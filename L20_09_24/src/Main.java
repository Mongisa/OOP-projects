public class Main {
    public static void main(String[] args) {

        Product p1; //Not initialized variable, only declared
        p1 = new Product(); //Initialization

        p1.productCode = 3;
        p1.productDescription = "Pen";
        p1.productPrice = 1.5f; //1.5 is double type!

        Product p2 = new Product();

        p2.productCode = 2;
        p2.productDescription = "Pencil";
        p2.productPrice = 2f;

        //p1.printProductInfo();
        //p2.printProductInfo();

        ProductBis p3 = new ProductBis();

        p3.setProductCode(2);
        p3.setProductDescription("Pencil");
        p3.setProductPrice(3f);

        p3.printProductInfo();
        System.out.println(p3.getProductCode());
    }
}