package com.ycj.util;


import com.google.common.collect.MultimapBuilder;
import org.apache.commons.collections.map.MultiKeyMap;
import org.apache.commons.collections.map.MultiValueMap;

import java.io.IOException;

public class ProcessUtil {

    public static void createProcess() {

        ProcessBuilder processBuilder = new ProcessBuilder();

        processBuilder.command("cmd");
        try {
            Process process = processBuilder.start();
            System.out.println(process.exitValue());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {

        MultiValueMap multiValueMap = new MultiValueMap();
        MultiKeyMap multiKeyMap = new MultiKeyMap();
        String str = "你好";
        String test = str.intern();
        System.out.println(test==str);
        System.out.println("java8"==str);


    }


}
