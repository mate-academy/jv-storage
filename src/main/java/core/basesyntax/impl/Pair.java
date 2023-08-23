package core.basesyntax.impl;

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

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (o.getClass().equals(Pair.class)) {
            Pair current = (Pair) o;
            return (key == current.key || key != null && key.equals(current.key))
                    && (value == current.value || value != null && value.equals(current.value));
        }

        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + ((key == null) ? 0 : key.hashCode());
        result = 31 * result + ((value == null) ? 0 : value.hashCode());
        return result;
    }
}
