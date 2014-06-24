package erogenousbeef.test.common;

import erogenousbeef.core.multiblock.MultiblockControllerBase;
import erogenousbeef.core.multiblock.MultiblockTileEntityBase;
import net.minecraft.nbt.NBTTagCompound;


public class TileEntityMultiblockTester extends MultiblockTileEntityBase {
	public static final int RED = 0xff0000;
	public static final int GREEN = 0x00ff00;
	public static final int BLUE = 0x0000ff;
	public static final int BLACK = 0x000000;
	
	private int colorIdx;
	private int[] colors = {BLACK, RED, GREEN, BLUE};

	public TileEntityMultiblockTester() {
		super();
		colorIdx = 0;
	}

	public int getColorIndex() {
		return colorIdx;
	}
	
	public int getColor() { return colors[colorIdx]; }
	
	public void changeColor() {
		colorIdx ++;
		if(colorIdx >= colors.length) {
			colorIdx = 0;
		}
	}
	
	@Override
	protected void encodeDescriptionPacket(NBTTagCompound packetData) {
		super.encodeDescriptionPacket(packetData);
		packetData.setInteger("colorIdx", colorIdx);
	}
	
	@Override
	protected void decodeDescriptionPacket(NBTTagCompound packetData) {
		super.decodeDescriptionPacket(packetData);
		if(packetData.hasKey("colorIdx")) {
			this.colorIdx = packetData.getInteger("colorIdx");
		}
	}

	@Override
	public MultiblockControllerBase createNewMultiblock() {
		return new TestMultiblockController(this.worldObj);
	}

	@Override
	public void onMachineAssembled(MultiblockControllerBase multiblockControllerBase) {}
	
	@Override
	public void onMachineBroken() { }

	@Override
	public void onMachineActivated() { }

	@Override
	public void onMachineDeactivated() { }

	@Override
	public Class<? extends MultiblockControllerBase> getMultiblockControllerType() {
		return TestMultiblockController.class;
	}

	@Override
	public void onOrphaned(MultiblockControllerBase oldController,
			int oldControllerSize, int newControllerSize) {
	}

}
