# jv-storage

Implement the `Storage` of `key-value` type that is parameterized with two types of data. 
You should be able to put new key-value pair and to get value by key.

If you are given the key-value pair, and the storage already contains this key, you should replace the value.

Example:
```java
Storage<Integer, Box> storage = new StorageImpl<>(); 
Box box = new Box();
storage.put(22, box); 
Box value = storage.get(22); // returns the Box
int size = storage.size(); // returns storage size
```
You should solve this task using one or two arrays (this depends on your implementation).
If you use arrays for your solution, we assume that the maximum number of elements in our `Storage` is 10.
#### [Try to avoid these common mistakes while solving task](https://mate-academy.github.io/jv-program-common-mistakes/java-core/generics/storage.html)
