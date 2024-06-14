package gaia.client.renderer;

import gaia.GrimoireOfGaia;
import gaia.client.ClientHandler;
import gaia.client.model.HarpyModel;
import gaia.entity.Harpy;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.resources.ResourceLocation;

public class HarpyRenderer extends GaiaBabyMobRenderer<Harpy, HarpyModel> {
	public static final ResourceLocation[] HARPY_LOCATIONS = new ResourceLocation[]{
			ResourceLocation.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/harpy/harpy01.png"),
			ResourceLocation.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/harpy/harpy02.png"),
			ResourceLocation.fromNamespaceAndPath(GrimoireOfGaia.MOD_ID, "textures/entity/harpy/harpy03.png")};

	public HarpyRenderer(Context context) {
		super(context, new HarpyModel(context.bakeLayer(ClientHandler.HARPY)), ClientHandler.smallShadow);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
	}

	@Override
	public ResourceLocation getTextureLocation(Harpy harpy) {
		return HARPY_LOCATIONS[harpy.getVariant()];
	}
}
