/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


public class Familia {
    private Persona p;
    private Persona personas[];
    private boolean beneficiada;


 public Familia(Persona p, Persona per[], int cp){
     this.p=p;
     personas =new Persona[cp];
     beneficiada=true;
    }

    public Persona getP() {
        return p;
    }

    public Persona[] getPersonas() {
        return personas;
    }

    public void setBeneficiada(boolean beneficiada) {
        this.beneficiada = beneficiada;
    }


}