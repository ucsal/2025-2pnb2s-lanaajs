package br.com.mariojp.solid.srp;

public class ReceiptService {

	// variáveis de instância
    private final TaxCalculator taxCalculator;
    private final ReceiptFormatter formatter;

	// construtor
    public ReceiptService(TaxCalculator taxCalculator, ReceiptFormatter formatter) {
        this.taxCalculator = taxCalculator;
        this.formatter = formatter;
    }

	// metodo para gerar o recibo
    public String generate(Order order) {

		// calcular subtotal, taxa e total
        double subtotal = order.getItems().stream().mapToDouble(i -> i.getUnitPrice() * i.getQuantity()).sum();
        double tax = taxCalculator.calculate(subtotal);
        double total = subtotal + tax;

        return formatter.format(order, subtotal, tax, total);
    }
}