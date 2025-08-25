package br.com.mariojp.solid.srp;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ReceiptServiceTest {

    @Test
    void uses_configured_tax_rate_of_8_percent() {
        // configura taxa
        System.setProperty("tax.rate", "0.08");

        // monta pedido
        Order order = new Order();
        order.add(new Item("Café", 8.0, 2));   // 16
        order.add(new Item("Bolo", 12.5, 1)); // 12.5 -> subtotal 28.5

        // cria service com dependências
        ReceiptService service = new ReceiptService(new TaxCalculator(), new ReceiptFormatter());

        String receipt = service.generate(order);

        assertTrue(receipt.contains("Subtotal: 28.5"));
        assertTrue(receipt.contains("Tax: 2.28"), "Deve respeitar tax.rate=0.08");
        assertTrue(receipt.contains("Total: 30.78"));
    }
}
