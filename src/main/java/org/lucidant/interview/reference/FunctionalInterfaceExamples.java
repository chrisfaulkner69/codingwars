package org.lucidant.interview.reference;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FunctionalInterfaceExamples {

    @FunctionalInterface
    interface Validator<T> {
        boolean isValid(T value);
    }

    public static void main(String[] args) {

        Function<Integer, Integer> square = x -> x * x;
        Function<Integer, Integer> addOne = x -> x + 1;
        System.out.println("Function.andThen: " + square.andThen(addOne).apply(3));
        System.out.println("Function.compose: " + square.compose(addOne).apply(3));

        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println("BiFunction: " + add.apply(2, 5));

        Predicate<Integer> isEven = n -> n % 2 == 0;
        Predicate<Integer> isPositive = n -> n > 0;
        System.out.println("Predicate.and: " + isEven.and(isPositive).test(4));
        System.out.println("Predicate.negate: " + isEven.negate().test(4));

        Supplier<String> greeting = () -> "hello";
        System.out.println("Supplier: " + greeting.get());

        Consumer<String> printer = System.out::println;
        List.of("a", "b", "c").forEach(printer);

        UnaryOperator<String> shout = s -> s.toUpperCase();
        System.out.println("UnaryOperator: " + shout.apply("quiet"));

        Validator<String> notBlank = s -> s != null && !s.isBlank();
        System.out.println("Custom functional interface: " + notBlank.isValid("  "));
    }
}
