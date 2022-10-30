package org.fmt4j.formatter;

import java.io.PrintStream;
import java.util.Locale;

public class PrintStreamFormatter {
    private final PrintStream stream;

    public PrintStreamFormatter(PrintStream stream) {
        this.stream = stream;
    }

    public String print(String formatter, Object... args) {
        return print(Locale.getDefault(), formatter, args);
    }

    public String print(Locale locale, String formatter, Object... args) {
        final String message = Formatter.format(locale, formatter, args);
        stream.print(message);
        return message;
    }

    public String println(String formatter, Object... args) {
        return println(Locale.getDefault(), formatter, args);
    }

    public String println(Locale locale, String formatter, Object... args) {
        final String message = Formatter.format(locale, formatter, args);
        stream.println(message);
        return message;
    }
}
