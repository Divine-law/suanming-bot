package com.example.Dao;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public interface suanming_dao {
    String qiangua = "1 1 1";
    String duigua = "0 1 1";
    String ligua = "1 0 1";
    String zhengua = "0 0 1";
    String xungua = "1 1 0";
    String kangua = "0 1 0";
    String gengua = "1 0 0";
    String kungua = "0 0 0";
    Map<Integer,String> guaxiang_map = new HashMap<Integer,String>(){
        {
            put(1,qiangua);
            put(2,duigua);
            put(3,ligua);
            put(4,zhengua);
            put(5,xungua);
            put(6,kangua);
            put(7,gengua);
            put(8,kungua);
            put(0,kungua);
        }
    };

    Map<String,String> guaming_map = new HashMap<String, String>(){
        {
            put(qiangua,"乾");
            put(duigua,"兑");
            put(ligua,"离");
            put(zhengua,"震");
            put(xungua,"巽");
            put(kangua,"坎");
            put(gengua,"艮");
            put(kungua,"坤");
        }
    };
    //以数字起卦
    public String[] qigua_shuzi(int shang,int xia);

    //变卦
    public String[] biangua_shuzi(String[] chu_gua,int dong_yao);

    //互卦
    public String[] hugua_shuzi(String[] chu_gua);

    //渲染阴爻
    public BufferedImage xuanran_yin(BufferedImage big,int x,int y);

    //渲染阳爻
    public BufferedImage xuanran_yang(BufferedImage big,int x,int y);

    //渲染文字
    public BufferedImage xuanran_font(BufferedImage big,int x,int y,String text);
}
