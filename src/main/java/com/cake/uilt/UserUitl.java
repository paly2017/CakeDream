package com.cake.uilt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserUitl {
    /**
     * MD5加密方法
     * @param password
     * @return
     */
    public static String encodeMD5(String password) throws
            NoSuchAlgorithmException {
        if (null==password){
            password="";
        }
        MessageDigest messageDigest=MessageDigest.getInstance("MD5");
        messageDigest.update(password.getBytes());
        byte [] bytes = messageDigest.digest();
        int i =0;
        StringBuffer stringBuffer = new StringBuffer(32);
        for (int offset=0 ;offset<bytes.length;offset++){
            i=bytes[offset];
            if (i<0){
                i+=256;
            }
            if (i<16){
                stringBuffer.append("0");
            }
            stringBuffer.append(Integer.toHexString(i));
        }
        return stringBuffer.toString();
    }

}
