package esame2016;

public abstract class ContoCorrenteException extends Exception {
  private final ContoCorrente c;

   public ContoCorrenteException(ContoCorrente c) {
        super();
        this.c = c;
   }

   public ContoCorrente getC() {
     return c;
   }
}
