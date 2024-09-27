package Company;

public class Invoice {
    private int invoiceCode;
    private String invoiceDescription;
    private Product products[];
    private int num;

    public Invoice(int invoiceCode, String invoiceDescription, int productNum) {
        this.invoiceCode = invoiceCode;
        this.invoiceDescription = invoiceDescription;
        this.products = new Product[productNum];
        this.num = 0;
    }

    public void insertProduct(Product p) {
        if(this.products.length == this.num) {
            System.out.println("Products array full!");
            return;
        }

        this.products[num++] = p;
    }

    public void printProducts() {
        System.out.println("Products in the invoice:");

        for(int i=0;i<this.num;i++) {
            this.products[i].printProductInfo();
            System.out.println();
        }
    }
}
