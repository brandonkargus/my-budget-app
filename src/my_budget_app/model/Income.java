package my_budget_app.model;

public class Income {
    private int amount;
    private String source;
    private String frequency;

    public Income(int amount, String source, String frequency) {
        this.amount = amount;
        this.source = source;
        this.frequency = frequency;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    @Override
    public String toString() {
        return "Income profile for this entry...." + "\r\n" +
                "Amount: " + amount + "\r\n" +
                "Source: " + source + "\r\n" +
                "Frequency:'" + frequency;
    }
}
