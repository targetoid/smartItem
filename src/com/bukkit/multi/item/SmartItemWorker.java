/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bukkit.multi.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 *
 * @author multicoder
 */
public class SmartItemWorker {
    private Player player;
    private int serverVersion;
    private HashMap<Material, String[]> materialsColors;
    private List<int[]> listOfPossibleRepair;
   public boolean playerList() {
        Player[] online = player.getServer().getOnlinePlayers();
        player.sendMessage(ChatColor.RED + "Online players: " + ChatColor.WHITE + online.length);
        String buffer = "";
        for (int i = 0; i < online.length; ++i) {
            Player p = online[i];
            String name = p.getDisplayName();
            if (buffer.length() + name.length() + 2 >= 256) {
                player.sendMessage(buffer);
                buffer = "";
            }
            buffer += name + ", ";
        }
        player.sendMessage(buffer);
        return true;
   }
   public boolean timeSet(String arg) {
        long curtime = player.getWorld().getTime();
        long newtime = curtime - (curtime % 24000);
        if (arg.equalsIgnoreCase("day"))
            newtime += 0;
        else if (arg.equalsIgnoreCase("night"))
            newtime += 14000;
        else if (arg.equalsIgnoreCase("dusk"))
            newtime += 12500;
        else if (arg.equalsIgnoreCase("dawn"))
            newtime += 23000;
        else // if not a constant, use raw time
            try {
                newtime += Integer.parseInt(arg);
            } catch (Exception e) {
                return false; // just print the usage...
            }
        player.getWorld().setTime(newtime);
        return true;
    }

    // just an alias to /time day
    public boolean timeDay() {
        player.getWorld().setTime(0);
        return true;
    }
    public boolean timeNight() {
        player.getWorld().setTime(14000);
        return true;
    }

}
