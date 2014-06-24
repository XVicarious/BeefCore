package erogenousbeef.test;

import cpw.mods.fml.common.FMLCommonHandler;
import erogenousbeef.core.multiblock.MultiblockServerTickHandler;

public class CommonProxy {

	public void preInit() {
		
	}
	
	public void init() {
		TestMod.registerTileEntities();
        //MinecraftForge.EVENT_BUS.register(new MultiblockServerTickHandler());
        FMLCommonHandler.instance().bus().register(new MultiblockServerTickHandler());
        //TickRegistry.registerTickHandler(new MultiblockServerTickHandler(), Side.SERVER);
	}
}
