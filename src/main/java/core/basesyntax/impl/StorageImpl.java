package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int FIRST_PAIR = 0;

    protected class Pair<K, V> extends StorageImpl<K, V> implements Storage<K, V> {
        private K indexKey;
        private V data;

        private Pair(K indexKey, V data) {
            this.indexKey = indexKey;
            this.data = data;
        }

        public K getIndexKey() {
            return indexKey;
        }

        public void setIndexKey(K indexKey) {
            this.indexKey = indexKey;
        }

        public V getData() {
            return data;
        }

        public void setData(V data) {
            this.data = data;
        }

  //      @Override
  //      public boolean equals(Object pair) {
  //          if (pair.getClass().equals(Pair.class)) {
  //              Pair current = (Pair) pair;
  //              return Objects.equals(this.indexKey, current.indexKey)
  //                          && Objects.equals(this.data, current.data);
  //          }
   //         return false;
  //      }

    }

    private Pair[] storageOfPairs = new Pair[10];

    @Override
    public void put(K key, V value) {
        Pair<K, V> pair = new Pair<K, V>(key, value);
        if (isStorageEmpty()){
            storageOfPairs[0] = pair;
        } else if (existsDublicate(pair) != -1)  {
            storageOfPairs[existsDublicate(pair)] = pair;
        } else if (checkEmptySlot() != -1){
            storageOfPairs[checkEmptySlot()] = pair;
        } else {
            System.out.println("Storage is full of its capacity");
        }
    }

    @Override
    public V get(K key) {
            for (int i = 0; i < storageOfPairs.length; i++) {
                if (!isStorageEmpty() && Objects.equals(storageOfPairs[i].getIndexKey(),key)) {
                    return (V) storageOfPairs[i].getData();
                }
            }
        return null;
    }
    @Override
    public int size() {
        if (checkEmptySlot() != -1) {
            return checkEmptySlot();
        }
        return -1;
    }

    private boolean isStorageEmpty(){
        return storageOfPairs[FIRST_PAIR] == null;
    }

    private int checkEmptySlot() {
        for (int i = 0; i < 10; i++) {
            if (storageOfPairs[i] == null) {
                return i;
            }
        }
        return -1;
    }

    private int existsDublicate(Pair pair) {
        if (!isStorageEmpty()) {
            for (int i = 0; i < storageOfPairs.length; i++) {
                if ( storageOfPairs[i].getIndexKey() == pair.getIndexKey()
                        || (storageOfPairs[i].getIndexKey() != null
                && storageOfPairs[i].getIndexKey().equals(pair.getIndexKey()))
                        //Objects.equals(storageOfPairs[i].getIndexKey(), pair.getIndexKey())
                       // як що взяти закоментовану умову, то не працює тільки 2 тести
                ) {
                    return i;
                }
            }
        }
        return -1;
    }
}
