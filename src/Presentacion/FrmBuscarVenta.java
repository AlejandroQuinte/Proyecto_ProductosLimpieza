/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Presentacion;

import Entidades.Cliente;
import Entidades.Empleado;
import Entidades.Producto;
import Entidades.Venta;
import LogicaNegocio.LNCliente;
import LogicaNegocio.LNEmpleado;
import LogicaNegocio.LNProducto;
import LogicaNegocio.LNVenta;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alequ
 */
public class FrmBuscarVenta extends javax.swing.JDialog {

    DefaultTableModel modelo;
    //variable global en la que guardo la informacion de la tabla
    String[] dato = {};

    public FrmBuscarVenta(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        this.setTitle("Buscar Ventas");
        setLocationRelativeTo(null);

        try {
            CargarDatos("");
        } catch (Exception e) {
            throw e;
        }

    }

    //METODOS
    //reiniciar tabla
    private void LimpiarTabla() {
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tblVentas.setModel(modelo);
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre Producto");
        modelo.addColumn("Marca Producto");
        modelo.addColumn("Nombre Cliente");
        modelo.addColumn("Nombre Empleado");
        modelo.addColumn("Cantidad Venta");
        modelo.addColumn("Precio Producto");
        modelo.addColumn("Fecha");

    }
//cargar los datos a la tabla
    private void CargarDatos(String condicion) throws Exception {

        try {
            //Venta
            LNVenta logica = new LNVenta();
            ArrayList<Venta> lista;
            LimpiarTabla();
            Object[] fila = new Object[8];

            //PRODUCTO
            LNProducto logicaP = new LNProducto();
            ArrayList<Producto> listaP;
            Object[] filaP = new Object[9];

            //CLIENTE
            LNCliente logicaClientes = new LNCliente();
            ArrayList<Cliente> listaClient;
            Object[] filaClientes = new Object[5];

            //EMPLEADO
            LNEmpleado logicaE = new LNEmpleado();
            ArrayList<Empleado> listaE;
            Object[] filaE = new Object[4];

            lista = logica.ListarRegistro(condicion);
            for (Venta Venta : lista) {

                //CLIENTE DATOS
                String condicionClient = "ID_Cliente =" + Venta.getIdCliente();
                listaClient = logicaClientes.ListarRegistro(condicionClient);
                for (Cliente Cliente : listaClient) {
                    filaClientes[0] = Cliente.getIdCliente();
                    filaClientes[1] = Cliente.getNombre();
                    filaClientes[2] = Cliente.getApellido();// + " " + proveedor.getApellidoProveedor();
                    filaClientes[3] = Cliente.getCorreoElectronico();
                    filaClientes[4] = Cliente.getTelefono();
                }

                //PRODUCTO DATOS
                String condicionP = "ID_Producto =" + Venta.getIdProducto();
                listaP = logicaP.ListarRegistro(condicionP);
                if (!listaP.isEmpty()) {
                    for (Producto Producto : listaP) {
                        filaP[0] = Producto.getIdProducto();
                        filaP[1] = Producto.getMarca();
                        filaP[2] = Producto.getNombre();
                        filaP[3] = Producto.getCantidadMedida();
                        filaP[4] = Producto.getTipoMedida();
                        filaP[5] = Producto.getPrecioCompra();
                        filaP[6] = Producto.getPrecioVenta();
                        filaP[7] = Producto.getTipoMoneda();
                        filaP[8] = Producto.getCantidadProducto();
                    }
                } else {
                    filaP[1] = "Borrado";
                    filaP[2] = "Borrado";
                }

                //
                String condicionE = "ID_Empleado =" + Venta.getIdEmpleado();
                listaE = logicaE.ListarRegistro(condicionE);
                for (Empleado Empleado : listaE) {
                    filaE[0] = Empleado.getIdEmpleado();
                    filaE[1] = Empleado.getNombre();// + " " + Empleado.getApellido();
                    filaE[2] = Empleado.getCorreoElectronico();
                    filaE[3] = Empleado.getTelefono();
                }

                //COMPRA DATOS
                fila[0] = Venta.getIdVenta();
                fila[1] = filaP[2];
                fila[2] = filaP[1];
                fila[3] = filaClientes[1];
                fila[4] = filaE[1];
                fila[5] = Venta.getCantidadVentidad();
                fila[6] = filaP[6];
                fila[7] = Venta.getFechaVenta();

                modelo.addRow(fila);
            }

            //modelo producto
        } catch (Exception e) {
            throw e;
        }
    }

