package Fuente;

import java.util.ArrayList;

public class Casa {

    //Dimensiones del piso
    int ancho;
    int largo;

    //PONER TEXTURA PARA CASA: PLANO 2D

    private final ArrayList<Objeto_Casa> objetos;

    public Casa(int ancho, int largo){
        this.objetos = new ArrayList<Objeto_Casa>();
        this.ancho = ancho;
        this.largo = largo;
    }

    public void agregar_objeto(Objeto_Casa objeto){
        objetos.add(objeto);
    }

    public boolean eliminar_objeto(Objeto_Casa nuevo_valor_objeto){
        for (int i=0; i<objetos.size();i++){
            if(objetos.get(i).getID().equals(nuevo_valor_objeto.getID())){
                objetos.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean actualizar_objeto(Objeto_Casa nuevo_valor_objeto){
        for (Objeto_Casa objeto : objetos) {
            if (objeto.getID().equals(nuevo_valor_objeto.getID())) {
                objeto.setObjeto(nuevo_valor_objeto);
                return true;
            }
        }
        return false;
    }

    public String mostrar_objetos(){
        StringBuilder info= new StringBuilder();
        for (Objeto_Casa objeto : objetos) {
            objeto.calculate_next_pos(ancho, largo);
            info.append(objeto.getInfo());
        }
        return info.toString();
    }
}
