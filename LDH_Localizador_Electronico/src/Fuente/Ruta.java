package Fuente;

import java.util.Random;

public class Ruta {

    private int pos_actual_x;
    private int pos_actual_y;


    public Ruta(){
        pos_actual_x = 0;
        pos_actual_y = 0;
    }
    public void calcular_pos_actual(int ancho, int largo){
        Random ran1 = new Random();
        Random ran2 = new Random();

        int valor_X;
        int valor_Y;

        valor_X = ran1.nextInt(ancho) + ancho;
        valor_Y = ran2.nextInt(largo) + largo;

        pos_actual_x = valor_X;
        pos_actual_y = valor_Y;
    }

    public int get_pos_x(){
        return pos_actual_x;
    }

    public int get_pos_y(){
        return pos_actual_y;
    }
}
