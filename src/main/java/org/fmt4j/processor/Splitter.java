package org.fmt4j.processor;

import org.fmt4j.element.Element;

import java.util.List;

public class Splitter {
    static final char LeftBracket = '{';
    static final char RightBracket = '}';

    String fmt;
    List<Object> args;

    public Splitter(String fmt, List<Object> args) {
        this.fmt = fmt;
        this.args = args;
    }

    List<Element> split() {
        return null;
    }
}
