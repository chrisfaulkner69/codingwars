# Interview Cheat Sheet

## Part 1 — Kata, ranked by likelihood of coming up

Grouped by how likely something *like* this shows up in a live-coding interview (not necessarily verbatim).

### Very likely
Classic warm-up territory — simple string/array manipulation and basic algorithms almost every Java interview touches.

- `FizzBuzz`
- `Anagram` / `AnagramDifference`
- `Isogram` / `IsogramNew`
- `PalindromeGenerator`
- `DigitalRoot`
- `ReduceButGrow` (product of an array via `reduce`)
- `MinNumberNotInArray`
- `SumOfMultiplesOf3or5`
- `FindOdd`
- `EqualSidesOfArray` / `EqualSidesOfAnArray`
- `WordSpinner` / `SentenceWordCount`
- `AlternatingCase`
- `ValidBraces` (balanced brackets — a top-tier classic)
- `Fibonacci` (classic, often a follow-up to "make it iterative/memoized")

### Possible
A bit more involved, still plausible as a 20–45 minute exercise.

- `ArrayDiff` / `ArrayIntersection`
- `RomanNumeral`
- `BinaryAddition`
- `ShortestWord`
- `WhatsInAName` / `WhoLikesIt`
- `MexicanWave`
- `ChangeCounter` (coin-change DP — common at mid/senior level)
- `SheepCount`
- `DigitalCypher`
- `PigLatin`
- `SortNumbersByWord`
- `IntegerSum`
- `HumanReadableTime` / `HumanReadableTimeWords`

### Unlikely
Kata-specific or a bit niche — plausible only if the interviewer happens to like this exact flavour.

- `ConnectFour` / `CuckooClock` / `BouncingBall`
- `PaginationHelper`
- `MatchSubst` / `MatchSubstJava21`
- `InterestBounds` / `InterestRate`
- `MultiplesSummation`
- `RegexValidator`
- `WordLetterChanger`
- `MessageDecoder`
- `DnaStrand`

### Very unlikely (verbatim) — but read this note
- `MazeRunner` — a real Codewars kata, but a full maze-simulation problem is an unusual, specific ask for a generic interview slot.
- `MazeWalker`, `Discount`, `OrderAnalyzer`, `InventoryAlertService` — custom exercises built this week, not sourced kata.

**Important caveat:** "very unlikely to reappear as this exact problem" does **not** mean "low value." These four were deliberately built to drill the *skills* interviewers actually reach for — sealed interfaces + pattern-matching `switch`, streams/`BigDecimal`/`Optional`, TDD against mocked collaborators, business-rule-triggers-a-side-effect design. Those skills are **very likely** to be tested, just wrapped in whatever scenario the interviewer invents on the day. Don't discount the prep value here.

---

## Part 2 — Snippet reference, pulled from your own code

### 1. Lambda / method references

**`FizzBuzz.java`** — bound instance method reference (`this::method`) and a static method reference to `System.out.println`:
```java
public void doFizzBuzzIntStream(final int startNum, final int endNum) {
    IntStream.rangeClosed(startNum, endNum)
        .mapToObj(this::getFizzBuzzString)
        .forEach(System.out::println);
}
```
`this::getFizzBuzzString` works because the method's signature (`int -> String`) matches what `mapToObj` needs. `System.out::println` is a method reference on a specific object instance (`System.out`), not the class — a different flavour from a static reference.

**`DnaStrand.java`** — static method reference:
```java
Arrays.stream(dna.split("")).map(DnaAlternative::alternative).collect(Collectors.joining());
```

**`OrderAnalyzer.java`** — a custom `@FunctionalInterface` (not `java.util.function.Predicate`) satisfied by both a lambda and a bound method reference:
```java
public List<Category> distinctCategories(List<Order> orders, OrderPredicate filter) {
    return orders1.stream()
            .filter(filter::test)
            .map(Order::category)
            .distinct()
            .toList();
}

@FunctionalInterface
public interface OrderPredicate {
    boolean test(Order order);
}
```
Called either as `distinctCategories(orders, o -> o.amount().compareTo(BigDecimal.valueOf(4)) > 0)` or as `distinctCategories(orders, this::checkValueOverFour)` — same interface, lambda or method reference interchangeably.

---

