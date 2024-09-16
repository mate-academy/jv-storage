package core.basesyntax.impl;

class Pair<K, V> {
    private final K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    // it may be a good idea of not providing setKey() method
    //    public void setKey(K key) {
    //        this.key = key;
    //    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Pair<?, ?> pair = (Pair<?, ?>) o;

        if (!((key == pair.key) || (key != null && key.equals(pair.key)))) {
            return false;
        }

        return (value == pair.value) || (value != null && value.equals(pair.value));
    }

    @Override
    public int hashCode() {
        int result = key != null ? key.hashCode() : 0;
        result = 31 * result + (value != null ? value.hashCode() : 0);
        return result;
    }
}
