package dev.uncreative.badventure.mixin.core.feature;

import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemFood;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import dev.uncreative.badventure.config.badventureconfig;

@Mixin(Item.class)
interface ItemAccessor {
	@Accessor("maxStackSize")
	int getMaxStackSize();

	@Accessor("maxStackSize")
	void setMaxStackSize(int size);
}

@Mixin(ItemFood.class)
public class FoodStackSize {


	@Inject(
		method = "<init>(Ljava/lang/String;Ljava/lang/String;IIIZI)V",
		at = @At("RETURN")
	)



	private void doubleMaxStackSize(
		String name,
		String namespaceId,
		int id,
		int healAmount,
		int ticksPerHeal,
		boolean favouriteWolfMeat,
		int maxStackSize,
		CallbackInfo ci
	) {
		ItemAccessor accessor = (ItemAccessor) this;

		int originalSize = accessor.getMaxStackSize();

		if (badventureconfig.increaseFoodStacks) {
			if (originalSize > 1) {
				if (originalSize * 2 > 16) {
					accessor.setMaxStackSize(originalSize);
				}
				else {
					accessor.setMaxStackSize(originalSize * 2);
				}
			}
		}
	}
}
