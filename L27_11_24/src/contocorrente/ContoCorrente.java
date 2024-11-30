package contocorrente;

public class ContoCorrente {
    private double saldo;

    public ContoCorrente(double saldo) {
        this.saldo = saldo;
    }

    public synchronized double getSaldo() {
        return saldo;
    }

    public synchronized void versa(double importo) {
        if(importo<=0) throw new RuntimeException("Non è possibile versare importo:" + importo);

        saldo += importo;
    }

    public synchronized void preleva(double importo) {
        if(importo<=0 || importo>saldo) throw new RuntimeException("Non è possibile prelevare importo:" + importo);
        saldo -= importo;
    }
}
