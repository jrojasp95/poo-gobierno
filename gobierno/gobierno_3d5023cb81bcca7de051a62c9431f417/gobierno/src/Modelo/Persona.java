/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author Estudiante
 */
public class Persona {
    private int cedula;
    private String nombre;
    private String apellido;
    private int rol;
    private int estrato;
    private int edad;


    public Persona(int cedula, String nombre, String apellido, int edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido=apellido;
        this.edad=edad;
                
    }   

    public int getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getRol() {
        return rol;
    }
    

    public int getEstrato() {
        return estrato;
    }

    public int getEdad() {
        return edad;
    }

    
    public void setRol(int rol) {
        this.rol = rol;
    }

    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }
    
}
