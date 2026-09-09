package io.github.hhcarlos.designpatterns.behavioral.strategy.order.payment;

import java.math.BigDecimal;

public class StandardShippingStrategy implements ShippingStrategy {
    private static final BigDecimal FREE_SHIPPING_THRESHOLD =
            new BigDecimal("800.00");

    private static final BigDecimal STANDARD_SHIPPING_COST =
            new BigDecimal("80");

    @Override
    public BigDecimal calculateShippingCost(BigDecimal orderTotal) {
        System.out.println(
                "Cantidad total de la orden: " + orderTotal
        );

        if (orderTotal.compareTo(FREE_SHIPPING_THRESHOLD) >= 0) {
            return  BigDecimal.ZERO;
        }

        return STANDARD_SHIPPING_COST;
    }
}
