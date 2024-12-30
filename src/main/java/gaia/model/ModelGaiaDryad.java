package gaia.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.MathHelper;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ModelGaiaDryad extends ModelBase{
	ModelRenderer head;
	ModelRenderer headaccessory;
	ModelRenderer hair1;
	ModelRenderer hair2;
	ModelRenderer bodytop;
	ModelRenderer bodymid;
	ModelRenderer bodymidbutton;
	ModelRenderer bodybottom;
	ModelRenderer rightchest;
	ModelRenderer lefttchest;
	public static ModelRenderer rightarm;
	ModelRenderer leftarm;
	ModelRenderer rightleg;
	ModelRenderer leftleg;
	ModelRenderer skirt1;
	ModelRenderer skirt2;

	public ModelGaiaDryad() {
		this.textureWidth = 128;
		this.textureHeight = 64;

		this.head = new ModelRenderer(this, 0, 0);
		this.head.addBox(-3F, -6F, -3F, 6, 6, 6);
		this.head.setRotationPoint(0F, 1F, 0F);
		this.head.setTextureSize(64, 32);
		this.head.mirror = true;
		this.setRotation(head, 0F, 0F, 0F);
		this.headaccessory = new ModelRenderer(this, 36, 0);
		this.headaccessory.addBox(-3.5F, -6.5F, -3.5F, 7, 7, 7);
		this.headaccessory.setRotationPoint(0F, 1F, 0F);
		this.headaccessory.setTextureSize(64, 32);
		this.headaccessory.mirror = true;
		this.setRotation(headaccessory, 0F, 0F, 0F);
		this.hair1 = new ModelRenderer(this, 36, 14);
		this.hair1.addBox(-4F, -6F, 1F, 8, 8, 3);
		this.hair1.setRotationPoint(0F, 1F, 0F);
		this.hair1.setTextureSize(64, 32);
		this.hair1.mirror = true;
		this.setRotation(hair1, 0F, 0F, 0F);
		this.hair2 = new ModelRenderer(this, 36, 25);
		this.hair2.addBox(-4.5F, -1F, 1.5F, 9, 9, 3);
		this.hair2.setRotationPoint(0F, 1F, 0F);
		this.hair2.setTextureSize(64, 32);
		this.hair2.mirror = true;
		this.setRotation(hair2, 0F, 0F, 0F);
		this.bodytop = new ModelRenderer(this, 0, 12);
		this.bodytop.addBox(-2.5F, 0F, -1.5F, 5, 5, 3);
		this.bodytop.setRotationPoint(0F, 1F, 0F);
		this.bodytop.setTextureSize(64, 32);
		this.bodytop.mirror = true;
		this.setRotation(bodytop, -0.0872665F, 0F, 0F);
		this.bodymid = new ModelRenderer(this, 0, 20);
		this.bodymid.addBox(-2F, 4.5F, -1.5F, 4, 3, 2);
		this.bodymid.setRotationPoint(0F, 1F, 0F);
		this.bodymid.setTextureSize(64, 32);
		this.bodymid.mirror = true;
		this.setRotation(bodymid, 0F, 0F, 0F);
		this.bodymidbutton = new ModelRenderer(this, 0, 20);
		this.bodymidbutton.addBox(-0.5F, 5F, -1.6F, 1, 2, 0);
		this.bodymidbutton.setRotationPoint(0F, 1F, 0F);
		this.bodymidbutton.setTextureSize(64, 32);
		this.bodymidbutton.mirror = true;
		this.setRotation(bodymidbutton, 0F, 0F, 0F);
		this.bodybottom = new ModelRenderer(this, 0, 25);
		this.bodybottom.addBox(-2.5F, 7F, -2.5F, 5, 3, 3);
		this.bodybottom.setRotationPoint(0F, 1F, 0F);
		this.bodybottom.setTextureSize(64, 32);
		this.bodybottom.mirror = true;
		this.setRotation(bodybottom, 0.0872665F, 0F, 0F);
		this.rightchest = new ModelRenderer(this, 0, 31);
		this.rightchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.rightchest.setRotationPoint(-1.3F, 3F, -1.5F);
		this.rightchest.setTextureSize(64, 32);
		this.rightchest.mirror = true;
		this.setRotation(rightchest, 0.7853982F, 0.1745329F, 0.0872665F);
		this.lefttchest = new ModelRenderer(this, 8, 31);
		this.lefttchest.addBox(-1F, -1F, -1F, 2, 2, 2);
		this.lefttchest.setRotationPoint(1.3F, 3F, -1.5F);
		this.lefttchest.setTextureSize(64, 32);
		this.lefttchest.mirror = true;
		this.setRotation(lefttchest, 0.7853982F, -0.0872665F, -0.0872665F);
		this.rightarm = new ModelRenderer(this, 16, 12);
		this.rightarm.addBox(-2F, -2F, -1F, 2, 10, 2);
		this.rightarm.setRotationPoint(-3F, 4F, 0F);
		this.rightarm.setTextureSize(64, 32);
		this.rightarm.mirror = true;
		this.setRotation(rightarm, 0.0872665F, 0F, 0.2617994F);
		this.leftarm = new ModelRenderer(this, 16, 12);
		this.leftarm.addBox(0F, -2F, -1F, 2, 10, 2);
		this.leftarm.setRotationPoint(3F, 4F, 0F);
		this.leftarm.setTextureSize(64, 32);
		this.leftarm.mirror = true;
		this.setRotation(leftarm, 0.0872665F, 0F, -0.2617994F);
		this.rightleg = new ModelRenderer(this, 24, 12);
		this.rightleg.addBox(-1F, 0F, -1F, 2, 13, 2);
		this.rightleg.setRotationPoint(-1.5F, 11F, 0F);
		this.rightleg.setTextureSize(64, 32);
		this.rightleg.mirror = true;
		this.setRotation(rightleg, 0F, 0F, -0.0349066F);
		this.leftleg = new ModelRenderer(this, 26, 12);
		this.leftleg.addBox(-1F, 0F, -1F, 2, 13, 2);
		this.leftleg.setRotationPoint(1.5F, 11F, 0F);
		this.leftleg.setTextureSize(64, 32);
		this.leftleg.mirror = true;
		this.setRotation(leftleg, 0F, 0F, 0.0349066F);
		this.skirt1 = new ModelRenderer(this, 36, 47);
		this.skirt1.addBox(-3.5F, 5F, -2F, 7, 7, 4);
		this.skirt1.setRotationPoint(0F, 11F, 0F);
		this.skirt1.setTextureSize(64, 32);
		this.skirt1.mirror = true;
		this.setRotation(skirt1, 0.1745329F, 0F, 0F);
		this.skirt2 = new ModelRenderer(this, 36, 37);
		this.skirt2.addBox(-3F, -1F, -2F, 6, 6, 4);
		this.skirt2.setRotationPoint(0F, 11F, 0F);
		this.skirt2.setTextureSize(64, 32);
		this.skirt2.mirror = true;
		this.setRotation(skirt2, 0.2617994F, 0F, 0F);
	}

	public void render(Entity entity, float par2, float par3, float par4, float par5, float par6, float par7) {
		super.render(entity, par2, par3, par4, par5, par6, par7);
		this.setRotationAngles(par2, par3, par4, par5, par6, par7);
		this.head.render(par7);
		this.headaccessory.render(par7);
		this.hair1.render(par7);
		this.hair2.render(par7);
		this.bodytop.render(par7);
		this.bodymid.render(par7);
		this.bodymidbutton.render(par7);
		this.bodybottom.render(par7);
		this.rightchest.render(par7);
		this.lefttchest.render(par7);
		this.rightarm.render(par7);
		this.leftarm.render(par7);
		this.rightleg.render(par7);
		this.leftleg.render(par7);
		this.skirt1.render(par7);
		this.skirt2.render(par7);
	}

	private void setRotation(ModelRenderer model, float x, float y, float z)
	{
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float par1, float par2, float par3, float par4, float par5, float par6) {
		this.head.rotateAngleY = par4 / 57.295776F;
		this.head.rotateAngleX = par5 / 57.295776F;
		this.headaccessory.rotateAngleY = this.head.rotateAngleY;
		this.headaccessory.rotateAngleX = this.head.rotateAngleX;
		this.hair1.rotateAngleY = this.head.rotateAngleY;
		this.hair2.rotateAngleY = this.head.rotateAngleY;
		this.rightarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.8F * par2 * 0.5F;
		this.rightarm.rotateAngleX += 0.0872665F;
		this.leftarm.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.8F * par2 * 0.5F;
		this.leftarm.rotateAngleX += 0.0872665F;
		this.rightleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F) * 0.8F * par2;
		this.leftleg.rotateAngleX = MathHelper.cos(par1 * 0.6662F + (float)Math.PI) * 0.8F * par2;

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

			this.rightarm.rotateAngleX = (float)((double)this.rightarm.rotateAngleX - ((double)f7 * 1.2D + (double)f8)) + 0.0872665F;
			this.rightarm.rotateAngleY += (this.bodytop.rotateAngleY * 2.0F);
			this.rightarm.rotateAngleZ = (MathHelper.sin(this.swingProgress * (float)Math.PI) * -0.4F) + 0.2617994F;
		}
	}
}
