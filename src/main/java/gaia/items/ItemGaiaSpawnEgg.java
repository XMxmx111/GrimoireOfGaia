package gaia.items;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gaia.BlockStateHelper;
import gaia.Gaia;
import gaia.entity.EntityGaiaEggInfo;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFence;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.MobSpawnerBaseLogic;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMobSpawner;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public final class ItemGaiaSpawnEgg extends Item {
	//@SideOnly(Side.CLIENT)
	//private IIcon baseIcon;
	//@SideOnly(Side.CLIENT)
	//private IIcon overlayIcon;
	private static Map<Integer, String> idToName = new HashMap();
	private static Map<Integer, EntityGaiaEggInfo> idToEgg = new HashMap();
	private static Map<Integer, Class<? extends EntityLiving>> idToClass = new HashMap();
	private static Map<Class<? extends EntityLiving>, Integer> classToID = new HashMap();

	public static void registerEntityEgg(
			Class<? extends EntityLiving> entityClass, int entityID,int primaryColor, int secondaryColor) {

		Integer id = Integer.valueOf(entityID);
		idToClass.put(id, entityClass);
		classToID.put(entityClass, id);
		idToEgg.put(id, new EntityGaiaEggInfo(entityID, primaryColor,
				secondaryColor));
		idToName.put(id,
				(String) EntityList.classToStringMapping.get(entityClass));
	}

	public static Entity spawnCreature(World world, int entityID, double posX,
									   double posY, double posZ) {
		Integer id = Integer.valueOf(entityID);
		if (!idToEgg.containsKey(id)) {
			return null;
		} else {
			EntityLiving entity = null;

			try {
				Class exception = (Class) idToClass.get(id);
				if (exception != null) {
					entity = (EntityLiving) exception.getConstructor(
							new Class[] { World.class }).newInstance(
							new Object[] { world });
				}
			} catch (Exception var11) {
				var11.printStackTrace();
			}

			if (entity == null) {
				//Logger.getlo.logWarning("Skipping Entity with id " +
				//entityID);
			} else {
				entity.setLocationAndAngles(posX, posY, posZ, MathHelper
								.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F),
						0.0F);
				entity.rotationYawHead = entity.rotationYaw;
				entity.renderYawOffset = entity.rotationYaw;
				//entity.onSpawnWithEgg((IEntityLivingData) null);
				entity.onInitialSpawn(world.getDifficultyForLocation(new BlockPos(entity)), (IEntityLivingData)null);
				world.spawnEntityInWorld(entity);
				entity.playLivingSound();
			}

			return entity;
		}
	}

	public static int entityID(Class<? extends EntityLiving> entityClass) {
		Integer result = (Integer) classToID.get(entityClass);
		return null == result ? -1 : result.intValue();
	}

	public ItemGaiaSpawnEgg() {
		this.setHasSubtypes(true);
		this.setCreativeTab(Gaia.tabGaia);
		this.setUnlocalizedName("GrimoireOfGaia.MonsterPlacer");
	}

	public String getItemStackDisplayName(ItemStack istack) {
		String ownName = ("" + StatCollector.translateToLocal(this
				.getUnlocalizedName() + ".name")).trim();
		String mobName = (String) idToName.get(Integer.valueOf(istack
				.getItemDamage()));
		if (mobName != null) {
			ownName = ownName
					+ " "
					+ StatCollector.translateToLocal("entity." + mobName
					+ ".name");
		}

		return ownName;
	}

	@SideOnly(Side.CLIENT)
	public int getColorFromItemStack(ItemStack istack, int renderPass) {
		EntityGaiaEggInfo EntityGaiaEggInfo = (EntityGaiaEggInfo) idToEgg
				.get(Integer.valueOf(istack.getItemDamage()));
		return EntityGaiaEggInfo != null ? (renderPass == 0 ? EntityGaiaEggInfo.primaryColor
				: EntityGaiaEggInfo.secondaryColor)
				: 16777215;
	}

	/*public boolean onItemUse(ItemStack istack, EntityPlayer player,
			World world, int posX, int posY, int posZ, int side, float par8,
			float par9, float par10) {
	}*/
	/*
	public boolean onItemUse(ItemStack istack, EntityPlayer player, World world, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	{	
		
		if (world.isRemote) {
			return true;
		} else {
			Block b = world.getBlock(posX, posY, posZ);
			posX += Facing.offsetsXForSide[side];
			posY += Facing.offsetsYForSide[side];
			posZ += Facing.offsetsZForSide[side];
			double verticalOffset = 0.0D;
			if (side == 1 && b != Blocks.air && b.getRenderType() == 11) {
				verticalOffset = 0.5D;
			}

			Entity entity = spawnCreature(world, istack.getItemDamage(),
					(double) posX + 0.5D, (double) posY + verticalOffset,
					(double) posZ + 0.5D);
			if (entity != null) {
				if (entity instanceof EntityLiving && istack.hasDisplayName()) {
					((EntityLiving) entity).setCustomNameTag(istack
							.getDisplayName());
				}

				if (!player.capabilities.isCreativeMode) {
					--istack.stackSize;
				}
			}

			return true;
		}
	}
	*/
	public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
	{
		if (worldIn.isRemote)
		{
			return true;
		}
		else if (!playerIn.canPlayerEdit(pos.offset(side), side, stack))
		{
			return false;
		}
		else
		{
			IBlockState iblockstate = worldIn.getBlockState(pos);

			if (iblockstate.getBlock() == Blocks.mob_spawner)
			{
				TileEntity tileentity = worldIn.getTileEntity(pos);

				if (tileentity instanceof TileEntityMobSpawner)
				{
					MobSpawnerBaseLogic mobspawnerbaselogic = ((TileEntityMobSpawner)tileentity).getSpawnerBaseLogic();
					mobspawnerbaselogic.setEntityName(ItemMonsterPlacer.getEntityName(stack));
					tileentity.markDirty();
					worldIn.markBlockForUpdate(pos);

					if (!playerIn.capabilities.isCreativeMode)
					{
						--stack.stackSize;
					}

					return true;
				}
			}

			pos = pos.offset(side);
			double d0 = 0.0D;

			if (side == EnumFacing.UP && iblockstate.getBlock() instanceof BlockFence) //Forge: Fix Vanilla bug comparing state instead of block
			{
				d0 = 0.5D;
			}

			//Entity entity = spawnCreature(worldIn, ItemMonsterPlacer.getEntityName(stack), (double)pos.getX() + 0.5D, (double)pos.getY() + d0, (double)pos.getZ() + 0.5D);
			Entity entity = spawnCreature(worldIn, stack.getItemDamage(),
					(double)pos.getX() + 0.5D, (double)pos.getY() + d0, (double)pos.getZ() + 0.5D);
			if (entity != null)
			{
				if (entity instanceof EntityLivingBase && stack.hasDisplayName())
				{
					entity.setCustomNameTag(stack.getDisplayName());
				}

				if (!playerIn.capabilities.isCreativeMode)
				{
					--stack.stackSize;
				}
			}

			return true;
		}
	}

	public ItemStack onItemRightClick(ItemStack istack, World world,
									  EntityPlayer player) {
		if (world.isRemote) {
			return istack;
		} else {
			MovingObjectPosition mop = this
					.getMovingObjectPositionFromPlayer(world, player, true);
			if (mop == null) {
				return istack;
			} else {
				if (mop.typeOfHit == MovingObjectType.BLOCK) {
					//int posX = movingobjectposition.blockX;
					//int posY = movingobjectposition.blockY;
					//int posZ = movingobjectposition.blockZ;
					int posX = mop.getBlockPos().getX();
					int posY = mop.getBlockPos().getX();
					int posZ = mop.getBlockPos().getX();
					BlockPos pos = mop.getBlockPos();
					if (!world.canMineBlockBody(player, pos)
							|| !player.canPlayerEdit(pos,
							mop.sideHit, istack)) {
						return istack;
					}

					//Block b = world.getBlock(posX, posY, posZ);
					Block b = BlockStateHelper.getBlockfromState(world, pos);

					if (b.getMaterial() == Material.water) {
						Entity entity = spawnCreature(world,
								istack.getItemDamage(), (double) posX,
								(double) posY, (double) posZ);
						if (entity != null) {
							if (entity instanceof EntityLiving
									&& istack.hasDisplayName()) {
								((EntityLiving) entity).setCustomNameTag(istack
										.getDisplayName());
							}

							if (!player.capabilities.isCreativeMode) {
								--istack.stackSize;
							}
						}
					}
				}

				return istack;
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public boolean requiresMultipleRenderPasses() {
		return true;
	}

	/*@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamageForRenderPass(int damage, int renderPass) {
		return renderPass > 0 ? this.overlayIcon : this.baseIcon;
	}*/

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item p_150895_1_, CreativeTabs p_150895_2_,
							List p_150895_3_) {
		Iterator it = idToEgg.values().iterator();

		while (it.hasNext()) {
			EntityGaiaEggInfo info = (EntityGaiaEggInfo) it.next();
			p_150895_3_.add(new ItemStack(p_150895_1_, 1, info.spawnedID));
		}
	}

	/*@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegistry) {
		this.baseIcon = iconRegistry.registerIcon("spawn_egg");
		this.overlayIcon = iconRegistry.registerIcon("spawn_egg_overlay");
	}*/
}
