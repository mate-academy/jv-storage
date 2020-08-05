package core.basesyntax;

public class Pair<K, V> {
    private static final int HASHCODE_NUMBER = 31;
    private K key;
    private V value;

    private Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public static <K, V> Pair<K, V> of(K first, V second) {
        return new Pair<>(first, second);
    }

    public K getKey() {
        return key;
    }

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
        if (o == null) {
            return false;
        }
        if (!(o.getClass().equals(Pair.class))) {
            return false;
        }
        Pair<K, V> pair = (Pair<K, V>) o;
        return (key != null && key.equals(pair.key) || key == pair.key)
                && (value != null && value.equals(pair.value) || (value == pair.value));
    }

    @Override
    public int hashCode() {
        int result = 17;
        result *= HASHCODE_NUMBER + (key != null ? key.hashCode() : 0);
        result *= HASHCODE_NUMBER + (value != null ? value.hashCode() : 0);
        return result;
    }
}
