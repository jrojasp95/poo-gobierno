/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

public class Ayuda {
    private int cdinero;
    private Producto prod[];
    private int cp;
    
    public Ayuda(int cdinero, int cp){
        this.cdinero=cdinero;
        prod=new Producto[cp];//definir el vector de productos a entregar
        this.cp=cp;
    }

    public int getCdinero() {
        return cdinero;
    }
     public int getCprod() {
        return cp;
    }

    public void setCdinero(int cdinero) {
        this.cdinero = cdinero;
    }

    public Producto[] getProd() {
        return prod;
    }

    public void setProd(Producto[] prod) {
        this.prod = prod;
    }
    
    
    
    
}
