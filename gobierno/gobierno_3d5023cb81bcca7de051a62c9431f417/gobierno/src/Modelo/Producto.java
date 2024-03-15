/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


public class Producto {
    private int id;
    private String nombre;
    private String fecha_venc;
    private int cant_existente;
   


 public Producto(int id, String nombre,String fecha_venc,int cant_existente ) {
        this.id =id;
        this.nombre = nombre;
        this.fecha_venc=fecha_venc;
        this.cant_existente=cant_existente;
    }


 
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFecha_venc() {
        return fecha_venc;
    }

    public int getCant_existente() {
        return cant_existente;
    }

    public void setCant_existente(int cant_existente) {
        this.cant_existente = cant_existente;
    }    

}