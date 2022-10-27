package org.fmt4j.element;

public class PlainElement implements Element {
    String text;

    public PlainElement(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
