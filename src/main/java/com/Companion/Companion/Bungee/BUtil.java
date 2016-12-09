package com.Companion.Companion.Bungee;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.Companion.Companion.Main;

public class BUtil implements Listener{

	private static Main plugin;

	public BUtil(Main hub) {
		BUtil.plugin = hub;
	}

	public static void sendToServer(Player player, String targetServer) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try {
			out.writeUTF("Connect");
			out.writeUTF(targetServer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
	}
	
	public static void sendMessage(Player player, String playerName, String Message) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try {
			out.writeUTF("Message");
			out.writeUTF(playerName);
			out.writeUTF(Message);
		} catch (Exception e) {
			e.printStackTrace();
		}
		player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
	}
	
	public static void playerCountOfServer(Player player, String targetServer) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try {
			out.writeUTF("PlayerCount");
			out.writeUTF(targetServer);
		} catch (Exception e) {
			e.printStackTrace();
		}
		player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
	}
	
	public static void kickPlayer(Player player, String playerName, String kickMessage) {
		ByteArrayOutputStream b = new ByteArrayOutputStream();
		DataOutputStream out = new DataOutputStream(b);
		try {
			out.writeUTF("KickPlayer");
			out.writeUTF(playerName);
			out.writeUTF(kickMessage);
		} catch (Exception e) {
			e.printStackTrace();
		}
		player.sendPluginMessage(plugin, "BungeeCord", b.toByteArray());
	}
}