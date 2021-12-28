package com.md_4.macbans.events;


import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static com.md_4.macbans.events.CheckJoin_1_15_R1.getJoinedPlayers;


@SuppressWarnings("all")
public class CheckLeft_1_15_R1 implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent e){
        getJoinedPlayers.remove(e.getPlayer());
    }
}

