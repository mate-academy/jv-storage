package core.basesyntax;

public class StorageImpl<K, V> implements Storage{

    private static final int MAX_ELEMENTS_NUMBER = 10;
    private final K[] keys;
    private final V[] values;


    public StorageImpl() {
        keys = (K[]) new Object[MAX_ELEMENTS_NUMBER];
        values = (V[]) new Object[MAX_ELEMENTS_NUMBER];
    }





}
