package core.basesyntax.impl;

class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public K getKey() {
        return key;
    }

    public int hashCode() {
        return 31 * (key == null ? 0 : key.hashCode())
                + 17 * (value == null ? 0 : value.hashCode());
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Pair<K, V> pair = (Pair<K, V>) obj;
        return (pair.getKey() == key
                || (pair.getKey() != null && pair.getKey().equals(key)))
                && (pair.getValue() == value
                || (pair.getValue() != null && pair.getValue().equals(value)));
    }
}
