package com.Companion.Companion.Handlers;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.Companion.Companion.Main;
import com.Companion.Companion.Menus.CompanionMenu;

public class CommandHandler implements Listener, CommandExecutor {
	
	@SuppressWarnings("unused")
	private Main plugin;

	public CommandHandler(Main hub) {
		this.plugin = hub;
	}
	
	public boolean onCommand(CommandSender sender, Command command,
			String alias, String[] args) {
		Player player = (Player) sender;
		if (alias.equalsIgnoreCase("companion")){
			CompanionMenu.Menu(player);
		}
		return true;
	}

}
