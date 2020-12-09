package Fuente;
import java.util.Random;

public abstract class Objeto_Terrestre extends Objeto_Electronico{

    //LE PONDRIAMOS UNA TEXTURA PARA IMPRIMIR EN LA INTERFAZ

    static final double min = 100.0;
    static final double max = 300.0;

    //VARIABLES DE VEHICULOS TERRESTRES//
    int numero_ruedas;
    String marca;
    int velocidad; //velocidad en kilometros/hora


    int dimension_X;
    int dimension_Y;
    int dimension_Z;

    public Objeto_Terrestre(String ID, double[] pos, int X, int Y, int Z){
        this.ID = ID;
        this.posicion = pos;
        dimension_X = X;
        dimension_Y = Y;
        dimension_Z = Z;
    }

    public int[] get_dimensions(){
        int[] dimensiones = new int[3];

        dimensiones[0] = dimension_X;
        dimensiones[1] = dimension_Y;
        dimensiones[2] = dimension_Z;

        return dimensiones;
    }

    public abstract void getInfo();
    public abstract double[] calculate_next_pos();
}
