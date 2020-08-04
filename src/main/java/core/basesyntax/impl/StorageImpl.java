package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    static final int SIZE = 10;
    Pair<K, V>[] pairs;

    public StorageImpl() {
        this.pairs = new Pair[SIZE];
    }

    @Override
    public void put(Object key, Object value) {
        for (int i = 0; i < SIZE; i++) {
            if (null == pairs[i] || isTheSameKey(pairs[i], key)) {
                pairs[i] = Pair.of(key, value);
                break;
            }
        }
    }

    @Override
    public Object get(Object key) {

        for (int i = 0; i < SIZE; i++) {
            if (null == pairs[i]) {
                break;
            }
            if (isTheSameKey(pairs[i], key)) {
                return pairs[i].getSecond();
            }
        }
        return null;
    }

    //Don’t create repeating code
    private boolean isTheSameKey(Pair pair, Object key) {
        return pair.getFirst() == key
                || (pair.getFirst() != null && pair.getFirst().equals(key));
    }
}
