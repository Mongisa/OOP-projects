package alessandromonte;

import sun.net.www.http.HttpCaptureInputStream;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) throws Exception {
        String url = "https://raw.githubusercontent.com/pcm-dpc/COVID-19/master/dati-province/dpc-covid19-ita-province-20211229.csv";
        try(Scanner isr = new Scanner(new BufferedInputStream((new URL(url)).openStream()))) {
            isr.nextLine();
            System.out.println(isr.nextLine());
        };
    }
}
