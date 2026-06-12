package vallegrande.edu.pe.view;

import vallegrande.edu.pe.controller.ExpedicionController;
import vallegrande.edu.pe.model.Usuario;

import javax.swing.*;
import java.awt.*;

public class UsuarioFormView extends JDialog {

    private final ExpedicionController ctrl = new ExpedicionController();
    private final UsuarioListaView padre;
    private final Usuario usuarioEditar;

    private JTextField txtNombre;
    private JTextField txtFecha;
    private JTextField txtExpedicion;

    private JLabel lblNombreError;
    private JLabel lblFechaError;
    private JLabel lblExpedicionError;

    public UsuarioFormView(UsuarioListaView padre, Usuario u) {
        super(padre, u == null ? "Nuevo Usuario" : "Editar Usuario", true);

        this.padre = padre;
        this.usuarioEditar = u;

        construirUI();

        if (u != null) {
            precargar(u);
        }
    }

    private void construirUI() {

        setSize(500, 400);
        setLocationRelativeTo(getOwner());
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridBagLayout());
        form.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        GridBagConstraints g = new GridBagConstraints();
        g.fill = GridBagConstraints.HORIZONTAL;
        g.insets = new Insets(5, 5, 5, 5);

        // Nombre
        g.gridx = 0;
        g.gridy = 0;
        form.add(label("Nombre *"), g);

        txtNombre = campo();
        g.gridy = 1;
        form.add(txtNombre, g);

        lblNombreError = error();
        g.gridy = 2;
        form.add(lblNombreError, g);

        // Fecha
        g.gridy = 3;
        form.add(label("Fecha *"), g);

        txtFecha = campo();
        g.gridy = 4;
        form.add(txtFecha, g);

        lblFechaError = error();
        g.gridy = 5;
        form.add(lblFechaError, g);

        // Expedición
        g.gridy = 6;
        form.add(label("Expedición *"), g);

        txtExpedicion = campo();
        g.gridy = 7;
        form.add(txtExpedicion, g);

        lblExpedicionError = error();
        g.gridy = 8;
        form.add(lblExpedicionError, g);

        add(form, BorderLayout.CENTER);

        JPanel botones = new JPanel();

        JButton btnGuardar =
                new JButton(usuarioEditar == null ? "GUARDAR" : "ACTUALIZAR");

        JButton btnCancelar = new JButton("CANCELAR");

        btnGuardar.addActionListener(e -> guardar());
        btnCancelar.addActionListener(e -> dispose());

        botones.add(btnGuardar);
        botones.add(btnCancelar);

        add(botones, BorderLayout.SOUTH);
    }

    private void guardar() {

        lblNombreError.setText("");
        lblFechaError.setText("");
        lblExpedicionError.setText("");

        String nombre = txtNombre.getText().trim();
        String fecha = txtFecha.getText().trim();
        String expedicion = txtExpedicion.getText().trim();

        boolean error = false;

        if (nombre.isEmpty()) {
            lblNombreError.setText("Ingrese el nombre.");
            error = true;
        }

        if (fecha.isEmpty()) {
            lblFechaError.setText("Ingrese la fecha.");
            error = true;
        }

        if (expedicion.isEmpty()) {
            lblExpedicionError.setText("Ingrese la expedición.");
            error = true;
        }

        if (error) {
            return;
        }

        String resultado;

        if (usuarioEditar == null) {

            resultado = ctrl.guardar (
                    nombre,
                    fecha ,
                    expedicion
            );

        } else {

            resultado = ctrl.actualizar(
                    usuarioEditar.getCodigo(),
                    nombre,
                    fecha,
                    expedicion
            );
        }

        if ("OK".equals(resultado)) {

            JOptionPane.showMessageDialog(
                    this,
                    "Operación realizada correctamente."
            );

            padre.cargarDatos();
            dispose();

        } else {

            JOptionPane.showMessageDialog(
                    this,
                    resultado,
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void precargar(Usuario u) {

        txtNombre.setText(u.getNombre());
        txtFecha.setText(u.getFecha());
        txtExpedicion.setText(u.getExpedicion());
    }

    private JTextField campo() {

        JTextField txt = new JTextField();

        txt.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(Color.GRAY),
                        BorderFactory.createEmptyBorder(5, 5, 5, 5)
                )
        );

        return txt;
    }

    private JLabel label(String texto) {

        JLabel lbl = new JLabel(texto);
        lbl.setFont(new Font("Segoe UI", Font.BOLD, 12));

        return lbl;
    }

    private JLabel error() {

        JLabel lbl = new JLabel();
        lbl.setForeground(Color.RED);

        return lbl;
    }
}