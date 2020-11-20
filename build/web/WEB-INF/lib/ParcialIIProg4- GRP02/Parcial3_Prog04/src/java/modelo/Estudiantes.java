/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author bryan
 */
public class Estudiantes {
    String carnet;
    String nombreestu;
    String nombremateria;
    String ciclo;
    double nota1;
    double nota2;
    double nota3;
    double promedio;
    String estado;
    
    public Estudiantes(){
    }
     public Estudiantes(String carnet, String nombreestu, String nombremateria, String ciclo,  double nota1, double nota2, double nota3, double promedio, String estado){
     this.carnet = carnet;
     this.nombreestu = nombreestu;
     this.nombremateria = nombremateria;
     this.ciclo = ciclo;
     this.nota1 = nota1;
     this.nota2 =  nota2;
     this.nota3 = nota3;
     this.promedio = promedio;
     this.estado = estado;
     }
     public String getCarnet(){
         return carnet;
     }
     public void setCarnet(String carnet){
         this.carnet= carnet;
     }
     
     public String getNombreestu(){
         return nombreestu;
     }
     public void setNombreestu(String nombreestu){
         this.nombreestu= nombreestu;
     }
     
    
     public String getNombremateria(){
         return nombremateria;
     }
     public void setNombremateria(String nombremateria){
         this.nombremateria= nombremateria;
     }
     
     public String getCiclo(){
         return ciclo;
     }
     public void setCiclo(String ciclo){
         this.ciclo = ciclo;
     }
     
     public double getNota1(){
         return nota1;
     }
     public void setNota1(double nota1){
         this.nota1 = nota1;
     }
     
     public double getNota2(){
         return nota2;
     }
     public void setNota2(double nota2){
         this.nota2 = nota2;
     }
     
     public double getNota3(){
         return nota1;
     }
     public void setNota3(double nota3){
         this.nota3 = nota3;
     }
     
     public double getPromedio(){
         promedio = (this.nota1+this.nota2+this.nota3)/3;
         promedio =  Math.round(promedio * 100.0) / 100.0;
         return promedio;
     }
   
     
}
