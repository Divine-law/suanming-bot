package com.example.Dao.impl;

import com.example.Dao.peizhuang_dao;
import net.mamoe.mirai.event.events.GroupMessageEvent;
import net.mamoe.mirai.message.data.Image;
import net.mamoe.mirai.utils.ExternalResource;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class peizhuang_impl implements peizhuang_dao {

    @Override
    public Image peizhuang(GroupMessageEvent event, String filename) {
        ExternalResource externalResource = ExternalResource.create(new File(filename));
        Image image = event.getSubject().uploadImage(externalResource);
        try {
            externalResource.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    public Image peizhuang(GroupMessageEvent event, InputStream inputStream){
        ExternalResource externalResource = null;
        try {
            externalResource = ExternalResource.create(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image image = event.getSubject().uploadImage(externalResource);
        return image;
    }
//
//    @Override
//    public Image jiancun(GroupMessageEvent event) {
//        String filename = "data/配装/剑纯.png";
//        File file = new File(filename);
//        ExternalResource externalResource = ExternalResource.create(file);
//        Image image = event.getSubject().uploadImage(externalResource);
//        try{
//            externalResource.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return image;
//    }
//
//    @Override
//    public Image bx(GroupMessageEvent event) {
//        String filename = "data/配装/冰心.png";
//        File file = new File(filename);
//        ExternalResource externalResource = ExternalResource.create(file);
//        Image image = event.getSubject().uploadImage(externalResource);
//        try{
//            externalResource.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return image;
//    }
//
//    @Override
//    public Image naixiu(GroupMessageEvent event) {
//        String filename = "data/配装/奶秀.png";
//        File file = new File(filename);
//        ExternalResource externalResource = ExternalResource.create(file);
//        Image image = event.getSubject().uploadImage(externalResource);
//        try{
//            externalResource.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return image;
//    }
//
//    @Override
//    public Image mowen(GroupMessageEvent event) {
//        String filename = "data/配装/莫问.png";
//        File file = new File(filename);
//        ExternalResource externalResource = ExternalResource.create(file);
//        Image image = event.getSubject().uploadImage(externalResource);
//        try{
//            externalResource.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return image;
//    }
//
//    @Override
//    public Image naige(GroupMessageEvent event) {
//        String filename = "data/配装/奶歌.png";
//        File file = new File(filename);
//        ExternalResource externalResource = ExternalResource.create(file);
//        Image image = event.getSubject().uploadImage(externalResource);
//        try{
//            externalResource.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return image;
//    }
//
//    @Override
//    public Image yijinjing(GroupMessageEvent event) {
//        String filename = "data/配装/易筋经.png";
//        File file = new File(filename);
//        ExternalResource externalResource = ExternalResource.create(file);
//        Image image = event.getSubject().uploadImage(externalResource);
//        try{
//            externalResource.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return image;
//    }
//
//    @Override
//    public Image xishuijing(GroupMessageEvent event) {
//        String filename = "data/配装/洗髓经.png";
//        File file = new File(filename);
//        ExternalResource externalResource = ExternalResource.create(file);
//        Image image = event.getSubject().uploadImage(externalResource);
//        try{
//            externalResource.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return image;
//    }
//
//    @Override
//    public Image huajian(GroupMessageEvent event) {
//        String filename = "data/配装/花间.png";
//        File file = new File(filename);
//        ExternalResource externalResource = ExternalResource.create(file);
//        Image image = event.getSubject().uploadImage(externalResource);
//        try{
//            externalResource.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return image;
//    }
//
//    @Override
//    public Image naihua(GroupMessageEvent event) {
//        String filename = "data/配装/奶花.png";
//        File file = new File(filename);
//        ExternalResource externalResource = ExternalResource.create(file);
//        Image image = event.getSubject().uploadImage(externalResource);
//        try{
//            externalResource.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return image;
//    }
//
//    @Override
//    public Image dujing(GroupMessageEvent event) {
//        String filename = "data/配装/毒经.png";
//        File file = new File(filename);
//        ExternalResource externalResource = ExternalResource.create(file);
//        Image image = event.getSubject().uploadImage(externalResource);
//        try{
//            externalResource.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return image;
//    }
//
//    @Override
//    public Image naidu(GroupMessageEvent event) {
//        String filename = "data/配装/奶毒.png";
//        File file = new File(filename);
//        ExternalResource externalResource = ExternalResource.create(file);
//        Image image = event.getSubject().uploadImage(externalResource);
//        try{
//            externalResource.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return image;
//    }
//
//    @Override
//    public Image aoxue(GroupMessageEvent event) {
//        String filename = "data/配装/傲血战意.png";
//        File file = new File(filename);
//        ExternalResource externalResource = ExternalResource.create(file);
//        Image image = event.getSubject().uploadImage(externalResource);
//        try{
//            externalResource.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return image;
//    }
//
//    @Override
//    public Image tielao(GroupMessageEvent event) {
//        String filename = "data/配装/铁牢律.png";
//        File file = new File(filename);
//        ExternalResource externalResource = ExternalResource.create(file);
//        Image image = event.getSubject().uploadImage(externalResource);
//        try{
//            externalResource.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return image;
//    }
//
//    @Override
//    public Image fenshanjing(GroupMessageEvent event) {
//        String filename = "data/配装/分山劲.png";
//        File file = new File(filename);
//        ExternalResource externalResource = ExternalResource.create(file);
//        Image image = event.getSubject().uploadImage(externalResource);
//        try{
//            externalResource.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return image;
//    }
//
//    @Override
//    public Image tieguyi(GroupMessageEvent event) {
//        String filename = "data/配装/铁骨衣.png";
//        File file = new File(filename);
//        ExternalResource externalResource = ExternalResource.create(file);
//        Image image = event.getSubject().uploadImage(externalResource);
//        try{
//            externalResource.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return image;
//    }
//
//    @Override
//    public Image fenying(GroupMessageEvent event) {
//        String filename = "data/配装/焚影圣决.png";
//        File file = new File(filename);
//        ExternalResource externalResource = ExternalResource.create(file);
//        Image image = event.getSubject().uploadImage(externalResource);
//        try{
//            externalResource.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return image;
//    }
//
//    @Override
//    public Image mingzun(GroupMessageEvent event) {
//        String filename = "data/配装/明尊琉璃体.png";
//        File file = new File(filename);
//        ExternalResource externalResource = ExternalResource.create(file);
//        Image image = event.getSubject().uploadImage(externalResource);
//        try{
//            externalResource.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return image;
//    }
//
//    @Override
//    public Image jingyu(GroupMessageEvent event) {
//        String filename = "data/配装/惊羽诀.png";
//        File file = new File(filename);
//        ExternalResource externalResource = ExternalResource.create(file);
//        Image image = event.getSubject().uploadImage(externalResource);
//        try{
//            externalResource.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return image;
//    }
//
//    @Override
//    public Image tianluo(GroupMessageEvent event) {
//        String filename = "data/配装/天罗诡道.png";
//        File file = new File(filename);
//        ExternalResource externalResource = ExternalResource.create(file);
//        Image image = event.getSubject().uploadImage(externalResource);
//        try{
//            externalResource.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return image;
//    }
//
//    @Override
//    public Image badao(GroupMessageEvent event) {
//        String filename = "data/配装/霸刀.png";
//        File file = new File(filename);
//        ExternalResource externalResource = ExternalResource.create(file);
//        Image image = event.getSubject().uploadImage(externalResource);
//        try{
//            externalResource.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return image;
//    }
//
//    @Override
//    public Image cangjian(GroupMessageEvent event) {
//        String filename = "data/配装/藏剑.png";
//        File file = new File(filename);
//        ExternalResource externalResource = ExternalResource.create(file);
//        Image image = event.getSubject().uploadImage(externalResource);
//        try{
//            externalResource.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return image;
//    }
//
//    @Override
//    public Image lingxue(GroupMessageEvent event) {
//        String filename = "data/配装/凌雪阁.png";
//        File file = new File(filename);
//        ExternalResource externalResource = ExternalResource.create(file);
//        Image image = event.getSubject().uploadImage(externalResource);
//        try{
//            externalResource.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return image;
//    }
//
//    @Override
//    public Image yantian(GroupMessageEvent event) {
//        String filename = "data/配装/衍天宗.png";
//        File file = new File(filename);
//        ExternalResource externalResource = ExternalResource.create(file);
//        Image image = event.getSubject().uploadImage(externalResource);
//        try{
//            externalResource.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return image;
//    }
//
//    @Override
//    public Image penglai(GroupMessageEvent event) {
//        String filename = "data/配装/蓬莱.png";
//        File file = new File(filename);
//        ExternalResource externalResource = ExternalResource.create(file);
//        Image image = event.getSubject().uploadImage(externalResource);
//        try{
//            externalResource.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return image;
//    }
//
//    @Override
//    public Image gaibang(GroupMessageEvent event) {
//        String filename = "data/配装/丐帮.png";
//        File file = new File(filename);
//        ExternalResource externalResource = ExternalResource.create(file);
//        Image image = event.getSubject().uploadImage(externalResource);
//        try{
//            externalResource.close();
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//        return image;
//    }
}
