package Fuente;

import java.util.ArrayList;

public class Terrestre {

    //PONER TEXTURA: MAPA MUNDI EN 2D
    private ArrayList<Objeto_Terrestre> objetos;

    public Terrestre(ArrayList<Objeto_Terrestre> objetos){
        this.objetos = objetos;
    }

    public void agregar_objeto(Objeto_Terrestre objeto){
        objetos.add(objeto);
    }

    public void eliminar_objeto(Objeto_Terrestre objeto){
        for (int i=0; i<objetos.size();i++){
            if(objetos.get(i).equals(objeto)){
                objetos.remove(i);
            }
        }
    }
    public void actualizar_objeto(Objeto_Terrestre nuevo_valor_objeto, int i){
        objetos.get(i).setObjeto(nuevo_valor_objeto);
    }

    public ArrayList<Objeto_Terrestre> getObjetos(){
        return objetos;
    }
}
