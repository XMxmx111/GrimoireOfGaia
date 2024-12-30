package gaia.block;

import gaia.Gaia;
import gaia.tileentity.TileEntityDollCreeperGirl;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockDollCreeperGirl extends BlockContainer {

	public BlockDollCreeperGirl(Material par2Material) {
		super(par2Material);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.25F, 1.0F);
		this.setLightOpacity(0);
		this.setHardness(3.0F);
		this.setResistance(6.0F);
		this.setUnlocalizedName("GrimoireOfGaia.DollCreeperGirl");
		this.setCreativeTab(Gaia.tabGaia);
	}

	public int getRenderType() {
		return -1;
	}

	public TileEntity createNewTileEntity(World par1World, int i) {
		return new TileEntityDollCreeperGirl();
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean isFullCube()
	{
		return false;
	}

	public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase entity, ItemStack stack)
	{

		if(entity != null) {
			TileEntityDollCreeperGirl tile = (TileEntityDollCreeperGirl)world.getTileEntity(pos);
			tile.direction = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
		}
	}

	public Block setBlockTextureName(String string) {
		return null;
	}
}
