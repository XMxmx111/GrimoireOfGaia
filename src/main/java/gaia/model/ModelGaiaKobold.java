package gaia.model;

import gaia.entity.monster.EntityGaiaKobold;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaKobold extends ModelGaia {
	private ModelRenderer head;
	private ModelRenderer headeyes;
	private ModelRenderer headaccessory;
	private ModelRenderer neck;
	private ModelRenderer bodytop;
	private ModelRenderer bodymiddle;
	private ModelRenderer bodymiddlebutton;
	private ModelRenderer bodybottom;
	private ModelRenderer rightchest;
	private ModelRenderer leftchest;
	private ModelRenderer rightarm;
	private ModelRenderer leftarm;
	private ModelRenderer rightleg;
	private ModelRenderer leftleg;
	private ModelRenderer backpack;
	private ModelRenderer waist;
	private ModelRenderer tail1;
	private ModelRenderer tail2;

	public ModelGaiaKobold() {
		textureWidth = 128;
		textureHeight = 64;

		head = new ModelRenderer(this, 0, 0);
		head.addBox(-3F, -6F, -3F, 6, 6, 6);
		head.setRotationPoint(0F, 1F, -1F);
		head.setTextureSize(64, 32);
		setRotation(head, 0F, 0F, 0F);
		headeyes = new ModelRenderer(this, 24, 0);
		headeyes.addBox(-3F, -6F, -3.1F, 6, 6, 0);
		headeyes.setRotationPoint(0F, 1F, -1F);
		headeyes.setTextureSize(64, 32);
		setRotation(headeyes, 0F, 0F, 0F);
		headaccessory = new ModelRenderer(this, 36, 0);
		headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		headaccessory.setRotationPoint(0F, 1F, -1F);
		headaccessory.setTextureSize(64, 32);
		setRotation(headaccessory, 0F, 0F, 0F);
		neck = new ModelRenderer(this, 0, 12);
		neck.addBox(-1F, -1F, -1F, 2, 2, 2);
		neck.setRotationPoint(0F, 1F, -1F);
		neck.setTextureSize(64, 32);
		setRotation(neck, 0F, 0F, 0F);
		bodytop = new ModelRenderer(this, 0, 16);
		bodytop.addBox(-2.5F, 0F, -1.5F, 5, 6, 3);
		bodytop.setRotationPoint(0F, 1F, -1F);
		bodytop.setTextureSize(64, 32);
		setRotation(bodytop, 0F, 0F, 0F);
		bodymiddle = new ModelRenderer(this, 0, 25);
		bodymiddle.addBox(-2F, 5.5F, -1.5F, 4, 3, 2);
		bodymiddle.setRotationPoint(0F, 1F, -1F);
		bodymiddle.setTextureSize(64, 32);
		setRotation(bodymiddle, 0.0872665F, 0F, 0F);
		bodymiddlebutton = new ModelRenderer(this, 0, 25);
		bodymiddlebutton.addBox(-0.5F, 6F, -1.6F, 1, 2, 0);
		bodymiddlebutton.setRotationPoint(0F, 1F, -1F);
		bodymiddlebutton.setTextureSize(64, 32);
		setRotation(bodymiddlebutton, 0.0872665F, 0F, 0F);
		bodybottom = new ModelRenderer(this, 0, 30);
		bodybottom.addBox(-3F, 8F, -2.5F, 6, 3, 3);
		bodybottom.setRotationPoint(0F, 1F, -1F);
		bodybottom.setTextureSize(64, 32);
		setRotation(bodybottom, 0.1745329F, 0F, 0F);
		rightchest = new ModelRenderer(this, 0, 36);
		rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		rightchest.setRotationPoint(-1.3F, 3F, -2.5F);
		rightchest.setTextureSize(64, 32);
		setRotation(rightchest, 0.8726646F, 0.1745329F, 0.0872665F);
		leftchest = new ModelRenderer(this, 0, 36);
		leftchest.mirror = true;
		leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		leftchest.setRotationPoint(1.3F, 3F, -2.5F);
		leftchest.setTextureSize(64, 32);
		setRotation(leftchest, 0.8726646F, -0.1745329F, -0.0872665F);
		rightarm = new ModelRenderer(this, 16, 12);
		rightarm.addBox(-2F, -1F, -1F, 2, 8, 2);
		rightarm.setRotationPoint(-2.5F, 2.5F, -1F);
		rightarm.setTextureSize(64, 32);
		setRotation(rightarm, 0F, 0F, 0.1745329F);
		leftarm = new ModelRenderer(this, 16, 12);
		leftarm.mirror = true;
		leftarm.addBox(0F, -1F, -1F, 2, 8, 2);
		leftarm.setRotationPoint(2.5F, 2.5F, -1F);
		leftarm.setTextureSize(64, 32);
		setRotation(leftarm, 0F, 0F, -0.1745329F);
		rightleg = new ModelRenderer(this, 98, 0);
		rightleg.addBox(-1.5F, -2F, -2F, 3, 8, 3);
		rightleg.setRotationPoint(-2.5F, 12F, 0F);
		rightleg.setTextureSize(64, 32);
		setRotation(rightleg, -0.3490659F, -0.0872665F, -0.0349066F);
		leftleg = new ModelRenderer(this, 98, 0);
		leftleg.addBox(-1.5F, -2F, -2F, 3, 8, 3);
		leftleg.setRotationPoint(2.5F, 12F, 0F);
		leftleg.setTextureSize(64, 32);
		setRotation(leftleg, -0.3490659F, 0.0872665F, 0.0349066F);
		ModelRenderer hair = new ModelRenderer(this, 36, 14);
		hair.addBox(-4F, -2.5F, 0F, 8, 4, 4);
		hair.setRotationPoint(0F, 1F, -1F);
		hair.setTextureSize(64, 32);
		setRotation(hair, 0F, 0F, 0F);
		ModelRenderer headnose = new ModelRenderer(this, 36, 22);
		headnose.addBox(-0.5F, -2.5F, -3.1F, 1, 1, 1);
		headnose.setRotationPoint(0F, 1F, -1F);
		headnose.setTextureSize(64, 32);
		setRotation(headnose, 0F, 0F, 0F);
		ModelRenderer headnoseshadow = new ModelRenderer(this, 36, 24);
		headnoseshadow.addBox(-0.5F, -4F, -3.2F, 1, 2, 1);
		headnoseshadow.setRotationPoint(0F, 1F, -1F);
		headnoseshadow.setTextureSize(64, 32);
		setRotation(headnoseshadow, 0F, 0F, 0F);
		ModelRenderer rightear = new ModelRenderer(this, 36, 27);
		rightear.addBox(-1.5F, -7F, -5.5F, 3, 6, 3);
		rightear.setRotationPoint(0F, 1F, -1F);
		rightear.setTextureSize(64, 32);
		setRotation(rightear, 0F, 0.7853982F, 0F);
		ModelRenderer leftear = new ModelRenderer(this, 36, 27);
		leftear.mirror = true;
		leftear.addBox(-1.5F, -7F, -5.5F, 3, 6, 3);
		leftear.setRotationPoint(0F, 1F, -1F);
		leftear.setTextureSize(64, 32);
		setRotation(leftear, 0F, -0.7853982F, 0F);
		ModelRenderer rightarmlower = new ModelRenderer(this, 64, 0);
		rightarmlower.addBox(-2.5F, 2F, -1.5F, 2, 8, 3);
		rightarmlower.setRotationPoint(-2.5F, 2.5F, -1F);
		rightarmlower.setTextureSize(64, 32);
		setRotation(rightarmlower, 0F, 0F, 0.1745329F);
		ModelRenderer leftarmlower = new ModelRenderer(this, 64, 0);
		leftarmlower.mirror = true;
		leftarmlower.addBox(0.5F, 2F, -1.5F, 2, 8, 3);
		leftarmlower.setRotationPoint(2.5F, 2.5F, -1F);
		leftarmlower.setTextureSize(64, 32);
		setRotation(leftarmlower, 0F, 0F, -0.1745329F);
		ModelRenderer righthand = new ModelRenderer(this, 64, 11);
		righthand.addBox(-2.5F, 8F, -2F, 2, 4, 4);
		righthand.setRotationPoint(-2.5F, 2.5F, -1F);
		righthand.setTextureSize(64, 32);
		setRotation(righthand, 0F, 0F, 0.0872665F);
		ModelRenderer lefthand = new ModelRenderer(this, 64, 11);
		lefthand.mirror = true;
		lefthand.addBox(0.5F, 8F, -2F, 2, 4, 4);
		lefthand.setRotationPoint(2.5F, 2.5F, -1F);
		lefthand.setTextureSize(64, 32);
		setRotation(lefthand, 0F, 0F, -0.0872665F);
		backpack = new ModelRenderer(this, 76, 0);
		backpack.addBox(-2.5F, 5F, 0.5F, 5, 4, 3);
		backpack.setRotationPoint(0F, 1F, -1F);
		backpack.setTextureSize(64, 32);
		setRotation(backpack, 0.1745329F, 0F, 0F);
		waist = new ModelRenderer(this, 76, 7);
		waist.addBox(-3.5F, 7.5F, -3F, 7, 4, 4);
		waist.setRotationPoint(0F, 1F, -1F);
		waist.setTextureSize(64, 32);
		setRotation(waist, 0.1745329F, 0F, 0F);
		tail1 = new ModelRenderer(this, 76, 15);
		tail1.addBox(-1F, 7F, -3.5F, 2, 5, 2);
		tail1.setRotationPoint(0F, 1F, -1F);
		tail1.setTextureSize(64, 32);
		setRotation(tail1, 0.5235988F, 0F, 0F);
		tail2 = new ModelRenderer(this, 76, 22);
		tail2.addBox(-1.5F, 11F, -5F, 3, 8, 3);
		tail2.setRotationPoint(0F, 1F, -1F);
		tail2.setTextureSize(64, 32);
		setRotation(tail2, 0.6108652F, 0F, 0F);
		ModelRenderer rightleglower = new ModelRenderer(this, 98, 11);
		rightleglower.addBox(-1.5F, 3.5F, 1F, 3, 8, 2);
		rightleglower.setRotationPoint(-2.5F, 12F, 0F);
		rightleglower.setTextureSize(64, 32);
		setRotation(rightleglower, -0.3490659F, -0.0872665F, -0.0349066F);
		ModelRenderer leftleglower = new ModelRenderer(this, 98, 11);
		leftleglower.addBox(-1.5F, 3.5F, 1F, 3, 8, 2);
		leftleglower.setRotationPoint(2.5F, 12F, 0F);
		leftleglower.setTextureSize(64, 32);
		setRotation(leftleglower, -0.3490659F, 0.0872665F, 0.0349066F);
		ModelRenderer rightfootlower = new ModelRenderer(this, 98, 21);
		rightfootlower.addBox(-1.5F, 10.5F, -5F, 3, 1, 3);
		rightfootlower.setRotationPoint(-2.5F, 12F, 0F);
		rightfootlower.setTextureSize(64, 32);
		setRotation(rightfootlower, 0.0872665F, -0.0872665F, -0.0349066F);
		ModelRenderer leftfootlower = new ModelRenderer(this, 98, 21);
		leftfootlower.addBox(-1.5F, 10.5F, -5F, 3, 1, 3);
		leftfootlower.setRotationPoint(2.5F, 12F, 0F);
		leftfootlower.setTextureSize(64, 32);
		setRotation(leftfootlower, 0.0872665F, 0.0872665F, 0.0349066F);

		convertToChild(head, hair);
		convertToChild(head, headnose);
		convertToChild(head, headnoseshadow);
		convertToChild(head, rightear);
		convertToChild(head, leftear);
		convertToChild(rightarm, rightarmlower);
		convertToChild(rightarm, righthand);
		convertToChild(leftarm, leftarmlower);
		convertToChild(leftarm, lefthand);
		convertToChild(rightleg, rightleglower);
		convertToChild(rightleg, rightfootlower);
		convertToChild(leftleg, leftleglower);
		convertToChild(leftleg, leftfootlower);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
		setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entityIn);
		head.render(scale);
		headaccessory.render(scale);
		neck.render(scale);
		bodytop.render(scale);
		bodymiddle.render(scale);
		bodymiddlebutton.render(scale);
		bodybottom.render(scale);
		rightchest.render(scale);
		leftchest.render(scale);
		rightarm.render(scale);
		leftarm.render(scale);
		rightleg.render(scale);
		leftleg.render(scale);
		backpack.render(scale);
		waist.render(scale);
		tail1.render(scale);
		tail2.render(scale);

		if (entityIn.ticksExisted % 60 == 0 && limbSwingAmount <= 0.1F) {
			headeyes.render(scale);
		}
	}

	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor,
			Entity entityIn) {
		// head
		head.rotateAngleY = netHeadYaw / 57.295776F;
		head.rotateAngleX = headPitch / 57.295776F;
		headeyes.rotateAngleY = head.rotateAngleY;
		headeyes.rotateAngleX = head.rotateAngleX;
		headaccessory.rotateAngleY = head.rotateAngleY;
		headaccessory.rotateAngleX = head.rotateAngleX;

		// arms
		rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.8F * limbSwingAmount * 0.5F;
		leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.8F * limbSwingAmount * 0.5F;

		rightarm.rotateAngleZ = 0.0F;
		leftarm.rotateAngleZ = 0.0F;

		ItemStack itemstack = ((EntityLivingBase) entityIn).getHeldItemMainhand();
		EntityGaiaKobold entity = (EntityGaiaKobold) entityIn;

		if (entity.isHoldingBow() && (itemstack.getItem() == Items.BOW)) {
			holdingBow(ageInTicks);
		} else if (swingProgress > -9990.0F) {
			holdingMelee();
		}

		rightarm.rotateAngleZ += (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.025F;
		leftarm.rotateAngleZ -= (MathHelper.cos(ageInTicks * 0.09F) * 0.025F + 0.025F) + 0.1745329F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.025F;

		// body
		tail1.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(15);
		tail2.rotateAngleY = MathHelper.cos(degToRad((float) entityIn.ticksExisted * 7)) * degToRad(20);

		// legs
		rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 0.5F * limbSwingAmount;
		leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 0.5F * limbSwingAmount;
		rightleg.rotateAngleX -= 0.3490659F;
		leftleg.rotateAngleX -= 0.3490659F;
	}

	private void holdingBow(float ageInTicks) {
		float f = MathHelper.sin(swingProgress * (float) Math.PI);
		float f1 = MathHelper.sin((1.0F - (1.0F - swingProgress) * (1.0F - swingProgress)) * (float) Math.PI);

		rightarm.rotateAngleZ = -0.3F;
		leftarm.rotateAngleZ = 0.3F;
		rightarm.rotateAngleY = -(0.1F - f * 0.6F);
		leftarm.rotateAngleY = 0.3F - f * 0.6F;
		rightarm.rotateAngleX = -((float) Math.PI / 2F);
		leftarm.rotateAngleX = -((float) Math.PI / 2F);
		rightarm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
		leftarm.rotateAngleX -= f * 1.2F - f1 * 0.4F;
		rightarm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		leftarm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
		rightarm.rotateAngleX += MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
		leftarm.rotateAngleX -= MathHelper.sin(ageInTicks * 0.067F) * 0.05F;
	}

	public void holdingMelee() {
		float f6;
		float f7;

		f6 = 1.0F - swingProgress;
		f6 *= f6;
		f6 *= f6;
		f6 = 1.0F - f6;
		f7 = MathHelper.sin(f6 * (float) Math.PI);
		float f8 = MathHelper.sin(swingProgress * (float) Math.PI) * -(head.rotateAngleX - 0.7F) * 0.75F;

		rightarm.rotateAngleX = (float) ((double) rightarm.rotateAngleX - ((double) f7 * 1.2D + (double) f8));
		rightarm.rotateAngleX += (bodytop.rotateAngleY * 2.0F);
		rightarm.rotateAngleZ = (MathHelper.sin(swingProgress * (float) Math.PI) * -0.4F);
	}

	public ModelRenderer getRightArm() {
		return rightarm;
	}

	public ModelRenderer getLeftArm() {
		return leftarm;
	}
}
