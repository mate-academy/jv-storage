package core.basesyntax;

@SuppressWarnings("unchecked")
public class Pair<K, V> {
    private final K key;
    private final V value;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair<K, V> pair = (Pair<K, V>) o;
        return (getKey() == pair.getKey() || getKey() != null
                && getKey().equals(pair.getKey()))
                && (getValue() == pair.getValue() || getValue() != null
                && getValue().equals(pair.getValue()));
    }

    @Override
    public int hashCode() {
        return (getKey() == null ? 0 : getKey().hashCode() / 7)
                + (getValue() == null ? 0 : getValue().hashCode() / 7);
    }
}
