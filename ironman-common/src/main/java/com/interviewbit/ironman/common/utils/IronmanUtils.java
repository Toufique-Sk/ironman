package com.interviewbit.ironman.common.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class IronmanUtils {

    public static Gson getGson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.create();
    }
    public static String passwordHashFunction(String password){
        Long hashedPassword = Long.valueOf(password.hashCode() * 13 * password.hashCode());
        return String.valueOf(hashedPassword * password.hashCode() * 25);
    }
}
