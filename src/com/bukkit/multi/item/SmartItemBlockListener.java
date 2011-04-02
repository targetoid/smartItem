/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bukkit.multi.item;

import org.bukkit.ChatColor;
import org.bukkit.event.block.BlockListener;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.entity.Player;

/**
 *
 * @author multicoder
 */
public class SmartItemBlockListener extends BlockListener {
    public static SmartItem plugin;
    public SmartItemBlockListener(SmartItem instance) {
		plugin = instance;}
        public void onBlockPlace(BlockPlaceEvent event) {
		Block block = event.getBlock();
		Player player = event.getPlayer();
                //player.sendMessage(ChatColor.DARK_GREEN + "you placed some block!");
                String Temp = getBlockName(block);
                if((Temp=="TNT") || (Temp=="LAVA")){
                    player.chat("I placed:"+Temp+"!");
                }
                //player.chat(Temp);
                //plugin.logDataPlace(player.getName(), Temp, player.getLocation().getBlockX(), player.getLocation().getBlockY(), player.getLocation().getBlockZ());
        }

        public String getBlockName(Block b)
        {String R = "UNKNOWN";
         if (b.getType() == Material.AIR){return "AIR";}
         if (b.getType() == Material.APPLE){return "APPLE";}
         if (b.getType() == Material.ARROW){return "ARROW";}
         if (b.getType() == Material.BED){return "BED";}
         if (b.getType() == Material.BEDROCK){return "BEDROCK";}
         if (b.getType() == Material.BED_BLOCK){return "BED_BLOCK";}
         if (b.getType() == Material.BOAT){return "BOAT";}
         if (b.getType() == Material.BONE){return "BONE";}
         if (b.getType() == Material.BOOK){return "BOOK";}
         if (b.getType() == Material.BOOKSHELF){return "BOOKSHELF";}
         if (b.getType() == Material.BOW){return "BOW";}
         if (b.getType() == Material.BOWL){return "BOWL";}
         if (b.getType() == Material.BREAD){return "BREAD";}
         if (b.getType() == Material.BRICK){return "BRICK";}
         if (b.getType() == Material.BROWN_MUSHROOM){return "BROWN_MUSHROOM";}
         if (b.getType() == Material.BUCKET){return "BUCKET";}
         if (b.getType() == Material.BURNING_FURNACE){return "BURNING_FURNACE";}
         if (b.getType() == Material.CACTUS){return "CACTUS";}
         if (b.getType() == Material.CAKE){return "CAKE";}
         if (b.getType() == Material.CAKE_BLOCK){return "CAKE_BLOCK";}
         if (b.getType() == Material.CHAINMAIL_BOOTS){return "CHAINMAIL_BOOTS";}
         if (b.getType() == Material.CHAINMAIL_CHESTPLATE){return "CHAINMAIL_CHESTPLATE";}
         if (b.getType() == Material.CHAINMAIL_HELMET){return "CHAINMAIL_HELMET";}
         if (b.getType() == Material.CHAINMAIL_LEGGINGS){return "CHAINMAIL_LEGGINGS";}
         if (b.getType() == Material.CHEST){return "CHEST";}
         if (b.getType() == Material.CLAY){return "CLAY";}
         if (b.getType() == Material.CLAY_BALL){return "CLAY_BALL";}
         if (b.getType() == Material.CLAY_BRICK){return "CLAY_BRICK";}
         if (b.getType() == Material.COAL){return "COAL";}
         if (b.getType() == Material.COAL_ORE){return "COAL_ORE";}
         if (b.getType() == Material.COBBLESTONE){return "COBBLESTONE";}
         if (b.getType() == Material.COBBLESTONE_STAIRS){return "COBBLESTONE_STAIRS";}
         if (b.getType() == Material.COMPASS){return "COMPASS";}
         if (b.getType() == Material.COOKED_FISH){return "COOKED_FISH";}
         if (b.getType() == Material.CROPS){return "CROPS";}
         if (b.getType() == Material.DIAMOND){return "DIAMOND";}
         if (b.getType() == Material.DIAMOND_AXE){return "DIAMOND_AXE";}
         if (b.getType() == Material.DIAMOND_BLOCK){return "DIAMOND_BLOCK";}
         if (b.getType() == Material.DIAMOND_BOOTS){return "DIAMOND_BOOTS";}
         if (b.getType() == Material.DIAMOND_CHESTPLATE){return "DIAMOND_CHESTPLATE";}
         if (b.getType() == Material.DIAMOND_HELMET){return "DIAMOND_HELMET";}
         if (b.getType() == Material.DIAMOND_HOE){return "DIAMOND_HOE";}
         if (b.getType() == Material.DIAMOND_LEGGINGS){return "DIAMOND_LEGGINGS";}
         if (b.getType() == Material.DIAMOND_ORE){return "DIAMOND_ORE";}
         if (b.getType() == Material.DIAMOND_PICKAXE){return "DIAMOND_PICKAXE";}
         if (b.getType() == Material.DIAMOND_SPADE){return "DIAMOND_SPADE";}
         if (b.getType() == Material.DIAMOND_SWORD){return "DIAMOND_SWORD";}
         if (b.getType() == Material.DIODE){return "DIODE";}
         if (b.getType() == Material.DIODE_BLOCK_OFF){return "DIODE_BLOCK_OFF";}
         if (b.getType() == Material.DIODE_BLOCK_ON){return "DIODE_BLOCK_ON";}
         if (b.getType() == Material.DIRT){return "DIRT";}
         if (b.getType() == Material.DISPENSER){return "DISPENSER";}
         if (b.getType() == Material.DOUBLE_STEP){return "DOUBLE_STEP";}
         if (b.getType() == Material.EGG){return "EGG";}
         if (b.getType() == Material.FEATHER){return "FEATHER";}
         if (b.getType() == Material.FENCE){return "FENCE";}
         if (b.getType() == Material.FIRE){return "FIRE";}
         if (b.getType() == Material.FISHING_ROD){return "FISHING_ROD";}
         if (b.getType() == Material.FLINT){return "FLINT";}
         if (b.getType() == Material.FLINT_AND_STEEL){return "FLINT_AND_STEEL";}
         if (b.getType() == Material.FURNACE){return "FURNACE";}
         if (b.getType() == Material.GLASS){return "GLASS";}
         if (b.getType() == Material.GLOWING_REDSTONE_ORE){return "GLOWING_REDSTONE_ORE";}
         if (b.getType() == Material.GLOWSTONE){return "GLOWSTONE";}
         if (b.getType() == Material.GLOWSTONE_DUST){return "GLOWSTONE_DUST";}
         if (b.getType() == Material.GOLDEN_APPLE){return "GOLDEN_APPLE";}
         if (b.getType() == Material.GOLD_AXE){return "GOLD_AXE";}
         if (b.getType() == Material.GOLD_BLOCK){return "GOLD_BLOCK";}
         if (b.getType() == Material.GOLD_BOOTS){return "GOLD_BOOTS";}
         if (b.getType() == Material.GOLD_CHESTPLATE){return "GOLD_CHESTPLATE";}
         if (b.getType() == Material.GOLD_HELMET){return "GOLD_HELMET";}
         //if (b.getType() == Material.){return "";}
         if (b.getType() == Material.STONE){return "STONE";}
         if (b.getType() == Material.TNT){return "TNT";}
         if (b.getType() == Material.LAVA){return "LAVA";}
         if (b.getType() == Material.NETHERRACK){return "NETHERRACK";}
         if (b.getType() == Material.WOOD){return "WOOD";}
         return R;
        }
}
