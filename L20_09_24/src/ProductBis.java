public class ProductBis {
    //Attributes Section
    private int productCode;
    private String productDescription;
    private float productPrice;

    public ProductBis() {
        productCode = 1;
        productDescription = "Empty Product";
        productPrice = 0;
    }

    void printProductInfo () {
        System.out.println("Product Code: " + productCode);
        System.out.println("Product Description: " + productDescription);
        System.out.println("Product Price: " + productPrice);
    }

    void setProductCode (int productCode) {
        this.productCode = productCode;
    }

    void setProductDescription (String productDescription) {
        this.productDescription = productDescription;
    }

    void setProductPrice (float productPrice) {
        this.productPrice = productPrice;
    }

    int getProductCode () {
        return this.productCode;
    }

    String getProductDescription () {
        return this.productDescription;
    }

    float getProductPrice () {
        return this.productPrice;
    }
}
