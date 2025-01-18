/**
 * <h1> Hoja de Trabajo 10 - Algoritmos y estructura de datos </h1>
 * <h2> Conexión (Clase tipo "módulo") </h2>
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

public class Conexion {
    String ciudad1 = "";
    String ciudad2 = "";
    int min = 0;

    /**
     * constructor de conexion
     * @param a origen
     * @param b destino
     * @param c km
     */
    public Conexion(String a, String b, String c){
        ciudad1 = a;
        ciudad2 = b;
        min = Integer.parseInt(c);
    }

    /**
     * impresiond el string
     * @return string
     */
    @Override
    public String toString() {
        return "Conexión{" +
                "ciudad1='" + ciudad1 + '\'' +
                ", ciudad2='" + ciudad2 + '\'' +
                ", min=" + min +
                '}';
    }
}
