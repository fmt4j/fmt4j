package org.fmt4j.processor;

import org.fmt4j.parser.Parser;

public class Processor {
    static final public char LeftBracket = '{';
    static final public char RightBracket = '}';

    final String fmt;
    final Parser parser;

    public Processor(String fmt, Parser parser) {
        this.fmt = fmt;
        this.parser = parser;
    }

    public StringBuilder process() {
        StringBuilder builder = new StringBuilder();

        int offset = 0;
        while (offset < fmt.length()) {
            final int codePoint = fmt.codePointAt(offset);
            final int codePointCharCount = Character.charCount(codePoint);

            if (codePoint == (int) LeftBracket) {
                int nextOffset = offset + codePointCharCount;

                // check right bracket missing
                if (nextOffset >= fmt.length()) {
                    throw new IllegalArgumentException("Argument formatter close bracket missing");
                }

                int nextCodePoint = fmt.codePointAt(nextOffset);
                int nextCodePointCharCount = Character.charCount(nextCodePoint);

                // {{ escape
                if (nextCodePoint == (int) LeftBracket) {
                    builder.append(LeftBracket);
                    offset += codePointCharCount + nextCodePointCharCount;
                    continue;
                }

                // formatter field
                while (nextOffset < fmt.length() && nextCodePoint != (int) RightBracket) {
                    nextCodePoint = fmt.codePointAt(nextOffset);
                    nextCodePointCharCount = Character.charCount(nextCodePoint);
                    nextOffset += nextCodePointCharCount;
                }

                // check right bracket missing
                if (nextOffset >= fmt.length()) {
                    throw new IllegalArgumentException("Argument formatter close bracket missing");
                }

                builder.append(parser.parse(fmt.substring(offset + codePointCharCount, nextOffset)));
                offset = nextOffset;
            } else {
                builder.append(codePoint);
                offset += codePointCharCount;
            }
        }
        return builder;
    }
}
