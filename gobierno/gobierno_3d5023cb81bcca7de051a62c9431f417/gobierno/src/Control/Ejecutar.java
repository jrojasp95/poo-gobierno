

/*

Debido a la pandemia el gobierno nos pide realizar un software que nos permita averiguar cuales familias
fueron las beneficiadas por las ayudas del gobierno, para ello se toma en cuenta que la ayuda puede ser
monetaria o alimenticia. Quien puede reclamarlas es la cabeza de familia tomando en cuenta su estrato y 
las personas bajo su cargo, se sabe que:

a)Si es estrato 1-2, la ayuda es de 1M
b) Si tiene a cargo niños >5 años, recibe ayuda alimenticia de bienestarina y vitaminas 
c)la gente de estrato 3 con hijos, reciben 500K
d) gente de estrato 4 en adelante, no se le da nada
*/
package Control;
import javax.swing.JOptionPane;

import Modelo.Gobierno;
import Vista.InOut;

public class Ejecutar {
    
   
   
   public static void main(String[] args) {
        // Crear nueva campaña de ayuda
        int total_dinero_ayuda, total_productos, opcion;
        InOut data = new InOut();
        
        JOptionPane.showMessageDialog(null,"Bienevenido al programa de ayudas para la pandemia");
        total_dinero_ayuda = data.pedirEntero("Digite el monto máximo de dinero disponible para ayudas");
        total_productos = data.pedirEntero("Digite la cantidad de tipo de productos  disponibles para ayudas");
        Gobierno GobCol = new Gobierno(total_dinero_ayuda,total_productos);
        
        do {

            opcion = data.pedirEntero("1. Registrar producto\n2. Registrar Familia\n3. Cargar ayudas\n4. Salir\n Digite una opcion: ");

            switch (opcion) {
                case 1:
                    GobCol.crearPro();
                    break;
                case 2:
                    GobCol.crearFamilias();
                    break;
                case 3:
                    GobCol.cargarFamiliasAyuda();
                    break;
                case 4:
                    data.mostraDatos("Gracias por usar nuestros servicios"); 
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    data.mostraDatos("Opción inválida, por favor seleccione nuevamente.");
            }
        } while (opcion != 4);
        
    }
}

