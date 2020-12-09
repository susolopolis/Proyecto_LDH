package Fuente;

public abstract class Objeto_Electronico {
    double[] posicion;
    String ID;

    public Objeto_Electronico(double[] posicion){
        this.posicion=posicion;
    }
    public Objeto_Electronico(){
        posicion = new double[3];
    }

    public double[] getPosicion(){
        return posicion;
    }

    public void setPosicion(double[] pos){
        posicion = pos;
    }

    public void setObjeto(Objeto_Electronico A){
        posicion = A.getPosicion();
    }
}
