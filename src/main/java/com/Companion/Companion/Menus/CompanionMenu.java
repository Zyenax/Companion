package com.Companion.Companion.Menus;

import java.util.Arrays;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.Companion.Companion.Main;
import com.Companion.Companion.Bungee.BUtil;
import com.Companion.Companion.Utils.Packets;
import com.Companion.Companion.Utils.Util;

public class CompanionMenu implements Listener{
	
	public static Inventory inv;
	
	private Main plugin;
	public CompanionMenu(Main listener) {
		this.plugin = listener;	
	}
	
	public static void Menu(Player p){
		inv = Bukkit.createInventory(null, 45, Util.color("        &c&lCompanion Menu"));
		Border();
		Shutdown(p);
		ChatClear(p);
		UnknownFiller();
		p.openInventory(inv);
	}
	
	public static void Border(){
		ItemStack border = Util.createItem(Material.STAINED_GLASS_PANE, 1, 15, Util.color(" "), null);
		inv.setItem(0, border);
		inv.setItem(1, border);
		inv.setItem(2, border);
		inv.setItem(3, border);
		inv.setItem(4, border);
		inv.setItem(5, border);
		inv.setItem(6, border);
		inv.setItem(7, border);
		inv.setItem(8, border);
		inv.setItem(9, border);
		inv.setItem(17, border);
		inv.setItem(18, border);
		inv.setItem(26, border);
		inv.setItem(27, border);
		inv.setItem(35, border);
		inv.setItem(36, border);
		inv.setItem(37, border);
		inv.setItem(38, border);
		inv.setItem(39, border);
		inv.setItem(40, border);
		inv.setItem(41, border);
		inv.setItem(42, border);
		inv.setItem(43, border);
		inv.setItem(44, border);
	}
	
	public static void UnknownFiller(){
			ItemStack item = Util.createSkull(Util.color("MHF_Question"), Util.color("&6&lCOMING SOON"), null);
			inv.setItem(14, item);
			inv.setItem(16, item);
			inv.setItem(20, item);
			inv.setItem(22, item);
			inv.setItem(24, item);
			inv.setItem(28, item);
			inv.setItem(30, item);
			inv.setItem(32, item);
			inv.setItem(34, item);
	}
	
	public static void Shutdown(Player p){
		if(p.hasPermission("companion.shutdown")){
			ItemStack item = Util.createItem(Material.BARRIER, 1, 0, Util.color("           &a&lSHUT DOWN"), Arrays.asList(Util.color(" "), Util.color("    &7Shuts the server down"), Util.color("&7while warning the players and"), Util.color("        &7saving the world!"), Util.color(" "), Util.color("            &a&lACCESS ✔"), Util.color("        &8Click to activate!")));
			inv.setItem(10, item);
		}else {
			ItemStack item = Util.createItem(Material.BARRIER, 1, 0, Util.color("           &c&lSHUT DOWN"), Arrays.asList(Util.color(" "), Util.color("    &7Shuts the server down"), Util.color("&7while warning the players and"), Util.color("        &7saving the world!"), Util.color(" "), Util.color("            &c&lACCESS ✘"), Util.color("        &8Click to activate!")));
			inv.setItem(10, item);
		}
	}
	
