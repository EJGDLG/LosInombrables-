/**
 * <h1> Hoja de Trabajo 10 - Algoritmos y estructura de datos </h1>
 * <h2> Graph (Clase tipo "módulo") </h2>
 * 
 * <p>
 * Universidad del Valle de Guatemala
 * </p>
 * 
 * @author Pablo Daniel Barillas Moreno - Carné No. 22193
 * @author Edwing José Gabriel de León García – Carné No. 22809
 * @version 1.0
 * @since 10/05/2023
 * 
 * CC2016 Seccion 20
 * 
 * Referencia de https://www.youtube.com/watch?v=KwWu9sXdnaY
 * 
 **/  

 import java.util.Collections;
public class Graph {

    private int n;
    private int[][] matriz;

    /**
     * Constructor de clase
     * @param n cantidad
     */
    public Graph(int n) {
        this.n = n;
        matriz = new int[this.n][this.n];
        //se inicializa matriz en 0
        for(int i=0; i< n; i++){
            for(int j=0; j< n; j++){
                matriz[i][j] = 0;
            }
        }
     }

     

    /**
     * agregar
     * @param i cantidad
     * @param j cantidad
     */
    public void agregar(int i, int j){
        matriz[i][j] += 1;
    }

    /**
     * remover
     * @param i ubicacion
     * @param j ubicacion
     */
    public void remover(int i, int j){
        if(matriz[i][j]>0)
            matriz[i][j] -= 1;
    }

    /**
     * impresion de matriz normal con 0
     */
    public void imprimir_normal(){

        for(int i=0; i< n; i++){
            System.out.print("||\t");
            for(int j=0; j< n; j++){
                System.out.print( matriz[i][j] + "\t" );
            }
            System.out.print("||");
            System.out.println();
        }
    }

    /**
     * matriz con infinitos
     */
    public void imprimir(){
        for(int i=0; i< n; i++){
            for(int j=0; j< n; j++){
                if (matriz[i][j]==0){
                    matriz[i][j]=999999;
                }
            }

        }
        for(int i=0; i< n; i++){
            System.out.print("||\t");
            for(int j=0; j< n; j++){
                System.out.print( matriz[i][j] + "\t" );
            }
            System.out.print("||");
            System.out.println();
        }
    }

    /**
     * retornar
     * @return retorna matriz
     */
    public int[][] retornar(){
        return matriz;
    }

    /**
     * devuelve min
     * @param a ubicacion
     * @param b ubicacion
     * @return minutos (min)
     * 
     */
    public int devolver(int a, int b){
        return matriz[a][b];
    }
    public int getCenter() {
        int[][] dist = new int[n][n];
        //se inicializa la matriz de distancias con la matriz de adyacencia
        for(int i=0; i< n; i++){
            for(int j=0; j< n; j++){
                dist[i][j] = matriz[i][j];
            }
        }
    
        //se aplica el algoritmo de Floyd-Warshall para encontrar las distancias entre cada par de vértices
        for(int k=0; k< n; k++){
            for(int i=0; i< n; i++){
                for(int j=0; j< n; j++){
                    if(dist[i][k] != Integer.MAX_VALUE && dist[k][j] != Integer.MAX_VALUE){
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    
        int maxDist = Integer.MIN_VALUE;
        int center = -1;
        //se encuentra el vértice que tiene la distancia máxima más pequeña
        for(int i=0; i< n; i++){
            int curDist = 0;
            for(int j=0; j< n; j++){
                if(dist[i][j] != Integer.MAX_VALUE){
                    curDist = Math.max(curDist, dist[i][j]);
                }
            }
            if(curDist < maxDist || center == -1){
                maxDist = curDist;
                center = i;
            }
        }
    
        return center;
    }
    
}
