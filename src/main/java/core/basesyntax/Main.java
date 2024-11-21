package core.basesyntax;
import core.basesyntax.impl.StorageImpl;
public class Main {
    public static void main(String[] args) {
        StorageImpl<Integer, String> storage = new StorageImpl<>();
        storage.put(21, "lebratik");
        storage.put(22, "lee");
        System.out.println("Value for key 22: " + storage.get(22));
        System.out.println("Storage size: " + storage.size());
    }
}
