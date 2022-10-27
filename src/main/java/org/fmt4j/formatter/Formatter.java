package org.fmt4j.formatter;

import java.util.Locale;
import java.util.Objects;

public class Formatter {
    public static String format(String fmt, Object... args) {
        return format(Locale.getDefault(), fmt, args);
    }

    public static String format(Locale locale, String fmt, Object... args) {
        validate(locale, fmt, args);
        return null;
    }

    public static String print(String fmt, Object... args) {
        return print(Locale.getDefault(), fmt, args);
    }

    public static String print(Locale locale, String fmt, Object... args) {
        validate(locale, fmt, args);
        return null;
    }

    public static String println(String fmt, Object... args) {
        return println(Locale.getDefault(), fmt, args);
    }

    public static String println(Locale locale, String fmt, Object... args) {
        validate(locale, fmt, args);
        return print(locale, fmt + "%n", args);
    }

    public static void validate(String fmt, Object... args) {
        validate(Locale.getDefault(), fmt, args);
    }

    public static void validate(Locale locale, String fmt, Object... args) {
        if (Objects.isNull(locale)) {
            throw new IllegalArgumentException("Parameter locale cannot be null");
        }
        if (Objects.isNull(fmt)) {
            throw new IllegalArgumentException("Parameter fmt cannot be null");
        }
    }
}
