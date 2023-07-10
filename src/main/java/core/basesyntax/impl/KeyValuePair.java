package core.basesyntax.impl;

public class KeyValuePair<K, V> {
    private final K key;
    private V value;

    public KeyValuePair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public boolean equalsByKey(K key) {
        return (this.key == null) ? key == null : this.key.equals(key);
    }

    public void setValue(V value) {
        this.value = value;
    }

    public V getValue() {
        return value;
    }
}
