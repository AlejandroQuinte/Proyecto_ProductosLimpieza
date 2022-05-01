package Presentacion;

import Entidades.Producto;
import LogicaNegocio.LNProducto;
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
public class FrmBuscarProducto extends javax.swing.JDialog {

    DefaultTableModel modelo;

    public FrmBuscarProducto(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.setTitle("Buscar Producto");

        try {
            CargarDatos("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
//reiniciar tabla
    private void LimpiarTabla() {
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tblProductos2.setModel(modelo);
        modelo.addColumn("Codigo");
        modelo.addColumn("Marca");
        modelo.addColumn("Nombre");
        modelo.addColumn("CantidadMedida");
        modelo.addColumn("TipoMedida");
        modelo.addColumn("PrecioCompra");
        modelo.addColumn("PrecioVenta");
        modelo.addColumn("TipoMoneda");
        modelo.addColumn("CantidadProducto");

    }
//cargar los datos a la tabla
    private void CargarDatos(String condicion) throws Exception {
        try {
            LNProducto logica = new LNProducto();
            ArrayList<Producto> lista;
            LimpiarTabla();
            Object[] fila = new Object[9];
            lista = logica.ListarRegistro(condicion);
            for (Producto Producto : lista) {
                fila[0] = Producto.getIdProducto();
                fila[1] = Producto.getMarca();
                fila[2] = Producto.getNombre();
                fila[3] = Producto.getCantidadMedida();
                fila[4] = Producto.getTipoMedida();
                fila[5] = Producto.getPrecioCompra();
                fila[6] = Producto.getPrecioVenta();
                fila[7] = Producto.getTipoMoneda();
                fila[8] = Producto.getCantidadProducto();
                modelo.addRow(fila);
            }

        } catch (Exception e) {
            throw e;
        }
    }

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

        jScrollPane2 = new javax.swing.JScrollPane();
        txtNombre = new javax.swing.JTextPane();
        btnBuscar = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblProductos2 = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCodigo = new javax.swing.JTextPane();
        btnAgregarProducto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

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

        tblProductos2.setModel(new javax.swing.table.DefaultTableModel(
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
        tblProductos2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductos2MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tblProductos2);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Codigo");

        jLabel2.setText("Nombre");

        jScrollPane1.setEnabled(false);
        jScrollPane1.setFocusable(false);

        txtCodigo.setEditable(false);
        jScrollPane1.setViewportView(txtCodigo);

        btnAgregarProducto.setText("Agregar Producto");
        btnAgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarProductoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnBuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAgregarProducto))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 19, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnCancelar)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnBuscar)
                        .addComponent(btnAgregarProducto)))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCancelar)
                .addContainerGap(59, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String condicion = "";
        try {
            if (!txtNombre.getText().equals("")) {
                condicion = "Nombre like '%" + txtNombre.getText() + "%' or Marca like '%" + txtNombre.getText() + "%'";

            }
            CargarDatos(condicion);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void tblProductos2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductos2MouseClicked

        if (evt.getClickCount() == 2) {
            int fila = tblProductos2.rowAtPoint(evt.getPoint());
            txtCodigo.setText(tblProductos2.getValueAt(fila, 0).toString());
            txtNombre.setText(tblProductos2.getValueAt(fila, 1).toString());

            this.dispose();
        }
    }//GEN-LAST:event_tblProductos2MouseClicked

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarProductoActionPerformed
        FrmProductoCRUD frm = new FrmProductoCRUD(null, true);
       frm.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                try {
                    
                    CargarDatos("");
                     
                } catch (Exception ex) {
                    try {
                        throw ex;
                    } catch (Exception ex1) {
                        Logger.getLogger(FrmBuscarProducto.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
            }
        });
        
        
        frm.setVisible(true);
    }//GEN-LAST:event_btnAgregarProductoActionPerformed

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
      
        String condicion = "";
        try {
            if (!txtNombre.getText().equals("")) {
                condicion = "Nombre like '%" + txtNombre.getText() + "%' or Marca like '%" + txtNombre.getText() + "%'";

            }
            CargarDatos(condicion);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
        
    }//GEN-LAST:event_txtNombreKeyPressed

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
            java.util.logging.Logger.getLogger(FrmBuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBuscarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                FrmBuscarProducto dialog = new FrmBuscarProducto(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTable tblProductos1;
    private javax.swing.JTable tblProductos2;
    private javax.swing.JTextPane txtCodigo;
    private javax.swing.JTextPane txtNombre;
    // End of variables declaration//GEN-END:variables
}
