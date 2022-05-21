package me.nopox.expresshub.utils.external;

import me.clip.placeholderapi.PlaceholderAPI;
import me.nopox.expresshub.utils.CC;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.inventory.meta.SkullMeta;

import java.util.*;
import java.util.function.BiConsumer;

// From orbit games hub core

public class ItemBuilder {

    private final Map<Enchantment, Integer> enchantments = new HashMap<>();

    private final ItemStack itemStack;
    private ItemMeta itemMeta;

    /**
     * Constructor to make a new item builder object
     *
     * @param material the type of the item
     */
    public ItemBuilder(Material material) {
        this.itemStack = new ItemStack(material);
        this.itemMeta = itemStack.getItemMeta();
    }


    public ItemBuilder(ItemStack itemStack) {
        this.itemStack = itemStack;
        this.itemMeta = itemStack.getItemMeta();
    }


    public ItemBuilder setAmount(int amount) {
        this.itemStack.setAmount(amount);
        return this;
    }

    public ItemBuilder setOwner(String name) {
        final SkullMeta skullMeta = (SkullMeta) this.itemMeta;
        return this;
    }

    public ItemBuilder setDisplayName(String name) {
        this.itemMeta.setDisplayName(CC.translate(name));
        return this;
    }

    public ItemBuilder addItemFlags(ItemFlag... flags) {
        this.itemMeta.addItemFlags(flags);
        return this;
    }

    public ItemBuilder setDurability(int durability) {
        this.itemStack.setDurability((short) durability);
        return this;
    }

    public ItemBuilder addLore(String lore) {
        final ArrayList<String> stringArrayList = new ArrayList<>();


        stringArrayList.add(CC.translate(lore));

        this.itemMeta.setLore(stringArrayList);
        return this;
    }

    public ItemBuilder addLore(String lore, Player player) {
        final ArrayList<String> stringArrayList = new ArrayList<>();

        lore = PlaceholderAPI.setPlaceholders(player, lore);

        stringArrayList.add(CC.translate(lore));

        this.itemMeta.setLore(stringArrayList);
        return this;
    }

    public ItemBuilder addLore(List<String> lore) {
        this.itemMeta.setLore(CC.translate(lore));
        return this;
    }

    public ItemBuilder addLore(String... lore) {
        final List<String> strings = new ArrayList<>();

        for (String string : lore) {
            strings.add(CC.translate(string));
        }

        this.itemMeta.setLore(strings);

        return this;
    }

    public ItemBuilder setEnchant(Enchantment enchantment, int level) {
        this.enchantments.put(enchantment, level);

        return this;
    }



    public ItemStack create() {
        if (this.itemMeta != null) {
            this.itemStack.setItemMeta(this.itemMeta);
        }

        if (!this.enchantments.isEmpty()) {
            this.itemStack.addUnsafeEnchantments(this.enchantments);
        }

        return this.itemStack;
    }


}
