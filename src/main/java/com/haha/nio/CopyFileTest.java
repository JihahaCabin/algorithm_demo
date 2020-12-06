package com.haha.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class CopyFileTest {

    public static void main(String[] args) throws IOException {
        String srcPath = "";
        String destPath = "";
        fastCopy(srcPath, destPath);
    }

    public static void fastCopy(String src, String dest) throws IOException {
        //获取源文件输入字节流
        FileInputStream fileInputStream = new FileInputStream(src);
        //获取输入字节流的文件通道
        FileChannel channelInput = fileInputStream.getChannel();
        //获取目的文件输出字节流
        FileOutputStream fileOutputStream = new FileOutputStream(dest);
        //获取输出字节流的文件通道
        FileChannel channelOutput = fileOutputStream.getChannel();
        // 为缓冲区分配1024个字节
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        while (true) {
            //从输入通道读取数据到缓冲区
            int read = channelInput.read(byteBuffer);

            //read()返回-1表示EOF
            if (read == -1) {
                break;
            }

            //切换读写
            byteBuffer.flip();

            //把缓冲区的内容写入到输出文件中
            channelOutput.write(byteBuffer);

            //清空缓冲区
            byteBuffer.clear();
        }


    }

}
