package mirai;

import com.example.Dao.impl.suanming_impl;
import com.example.controller.suanming_controller;
import net.mamoe.mirai.Bot;
import net.mamoe.mirai.BotFactory;
import net.mamoe.mirai.event.GlobalEventChannel;
import net.mamoe.mirai.event.events.FriendMessageEvent;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.MessageChainBuilder;
import net.mamoe.mirai.message.data.QuoteReply;
import net.mamoe.mirai.utils.BotConfiguration;

public class RunMirai {
    public static void main(String[] args) {
        Bot bot = BotFactory.INSTANCE.newBot(123456, "password");
//        bot.login();
    }
    public static void afterLogin(Bot bot) {
        long yourQQNumber = 3165063950L;
        bot.getEventChannel().subscribeAlways(FriendMessageEvent.class, (event) -> {
            if (event.getSender().getId() == yourQQNumber) {
                event.getSubject().sendMessage(new MessageChainBuilder()
                        .append(new QuoteReply(event.getMessage()))
                        .append("Hi, you just said: '")
                        .append(event.getMessage())
                        .append("'")
                        .build()
                );
            }
        });
    }
    public static void onEnable() {
//        Bot bot = Bot.getInstance(3165063950L);
        GlobalEventChannel.INSTANCE.subscribeAlways(FriendMessageEvent.class, (FriendMessageEvent event) ->{
            event.getSender().sendMessage("喵");
        });

        GlobalEventChannel.INSTANCE.subscribeAlways(GroupMessageEvent.class,(GroupMessageEvent event)->{
            String message = event.getMessage().contentToString();
            String[] message_shuzu = message.split("\\s+");
            int[] shuzi = {Integer.parseInt(message_shuzu[1]), Integer.parseInt(message_shuzu[2])};
            suanming_impl suanming = new suanming_impl();
            if (message_shuzu[0].equals("起卦")){
//                String guaxiang_message = suanming.qigua_shuzi(shuzi[0],shuzi[1]);
//                event.getSubject().sendMessage(guaxiang_message);
                suanming_controller suanmingController = new suanming_controller();
                suanmingController.guaxiang(event,shuzi);
            }
        });
    }
}



class WithConfiguration1 {

    public static void main(String[] args) {
        // 使用自定义配置
        Bot bot = BotFactory.INSTANCE.newBot(3165063950L, "zdszdmm12138", new BotConfiguration() {{
            fileBasedDeviceInfo("C:\\Users\\HP\\Desktop\\mcl-1.0.3\\bots\\3165063950\\device.json"); // 使用 device.json 存储设备信息
//            setProtocol(MiraiProtocol.ANDROID_PAD); // 切换协议
        }});
        bot.login();
//        RunMirai.afterLogin(bot);
//        RunMirai.onEnable();
    }
}