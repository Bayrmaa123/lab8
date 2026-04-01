public class Main {
    public static void main(String[] args) {
        // Агуулах үүсгэх
        Warehouse w = new Warehouse("Tuv aguulah");

        // Бараа нэмэх
        w.addProduct("Laptop", 10);
        w.addProduct("Phone", 20);

        // Бараа хасах
        w.removeProduct("Laptop", 3);

        // Үр дүнг хэвлэх
        System.out.println("--- " + w.getName() + " ---");
        w.showProducts();
        
        System.out.println("\n--- Guilgeenii tuuh ---");
        w.showTransactions();
    }
}