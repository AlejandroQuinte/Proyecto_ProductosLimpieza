/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Presentacion;

import Entidades.Cliente;
import Entidades.Empleado;
import LogicaNegocio.LNCliente;
import com.microsoft.sqlserver.jdbc.StringUtils;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alequ
 */
public class FrmClienteCRUD extends javax.swing.JDialog {

    DefaultTableModel modelo;

    public FrmClienteCRUD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Cliente");
        this.setLocationRelativeTo(null);

        try {
            CargarDatos("");
        } catch (Exception e) {
        }

    }

    //METODOS
    //REINCIIAR TABLAs
    private void LimpiarTabla() {
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tblClientes.setModel(modelo);
        modelo.addColumn("Codigo");
        modelo.addColumn("NombreCliente");
        modelo.addColumn("Apellido");
        modelo.addColumn("CorreoElectronico");
        modelo.addColumn("Telefono");

    }
//Cargar los datos a la tabla

    private void CargarDatos(String condicion) throws Exception {
        try {
            LNCliente logica = new LNCliente();
            ArrayList<Cliente> lista;
            LimpiarTabla();
            Object[] fila = new Object[5];
            lista = logica.ListarRegistro(condicion);
            for (Cliente Cliente : lista) {
                fila[0] = Cliente.getIdCliente();
                fila[1] = Cliente.getNombre();
                fila[2] = Cliente.getApellido();// + " " + proveedor.getApellidoProveedor();
                fila[3] = Cliente.getCorreoElectronico();
                fila[4] = Cliente.getTelefono();
                modelo.addRow(fila);
            }

        } catch (Exception e) {
            throw e;
        }
    }

    public void Limpiar() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtCodigo.setText("");
        txtCorreoElectronico.setText("");
        txtTelefono.setText("");
    }

    private Cliente GenerarEntidad() {

        Cliente Cliente = new Cliente();
        if (!txtCodigo.getText().equals("")) {

            Cliente.setExiste(true);
            Cliente.setIdCliente(Integer.parseInt(txtCodigo.getText()));
        }

        Cliente.setNombre(txtNombre.getText());
        Cliente.setApellido(txtApellido.getText());
        Cliente.setCorreoElectronico(txtCorreoElectronico.getText());
        Cliente.setTelefono(Integer.parseInt(txtTelefono.getText()));

        return Cliente;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtNombre = new javax.swing.JTextPane();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtApellido = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtTelefono = new javax.swing.JTextPane();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCodigo = new javax.swing.JTextPane();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtCorreoElectronico = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblClientes);

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

        jScrollPane4.setViewportView(txtNombre);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel1.setText("Codigo");

        jScrollPane5.setViewportView(txtApellido);

        jLabel2.setText("Nombre");

        jLabel3.setText("Correo Electronico");

        jScrollPane6.setViewportView(txtTelefono);

        jLabel4.setText("Telefono");

        jLabel5.setText("Apellido");

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(102, 102, 102));
        txtCodigo.setFocusable(false);
        jScrollPane1.setViewportView(txtCodigo);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(txtCorreoElectronico);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(btnLimpiar)
                                            .addGap(12, 12, 12)
                                            .addComponent(btnGuardar)
                                            .addGap(169, 169, 169))
                                        .addGroup(layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnEliminar)
                                            .addGap(12, 12, 12)
                                            .addComponent(btnSalir)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jScrollPane6)
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(31, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
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
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked

        if (evt.getClickCount() == 2) {
            int fila = tblClientes.rowAtPoint(evt.getPoint());
            txtCodigo.setText(tblClientes.getValueAt(fila, 0).toString());
            txtNombre.setText(tblClientes.getValueAt(fila, 1).toString());
            txtApellido.setText(tblClientes.getValueAt(fila, 2).toString());
            txtCorreoElectronico.setText(tblClientes.getValueAt(fila, 3).toString());
            txtTelefono.setText(tblClientes.getValueAt(fila, 4).toString());

        }
    }//GEN-LAST:event_tblClientesMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        //verificacion que todo este vacio y pueda agregar datos a la BD
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
                                LNCliente logica = new LNCliente();
                                Cliente Cliente = GenerarEntidad();
                                try {
                                    if (Cliente.isExiste()) {
                                        logica.Modificar(Cliente);
                                    } else {
                                        logica.Insertar(Cliente);
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
        LNCliente logica = new LNCliente();
        Cliente Cliente;
        //Si txtcodigo tiene dato significa que lo selecciono y puede eliminarlo
        if (!txtCodigo.getText().equals("")) {
            try {
                Cliente = GenerarEntidad();

                int respuesta = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar el producto?");

                if (respuesta == 0) {
                    if (Cliente.isExiste()) {
                        if (logica.Eliminar(Cliente) > 0) {
                            JOptionPane.showMessageDialog(this, logica.getMensaje());
                            Limpiar();
                            CargarDatos("");
                        } else {
                            JOptionPane.showMessageDialog(this, logica.getMensaje());
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

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

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
            java.util.logging.Logger.getLogger(FrmClienteCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmClienteCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmClienteCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmClienteCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmClienteCRUD dialog = new FrmClienteCRUD(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextPane txtApellido;
    private javax.swing.JTextPane txtCodigo;
    private javax.swing.JTextPane txtCorreoElectronico;
    private javax.swing.JTextPane txtNombre;
    private javax.swing.JTextPane txtTelefono;
    // End of variables declaration//GEN-END:variables
}
