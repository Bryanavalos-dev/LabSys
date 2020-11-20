/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j1;

import java.util.Scanner;

/**
 *
 * @author gerson
 */
public class j2 {
    public static void main(String[] args){
		Scanner lc = new Scanner(System.in);
		int n=0;

		do{
			System.out.println("Ingrese un numero mayor a 4 y par:");
			n=lc.nextInt();
		}while(n<4);

		String[][] c = new String[n][n]; 
        System.out.println("=== PATRON 1 ===");
		for (int a=0; a<n; a++) {
			for(int b=0; b<n; b++){
				c[a][b]=((a+b)<n)?"*":" ";
				System.out.print( c[a][b]+" " );
			}
			System.out.println("");
		}

		System.out.println("\n=== PATRON 2 ===");
		for (int a=0; a<n; a++) {
			for(int b=0; b<n; b++){
				c[a][b]=((a+b)>=n-1)?"*":" ";
				System.out.print( c[a][b]+" " );
			}
			System.out.println("");
		}

		System.out.println("\n=== PATRON 3 ===");
		for (int a=0; a<n; a++) {
			for(int b=0; b<n; b++){
				c[a][b]=(a==b)?"*":"";
				System.out.print( c[a][b]+" " );
			}
			System.out.println("");
		}

	}
}
