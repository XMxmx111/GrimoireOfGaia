package gaia.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Particles;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ItemPickupHeart extends ItemBase {
    public ItemPickupHeart(Item.Properties builder) {
        super(builder.maxStackSize(1));
    }

    @Override
    public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
        super.inventoryTick(stack, worldIn, entityIn, itemSlot, isSelected);

        if (!(entityIn instanceof EntityPlayer))
            return;

        EntityPlayer player = (EntityPlayer) entityIn;
        BlockPos pos = new BlockPos(player.posX, player.posY + player.getYOffset(), player.posZ);

        if (!player.abilities.isCreativeMode) {
            player.heal(2);
            stack.shrink(1);

            for (int i1 = 0; i1 < 15; ++i1) {
                double d0 = random.nextGaussian() * 0.02D;
                double d1 = random.nextGaussian() * 0.02D;
                double d2 = random.nextGaussian() * 0.02D;
                worldIn.spawnParticle(Particles.HEART, (double) ((float) pos.getX() + random.nextFloat()), ((double) pos.getY() + 1.0f) + (double) random.nextFloat() * 2.0f, (double) ((float) pos.getZ() + random.nextFloat()), d0, d1, d2);
            }
        }
    }
}
