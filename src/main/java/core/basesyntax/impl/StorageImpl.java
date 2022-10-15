package core.basesyntax.impl;

import core.basesyntax.Box;
import core.basesyntax.Storage;

import java.util.ArrayList;
import java.util.List;

public class StorageImpl<K, V> implements Storage<K, V> {
    private List<Box> storage = new ArrayList<>();

    public int getIndex (K key, List<Box> storage) {
        if (storage.size() > 0) {
            for (int i = 0; i < storage.size(); i++) {
                if (storage.get(i).getKey() == key || storage.get(i).getKey().equals(key)) {
//                    System.out.println(i);
                    return i;
                }
            }
        };
       return -1;
    }
    @Override
    public void put(K key, V value) {
        Box box = new Box(key, value);
        if (box.getKey() == null || box.getValue() == null) {
            return;
        }
        if (getIndex(key, storage) >= 0 ) {  //уже есть с таким key
            int i = getIndex(key, storage); //индекс в storage этого эл-та с key
            Box itemFromStorage = storage.get(i); //эл-т на поз-и i в в storage
            if (itemFromStorage.getKey() == box.getKey() ||
                    (box.getKey() != null && box.getKey().equals(itemFromStorage.getKey()))) {
                storage.set(i, box);
            }
        }
        else if (box.getKey() != null){
            storage.add(box);
        }
        System.out.println(storage);
    }

    @Override
    public V get(K key) {
//        if (getIndex(key, storage )>= 0) {
//            return (V) storage.get(getIndex(key, storage )).getValue();
//        }
        for (Box item: storage) {
            if(item.getKey() != null && item.getKey().equals(key)) {
                return (V) item.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storage.size();
    }
}
