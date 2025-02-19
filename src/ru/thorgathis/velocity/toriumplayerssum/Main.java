package ru.thorgathis.velocity.toriumplayerssum;

import com.google.inject.Inject;
import com.velocitypowered.api.event.Subscribe;
import com.velocitypowered.api.event.proxy.ProxyInitializeEvent;
import com.velocitypowered.api.plugin.Plugin;
import com.velocitypowered.api.proxy.ProxyServer;
import org.slf4j.Logger;

@Plugin(
        id = "toriumps",
        name = "ToriumPlayersSum",
        version = "1.0.0",
        description = "Online is a sum of all servers",
        authors = {"Thorgathis"}
)
public class Main {

    private final ProxyServer server;
    private final Logger logger;

    @Inject
    public Main(ProxyServer server, Logger logger) {
        this.server = server;
        this.logger = logger;
    }

    @Subscribe
    public void onProxyInitialization(ProxyInitializeEvent event) {
        server.getEventManager().register(this, new Listener(server));
        logger.info("Plugin ServersOnlineSum successfully loaded!");
    }
}