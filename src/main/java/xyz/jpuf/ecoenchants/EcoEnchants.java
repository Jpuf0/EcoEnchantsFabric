package xyz.jpuf.ecoenchants;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;

import xyz.jpuf.ecoenchants.Enchantments.EcoEnchantments;
import xyz.jpuf.ecoenchants.Events.EventHandlers;
import xyz.jpuf.ecoenchants.extras.Blocks.BlockLoader;

public class EcoEnchants implements ModInitializer {
    public static String MODID = "ecoenchants";

    public static final ItemGroup ECOENCHANTS = FabricItemGroupBuilder.create(
            new Identifier(MODID, "enchantments"))
            .icon(() -> new ItemStack(Items.ENCHANTED_BOOK))
            .appendItems(item -> {
                item.addAll(EcoEnchantments.getBooks());
            })
            .build();

    @Override
    public void onInitialize() {
        EcoEnchantments.register();
        BlockLoader.load();
//        CustomLoader.load();
        EventHandlers.init();
        System.out.println("All Enchants: " + String.valueOf(EcoEnchantments.all()));
//        EcoEnchantments.getBooks();
    }
}
