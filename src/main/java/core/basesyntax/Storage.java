package core.basesyntax;

import java.security.Key;

public interface Storage<K, V> {

    void put(K key, V value);

    Key get(K key);

    int size();
}
