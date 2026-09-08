package org.lucidant.interview.notification;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InventoryAlertServiceTest {

    @Mock
    private StockCheckService stockCheckService;

    @Mock
    private NotificationGateway notificationGateway;


    private InventoryAlertService inventoryAlertService;


    @BeforeEach
    void beforeEach() {
        Map<String, Integer> stockQuantity = new HashMap<>();
        stockQuantity.put("MILK", 100);
        stockQuantity.put("BEER", 200);
        inventoryAlertService = new InventoryAlertService(notificationGateway, stockCheckService, stockQuantity);
    }

    @Test
    void givenInvalidParameter_whenCheckStock_thenIllegalArgumentException() {
       assertThrows(IllegalArgumentException.class, () -> inventoryAlertService.checkStock(null));
    }

    @Test
    void givenMatchingProductsInInventory_whenCheckStockIsBelowTarget_thenReturnFalseAndSendNotification() {

        when(stockCheckService.getStockQuantity("BEER")).thenReturn(100);

        boolean isStockAvailable = inventoryAlertService.checkStock(new Product("BEER",200));

        verify(notificationGateway).send("RECIPIENT", "BEER");
        assertFalse(isStockAvailable);
    }

    @Test
    void givenNoMatchingProductsInInventory_whenCheckStock_thenReturnZero() {

        when(stockCheckService.getStockQuantity("SODA")).thenReturn(-1);

        boolean isStockAvailable = inventoryAlertService.checkStock(new Product("SODA",100));

        verify(notificationGateway).send("RECIPIENT", "SODA");
        assertFalse(isStockAvailable);
    }

    @Test
    void givenMatchingProductInInventory_whenCheckStockWhereIsSufficient_thenReturnQuantityAndNoNotification() {

        when(stockCheckService.getStockQuantity("SODA")).thenReturn(3000);

        boolean isStockAvailable = inventoryAlertService.checkStock(new Product("SODA",100));

        verifyNoInteractions(notificationGateway);
        assertTrue(isStockAvailable);
    }
}
