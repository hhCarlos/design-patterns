package io.github.hhcarlos.designpatterns.behavioral.strategy.order;

import io.github.hhcarlos.designpatterns.behavioral.strategy.order.payment.ExpressShippingStrategy;
import io.github.hhcarlos.designpatterns.behavioral.strategy.order.payment.StandardShippingStrategy;

import java.math.BigDecimal;

public final class OrderExample {

    private OrderExample() {}

    public static void run() {
        Order uno_orden = new Order(
                new BigDecimal("500"),
                new StandardShippingStrategy()
        );

        System.out.println("Costo de envio (500): " + uno_orden.calculateShippingCost());
        System.out.println("Total la orden de 500: " + uno_orden.orderTotalWithShippingCost());

        Order dos_orden = new Order(
                new BigDecimal("1200"),
                new ExpressShippingStrategy()
        );

        System.out.println("Costo de envio (1200): " + dos_orden.calculateShippingCost());
        System.out.println("Total la orden de 1200: " + dos_orden.orderTotalWithShippingCost());

        dos_orden.setShippingStrategy(new StandardShippingStrategy());

        System.out.println("Costo de envio (1200): " + dos_orden.calculateShippingCost());
        System.out.println("Total la orden de 1200: " + dos_orden.orderTotalWithShippingCost());
    }
}
