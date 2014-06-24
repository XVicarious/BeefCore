package erogenousbeef.test;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.FMLLog;
import erogenousbeef.core.multiblock.MultiblockClientTickHandler;
import erogenousbeef.test.client.RendererMultiblockTester;
import erogenousbeef.test.common.TileEntityMultiblockTester;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit() {
		super.preInit();
	}
	
	@Override
	public void init() {
		super.init();
		
		// Bind special renderers here
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityMultiblockTester.class, new RendererMultiblockTester());
        //MinecraftForge.EVENT_BUS.register(new MultiblockClientTickHandler());
        FMLCommonHandler.instance().bus().register(new MultiblockClientTickHandler());
        FMLLog.info("Tick handler registered on client");
	}
	
}
