package Presentacion;

import Entidades.Empleado;
import Entidades.Persona;
import LogicaNegocio.LNEmpleado;
import com.microsoft.sqlserver.jdbc.StringUtils;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alequ
 */
public class FrmEmpleadoCRUD extends javax.swing.JDialog {
//atributos globales
    DefaultTableModel modelo;

    public FrmEmpleadoCRUD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        setLocationRelativeTo(null);
        this.setTitle("Empleado");

        try {
            CargarDatos("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tblEmpleados = new javax.swing.JTable();
        btnLimpiar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCodigo = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCorreoElectronico = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtNombre = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtApellido = new javax.swing.JTextPane();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtTelefono = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        tblEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblEmpleados);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel1.setText("Codigo");

        jLabel2.setText("Nombre");

        jLabel3.setText("Correo Electronico");

        jLabel4.setText("Telefono");

        jLabel5.setText("Apellido");

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(102, 102, 102));
        txtCodigo.setFocusable(false);
        jScrollPane1.setViewportView(txtCodigo);

        jScrollPane2.setViewportView(txtCorreoElectronico);

        jScrollPane4.setViewportView(txtNombre);

        jScrollPane5.setViewportView(txtApellido);

        jScrollPane6.setViewportView(txtTelefono);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(19, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(15, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(45, 51, Short.MAX_VALUE)
                                .addComponent(btnLimpiar)
                                .addGap(12, 12, 12)
                                .addComponent(btnGuardar)
                                .addGap(169, 169, 169))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                                            .addComponent(jScrollPane4)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnEliminar)
                                                .addGap(12, 12, 12)
                                                .addComponent(btnSalir))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 0, Short.MAX_VALUE)))))))))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel1))
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //metodos
    //reinicio de tabla
    private void LimpiarTabla() {
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tblEmpleados.setModel(modelo);
        modelo.addColumn("Codigo");
        modelo.addColumn("NombreEmpleado");
        modelo.addColumn("ApellidoEmpleado");
        modelo.addColumn("CorreoElectronico");
        modelo.addColumn("Telefono");

    }

    //cargar datos a la tabla
    private void CargarDatos(String condicion) throws Exception {
        try {
            LNEmpleado logica = new LNEmpleado();
            ArrayList<Empleado> lista;
            LimpiarTabla();
            Object[] fila = new Object[5];
            lista = logica.ListarRegistro(condicion);
            for (Empleado Empleado : lista) {
                fila[0] = Empleado.getIdEmpleado();
                fila[1] = Empleado.getNombre();
                fila[2] = Empleado.getApellido();
                fila[3] = Empleado.getCorreoElectronico();
                fila[4] = Empleado.getTelefono();
                modelo.addRow(fila);
            }

        } catch (Exception e) {
            throw e;
        }
    }
    
    //limpia todos los textbox
    public void Limpiar() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtCodigo.setText("");
        txtCorreoElectronico.setText("");
        txtTelefono.setText("");
    }
    //genera la entidad empleado
    private Empleado GenerarEntidad() {

        Empleado Empleado = new Empleado();
        if (!txtCodigo.getText().equals("")) {

            Empleado.setExiste(true);
            Empleado.setIdEmpleado(Integer.parseInt(txtCodigo.getText()));
        }

        Empleado.setNombre(txtNombre.getText());
        Empleado.setApellido(txtApellido.getText());
        Empleado.setCorreoElectronico(txtCorreoElectronico.getText());
        Empleado.setTelefono(Integer.parseInt(txtTelefono.getText()));

        return Empleado;
    }


    private void tblEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEmpleadosMouseClicked

        if (evt.getClickCount() == 2) {
            int fila = tblEmpleados.rowAtPoint(evt.getPoint());
            txtCodigo.setText(tblEmpleados.getValueAt(fila, 0).toString());
            txtNombre.setText(tblEmpleados.getValueAt(fila, 1).toString());
            txtApellido.setText(tblEmpleados.getValueAt(fila, 2).toString());
            txtCorreoElectronico.setText(tblEmpleados.getValueAt(fila, 3).toString());
            txtTelefono.setText(tblEmpleados.getValueAt(fila, 4).toString());

        }
    }//GEN-LAST:event_tblEmpleadosMouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        //revisa que todos los datos esten correctamente llenos 
        boolean vacio = false;
        if (txtNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los espacios en blanco");
            vacio = true;
        } else {
            if (txtApellido.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los espacios en blanco");
                vacio = true;
            } else {
                if (txtCorreoElectronico.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los espacios en blanco");
                    vacio = true;
                } else {
                    if (txtTelefono.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Debe llenar todos los espacios en blanco");
                        vacio = true;
                    } else {

                        if (!StringUtils.isNumeric(txtTelefono.getText())) {
                            JOptionPane.showMessageDialog(null, "Telefono debe llenarlo con numeros");
                        } else {

                            if (!txtNombre.getText().equals("") && !txtApellido.getText().equals("") && !txtCorreoElectronico.getText().equals("") && !txtTelefono.getText().equals("")) {
                                LNEmpleado logica = new LNEmpleado();
                                Empleado Empleado = GenerarEntidad();
                                try {
                                    if (Empleado.isExiste()) {
                                        logica.Modificar(Empleado);
                                    } else {
                                        logica.Insertar(Empleado);
                                    }

                                    JOptionPane.showMessageDialog(this, logica.getMensaje());
                                    Limpiar();

                                    CargarDatos("");
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(this, e.getMessage());
                                }
                            }

                        }

                    }
                }
            }

        }
 
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        LNEmpleado logica = new LNEmpleado();
        Empleado Empleado;
        //Elimina el producto, pero antes tiene que haberlo seleccionado y sino esta seleccionado el txtcodigo esta vacio
        if (!txtCodigo.getText().equals("")) {
            try {
                Empleado = GenerarEntidad();

                int respuesta = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar el producto?");

                if (respuesta == 0) {
                    if (Empleado.isExiste()) {
                        if (logica.Eliminar(Empleado) > 0) {
                            JOptionPane.showMessageDialog(this, logica.getMensaje());
                            Limpiar();
                            CargarDatos("");
                        } else {
                            JOptionPane.showMessageDialog(this, "No fue posible eliminarlo");
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Debe seleccionar al Empleado");
                    }
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione el dato que desea eliminar dando doble click en la tabla");
        }


    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmEmpleadoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmEmpleadoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmEmpleadoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmEmpleadoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmEmpleadoCRUD dialog = new FrmEmpleadoCRUD(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tblEmpleados;
    private javax.swing.JTextPane txtApellido;
    private javax.swing.JTextPane txtCodigo;
    private javax.swing.JTextPane txtCorreoElectronico;
    private javax.swing.JTextPane txtNombre;
    private javax.swing.JTextPane txtTelefono;
    // End of variables declaration//GEN-END:variables
}