	public static void ChatClear(Player p){
		if(p.hasPermission("companion.clearchat")){
			ItemStack item = Util.createItem(Material.NAME_TAG, 1, 0, Util.color("             &a&lCLEAR CHAT"), Arrays.asList(Util.color(" "), Util.color("       &7Clears the chat of the"), Util.color("&7server from spammers and other"), Util.color("         &7malicious messages!"), Util.color(" "), Util.color("               &a&lACCESS ✔"), Util.color("           &8Click to activate!")));
			inv.setItem(12, item);
		}else {
			ItemStack item = Util.createItem(Material.NAME_TAG, 1, 0, Util.color("             &c&lCLEAR CHAT"), Arrays.asList(Util.color(" "), Util.color("       &7Clears the chat of the"), Util.color("&7server from spammers and other"), Util.color("         &7malicious messages!"), Util.color(" "), Util.color("               &c&lACCESS ✘"), Util.color("           &8Click to activate!")));
			inv.setItem(12, item);
		}
	}
	
	
	@EventHandler
	public void menuClickEvent(InventoryClickEvent e){
		final Player p = (Player) e.getWhoClicked();
		final ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
		if(e.getInventory().getName().equals(Util.color("        &c&lCompanion Menu"))){
			e.setCancelled(true);
			if(e.getWhoClicked() instanceof Player){
				if(!(e.getInventory() == null)){
					if(!(e.getCurrentItem() == null)){
						if(!(e.getCurrentItem().getType() == Material.AIR)){
							//START OF THE MENU ITEMS FOR THE CLICK EVENT
							
							
							//SHUT DOWN SERVER ACTIONS
							if(e.getCurrentItem().getType().equals(Material.BARRIER)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Util.color("           &a&lSHUT DOWN"))){
									//ACTION GOES HERE
									e.getWhoClicked().closeInventory();
									for(final Player player : Bukkit.getOnlinePlayers()){
									e.setCancelled(true);
									p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, Integer.MAX_VALUE, Integer.MAX_VALUE);
				    				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,new Runnable() {
										public void run() {
										   Packets.sendTitle(player, Util.color("&c&lSHUTTING DOWN IN..."), Util.color("&c&l10 SECONDS!"));
										   player.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, Integer.MAX_VALUE, Integer.MAX_VALUE);
										}
									}, 0);
				    				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,new Runnable() {
										public void run() {
										   Packets.sendTitle(player, Util.color("&c&lSHUTTING DOWN IN..."), Util.color("&c&l9 SECONDS!"));
										   player.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, Integer.MAX_VALUE, Integer.MAX_VALUE);
										}
									}, 20);
				    				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,new Runnable() {
										public void run() {
										   Packets.sendTitle(player, Util.color("&c&lSHUTTING DOWN IN..."), Util.color("&c&l8 SECONDS!"));
										   player.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, Integer.MAX_VALUE, Integer.MAX_VALUE);
										}
									}, 40);
				    				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,new Runnable() {
										public void run() {
										   Packets.sendTitle(player, Util.color("&c&lSHUTTING DOWN IN..."), Util.color("&c&l7 SECONDS!"));
										   player.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, Integer.MAX_VALUE, Integer.MAX_VALUE);
										}
									}, 60);
				    				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,new Runnable() {
										public void run() {
										   Packets.sendTitle(player, Util.color("&c&lSHUTTING DOWN IN..."), Util.color("&c&l6 SECONDS!"));
										   player.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, Integer.MAX_VALUE, Integer.MAX_VALUE);
										}
									}, 80);
				    				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,new Runnable() {
										public void run() {
										   Packets.sendTitle(player, Util.color("&c&lSHUTTING DOWN IN..."), Util.color("&c&l5 SECONDS!"));
										   player.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, Integer.MAX_VALUE, Integer.MAX_VALUE);
										   Bukkit.getServer().dispatchCommand(console , Util.color("save-all"));
										}
									}, 100);
				    				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,new Runnable() {
										public void run() {
										   Packets.sendTitle(player, Util.color("&c&lSHUTTING DOWN IN..."), Util.color("&c&l4 SECONDS!"));
										   player.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, Integer.MAX_VALUE, Integer.MAX_VALUE);
										}
									}, 120);
				    				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,new Runnable() {
										public void run() {
										   Packets.sendTitle(player, Util.color("&c&lSHUTTING DOWN IN..."), Util.color("&c&l3 SECONDS!"));
										   player.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, Integer.MAX_VALUE, Integer.MAX_VALUE);
										}
									}, 140);
				    				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,new Runnable() {
										public void run() {
										   Packets.sendTitle(player, Util.color("&c&lSHUTTING DOWN IN..."), Util.color("&c&l2 SECONDS!"));
										   player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_BREAK, Integer.MAX_VALUE, Integer.MAX_VALUE);
										}
									}, 160);
				    				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,new Runnable() {
										public void run() {
										   Packets.sendTitle(player, Util.color("&c&lSHUTTING DOWN IN..."), Util.color("&c&l1 SECONDS!"));
										   player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_BREAK, Integer.MAX_VALUE, Integer.MAX_VALUE);
										}
									}, 180);
				    				Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(plugin,new Runnable() {
										public void run() {
											BUtil.sendToServer(player, "Hub");
										   Bukkit.getServer().shutdown();
										   player.playSound(player.getLocation(), Sound.BLOCK_ANVIL_BREAK, Integer.MAX_VALUE, Integer.MAX_VALUE);
										}
									}, 200);
								}
								}
							}
							
							//SHUT DOWN SERVER NO ACCESS
							if(e.getCurrentItem().getType().equals(Material.BARRIER)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Util.color("           &c&lSHUT DOWN"))){
									//ACTION GOES HERE
									e.getWhoClicked().closeInventory();
									p.sendMessage(Util.color("&4&lCOMPANION &8>> &cNo Access!"));
									e.setCancelled(true);
									p.playSound(p.getLocation(), Sound.BLOCK_CHEST_LOCKED, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}
							
							
							
							if(e.getCurrentItem().getType().equals(Material.NAME_TAG)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Util.color("             &a&lCLEAR CHAT"))){
									//ACTION GOES HERE
									for(final Player player : Bukkit.getOnlinePlayers()){
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("                     "));
										player.sendMessage(Util.color("&4&lCHAT &8>> &cChat was cleared by: &e" + p.getName()));
									e.getWhoClicked().closeInventory();
									e.setCancelled(true);
									p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, Integer.MAX_VALUE, Integer.MAX_VALUE);
									}
								}
							}
							if(e.getCurrentItem().getType().equals(Material.NAME_TAG)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Util.color("             &c&lCLEAR CHAT"))){
									//ACTION GOES HERE
									e.getWhoClicked().closeInventory();
									p.sendMessage(Util.color("&4&lCOMPANION &8>> &cNo Access!"));
									e.setCancelled(true);
									p.playSound(p.getLocation(), Sound.BLOCK_CHEST_LOCKED, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}
							
							
							if(e.getCurrentItem().getType().equals(Material.STAINED_GLASS_PANE)){
								if(e.getCurrentItem().getItemMeta().getDisplayName().equals(Util.color(" "))){
									//ACTION GOES HERE
									e.setCancelled(true);
									p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, Integer.MAX_VALUE, Integer.MAX_VALUE);
								}
							}
							//END OF THE MENU ITEMS
							
							
							
						}else{
							e.setCancelled(true);
							p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, Integer.MAX_VALUE, Integer.MAX_VALUE);
						}
					}else{
						e.setCancelled(true);
						p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_BREAK, Integer.MAX_VALUE, Integer.MAX_VALUE);
					}
				}else{
					e.setCancelled(true);
				}
			}else{
				e.setCancelled(true);
			}
		}
	}

}
