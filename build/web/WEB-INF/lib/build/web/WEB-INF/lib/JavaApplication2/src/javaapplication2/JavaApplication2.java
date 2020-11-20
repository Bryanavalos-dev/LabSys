/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.util.Scanner;

/**
 *
 * @author gerson
 */
public class JavaApplication2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
    
           /*
        1.Se llena con una secuencia de numerosde del 1 a la nxn
        2.El primer valor se coloca al centro de la primera fila
        3.Si el valor ingresado es multiplo de n  entonces se coloca el nuevo valor en la misma columna y siguiente fila,caso 
        contrario se usa la fila anterior y columna posterior
        **Si la fila anterior no existe se usa la ultima fila
        **Si la columna posteior no existe se usa la primera columna
        */
           
        Scanner lc = new Scanner(System.in);
        int c =0, f=0, n=0;
        System.out.println("===========================================");
        System.out.println("======== Caja magica ===============");
        System.out.println("===========================================");
        do{
        System.out.println("Ingrese un valor impar y mayor que 3");
        n=lc.nextInt();
        }while(n%2==0 || n<3);
        
        c=n/2;
        String[][] ar = new String[n][n];
        
        for(int a=1; a<=(n*n); a++){
            System.out.println("Inicio c:"+c+" f:"+f+" valor:"+a);
            if(a==1){System.out.println("Entre"); ar[c][f]=a+" "; }//inicia en la mitad
            else{
                c++;f--;
                c=(c>=n)?0:c;
                f=(f<0)?n-1:f;
                if(a%n==0){
                   f++;
                   f=(f<0)?n-1:f;
                   ar[c][f]=a+" ";
                }else{
                    ar[c][f]=a+" ";
                }
                
                
                
            }
             System.out.println("Fin  c:"+c+" f:"+f+" variable:"+ar[c][f]);
        }
        
        
        
    }
    
    
    
    
}
