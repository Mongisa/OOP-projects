public class Main {
    //Main is static because it needs to be reachable without any object instances
    public static void main(String[] args) {

        Product p1 = new Product(1,"Pen",1.5F);
        Product p2 = new Product(2,"Pencil",2.5F);

        Product p = p1; //p will point to the same address as p1. It's NOT a new object!

        //p1.setProductCode(1);
        //p1.setProductDescription("Pen");
        //p1.setProductPrice(1.5F);

        p1.printProductInfo();
        p2.printProductInfo();

        System.out.println(Product.getProductCount());
    }
}