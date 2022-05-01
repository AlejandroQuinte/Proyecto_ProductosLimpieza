/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Presentacion;

import Entidades.Producto;
import LogicaNegocio.LNProducto;
import com.microsoft.sqlserver.jdbc.StringUtils;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alequ
 */
public class FrmProductoCRUD extends javax.swing.JDialog {

    //atributos globalres
    DefaultTableModel modelo;
    
    //creacion de datos que se agregaran a los combo box
    String[] medida = {"GRAMOS","KILOGRAMOS", "LITROS","MILILITROS"};
    DefaultComboBoxModel modeloMedida = new DefaultComboBoxModel(medida); 
    String[] moneda = {"COLONES", "DOLARES"};
    DefaultComboBoxModel modeloMoneda = new DefaultComboBoxModel(moneda);

    
    public FrmProductoCRUD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        setLocationRelativeTo(null);
        this.setTitle("Producto");

        ComboMedida.setSelectedItem(ABORT);

        try {
            CargarDatos("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }
//reinicio de la tabla
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
//cargar los datos hacia la tablas
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
                fila[5] = (int) Producto.getPrecioCompra();
                fila[6] = (int) Producto.getPrecioVenta();
                fila[7] = Producto.getTipoMoneda();
                fila[8] = Producto.getCantidadProducto();
                modelo.addRow(fila);
            }

        } catch (Exception e) {
            throw e;
        }
    }
//limpia los textbox
    public void Limpiar() {
        txtMarca.setText("");
        txtNombre.setText("");
        txtCantidadMedida.setText("");
        txtPrecioCompra.setText("");
        txtPrecioVenta.setText("");
        txtCantidadProducto.setText("");
        txtCodigo.setText("");
        ComboMedida.setSelectedIndex(0);
        ComboMoneda.setSelectedIndex(0);
        txtCantidadProducto.setEditable(false);
    }
