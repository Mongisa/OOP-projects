public class Main {
    public static void main(String[] args) {

        Product p1; //Not initialized variable, only declared
        p1 = new Product(); //Initialization

        p1.productCode = 3;
        p1.productDescription = "Pen";
        p1.productPrice = 1.5f; //1.5 is double type!

        p1.printProductInfo();
    }
}