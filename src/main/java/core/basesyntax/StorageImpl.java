package core.basesyntax;

public class StorageImpl<K, V> implements Storage<K, V> {
    static final int MAX_NUMBER = 10;
    private final Object[] keyArray = new Object[MAX_NUMBER];
    private final Object[] valueArray = new Object[MAX_NUMBER];

    @Override
    public void put(Object key, Object value) {
        boolean alreadyContain = false;
        for (int i = 0; i < MAX_NUMBER; i++) {
            if (key == null) {
                if (key == keyArray[i]) {
                    valueArray[i] = value;
                    alreadyContain = true;
                    break;
                } else {
                    continue;
                }
            } else if (key.equals(keyArray[i])) {
                valueArray[i] = value;
                alreadyContain = true;
            }
        }
        if (!alreadyContain) {
            keyArray[size()] = key;
            valueArray[size()] = value;
        }
    }

    @Override
    public Object get(Object key) {
        for (int i = 0; i < 10; i++) {
            if (key == null) {
                if (key == keyArray[i]) {
                    return valueArray[i];
                } else {
                    continue;
                }
            } else if (key.equals(keyArray[i])) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < 10; i++) {
            if (null != valueArray[i]) {
                counter++;
            }
        }
        return counter;
    }
}
