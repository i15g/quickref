# Java Quickref

```java
import java.util.*;
```

## Primitives

| Data Type | Default Value | Size   | Max    |
| --------- | ------------- | ------ | ------ |
| boolean   | `false`       | 1 bit  |        |
| char      | “ “ (space)   | 2 byte | 2^16-1 |
| byte      | 0             | 1 byte | 2^07-1 |
| short     | 0             | 2 byte | 2^15-1 |
| int       | 0             | 4 byte | 2^31-1 |
| long      | 0             | 8 byte | 2^63-1 |
| float     | 0.0f          | 4 byte |        |
| double    | 0.0d          | 8 byte |        |

Recall: 1 byte = 8 bits

## Type Conversions

- Widening aka automatic conversion
  - Byte > Short > Int > Long > Float > Double
  - Automatic because no information is lost
- Narrowing aka explicit conversion aka downcasting
  - Requires explicit cast because information is lost

```java
//
int i = 'a'; // Widening char to int
char c = (char) 97; //Narrowing int to char

// From String
int i = Integer.parseInt(str);
double d = Double.parseDouble(str);
boolean b = Boolean.parseBoolean(str);
// To String
String.valueOf(i)
```

## Operators

| Category                | Operators                                          |
| ----------------------- | -------------------------------------------------- |
| Arithmetic              | +, -, /, \*, %                                     |
| Relational              | <, >, <=, >=,==, !=                                |
| Logical                 | && , \|\|                                          |
| Assignment              | =, +=, −=, ×=, ÷=, %=, &=, ^=, \|=, <<=, >>=, >>>= |
| Increment and Decrement | ++, --                                             |
| Conditional             | ?, :                                               |
| Bitwise                 | ^, &, \|                                           |

## Methods

```java
returnType methodName(parameter list){
  //do stuff
  return value;
}

public static void main(String[] args){ }
```

## Conditionals

```java
if (x > 10){
 foo();
} else if (x > 5){
  bar();
} else {
  fooBar();
}

y = x > 10 ? itWasTrue() : itWasFalse();

int day = getDayOfTheWeek();
String result;
switch(day){
  case 0:
    result = "Sunday";
    break;
  case 1:
    result = "Monday"
    break;
  default:
    result = "unknown";
    break;
}
```

## Loops

- **! ForEach loops should never modify the collection !**
- Also see Loops.java

```java
String s = "hello";
for (int i = 0; i < s.length(); i++){
  System.out.println(s.charAt(i));
}

for (char c : s.toCharArray()){
  System.out.println(c);
}

int j = 0;
while (j < s.length()){
  System.out.println(s.charAt(j));
  j++;
}

int k = 0;
do {
  System.out.println(s.charAt(k));
  k++;
} while (k < s.length());

break;    // break out of loop entirely
continue; // break out of this iteration
```

## Exceptions

```java
try {
  int x = 42 / 0;
} catch (ArithmeticException e) {
  System.out.println("Division by zero");
} catch (Exception e) {
  System.out.println("Not run because upper exception is caught");
} finally {
  System.out.println("Always executed last");
}

if (blah){
  throw new IllegalArgumentException("Bad param");
}
```

## Enum

```java
enum Level {
  LOW,
  MED,
  HIGH
}
```

## Strings

- Escape sequences
  - `\n` newline
  - `\t` tab

```java
String s = new String(myCharArray); // char array back to string
String s = "hello";
s += " " + "there"; //concats

String.format("%s is %d years old.", "Bob", 30); // Interpolation

s.length()
s.toLowerCase(), s.toUpperCase()
s.trim()

s.contains(s2)
s.startsWith(s2), s.endsWith(s2)
s.charAt(index)
s.indexOf(s2), s.indexOf(s2, fromIndex)
s.lastIndexOf(s2), s.lastIndexOf(s2, fromIndex)
s.substring(beginIndex)
s.substring(beginIndex, endIndexExclusive)

s.replace("he", "HE")   //replaces all instaces of `he`
s.replaceAll(regex, "") //same as replace but takes a regex
s.matches(regex)

s.equals(s1),s.equalsIgnoreCase(s1)
left.compareTo(right)

s.toCharArray()
s.split(regex) //returns String[], just contains s if no regex hits

// See StringBuffer for multithreading situations
// StringBuilder has equivalent methods for:
//    length, substring, indexOf, lastIndexOf, replace
StringBuilder sb = new StringBuilder(initialCapacity);
sb.append("append me")
sb.delete(beginIndex, endIndexExclusive) //rm a substring
sb.deleteCharAt(index)
sb.setCharAt(index)
sb.insert(index, "my string")
sb.reverse()
return sb.toString();
```

