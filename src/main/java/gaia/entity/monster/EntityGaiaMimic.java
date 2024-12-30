package gaia.entity.monster;

import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobBase;
import gaia.entity.ai.EntityAIGaiaAttackOnCollide;
import gaia.init.GaiaItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaMimic extends EntityMobBase {
	private static final Item[] chestDrops = new Item[] {
			Items.gunpowder, Items.gunpowder,
			Items.ender_pearl, Items.ender_pearl,
			Items.slime_ball, Items.slime_ball,
			Items.string,
			Items.spider_eye,
			Items.bone,
			Items.rotten_flesh };

	public EntityGaiaMimic(World par1World) {
		super(par1World);
		this.experienceValue = EntityAttributes.experienceValue1;
		this.stepHeight = 6.0F;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIGaiaAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false));
		this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)EntityAttributes.maxHealth1);
		//		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
		//		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setBaseValue((double)GaiaEntityAttributes.knockback1);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)EntityAttributes.moveSpeed1);
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue((double)EntityAttributes.attackDamage1);
	}

	public int getTotalArmorValue() {
		return EntityAttributes.rateArmor1;
	}

	public boolean attackEntityAsMob(Entity par1Entity) {
		if(super.attackEntityAsMob(par1Entity)) {
			if(par1Entity instanceof EntityLivingBase) {
				byte byte0 = 0;

				if (this.worldObj.getDifficulty() == EnumDifficulty.NORMAL){
					byte0 = 7;
				} else if (this.worldObj.getDifficulty() == EnumDifficulty.HARD) {
					byte0 = 15;
				}

				if(byte0 > 0) {
					((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.hunger.id, byte0 * 60, 0));
					((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.poison.id, byte0 * 30, 0));
				}
			}

			return true;
		} else {
			return false;
		}
	}

	public boolean isAIEnabled() {
		return true;
	}

	public void onLivingUpdate() {
		if(!this.onGround && this.motionY < 0.0D) {
			this.motionY *= 0.8D;
		}

		super.onLivingUpdate();
	}

	protected String getLivingSound() {
		return "random.chestopen";
	}

	protected String getHurtSound() {
		return "step.wood";
	}

	protected String getDeathSound() {
		return "random.chestopen";
	}

	protected void dropFewItems(boolean par1, int par2) {
		for(int var4 = 0; var4 < 1; ++var4) {
			Item var6 = chestDrops[this.rand.nextInt(chestDrops.length)];

			for(int var7 = 0; var7 < 1; ++var7) {
				this.dropItem(var6, 1);
			}
		}

		if(par1 && (this.rand.nextInt(10) == 0 || this.rand.nextInt(1 + par2) > 0)) {
			this.dropItem(GaiaItem.MiscFurnaceFuel,1);
		}

		if(par1 && (this.rand.nextInt(2) == 0 || this.rand.nextInt(1 + par2) > 0)) {
			this.entityDropItem(new ItemStack(GaiaItem.Shard, 1, 0), 0.0F);
		}
	}

	protected void dropRareDrop(int par1) {
		switch(this.rand.nextInt(4)) {
			case 0:
				this.dropItem(GaiaItem.BagOre,1);
				break;
			case 1:
				this.dropItem(GaiaItem.BagRecord,1);
				break;
			case 2:
				this.dropItem(GaiaItem.SpawnCardTrader,1);
				break;
			case 3:
				this.experienceValue = EntityAttributes.experienceValue1 * 5;
		}
	}

	protected void fall(float f) {}

	//Is no knockback intended - never noticed it :^)
	public void knockBack(Entity par1Entity, float par2, double par3, double par5) {}

	public boolean getCanSpawnHere() {
		return this.posY < 32.0D && super.getCanSpawnHere();
	}
}
