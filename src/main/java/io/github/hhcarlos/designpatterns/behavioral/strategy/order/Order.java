package io.github.hhcarlos.designpatterns.behavioral.strategy.order;

import io.github.hhcarlos.designpatterns.behavioral.strategy.order.payment.ShippingStrategy;

import java.math.BigDecimal;

public class Order {
    private BigDecimal orderTotal;
    private ShippingStrategy shippingStrategy;

    public Order(BigDecimal orderTotal, ShippingStrategy shippingStrategy) {
        this.orderTotal = orderTotal;
        this.shippingStrategy = shippingStrategy;
    }

    public BigDecimal calculateShippingCost() {
        return this.shippingStrategy.calculateShippingCost(this.orderTotal);
    }

    public void setShippingStrategy(ShippingStrategy newStrategy) {
        this.shippingStrategy = newStrategy;
    }

    public BigDecimal orderTotalWithShippingCost() {
        return this.orderTotal.add(this.calculateShippingCost());
    }
}
