package gaia.items;

import java.util.List;
import java.util.Random;

import gaia.Gaia;
import gaia.init.GaiaItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemSpawnCard extends Item {
	String texture;

	public ItemSpawnCard(String texture) {

		this.texture = texture;
		this.maxStackSize = 1;
		this.setUnlocalizedName("GrimoireOfGaia.SpawnCard");
		this.setCreativeTab(Gaia.tabGaia);
	}

	@SideOnly(Side.CLIENT)
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.EPIC;
	}

	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add(StatCollector.translateToLocal("text.GrimoireOfGaia.RightClickUse.desc"));
	}

	public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer) {
		world.playSoundAtEntity(entityplayer, "grimoireofgaia:box_open2", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);

		Random random = new Random();
		int i = random.nextInt(5);
		switch(i) {
			case 0:
				return new ItemStack(GaiaItem.SpawnCardCreeperGirl);
			case 1:
				return new ItemStack(GaiaItem.SpawnCardEnderGirl);
			case 2:
				return new ItemStack(GaiaItem.SpawnCardHolstaurus);
			case 3:
				return new ItemStack(GaiaItem.SpawnCardSlimeGirl);
			case 4:
				return new ItemStack(GaiaItem.SpawnCardTrader);
			default:
				return itemstack;
		}
	}
}
