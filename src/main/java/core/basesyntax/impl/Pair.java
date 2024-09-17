package core.basesyntax.impl;

public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public boolean equals(Pair pair) {
        if (this == pair) {
            return true;
        }

        if (pair == null || this.getClass() != pair.getClass()) {
            return false;
        }

        Pair current = (Pair) pair;
        if ((key == null && current.key == null)
                && (value == null && current.value == null)) {
            return true;
        }

        if (key == null || current.key == null) {
            return false;
        }

        if (value == null || current.value == null) {
            return false;
        }

        return this.key.equals(current.key);
    }

    @Override
    public int hashCode() {
        int result = key.hashCode();
        result = 31 * result + value.hashCode();
        return result;
    }

}
