package com.ace;

public class StringOperations {

    public static String reverseString( String s){
        char[] ch=s.toCharArray();
        StringBuffer sb= new StringBuffer();
        for (int i=ch.length-1;i>=0;i--){
            sb.append(ch[i]);
        }
        return sb.toString();
    }
}
