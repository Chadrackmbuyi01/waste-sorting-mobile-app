package com.environ.assessment.grad001.chadrack_mbuyi_kalala.waste_sorting_mobile_app.helper;

import org.springframework.util.StringUtils;

import java.util.UUID;

public class Helper {

    public static String generateID(){
        return UUID.randomUUID().toString();
    }

    public static boolean isEmptyOrNull(String str){
        return StringUtils.isEmpty(str);
    }

    public static String emptyIfNull(String str){
        if(isEmptyOrNull(str))
            return "";
        return str;
    }

    public static void checkStringParameter(String param, String value){
        if(isEmptyOrNull(param))
            throw new IllegalArgumentException(param + " is null or empty");
    }

}
