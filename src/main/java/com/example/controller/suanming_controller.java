package com.example.controller;

import com.example.Dao.impl.peizhuang_impl;
import com.example.Dao.impl.suanming_impl;
import com.example.tools.biangua;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.Image;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class suanming_controller {
    public void guaxiang(GroupMessageEvent event, int[] shuzi){

        BufferedImage big = null;
        try {
            //获取背景图片
//            File file = new File("res/images/test.png");
            File file = new File("res/images/test.png");
            big = ImageIO.read(file);
            suanming_impl suanmingImpl = new suanming_impl();
            //渲染本卦、互卦、变卦的文字
            suanmingImpl.xuanran_font(big,108,100,"本卦");
            suanmingImpl.xuanran_font(big,313,100,"互卦");
            suanmingImpl.xuanran_font(big,518,100,"变卦");
            String[] chu_gua = suanmingImpl.qigua_shuzi(shuzi[0],shuzi[1]);
            // 渲染初卦图像
            for(int i = 0;i<chu_gua.length;i++){
                if(chu_gua[i].equals("1")){
                    suanmingImpl.xuanran_yang(big,100,(225-(i*20)));
                }else{
                    suanmingImpl.xuanran_yin(big,100,(225-(i*20)));
                }
            }
            String[] hu_gua = suanmingImpl.hugua_shuzi(chu_gua);
            // 渲染互卦图像
            for(int i = 0;i<hu_gua.length;i++){
                if(hu_gua[i].equals("1")){
                    suanmingImpl.xuanran_yang(big,305,(225-(i*20)));
                }else{
                    suanmingImpl.xuanran_yin(big,305,(225-(i*20)));
                }
            }
            String chu_gua_s = biangua.zhuanhuan(chu_gua);
            int dong_yao = (shuzi[0]+shuzi[1])%6;
            //渲染体卦与用卦的文字
            if(dong_yao>3||dong_yao==0){
                suanmingImpl.xuanran_font(big,5,157,"用卦");
                suanmingImpl.xuanran_font(big,5,233,"体卦");
            }else{
                suanmingImpl.xuanran_font(big,5,157,"体卦");
                suanmingImpl.xuanran_font(big,5,233,"用卦");
            }
            String[] bian_gua = suanmingImpl.biangua_shuzi(chu_gua,dong_yao);
            //渲染变卦图像
            for(int i = 0;i<bian_gua.length;i++){
                if(bian_gua[i].equals("1")){
                    suanmingImpl.xuanran_yang(big,510,(225-(i*20)));
                }else{
                    suanmingImpl.xuanran_yin(big,510,(225-(i*20)));
                }
            }
            String data = String.valueOf(new Date().getTime());
            String file_name = "res/images/jieguo/"+String.valueOf(event.getGroup().getId())+data;
            ImageIO.write(big,"png",new File(file_name));
            peizhuang_impl peizhuang_impl = new peizhuang_impl();
            Image gua = peizhuang_impl.peizhuang(event,file_name);
            String bian_gua_s = biangua.zhuanhuan(bian_gua);
            String hu_gua_s = biangua.zhuanhuan(hu_gua);
            String gua_message = "本卦：" + chu_gua_s+"\n"
                    +"互卦：" + hu_gua_s + "\n"
                    +"动爻：" + dong_yao + "\n"
                    +"变卦：" + bian_gua_s;

            event.getSubject().sendMessage(gua);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
