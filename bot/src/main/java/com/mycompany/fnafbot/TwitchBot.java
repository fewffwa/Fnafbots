/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.fnafbot;

import static com.mycompany.fnafbot.Fnafbot.writetoini;
import static com.mycompany.fnafbot.Fnafbot.writetoinialt;
import org.pircbotx.PircBotX;
import org.pircbotx.hooks.*;
import org.pircbotx.hooks.events.*;
import org.pircbotx.Configuration;

/**
 *
 * @author yourf
 */
public class TwitchBot extends ListenerAdapter {

    public TwitchBot() throws Exception {
        String botUsername = "yourusernamehere";
        String oauthToken = "oauthtoken";

        // The channel you want the bot to join
        String channel = "channelname";

        Configuration configuration = new Configuration.Builder()
                .setName(botUsername)
                .addServer("irc.twitch.tv")
                .setServerPort(6667)
                .setServerPassword(oauthToken)
                .addAutoJoinChannel(channel)
                .addListener(this)
                .buildConfiguration();

        PircBotX bot = new PircBotX(configuration);
        bot.startBot();

    }

    @Override
    public void onMessage(MessageEvent event) {
        String message = event.getMessage();
        if (message.equals("!start")) {
            writetoinialt("start", 1);
        }
        if (message.equals("!cams")) {
            writetoini("camup", 1);
            writetoini("camdown", 1);
        }
                if (message.equals("!panels")) {
            writetoini("panelup", 1);
            writetoini("paneldown", 1);
        }
        if (message.equals("!right")) {
            writetoini("goright", 1);
        }
        if (message.equals("!left")) {
            writetoini("goleft", 1);
        }
        makeGameplayCommand("camup", message);
        makeGameplayCommand("camdown", message);
        makeGameplayCommand("panelup", message);
        makeGameplayCommand("paneldown", message);
        makeGameplayCommand("mute", message);
        makeGameplayCommand("honk", message);
        makeGameplayCommand("lure", message);
        makeGameplayCommand("audio", message);
        makeGameplayCommand("vent", message);
        makeGameplayCommand("video", message);
        makeGameplayCommand("all", message);
        makeGameplayCommand("seal11", message);
        makeGameplayCommand("seal12", message);
        makeGameplayCommand("seal13", message);
        makeGameplayCommand("seal14", message);
        makeGameplayCommand("seal15", message);
        makeGameplayCommand("mapvent", message);
        makeGameplayCommand("mapcams", message);
        makeGameplayCommand("cam1", message);
        makeGameplayCommand("cam2", message);
        makeGameplayCommand("cam3", message);
        makeGameplayCommand("cam4", message);
        makeGameplayCommand("cam5", message);
        makeGameplayCommand("cam6", message);
        makeGameplayCommand("cam7", message);
        makeGameplayCommand("cam8", message);
        makeGameplayCommand("cam9", message);
        makeGameplayCommand("cam10", message);
        makeGameplayCommand("cam11", message);
        makeGameplayCommand("cam12", message);
        makeGameplayCommand("cam13", message);
        makeGameplayCommand("cam14", message);
        makeGameplayCommand("cam15", message);
        makeGameplayCommand("spooky", message);
        makeGameplayCommand("unspooky", message);

        // Check if the message is a command (customize this based on your needs)
    }

    public void makeGameplayCommand(String Command, String message) {
        if (message.equals("!" + Command)) {
            Fnafbot.writetoini(Command, 1);
        }
    }
}
