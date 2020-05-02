package com.thankson.common.util.utils;

public class CollectionUtils {
    public static boolean isEmpty(String[] strings){
        return strings==null||strings.length==0;
    }

    public static void main(String[] args) {
        String[] strings={};
        System.out.println(isEmpty(strings));
    }
}
