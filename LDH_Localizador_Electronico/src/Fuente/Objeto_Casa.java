package Fuente;

public class Objeto_Casa{


    //VARIABLES DE APARATOS ELECTRONICOS//
    //COMPROBAR QUE EL IDENTIFICADOR SEA UNICO: VA A SER,POR EJEMPLO, "SMARTPHONE DE JESUS"

    private final String ID;
    private String marca;
    private String modelo;
    private String valor;
    private Ruta ruta;

    public Objeto_Casa(String ID,String marca, String modelo,String valor){
        this.ID = ID;
        this.marca = marca;
        this.modelo = modelo;
        this.valor = valor;
        this.ruta = new Ruta();
    }

    public void setObjeto(Objeto_Casa nuevo_objeto){
        this.modelo = nuevo_objeto.getModelo();
        this.marca = nuevo_objeto.getMarca();
        this.valor = nuevo_objeto.getValor();
        this.ruta = nuevo_objeto.getRuta();
    }

    public String getID(){return ID;}
    public String getMarca(){
        return marca;
    }

    public String getModelo(){
        return modelo;
    }

    public String getValor(){
        return valor;
    }

    public Ruta getRuta(){
        return ruta;
    }


    public void calculate_next_pos(int ancho,int largo) {
            ruta.calcular_pos_actual(ancho,largo);
    }

    public String getInfo(){
            int x,y;
            x = ruta.get_pos_x();
            y = ruta.get_pos_y();

            return this.getID() + " | Posicion: [" + x + "," + y +"] " + " | Modelo: " + this.getModelo() + " | Marca: " + this.getMarca() + " | Valor: " + this.getValor() + "\n";
        }
}
