package gaia.entity.monster;

import gaia.entity.EntityAttributes;
import gaia.entity.EntityMobDay;
import gaia.entity.ai.EntityAIGaiaAttackOnCollide;
import gaia.init.GaiaItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityGaiaCyclops extends EntityMobDay {

	public EntityGaiaCyclops(World par1World) {
		super(par1World);
		this.experienceValue = EntityAttributes.experienceValue1;
		this.stepHeight = 1.0F;
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new EntityAIGaiaAttackOnCollide(this, 1.0D, true));
		this.tasks.addTask(2, new EntityAIWander(this, 1.0D));
		this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(3, new EntityAILookIdle(this));
		this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, true));
	}

	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue((double)EntityAttributes.maxHealth1);
		//		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(40.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue((double)EntityAttributes.moveSpeed3);
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
					((EntityLivingBase)par1Entity).addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, byte0 * 30, 0));
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

	/*
	public void setTarget(Entity par1Entity) {
		StackTraceElement[] elements = Thread.currentThread().getStackTrace();
		if(elements.length > 2) {
			StackTraceElement previousMethod = elements[2];
			if(previousMethod.getClassName().startsWith("org.millenaire.") && previousMethod.getMethodName().equals("triggerMobAttacks")) {
				return;
			}
		}
		
		super.setTarget(par1Entity);
	}
	*/

	public void onLivingUpdate() {
		super.onLivingUpdate();
	}

	protected String getLivingSound() {
		return "grimoireofgaia:assist_say";
	}

	protected String getHurtSound() {
		return "grimoireofgaia:assist_hurt";
	}

	protected String getDeathSound() {
		return "grimoireofgaia:assist_death";
	}

	protected void dropFewItems(boolean par1, int par2) {
		int var3 = this.rand.nextInt(3 + par2);

		for(int var4 = 0; var4 < var3; ++var4) {
			this.dropItem(Items.string,1);
		}

		if(par1 && (this.rand.nextInt(10) == 0 || this.rand.nextInt(1 + par2) > 0)) {
			this.dropItem(GaiaItem.FoodBerryIce,1);
		}

		if(par1 && (this.rand.nextInt(2) == 0 || this.rand.nextInt(1 + par2) > 0)) {
			this.entityDropItem(new ItemStack(GaiaItem.Shard, 1, 0), 0.0F);
		}
	}

	protected void dropRareDrop(int par1) {
		switch(this.rand.nextInt(2)) {
			case 0:
				this.dropItem(GaiaItem.BoxIron,1);
				break;
			case 1:
				this.experienceValue = EntityAttributes.experienceValue1 * 5;
		}
	}
	/*
	public IEntityLivingData onSpawnWithEgg(IEntityLivingData par1IEntityLivingData) {
		par1IEntityLivingData = super.onSpawnWithEgg(par1IEntityLivingData);
		this.setCurrentItemOrArmor(0, new ItemStack(Items.stone_sword));
		this.enchantEquipment();
		return par1IEntityLivingData;
	}
	*/
	public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata)
	{
		livingdata = super.onInitialSpawn(difficulty, livingdata);
		this.setCurrentItemOrArmor(0, new ItemStack(Items.stone_sword));
		this.setEnchantmentBasedOnDifficulty(difficulty);
		return livingdata;

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
			if(this.motionY > EntityAttributes.knockback1) {
				this.motionY = EntityAttributes.knockback1;
			}
		}
	}

	public boolean getCanSpawnHere() {
		return this.posY > 60.0D && super.getCanSpawnHere();
	}
}
