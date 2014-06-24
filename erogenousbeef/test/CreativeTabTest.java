package erogenousbeef.test;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabTest extends CreativeTabs {

	public CreativeTabTest(int par1, String par2Str) {
		super(par1, par2Str);
	}

    @Override
    public Item getTabIconItem() {
        return Items.item_frame;
    }
}
