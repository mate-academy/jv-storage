package core.basesyntax.impl;

public class KeyValuePair<K, V> {
    private final K key;
    private V value;

    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public KeyValuePair(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    @Override
    public boolean equals(Object pair) {
        if (this == pair) {
            return true;
        }
        if (pair == null || !pair.getClass().equals(KeyValuePair.class)) {
            return false;
        }
        KeyValuePair target = (KeyValuePair) pair;
        return (key == null) ? target.key == null : key.equals(target.key);
    }

    @Override
    public int hashCode() {
        return 31 * 17 + (key == null ? 0 : key.hashCode());
    }
}
