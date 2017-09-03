package com.ithwong.common.utils;

import sun.misc.BASE64Encoder;

import java.security.MessageDigest;

/**
 * @Description 加密工具类
 * Created by Harry on 2017/6/20.
 */
public class EncriptUtil {

    public static String Md5Encoder(String string) {

        try {

            //确定计算方法
            MessageDigest md5=MessageDigest.getInstance("MD5");
            BASE64Encoder base64en = new BASE64Encoder();
            //加密后的字符串
            String newstr=base64en.encode(md5.digest(string.getBytes("utf-8")));
            return newstr;

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("加密错误！");
        }

    }

    public static void main(String[] args) {



        System.out.println(Md5Encoder("123456"));
    }

}
