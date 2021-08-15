package com.example.Dao.impl;

import com.example.Dao.suanming_dao;
import com.example.tools.biangua;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class suanming_impl implements suanming_dao {
    @Override
    public String[] qigua_shuzi(int shang, int xia) {
        int shanggua = shang%8;
        int xiagua = xia%8;
        String[] shang_gua = guaxiang_map.get(shanggua).split("\\s+");
        String[] xia_gua   = guaxiang_map.get(xiagua).split("\\s+");
        String chujiu = xia_gua[2];
        String erjiu = xia_gua[1];
        String sanjiu = xia_gua[0];
        String sijiu = shang_gua[2];
        String wujiu = shang_gua[1];
        String liujiu = shang_gua[0];
        String[] chu_gua = {chujiu,erjiu,sanjiu,sijiu,wujiu,liujiu};
        return chu_gua;
    }

    @Override
    public String[] biangua_shuzi(String[] chu_gua, int dong_yao) {
        String[] bian_gua = chu_gua;
        if(dong_yao==0){
            bian_gua[5] = biangua.biangua(bian_gua[5]);
        }else{
            int i = dong_yao-1;
            bian_gua[i] = biangua.biangua(bian_gua[i]);
        }
        return bian_gua;
    }

    @Override
    public String[] hugua_shuzi(String[] chu_gua) {
        String[] hu_gua = {chu_gua[1],chu_gua[2],chu_gua[3],chu_gua[2],chu_gua[3],chu_gua[4]};
        return hu_gua;
    }

    //渲染阴爻
    @Override
    public BufferedImage xuanran_yin(BufferedImage big, int x, int y) {
        BufferedImage small = null;
        try {
            small = ImageIO.read(new File("res/images/阴爻.png"));
//            small = ImageIO.read(new File("C:\\Users\\HP\\Pictures\\阴爻.png"));
            Graphics2D g =big.createGraphics();
            g.drawImage(small,x,y,small.getWidth(),small.getHeight(),null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return big;
    }

    //渲染阳爻
    @Override
    public BufferedImage xuanran_yang(BufferedImage big, int x, int y) {
        BufferedImage small = null;
        try {
            small = ImageIO.read(new File("res/images/阳爻.png"));
//            small = ImageIO.read(new File("C:\\Users\\HP\\Pictures\\阳爻.png"));
            Graphics2D g =big.createGraphics();
            g.drawImage(small,x,y,small.getWidth(),small.getHeight(),null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return big;
    }

    // 渲染文字
    @Override
    public BufferedImage xuanran_font(BufferedImage big, int x, int y, String text) {
        Graphics2D g = big.createGraphics();
        g.setColor(new Color(255,59,48));
        g.setFont(new Font("宋体",Font.PLAIN,40));
        try{
            g.drawString(text,x,y);
        }catch (Exception e){
            e.printStackTrace();
        }

        return big;
    }

}
