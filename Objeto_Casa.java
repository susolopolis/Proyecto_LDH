package Fuente;

import java.util.Random;

public abstract class Objeto_Casa extends Objeto_Electronico{
    //LE PONDRIAMOS UNA TEXTURA PARA IMPRIMIR EN LA INTERFAZ

    static final double min = 0.0;
    static final double max = 20.0;

    //VARIABLES DE APARATOS ELECTRONICOS//
    String marca;
    String modelo;
    int valor;

    int dimension_X;
    int dimension_Y;
    int dimension_Z;

    public Objeto_Casa(String ID, double[] pos, int X, int Y, int Z){
        this.ID = ID;
        this.posicion = pos;
        dimension_X = X;
        dimension_Y = Y;
        dimension_Z = Z;
    }

    /*
        Random ran1 = new Random();
        Random ran2 = new Random();
        Random ran3 = new Random();

        double[] new_pos = new double[3];

        new_pos[0] = min + ( max - min ) * ran1.nextDouble();
        new_pos[1] = min + ( max - min ) * ran2.nextDouble();
        new_pos[2] = min + ( max - min ) * ran3.nextDouble();

        return new_pos;
    }
*/
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
