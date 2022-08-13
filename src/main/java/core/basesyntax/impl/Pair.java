package core.basesyntax.impl;

class Pair<T1,T2> {
    private T1 key;
    private T2 value;

    public Pair(T1 key, T2 value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public int hashCode() {
        return 7 + 7 * (key == null ? 0 : key.hashCode())
                + 7 * (value == null ? 0 : value.hashCode());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Pair<T1, T2> pair = (Pair<T1, T2>) obj;
        return (key == pair.key || key != null && key.equals(pair.key))
                && (value == pair.value || value != null && value.equals(pair.value));
    }

    public T1 getKey() {
        return key;
    }

    public T2 getValue() {
        return value;
    }

    public void setValue(T2 value) {
        this.value = value;
    }
}
