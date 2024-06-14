package gaia.client.renderer.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.SludgeGirlModel;
import gaia.entity.SludgeGirl;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

public class SludgeHairLayer extends RenderLayer<SludgeGirl, SludgeGirlModel> {
	public static final ResourceLocation[] SLUDGE_GIRL_HAIR_LOCATIONS = new ResourceLocation[]{
			ResourceLocation.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/sludge_girl/hair_sludge_girl01.png"),
			ResourceLocation.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/sludge_girl/hair_sludge_girl02.png"),
			ResourceLocation.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/sludge_girl/hair_sludge_girl03.png")};

	private final SludgeGirlModel model;

	public SludgeHairLayer(RenderLayerParent<SludgeGirl, SludgeGirlModel> renderLayerParent, EntityModelSet modelSet) {
		super(renderLayerParent);
		this.model = new SludgeGirlModel(modelSet.bakeLayer(ClientHandler.SLUDGE_GIRL));
	}

	public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, SludgeGirl sludgeGirl, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		Minecraft minecraft = Minecraft.getInstance();
		boolean flag = minecraft.shouldEntityAppearGlowing(sludgeGirl) && sludgeGirl.isInvisible();
		if (!sludgeGirl.isInvisible() || flag) {
			VertexConsumer vertexconsumer;
			if (flag) {
				vertexconsumer = bufferSource.getBuffer(RenderType.outline(this.getTextureLocation(sludgeGirl)));
			} else {
				vertexconsumer = bufferSource.getBuffer(RenderType.entityTranslucent(this.getTextureLocation(sludgeGirl)));
			}

			this.getParentModel().copyPropertiesTo(this.model);
			this.model.prepareMobModel(sludgeGirl, limbSwing, limbSwingAmount, partialTicks);
			this.model.setupAnim(sludgeGirl, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
			this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, LivingEntityRenderer.getOverlayCoords(sludgeGirl, 0.0F));
		}
	}

	@Override
	protected ResourceLocation getTextureLocation(SludgeGirl sludgeGirl) {
		return SLUDGE_GIRL_HAIR_LOCATIONS[sludgeGirl.getVariant()];
	}
}