package core.basesyntax;

import core.basesyntax.impl.StorageImpl;

public class Main {
    public static void main(String[] args) {
        Storage<Integer,String> storage = new StorageImpl<>();
        Box box = new Box("kol",22);
        storage.put(22, "dasdasd");
        storage.put(33,"r");
        storage.put(44,"e");
        storage.put(33,"r");
        storage.put(11,"ss");
        System.out.println(storage.size());
        System.out.println(storage.get(11));
    }
}
