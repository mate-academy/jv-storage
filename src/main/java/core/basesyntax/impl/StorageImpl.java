package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;

public class StorageImpl<K, V> implements Storage<K, V> {

    private ArrayList<Pairs> pairs = new ArrayList<>();

    @Override
    public void put(K key, V value) {
        Pairs pair = findPair(key);
        if (pair == null) {
            pair = new Pairs(key, value);
            pairs.add(pair);
        } else {
            pair.setValue(value);
        }
    }

    private Pairs<K, V> findPair(K key) {
        Pairs<K, V> unicPair = null;
        for (int i = 0; i < pairs.size(); i++) {
            Pairs<K, V> pair = pairs.get(i);
            if (pair.getKey() != null && pair.getKey().equals(key)) {
                unicPair = pair;
            }
            if ((pair.getKey() == null) && (key == null)) {
                unicPair = pair;
            }
        }
        return unicPair;
    }

    @Override
    public V get(K key) {
        V value = null;
        for (int i = 0; i < pairs.size(); i++) {
            if (pairs.get(i).getKey() != null && pairs.get(i).getKey().equals(key)) {
                value = (V) pairs.get(i).getValue();
            }
            if (pairs.get(i).getKey() == null && key == null) {
                value = (V) pairs.get(i).getValue();
            }
        }
        return value;
    }

    @Override
    public int size() {
        return pairs.size();
    }
}
