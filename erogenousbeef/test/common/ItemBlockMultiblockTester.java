package erogenousbeef.test.common;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;

public class ItemBlockMultiblockTester extends ItemBlock {

	public ItemBlockMultiblockTester(Block block) {
		super(block);
		this.setMaxDamage(0);
		this.setHasSubtypes(false);
	}
}
