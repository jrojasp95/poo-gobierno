
package Modelo;

import Vista.InOut;
import java.util.ArrayList;


public class Gobierno {
    //atributos de la clase 
     Familia familias_post[]=new Familia[100];//se define vector de familias postuladas
     ArrayList <Familia> familias_ayu=new ArrayList <Familia>();
     Ayuda Ay;
     InOut oe=new InOut();//crea el objeto para acceder a InOut
     Validaciones v=new Validaciones();
     int familias_registradas=0;
     
     public Gobierno(int cant_Dinero,int cproductos ) {//constructor 
         Ay=new Ayuda(cant_Dinero,cproductos);
   }
     
     public void crearPro(){
         int id,cant;
         String nombre,fv;
         Producto productos[]=new Producto[Ay.getCprod()];//definir el vector con la cantidad de productos que va a entregar el gobierno
         for(int i=0;i<Ay.getCprod(); i++){
             id=oe.pedirEntero("ingrese id");
             nombre=oe.pedirString("ingrese nombre");
             fv=oe.pedirString("Ingrese fecha vencimiento");
             cant=oe.pedirEntero("cantidad");
             Producto obp=new Producto(id,nombre,fv,cant);
             productos[i]=obp;// envia el objeto al vector
         }
        Ay.setProd(productos);
     }  
     
   public void crearFamilias(){
       int ind=0,res,edad,est,ced,cpf=0,rol;
       String nom,ape;
       Persona personasF[];
       Persona cf=null;
       res=oe.pedirEntero(" si llega familia a postularse 1 sino otro valor");
     
           ced=oe.pedirEntero("ingrese cedula");
           nom=oe.pedirString("Ingrese nombre");
           ape=oe.pedirString("Ingrese apellido");
           do{
           edad=oe.pedirEntero("ingrese edad");
           }while(!(v.evaluarEdadC(edad)));
           //}while(!(v.evaluared(ced)|| v.evaluarEdadC(edad)));
           do{
           est=oe.pedirEntero("Ingrese estrato");
           }while(!v.evaluarEst(est));
           cf=new Persona(ced,nom,ape,edad);
           cf.setEstrato(est);
           cpf=oe.pedirEntero("Cuantas personas componen su familia");
           personasF=new Persona [cpf];//sirve pára guardar las personas de esa familia
           for(int i=0; i<cpf;i++){
               oe.mostraDatos("Integrante"+(i+1));
               ced=oe.pedirEntero("ingrese identificacion");
               nom=oe.pedirString("Ingrese nombre");
               ape=oe.pedirString("Ingrese apellido");
               //do{
                  // edad=oe.pedirEntero("ingrese edad");
                //}while(!v.evaluared(edad));
               rol=oe.pedirEntero("Ingrese su rol 1.hijo, 2.conyugue, 3 padre"); 
               if(rol==1){
                   do{
                     do{// validar edad 
                        edad=oe.pedirEntero("ingrese edad del hijo");
                        }while(!v.evaluared(edad));  //si ingresa una edad invalida se piede de nuevo el dato
                   }while(edad>(cf.getEdad()+15)); ///si la edad del hijo es mayor por 15 años a la edad del CF se pide de nuevo el dato ya que no es coherente
               }
               if(rol==2){
                   do{// validar edad 
                     do {
                        edad=oe.pedirEntero("ingrese edad del conyugue");
                     }while(!v.evaluared(edad));  ///si ingresa una edad invalida pide de nuevo el dato    
                    }while(edad<14); // si la edad del conyuge es menor a 14 años pide de nuevo el dato
               }
               if(rol==3){
                   do{
                     do{// validar edad 
                        edad=oe.pedirEntero("ingrese edad del padre");
                        }while(!v.evaluared(edad));  
                   }while(edad<(cf.getEdad()+15));
               }
             Persona Integ=new Persona(ced,nom,ape,edad);
             Integ.setRol(rol);
             personasF[i]=Integ;
           }
        Familia fam=new Familia(cf, personasF,cpf); 
       familias_post[ind]=fam;
       familias_registradas = familias_registradas + 1;
       oe.mostraDatos("familias registradas: " + familias_registradas );
 
   } 
   
   
   public void cargarFamiliasAyuda(){
       boolean d;
       Persona pers[];
       Producto prod[];
       oe.mostraDatos("meotodo  cargar familias");
       oe.mostraDatos("familias registradas: " + familias_registradas );
       if(familias_registradas>0){
        for(Familia f:familias_post){
            d=true;

            if(f.getP().getEstrato()==1 || f.getP().getEstrato()==2){
                if(Ay.getCdinero()>=1000000){
                   Ay.setCdinero(Ay.getCdinero()-1000000);
                   f.setBeneficiada(false);// cambia el estado de beneficiada si tiene un beneficio
                   d=false;//recibe ayuda
                }
                pers=f.getPersonas();
              for(Persona per:pers){//recorrer las personas de esa familia
                if(per.getEdad()<5){
                    prod=Ay.getProd();
                    for(Producto pro:prod){
                        //evaluar haya producto para entregar
                         pro.setCant_existente(pro.getCant_existente()-1);
                         f.setBeneficiada(false);
                        d=false;//recibe ayuda
                    }
                    //DEBEN HACER EL RESTO DE LA CONDICIONES
                }else{
                    System.out.println("no aplica");
                } 
              }
            }
        }
       }else{
           oe.mostraDatos("No hay familias registradas");
       }
   }
}
