package com.md_4.macbans.events;


import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;



@SuppressWarnings("all")
public class CheckLeft_1_8_1_12_R1 implements Listener {

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent e){
        getJoinedPlayers.remove(e.getPlayer());
    }


}

