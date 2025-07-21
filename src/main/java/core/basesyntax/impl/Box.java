package core.basesyntax.impl;

public class Box<T> {
    private T content;

    public Box() {
    }

    public Box(T content) {
        this.content = content;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Box{" + "content=" + content + '}';
    }
}
