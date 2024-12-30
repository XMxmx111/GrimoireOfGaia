package gaia.items;

import java.util.List;

import gaia.Gaia;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBagBook extends Item {
	String texture;

	public ItemBagBook(String texture) {

		this.texture = texture;
		this.maxStackSize = 1;
		this.setUnlocalizedName("GrimoireOfGaia.BagBook");
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
		world.playSoundAtEntity(entityplayer, "grimoireofgaia:bag_open", 0.5F, world.rand.nextFloat() * 0.1F + 0.9F);

		Enchantment enchantment = Enchantment.enchantmentsBookList[itemRand.nextInt(Enchantment.enchantmentsBookList.length)];
		int k = MathHelper.getRandomIntegerInRange(itemRand, enchantment.getMinLevel(), enchantment.getMaxLevel());
		ItemStack book = Items.enchanted_book.getEnchantedItemStack(new EnchantmentData(enchantment, k));
		return book;
	}
}
