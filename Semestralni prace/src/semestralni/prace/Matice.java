/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
/**
 *
 * @author Moje
 */
public class Matice {
    double[][] matice;

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Matice other = (Matice) obj;
        if (!Arrays.deepEquals(this.matice, other.matice)) {
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Arrays.deepHashCode(this.matice);
        return hash;
    }

    /**
     *
     * @param rozmer
     */
    public Matice(int rozmer) {
        matice= new double[rozmer][rozmer];
    }
    
    /**
     *
     */
    public Matice(){
        
    }
    
    
  /*  public Matice() {
        matice= new double[][];
    }*/
    
    /**
     *
     * @param rozmer_x
     * @param rozmer_y
     * 
     * Vytvoří prázdnou matici o zadaných rozměrech
     */
    public Matice(int rozmer_x, int rozmer_y) {
        matice= new double[rozmer_x][rozmer_y];
        for (int i = 0; i <rozmer_x; i++) {
            for (int j = 0; j < rozmer_y; j++) {
                matice[i][j]=0;
            }
            
        }
    }
    /**
     *
     * @param arr
     * 
     * Vytvoří matici o rozměrech a obsahu zadaného pole
     */
    public Matice(double[][] arr){
        matice=arr.clone();
    }
    
    void nastavPole(int i, int j){
        matice=new double[i][j];
    }
    
    /**
     *
     * @param col
     * @param row
     * @param val
     * 
     * Nastaví hiodnout matice na zadaných souřadnicích
     */
    public void nastavHodnotu(int col,int row,double val){
        matice[row][col]=val;
    }
    
    void napln(){
        Scanner s=new Scanner(System.in);
        System.out.println("zadej prvky matice");
        for (int i = 0; i < matice.length; i++) {
            for (int j = 0; j < matice[0].length; j++) {
                while(!s.hasNextDouble()){
                    System.out.println("je nutné zadat číslo");
                    s.next();
                }
                matice[i][j]=s.nextDouble();
            }
        }
    }
    
