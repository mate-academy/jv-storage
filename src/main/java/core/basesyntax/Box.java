package core.basesyntax;

public class Box<K, V> {
    private K key;
    private V value;

    public Box(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {

        return key;
    }

    public void setKey(K key) {
        if (key != null) {
            this.key = key;
        }
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        if (value != null) {
            this.value = value;
        }
    }
}
