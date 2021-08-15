package com.example.tools;

import static com.example.Dao.suanming_dao.guaming_map;

public class biangua {
    public static String biangua(String gua_yao){
        if (gua_yao.equals("0")){
            return "1";
        }else if(gua_yao.equals("1")){
            return "0";
        }else{
            return null;
        }
    }

    public static String zhuanhuan(String[] guaxiang){
        String chujiu = guaxiang[0];
        String erjiu = guaxiang[1];
        String sanjiu = guaxiang[2];
        String sijiu = guaxiang[3];
        String wujiu = guaxiang[4];
        String liujiu = guaxiang[5];
        String shang_gua = liujiu+" "+wujiu+" "+sijiu;
        String xia_gua = sanjiu+" "+erjiu+" "+chujiu;
        String s_gua = guaming_map.get(shang_gua);
        String x_gua = guaming_map.get(xia_gua);
        String gua = guaming_map.get(shang_gua)+"上"+guaming_map.get(xia_gua)+"下";
        return gua;
    }
}
