package core.basesyntax;

public class Entry<K, V> {
    private K key;
    private V value;

    public Entry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        Entry<K, V> entry = (Entry<K, V>) object;
        return (entry.getKey() == key
                || (entry.getKey() != null && entry.getKey().equals(key)))
                && (entry.getValue() == value
                || (entry.getValue() != null && entry.getValue().equals(value)));
    }

    public int hashCode() {
        return (key == null ? 0 : key.hashCode() << 16)
                & (value == null ? 0 : value.hashCode());
    }
}
