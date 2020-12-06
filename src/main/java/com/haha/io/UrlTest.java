package com.haha.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 直接从 URL 中读取字节流数据
 */
public class UrlTest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baidu.com");
        //字节流
        InputStream inputStream = url.openStream();
        //字符流
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
        //提供缓存功能
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        bufferedReader.close();
    }
}
