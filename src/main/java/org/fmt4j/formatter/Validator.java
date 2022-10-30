package org.fmt4j.formatter;

import java.util.Locale;
import java.util.Objects;

class Validator {
    static void validate(String formatter, Object... args) {
        validate(Locale.getDefault(), formatter, args);
    }

    static void validate(Locale locale, String formatter, Object... args) {
        if (Objects.isNull(locale)) {
            throw new IllegalArgumentException("Argument locale cannot be null");
        }
        if (Objects.isNull(formatter)) {
            throw new IllegalArgumentException("Argument formatter cannot be null");
        }
    }
}
