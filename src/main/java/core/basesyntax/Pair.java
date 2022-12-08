package core.basesyntax;

@SuppressWarnings("unchecked")
public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public boolean equals(Object pair) {
        if (pair == this) {
            return true;
        }
        if (pair == null) {
            return false;
        }
        if (pair.getClass().equals(Pair.class)) {
            Pair<K, V> current = (Pair<K, V>) pair;
            return (key != null ? this.key.equals(current.key) : key == current.key)
                    && (value != null ? this.value.equals(current.value) : value == current.value);
        }
        return false;
    }

    public int hashCode() {
        int result = 17;
        result = 31 * result + (key == null ? 0 : key.hashCode());
        result = 31 * result + (value == null ? 0 : value.hashCode());

        return result;
    }
}
