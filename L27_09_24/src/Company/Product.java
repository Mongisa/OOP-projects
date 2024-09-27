package Company;

public class Product {
    //Attributes Section
    private final int productCode; //"final" indicates a constant
    private String productDescription;
    private float productPrice;
    private static int productCount; //"static" indicates that the variable is "global"

    //Explicit Constructor
    public Product(int productCode, String productDescription, float productPrice) {
        this.productCode = productCode;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        productCount++;
    }

    //Another version of the Constructor (overloading dei metodi)
    public Product() {
        //You can call a constructor in another constructor using this()
        this(0,"Empty Company.Product", 0F);
    }

    //Methods Section
    public void printProductInfo () {
        System.out.println("Company Code: " + productCode);
        System.out.println("Company Description: " + productDescription);
        System.out.println("Company Price: " + productPrice + " €");
    }

    public void setProductDescription (String productDescription) {
        this.productDescription = productDescription;
    }

    public void setProductPrice (float productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductCode () {
        return this.productCode;
    }

    public String getProductDescription () {
        return this.productDescription;
    }

    public float getProductPrice () {
        return this.productPrice;
    }

    //Class Method
    public static int getProductCount () {
        return productCount;
    }

    public static class Main {
        public static void main(String[] args) {
            System.out.println("Hello world!");
        }
    }
}