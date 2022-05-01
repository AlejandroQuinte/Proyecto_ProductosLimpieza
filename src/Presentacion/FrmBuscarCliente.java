/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Presentacion;

import Entidades.Cliente;
import LogicaNegocio.LNCliente;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alequ
 */
public class FrmBuscarCliente extends javax.swing.JDialog {
//atributos globales
    DefaultTableModel modelo;

    public FrmBuscarCliente(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();

        //colocacion de titulo y lugar donde aparecera
        this.setLocationRelativeTo(null);
        this.setTitle("Buscar Cliente");

        //cargado de datos
        try {
            CargarDatos("");
        } catch (Exception e) {
            throw e;
        }

    }
    //colocar valor principal a la tabla
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
    //cargamos los datos en un arreglo de objetos
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
//obtenemos el id del dato que se coloco en ese textbox para invocar este metodo en en otro formualrio
    public int ObtenerId() {
        int codigo = -1;
        if (!txtCodigo.getText().equals("")) {
            codigo = Integer.parseInt(txtCodigo.getText());
        }
        return codigo;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCodigo = new javax.swing.JTextPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNombre = new javax.swing.JTextPane();
        btnBuscar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblClientes = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Codigo");

        btnAgregar.setText("Agregar Cliente");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre");

        jScrollPane1.setEnabled(false);
        jScrollPane1.setFocusable(false);

        txtCodigo.setEditable(false);
        jScrollPane1.setViewportView(txtCodigo);

        txtNombre.setAutoscrolls(false);
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(txtNombre);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnBuscar)
                                    .addGap(12, 12, 12)
                                    .addComponent(btnAgregar))
                                .addComponent(jLabel2)))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscar)
                        .addComponent(btnAgregar)))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
       //se crea el formulario CRUD para agregar los datos
        FrmClienteCRUD frm = new FrmClienteCRUD(null, true);
        frm.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                try {
                    
                    CargarDatos("");

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        frm.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        //cada vez que se graga un dato de hace la busqueda con los datos del textbox
        String condicion = "";
        try {
            if (!txtNombre.getText().equals("")) {
                condicion = "Nombre like '%" + txtNombre.getText() + "%' or Apellido like '%" + txtNombre.getText() + "%'";

            }
            CargarDatos(condicion);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_txtNombreKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String condicion = "";
        //se presiona el boton de busqeda para hacer la busquda de los datos
        try {
            if (!txtNombre.getText().equals("")) {
                condicion = "Nombre like '%" + txtNombre.getText() + "%' or Apellido like '%" + txtNombre.getText() + "%'";

            }
            CargarDatos(condicion);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        //se coloca los datos de la tabla en los textbox y se cierra el formulario
        if (evt.getClickCount() == 2) {
            int fila = tblClientes.rowAtPoint(evt.getPoint());
            txtCodigo.setText(tblClientes.getValueAt(fila, 0).toString());
            txtNombre.setText(tblClientes.getValueAt(fila, 1).toString());

            this.dispose();
        }
    }//GEN-LAST:event_tblClientesMouseClicked

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
            java.util.logging.Logger.getLogger(FrmBuscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBuscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBuscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBuscarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmBuscarCliente dialog = new FrmBuscarCliente(new javax.swing.JFrame(), true);
                    dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                        @Override
                        public void windowClosing(java.awt.event.WindowEvent e) {
                            System.exit(0);
                        }
                    });
                    dialog.setVisible(true);
                } catch (Exception e) {
                    try {
                        throw e;
                    } catch (Exception ex) {
                        Logger.getLogger(FrmBuscarCliente.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblClientes;
    private javax.swing.JTextPane txtCodigo;
    private javax.swing.JTextPane txtNombre;
    // End of variables declaration//GEN-END:variables
}
