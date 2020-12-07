package Fuente;

public abstract class Objeto_Electronico {
    float[] posicion;

    public Objeto_Electronico(float[] posicion){
        this.posicion=posicion;
    }

    public float[] getPosicion(){
        return posicion;
    }
    public void setObjeto(Objeto_Electronico A){
        posicion = A.getPosicion();
    }
}
