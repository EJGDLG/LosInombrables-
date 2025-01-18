/**
 * <h1> Hoja de Trabajo 10 - Algoritmos y estructura de datos </h1>
 * <h2> Controlador
 * 
 *  (Clase tipo "Controlador") </h2>
 * 
 * <p>
 * Universidad del Valle de Guatemala
 * </p>
 * 
 * @author Pablo Daniel Barillas Moreno - Carné No. 22193
 * @author Edwing José Gabriel de León García – Carné No. 22809
 * @version 1.0
 * @since 15/05/2023
 * 
 * CC2016 Seccion 20
 * 
 * Referencia de https://www.youtube.com/watch?v=KwWu9sXdnaY
 * 
 **/  

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Random;
import java.util.Collections;
public class Controlador {
    
    

    public void logica(){

        Scanner scan = new Scanner(System.in);
        vista view =  new vista();
        Floyd cam = new Floyd();

        System.out.println("\n____________________-----------------------------------________________________");
        System.out.println("______________________--------- Mejor que Waze ---------_________________________");
        System.out.println("______________________-----------------------------------________________________");
        System.out.println();

        /**
         * guarda la posicion de la
         */

        ArrayList<String> ciudades = new ArrayList<String>();

        /**
         * se lee el archivo txt para saber el espacio de la matriz
         */
        System.out.println("Lo que hay en el guategrafo.txt\n");
        try{
            FileReader r = new FileReader("guategrafo.txt");
            BufferedReader buffer = new BufferedReader(r);

            String temp ="";

            while(temp!=null){
                temp = buffer.readLine();
                if(temp == null){
                    break;
                }
                System.out.println(temp);
                String[] data = temp.split(" ");
                Conexion conectando  =  new Conexion(data[0],data[1],data[2]);
                //corroborando el vertice de la ciudad 1
                if (!ciudades.contains(conectando.ciudad1)){
                    ciudades.add(conectando.ciudad1);
                }

                //corroborando el vertice de la ciudad 2
                if (!ciudades.contains(conectando.ciudad2)){
                    ciudades.add(conectando.ciudad2);
                }

            }
        }catch(Exception e){
            System.out.println("archivo no encontrado");
        }
        /**
         * se instancia la matriz y se llena con los datos asignados
         */

        Graph matriz = new Graph(ciudades.size());

        try{
            FileReader r = new FileReader("guategrafo.txt");
            BufferedReader buffer = new BufferedReader(r);

            String temp ="";

            while(temp!=null){
                temp = buffer.readLine();
                if(temp == null){
                    break;
                }
                String[] data = temp.split(" ");
                Conexion conectando  =  new Conexion(data[0],data[1],data[2]);
                //corroborando el vertice de la ciudad 1
                if (!ciudades.contains(conectando.ciudad1)){
                    ciudades.add(conectando.ciudad1);
                }

                //corroborando el vertice de la ciudad 2
                if (!ciudades.contains(conectando.ciudad2)){
                    ciudades.add(conectando.ciudad2);
                }

                for (int i=0;i<conectando.min;i++){
                    matriz.agregar(ciudades.indexOf(conectando.ciudad1), ciudades.indexOf(conectando.ciudad2));
                    matriz.agregar(ciudades.indexOf(conectando.ciudad2), ciudades.indexOf(conectando.ciudad1));
                }

            }
        }catch(Exception e){
            System.out.println("archivo no encontrado");
        }
        System.out.println("\nNombres de las ciudades con el numero de vertice asignado\n");
        for (int i=0;i<ciudades.size();i++){
            System.out.print(ciudades.get(i)+"\t");
            System.out.print(ciudades.indexOf(ciudades.get(i)));
            System.out.println();
        }
        

        
        System.out.println("\nMatriz de adyacencia entre ciudades\n");

        matriz.imprimir_normal();

        System.out.println("\nMatriz de adyacencia para Floyd (0-->infinito)\n");

        matriz.imprimir();

        System.out.println(cam.algoritmoFloyd(ciudades,matriz.retornar()));

        

        boolean ciclo = true;
        while (ciclo==true){
            view.titulo();

            int opcion = view.menu_opcion();

            if(opcion==1){
                /**
                 * como la distancia no cambia, se toma como si la distancia fuera tanto de origen a destino como de destino a origen
                 */
                System.out.println("Este método se recomienda solo usar una vez, ya que");
                System.out.println("Otra segunda correccion borrar todos los nuevos cambios realizados");
                System.out.println("Ingrese la ciudadd destino");
                String origen = scan.nextLine();

                System.out.println("Ingrese la ciudad origen");
                String destino = scan.nextLine();

                System.out.println("Ingrese la cantidad de min en clima normal");
                int min = Integer.parseInt(scan.nextLine());

                System.out.println("Ingrese la cantidad de min clima lluvia ");
                int min1 = Integer.parseInt(scan.nextLine());
                System.out.println("Ingrese la cantidad de min clima con nieves");
                int min2 = Integer.parseInt(scan.nextLine());
                System.out.println("Ingrese la cantidad de min tormenta");
                int min3 = Integer.parseInt(scan.nextLine());

                System.out.println("Ingrese el clima ");
                String tiempoSeleccionado = scan.nextLine();
                 
                if(tiempoSeleccionado == "con clima normal"){
                    
                if (!ciudades.contains(origen)){
                    ciudades.add(origen);
                }

                //corroborando el vertice de la ciudad 2
                if (!ciudades.contains(destino)){
                    ciudades.add(destino);
                }
                matriz = new Graph(ciudades.size());
                JOptionPane.showMessageDialog(null,"\n----La ruta puede estar  ----\n"+ tiempoSeleccionado+ "--vas a llegar" +min);
                }else if(tiempoSeleccionado == "con lluvia"){
                    if (!ciudades.contains(origen)){
                        ciudades.add(origen);
                    }
    
                    //corroborando el vertice de la ciudad 2
                    if (!ciudades.contains(destino)){
                        ciudades.add(destino);
                    }
                    matriz = new Graph(ciudades.size());
                    JOptionPane.showMessageDialog(null,"\n----La ruta puede estar  ----\n"+ tiempoSeleccionado+ "--vas a llegar tarde" +min2);
                }else if(tiempoSeleccionado == "con nieve"){
                    if (!ciudades.contains(origen)){
                        ciudades.add(origen);
                    }
    
                    //corroborando el vertice de la ciudad 2
                    if (!ciudades.contains(destino)){
                        ciudades.add(destino);
                    }
                    matriz = new Graph(ciudades.size());
                    JOptionPane.showMessageDialog(null,"\n----La ruta puede estar  ----\n"+ tiempoSeleccionado+ "--vas a llegar tarde" +min3);
                    }else{ 
                        JOptionPane.showMessageDialog(null,"\n----La ruta puede estar  ----\n"+ tiempoSeleccionado+ "--No va a llegar");
                        logica();
                         break;
                    }

                try{
                    FileReader r = new FileReader("guategrafo.txt");
                    BufferedReader buffer = new BufferedReader(r);

                    String temp ="";

                    while(temp!=null){
                        temp = buffer.readLine();
                        if(temp == null){
                            break;
                        }
                        String[] data = temp.split(" ");
                        Conexion conectando  =  new Conexion(data[0],data[1],data[2]);
                        //corroborando el vertice de la ciudad 1
                        if (!ciudades.contains(conectando.ciudad1)){
                            ciudades.add(conectando.ciudad1);
                        }

                        //corroborando el vertice de la ciudad 2
                        if (!ciudades.contains(conectando.ciudad2)){
                            ciudades.add(conectando.ciudad2);
                        }

                        for (int i=0;i<conectando.min;i++){
                            matriz.agregar(ciudades.indexOf(conectando.ciudad1), ciudades.indexOf(conectando.ciudad2));
                            matriz.agregar(ciudades.indexOf(conectando.ciudad2), ciudades.indexOf(conectando.ciudad1));
                        }
                    
                    }
                    
                }catch(Exception e){
                    System.out.println("archivo no encontrado");
                }
              
                for (int i=0;i<min;i++){
                    matriz.agregar(ciudades.indexOf(origen),ciudades.indexOf(destino));
                    matriz.agregar(ciudades.indexOf(destino),ciudades.indexOf(origen));
                }
                System.out.println("Se ha agregado a la matriz");
                 
        
                System.out.println("\nMatriz de adyacencia para Floyd (0-->infinito)\n");

                matriz.imprimir();

            }else if(opcion==2){
                Floyd cam2 = new Floyd();
                System.out.println("\nMatriz de adyacencia para Floyd (0-->infinito)\n");

                matriz.imprimir();
                System.out.println(cam2.algoritmoFloyd2(ciudades,matriz.retornar()));
                
            }else if (opcion==3){
                Floyd cam3 = new Floyd();
                System.out.println("\nMatriz de adyacencia para Floyd (0-->infinito)\n");

                matriz.imprimir();
                System.out.println(cam3.algoritmoFloyd(ciudades,matriz.retornar()));

            }else if (opcion==4){
                Graph G = new Graph(opcion);
                System.out.println("\nImplementación del cálculo del centro del grafo:\n"+ciudades.get(3)+"\t");

            
            }else if (opcion==5){
                System.out.println("\nSaliendo al menu principal.... espere....\n");
                ciclo=false;
            }
        }
    }


    public void StartPrincipal(){
        vista v = new vista();
         int selection = 0;
         int options1 = 1;
         while(selection != options1){
            v.title();
            System.out.println();
             options1 = v.mainMenu();
             selection = v.selection(options1);
             switch(selection){
                 case 1:
                     // Incio
                     v.messageSuccess();
                     logica();
                     break;
                 default:
                     // Programa terminado
                     v.end_sys();
                     break;
             }
         }
    }
}

    
    


