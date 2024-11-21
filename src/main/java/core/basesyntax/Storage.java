package core.basesyntax;

public abstract class Storage<K, V> {
    protected abstract void put(K key, V value);
    public abstract V get(K key);
    protected abstract int size();
}
