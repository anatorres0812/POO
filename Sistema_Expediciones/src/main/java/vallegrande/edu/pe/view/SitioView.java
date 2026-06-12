package vallegrande.edu.pe.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class SitioView extends JFrame {

    public JTextField txtCodigo;
    public JTextField txtNombre;
    public JTextField txtPais;
    public JTextField txtAnio;
    public JTextField txtEstado;

    public JButton btnGuardar;
    public JButton btnModificar;
    public JButton btnEliminar;
    public JButton btnListar;

    public JTable tabla;

    public SitioView() {

        setTitle("Sistema de Expediciones Arqueológicas");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblCodigo = new JLabel("Código:");
        lblCodigo.setBounds(30, 30, 120, 25);
        panel.add(lblCodigo);

        txtCodigo = new JTextField();
        txtCodigo.setBounds(180, 30, 200, 25);
        panel.add(txtCodigo);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(30, 70, 120, 25);
        panel.add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(180, 70, 200, 25);
        panel.add(txtNombre);

        JLabel lblPais = new JLabel("País:");
        lblPais.setBounds(30, 110, 120, 25);
        panel.add(lblPais);

        txtPais = new JTextField();
        txtPais.setBounds(180, 110, 200, 25);
        panel.add(txtPais);

        JLabel lblAnio = new JLabel("Año Descubrimiento:");
        lblAnio.setBounds(30, 150, 140, 25);
        panel.add(lblAnio);

        txtAnio = new JTextField();
        txtAnio.setBounds(180, 150, 200, 25);
        panel.add(txtAnio);

        JLabel lblEstado = new JLabel("Estado Conservación:");
        lblEstado.setBounds(30, 190, 140, 25);
        panel.add(lblEstado);

        txtEstado = new JTextField();
        txtEstado.setBounds(180, 190, 200, 25);
        panel.add(txtEstado);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(450, 30, 120, 30);
        panel.add(btnGuardar);

        btnModificar = new JButton("Modificar");
        btnModificar.setBounds(450, 80, 120, 30);
        panel.add(btnModificar);

        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBounds(450, 130, 120, 30);
        panel.add(btnEliminar);

        btnListar = new JButton("Listar");
        btnListar.setBounds(450, 180, 120, 30);
        panel.add(btnListar);

        tabla = new JTable();
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(30, 260, 820, 250);

        panel.add(scrollPane);

        add(panel);

        setVisible(true);
    }
}
