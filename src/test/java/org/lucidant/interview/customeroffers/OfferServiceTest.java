package org.lucidant.interview.customeroffers;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OfferServiceTest {

    @Mock
    private CustomerClient customerClient;

    @InjectMocks
    private OfferService offerService;

    @Test
    void whenCustomerIdIsNotFound_whenGetOffers_thenReturnEmptyList() {

        when(customerClient.getCustomer("ID1")).thenReturn(null);

        assertEquals(0, offerService.getOffers("ID1").size());
    }

    @Test
    void whenActiveCustomerFound_whenGetOffers_thenReturnOffer() {

        var customer = new Customer("ID1", true, 25);
        when(customerClient.getCustomer("ID1")).thenReturn(customer);

        var offers =  offerService.getOffers("ID1");

        assertEquals(1, offers.size());
        assertEquals("STANDARD", offers.getFirst());
    }

    @Test
    void whenInactiveCustomerFound_whenGetOffers_thenReturnEmptyList() {

        var customer = new Customer("ID1", false, 25);
        when(customerClient.getCustomer("ID1")).thenReturn(customer);

        var offers =  offerService.getOffers("ID1");

        assertEquals(0, offers.size());
    }

    @Test
    void whenCustomerSeniorTypeFound_whenGetOffers_thenReturnAppropriateOffers() {

        var customer = new Customer("ID1", true, 65);
        when(customerClient.getCustomer("ID1")).thenReturn(customer);

        var offers =  offerService.getOffers("ID1");

        assertEquals(2, offers.size());
        assertEquals("STANDARD", offers.getFirst());
        assertEquals("SENIOR", offers.getLast());
    }
}
