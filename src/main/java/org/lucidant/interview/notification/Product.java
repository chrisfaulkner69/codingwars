package org.lucidant.interview.notification;

public record Product(String name, int quantity) {

    public Product {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null or blank");
        }
    }

}