### 2. Sorting — in and out of streams

**`SortNumbersByWord.java`** — sorting `Map.Entry` pairs by value, in-stream:
```java
public static int[] sortBetter(final int[] array) {
    return Arrays.stream(array)
            .mapToObj(i -> Map.entry(i, numToWord(i)))
            .sorted(Map.Entry.comparingByValue())
            .mapToInt(Map.Entry::getKey)
            .toArray();
}
```

**`OrderAnalyzer.java`** — descending sort of a `Map`'s entries, then rebuilding a `LinkedHashMap` so the order survives being turned back into a `Map` (a plain `Map` has no ordering guarantee, only its entry-*stream* does):
```java
return customerTotals.entrySet().stream()
        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                (existing, replacement) -> existing, LinkedHashMap::new));
```

**`ArrayIntersection.java`** — plain, non-stream in-place array sort, when you just need it sorted and don't care about the stream ceremony:
```java
Arrays.sort(firstArray);
Arrays.sort(secondArray);
```

---

### 3. Grouping in streams

**`OrderAnalyzer.java`** — plain `groupingBy` (no downstream collector, `Map<K, List<V>>`):
```java
public Map<String, List<Order>> groupByCustomer(List<Order> orders) {
    return orders.stream()
            .collect(groupingBy(Order::customer, Collectors.toList()));
}
```

Same file — `groupingBy` **with** a downstream collector, composing `mapping` + `reducing` to go straight from grouped orders to summed `BigDecimal` totals in one pass:
```java
Map<String, BigDecimal> customerTotals = orders.stream()
        .collect(groupingBy(Order::customer,
                mapping(Order::amount, reducing(BigDecimal.ZERO, BigDecimal::add))));
```
Talking point: `mapping(extractor, downstream)` composed with a 2-arg `reducing(identity, op)` is equivalent to the 3-arg `reducing(identity, mapper, op)` form — shows the collectors are composable building blocks, not a fixed menu.

---

### 4. Collecting, joining, and `reduce` (identity / accumulator)

**`ReduceButGrow.java`** — `reduce` with an identity and a combining lambda (product of an array):
```java
public static int grow(int[] x) {
    return IntStream.of(x).reduce(1, (a, b) -> a * b);
}
```

**`OrderAnalyzer.java`** — same shape, but the combiner is a method reference and the values are `BigDecimal` (sum, not product):
```java
return orders.stream()
        .filter(order -> order.category() == category)
        .map(Order::amount)
        .reduce(BigDecimal.ZERO, BigDecimal::add);
```

**`DnaStrand.java`** / **`PigLatin.java`** — `Collectors.joining()`, with and without a delimiter:
```java
Arrays.stream(dna.split("")).map(DnaAlternative::alternative).collect(Collectors.joining());
```
```java
return Arrays.stream(str.split("\\s")).map(PigLatin::pigWord).collect(Collectors.joining(" "));
```

---

### 5. Stream generation, `flatMap`, `map`, `IntStream`

**`FizzBuzz.java`** — generating a stream from a numeric range:
```java
IntStream.rangeClosed(startNum, endNum)
```

