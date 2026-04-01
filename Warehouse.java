import java.util.ArrayList;

public class Warehouse {
    private String name;
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<Transaction> transactions = new ArrayList<>();

    public Warehouse(String name) {
        this.name = name;
    }

    // VS Code-ын "name is not used" анхааруулгыг арилгахын тулд getter нэмэв
    public String getName() {
        return name;
    }

    public void addProduct(String name, int quantity) {
        boolean found = false;
        
        // 1. Бүртгэлтэй бараа байгаа эсэхийг шалгах
        for (Product p : products) {
            if (p.getName().equals(name)) {
                p.addQuantity(quantity);
                found = true;
                break;
            }
        }

        // 2. Хэрэв шинэ бараа бол жагсаалтад нэмэх
        if (!found) {
            products.add(new Product(name, quantity));
        }

        // 3. Гүйлгээг бүртгэх (Аль ч тохиолдолд "IN" гүйлгээ хийгдэнэ)
        transactions.add(new Transaction("IN", name, quantity));
    }

    public void removeProduct(String name, int quantity) {
        for (Product p : products) {
            if (p.getName().equals(name)) {
                // Энд хасах логикоо бичнэ (жишээ нь p.subtractQuantity(quantity))
                transactions.add(new Transaction("OUT", name, quantity));
                return;
            }
        }
        System.out.println("Baraa oldsongui: " + name);
    }
    // Агуулах дахь бараануудыг хэвлэж харуулах функц
    public void showProducts() {
        System.out.println("--- Odoo baigaa baraanuud ---");
        for (Product p : products) {
            // Product класс дотор getName() болон getQuantity() байгаа гэж үзэв
            System.out.println("Ner: " + p.getName() + " | Too: " + p.getQuantity());
        }
    }

    // Бүх гүйлгээний түүхийг хэвлэж харуулах функц
    public void showTransactions() {
        System.out.println("--- Guilgeenii tuuh ---");
        for (Transaction t : transactions) {
            // Transaction класс дотор toString() эсвэл харуулах функц байгаа гэж үзэв
            System.out.println(t.toString()); 
        }
    }
}