package core.basesyntax;

public class Pair<K,V> {
    private V value;
    private K key;

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

    public int hashCode() {
        int result = 17;
        result = 31 * result + (value == null ? 0 : value.hashCode());
        result = 31 * result + (key == null ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair<K, V> pair = (Pair<K, V>) o;
        return (value == pair.value && key == pair.key || value != null && key != null
                && value.equals(pair.value) && key.equals(pair.key));
    }
}
