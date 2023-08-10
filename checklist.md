## Common mistakes (jv-storage)

#### Don't begin class or method implementation with empty line.  
Remove all redundant empty lines, be careful :)
#### All non-constant fields should be initialized in the constructor
- Example:
    ```java
    public class Shelf {
        private Object[] items;
    
        public Shelf() {
            items = new Object[]{"book", "photo", "phone"};
        }
    }
    ```
#### Any magic numbers should be constants
Your code should be easy to read. Let's move all hardcoded values to constant fields and give them informative names.

- Bad example:
    ```java
    public class Shelf {
        private Object[] items;
    
        public Shelf() {
            items = new Object[6];
        }
    }
    ```
- Refactored code:
    ```java
    public class Shelf {
        private static final int MAX_ITEMS_NUMBER = 6;
        private Object[] items;
    
        public Shelf() {
            items = new Object[MAX_ITEMS_NUMBER];
        }
    }
    ```
#### Don't use any kind of List, Set or Map
We will soon learn how these collections work.
#### Don't create repeating code
If the logic of your code repeats - move it to the separate private method. 
There is even a software design principle called [DRY](https://dzone.com/articles/software-design-principles-dry-and-kiss) that urges not to repeat yourself.
#### Don't use class Objects
#### Create informative variable and method names.
Writing proper variable names can be a highly valuable investment to the quality of your code. 
Not only you and your teammates understand your code better, but it can also improve code sustainability in the future later on. 
When you go back to the same code base and re-read it over again, you should understand what is going on.
Do not use abstract words like `string` or `array` as variable name. Do not use one-letter names. The name of the method should make it clear what it does.
- Bad example:
    ```java
    String[] arr = new String[]{"Alex", "Bob", "Alice"};
    for (String s : arr) {
        System.out.println(s);
    }
    ```
- Refactored code:
    ```java
    String[] usernames = new String[]{"Alex", "Bob", "Alice"};
    for (String username : usernames) {
        System.out.println(username);
    }
    ```
    
