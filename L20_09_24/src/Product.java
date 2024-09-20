public class Product {
    //Attributes Section
    int productCode;
    String productDescription;
    float productPrice;

    void printProductInfo () {
        System.out.println("Product Code: " + productCode);
        System.out.println("Product Description: " + productDescription);
        System.out.println("Product Price: " + productPrice);
    }
}