    public String[] Cargar(int fila) {
        String[] datos = new String[8];
        //cargamos los datos de la tabla al String
        for (int i = 0; i < datos.length; i++) {
            datos[i] = tblVentas.getValueAt(fila, i).toString();
        }

        return datos;
    }

    public String[] ObtenerDato() {
        return dato;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtCodigo = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCompras = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNombre = new javax.swing.JTextPane();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtNombre1 = new javax.swing.JTextPane();
        btnBuscar1 = new javax.swing.JButton();
        btnCancelar1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtCodigo1 = new javax.swing.JTextPane();

        jScrollPane1.setEnabled(false);
        jScrollPane1.setFocusable(false);

        txtCodigo.setEditable(false);
        jScrollPane1.setViewportView(txtCodigo);

        tblCompras.setModel(new javax.swing.table.DefaultTableModel(
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
        tblCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblComprasMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblCompras);

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

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("Codigo");

        jLabel2.setText("Nombre");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
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
        tblVentas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblVentasMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblVentas);

        txtNombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombre1KeyPressed(evt);
            }
        });
        jScrollPane5.setViewportView(txtNombre1);

        btnBuscar1.setText("Buscar");
        btnBuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscar1ActionPerformed(evt);
            }
        });

        btnCancelar1.setText("Cancelar");
        btnCancelar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelar1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Codigo");

        jLabel4.setText("Nombre");

        jScrollPane6.setEnabled(false);
        jScrollPane6.setFocusable(false);

        txtCodigo1.setEditable(false);
        jScrollPane6.setViewportView(txtCodigo1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCancelar1)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(22, 22, 22)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(46, 46, 46)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(30, 30, 30)
                                    .addComponent(btnBuscar1))))
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar1))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar1)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblComprasMouseClicked

        if (evt.getClickCount() == 2) {
            int fila = tblVentas.rowAtPoint(evt.getPoint());

            dato = Cargar(fila);

            this.dispose();

        }
    }//GEN-LAST:event_tblComprasMouseClicked

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed


    }//GEN-LAST:event_txtNombreKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblVentasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblVentasMouseClicked

        if (evt.getClickCount() == 2) {
            int fila = tblVentas.rowAtPoint(evt.getPoint());

            dato = Cargar(fila);

            this.dispose();

        }
    }//GEN-LAST:event_tblVentasMouseClicked

    private void txtNombre1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombre1KeyPressed

        String condicion = "";
        try {
            if (!txtNombre1.getText().equals("")) {
                condicion = "Nombre like '%" + txtNombre1.getText() + "%'";

            }
            CargarDatos(condicion);
        } catch (Exception e) {
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(FrmBuscarVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_txtNombre1KeyPressed

    private void btnBuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscar1ActionPerformed
        String condicion = "";
        try {
            if (!txtNombre1.getText().equals("")) {
                condicion = "Nombre like '%" + txtNombre1.getText() + "%'";

            }
            CargarDatos(condicion);
        } catch (Exception e) {
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(FrmBuscarVenta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnBuscar1ActionPerformed

    private void btnCancelar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelar1ActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelar1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmBuscarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBuscarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBuscarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBuscarVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmBuscarVenta dialog = new FrmBuscarVenta(new javax.swing.JFrame(), true);
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
                        Logger.getLogger(FrmBuscarVenta.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnBuscar1;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCancelar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTable tblCompras;
    private javax.swing.JTable tblVentas;
    private javax.swing.JTextPane txtCodigo;
    private javax.swing.JTextPane txtCodigo1;
    private javax.swing.JTextPane txtNombre;
    private javax.swing.JTextPane txtNombre1;
    // End of variables declaration//GEN-END:variables
}
