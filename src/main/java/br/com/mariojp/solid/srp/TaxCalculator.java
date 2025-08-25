package br.com.mariojp.solid.srp;

public class TaxCalculator {
    
    // variável de instância
    private double tax;

    // construtor que lê a taxa de imposto de uma propriedade do sistema
    public TaxCalculator() {
        String rate = System.getProperty("tax", "0.0");
        this.tax = Double.parseDouble(rate);
    }

    // método para calcular o imposto com base no subtotal
    public double calculate(double subtotal) {
        return subtotal * tax;
    }
}
