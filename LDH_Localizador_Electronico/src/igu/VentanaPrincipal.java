package igu;

import logica.Casa;
import logica.Objeto_Casa;
import logica.Ruta;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.GridLayout;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;


    private JPanel pnPrincipal;
    private JPanel pnObjetos;
    private JPanel pnLocalizacion;
    private JLabel lbListaObjetos;

    private JScrollPane scrollPaneListaObjetos;
    private JList<Objeto_Casa> listObjetos;
    private DefaultListModel<Objeto_Casa> modelObjetos;
    private DefaultListModel<Objeto_Casa> modelObjetosGuardados;

    private JPanel pnBotones;
    private JPanel pnBtInferior;
    private JButton btRecuperar;
    private JButton btGuardar;
    private JPanel pnBtSuperior;
    private JButton btCrear;
    private JButton btActualizar;
    private JButton btEliminar;
    private JLabel lbInformacionObjetos;
    private JPanel pnCampos;
    private JPanel pnPosiciones;
    private JLabel lbId;
    private JTextField txId;
    private JLabel lbMarca;
    private JTextField txMarca;
    private JLabel lbModelo;
    private JTextField txModelo;
    private JLabel lbValor;
    private JTextField txValor;
    private JCheckBox chckbxEditar;
    private JSeparator separator;
    private JLabel lbPosicionX;
    private JTextField txPosicionX;
    private JLabel lbPosicionY;
    private JTextField txPosicionY;

    Casa casa;

    Objeto_Casa ultimaSeleccion = null;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    VentanaPrincipal frame = new VentanaPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public VentanaPrincipal() {
        casa = new Casa(1000, 500);
        modelObjetosGuardados = new DefaultListModel<Objeto_Casa>();

        setTitle("Seguimiento de objetos en el hogar");
        setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/ObjectTrackingIcon.png")));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 400);
        pnPrincipal = new JPanel();
        pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
        pnPrincipal.setLayout(new BorderLayout(0, 0));
        setContentPane(pnPrincipal);
        pnPrincipal.add(getPnObjetos(), BorderLayout.WEST);
        pnPrincipal.add(getPnLocalizacion(), BorderLayout.CENTER);

        setLocationRelativeTo(null);
    }

    private JPanel getPnObjetos() {
        if (pnObjetos == null) {
            pnObjetos = new JPanel();
            GridBagLayout gbl_pnObjetos = new GridBagLayout();
            gbl_pnObjetos.columnWidths = new int[]{214, 0};
            gbl_pnObjetos.rowHeights = new int[]{36, 244, 70, 0, 0, 0};
            gbl_pnObjetos.columnWeights = new double[]{1.0, Double.MIN_VALUE};
            gbl_pnObjetos.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
            pnObjetos.setLayout(gbl_pnObjetos);
            GridBagConstraints gbc_lbListaObjetos = new GridBagConstraints();
            gbc_lbListaObjetos.fill = GridBagConstraints.BOTH;
            gbc_lbListaObjetos.insets = new Insets(0, 0, 5, 0);
            gbc_lbListaObjetos.gridx = 0;
            gbc_lbListaObjetos.gridy = 0;
            pnObjetos.add(getLbListaObjetos(), gbc_lbListaObjetos);
            GridBagConstraints gbc_scrollPaneListaObjetos = new GridBagConstraints();
            gbc_scrollPaneListaObjetos.fill = GridBagConstraints.BOTH;
            gbc_scrollPaneListaObjetos.insets = new Insets(0, 0, 5, 0);
            gbc_scrollPaneListaObjetos.gridx = 0;
            gbc_scrollPaneListaObjetos.gridy = 1;
            pnObjetos.add(getScrollPaneListaObjetos(), gbc_scrollPaneListaObjetos);
            GridBagConstraints gbc_pnBotones = new GridBagConstraints();
            gbc_pnBotones.insets = new Insets(0, 0, 5, 0);
            gbc_pnBotones.fill = GridBagConstraints.BOTH;
            gbc_pnBotones.gridx = 0;
            gbc_pnBotones.gridy = 2;
            pnObjetos.add(getPnBotones(), gbc_pnBotones);
        }
        return pnObjetos;
    }

    private JPanel getPnLocalizacion() {
        if (pnLocalizacion == null) {
            pnLocalizacion = new JPanel();
            pnLocalizacion.setLayout(new BorderLayout(0, 0));
            pnLocalizacion.add(getLbInformacionObjetos(), BorderLayout.NORTH);
            pnLocalizacion.add(getPnCampos(), BorderLayout.CENTER);
            pnLocalizacion.add(getPnPosiciones(), BorderLayout.SOUTH);
        }
        return pnLocalizacion;
    }

    private JLabel getLbListaObjetos() {
        if (lbListaObjetos == null) {
            lbListaObjetos = new JLabel("Lista de objetos:");
            lbListaObjetos.setVerticalAlignment(SwingConstants.TOP);
            lbListaObjetos.setFont(new Font("Tahoma", Font.BOLD, 16));
        }
        return lbListaObjetos;
    }

    private JScrollPane getScrollPaneListaObjetos() {
        if (scrollPaneListaObjetos == null) {
            scrollPaneListaObjetos = new JScrollPane();
            scrollPaneListaObjetos.setViewportBorder(new EmptyBorder(1, 1, 1, 1));
            scrollPaneListaObjetos.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPaneListaObjetos.setViewportView(getListObjetos());
        }
        return scrollPaneListaObjetos;
    }

    private JList<Objeto_Casa> getListObjetos() {
        if (listObjetos == null) {
            modelObjetos = new DefaultListModel<Objeto_Casa>();
            listObjetos = new JList<Objeto_Casa>();
            listObjetos.addListSelectionListener(new ListSelectionListener() {
                public void valueChanged(ListSelectionEvent arg0) {
                    if (!listObjetos.isSelectionEmpty())
                        actualizarValores(modelObjetos.get(listObjetos.getSelectedIndex()));
                }
            });
            listObjetos.setModel(modelObjetos);
            listObjetos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        }
        return listObjetos;
    }


    private JPanel getPnBotones() {
        if (pnBotones == null) {
            pnBotones = new JPanel();
            pnBotones.setLayout(new GridLayout(2, 3, 0, 0));
            pnBotones.add(getPnBtSuperior());
            pnBotones.add(getPnBtInferior());
        }
        return pnBotones;
    }

    private JPanel getPnBtInferior() {
        if (pnBtInferior == null) {
            pnBtInferior = new JPanel();
            pnBtInferior.add(getBtRecuperar());
            pnBtInferior.add(getBtGuardar());
        }
        return pnBtInferior;
    }

    private JButton getBtRecuperar() {
        if (btRecuperar == null) {
            btRecuperar = new JButton("Recuperar");
            btRecuperar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    Object[] opciones = modelObjetosGuardados.toArray();

                    Object objetoSeleccionado = JOptionPane.showInputDialog(getReferenciaThis(),
                            "Escoje un objeto a recuperar",
                            "Recuperar objeto",
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            opciones,
                            ultimaSeleccion);

                    if (objetoSeleccionado == null) {
                        // Si el usuario cancela; no ha seleccionado nada; o pulsó Escape or hit escape
                        JOptionPane.showMessageDialog(null, "\r\nOperación cancelada");
                    } else {
                        // Se recupera el objeto
                        ultimaSeleccion = (Objeto_Casa) objetoSeleccionado;
                        recuperarObjeto(ultimaSeleccion);
                    }
                }
            });
        }
        return btRecuperar;
    }

    private void recuperarObjeto(Objeto_Casa objetoARecuperar) {
        if (!doesItContain(objetoARecuperar, modelObjetos)) {
            modelObjetos.addElement(objetoARecuperar);
            casa.agregar_objeto(objetoARecuperar);
        } else {
            JOptionPane.showMessageDialog(null, "El objeto que desea recuperar ya existe" +
                    " en la lista actual");
        }
    }

    private JButton getBtGuardar() {
        if (btGuardar == null) {
            btGuardar = new JButton("Guardar");
            btGuardar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if (!listObjetos.isSelectionEmpty()) {
                        Objeto_Casa objetoAGuardar = listObjetos.getSelectedValue();
                        if (modelObjetosGuardados.isEmpty()) {
                            modelObjetosGuardados.addElement(objetoAGuardar);
                            JOptionPane.showMessageDialog(null, "Se ha guardado el objeto correctamente.");
                        } else {
                            if (!doesItContain(objetoAGuardar, modelObjetosGuardados)) {
                                modelObjetosGuardados.addElement(objetoAGuardar);
                                JOptionPane.showMessageDialog(null, "Se ha guardado el objeto correctamente.");
                            } else {
                                JOptionPane.showMessageDialog(null, "El objeto "
                                        + objetoAGuardar.getModelo() + " con ID " + objetoAGuardar.getID() +
                                        " ya estaba guardado.", "Objeto previamente almacenado", JOptionPane.WARNING_MESSAGE);
                            }
                        }

                    }

                }
            });
        }
        return btGuardar;
    }

    private JPanel getPnBtSuperior() {
        if (pnBtSuperior == null) {
            pnBtSuperior = new JPanel();
            pnBtSuperior.add(getBtCrear());
            pnBtSuperior.add(getBtActualizar());
            pnBtSuperior.add(getBtEliminar());
        }
        return pnBtSuperior;
    }

    private JButton getBtCrear() {
        if (btCrear == null) {
            btCrear = new JButton("Crear");
            btCrear.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if (getChckbxEditar().isSelected()) {

                        String campoID = getTxId().getText();
                        String campoMarca = getTxMarca().getText();
                        String campoModelo = getTxModelo().getText();
                        String campoValor = getTxValor().getText();

                        if (!(campoID.isBlank() && campoMarca.isBlank() && campoModelo.isBlank() && campoValor.isBlank())) {
                            Objeto_Casa objetoACrear = new Objeto_Casa(campoID, campoMarca, campoModelo, campoValor, casa);
                            if (modelObjetos.isEmpty() || !doesItContain(objetoACrear, modelObjetos)) {
                                modelObjetos.addElement(objetoACrear);
                                casa.agregar_objeto(objetoACrear);
                            } else {
                                JOptionPane.showMessageDialog(null,
                                        "Ya existe un objeto con el mismo ID en la lista. Por favor, introduce otro ID");
                            }
                        }
                    }
                }
            });
        }
        return btCrear;
    }

    private boolean doesItContain(Objeto_Casa objetoAComprobar, DefaultListModel<Objeto_Casa> modeloDeBusqueda) {
        for (int i = 0; i < modeloDeBusqueda.size(); i++) {
            if (modeloDeBusqueda.get(i).getID().equals(objetoAComprobar.getID())) {
                return true;
            }
        }
        return false;
    }

    private JButton getBtActualizar() {
        if (btActualizar == null) {
            btActualizar = new JButton("Actualizar");
            btActualizar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if (!listObjetos.isSelectionEmpty()) {
                        Objeto_Casa objetoActualizable = modelObjetos.get(listObjetos.getSelectedIndex());
                        actualizarValores(objetoActualizable);
                    } else {
                        JOptionPane.showMessageDialog(null, "Por favor, selecciona " +
                                "un elemento de la lista para actualizar la información.");
                    }

                }
            });
        }
        return btActualizar;
    }

    private void actualizarValores(Objeto_Casa objetoActualizable) {
        String idActualizado = objetoActualizable.getInfo()[0];
        String marcaActualizada = objetoActualizable.getInfo()[1];
        String modeloActualizado = objetoActualizable.getInfo()[2];
        String valorActualizado = objetoActualizable.getInfo()[3];

        getTxId().setText(idActualizado);
        getTxMarca().setText(marcaActualizada);
        getTxModelo().setText(modeloActualizado);
        getTxValor().setText(valorActualizado);

        objetoActualizable.calculate_next_pos(Ruta.COTA_DE_DESPLAZAMIENTO_X, Ruta.COTA_DE_DESPLAZAMIENTO_Y);

        String valorPosXActualizado = objetoActualizable.getInfo()[4];
        String valorPosYActualizado = objetoActualizable.getInfo()[5];

        getTxPosicionX().setText(valorPosXActualizado);
        getTxPosicionY().setText(valorPosYActualizado);
    }

    private JButton getBtEliminar() {
        if (btEliminar == null) {
            btEliminar = new JButton("Eliminar");
            btEliminar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    if (!listObjetos.isSelectionEmpty()) {
                        Objeto_Casa objetoABorrar = listObjetos.getSelectedValue();
                        modelObjetos.removeElement(objetoABorrar);
                        casa.eliminar_objeto(objetoABorrar);
                        vaciarCampos();
                    } else {
                        JOptionPane.showMessageDialog(null, "Puede que la lista " +
                                "se encuentre vacía o no haya seleccionado ningún elemento.");
                    }
                }
            });
        }
        return btEliminar;
    }

    private void vaciarCampos() {
        getTxId().setText("");
        getTxMarca().setText("");
        getTxModelo().setText("");
        getTxValor().setText("");
        getTxPosicionX().setText("");
        getTxPosicionY().setText("");
    }

    private JLabel getLbInformacionObjetos() {
        if (lbInformacionObjetos == null) {
            lbInformacionObjetos = new JLabel("Informacion del objeto:");
            lbInformacionObjetos.setHorizontalAlignment(SwingConstants.CENTER);
            lbInformacionObjetos.setFont(new Font("Sylfaen", Font.BOLD, 22));
        }
        return lbInformacionObjetos;
    }

    private JPanel getPnCampos() {
        if (pnCampos == null) {
            pnCampos = new JPanel();
            pnCampos.setToolTipText("Cuando esta opci\u00F3n est\u00E1 deshabilitada, solo podr\u00E1 mostrarse la informaci\u00F3n. En caso contrario, se podr\u00E1n modificar los campos.");
            GridBagLayout gbl_pnCampos = new GridBagLayout();
            gbl_pnCampos.columnWidths = new int[]{119, 223, 0};
            gbl_pnCampos.rowHeights = new int[]{60, 60, 60, 60, 60, 0};
            gbl_pnCampos.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
            gbl_pnCampos.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
            pnCampos.setLayout(gbl_pnCampos);
            GridBagConstraints gbc_lbId = new GridBagConstraints();
            gbc_lbId.fill = GridBagConstraints.BOTH;
            gbc_lbId.insets = new Insets(0, 0, 5, 5);
            gbc_lbId.gridx = 0;
            gbc_lbId.gridy = 0;
            pnCampos.add(getLbId(), gbc_lbId);
            GridBagConstraints gbc_txId = new GridBagConstraints();
            gbc_txId.fill = GridBagConstraints.BOTH;
            gbc_txId.insets = new Insets(0, 0, 5, 0);
            gbc_txId.gridx = 1;
            gbc_txId.gridy = 0;
            pnCampos.add(getTxId(), gbc_txId);
            GridBagConstraints gbc_lbMarca = new GridBagConstraints();
            gbc_lbMarca.fill = GridBagConstraints.BOTH;
            gbc_lbMarca.insets = new Insets(0, 0, 5, 5);
            gbc_lbMarca.gridx = 0;
            gbc_lbMarca.gridy = 1;
            pnCampos.add(getLbMarca(), gbc_lbMarca);
            GridBagConstraints gbc_txMarca = new GridBagConstraints();
            gbc_txMarca.fill = GridBagConstraints.BOTH;
            gbc_txMarca.insets = new Insets(0, 0, 5, 0);
            gbc_txMarca.gridx = 1;
            gbc_txMarca.gridy = 1;
            pnCampos.add(getTxMarca(), gbc_txMarca);
            GridBagConstraints gbc_lbModelo = new GridBagConstraints();
            gbc_lbModelo.fill = GridBagConstraints.BOTH;
            gbc_lbModelo.insets = new Insets(0, 0, 5, 5);
            gbc_lbModelo.gridx = 0;
            gbc_lbModelo.gridy = 2;
            pnCampos.add(getLbModelo(), gbc_lbModelo);
            GridBagConstraints gbc_txModelo = new GridBagConstraints();
            gbc_txModelo.fill = GridBagConstraints.BOTH;
            gbc_txModelo.insets = new Insets(0, 0, 5, 0);
            gbc_txModelo.gridx = 1;
            gbc_txModelo.gridy = 2;
            pnCampos.add(getTxModelo(), gbc_txModelo);
            GridBagConstraints gbc_lbValor = new GridBagConstraints();
            gbc_lbValor.fill = GridBagConstraints.BOTH;
            gbc_lbValor.insets = new Insets(0, 0, 5, 5);
            gbc_lbValor.gridx = 0;
            gbc_lbValor.gridy = 3;
            pnCampos.add(getLbValor(), gbc_lbValor);
            GridBagConstraints gbc_txValor = new GridBagConstraints();
            gbc_txValor.fill = GridBagConstraints.BOTH;
            gbc_txValor.insets = new Insets(0, 0, 5, 0);
            gbc_txValor.gridx = 1;
            gbc_txValor.gridy = 3;
            pnCampos.add(getTxValor(), gbc_txValor);
            GridBagConstraints gbc_separator = new GridBagConstraints();
            gbc_separator.fill = GridBagConstraints.BOTH;
            gbc_separator.insets = new Insets(0, 0, 0, 5);
            gbc_separator.gridx = 0;
            gbc_separator.gridy = 4;
            pnCampos.add(getSeparator(), gbc_separator);
            GridBagConstraints gbc_chckbxEditar = new GridBagConstraints();
            gbc_chckbxEditar.fill = GridBagConstraints.BOTH;
            gbc_chckbxEditar.gridx = 1;
            gbc_chckbxEditar.gridy = 4;
            pnCampos.add(getChckbxEditar(), gbc_chckbxEditar);
        }
        return pnCampos;
    }

    private JPanel getPnPosiciones() {
        if (pnPosiciones == null) {
            pnPosiciones = new JPanel();
            GridBagLayout gbl_pnPosiciones = new GridBagLayout();
            gbl_pnPosiciones.columnWidths = new int[]{104, 137, 94, 137, 0};
            gbl_pnPosiciones.rowHeights = new int[]{20, 0};
            gbl_pnPosiciones.columnWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
            gbl_pnPosiciones.rowWeights = new double[]{0.0, Double.MIN_VALUE};
            pnPosiciones.setLayout(gbl_pnPosiciones);
            GridBagConstraints gbc_lbPosicionX = new GridBagConstraints();
            gbc_lbPosicionX.insets = new Insets(0, 0, 0, 5);
            gbc_lbPosicionX.gridx = 0;
            gbc_lbPosicionX.gridy = 0;
            pnPosiciones.add(getLbPosicionX(), gbc_lbPosicionX);
            GridBagConstraints gbc_txPosicionX = new GridBagConstraints();
            gbc_txPosicionX.fill = GridBagConstraints.HORIZONTAL;
            gbc_txPosicionX.insets = new Insets(0, 0, 0, 5);
            gbc_txPosicionX.gridx = 1;
            gbc_txPosicionX.gridy = 0;
            pnPosiciones.add(getTxPosicionX(), gbc_txPosicionX);
            GridBagConstraints gbc_lbPosicionY = new GridBagConstraints();
            gbc_lbPosicionY.insets = new Insets(0, 0, 0, 5);
            gbc_lbPosicionY.gridx = 2;
            gbc_lbPosicionY.gridy = 0;
            pnPosiciones.add(getLbPosicionY(), gbc_lbPosicionY);
            GridBagConstraints gbc_txPosicionY = new GridBagConstraints();
            gbc_txPosicionY.fill = GridBagConstraints.HORIZONTAL;
            gbc_txPosicionY.gridx = 3;
            gbc_txPosicionY.gridy = 0;
            pnPosiciones.add(getTxPosicionY(), gbc_txPosicionY);
        }
        return pnPosiciones;
    }

    private JLabel getLbId() {
        if (lbId == null) {
            lbId = new JLabel("ID: ");
            lbId.setHorizontalAlignment(SwingConstants.CENTER);
            lbId.setFont(new Font("Tahoma", Font.BOLD, 14));
        }
        return lbId;
    }

    private JTextField getTxId() {
        if (txId == null) {
            txId = new JTextField();
            txId.setColumns(10);
        }
        return txId;
    }

    private JLabel getLbMarca() {
        if (lbMarca == null) {
            lbMarca = new JLabel("Marca: ");
            lbMarca.setHorizontalAlignment(SwingConstants.CENTER);
            lbMarca.setFont(new Font("Tahoma", Font.BOLD, 14));
        }
        return lbMarca;
    }

    private JTextField getTxMarca() {
        if (txMarca == null) {
            txMarca = new JTextField();
            txMarca.setFont(new Font("Tahoma", Font.PLAIN, 11));
            txMarca.setColumns(10);
        }
        return txMarca;
    }

    private JLabel getLbModelo() {
        if (lbModelo == null) {
            lbModelo = new JLabel("Modelo:");
            lbModelo.setHorizontalAlignment(SwingConstants.CENTER);
            lbModelo.setFont(new Font("Tahoma", Font.BOLD, 14));
        }
        return lbModelo;
    }

    private JTextField getTxModelo() {
        if (txModelo == null) {
            txModelo = new JTextField();
            txModelo.setColumns(10);
        }
        return txModelo;
    }

    private JLabel getLbValor() {
        if (lbValor == null) {
            lbValor = new JLabel("Valor: ");
            lbValor.setHorizontalAlignment(SwingConstants.CENTER);
            lbValor.setFont(new Font("Tahoma", Font.BOLD, 14));
        }
        return lbValor;
    }

    private JTextField getTxValor() {
        if (txValor == null) {
            txValor = new JTextField();
            txValor.setColumns(10);
        }
        return txValor;
    }

    private JCheckBox getChckbxEditar() {
        if (chckbxEditar == null) {
            chckbxEditar = new JCheckBox("Editar");
            chckbxEditar.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent arg0) {
                    boolean isSelected = getChckbxEditar().isSelected();
                    getTxId().setEditable(isSelected);
                    getTxMarca().setEditable(isSelected);
                    getTxModelo().setEditable(isSelected);
                    getTxValor().setEditable(isSelected);
                }
            });
            chckbxEditar.setHorizontalAlignment(SwingConstants.RIGHT);
            chckbxEditar.setSelected(true);
        }
        return chckbxEditar;
    }

    private JSeparator getSeparator() {
        if (separator == null) {
            separator = new JSeparator();
            separator.setForeground(SystemColor.scrollbar);
        }
        return separator;
    }

    private JLabel getLbPosicionX() {
        if (lbPosicionX == null) {
            lbPosicionX = new JLabel("Posicion X: ");
            lbPosicionX.setHorizontalAlignment(SwingConstants.CENTER);
            lbPosicionX.setFont(new Font("Tahoma", Font.BOLD, 14));
        }
        return lbPosicionX;
    }

    private JTextField getTxPosicionX() {
        if (txPosicionX == null) {
            txPosicionX = new JTextField();
            txPosicionX.setEditable(false);
            txPosicionX.setHorizontalAlignment(SwingConstants.CENTER);
            txPosicionX.setColumns(10);
        }
        return txPosicionX;
    }

    private JLabel getLbPosicionY() {
        if (lbPosicionY == null) {
            lbPosicionY = new JLabel("Posicion Y: ");
            lbPosicionY.setHorizontalAlignment(SwingConstants.CENTER);
            lbPosicionY.setFont(new Font("Tahoma", Font.BOLD, 14));
        }
        return lbPosicionY;
    }

    private JTextField getTxPosicionY() {
        if (txPosicionY == null) {
            txPosicionY = new JTextField();
            txPosicionY.setEditable(false);
            txPosicionY.setHorizontalAlignment(SwingConstants.CENTER);
            txPosicionY.setColumns(10);
        }
        return txPosicionY;
    }

    private VentanaPrincipal getReferenciaThis() {
        return this;
    }
}