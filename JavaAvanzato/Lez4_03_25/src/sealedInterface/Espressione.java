package sealedInterface;

public sealed interface Espressione permits Descrivibile {
    int valuta();
}

non-sealed interface Descrivibile extends Espressione {
    void descrivi();
}