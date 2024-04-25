package currency.converter;

public class Currency {
    private String currIn;
    private String currOut;
    private double amount;
    
    public Currency(String currIn, String currOut, double amount) {
        this.currIn = currIn;
        this.currOut = currOut;
        this.amount = amount;
    }
    
    public double getAmount() {
        return amount;
    }
}