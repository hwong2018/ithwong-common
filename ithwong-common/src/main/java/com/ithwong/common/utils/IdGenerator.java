package com.ithwong.common.utils;

import java.util.UUID;

/**
 * Created by Harry on 2017/7/31.
 */
public class IdGenerator {

    /**
     * @description 创建一个新的UUID(不带下划线的)
     */
    public static String getUUID() {
        return UUID.randomUUID().toString().replaceAll("_","").replaceAll("-","");
    }
}
