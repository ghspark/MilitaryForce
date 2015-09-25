package com.gh.app.militaryforce.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by gaohang on 15/9/25.
 */
public class StringUtils {

    public static String replaceBlank(String str) {
        String dest = "";
        if (str != null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }
}
