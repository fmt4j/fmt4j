package org.fmt4j.element;

public class FormatElement implements Element {
    String formatter;
    Object arg;

    public FormatElement(String formatter, Object arg) {
        this.formatter = formatter;
        this.arg = arg;
    }

    @Override
    public String toString() {
        return null;
    }
}
