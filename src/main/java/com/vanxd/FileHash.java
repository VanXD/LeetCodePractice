package com.vanxd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.security.MessageDigest;
import java.util.Scanner;

/**
 * File HASH
 */
public class FileHash {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入两个文件的绝对或相对路径，以空格分割");
        String path1 = in.next();
        String path2 = in.next();

        String md5A = getMd5ByFile(new File(path1));
        String md5B = getMd5ByFile(new File(path2));
        System.out.println("第一个文件的MD5: " + md5A);
        System.out.println("第二个文件的MD5: " + md5B);
        String tip = "不相同";
        if ( md5A.equals(md5B) ) {
            tip = "相同";
        }
        System.out.println("两个文件" + tip + "！");
    }

    public static String getMd5ByFile(File file) throws FileNotFoundException {
        String value = null;
        FileInputStream in = new FileInputStream(file);
        try {
            MappedByteBuffer byteBuffer = in.getChannel().map(FileChannel.MapMode.READ_ONLY, 0, file.length());
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(byteBuffer);
            BigInteger bi = new BigInteger(1, md5.digest());
            value = bi.toString(16);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return value;
    }
}

