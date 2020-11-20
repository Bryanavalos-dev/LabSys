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
public class J1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       
        Scanner sc = new Scanner(System.in);
        
        int mes = 0;
        
        System.out.println("Ingrese el numero del mes a evaluar:");
        mes = sc.nextInt();
        System.out.println("\n"+mostrarMes(mes));
        
        
        
    
        }
    
    public static String mostrarMes(int mes){
        String res = "";
        int dias = 0;
        if(mes == 4 || mes == 6 || mes == 9 || mes == 11){
            dias = 30;
        }else{
            if(mes !=2 && mes > 0 && mes <=12){
                dias = 31;
            }else if(mes ==2 ){
                int anio = 2020;
                
                dias = 28;
                if( (anio%4==0) && ( (anio%100!=0)||(anio%400==0) ) )
                dias = 29;
                
                
            }
            
        }
            
        
        
       switch(mes){


            case 1:
                           res = "Mes de Enero, contiene "+ dias +" dias";
                           break;


            case 2:
                           res = "Mes de Febrero, contiene "+ dias +" dias";
                           break;


            case 3:
                           res = "Mes de Marzo, contiene "+ dias +" dias";
                           break;


            case 4:
                           res = "Mes de Abril, contiene "+ dias +" dias";
                           break;


            case 5:
                           res = "Mes de Mayo, contiene "+ dias +" dias";
                           break;


            case 6:
                           res = "Mes de Junio, contiene "+ dias +" dias";
                           break;


            case 7:
                           res = "Mes de Julio, contiene "+ dias +" dias";
                           break;


            case 8:
                           res = "Mes de Agosto, contiene "+ dias +" dias";
                           break;


            case 9:
                           res = "Mes de Septiembre, contiene "+ dias +" dias";
                           break;


            case 10:
                           res = "Mes de Octubre, contiene "+ dias +" dias";
                           break;


            case 11:
                           res = "Mes de Noviembre, contiene "+ dias +" dias";
                           break;


            case 12:
                           res = "Mes de Diciembre, contiene "+ dias +" dias";
                           break;

               
           default:
               res = "No existe ese mes";
               break;
                       
       }
       
       
        
        return res;
    }
    
    
    
    
    
    
    
}
