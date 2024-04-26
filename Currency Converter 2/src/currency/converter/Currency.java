package currency.converter;

abstract class Currency {
    private String currIn;
    private String currOut;
    
    public Currency(String currIn, String currOut) {
        this.currIn = currIn;
        this.currOut = currOut;
    }
    
    protected String Key() {
        return currIn+"-"+currOut;
    }
    
    protected abstract double ConvertAmount();
}