/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Scanner;

//import javax.swing.

/**
 *
 * @author Moje
 */





public class SemestralniPrace {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      /*  
        HlavniOkno o=new HlavniOkno();
        o.setVisible(true);
        */
        Scanner scan= new Scanner(System.in);
        System.out.println("Nacteni prvniho operandu 1 pro rucne, 2 ze souboru, 3 pro ukonceni");
        int i;
        i=prectiInt(1,3);
        int j=0,k=0;
       // Matice prvni=new Matice();
        Matice prvni=new Matice();
        switch (i){
            case 1: System.out.println("Zadej velikost matice");
                System.out.println("Zadej pocet radku");
                j=prectiInt(0,Integer.MAX_VALUE);
                System.out.println("Zadej pocet sloupcu");
                k=prectiInt(0,Integer.MAX_VALUE);    
                break;
            case 2: prvni=nactiSoubor();
                break;
            case 3: 
                System.out.println("Vypinam se");
                return;
        }
        if (i==1){
            prvni.nastavPole(j,k);
            prvni.napln();
        }
        else{
            if(prvni==null){
                return;
            }
        }
        System.out.println("Zadal jsi nasledujici matici:");
        prvni.vypisMatici();
        System.out.println("");
        System.out.println("vyber co chces udelat:");
        System.out.println("1 - Determinant");
        System.out.println("2 - Transponuj");
        System.out.println("3 - Pricti");
        System.out.println("4 - Vynasob matici");
        System.out.println("5 - Vynasob skalarem");
        System.out.println("6 - Odecti");
        System.out.println("7 - Ukonci");
        i=prectiInt(1,7);
        Matice vysledek=new Matice();
        switch (i){
            case 7:
                return;
            case 1: 
                System.out.println("Determinant matice je: ");
                System.out.println(prvni.determinant());
                return;
            case 2:
                vysledek=prvni.transponovana();
                break;
            case 3:
                napln(vysledek);
                vysledek=prvni.maticeSecti(vysledek);
                break;
            case 4:
                napln(vysledek);
                vysledek=prvni.vynasob(vysledek);
                break;
            case 5:
                double l;
                System.out.println("Zadej skalár");
                while(!scan.hasNextDouble()){
                    System.out.println("je nutné zadat číslo");
                    scan.next();
                }
                l=scan.nextDouble();
                vysledek=prvni.vynasob(l);
                break;
            case 6:
                napln(vysledek);
                vysledek=prvni.maticeSecti(vysledek.vynasob(-1));
        }
        if (vysledek==null){
            return;
        }
        System.out.println("Výsledek je: ");
        vysledek.vypisMatici();
        System.out.println("Chcete ulozit vysledek do souboru?");
        System.out.println("1-ANO");
        System.out.println("2-NE");
        i=prectiInt(1,2);
        if (i==1){
            ulozSoubor(vysledek);
        }
    }
    static void napln(Matice matice){
        System.out.println("Vyber metodu plnění matice");
        System.out.println("1 - ručně");
        System.out.println("2 - náhodně");
        //System.out.println("3 - ze souboru");
        int k;
        k = prectiInt(1,3);
       /* if (k==3){
            matice = nactiSoubor();
            return;
        }*/
        System.out.println("Zadej velikost matice");
        System.out.println("Zadej pocet radku");
        Scanner scan=new Scanner(System.in);
        int i,j;
        i=prectiInt(0,Integer.MAX_VALUE);
        System.out.println("Zadej pocet sloupcu");
        j=prectiInt(0,Integer.MAX_VALUE);
        matice.nastavPole(i, j);
        if (k==1){
           matice.napln();
        }
        else{
            while(true){
                double n,l;
                System.out.println("zadej min");
                while(!scan.hasNextDouble()){
                    System.out.println("je nutné zadat číslo");
                    scan.next();
                }
                n=scan.nextDouble();
                System.out.println("zadej max");
                while(!scan.hasNextDouble()){
                    System.out.println("je nutné zadat číslo");
                    scan.next();
                }
                l=scan.nextDouble();
                if (n<l){
                    matice.naplnMaticiNahodne(n, l);
                    break;
                }
                System.out.println("min musí být menší, než max");
            }
        }
    }
    static int prectiInt(int min, int max){
        Scanner scan=new Scanner(System.in);
        int i=0;
        while(scan.hasNext()){
            if(scan.hasNextInt()){
                i=scan.nextInt();
                if(i>=min&&i<=max){
                    break;
                }
            }
            else{
                scan.next();
            }
            System.out.println("je nutné zadat cele kladne číslo");
        }
        return i;
    }
    
    static Matice nactiSoubor(){ //metoda pro nacteni soubru podle nastavenych parametru
        int i,j;
        Matice M = new Matice();
        try {
            Scanner s = new Scanner(new FileInputStream("matice.txt"), "UTF8");
            try{
                i=s.nextInt();
                j=s.nextInt();
                s.next();
                M.nastavPole(i, j);
                for (int l = 0; l < i; l++) {
                    while(!s.hasNextDouble()){
                        if(s.hasNext()){
                            s.next();
                        }
                    }
                    for (int m = 0; m < j; m++) {
                        M.matice[l][m]=s.nextDouble();
                    }
                    //s.next();
                }
            }catch(Exception e){
                System.out.println("Soubor má špatný formát");
                System.out.println("Error: " + e.getMessage());
                return null;
            }
            return M;
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        return null;
    }
    
    static void ulozSoubor(Matice mat){ //okládání souboru - shodné s výpisem matice na obrazovku, jen je přidáno vložení rozměrů a je vypisováno do souboru
        try{
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("matice.txt"), "UTF8"));
            out.write(String.format("%d  %d %n",mat.matice.length,mat.matice[0].length));
            for (int i = 0; i < mat.matice.length; i++) {
                out.write("|  ");
                for (int j = 0; j < mat.matice[0].length; j++) {
                    out.write(String.format("%9.4f ",mat.matice[i][j])); 
                }
                out.write(String.format("\t| %n"));
            }
            out.close();
        } catch (UnsupportedEncodingException e) {
        } catch (IOException e) {
        }
    }
}