**`EqualSidesOfArray.java`** — using `IntStream.range` purely as an index generator (a common trick when you need the index itself, not the array's values):
```java
return IntStream.range(0, arrayLength)
        .filter(i -> Arrays.stream(Arrays.copyOfRange(inputArray, 0, i)).sum()
                  == Arrays.stream(Arrays.copyOfRange(inputArray, i + 1, arrayLength)).sum())
        .findFirst()
        .orElse(-1);
```

**`IsogramNew.java`** — going from a `String` to a primitive `IntStream` of char codes (`.chars()`), filtering, then `mapToObj` to cross back from a primitive stream to `Stream<String>`:
```java
final var alphabetOnly = str.toLowerCase(Locale.ROOT).chars()
        .filter(Character::isLetter)
        .mapToObj(c -> String.valueOf((char) c))
        .collect(Collectors.joining());
```

**`flatMap`** — not in this repo's non-interview kata, but from `java-lang-features/streams/StreamsTest.java`, the canonical shape (flattening a "collection of collections" into one continuous stream, rather than a stream-of-streams like `map` would produce):
```java
var allMiddleNames = names.stream()
        .flatMap(name -> name.getMiddleNames().stream())
        .distinct()
        .collect(Collectors.toList());
```

---

### 6. `filter`

**`InterestRate.java`** — filtering domain objects by a predicate method:
```java
return interestBounds.stream()
        .filter(bound -> bound.inRange(amount))
        .findFirst()
        ...
```

**`kyu6/SumOfMultiplesOf3or5.java`** — filtering primitives with modulo arithmetic:
```java
IntStream.range(0, number)
        .filter(n -> (n % 3 == 0) || (n % 5 == 0))
        ...
```

---

### 7. String / char-array fiddly bits (not stream-related)

**`MexicanWave.java`** — the classic "replace one character at an index" trick using `substring` either side of it, since `String` has no in-place char replacement:
```java
str.substring(0, n) + Character.toUpperCase(str.charAt(n)) + str.substring(n + 1)
```

**`kyu7/DigitalCypher.java`** — `toCharArray()` to iterate characters, plus digit-by-digit extraction via `substring`:
```java
for (final char c : message.toCharArray()) {
    final var val = keyStr.substring(lengthCount, lengthCount + 1);
    retVal[count] = (c - OFFSET) + Integer.parseInt(val);
    ...
}
```

**`PalindromeGenerator.java`** — reversing a `String` (there's no `String.reverse()`, you go via `StringBuilder`):
```java
final StringBuilder reversed = new StringBuilder(word.toLowerCase()).reverse();
return word.toLowerCase().contentEquals(reversed);
```

**`kyu8/AlternatingCase.java`** — per-character case-flipping via `charAt`:
```java
for (String entry : Arrays.stream(input.split("")).toList()) {
    alternating.append(isLowerCase(entry.charAt(0)) ? entry.toUpperCase() : entry.toLowerCase());
}
```

**`kyu4/HumanReadableTimeWords.java`** — regex `replaceAll` with a negative lookahead, to replace only the *last* comma in a list with "and":
```java
// REGEX to get the last comma
return str.replaceAll(", (?!.+,)", " and ");
```

---

### 8. Other things worth having ready

**Sealed interface + pattern-matching `switch`** (`Discount.java` / `DiscountCalculator.java`) — exhaustive type modeling with zero `default` branch, the compiler enforces every case is handled:
```java
public sealed interface Discount permits PercentageOff, FixedAmountOff, NoDiscount {}
record PercentageOff(double percent) implements Discount { ... }
record FixedAmountOff(double amount) implements Discount { ... }
record NoDiscount() implements Discount { ... }
```
```java
return switch (discount) {
    case PercentageOff p -> price * (1 - p.percent());
    case FixedAmountOff f -> price - f.amount();
    case NoDiscount n -> price;
};
```

**Validating an invariant in a record's compact constructor** (`Discount.java`) — the only place validation logic for a record needs to live, since it runs for every possible way of constructing the record:
```java
public PercentageOff {
    if (percent < 0 || percent > MAX_PERCENT_OFF) {
        throw new IllegalArgumentException(...);
    }
}
```

**`Optional` for "might not exist"** (`OrderAnalyzer.java`), instead of throwing or returning a sentinel:
```java
public Optional<Order> mostExpensiveOrder(List<Order> orders) {
    if (orders == null || orders.isEmpty()) {
        return Optional.empty();
    }
    return orders.stream().max(Comparator.comparing(Order::amount));
}
```

**Mocking a collaborator to verify a conditional side effect** (`InventoryAlertServiceTest.java`) — the core shape of "verify `send()` is called only when a business rule is met":
```java
@Test
void givenMatchingProductInInventory_whenCheckStockWhereIsSufficient_thenReturnQuantityAndNoNotification() {
    when(stockCheckService.getStockQuantity("SODA")).thenReturn(3000);
    boolean isStockAvailable = inventoryAlertService.checkStock(new Product("SODA", 100));
    verifyNoInteractions(notificationGateway);
    assertTrue(isStockAvailable);
}
```

**`Objects.requireNonNullElse`** (`OrderAnalyzer.java`) — collapsing a null-check into one line without misusing `Optional` as a general-purpose null-coalescing tool:
```java
var orders1 = Objects.requireNonNullElse(orders, new ArrayList<Order>(0));
```
