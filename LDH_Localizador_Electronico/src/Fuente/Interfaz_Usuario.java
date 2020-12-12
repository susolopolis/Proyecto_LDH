package Fuente;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interfaz_Usuario extends JFrame{


    private JPanel Pantalla_1;
    private JLabel Lista_Objetos;
    private JButton crear_objeto;
    private JButton actualizar_objeto;
    private JButton eliminar_objeto;
    private JLabel Objetos_Actuales;
    private JTextField texto_id;
    private JLabel etiqueta_ID;
    private JTextField texto_marca;
    private JLabel etiqueta_Marca;
    private JTextField texto_modelo;
    private JLabel etiqueta_modelo;
    private JTextField texto_valor;
    private JLabel etiqueta_valor;
    private JTextPane textPane1;
    private JButton Mostrar_Objetos;

    public Interfaz_Usuario(String titulo) {
        super(titulo);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane((Pantalla_1));
        this.pack();

        Casa nueva_casa= new Casa(1000,500);

        crear_objeto.addActionListener(e -> {
            String ID = texto_id.getText();
            String Modelo = texto_modelo.getText();
            String Marca = texto_marca.getText();
            String valor = texto_valor.getText();

            Objeto_Casa nuevo_objeto = new Objeto_Casa(ID,Marca,Modelo,valor);
            nueva_casa.agregar_objeto(nuevo_objeto);
        });
        eliminar_objeto.addActionListener(e -> {
            String ID = texto_id.getText();
            String Modelo = texto_modelo.getText();
            String Marca = texto_marca.getText();
            String valor = texto_valor.getText();

            Objeto_Casa nuevo_objeto = new Objeto_Casa(ID,Marca,Modelo,valor);
            nueva_casa.eliminar_objeto(nuevo_objeto);
        });

        actualizar_objeto.addActionListener(e -> {
            String ID = texto_id.getText();
            String Modelo = texto_modelo.getText();
            String Marca = texto_marca.getText();
            String valor = texto_valor.getText();

            Objeto_Casa nuevo_objeto = new Objeto_Casa(ID,Marca,Modelo,valor);
            nueva_casa.actualizar_objeto(nuevo_objeto);
        });

        Mostrar_Objetos.addActionListener(e -> {
            String objetos;
            objetos = nueva_casa.mostrar_objetos();
            textPane1.setText(objetos);
        });
    }

    public static void main(String[] args) {
        JFrame frame = new Interfaz_Usuario("Programa de Seguimiento de Objetos en Casa");
        frame.setVisible(true);
    }
}