## Regexes

| Metachars | Info                             |
| --------- | -------------------------------- |
| \|        | Pattern separator, eg bob\|alice |
| .         | Any single char                  |
| ^         | First char                       |
| $         | Last char                        |
| \d        | Digit                            |
| \s        | Whitespace char (includes tabs)  |

| Range  | Info                         |
| ------ | ---------------------------- |
| [abc]  | Any char in the brackets     |
| [^abc] | Any char NOT in the brackets |
| [0-9]  | Any char in range 0-9        |

| Quantifier | Info                                            |
| ---------- | ----------------------------------------------- |
| n+         | At least one of n                               |
| n\*        | At least zero of n                              |
| n?         | Zero or one n                                   |
| n{x}       | Sequence of n that occurs x times               |
| n{x,y}     | Sequence of n that occurs x-y times (inclusive) |
| n{x,}      | Sequence of n that occurs at least x times      |

Examples:

```java
s.replaceAll("\s+", "") //remove all whitespace
s.replaceAll("[^a-zA-Z ]", "") //remove anything that isn't a letter or a space
s.matches("([a-zA-Z]|\\d|\s)*"); //s only has alphabet or digits or whitespace
```

## Math

```java
import static java.lang.Math.*; //static import

abs(int a)
addExact(int x, int y)
ceil(double a), floor(double a)
max(int a, int b), min(int a, int b)
pow(double a, double b) // power, exponent
round(double a) //returns closest long
round(float a) //return closest int
//Methods of the form opExact() throw an exception if the result overflows
```

## Random

```java
Random rand = new Random();
rand.nextInt(upperBound) //    0 <= output < upperBound
rand.nextFloat()         // 0.0f <= output < 1.0f
rand.nextDouble()        // 0.0d <= output < 1.0d

Math.random()            // 0.0d <= output < 1.0d
(int)(Math.random()*100) // 0 <= output < 100

//stream of n nums
rand.ints(n)
rand.longs(n)
rand.doubles(n)

//select random element
arr[rand.nextInt(arr.length)]
```

## Arrays

- Will not auto-resize

```java
int[][] intMatrix = new int[10][10];
String[] arr = {"Bob", "Alice", "John"};
String first = arr[0];
arr[0] = "Robert";
int len = arr.length;
String[] arrCopy = arr.clone(); //copies contents
//See Arrays.equals(arr0,arr1) below for comparing arrays
```

## java.util.Arrays

```java
object[] arr
Arrays.toString(arr) //useful for pretty printing
Arrays.binarySearch(arr, key) //returns index, arr must be sorted
Arrays.equals(arr0, arr1) // checks length and arr0[i].equals(arr1[i]) for all i
Arrays.fill(arr, value) //assings value to each element in arr
Arrays.mismatch(arr0, arr1) //index of first mismatch (includes DNEs) or -1 if none found
Arrays.sort(arr) // merge sort, must implement equals() method for custom objects
Arrays.stream(arr)
```

## ArrayLists

- Implements List interface
- Can't use primitives (ex: int has to be Integer)
- Auto-resize

```java
//Double Brace Initialisation:
var names = new ArrayList<String>() {
  {
    add("Bob");
    add("Alice");
    add("John");
  }
};

//quick immutable list:
List<String> names = Arrays.asList("Bob", "Alice", "John");

String first = names.get(0);
names.set(0, "Robert")
names.remove(0)
names.contains("Jim")
names.clear() //removes all elements
names.size() //length
names.addAll(names2) //combine 2 lists
names.indexOf(Object o), lastIndexOf(Object o) //int index or -1 for DNE
names.isEmpty()
names.toArray()
names.stream()

names.sort(Comparator<? super E> c) //See Comparators, pass in lambda
names.removeIf(s -> s.length() > 3)
names.replaceAll(s -> s.toUpperCase())
```

## java.util.Collections

