package com.example.educarcasamobile;

import java.util.regex.Pattern;

/**
 * Created by Luiz Romario Filho on 12/13/2014.
 */
public class Util {
    public static String URL_WEBSERVICE = "http://10.0.3.2/EducarEmCasa";
//    public static String URL_WEBSERVICE = "http://10.0.3.2:8080/TraducaoColaborativa/rest";

    public static Boolean validate(String email) {
        return Pattern.matches("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})$", email);
    }

    public static Boolean isNotNull(String value) {
        return null != value && !"".equalsIgnoreCase(value.trim());
    }
}
