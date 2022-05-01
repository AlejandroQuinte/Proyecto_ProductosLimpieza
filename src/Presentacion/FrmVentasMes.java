/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Presentacion;

import Entidades.Cliente;
import Entidades.Empleado;
import Entidades.Producto;
import Entidades.Venta;
import Entidades.VentaMesP;
import Entidades.VentasMesE;
import LogicaNegocio.LNCliente;
import LogicaNegocio.LNEmpleado;
import LogicaNegocio.LNProducto;
import LogicaNegocio.LNVenta;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alequ
 */
public class FrmVentasMes extends javax.swing.JDialog {

    DefaultTableModel modelo;
    DefaultTableModel modeloEmpleados;

    String[] MES = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
    DefaultComboBoxModel month = new DefaultComboBoxModel(MES);

    public FrmVentasMes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Ventas Mes");
        setLocationRelativeTo(null);

        try {
            CargarDatosEmpleados("", 1);
            CargarDatosProductos("", 1);
        } catch (Exception e) {
        }
    }

    //METODOS
    //reinicia la tabla
    private void LimpiarTabla() {
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tblVentaEmpleado.setModel(modelo);
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre Producto");
        modelo.addColumn("Marca Producto");
        modelo.addColumn("Cantidad Vendida");
        modelo.addColumn("Nombre Empleado");
        modelo.addColumn("Fecha");

    }

    //cargar los datos a la tabla
    private void CargarDatosEmpleados(String condicion, int fecha) throws Exception {
        try {
            LNVenta logica = new LNVenta();
            ArrayList<VentasMesE> lista;
            LimpiarTabla();
            Object[] fila = new Object[6];
            lista = logica.ListarRegistroEmpleado(condicion, fecha);
            for (VentasMesE VentasMesE : lista) {
                fila[0] = VentasMesE.getIdVenta();
                fila[1] = VentasMesE.getNombre();
                fila[2] = VentasMesE.getMarca();
                fila[3] = VentasMesE.getCantidadVendida();
                fila[4] = VentasMesE.getNombreEmpleado();
                fila[5] = VentasMesE.getFechaVenta();
                modelo.addRow(fila);
            }

        } catch (Exception e) {
            throw e;
        }
    }

    //reinicia la tabla
    private void LimpiarTablaProductos() {
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tblVentaProducto.setModel(modelo);
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre Producto");
        modelo.addColumn("Marca Producto");
        modelo.addColumn("Cantidad Vendida"); 

    }

    //cargar los datos a la tabla
    private void CargarDatosProductos(String condicion, int fecha) throws Exception {
        try {
            LNVenta logica = new LNVenta();
            ArrayList<VentaMesP> lista;
            LimpiarTablaProductos();
            Object[] fila = new Object[4];
            lista = logica.ListarRegistroProducto(condicion, fecha);
            for (VentaMesP VentaMesP : lista) {
                fila[0] = VentaMesP.getIdVenta();
                fila[1] = VentaMesP.getNombre();
                fila[2] = VentaMesP.getMarca();
                fila[3] = VentaMesP.getCantidadVendida();
                modelo.addRow(fila);
            }

        } catch (Exception e) {
            throw e;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblVentaProducto = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblVentaEmpleado = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboMesEmpleado = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        tblVentaProducto.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblVentaProducto);

        tblVentaEmpleado.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tblVentaEmpleado);

        jLabel1.setText("Ventas por mes productos Empleados");

        jLabel2.setText("Orden de mayor a menor");

        jLabel3.setText("Orden de mayor a menor");

        comboMesEmpleado.setModel(month);
        comboMesEmpleado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboMesEmpleadoItemStateChanged(evt);
            }
        });

        jLabel4.setText("Meses");

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        jLabel5.setText("Ventas productos por mes");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(991, 991, 991)
                        .addComponent(btnSalir))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 556, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(218, 218, 218)
                                .addComponent(jLabel3))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 489, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(46, 46, 46))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(comboMesEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(488, 488, 488))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboMesEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnSalir)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboMesEmpleadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboMesEmpleadoItemStateChanged

        int mes = comboMesEmpleado.getSelectedIndex() + 1;
        String condicion = "";
        try {
            CargarDatosEmpleados(condicion, mes);
            CargarDatosProductos(condicion, mes);
        } catch (Exception ex) {
            Logger.getLogger(FrmVentasMes.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_comboMesEmpleadoItemStateChanged

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
            java.util.logging.Logger.getLogger(FrmVentasMes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmVentasMes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmVentasMes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmVentasMes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmVentasMes dialog = new FrmVentasMes(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> comboMesEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblVentaEmpleado;
    private javax.swing.JTable tblVentaProducto;
    // End of variables declaration//GEN-END:variables

}
