import Company.Invoice;
import Company.Product;

public class Main {
    public static void main(String[] args) {
        Invoice i1 = new Invoice(35,"Stationery purchase invoice", 4);

        i1.insertProduct(new Product(2, "Pencil", 1.5F));
        i1.insertProduct(new Product(4,"Pen",0.8F));

        i1.printProducts();
    }
}