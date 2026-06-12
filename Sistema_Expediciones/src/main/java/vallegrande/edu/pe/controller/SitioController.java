package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.dao.SitioDAO;
import vallegrande.edu.pe.model.SitioArqueologico;
import vallegrande.edu.pe.view.SitioView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SitioController implements ActionListener {

    private SitioView vista;
    private SitioDAO dao;

    public SitioController(SitioView vista) {

        this.vista = vista;
        this.dao = new SitioDAO();

        this.vista.btnGuardar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vista.btnGuardar) {

            try {

                String codigo = vista.txtCodigo.getText().trim();
                String nombre = vista.txtNombre.getText().trim();
                String pais = vista.txtPais.getText().trim();
                String anioTexto = vista.txtAnio.getText().trim();
                String estado = vista.txtEstado.getText().trim();

                // VALIDAR CÓDIGO (Ejemplo: SIT001)
                if (!codigo.matches("^[A-Z]{3}\\d{3}$")) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Código inválido. Ejemplo: SIT001"
                    );
                    return;
                }

                // VALIDAR NOMBRE
                if (!nombre.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$")) {

                    JOptionPane.showMessageDialog(
                            null,
                            "El nombre solo debe contener letras."
                    );
                    return;
                }

                // VALIDAR PAÍS
                if (!pais.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$")) {

                    JOptionPane.showMessageDialog(
                            null,
                            "El país solo debe contener letras."
                    );
                    return;
                }

                // VALIDAR AÑO
                if (!anioTexto.matches("\\d{4}")) {

                    JOptionPane.showMessageDialog(
                            null,
                            "Ingrese un año válido de 4 dígitos."
                    );
                    return;
                }

                int anio = Integer.parseInt(anioTexto);

                if (anio < 1000 || anio > 2026) {

                    JOptionPane.showMessageDialog(
                            null,
                            "El año debe estar entre 1000 y 2026."
                    );
                    return;
                }

                // VALIDAR ESTADO
                if (!estado.matches("^[A-Za-zÁÉÍÓÚáéíóúÑñ ]+$")) {

                    JOptionPane.showMessageDialog(
                            null,
                            "El estado de conservación solo debe contener letras."
                    );
                    return;
                }

                SitioArqueologico sitio = new SitioArqueologico();

                sitio.setCodigo(codigo);
                sitio.setNombre(nombre);
                sitio.setPais(pais);
                sitio.setAnioDescubrimiento(anio);
                sitio.setEstadoConservacion(estado);

                dao.guardar(sitio);

                JOptionPane.showMessageDialog(
                        null,
                        "Registro guardado correctamente."
                );

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        null,
                        "Error: " + ex.getMessage()
                );
            }
        }
    }
}