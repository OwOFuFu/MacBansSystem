package com.md_4.macbans.events;


import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;


@SuppressWarnings("all")
public class CheckLeft_1_17_R1 implements Listener {

    public static HashMap<String, String> getJoinedPlayers = new HashMap<>();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent e){
        getJoinedPlayers.remove(e.getPlayer());
    }
}
