package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;
import java.util.List;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_HASH_RANGE = 25;
    private final ArrayList<ArrayList<K>> keys = new ArrayList<>();
    private final ArrayList<ArrayList<V>> values = new ArrayList<>();

    public StorageImpl() {
        keys.add(new ArrayList<>());
        values.add(new ArrayList<>());
    }

    @Override
    public void put(K key, V value) {

        int place = key == null ? 0 : Math.abs(key.hashCode() % MAX_HASH_RANGE);
        while (keys.size() <= place) {
            keys.add(new ArrayList<>());
            values.add(new ArrayList<>());
        }
        List<K> keysColumn = keys.get(place);
        int x = -1;
        for (int i = 0; i < keysColumn.size(); i++) {
            if (keysColumn.get(i) == key
                    || (keysColumn.get(i) != null && keysColumn.get(i).equals(key))) {
                x = i;
            }
        }
        if (x == -1) {
            keys.get(place).add(key);
            values.get(place).add(value);
        } else {
            keys.get(place).set(x, key);
            values.get(place).set(x, value);
        }
    }

    @Override
    public V get(K key) {
        int place = key == null ? 0 : Math.abs(key.hashCode() % MAX_HASH_RANGE);
        if (place >= keys.size()) {
            return null;
        }
        List<K> keysColumn = keys.get(place);
        int x = -1;
        for (int i = 0; i < keysColumn.size(); i++) {
            if (keysColumn.get(i) == key
                    || (keysColumn.get(i) != null && keysColumn.get(i).equals(key))) {
                x = i;
            }
        }
        if (x == -1) {
            return null;
        }
        return values.get(place).get(x);
    }

    @Override
    public int size() {
        return keys.stream().mapToInt(ArrayList::size).sum();
    }
}
