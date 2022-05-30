package core.basesyntax.impl;

public class GetSize {
    private Object[] values;

    public GetSize(Object[] values) {
        this.values = values;
    }

    public int size() {
        return getSize();
    }

    private int getSize() {
        int size = 0;
        for (Object obj : values) {
            if (obj != null) {
                size++;
            }
        }
        return size;
    }
}
