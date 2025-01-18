/**
 * <h1> Hoja de Trabajo 10 - Algoritmos y estructura de datos </h1>
 * <h2> vista (Clase tipo "Vista") </h2>
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
 **/  

import java.util.Scanner;

import javax.swing.JOptionPane;

class vista{
    Scanner scan;

    public void title(){
        System.out.println(" ▄         ▄  ▄               ▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄       ▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄▄▄ ");
        System.out.println("▐░▌       ▐░▌▐░▌             ▐░▌▐░░░░░░░░░░░▌▐░▌     ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌");
        System.out.println("▐░▌       ▐░▌ ▐░▌           ▐░▌ ▐░█▀▀▀▀▀▀▀▀▀  ▐░▌   ▐░▌ ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀▀▀▀▀▀ ");
        System.out.println("▐░▌       ▐░▌  ▐░▌         ▐░▌  ▐░▌            ▐░▌ ▐░▌  ▐░▌       ▐░▌▐░▌       ▐░▌▐░▌          ▐░▌          ▐░▌          ");
        System.out.println("▐░▌       ▐░▌   ▐░▌       ▐░▌   ▐░▌ ▄▄▄▄▄▄▄▄    ▐░▐░▌   ▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄ ▐░█▄▄▄▄▄▄▄▄▄ ");
        System.out.println("▐░▌       ▐░▌    ▐░▌     ▐░▌    ▐░▌▐░░░░░░░░▌    ▐░▌    ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌");
        System.out.println("▐░▌       ▐░▌     ▐░▌   ▐░▌     ▐░▌ ▀▀▀▀▀▀█░▌   ▐░▌░▌   ▐░█▀▀▀▀▀▀▀▀▀ ▐░█▀▀▀▀█░█▀▀ ▐░█▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀█░▌ ▀▀▀▀▀▀▀▀▀█░▌");
        System.out.println("▐░▌       ▐░▌      ▐░▌ ▐░▌      ▐░▌       ▐░▌  ▐░▌ ▐░▌  ▐░▌          ▐░▌     ▐░▌  ▐░▌                    ▐░▌          ▐░▌");
        System.out.println("▐░█▄▄▄▄▄▄▄█░▌       ▐░▐░▌       ▐░█▄▄▄▄▄▄▄█░▌ ▐░▌   ▐░▌ ▐░▌          ▐░▌      ▐░▌ ▐░█▄▄▄▄▄▄▄▄▄  ▄▄▄▄▄▄▄▄▄█░▌ ▄▄▄▄▄▄▄▄▄█░▌");
        System.out.println("▐░░░░░░░░░░░▌        ▐░▌        ▐░░░░░░░░░░░▌▐░▌     ▐░▌▐░▌          ▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌");
        System.out.println(" ▀▀▀▀▀▀▀▀▀▀▀          ▀          ▀▀▀▀▀▀▀▀▀▀▀  ▀       ▀  ▀            ▀         ▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀▀ ");
    }

    public void end_sys(){
        JOptionPane.showMessageDialog(null,"\n---- Gracias por utilizar el sistema Saliendo.... ----\n");
    }

    public int mainMenu(){
        JOptionPane.showMessageDialog(null,
            "\n=======================================================\n"
            + "Bienvenido a\n"
            + "𝕌𝕍𝔾𝕏𝕡𝕣𝕖𝕤𝕤\n"
            + "Entrando a sistema...."
            +"\n======================================================\n"
            );
        String[] options = {"Iniciar", "Salir del programa"};
        for(int i = 0;i < options.length;i++){
            System.out.println((i+1) + ". " + options[i]);
        }
        return options.length;
    }

    public vista(){
        scan = new Scanner(System.in);
    }

    /***
     * presionar para continuar
     */
    public void press_enter(){
        System.out.println("Presione ENTER para el siguiente paciente...");
        scan.nextLine();
    }
    /***
     * menu para elegir opcion
     * @return numero seleccionado segun la opcion
     */
    public int menu_opcion(){
        boolean verificador=false;
        int opcion=-1;
        do{
            System.out.println(" ---> Elija que opcion realizar");
            System.out.println("	1.  Agregar");
            System.out.println("	2.  Ver matriz de Floyd");
            System.out.println("	3.  Ver rutas cortas");
            System.out.println("	4.  Calculo de centro de grafo");
            System.out.println("	5.  Salir al menu principal");


            try{

                opcion = Integer.parseInt(scan.nextLine());


            }catch(Exception e){
                System.out.println("ese no es un numero entero");
            }

            if(opcion<1||opcion>5){
                System.out.println("esa no es una opcion\n");
            }else{
                verificador=true;
            }
        }while(verificador==false);

        return opcion;
    }

    /**
     * Impresion del titulo
     */

    public void titulo(){
        System.out.println("\n______________________-----------------------------------______________________");
        System.out.println("________________________--------- Mejor que Waze ---------_______________________");
        System.out.println("_______________________-----------------------------------_______________________");
        System.out.println();;
    }

    public int selection(int options) {
        boolean next_step = false;
        int selection = 0;
        do{
            try{
                // Opciones disponibles, cantidad
                // opción de entrada, del usuario
                selection = Integer.parseInt(JOptionPane.showInputDialog("Ingrese una de las opciones"));
                if(selection < 1 || selection> options){
                    System.err.println("\n¡Debe de ingresar una de las opciones dispoibles!\n");
                }else{
                    next_step = true;
                }
            }catch(NumberFormatException e){
                System.err.println("\n¡Debe ingresar un valor numérico!\n");
            }
        }while(!next_step);
        return selection;
    }

    public void messageSuccess(){
        JOptionPane.showMessageDialog(null,"\n----¡Ha Entrando con éxito!----\n");
    }

}


