package com.Companion.Companion;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.messaging.PluginMessageListener;

import com.Companion.Companion.Bungee.BUtil;
import com.Companion.Companion.Handlers.CommandHandler;
import com.Companion.Companion.Menus.CompanionMenu;
import com.Companion.Companion.Utils.Packets;
import com.Companion.Companion.Utils.Util;
import com.google.common.io.ByteArrayDataInput;
import com.google.common.io.ByteStreams;

public class Main extends JavaPlugin implements Listener, PluginMessageListener{
	
	public void onEnable(){
		Listeners();
		Commands();
		final ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
	    console.sendMessage(Util.color("&c&l[&a&lCompanion&c&l] &b&lHas Been Enabled!"));
	    Bukkit.getServer().getMessenger().registerOutgoingPluginChannel(this,"BungeeCord");
	    Bukkit.getServer().getMessenger().registerIncomingPluginChannel(this, "BungeeCord", this);
	}
	
	public void onDisable(){
		final ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
	    console.sendMessage(Util.color("&c&l[&a&lCompanion&c&l] &c&lHas Been Disabled!"));
	}
	
	public void Listeners(){
		PluginManager pm = Bukkit.getServer().getPluginManager();
		pm.registerEvents(new Packets(this), this);
		pm.registerEvents(new Util(this), this);
		pm.registerEvents(new CompanionMenu(this), this);
		pm.registerEvents(new CommandHandler(this), this);
		pm.registerEvents(new BUtil(this), this);
	}
	
	public void Commands(){
		getCommand("companion").setExecutor(new CommandHandler(this));
	}
	
	@SuppressWarnings("unused")
	public void onPluginMessageReceived(String channel, Player player, byte[] message) {
	    if (!channel.equals("BungeeCord")) {
	      return;
	    }
	    ByteArrayDataInput in = ByteStreams.newDataInput(message);
	    String subchannel = in.readUTF();
	    if (subchannel.equals("BungeeCord")) {
	      // Use the code sample in the 'Response' sections below to read
	      // the data.
	    	String server = in.readUTF(); // Name of server, as given in the arguments
			int playercount = in.readInt();
	    }
	  }
}
