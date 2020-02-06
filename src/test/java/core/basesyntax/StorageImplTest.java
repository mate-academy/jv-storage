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
    public void getElementWithKeyNull() {
        Storage<Integer, String> storage = new StorageImpl<>();
        String elementOne = "Element 1";
        String elementTwo = "Element 2";
        String elementTree = "Element 3";
        storage.put(1, elementOne);
        storage.put(null, elementTwo);
        storage.put(3, elementTree);
        Assert.assertEquals(
                "Test failed! Method get(null) should return value",
                elementTwo,
                storage.get(null));
    }

    @Test
    public void getElementWhenKeyIsObject() {
        Storage<Cat, String> storage = new StorageImpl<>();
        String elementOne = "Element 1";
        String elementTwo = "Element 2";
        String elementTree = "Element 3";
        Cat firstCat = new Cat("Myrchyk", "white");
        Cat secondCat = new Cat("Barsik", "black");
        Cat sameSecondCat = new Cat("Barsik", "black");
        Cat thirdCat = new Cat("Musia", "grey");

        storage.put(firstCat, elementOne);
        storage.put(secondCat, elementTwo);
        storage.put(thirdCat, elementTree);
        Assert.assertEquals(
                "Test failed! Method get(key) should return correct value",
                elementTwo, storage.get(sameSecondCat));
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
        String one = "one";

        storage.put(1, one);
        storage.put(null, element);

        Assert.assertEquals(one, storage.get(1));
        Assert.assertEquals(element, storage.get(null));
    }
}
