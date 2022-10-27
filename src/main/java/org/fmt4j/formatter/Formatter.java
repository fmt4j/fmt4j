package org.fmt4j.formatter;

import java.util.Locale;

public class Formatter {
    public static String format(String fmt, Object... args) {
        return null;
    }

    public static String format(Locale locale, String fmt, Object... args) {
        return null;
    }

    public static String print(String fmt, Object... args) {
        return null;
    }

    public static String print(Locale locale, String fmt, Object... args) {
        return null;
    }

    public static String println(String fmt, Object... args) {
        return print(fmt + "%n", args);
    }

    public static String println(Locale locale, String fmt, Object... args) {
        return print(locale, fmt + "%n", args);
    }
}
