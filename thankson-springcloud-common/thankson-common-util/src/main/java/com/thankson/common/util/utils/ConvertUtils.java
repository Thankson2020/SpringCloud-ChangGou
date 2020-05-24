package com.thankson.common.util.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/**
 * 转换工具类
 *
 * @author Thankson
 * @date 2020年2月19日
 */
public class ConvertUtils {

    /**
     * 输入流转换为字符串
     *
     * @param inputStream 输入流
     * @return 字符串
     * @auhtor Thankson
     * @date 2020年2月19日
     */
    public static String convertToString(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }
        outSteam.close();
        inputStream.close();
        String result = new String(outSteam.toByteArray(), StandardCharsets.UTF_8);
        return result;
    }
}