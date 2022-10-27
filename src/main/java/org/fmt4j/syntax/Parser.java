package org.fmt4j.syntax;

import java.util.List;

public class Parser implements IParser {
    final List<Object> args;

    public Parser(List<Object> args) {
        this.args = args;
    }

    @Override
    public String parse(final String field) {
        return null;
    }
}
