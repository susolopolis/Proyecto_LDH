package Fuente;

import java.util.ArrayList;

public class Objetos_Casa {
    private ArrayList<Objeto_Electronico> objetos;

    public Objetos_Casa(ArrayList<Objeto_Electronico> objetos){
        this.objetos = objetos;
    }

    public void agregar_objeto(Objeto_Electronico objeto){
        objetos.add(objeto);
    }

    public void eliminar_objeto(Objeto_Electronico objeto){
        for (int i=0; i<objetos.size();i++){
            if(objetos.get(i).equals(objeto)){
                objetos.remove(i);
            }
        }
    }
    public void actualizar_objeto(Objeto_Electronico nuevo_valor_objeto, int i){
        objetos.get(i).setObjeto(nuevo_valor_objeto);
    }

    public ArrayList<Objeto_Electronico> getObjetos(){
        return objetos;
    }
}
