/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package semestralni.prace;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Moje
 */
public class Matice {
    double[][] matice;

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Arrays.deepHashCode(this.matice);
        return hash;
    }

    public Matice(int rozmer) {
        matice= new double[rozmer][rozmer];
    }
    
    public Matice(){
        
    }
    
    
  /*  public Matice() {
        matice= new double[][];
    }*/
    
    public Matice(int rozmer_x, int rozmer_y) {
        matice= new double[rozmer_x][rozmer_y];
    }
    public Matice(double[][] arr){
        matice=arr.clone();
    }
    
    void nastavPole(int i, int j){
        matice=new double[i][j];
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
    
    Matice maticeSecti(Matice B){
        if((matice.length!=B.matice.length)||(matice[0].length!=B.matice[0].length)){
            System.out.println("Matice musí být stejně velké");
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
    
    double[][] GetPole(){
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
    
    Matice vynasob(Matice A){
        if (matice[0].length!=A.matice.length){
            System.out.println("matice těchto rozměrů nelze násobit");
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
            return 0;
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
