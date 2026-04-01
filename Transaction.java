 import java.time.LocalDate;

public class Transaction {
    private String type;
    private String productName;
    private int amount;
    private LocalDate date;

    public Transaction(String type, String productName, int amount) {
        this.type = type;
        this.productName = productName;
        this.amount = amount;
        this.date = LocalDate.now();
    }

    public void printTransaction() {
        System.out.println(type + " | " + productName + " | " + amount + " | " + date);
    }
} 
