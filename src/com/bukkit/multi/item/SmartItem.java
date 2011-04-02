/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.bukkit.multi.item;

import java.sql.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.logging.Logger;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import java.io.IOException;


import com.nijiko.permissions.PermissionHandler;
import com.nijikokun.bukkit.Permissions.Permissions;
import org.bukkit.ChatColor;
/**
 *
 * @author multicoder
 */
public class SmartItem extends JavaPlugin{
        public static final Logger log = Logger.getLogger("Minecraft");
        private final SmartItemBlockListener blockListener = new SmartItemBlockListener(this);
        public static PermissionHandler Permissions;
        private SmartItemWorker worker = new SmartItemWorker();
    public void onEnable() {
        log.info("[SmartItem Enabled]");
        setupPermissions();
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvent(Event.Type.BLOCK_PLACE, blockListener,
        Event.Priority.Monitor, this);

    }
    public void onDisable() {log.info("[SmartItem Disbled]");}
    public boolean onCommand(CommandSender sender, Command command, String commandLabel, String[] args) {
    if(args.length<1)return false;

    String[] split = args;
    String[] split2 = split[0].split(":");  //try to get color parameter
    int amount = 64;
    if(split.length>1)amount=Integer.parseInt(split[1]);

    String commandName = command.getName().toLowerCase();
        if (sender instanceof Player) {
            Player player = (Player) sender;
            log.info("[" + player.getName() + ":/" + commandName + " " + split2[0] + "]");
            if ((commandName.equals("item")) || (commandName.equals("i"))) {
                Material material = Material.matchMaterial(split2[0]);
                if(material==null){
                    player.sendMessage(ChatColor.RED +"No such item: "+split2[0]);
                    return false;
                }
                int id = material.getId();
                System.out.println("get material: "+material.name()+" id: "+id);

                if ((id == 51) || (id == 52) || (id == 87) || (id==46)
                            || (id == 7) || (id == 8) || (id == 9) || (id == 52) || (id == 10)
                            || (id == 11) || (id == 7) || (id == 90) || (id == 91)
                            || (id == 92) || (id == 93) || (id == 94) || (id == 259) 
                            || (id == 289) || (id == 318)) {
                        if (SmartItem.Permissions.has(player, "multi.dangerblock")) {
                            player.getInventory().addItem(new ItemStack(material, 64));
                        }
                        else{
                            player.chat("<Sorry only architects and above can spawn: " + id + ">");
                        }
                } else {


                    
                    short damage=0;
                    //if we have color parameter
                    if(split2.length>1){
                        damage=Short.decode(split2[1]);
                    }

                    player.getInventory().addItem(new ItemStack(material, amount, damage));
                    player.sendMessage("[Item: "+material.name()+"]");
                    log.info("["+player.getName()+"Item: "+material.name()+"]");
                }
            }
            if (commandName.equals("list")){
                //timeSet(player, "day");
                worker.playerList();
            }
            if (commandName.equals("day")){
                //timeSet(player, "day");
                worker.timeDay();
            }
            if (commandName.equals("night")){
                worker.timeNight();
            }
            if (commandName.equals("tp")){
                Player buddy = player.getServer().getPlayer(split[0]);
                if (buddy != null)
			player.teleport(buddy);
		else
			player.sendMessage(ChatColor.RED + "Player " + ChatColor.WHITE + buddy.getName() + ChatColor.RED + " not found!");
		return true;
            }
            if (commandName.equals("heal")){
                player.setHealth(10);
            }
            if (commandName.equals("tphere")){
                Player buddy = player.getServer().getPlayer(split[0]);
		if (buddy != null)
			buddy.teleport(player);
		else
			player.sendMessage(ChatColor.RED + "Player " + ChatColor.WHITE + buddy.getName() + ChatColor.RED + " not found!");
		return true;
            }
            if (commandName.equals("help")){
			player.sendMessage(ChatColor.AQUA +
                                "Current commands:"
                                + "/tp /tphere /i /item /day /night /list"
                                );
                  return true;
            }
        }
    return true;
    }
    private void setupPermissions() {
      Plugin test = this.getServer().getPluginManager().getPlugin("Permissions");
      //System.out.println("testing permissions...");
      if (this.Permissions == null) {
          if (test != null) {
              this.Permissions = ((Permissions)test).getHandler();
          } else {
              System.out.println("Permission system not detected, defaulting to OP");
              log.info("Permission system not detected, defaulting to OP");
          }
      }
    }
}
