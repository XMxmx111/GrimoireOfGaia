package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaSiren extends ModelBase {
	ModelRenderer bodytop;
	ModelRenderer bodymiddle;
	ModelRenderer bodybottom;
	ModelRenderer bodymiddlebutton;
	ModelRenderer head;
	ModelRenderer headaccessory;
	ModelRenderer finright;
	ModelRenderer finleft;
	ModelRenderer hair1;
	ModelRenderer hair2;
	ModelRenderer pauldron;
	ModelRenderer rightchest;
	ModelRenderer leftchest;
	public static ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer tail1;
	ModelRenderer tail2;
	ModelRenderer tail3;
	ModelRenderer tail4;
	ModelRenderer tail5;
	ModelRenderer tail6;
	ModelRenderer tail7;
	ModelRenderer tail8;

	public ModelGaiaSiren() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.bodytop = new ModelRenderer(this, 0, 12);
		this.bodytop.addBox(-2.5F, 0F, -1.5F, 5, 5, 3);
		this.bodytop.setRotationPoint(0F, 1F, 0F);
		this.bodytop.setTextureSize(128, 64);
		this.bodytop.mirror = true;
		this.setRotation(bodytop, -0.0872665F, 0F, 0F);
		this.bodymiddle = new ModelRenderer(this, 0, 20);
		this.bodymiddle.addBox(-2F, 4.5F, -1.5F, 4, 3, 2);
		this.bodymiddle.setRotationPoint(0F, 1F, 0F);
		this.bodymiddle.setTextureSize(128, 64);
		this.bodymiddle.mirror = true;
		this.setRotation(bodymiddle, 0F, 0F, 0F);
		this.bodybottom = new ModelRenderer(this, 0, 25);
		this.bodybottom.addBox(-2.5F, 7F, -2F, 5, 3, 3);
		this.bodybottom.setRotationPoint(0F, 1F, 0F);
		this.bodybottom.setTextureSize(128, 64);
		this.bodybottom.mirror = true;
		this.setRotation(bodybottom, 0F, 0F, 0F);
		this.bodymiddlebutton = new ModelRenderer(this, 0, 20);
		this.bodymiddlebutton.addBox(-0.5F, 5F, -1.6F, 1, 2, 0);
		this.bodymiddlebutton.setRotationPoint(0F, 1F, 0F);
		this.bodymiddlebutton.setTextureSize(128, 64);
		this.bodymiddlebutton.mirror = true;
		this.setRotation(bodymiddlebutton, 0F, 0F, 0F);
		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3F, -6F, -3F, 6, 6, 6);
		this.head.setRotationPoint(0F, 1F, 0F);
		this.head.setTextureSize(128, 64);
		this.head.mirror = true;
		this.setRotation(head, 0F, 0F, 0F);
		this.headaccessory = new ModelRenderer(this, 38, 0);
		this.headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		this.headaccessory.setRotationPoint(0F, 1F, 0F);
		this.headaccessory.setTextureSize(128, 64);
		this.headaccessory.mirror = true;
		this.setRotation(headaccessory, 0F, 0F, 0F);
		this.finright = new ModelRenderer(this, 38, 34);
		this.finright.addBox(-4F, -6F, -1F, 0, 5, 3);
		this.finright.setRotationPoint(0F, 1F, 0F);
		this.finright.setTextureSize(128, 64);
		this.finright.mirror = true;
		this.setRotation(finright, 0F, -0.5235988F, 0F);
		this.finleft = new ModelRenderer(this, 38, 34);
		this.finleft.addBox(4F, -6F, -1F, 0, 5, 3);
		this.finleft.setRotationPoint(0F, 1F, 0F);
		this.finleft.setTextureSize(128, 64);
		this.finleft.mirror = true;
		this.setRotation(finleft, 0F, 0.5235988F, 0F);
		this.hair1 = new ModelRenderer(this, 38, 14);
		this.hair1.addBox(-4F, -6F, 1F, 8, 8, 3);
		this.hair1.setRotationPoint(0F, 1F, 0F);
		this.hair1.setTextureSize(128, 64);
		this.hair1.mirror = true;
		this.setRotation(hair1, 0F, 0F, 0F);
		this.hair2 = new ModelRenderer(this, 38, 25);
		this.hair2.addBox(-4.5F, -1F, 1.5F, 9, 9, 3);
		this.hair2.setRotationPoint(0F, 1F, 0F);
		this.hair2.setTextureSize(128, 64);
		this.hair2.mirror = true;
		this.setRotation(hair2, 0F, 0F, 0F);
		this.pauldron = new ModelRenderer(this, 38, 42);
		this.pauldron.addBox(-4.5F, 0F, -2F, 9, 4, 4);
		this.pauldron.setRotationPoint(0F, 1F, 0F);
		this.pauldron.setTextureSize(128, 64);
		this.pauldron.mirror = true;
		this.setRotation(pauldron, 0F, 0F, 0F);
		this.rightchest = new ModelRenderer(this, 0, 31);
		this.rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.rightchest.setRotationPoint(-1.3F, 3F, -1.5F);
		this.rightchest.setTextureSize(128, 64);
		this.rightchest.mirror = true;
		this.setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		this.leftchest = new ModelRenderer(this, 8, 31);
		this.leftchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.leftchest.setRotationPoint(1.3F, 3F, -1.5F);
		this.leftchest.setTextureSize(128, 64);
		this.leftchest.mirror = true;
		this.setRotation(leftchest, 0.7853982F, -0.1745329F, -0.0872665F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2F, -1F, -1F, 2, 10, 2);
		this.rightarm.setRotationPoint(-2.5F, 2.5F, 0F);
		this.rightarm.setTextureSize(128, 64);
		this.rightarm.mirror = true;
		this.setRotation(rightarm, 0F, 0F, 0.2617994F);
		this.leftarm = new ModelRenderer(this, 16, 24);
		this.leftarm.addBox(0F, -1F, -1F, 2, 10, 2);
		this.leftarm.setRotationPoint(2.5F, 2.5F, 0F);
		this.leftarm.setTextureSize(128, 64);
		this.leftarm.mirror = true;
		this.setRotation(leftarm, 0F, 0F, -0.2617994F);
		this.tail1 = new ModelRenderer(this, 66, 0);
		this.tail1.addBox(-3F, -1F, -2.5F, 6, 3, 4);
		this.tail1.setRotationPoint(0F, 11F, 0F);
		this.tail1.setTextureSize(128, 64);
		this.tail1.mirror = true;
		this.setRotation(tail1, 0F, 0F, 0F);
		this.tail2 = new ModelRenderer(this, 66, 7);
		this.tail2.addBox(-3F, 2F, -2.5F, 6, 4, 3);
		this.tail2.setRotationPoint(0F, 11F, 0F);
		this.tail2.setTextureSize(128, 64);
		this.tail2.mirror = true;
		this.setRotation(tail2, 0.0872665F, 0F, 0F);
		this.tail3 = new ModelRenderer(this, 66, 14);
		this.tail3.addBox(-2.5F, 5F, -2F, 5, 4, 3);
		this.tail3.setRotationPoint(0F, 11F, 0F);
		this.tail3.setTextureSize(128, 64);
		this.tail3.mirror = true;
		this.setRotation(tail3, 0.1308997F, 0F, 0F);
		this.tail4 = new ModelRenderer(this, 66, 21);
		this.tail4.addBox(-2.5F, 8F, -1.5F, 5, 3, 4);
		this.tail4.setRotationPoint(0F, 11F, 0F);
		this.tail4.setTextureSize(128, 64);
		this.tail4.mirror = true;
		this.setRotation(tail4, 0.1745329F, 0F, 0F);
		this.tail5 = new ModelRenderer(this, 66, 28);
		this.tail5.addBox(-2F, 10F, -0.5F, 4, 3, 4);
		this.tail5.setRotationPoint(0F, 11F, 0F);
		this.tail5.setTextureSize(128, 64);
		this.tail5.mirror = true;
		this.setRotation(tail5, 0.1745329F, 0F, 0F);
		this.tail6 = new ModelRenderer(this, 66, 28);
		this.tail6.addBox(-2F, 11F, 1.5F, 4, 3, 4);
		this.tail6.setRotationPoint(0F, 11F, 0F);
		this.tail6.setTextureSize(128, 64);
		this.tail6.mirror = true;
		this.setRotation(tail6, 0.1745329F, 0F, 0F);
		this.tail7 = new ModelRenderer(this, 66, 35);
		this.tail7.addBox(-1.5F, 12F, 5.5F, 3, 2, 4);
		this.tail7.setRotationPoint(0F, 11F, 0F);
		this.tail7.setTextureSize(128, 64);
		this.tail7.mirror = true;
		this.setRotation(tail7, 0.1745329F, 0F, 0F);
		this.tail8 = new ModelRenderer(this, 66, 41);
		this.tail8.addBox(-1F, 12.5F, 9.5F, 2, 1, 4);
		this.tail8.setRotationPoint(0F, 11F, 0F);
		this.tail8.setTextureSize(128, 64);
		this.tail8.mirror = true;
		this.setRotation(tail8, 0.1745329F, 0F, 0F);
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
		this.setRotationAngles(par2, par3, par4, par5, par6, par7);
		this.bodytop.render(par7);
		this.bodymiddle.render(par7);
		this.bodybottom.render(par7);
		this.bodymiddlebutton.render(par7);
		this.head.render(par7);
		this.headaccessory.render(par7);
		this.finright.render(par7);
		this.finleft.render(par7);
		this.hair1.render(par7);
		this.hair2.render(par7);
		this.pauldron.render(par7);
		this.rightchest.render(par7);
		this.leftchest.render(par7);
		this.rightarm.render(par7);
		this.leftarm.render(par7);
		this.tail1.render(par7);
		this.tail2.render(par7);
		this.tail3.render(par7);
		this.tail4.render(par7);
		this.tail5.render(par7);
		this.tail6.render(par7);
		this.tail7.render(par7);
		this.tail8.render(par7);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6) {
		this.head.rotateAngleY = par4 / 57.295776F;
		this.head.rotateAngleX = par5 / 57.295776F;
		this.headaccessory.rotateAngleY = this.head.rotateAngleY;
		this.headaccessory.rotateAngleX = this.head.rotateAngleX;
		this.finright.rotateAngleY = this.head.rotateAngleY - 0.5235988F;
		this.finright.rotateAngleX = this.head.rotateAngleX;
		this.finleft.rotateAngleY = this.head.rotateAngleY + 0.5235988F;
		this.finleft.rotateAngleX = this.head.rotateAngleX;
		this.hair1.rotateAngleY = this.head.rotateAngleY;
		this.hair2.rotateAngleY = this.head.rotateAngleY;
		this.rightarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 1.0F * par2 * 0.5F;
		this.leftarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 1.0F * par2 * 0.5F;
		this.tail1.rotateAngleZ = MathHelper.cos(par1 * 0.6162F) * 0.1F * par2;
		this.tail2.rotateAngleZ = MathHelper.cos(par1 * 0.6262F) * 0.1F * par2;
		this.tail3.rotateAngleZ = MathHelper.cos(par1 * 0.6362F) * 0.1F * par2;
		this.tail4.rotateAngleZ = MathHelper.cos(par1 * 0.6462F) * 0.1F * par2;
		this.tail5.rotateAngleZ = MathHelper.cos(par1 * 0.6562F) * 0.1F * par2;
		this.tail6.rotateAngleZ = MathHelper.cos(par1 * 0.6662F) * 0.1F * par2;
		this.tail7.rotateAngleZ = MathHelper.cos(par1 * 0.6762F) * 0.1F * par2;
		this.tail8.rotateAngleZ = MathHelper.cos(par1 * 0.6762F) * 0.1F * par2;

		float f6;
		float f7;

		if (this.swingProgress > -9990.0F)
		{
			f6 = this.swingProgress;
			f6 = 1.0F - this.swingProgress;
			f6 *= f6;
			f6 *= f6;
			f6 = 1.0F - f6;
			f7 = MathHelper.sin(f6 * (float)Math.PI);
			float f8 = MathHelper.sin(this.swingProgress * (float)Math.PI) * -(this.head.rotateAngleX - 0.7F) * 0.75F;

			this.rightarm.rotateAngleX = (float)((double)this.rightarm.rotateAngleX - ((double)f7 * 1.2D + (double)f8));
			this.rightarm.rotateAngleY += this.bodytop.rotateAngleY * 2.0F;
			this.rightarm.rotateAngleZ = (MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F) + 0.2617994F;
		}
	}
}
