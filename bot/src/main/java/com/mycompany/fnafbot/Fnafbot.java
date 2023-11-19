/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.fnafbot;

import org.ini4j.*;
import java.io.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.events.message.*;
import net.dv8tion.jda.api.requests.GatewayIntent;
/**
 *
 * @author yourf
 */
public class Fnafbot {

    public Fnafbot() {
        JDA api = JDABuilder.createDefault("your token here")
                .addEventListeners(new ListenerAdapter() {
                    @Override
                    public void onMessageReceived(MessageReceivedEvent event) {
                        String cams = "!cams";
                        String message = event.getMessage().getContentDisplay();
                        String channel = event.getChannel().getId();
                        TextChannel thischannel = event.getJDA().getTextChannelById(channel);
                        if ((channel.equals("")) || (channel.equals("")) || (channel.equals("")) || (channel.equals(""))) {

                            if (message.equals(cams)) {
                                writetoini("camup", 1);
                                writetoini("camdown", 1);
                            }
                            if (message.equals("!right")) {
                                writetoini("goright", 1);
                            }
                            if (message.equals("!left")) {
                                writetoini("goleft", 1);
                            }
                            if (message.equals("!start")) {
                                writetoinialt("start", 1);
                            }
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
                            if (message.equals("!commands")) {
                                thischannel.sendMessage("""
                                                        The bot currently supports the following gameplay commands: 
                                                        !start
                                                        !right
                                                        !left
                                                        !cams
                                                        !cam1
                                                        !cam2
                                                        !cam3
                                                        !cam4
                                                        !cam5
                                                        !cam6
                                                        !cam7
                                                        !cam8
                                                        !cam9
                                                        !cam10
                                                        !cam11
                                                        !cam12
                                                        !cam13
                                                        !cam14
                                                        !cam15
                                                        !panelup
                                                        !paneldown
                                                        !audio
                                                        !video
                                                        !vent
                                                        !all
                                                        !mute
                                                        !lure
                                                        !mapvent
                                                        !seal10
                                                        !seal11
                                                        !seal12
                                                        !seal13
                                                        !seal14
                                                        !seal15
                                                        there may be a few more commands not listed for fun, try and figure out what they are!""").queue();
                            }
                        }

                    }

                }).enableIntents(GatewayIntent.MESSAGE_CONTENT).build();
    }

    public static void main(String[] args) {
        Fnafbot bot = new Fnafbot();
        try {
            TwitchBot twitchbot = new TwitchBot();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static Object parseini(String inifield) {
        String user = System.getProperty("user.name");
        String filePath = "C:\\Users\\" + user
                + "\\AppData\\Roaming\\MMFApplications\\fnafini";

        try {
            // Parse the INI file
            Ini ini = new Ini();
            ini.load(new FileInputStream(filePath));
            Object value = ini.get("freddy3", inifield);

            // Get the value of the "camup" field from the "freddy3" section
            // Print the value of the "camup" field
            return value;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void writetoinialt(String inifield, int value) {
        String user = System.getProperty("user.name");
        String filePath = "C:\\Users\\" + user
                + "\\AppData\\Roaming\\MMFApplications\\freddy3";
        try {
            Wini ini = new Wini(new File(filePath));
            ini.put("freddy3", inifield, value);
            ini.store();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writetoini(String inifield, int value) {
        String user = System.getProperty("user.name");
        String filePath = "C:\\Users\\" + user
                + "\\AppData\\Roaming\\MMFApplications\\fnafini";
        try {
            Wini ini = new Wini(new File(filePath));
            ini.put("fnafini", inifield, value);
            ini.store();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void makeGameplayCommand(String command, String message) {
        if (message.equals("!" + command)) {
            writetoini(command, 1);
        }
    }
}
