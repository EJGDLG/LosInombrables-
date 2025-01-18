/**
 * <h1> Hoja de Trabajo 10 - Algoritmos y estructura de datos </h1>
 * <h2> Floyd (Clase tipo "módulo") </h2>
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
 * Referencia de... https://www.youtube.com/watch?v=xK0ShW9G-Ts
 * 
 **/  

import java.util.ArrayList;
import java.util.Collections;

public class Floyd {
    public String algoritmoFloyd (ArrayList<String> nombres, int[][] matriz){
        int vertices = matriz.length;
        int MatrizAdyacencia[][] =matriz;
        String caminos [][]=new String[vertices][vertices];
        String caminosAuxiliares[][]=new String[vertices][vertices];
        String caminoRecorrido="",cadena="",caminitos="";
        int i,j,k;
        float temporal1,temporal2,temporal3,temporal4,minimo;
        for (i = 0;i<vertices;i++){
            for (j=0;j<vertices;j++){
                caminos[i][j] = "";
                caminosAuxiliares[i][j]="";
            }

        }
        for (k=0;k<vertices;k++){
            for (i=0;i<vertices;i++){
                for (j=0;j<vertices;j++){
                    temporal1 = MatrizAdyacencia[i][j];
                    temporal2 = MatrizAdyacencia[i][k];
                    temporal3 = MatrizAdyacencia[k][j];
                    temporal4 = temporal2 +temporal3;

                    minimo = Math.min(temporal1,temporal4);
                    if (temporal1!=temporal4){
                        if (minimo==temporal4){
                            caminoRecorrido = "";
                            caminosAuxiliares[i][j] = k + "";
                            caminos[i][j]=caminosR(i,k,caminosAuxiliares,caminoRecorrido)+ (k) ;
                        }

                    }
                    MatrizAdyacencia[i][j] = (int) minimo;

                }

            }

        }

        for (i=0;i<vertices;i++){
            for (j=0;j<vertices;j++){
                cadena = cadena + "[" + MatrizAdyacencia[i][j]+"]";
            }
            cadena = cadena + "\n";
        }

        for (i=0;i<vertices;i++){
            for (j=0;j<vertices;j++){
                if (MatrizAdyacencia[i][j]!=1000000){
                    if(i !=j){
                        if(caminos[i][j].equals("")){
                            caminitos += "Desde "+nombres.get(i)+" Hacia "+nombres.get(j)+" Es mejor irse por "+nombres.get(i)+" y luego a "+nombres.get(j)+"\n";
                        }else if(MatrizAdyacencia[i][j] ==1000000 ){
                            caminitos +="Desde "+ nombres.get(i)+" Hacia "+nombres.get(j)+" Es mejor irse por "+(i)+", "+(caminos[i][j]) + " y finalmente " +(j)+"\n";
                        }else{
                            
                        }
                    }
                }
            }
            cadena = cadena + "\n";
        }




        return "\n Rutas entre vertices:\n"+caminitos;
    }
    public String algoritmoFloyd2 (ArrayList<String> nombres, int[][] matriz){
        int vertices = matriz.length;
        int MatrizAdyacencia[][] =matriz;
        String caminos [][]=new String[vertices][vertices];
        String caminosAuxiliares[][]=new String[vertices][vertices];
        String caminoRecorrido="",cadena="",caminitos="";
        int i,j,k;
        float temporal1,temporal2,temporal3,temporal4,minimo;
        for (i = 0;i<vertices;i++){
            for (j=0;j<vertices;j++){
                caminos[i][j] = "";
                caminosAuxiliares[i][j]="";
            }

        }
        for (k=0;k<vertices;k++){
            for (i=0;i<vertices;i++){
                for (j=0;j<vertices;j++){
                    temporal1 = MatrizAdyacencia[i][j];
                    temporal2 = MatrizAdyacencia[i][k];
                    temporal3 = MatrizAdyacencia[k][j];
                    temporal4 = temporal2 +temporal3;

                    minimo = Math.min(temporal1,temporal4);
                    if (temporal1!=temporal4){
                        if (minimo==temporal4){
                            caminoRecorrido = "";
                            caminosAuxiliares[i][j] = k + "";
                            caminos[i][j]=caminosR(i,k,caminosAuxiliares,caminoRecorrido)+ (k) ;
                        }

                    }
                    MatrizAdyacencia[i][j] = (int) minimo;

                }

            }

        }

        for (i=0;i<vertices;i++){
            for (j=0;j<vertices;j++){
                cadena = cadena + "[" + MatrizAdyacencia[i][j]+"]";
            }
            cadena = cadena + "\n";
        }

        for (i=0;i<vertices;i++){
            for (j=0;j<vertices;j++){
                if (MatrizAdyacencia[i][j]!=1000000){
                    if(i !=j){
                        if(caminos[i][j].equals("")){
                            caminitos += "Desde "+nombres.get(i)+" Hacia "+nombres.get(j)+" Es mejor irse por "+nombres.get(i)+" y luego a "+nombres.get(j)+"\n";
                        }else{
                            caminitos +="Desde "+ nombres.get(i)+" Hacia "+nombres.get(j)+" Es mejor irse por "+(i)+", "+(caminos[i][j]) + " y finalmente " +(j)+"\n";
                        }
                    }
                }
            }
            cadena = cadena + "\n";
        }




        return "\nMatriz con caminos cortos \n" +cadena;
    }

    public String caminosR(int i, int k, String[][] caminosAuxiliares, String caminoRecorrido) {
        if(caminosAuxiliares[i][k].equals("")){
            return "";
        }else{
            caminoRecorrido +=caminosR(i, Integer.parseInt(caminosAuxiliares[i][k].toString()), caminosAuxiliares, caminoRecorrido)+(Integer.parseInt(caminosAuxiliares[i][k].toString()))+", ";
            return caminoRecorrido;
        }
    }

}
