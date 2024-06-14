package gaia.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.CobbleGolemModel;
import gaia.entity.CobbleGolem;
import gaia.entity.CobblestoneGolem;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CobbleGolemRenderer extends MobRenderer<CobbleGolem, CobbleGolemModel> {
	public static final ResourceLocation[] COBBLE_GOLEM_LOCATIONS = new ResourceLocation[]{
			ResourceLocation.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/cobble_golem/cobble_golem.png")};

	public CobbleGolemRenderer(Context context) {
		super(context, new CobbleGolemModel(context.bakeLayer(ClientHandler.COBBLE_GOLEM)), ClientHandler.smallShadow);
	}

	@Override
	protected void setupRotations(CobbleGolem cobbleGolem, PoseStack poseStack, float bob, float yBodyRot, float partialTick, float scale) {
		super.setupRotations(cobbleGolem, poseStack, bob, yBodyRot, partialTick, scale);
		if (!((double) cobbleGolem.walkAnimation.speed() < 0.01D)) {
			float f = 13.0F;
			float f1 = cobbleGolem.walkAnimation.position() - cobbleGolem.walkAnimation.speed() * (1.0F - partialTick) + 6.0F;
			float f2 = (Math.abs(f1 % f - 6.5F) - 3.25F) / 3.25F;
			poseStack.mulPose(Axis.ZP.rotationDegrees(6.5F * f2));
		}
	}

	@Override
	public ResourceLocation getTextureLocation(CobbleGolem cobbleGolem) {
		return COBBLE_GOLEM_LOCATIONS[cobbleGolem.getVariant()];
	}
}
