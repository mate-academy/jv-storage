package core.basesyntax.model;

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

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair<?, ?> pair = (Pair<?, ?>) o;
        boolean keyEquals = (this.key == pair.key)
                              || (this.key != null && this.key.equals(pair.key));
        boolean valueEquals = (this.value == pair.value)
                              || (this.value != null && this.value.equals(pair.value));
        return keyEquals && valueEquals;
    }

    @Override
    public int hashCode() {
        int result = 17;
        if (key != null) {
            result = 31 * result + key.hashCode();
        }
        if (value != null) {
            result = 31 * result + value.hashCode();
        }
        return result;
    }
}
