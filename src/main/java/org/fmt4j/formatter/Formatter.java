package org.fmt4j.formatter;

import org.fmt4j.processor.Processor;
import org.fmt4j.parser.Parser;
import org.fmt4j.parser.SyntaxParser;

import java.util.List;
import java.util.Locale;

public class Formatter {
    public static final PrintStreamFormatter out = new PrintStreamFormatter(System.out);
    public static final PrintStreamFormatter err = new PrintStreamFormatter(System.err);

    public static String format(String formatter, Object... args) {
        return format(Locale.getDefault(), formatter, args);
    }

    public static String format(Locale locale, String formatter, Object... args) {
        Validator.validate(locale, formatter, args);
        final Parser parser = new SyntaxParser(List.of(args));
        final Processor processor = new Processor(formatter, parser);
        final StringBuilder builder = processor.process();
        return builder.toString();
    }
}
