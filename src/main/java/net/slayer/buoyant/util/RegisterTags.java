package net.slayer.buoyant.util;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.slayer.buoyant.Buoyant;

public class RegisterTags {
    public static class Items {
        public static final TagKey<Item> BUOYANT = TagKey.of(RegistryKeys.ITEM, new Identifier("buoyant", "buoyant"));
        public static final TagKey<Item> HEAVY = TagKey.of(RegistryKeys.ITEM, new Identifier("buoyant", "dense"));
        public static final TagKey<Item> SUPER_BUOYANT = TagKey.of(RegistryKeys.ITEM, new Identifier("buoyant", "super_buoyant"));
        public static final TagKey<Item> SUPER_HEAVY = TagKey.of(RegistryKeys.ITEM, new Identifier("buoyant", "super_dense"));


        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(Buoyant.MOD_ID, name));
        }
    }
}
