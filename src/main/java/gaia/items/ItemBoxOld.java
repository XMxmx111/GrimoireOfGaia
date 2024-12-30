package gaia.items;

import java.util.List;
import java.util.Random;

import gaia.Gaia;
import gaia.init.GaiaItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBoxOld extends Item {
	String texture;

	public ItemBoxOld(String texture) {

		this.texture = texture;
		this.maxStackSize = 1;
		this.setUnlocalizedName("GrimoireOfGaia.BoxOld");
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.RARE;
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(StatCollector.translateToLocal("text.GrimoireOfGaia.RightClickUse.desc"));
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		world.playSoundAtEntity(entityplayer, "grimoireofgaia:box_open2", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);

		Random random = new Random();
		int i = random.nextInt(8);
		switch(i) {
			case 0:
				return new ItemStack(GaiaItem.Shard, 1, 4);
			case 1:
				return new ItemStack(GaiaItem.Shard, 1, 4);
			case 2:
				return new ItemStack(GaiaItem.MiscGigaGear);
			case 3:
				return new ItemStack(GaiaItem.SpawnCard);
			case 4:
				return new ItemStack(Items.saddle);
			case 5:
				return new ItemStack(Items.name_tag);
			case 6:
				return new ItemStack(GaiaItem.Shard, 1, 4);
			case 7:
				return new ItemStack(GaiaItem.Shard, 1, 4);
			default:
				return itemstack;
		}
	}
}
