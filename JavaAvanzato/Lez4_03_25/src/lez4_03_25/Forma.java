package lez4_03_25;

//Classe sigillata
//Permits specifica le classi che possono specificarla (che devono già essere definite)
public sealed class Forma permits Ellisse, Triangolo {

}

non-sealed class Triangolo extends Forma {

}

/*
* Le classi sigillate possono essere specializzate da classi
* che risiedono nello stesso package o stesso modulo (un modulo
* raccoglie più package)
*/