//genera el producto mediante los datos en los textbox
    private Producto GenerarEntidad() {

        Producto Producto = new Producto();
        if (!txtCodigo.getText().equals("")) {

            Producto.setExiste(true);
            Producto.setIdProducto(Integer.parseInt(txtCodigo.getText()));
        }

        Producto.setMarca(txtMarca.getText());
        Producto.setNombre(txtNombre.getText());
        Producto.setCantidadMedida(Integer.parseInt(txtCantidadMedida.getText()));
        Producto.setTipoMedida((String) ComboMedida.getSelectedItem());
        Producto.setPrecioCompra(Integer.parseInt(txtPrecioCompra.getText()));
        Producto.setPrecioVenta(Integer.parseInt(txtPrecioVenta.getText()));
        Producto.setTipoMoneda((String) ComboMoneda.getSelectedItem());
        Producto.setCantidadProducto(Integer.parseInt(txtCantidadProducto.getText()));

        return Producto;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblProductos2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMarca = new javax.swing.JTextPane();
        txtNombreScroll = new javax.swing.JScrollPane();
        txtNombre = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtCantidadMedida = new javax.swing.JTextPane();
        ComboMedida = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtPrecioVenta = new javax.swing.JTextPane();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtPrecioCompra = new javax.swing.JTextPane();
        ComboMoneda = new javax.swing.JComboBox<>();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtCantidadProducto = new javax.swing.JTextPane();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCodigo = new javax.swing.JTextPane();
        btnLimpiar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

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

        jLabel1.setText("Marca");

        jLabel2.setText("Cantidad de Medida");

        jLabel3.setText("Precio Compra");

        jLabel4.setText("Nombre");

        jLabel5.setText("Tipo de medida");

        jLabel6.setText("Precio Venta");

        jLabel7.setText("Tipo de Moneda");

        jLabel8.setText("Cantidad de Producto");

        jScrollPane2.setViewportView(txtMarca);

        txtNombreScroll.setViewportView(txtNombre);

        jScrollPane4.setViewportView(txtCantidadMedida);

        ComboMedida.setModel(modeloMedida);
        ComboMedida.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ComboMedidaItemStateChanged(evt);
            }
        });

        jScrollPane6.setViewportView(txtPrecioVenta);

        jScrollPane7.setViewportView(txtPrecioCompra);

        ComboMoneda.setModel(modeloMoneda);

        txtCantidadProducto.setEditable(false);
        txtCantidadProducto.setText("0");
        jScrollPane8.setViewportView(txtCantidadProducto);

        jLabel9.setText("Codigo");

        txtCodigo.setEditable(false);
        txtCodigo.setFocusable(false);
        jScrollPane1.setViewportView(txtCodigo);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 698, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnLimpiar)
                            .addGap(12, 12, 12)
                            .addComponent(btnGuardar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btnEliminar)
                            .addGap(12, 12, 12)
                            .addComponent(btnSalir))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane1)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(50, 50, 50)
                                            .addComponent(jLabel1)
                                            .addGap(101, 101, 101))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(49, 49, 49)
                                            .addComponent(jScrollPane2)
                                            .addGap(18, 18, 18)))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtNombreScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(58, 58, 58)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(ComboMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(62, 62, 62)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(ComboMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7))))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel3)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNombreScroll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel5)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(jLabel7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboMoneda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnGuardar)
                    .addComponent(btnEliminar)
                    .addComponent(btnSalir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblProductos2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductos2MouseClicked
        if (evt.getClickCount() == 2) {
            //si se selecciona un doble click en algun dato de la tabla se coloca la informacion de la tabla en los textbox
            int fila = tblProductos2.rowAtPoint(evt.getPoint());
            txtCodigo.setText(tblProductos2.getValueAt(fila, 0).toString());
            txtMarca.setText(tblProductos2.getValueAt(fila, 1).toString());
            txtNombre.setText(tblProductos2.getValueAt(fila, 2).toString());
            txtCantidadMedida.setText(tblProductos2.getValueAt(fila, 3).toString());

            ComboMedida.setSelectedItem(tblProductos2.getValueAt(fila, 4).toString());

            txtPrecioCompra.setText(tblProductos2.getValueAt(fila, 5).toString());
            txtPrecioVenta.setText(tblProductos2.getValueAt(fila, 6).toString());

            ComboMoneda.setSelectedItem(tblProductos2.getValueAt(fila, 7).toString());

            txtCantidadProducto.setText(tblProductos2.getValueAt(fila, 8).toString());

            txtCantidadProducto.setEditable(true);

        }
    }//GEN-LAST:event_tblProductos2MouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        txtCantidadProducto.setEditable(false);
        //se revisa que todos los datos esten llenos y revisa que sean numerales
        boolean vacio = false;
        if (txtMarca.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los espacios en blanco");
            vacio = true;
        } else {
            if (txtPrecioVenta.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los espacios en blanco");
                vacio = true;
            } else {
                if (txtPrecioCompra.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Debe llenar todos los espacios en blanco");
                    vacio = true;
                } else {
                    if (txtCantidadMedida.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Debe llenar todos los espacios en blanco");
                        vacio = true;
                    } else {
                        if (txtNombre.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Debe llenar todos los espacios en blanco");
                            vacio = true;
                        } else {
                            if (txtCantidadProducto.getText().equals("")) {
                                JOptionPane.showMessageDialog(null, "Debe llenar todos los espacios en blanco");
                                vacio = true;
                            } else {

                                if (!StringUtils.isNumeric(txtPrecioCompra.getText()) || !StringUtils.isNumeric(txtPrecioVenta.getText()) || !StringUtils.isNumeric(txtCantidadMedida.getText()) || !StringUtils.isNumeric(txtCantidadProducto.getText())) {
                                    JOptionPane.showMessageDialog(null, "CantidadProducto, PrecioCompra, PrecioVenta, CantidadMedida debe llenarlo con numeros");

                                } else {

                                    if (!txtPrecioCompra.getText().equals("") && !txtPrecioVenta.getText().equals("") && !txtCantidadMedida.getText().equals("") && !txtCantidadProducto.getText().equals("") && !txtMarca.getText().equals("") && !txtNombre.getText().equals("")) {
                                        LNProducto logica = new LNProducto();
                                        Producto Producto = GenerarEntidad();
                                        try {
                                            if (Producto.isExiste()) {
                                                logica.Modificar(Producto);
                                            } else {
                                                logica.Insertar(Producto);
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
            }
        }
 
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        LNProducto logica = new LNProducto();
        Producto Producto;

        //se revisa que un dato se selecciono revisando que el txtCodigo no este vacio si esta vacio no se selecciono nada y  no se puede eliminar
        if (!txtCodigo.getText().equals("")) {
            try {
                Producto = GenerarEntidad();

                int respuesta = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar el producto?");

                if (respuesta == 0) {
                    if (Producto.isExiste()) {
                        if (logica.Eliminar(Producto) > 0) {
                            JOptionPane.showMessageDialog(this, logica.getMensaje());
                            Limpiar();
                            CargarDatos("");
                        } else {
                            JOptionPane.showMessageDialog(this, logica.getMensaje()); 
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Debe seleccionar al Producto");
                    }
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(this, "Seleccione el dato que desea eliminar dando doble click en la tabla");
        }
 

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void ComboMedidaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ComboMedidaItemStateChanged
        if (evt.getItemSelectable() == ComboMedida) {
            

        }

    }//GEN-LAST:event_ComboMedidaItemStateChanged

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
            java.util.logging.Logger.getLogger(FrmProductoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmProductoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmProductoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmProductoCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmProductoCRUD dialog = new FrmProductoCRUD(new javax.swing.JFrame(), true);
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
    private javax.swing.JComboBox<String> ComboMedida;
    private javax.swing.JComboBox<String> ComboMoneda;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTable tblProductos2;
    private javax.swing.JTextPane txtCantidadMedida;
    private javax.swing.JTextPane txtCantidadProducto;
    private javax.swing.JTextPane txtCodigo;
    private javax.swing.JTextPane txtMarca;
    private javax.swing.JTextPane txtNombre;
    private javax.swing.JScrollPane txtNombreScroll;
    private javax.swing.JTextPane txtPrecioCompra;
    private javax.swing.JTextPane txtPrecioVenta;
    // End of variables declaration//GEN-END:variables
}
