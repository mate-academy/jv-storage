package core.basesyntax;

import core.basesyntax.impl.StorageImpl;
import org.junit.Assert;
import org.junit.Test;

public class StorageImplTest {

    @Test
    public void addElementToStorage() {
        Storage<Integer, String> storage = new StorageImpl<>();
        String elementOne = "Element 1";
        String elementTwo = "Element 2";
        String elementTree = "Element 3";

        storage.put(1, elementOne);
        storage.put(2, elementTwo);
        storage.put(3, elementTree);

        Assert.assertEquals(elementOne, storage.get(1));
        Assert.assertEquals(elementTwo, storage.get(2));
        Assert.assertEquals(elementTree, storage.get(3));
    }

    @Test
    public void getElementWhenKeyDontExist() {
        Storage<Integer, String> storage = new StorageImpl<>();

        Assert.assertNull(
                "When element with this key dont exist, should return null",
                storage.get(1234321));
    }

    @Test
    public void addTwoElementsWithSameKey() {
        Storage<Integer, String> storage = new StorageImpl<>();
        Integer key = 1;
        String elementOne = "One";
        String elementTwo = "Two";

        storage.put(key, elementOne);
        storage.put(key, elementTwo);

        Assert.assertEquals(
                "When elements were adding with the same key, should be rewritten",
                elementTwo,
                storage.get(key));
    }

    @Test
    public void addElementWithKeyNull() {
        Storage<Integer, String> storage = new StorageImpl<>();
        String element = "Element";

        storage.put(null, element);

        Assert.assertEquals(element, storage.get(null));
    }
}
