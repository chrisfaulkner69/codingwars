package org.lucidant.interview.customeroffers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OfferService {

    private final CustomerClient customerClient;

    public OfferService(CustomerClient customerClient) {
        this.customerClient = customerClient;
    }

    public List<String> getOffers(String customerId) {

        var customer = customerClient.getCustomer(customerId);
        if (customer == null || !customer.active()) {
            return Collections.emptyList();
        }

        List<String> offers = new ArrayList<>();
        if (customer.age() >= 0) {
            offers.add(OfferType.STANDARD.name());
            if (customer.age() >= 65) {
                offers.add(OfferType.SENIOR.name());
            }
        }

        return offers;
    }
}
