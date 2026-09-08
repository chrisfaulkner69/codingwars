package org.lucidant.interview.reference;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExamples {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        CompletableFuture<Integer> supplyThenApply = CompletableFuture
                .supplyAsync(() -> 10)
                .thenApply(x -> x * 2);
        System.out.println("thenApply: " + supplyThenApply.get());

        CompletableFuture<Integer> thenCompose = CompletableFuture
                .supplyAsync(() -> 10)
                .thenCompose(x -> CompletableFuture.supplyAsync(() -> x * 3));
        System.out.println("thenCompose (chaining two async calls): " + thenCompose.get());

        CompletableFuture<Integer> thenCombine = CompletableFuture.supplyAsync(() -> 4)
                .thenCombine(CompletableFuture.supplyAsync(() -> 6), Integer::sum);
        System.out.println("thenCombine (two independent futures): " + thenCombine.get());

        CompletableFuture<Integer> recovered = CompletableFuture
                .supplyAsync(() -> { throw new RuntimeException("boom"); })
                .exceptionally(ex -> -1)
                .thenApply(x -> (Integer) x);
        System.out.println("exceptionally: " + recovered.get());

        var futures = List.of(
                CompletableFuture.supplyAsync(() -> 1),
                CompletableFuture.supplyAsync(() -> 2),
                CompletableFuture.supplyAsync(() -> 3));
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        int total = futures.stream().mapToInt(CompletableFuture::join).sum();
        System.out.println("allOf then sum: " + total);
    }
}
