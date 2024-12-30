package gaia.entity.monster;

import gaia.BlockStateHelper;
import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobBase;
import gaia.entity.ai.EntityAIGaiaAttackOnCollide;
import gaia.init.GaiaItem;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityGaiaCobblestoneGolem extends EntityMobBase {
	private int attackTimer;
	private int holdRoseTick;

	public EntityGaiaCobblestoneGolem(World par1World) {
		super(par1World);
		this.setSize(1.4F, 2.2F);
		this.experienceValue = EntityAttributes.experienceValue2;
		this.stepHeight = 1.0F;
		this.isImmuneToFire = true;
		//this.getNavigator().setAvoidsWater(true);
		((PathNavigateGround)this.getNavigator()).setAvoidsWater(true);
		this.tasks.addTask(1, new EntityAIGaiaAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(2, new EntityAIWander(this, 0.5D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(4, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)EntityAttributes.maxHealth2);
		//		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)EntityAttributes.moveSpeed2);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)EntityAttributes.attackDamage2);
	}

	public int getTotalArmorValue() {
		return EntityAttributes.rateArmor2;
	}

	public boolean attackEntityAsMob(Entity par1Entity) {
		this.attackTimer = 10;
		this.worldObj.setEntityState(this, (byte)4);
		boolean var2 = par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), (float)(7 + this.rand.nextInt(15)));
		if(var2) {
			par1Entity.motionY += 0.6000000059604645D;
		}

		this.playSound("mob.irongolem.throw", 1.0F, 1.0F);
		return var2;
	}

	@SideOnly(Side.CLIENT)
	public void handleStatusUpdate(byte par1) {
		if(par1 == 4) {
			this.attackTimer = 10;
			this.playSound("mob.irongolem.throw", 1.0F, 1.0F);
		} else if(par1 == 11) {
			this.holdRoseTick = 400;
		} else {
			super.handleStatusUpdate(par1);
		}

	}

	@SideOnly(Side.CLIENT)
	public int getAttackTimer() {
		return this.attackTimer;
	}

	public boolean isAIEnabled() {
		return true;
	}

	public boolean attackEntityFrom(DamageSource par1DamageSource, int par2) {
		Entity entity = par1DamageSource.getEntity();
		if (entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) entity;
			ItemStack itemstack = player.getCurrentEquippedItem();
			if (itemstack != null) {
				Item item = itemstack.getItem();
				if (item != null) {
					if (item == Items.wooden_pickaxe) {
						par2 = 6;
					}

					if (item == Items.stone_pickaxe) {
						par2 = 7;
					}

					if (item == Items.iron_pickaxe) {
						par2 = 8;
					}

					if (item == Items.golden_pickaxe) {
						par2 = 6;
					}

					if (item == Items.diamond_pickaxe) {
						par2 = 9;
					}
				}
			}

		}

		return super.attackEntityFrom(par1DamageSource, (float) par2);
	}

	public void onLivingUpdate() {
		super.onLivingUpdate();
		if(this.attackTimer > 0) {
			--this.attackTimer;
		}

		if(this.holdRoseTick > 0) {
			--this.holdRoseTick;
		}

		if(this.motionX * this.motionX + this.motionZ * this.motionZ > 2.500000277905201E-7D && this.rand.nextInt(5) == 0) {
			int var1 = MathHelper.floor_double(this.posX);
			int var2 = MathHelper.floor_double(this.posY - 0.20000000298023224D);// - (double)this.yOffset);
			int var3 = MathHelper.floor_double(this.posZ);
			World world = this.worldObj;
			BlockPos pos = new BlockPos(var1, var2, var3);
			int crackid = BlockStateHelper.getblock_ID(world, pos);
			int crackmeta = BlockStateHelper.getMetafromState(world, pos);

			//Block b = this.worldObj.getBlock(var1, var2, var3);
			Block b = BlockStateHelper.getBlockfromState(this.worldObj, pos);
			if(b != Blocks.air) {
				//this.worldObj.spawnParticle("blockcrack_" + Block.getIdFromBlock(b) + "_" + this.worldObj.getBlockMetadata(var1, var2, var3), this.posX + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, this.getEntityBoundingBox().minY + 0.1D, this.posZ + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, 4.0D * ((double)this.rand.nextFloat() - 0.5D), 0.5D, ((double)this.rand.nextFloat() - 0.5D) * 4.0D);
				this.worldObj.spawnParticle(EnumParticleTypes.BLOCK_CRACK,
						this.posX + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, this.getEntityBoundingBox().minY + 0.1D,
						this.posZ + ((double)this.rand.nextFloat() - 0.5D) * (double)this.width, 4.0D * ((double)this.rand.nextFloat() - 0.5D), 0.5D,
						((double)this.rand.nextFloat() - 0.5D) * 4.0D,
						crackid,crackmeta);
			}}

	}

	protected String getLivingSound() {
		//TODO Living sound
		return null;
		//return "none";
	}

	protected String getHurtSound() {
		return "dig.stone";
	}

	protected String getDeathSound() {
		return "mob.irongolem.death";
	}

	protected void playStepSound(int par1, int par2, int par3, int par4) {
		this.worldObj.playSoundAtEntity(this, "mob.irongolem.walk", 1.0F, 1.0F);
	}

	protected void dropFewItems(boolean par1, int par2) {
		int var3 = this.rand.nextInt(3 + par2);

		for(int var4 = 0; var4 < var3; ++var4) {
			this.entityDropItem(new ItemStack(GaiaItem.Shard, 1, 0), 0.0F);
		}

		if(par1 && (this.rand.nextInt(2) == 0 || this.rand.nextInt(1 + par2) > 0)) {
			this.entityDropItem(new ItemStack(GaiaItem.Shard, 1, 1), 0.0F);
		}

		if(par1 && (this.rand.nextInt(4) == 0 || this.rand.nextInt(1 + par2) > 0)) {
			this.dropItem(GaiaItem.Fragment, 1);
		}
	}

	protected void dropRareDrop(int par1) {
		switch(this.rand.nextInt(3)) {
			case 0:
				this.dropItem(GaiaItem.BoxGold,1);
				break;
			case 1:
				this.dropItem(GaiaItem.BagBook,1);
				break;
			case 2:
				this.dropItem(GaiaItem.BookMetal,1);
		}
	}

	public boolean isPotionApplicable(PotionEffect par1PotionEffect) {
		return par1PotionEffect.getPotionID() == Potion.poison.id?false:super.isPotionApplicable(par1PotionEffect);
	}

	public void knockBack(Entity par1Entity, float par2, double par3, double par5) {
		if(this.rand.nextDouble() >= this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).getAttributeValue()) {
			this.isAirBorne = true;
			float f1 = MathHelper.sqrt_double(par3 * par3 + par5 * par5);
			float f2 = 0.4F;
			this.motionX /= 2.0D;
			this.motionY /= 2.0D;
			this.motionZ /= 2.0D;
			this.motionX -= par3 / (double)f1 * (double)f2;
			this.motionY += (double)f2;
			this.motionZ -= par5 / (double)f1 * (double)f2;
			if(this.motionY > EntityAttributes.knockback2) {
				this.motionY = EntityAttributes.knockback2;
			}
		}
	}

	public boolean getCanSpawnHere() {
		return this.posY > 60.0D && super.getCanSpawnHere();
	}
}
