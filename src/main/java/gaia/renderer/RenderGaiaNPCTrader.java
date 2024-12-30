package gaia.renderer;

import gaia.GaiaReference;
import gaia.model.ModelGaiaNPCTrader;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderGaiaNPCTrader extends RenderLiving {

	private static final ResourceLocation texture = new ResourceLocation(GaiaReference.MOD_ID, "textures/models/Trader.png");

	static RenderManager rend = Minecraft.getMinecraft().getRenderManager();
	public RenderGaiaNPCTrader( float shadowSize) {
		super(rend, new ModelGaiaNPCTrader(), shadowSize);
	}

	protected ResourceLocation getEntityTexture(Entity entity) {
		return texture;
	}
}
