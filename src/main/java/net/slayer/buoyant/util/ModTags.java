package net.slayer.buoyant.util;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.slayer.buoyant.Buoyant;

public class ModTags {
    public static final TagKey<Item> BUOYANT = newTag("buoyant");
    public static final TagKey<Item> DENSE = newTag("dense");
    public static final TagKey<Item> SUPER_BUOYANT = newTag("super_buoyant");
    public static final TagKey<Item> SUPER_DENSE = newTag("super_dense");

    private static TagKey<Item> newTag(String name) {
        return TagKey.of(RegistryKeys.ITEM, new Identifier(Buoyant.MOD_ID, name));
    }
}
