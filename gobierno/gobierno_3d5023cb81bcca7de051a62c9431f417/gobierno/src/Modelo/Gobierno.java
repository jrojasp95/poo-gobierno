
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
     int familias_registradas=0,ind=0;
     
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
       int edad,est,ced,cpf=0,rol;
       String nom,ape;
       Persona personasF[];
       Persona cf=null;
           ced=oe.pedirEntero("ingrese cedula");
           nom=oe.pedirString("Ingrese nombre");
           ape=oe.pedirString("Ingrese apellido");
           do{
           edad=oe.pedirEntero("ingrese edad");
           }while(!(v.evaluarEdadC(edad)));
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
       ind = ind + 1;
       oe.mostraDatos("familias registradas: " + familias_registradas );
 
   } 
   
   
   public void cargarFamiliasAyuda(){
       boolean beneficiadas; //variable booleana para saber si la familia recibio ayudas
       Persona pers[];
       Producto prod[];
       oe.mostraDatos("metodo  cargar familias");
       oe.mostraDatos("familias registradas: " + familias_registradas );
       if(familias_registradas>0){
        //for(Familia f:familias_post){ ESTE CONDICIONAL TRATA DE RECORRER TODAS LAS 100 POSICIONES DEL VECTOR FAMILIA PERO COMO SOLO SE HAN REGISTRADIO UNA SALEN NULL POINTERS
          for (int i = 0; i < familias_registradas; i++) {
            Familia f = familias_post[i];   
            beneficiadas=true; //por defecto se deja en true y se cambia de valor solo para las familias no beneficiadas
            oe.mostraDatos("Estrato de cabeza de familia " + f.getP().getEstrato());
            oe.mostraDatos("Obtener integrantes de la familia");
            pers=f.getPersonas();
            if(f.getP().getEstrato()==1 || f.getP().getEstrato()==2){
                oe.mostraDatos("Condicional estrato 1 y 2");
                if(Ay.getCdinero()>=1000000){
                   Ay.setCdinero(Ay.getCdinero()-1000000);
                   f.setBeneficiada(beneficiadas);// cambia el estado de beneficiada si tiene un beneficio
                   oe.mostraDatos("Ayudas economicas estrato uno");
                }else{
                    oe.mostraDatos("No hay suficientes fondos para entregar ayuda economica");
                }
                oe.mostraDatos("Evaluar si se puede entregar ayuda de viveres");
                
                ///descomentar y ajustar este codigo, se tiene que recorrer los integrantes de la familia y ver cuales son menores de 5 años para dar ayuda de viveres
                /*for(Persona per:pers){//recorrer las personas de esa familia
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
                }*/
            }else if(f.getP().getEstrato()==3){
                oe.mostraDatos("Condicional estrato 3");
                if(Ay.getCdinero()>=500000){
                    int c_hijos=0;
                    for(Persona per:pers){
                        oe.mostraDatos("rol evaluado " + per.getRol());
                        if(per.getRol()==1){
                            c_hijos=c_hijos+1;
                        }
                    }
                    if(c_hijos>0){
                        Ay.setCdinero(Ay.getCdinero()-1000000);
                        f.setBeneficiada(beneficiadas);
                        oe.mostraDatos("Ayudas economicas ya que la familia cuenta con hijos");
                    }
                }
            }else{
                f.setBeneficiada(beneficiadas);
                oe.mostraDatos("La familia no aplica para ayudas del gobierno");
            }
        }
       }else{
           oe.mostraDatos("No hay familias registradas");
       }
   }
}
