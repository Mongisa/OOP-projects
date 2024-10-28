package distributore;

import distributore.bibite.*;

public class TestDistributore {
    public static void main(String[] args) {
        Distributore d = new Distributore();
        
        System.out.println(d);
        
        
        System.out.println("(main) inserisco normalmente------------------------");
        try{
            d.registraTessera(61270);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        try{
            d.registraTessera(61271);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        try{
            d.registraTessera(61272);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        try{
            d.caricaTessera(61270, 50.77);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        try{
            d.caricaTessera(61270, 10);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        try{
            d.caricaTessera(61271, 22);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        try{
            d.caricaTessera(61272, 5.5);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        try{
            d.registraBibita(new Sorgesana("AIS167","Sorgesana",2,4));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        try{
            d.caricaBibita("AIS167",1);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        try{
            d.registraBibita(new CocaCola("AHJ167","Coca-Cola",3.5,2));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        try{
            d.registraBibita(new Estathe("AOO167","Estathe",2.5,3));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        System.out.println(d);
        
        
        System.out.println("(main) provo eccezione: CodiceTesseraPresenteException");
        try{
            d.registraTessera(61270);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        System.out.println("(main) provo eccezione: CodiceBibitaPresenteException");
        try{
            d.registraBibita(new Estathe("AOO167","Estathe",2.5,4));
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }        
        
        System.out.println("(main) provo eccezione: TesseraNonValidaException");
        try{
            d.caricaTessera(61273, 50.77);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        try{
            d.eroga("AOO167",61273);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        System.out.println("(main) provo eccezione: BibitaNonPresenteException");
        try{
            d.caricaBibita("AIS187",1);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        try{
            d.eroga("ZZZ167",61272);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
               
        System.out.println("(main) prelevo con la tessera 61272 gli estathe");
        try{
            d.eroga("AOO167",61272);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        try{
            d.eroga("AOO167",61272);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(d);
        
        
        System.out.println("(main) provo eccezione: CreditoInsufficienteException");
        try{
            d.eroga("AOO167",61272);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        
        
        System.out.println("(main) provo eccezione: BibitaEsauritaException");
        try{
            d.eroga("AOO167",61270);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        try{
            d.eroga("AOO167",61270);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        System.out.println(d);
    }
}
