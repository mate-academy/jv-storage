package core.basesyntax.impl;

public class Pair<T, V> {
    private T key;
    private V value;

    public Pair(T key, V value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (key != null ? this.key.hashCode() : 0);
        result = 31 * result + (value != null ? this.value.hashCode() : 0);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Pair<T, V> other = (Pair<T, V>) obj;

        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }

        if (value == null) {
            return other.value == null;
        } else {
            return value.equals(other.value);
        }
    }
}
