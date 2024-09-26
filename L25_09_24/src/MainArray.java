public class MainArray {
    public static void main(String[] args) {
        int vett[];

        vett = new int[3];

        for(int i=0; i<vett.length; i++) {
            System.out.println(vett[i]);
        }

        Product products[] = new Product[2];

        products[0] = new Product();
        products[1] = new Product(3,"pen", 1.5F);

        for(int i=0; i<products.length; i++) {
            products[i].printProductInfo();
        }
    }
}