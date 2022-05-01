/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Presentacion;

import Entidades.Proveedor;
import LogicaNegocio.LNProveedor;
import com.microsoft.sqlserver.jdbc.StringUtils;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alequ
 */
public class FrmProveedorCRUD extends javax.swing.JDialog {

    DefaultTableModel modelo;

    public FrmProveedorCRUD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.setTitle("Proveedor");

        setLocationRelativeTo(null);

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
        tblProveedor = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtApellido = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtTelefono = new javax.swing.JTextPane();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCodigo = new javax.swing.JTextPane();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtNombre = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMarca = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblProveedor.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProveedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProveedorMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblProveedor);

        jLabel2.setText("Nombre");

        jLabel4.setText("Telefono");

        jScrollPane5.setViewportView(txtApellido);

        jLabel5.setText("Apellido");

        jScrollPane6.setViewportView(txtTelefono);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        txtCodigo.setEditable(false);
        txtCodigo.setBackground(new java.awt.Color(102, 102, 102));
        txtCodigo.setFocusable(false);
        jScrollPane1.setViewportView(txtCodigo);

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

        jScrollPane4.setViewportView(txtNombre);

        jLabel1.setText("Codigo");

        jLabel3.setText("Marca");

        jScrollPane2.setViewportView(txtMarca);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnLimpiar)
                                .addGap(12, 12, 12)
                                .addComponent(btnGuardar)
                                .addGap(169, 169, 169))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnEliminar)
                                .addGap(12, 12, 12)
                                .addComponent(btnSalir))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(39, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(39, Short.MAX_VALUE)
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
                    .addComponent(jLabel4)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //reiniciar tabla
    private void LimpiarTabla() {
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tblProveedor.setModel(modelo);
        modelo.addColumn("Codigo");
        modelo.addColumn("Marca");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Telefono");

    }
//cargar datos a la tabla
    private void CargarDatos(String condicion) throws Exception {
        try {
            LNProveedor logica = new LNProveedor();
            ArrayList<Proveedor> lista;
            LimpiarTabla();
            Object[] fila = new Object[6];
            lista = logica.ListarRegistro(condicion);
            for (Proveedor proveedor : lista) {
                fila[0] = proveedor.getIdProveedor();
                fila[1] = proveedor.getMarca();
                fila[2] = proveedor.getNombreProveedor();
                fila[3] = proveedor.getApellidoProveedor();
                fila[4] = proveedor.getTelefono();
                modelo.addRow(fila);
            }

        } catch (Exception e) {
            throw e;
        }
    }
//limpiar datos de los textbox
    public void Limpiar() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtTelefono.setText("");
        txtMarca.setText("");
    }

    //crear entidad proveedor
    private Proveedor GenerarEntidad() {

        Proveedor Proveedor = new Proveedor();
        if (!txtCodigo.getText().equals("")) {

            Proveedor.setExiste(true);
            Proveedor.setIdProveedor(Integer.parseInt(txtCodigo.getText()));
        }

        Proveedor.setNombreProveedor(txtNombre.getText());
        Proveedor.setMarca(txtMarca.getText());
        Proveedor.setApellidoProveedor(txtApellido.getText());
        Proveedor.setTelefono(Integer.parseInt(txtTelefono.getText()));

        return Proveedor;
    }


    private void tblProveedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProveedorMouseClicked

        //si da doble click a un dato lo cargara a los textbox
        if (evt.getClickCount() == 2) {
            int fila = tblProveedor.rowAtPoint(evt.getPoint());
            txtCodigo.setText(tblProveedor.getValueAt(fila, 0).toString());
            txtMarca.setText(tblProveedor.getValueAt(fila, 2).toString());
            txtNombre.setText(tblProveedor.getValueAt(fila, 1).toString());
            txtApellido.setText(tblProveedor.getValueAt(fila, 3).toString());
            txtTelefono.setText(tblProveedor.getValueAt(fila, 4).toString());

        }
    }//GEN-LAST:event_tblProveedorMouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        ///revisa que esten lllenos para poder ahcer el guardado y que sean numerales
        boolean vacio = false;
        if (txtNombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los espacios en blanco");
            vacio = true;
        } else {
            if (txtApellido.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los espacios en blanco");
                vacio = true;
            } else {
                if (txtMarca.getText().equals("")) {
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

                            if (!txtNombre.getText().equals("") && !txtApellido.getText().equals("") && !txtMarca.getText().equals("") && !txtTelefono.getText().equals("")) {
                                LNProveedor logica = new LNProveedor();
                                Proveedor Proveedor = GenerarEntidad();
                                try {
                                    if (Proveedor.isExiste()) {
                                        logica.Modificar(Proveedor);
                                    } else {
                                        logica.Insertar(Proveedor);
                                    }

                                    JOptionPane.showMessageDialog(this, logica.getMensaje());
                                    Limpiar();

                                    CargarDatos("");
                                } catch (Exception e) {
                                    JOptionPane.showMessageDialog(this, e.getMessage() + "asdasd");
                                }
                            }

                        }

                    }
                }
            }

        }
 
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        LNProveedor logica = new LNProveedor();
        Proveedor Proveedor;

        //si se sleecciono un dato lo puede eliminar se sabe que lo selecciono si txtCodigo esta con datos
        if (!txtCodigo.getText().equals("")) {
            try {
                Proveedor = GenerarEntidad();

                int respuesta = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar el producto?");

                if (respuesta == 0) {
                    if (Proveedor.isExiste()) {
                        if (logica.Eliminar(Proveedor) > 0) {
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
            java.util.logging.Logger.getLogger(FrmProveedorCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProveedorCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProveedorCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProveedorCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmProveedorCRUD dialog = new FrmProveedorCRUD(new javax.swing.JFrame(), true);
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
    private javax.swing.JTable tblProveedor;
    private javax.swing.JTextPane txtApellido;
    private javax.swing.JTextPane txtCodigo;
    private javax.swing.JTextPane txtMarca;
    private javax.swing.JTextPane txtNombre;
    private javax.swing.JTextPane txtTelefono;
    // End of variables declaration//GEN-END:variables
}
