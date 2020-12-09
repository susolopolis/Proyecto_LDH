package Fuente;

import java.util.ArrayList;

public class Casa {

    //PONER TEXTURA PARA CASA: PLANO 3D O 2D
    private ArrayList<Objeto_Casa> objetos;

    public Casa(ArrayList<Objeto_Casa> objetos){
        this.objetos = objetos;
    }

    public void agregar_objeto(Objeto_Casa objeto){
        objetos.add(objeto);
    }

    public void eliminar_objeto(Objeto_Casa objeto){
        for (int i=0; i<objetos.size();i++){
            if(objetos.get(i).equals(objeto)){
                objetos.remove(i);
            }
        }
    }
    public void actualizar_objeto(Objeto_Casa nuevo_valor_objeto, int i){
        objetos.get(i).setObjeto(nuevo_valor_objeto);
    }

    public ArrayList<Objeto_Casa> getObjetos(){
        return objetos;
    }
}
