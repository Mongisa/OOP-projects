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
        this(0,"Empty Product", 0F);
    }

    public Product(int productCode) {
        this.productCode = productCode;
    }

    public Product(float productPrice) {
        this.productCode = 0;
        this.productPrice = productPrice;
    }

    //Methods Section
    public void printProductInfo () {
        System.out.println("Product Code: " + productCode);
        System.out.println("Product Description: " + productDescription);
        System.out.println("Product Price: " + productPrice);
    }

    //Cannot use anymore because productCode is a constant
    /*void setProductCode (int productCode) {
        this.productCode = productCode;
    }*/

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
}