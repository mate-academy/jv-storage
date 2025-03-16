package core.basesyntax.impl;

public class Preserved<K, V> {
    private K key;
    private V value;

    public Preserved(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public V getValue() {
        return value;
    }

    public K getKey() {
        return key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null) {
            return false;
        }

        if (getClass() == obj.getClass()) {
            return true;
        }

        Preserved pres = (Preserved) obj;
        return (key == pres.key || (key != null && key.equals(pres.key)))
                && (value == pres.value || (value != null && value.equals(pres.value)));
    }

    @Override
    public int hashCode() {
        int x = 7;
        x = 31 * x + (key == null ? 0 : key.hashCode());
        x = 31 * x + (value == null ? 0 : value.hashCode());
        return x;

    }
}
