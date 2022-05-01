/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Presentacion;

import Entidades.Compra;
import Entidades.Empleado;
import Entidades.Producto;
import Entidades.Proveedor;
import LogicaNegocio.LNCompra;
import LogicaNegocio.LNEmpleado;
import LogicaNegocio.LNProducto;
import LogicaNegocio.LNProveedor;
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
public class FrmBuscarCompra extends javax.swing.JDialog {
//atributos globales
    DefaultTableModel modelo;
     //variable global en la que guardo la informacion de la tabla
    String[] dato= {};

    
    public FrmBuscarCompra(java.awt.Frame parent, boolean modal) throws Exception {
        super(parent, modal);
        initComponents();
        this.setTitle("Buscar Compra");
        LimpiarTabla();
        setLocationRelativeTo(null); 

        try {
            CargarDatos("");
        } catch (Exception e) {
            throw e;
        }
    }
    
    //colocar informacion nueva a la tabla
    private void LimpiarTabla() {
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tblCompras.setModel(modelo);
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre Producto");
        modelo.addColumn("Marca Producto");
        modelo.addColumn("Nombre Proveedor");
        modelo.addColumn("Nombre Empleado");
        modelo.addColumn("Cantidad Compra");
        modelo.addColumn("Precio Producto");
        modelo.addColumn("Fecha");

    }
//metodo para cargar datos creando nuevas logicas de negocio para obtener mas datos y poder mostrarlo en la tabla
    //se accede a 3 tablas para poder obtener la informacion correcta y obtener esa informacion
    private void CargarDatos(String condicion) throws Exception {

        try {
            LNCompra logica = new LNCompra();
            ArrayList<Compra> lista;
            LimpiarTabla();
            Object[] fila = new Object[8];

            //PRODUCTO
            LNProducto logicaP = new LNProducto();
            ArrayList<Producto> listaP;
            Object[] filaP = new Object[9];

            //PROVEEDOR
            LNProveedor logicaPro = new LNProveedor();
            ArrayList<Proveedor> listaPro;
            Object[] filaPro = new Object[4];

            //EMPLEADO
            LNEmpleado logicaE = new LNEmpleado();
            ArrayList<Empleado> listaE;
            Object[] filaE = new Object[4];

            lista = logica.ListarRegistro(condicion);
            for (Compra Compra : lista) {

                //PROVEEDOR DATOS
                String condicionPro = "ID_Proveedor =" + Compra.getIdVendedor();
                listaPro = logicaPro.ListarRegistro(condicionPro);
                for (Proveedor proveedor : listaPro) {
                    filaPro[0] = proveedor.getIdProveedor();
                    filaPro[1] = proveedor.getMarca();
                    filaPro[2] = proveedor.getNombreProveedor();// + " " + proveedor.getApellidoProveedor();
                    filaPro[3] = proveedor.getTelefono();
                }

                //PRODUCTO DATOS
                String condicionP = "ID_Producto =" + Compra.getIdProducto();
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
                String condicionE = "ID_Empleado =" + Compra.getIdEmpleado();
                listaE = logicaE.ListarRegistro(condicionE);
                for (Empleado Empleado : listaE) {
                    filaE[0] = Empleado.getIdEmpleado();
                    filaE[1] = Empleado.getNombre();// + " " + Empleado.getApellido();
                    filaE[2] = Empleado.getCorreoElectronico();
                    filaE[3] = Empleado.getTelefono();
                }

                //COMPRA DATOS
                fila[0] = Compra.getIdCompra();
                fila[1] = filaP[2];
                fila[2] = filaP[1];
                fila[3] = filaPro[2];
                fila[4] = filaE[1];
                fila[5] = Compra.getCantidadCompra();
                fila[6] = filaP[5];
                fila[7] = Compra.getFechaCompra();

                modelo.addRow(fila);
            }

            //modelo producto
        } catch (Exception e) {
            throw e;
        }
    }

     //Creamos u metodo que devuelve un Arreglo de String para poder cargar la inforamcions de la 
    // tabla y luego poder invocarla en otros formularios, enviandole la fila que seleccionamos
    // despues cada dato lo convertimos en string     
    public String[] Cargar(int fila){
        String[] datos = new String[8];
            //cargamos los datos de la tabla al String
            for (int i = 0; i < datos.length; i++) {
                datos[i] = tblCompras.getValueAt(fila, i).toString();
            }
            
            return datos;
    }
    
    
    public String[] ObtenerDato() {
        return dato;
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        txtNombre = new javax.swing.JTextPane();
        btnBuscar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtCodigo = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCompras = new javax.swing.JTable();

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(btnBuscar))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(8, Short.MAX_VALUE))
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
                    .addComponent(btnBuscar))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCancelar)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        //metodo para hacer la busqeda cada vez que se presione cualquiera tecla
        String condicion = "";
        try {
            if (!txtNombre.getText().equals("")) {
                condicion = "Nombre like '%" + txtNombre.getText() + "%'";

            }
            CargarDatos(condicion);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }//GEN-LAST:event_txtNombreKeyPressed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        //metodo para hacer la busqeda cada vez que se presione el bnoton de buscar
        String condicion = "";
        try {
            if (!txtNombre.getText().equals("")) {
                condicion = "Nombre like '%" + txtNombre.getText() + "%'";

            }
            CargarDatos(condicion);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblComprasMouseClicked

        //doble click en la tabla y carga el dato de otro formulario
        if (evt.getClickCount() == 2) {
            int fila = tblCompras.rowAtPoint(evt.getPoint());
 
            dato=Cargar(fila);

            this.dispose();

        }
    }//GEN-LAST:event_tblComprasMouseClicked

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
            java.util.logging.Logger.getLogger(FrmBuscarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmBuscarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmBuscarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmBuscarCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    FrmBuscarCompra dialog = new FrmBuscarCompra(new javax.swing.JFrame(), true);
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
                        Logger.getLogger(FrmBuscarCompra.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tblCompras;
    private javax.swing.JTextPane txtCodigo;
    private javax.swing.JTextPane txtNombre;
    // End of variables declaration//GEN-END:variables
}
