package org.fmt4j.parser;

import java.util.List;

public class SyntaxParser implements Parser {
    final List<Object> args;

    public SyntaxParser(List<Object> args) {
        this.args = args;
    }

    @Override
    public String parse(final String field) {
        return null;
    }
}
