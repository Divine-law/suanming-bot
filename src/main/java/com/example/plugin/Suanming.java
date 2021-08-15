package com.example.plugin;

import com.example.controller.suanming_controller;
import net.mamoe.mirai.console.extension.PluginComponentStorage;
import net.mamoe.mirai.console.plugin.jvm.JavaPlugin;
import net.mamoe.mirai.console.plugin.jvm.JvmPluginDescriptionBuilder;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.MessageChain;
import net.mamoe.mirai.message.data.PlainText;
import org.jetbrains.annotations.NotNull;
import com.example.Dao.impl.*;

public class Suanming extends JavaPlugin {
    public static Suanming INSTANCE = new Suanming();
    private Suanming() {
        super(new JvmPluginDescriptionBuilder(
                        "com.example.plugin.Suanming", // 需要遵循语法规定，不知道写什么的话就写主类名吧
                        "1.0.0" // 同样需要遵循语法规定
                )
                .author("me")
                .name("Suanming")
                .info("新版本测试")
                .build()
        );
    }

    @Override
    public void onLoad(@NotNull PluginComponentStorage $this$onLoad) {

    }

    @Override
    public void onEnable() {
//        Bot bot = Bot.getInstance(3165063950L);
        GlobalEventChannel.INSTANCE.subscribeAlways(FriendMessageEvent.class, (FriendMessageEvent event) ->{
            event.getSender().sendMessage("喵");
        });

        GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent.class,(GroupMessageEvent event)->{
            MessageChain messageChain = event.getMessage();
            String message = messageChain.get(PlainText.Key).toString();
            String[] message_shuzu = message.split("\\s+");
            if(messageChain.size()<3&&message_shuzu[0].equals("起卦")&&message_shuzu.length==3){
                int[] shuzi = {Integer.parseInt(message_shuzu[1]), Integer.parseInt(message_shuzu[2])};
                suanming_impl suanming = new suanming_impl();
                suanming_controller suanmingController = new suanming_controller();
                suanmingController.guaxiang(event,shuzi);
            }


        });
    }
}