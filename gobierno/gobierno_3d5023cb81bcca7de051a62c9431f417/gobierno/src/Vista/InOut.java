/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;


import javax.swing.JOptionPane;


public class InOut {
    
    public int pedirEntero(String m){ 
        return Integer.parseInt(JOptionPane.showInputDialog(m));
    }
    
    
    public String pedirString(String m){
        return JOptionPane.showInputDialog(m);
    }
    
    
    public void mostraDatos(String m){
        JOptionPane.showMessageDialog(null, m);
    }
    
     public static int mostrarPantallaInicial() {
        InOut data = new InOut();
        int opcion;
        do {
            opcion = data.pedirEntero("Digite una opcion\n1. Registrar producto\n2. Registrar Familia\n3. Cargar ayudas\n4. Salir");
        }while(opcion>4 || opcion <1 );
        // Aquí iría el código para mostrar la pantalla inicial de tu aplicación
        return opcion;
    }
    
     
}
