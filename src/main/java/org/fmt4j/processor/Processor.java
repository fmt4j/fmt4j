package org.fmt4j.processor;

import java.util.IllegalFormatException;
import java.util.List;

public class Processor {
    static final char LeftBracket = '{';
    static final char RightBracket = '}';

    String fmt;
    List<Object> args;

    public Processor(String fmt, List<Object> args) {
        this.fmt = fmt;
        this.args = args;
    }

    public StringBuilder process() {
        StringBuilder builder = new StringBuilder();

        int offset = 0;
        while (offset < fmt.length()) {
            final int codePoint = fmt.codePointAt(offset);
            final int codePointCharCount = Character.charCount(codePoint);

            if (codePoint == (int) LeftBracket) {
                int nextOffset = offset + codePointCharCount;
                while (nextOffset < fmt.length() && fmt.codePointAt(nextOffset) != (int) RightBracket) {
                    final int nextCodePoint = fmt.codePointAt(nextOffset);
                    final int nextCodePointCharCount = Character.charCount(nextCodePoint);
                    nextOffset += nextCodePointCharCount;
                }
                if (nextOffset >= fmt.length()) {
                    throw new IllegalArgumentException("Argument fmt missing right bracket");
                }
            } else {
                builder.append(codePoint);
                offset += codePointCharCount;
            }
        }
        return builder;
    }
}
