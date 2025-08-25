import br.com.mariojp.solid.srp.*;

public class Main {
    public static void main(String[] args) {

        // configurando taxa 
        System.setProperty("tax.rate", "0.85");

        Order o = new Order();

        o.add(new Item("Café", 8.0, 2));   // 16
        o.add(new Item("Bolo", 12.5, 1)); 

        ReceiptService service = new ReceiptService(new TaxCalculator(), new ReceiptFormatter());
        String receipt = service.generate(o);

        System.out.println(receipt);
    }
}
