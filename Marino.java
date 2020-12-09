package Fuente;

import java.util.ArrayList;

public class Marino {

    //PONER TEXTURA: MAPA MUNDI 2D

    private ArrayList<Objeto_Marino> objetos;

    public Marino(ArrayList<Objeto_Marino> objetos){
        this.objetos = objetos;
    }

    public void agregar_objeto(Objeto_Marino objeto){
        objetos.add(objeto);
    }

    public void eliminar_objeto(Objeto_Marino objeto){
        for (int i=0; i<objetos.size();i++){
            if(objetos.get(i).equals(objeto)){
                objetos.remove(i);
            }
        }
    }
    public void actualizar_objeto(Objeto_Marino nuevo_valor_objeto, int i){
        objetos.get(i).setObjeto(nuevo_valor_objeto);
    }

    public ArrayList<Objeto_Marino> getObjetos(){
        return objetos;
    }
}
