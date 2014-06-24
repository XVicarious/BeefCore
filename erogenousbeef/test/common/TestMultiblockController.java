package erogenousbeef.test.common;

import cpw.mods.fml.common.FMLLog;
import erogenousbeef.core.common.BeefCoreLog;
import erogenousbeef.core.multiblock.IMultiblockPart;
import erogenousbeef.core.multiblock.MultiblockControllerBase;
import erogenousbeef.core.multiblock.MultiblockValidationException;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class TestMultiblockController extends MultiblockControllerBase {
    @Override
    protected void isMachineWhole() throws MultiblockValidationException {
        ;
    }

    protected static int nextOrdinal = 0;
	public int ordinal;
	
	public TestMultiblockController(World world) {
		super(world);
		if(world.isRemote) {
			ordinal = -1;
		}
		else {
			ordinal = nextOrdinal++;
		}
	}

	@Override
	protected void onBlockAdded(IMultiblockPart newPart) {
        BeefCoreLog.info("adding block");
	}

	@Override
	protected void onBlockRemoved(IMultiblockPart oldPart) {
	}

	@Override
	protected int getMinimumNumberOfBlocksForAssembledMachine() {
		return 2;
	}
	
	@Override
	protected void onAssimilate(MultiblockControllerBase assimilated) {
	}

	@Override
	protected void onAssimilated(MultiblockControllerBase otherMachine) {
	}

	@Override
	public void detachBlock(IMultiblockPart part, boolean chunkUnloading) {
        BeefCoreLog.info("[%s] Controller %d detaching block at %s", (worldObj.isRemote ? "CLIENT" : "SERVER"), ordinal, part.getWorldLocation());
		super.detachBlock(part, chunkUnloading);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound data) {
	}

	@Override
	public void readFromNBT(NBTTagCompound data) {
	}

	@Override
	public void formatDescriptionPacket(NBTTagCompound data) {
		data.setInteger("ordinal", ordinal);
	}

	@Override
	public void decodeDescriptionPacket(NBTTagCompound data) {
		if(data.hasKey("ordinal")) {
			ordinal = data.getInteger("ordinal");
		}
	}
	
	@Override
	protected void onMachinePaused() {
        BeefCoreLog.info("Machine %d PAUSED", hashCode());
	}
	
	@Override
	protected void onMachineAssembled() {
        BeefCoreLog.info("Machine %d ASSEMBLED", hashCode());
	}
	
	@Override
	protected void onMachineDisassembled() {
        BeefCoreLog.info("Machine %d DISASSEMBLED", hashCode());
	}

	@Override
	protected void onMachineRestored() {
        BeefCoreLog.info("Machine %d RESTORED", hashCode());
	}

	@Override
	protected boolean updateServer() {
		return false;
	}
	
	@Override
	protected void updateClient() {
	}

	@Override
	protected int getMaximumXSize() {
		return 16;
	}

	@Override
	protected int getMaximumZSize() {
		return 16;
	}

	@Override
	protected int getMaximumYSize() {
		return 16;
	}
	
	@Override
	protected void isBlockGoodForInterior(World world, int x, int y, int z) {
		return;
	}

	@Override
	public void onAttachedPartWithMultiblockData(IMultiblockPart part,
			NBTTagCompound data) {
		FMLLog.info("[%s] Controller %d assimilating save data from part @ %s", (worldObj.isRemote ? "CLIENT" : "SERVER"), ordinal, part.getWorldLocation());
		decodeDescriptionPacket(data);
	}

}
