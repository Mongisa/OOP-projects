public class Invoice {
    private int id = 0;
    private String description;
    private Product[] products;
    private int count = 0;

    public Invoice(int id, String description) {
        this.id = id;
        this.description = description;
        this.products = new Product[50];
    }

    public Invoice(int id, String description, int size) {
        this.id = id;
        this.description = description;
        this.products = new Product[size];
    }

    public void insertProduct(Product product) {
        if(this.count == this.products.length-1) {
            System.out.println("Invoice is full!");
            return;
        }

        this.products[count++] = product;
    }

    public void printInvoiceSummary() {
        System.out.println("Description: "+ this.description);
        System.out.println("Id: "+ this.id);
        System.out.println("List of products:");

        for(int i=0;i<this.count;i++) {
            this.products[i].printProductInfo();
            System.out.println();
        }
    }

    //Not requested
    public float getTotalExpense() {
        float expense = 0;

        for(int i=0;i<this.count;i++)
            expense+=this.products[i].getProductPrice();

        return expense;
    }
}
