package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_NUMBER = 10;
    private final core.basesyntax.impl.Node[] nodeArray;
    private int size;

    public StorageImpl() {
        nodeArray = new core.basesyntax.impl.Node[MAX_ARRAY_NUMBER];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == nodeArray[i].getKey() || key != null && key.equals(nodeArray[i].getKey())) {
                nodeArray[i].setValue(value);
                return;
            }
        }

        core.basesyntax.impl.Node<K, V> pair = new core.basesyntax.impl.Node<>();
        pair.setKey(key);
        pair.setValue(value);
        nodeArray[size] = pair;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == nodeArray[i].getKey() || key != null && key.equals(nodeArray[i].getKey())) {
                return (V) nodeArray[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

}

