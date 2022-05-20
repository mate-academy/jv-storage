package core.basesyntax;

public class Pair<K, V> {
    private final K key;
    private V value;

    public Pair(K number, V value) {
        this.key = number;
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public boolean isEqualKeys(K key) {
        return (this.key == null ? 0 : this.key.hashCode())
                == (key == null ? 0 : key.hashCode());
    }
}

