package core.basesyntax.impl;

class Pair<K, V> {
    private K key;
    private V value;

    //write your code here
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
}