    Matice maticeSecti(Matice B, Component cmpt){
        if((matice.length!=B.matice.length)||(matice[0].length!=B.matice[0].length)){
            JOptionPane.showMessageDialog(null, "Matice musí být stejných rozměrů", "Chyba výpočtu", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        Matice C=new Matice(this.matice);
        for (int i = 0; i < matice.length; i++) {
            for (int j = 0; j < matice[0].length; j++) {
                C.matice[i][j]+=B.matice[i][j];
            }
        }
        return C;
    }
    
    Matice transponovana(){
        Matice a=new Matice(this.matice[0].length,this.matice.length);
        for (int i = 0; i < matice.length; i++) {
            for (int j = 0; j < matice[0].length; j++) {
                a.matice[j][i]=this.matice[i][j];
            }
        }
        return a;
    }
    
    /**
     *
     * @return
     * 
     * Vrací pole tvořící matici
     */
    public double[][] GetPole(){
        return this.matice;
    }
    
    void naplnMaticiNahodne(double min,double max){
        for (int i = 0; i < matice.length; i++) {
            for (int j = 0; j < matice[0].length; j++) {
                matice[i][j]=((Math.random()*(max-min))+min);
            }
        }
    }
    void vypisMatici(){
        for (int i = 0; i < matice.length; i++) {
            System.out.print("|  ");
            for (int j = 0; j < matice[0].length; j++) {
                System.out.printf("%9.4f ",matice[i][j]); 
            }
            System.out.println("\t|");
        }
    }
    
    void nactiSoubor(String cesta, java.awt.Component cmpt){ //metoda pro nacteni soubru podle nastavenych parametru
        int i,j;
        try {
            Scanner s = new Scanner(new FileInputStream(cesta), "UTF8");
            try{
                i=s.nextInt();
                j=s.nextInt();
                s.next();
                this.nastavPole(i, j);
                for (int l = 0; l < i; l++) {
                    while(!s.hasNextDouble()){
                        if(s.hasNext()){
                            s.next();
                        }
                    }
                    for (int m = 0; m < j; m++) {
                        this.matice[l][m]=s.nextDouble();
                    }
                    //s.next();
                }
            }catch(Exception e){
                JOptionPane.showMessageDialog(cmpt, "Soubor má nesprávný formát, nebo je poškozen!", "Chyba vstupních dat", JOptionPane.WARNING_MESSAGE);
                this.matice=null;
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
    
    void ulozSoubor(String cesta, java.awt.Component cmpt){ //okládání souboru - shodné s výpisem matice na obrazovku, jen je přidáno vložení rozměrů a je vypisováno do souboru
        try{
            Writer out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(cesta), "UTF8"));
            out.write(String.format("%d  %d %n",matice.length,matice[0].length));
            for (int i = 0; i < matice.length; i++) {
                out.write("|  ");
                for (int j = 0; j < matice[0].length; j++) {
                    out.write(String.format("%9.4f ",matice[i][j])); 
                }
                out.write(String.format("\t| %n"));
            }
            out.close();
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(cmpt, "Soubor nelze vytvořit, pravděpodobně nemáte dostatečná práva pro zápis v daném umístění", "Chyba ukládání", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    void vypis(javax.swing.JPanel p){
        p.setLayout(new java.awt.GridLayout(matice.length,matice[0].length));
        Border border = BorderFactory.createLineBorder(Color.BLACK,1);
        for (int i = 0; i < matice.length; i++) {
            for (int j = 0; j < matice[0].length; j++) {
                JTextField lab=new JTextField(String.format("%.3f",matice[i][j]));
                lab.setHorizontalAlignment(JTextField.CENTER);
                lab.setEditable(false);
                lab.setBorder(border);
                p.add(lab);
            //    p.add(new JLabel(String.format("%.2f",matice[i][j])).setBorder(border));
            }
        }
    }
    
    Matice vynasob(Matice A){
        if (matice[0].length!=A.matice.length){
            JOptionPane.showMessageDialog(null, "Matice těchto rozměrů nelze násobit!", "Chyba výpočtu", JOptionPane.WARNING_MESSAGE);
            return null;
        }
        Matice B=new Matice(matice.length,A.matice[0].length);
        for (int i = 0; i < B.matice.length; i++) {
            for (int j = 0; j < B.matice[0].length; j++) {
                B.matice[i][j]=0;
                for (int k = 0; k < matice[0].length; k++) {
                    B.matice[i][j]+=matice[i][k]*A.matice[k][j];
                }
            }
        }
        return B;
    }
    Matice vynasob(double skalar){
        Matice B=new Matice(matice.length,matice[0].length);
        for (int i = 0; i < matice.length; i++) {
            for (int j = 0; j < matice[0].length; j++) {
                B.matice[i][j]=skalar*matice[i][j];
            }
        }
        return B;
    }
    double determinant(){
        return determinant(matice); 
    }
    double determinant(double[][] mat){
        double det=0;
        if(mat.length!=mat[0].length){
            JOptionPane.showMessageDialog(null, "Determinant lze počítat jen u čtvercových matic!", "Chyba výpočtu", JOptionPane.WARNING_MESSAGE);
            return Double.MAX_VALUE;
        }
        if(mat.length==1){
            return mat[0][0];
        }
        if(mat.length==2){
            return ((mat[0][0]*mat[1][1])-(mat[0][1]*mat[1][0]));
        }
        for (int i = 0; i < mat.length; i++) {//nahrazovaný sloupec původní matice
            double temp[][]=new double[mat.length-1][mat.length-1];
            for (int j = 0; j < mat.length; j++) {  //j-momentálně obsazovaný sloupec
                for (int k = 0; k < temp.length; k++) { //obsazení všech sloupců
                    if(j<i){
                        temp[k][j]=mat[k+1][j];
                    }else if(j>i){
                        temp[k][j-1]=mat[k+1][j];
                    }
                }
            }
            det+=mat[0][i]*(Math.pow((-1), i))*determinant(temp);
        }
        return det;
    }
}
