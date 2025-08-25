package br.com.mariojp.solid.srp;

public class ReceiptFormatter {

    // método para formatar o recibo
    public String format(Order order, double subtotal, double tax, double total) {

        StringBuilder sb = new StringBuilder();

        // formatação do recibo
        sb.append("=== RECIBO ===\n");

        // detalhes do pedido
        for (var i : order.getItems()) {
            sb.append(i.getName())
              .append(" x").append(i.getQuantity())
              .append(" = ").append(i.getUnitPrice() * i.getQuantity())
              .append("\n");
        }

        sb.append("Subtotal: ").append(subtotal).append("\n");
        sb.append("Tax: ").append(tax).append("\n");
        sb.append("Total: ").append(total).append("\n");

        return sb.toString();
    }
}
