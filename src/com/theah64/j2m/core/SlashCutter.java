package com.theah64.j2m.core;

/**
 * Created by theapache64 on 11/1/18.
 */
public class SlashCutter {
    public static String cut(String string) {
        if (string.contains("/")) {
            final String temp[] = string.split("/");
            return temp[temp.length - 1];
        }
        return string;
    }
}
