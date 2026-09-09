package org.lucidant.interview.notification;

import java.util.Map;

public class InventoryAlertService {

    private final Map<String, Integer> minQuantityLevels;

    private final NotificationGateway notificationGateway;

    private final StockCheckService stockCheckService;

    public InventoryAlertService(NotificationGateway notificationGateway,
                                 StockCheckService stockCheckService,
                                 Map<String, Integer> minQuantityLevels) {
        this.notificationGateway = notificationGateway;
        this.stockCheckService = stockCheckService;
        this.minQuantityLevels = minQuantityLevels;
    }

    public boolean checkStock(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("product is null");
        }

        final int stockQuantity = stockCheckService.getStockQuantity(product.name());
        if (stockQuantity < product.quantity() || stockQuantity < minQuantityLevels.getOrDefault(product.name(), 100)) {
            notificationGateway.send("RECIPIENT", product.name());
            return false;
        }

        return true;
    }
}