```java
List<String> list = Arrays.asList("Bob", "Alice", "John");

Collections.fill(coll, T obj) //assings value to each element
Collections.frequency(coll, Object o)
Collections.indexOfSubList(list, Arrays.asList("Alice", "John"))
Collections.max(coll), min(coll)
Collections.replaceAll(list, T oldVal, T newVal)
Collections.reverse(list)
Collections.shuffle(list)
Collections.sort(list) //optionally pass in a custom lambda
Collections.swap(list, int i, int j)
```

## Lambdas

```java
var list = Arrays.asList("Bob", "Alice", "John");
list.sort((s0, s1) -> s0.length() - s1.length());
list.sort((s0, s1) -> {
  //multiline
  return s0.length() - s1.length();
});
// Method reference syntax:
list.forEach(System.out::println);
```

## Comparators

```java
left.compareTo(right)
// -1 if left < right
//  1 if right > left
//  0 if equal
"alice".compareTo("bob") // -1
```

When sorting:

- -1 means `left` should come before `right`
- 1 means `right` should come before `left`

## Streams

```java
var list = Arrays.asList("Bob", "Alice", "John", "Bob");
// Get unique strings and make them uppercase
List<String> output = list.stream().distinct().map(String::toUpperCase).collect(Collectors.toList());

// Get int length of longest string in list
int longestLength = list.stream().mapToInt(s -> s.length()).max().getAsInt();
int longestLength = list.stream().map(String::length).max((a, b) -> a.compareTo(b)).get();

// String > IntStream > String stream > Recollect to string
var hello = "hello".chars().mapToObj(i -> String.valueOf((char) i)).collect(Collectors.joining(""));
```

```java
Stream.generate(() -> "#")
count()
distinct() //unique elements only
skip(n) //discard first n elements
limit(n) //truncate after n elements

// Predicates, ex s -> s.length() > 3
allMatch(predicate) //true is all elements match
anyMatch(predicate)  //true if at least one element matches
noneMatch(predicate) //true if none match
filter(predicate) //keep elements that match pred

forEach(System.out::println) //a non-interfering action to perform on the elements
map(mapper) // ex: obj -> obj.toString()
flatMap() //transform each element into a new stream and then combine them all

// Comparators
sorted() //natural order
sorted(comparator)
max(comparator), min(comparator)
```

```java
//IntStream, LongStream, DoubleStream
IntStream.range(int startInclusive, int endExclusive)
IntStream.rangeClosed(int startInclusive, int endInclusive)
mapToInt(mapper), mapToLong(mapper), mapToDouble(mapper)
boxed() //converts IntStream to Stream<Integer>
average()
max(), min()
sum()
```

```java
reduce((a, b) -> a + b) //collapse all elements together
toArray()

collect(Collectors.toList()) //or toSet()
collect(Collectors.joining()) //join elements into single string
collect(Collectors.joining(", "))
```

## LinkedList

```java
var ll = new LinkedList<String>();

addLast(), add()     // appends
addFirst(o), push(o) // prepends

peek()     //retrieves but does not remove head
peekLast() //retrieves but does not remove tail

removeFirst() //pop head
removeLast()  //pop tail
```

## ArrayDeque

- Not thread safe
- Usually faster than LinkedList for stacks and queues

```java
//Stack
var stack = new ArrayDeque<>();
stack.push(1)
stack.pop()

//Queue
var queue = new ArrayDeque<>();
queue.add(0) //add to end of queue
queue.poll() //get element at the front of the queue
```

## Set / HashSet

```java
Set<String> h = new HashSet<String>(); //optional param initialCapacity
Set<String> h = new HashSet<String>(strList);

h.add("a"); h.add("b"); h.add("c"); h.add("a");
h.size()
h.contains("a")
h.remove("a")
h.clear() //remove all elements
```

## Map / HashMap

```java
var hm = new HashMap<String,String>(); //optional param initialCapacity

hm.put(key, value)
hm.putIfAbsent(key, value)
hm.get(key) // returns null if DNE
getOrDefault(key, defaultValue) // returns defaultValue if DNE
hm.remove(key)
hm.clear()
hm.size()
hm.isEmpty()
hm.keySet();
hm.values()
hm.containsKey(key)
hm.containsValue(value)
hm.forEach((k,v)-> print(k,v));
```

## Comments

```java
// Single line comment
/* Multi
line
comment */
```
