package com.interviewbit.ironman.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class IronmanUtils {

    public static Gson getGson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }
}
