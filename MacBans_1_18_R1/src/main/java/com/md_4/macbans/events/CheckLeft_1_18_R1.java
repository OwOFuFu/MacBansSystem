package com.md_4.macbans.events;


import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.HashMap;

import static com.md_4.macbans.events.CheckJoin_1_18_R1.getJoinedPlayers;


@SuppressWarnings("all")
public class CheckLeft_1_18_R1 implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent e){
        getJoinedPlayers.remove(e.getPlayer());
    }
}
