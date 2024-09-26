public class Main {
    public static void main(String[] args) {
        Invoice invoice1 = new Invoice(0,"April 2024");

        invoice1.insertProduct(new Product(0,"Pencil",1.5F));
        invoice1.insertProduct(new Product(1,"Rubber",3F));
        invoice1.insertProduct(new Product(2,"Pen",2F));

        invoice1.printInvoiceSummary();

        //Not requested
        System.out.println("Total expense: " + invoice1.getTotalExpense() + " €");
    }
}