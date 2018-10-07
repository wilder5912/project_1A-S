package com.storeArticle.store.service.validation;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationService {
    public static boolean isValidateTextComma(String textData){
        String exprecion= "'([^']*)";
        Pattern pattern = Pattern.compile(exprecion);
        Matcher matcher = pattern.matcher(textData);
        return matcher.find();
    }
}
