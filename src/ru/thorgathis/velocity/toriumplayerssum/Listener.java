package ru.thorgathis.velocity.toriumplayerssum;

import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyPingEvent;
import com.velocitypowered.api.proxy.ProxyServer;
import com.velocitypowered.api.proxy.server.RegisteredServer;
import com.velocitypowered.api.proxy.server.ServerPing;

public class Listener {
    private final ProxyServer server;

    public Listener(ProxyServer server) {
        this.server = server;
    }

    @Subscribe
    public void onProxyPing(ProxyPingEvent event) {
        int totalOnline = 0;

        for (RegisteredServer registeredServer : server.getAllServers()) {
            totalOnline += registeredServer.getPlayersConnected().size();
        }

        ServerPing ping = event.getPing();
        ServerPing.Builder builder = ping.asBuilder();
        builder.onlinePlayers(totalOnline);
        event.setPing(builder.build());
    }
}