package io.github.hhcarlos.designpatterns.behavioral.strategy.order.payment;

import java.math.BigDecimal;

public class ExpressShippingStrategy implements ShippingStrategy {
    private static final BigDecimal EXPRESS_SHIPPING_PRICE =
            new BigDecimal("150.00");

    @Override
    public BigDecimal calculateShippingCost(BigDecimal orderTotal) {
        return EXPRESS_SHIPPING_PRICE;
    }
}
