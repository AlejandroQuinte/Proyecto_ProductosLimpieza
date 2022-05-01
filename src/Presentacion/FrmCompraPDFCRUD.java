/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package Presentacion;

import Entidades.DatosPlanilla;
import Entidades.Producto;
import LogicaNegocio.LNPlantilla;
import LogicaNegocio.LNProducto;
import java.awt.Desktop;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alequ
 */
public class FrmCompraPDFCRUD extends javax.swing.JDialog {

    //atributos globales
    DefaultTableModel modelo;
    String fecha;
    ArrayList<DatosPlanilla> lista = new ArrayList();
    String nombreArchivo = "";
    boolean seleccionado = false;
    int fila = -1;

    public FrmCompraPDFCRUD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        this.setTitle("Facturacion Compra");
        try {
            LimpiarTabla();
        } catch (Exception e) {
            throw e;
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

        tblCompras.setModel(modelo);
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre Producto");
        modelo.addColumn("Marca Producto");
        modelo.addColumn("Nombre Proveedor");
        modelo.addColumn("Nombre Empleado");
        modelo.addColumn("Cantidad Venta");
        modelo.addColumn("Precio Producto");
        modelo.addColumn("Fecha");

    }
//metood para limipiar todos los textbox
    private void Limpiar() {
        txtNombreProducto.setText("");
        txtNombreEmpleado.setText("");
        txtPrecio.setText("");
        txtMarca.setText("");
        txtNombreProveedor.setText("");
        txtCantidad.setText("");
        txtCodigo.setText("");
    }

    
//Cargar los datos a la tabla
    private void CargarDatos() {
 
        DatosPlanilla datosCarga;
        
        if (!txtCodigo.getText().equals("")) {
            datosCarga = new DatosPlanilla();
            datosCarga.setCodigo(Integer.parseInt(txtCodigo.getText()));
            datosCarga.setNombreProducto(txtNombreProducto.getText());
            datosCarga.setMarcaProducto(txtMarca.getText());
            datosCarga.setNombreProveedor(txtNombreProveedor.getText());
            datosCarga.setNombreEmpleado(txtNombreEmpleado.getText());
            datosCarga.setCantidadCompra(Integer.parseInt(txtCantidad.getText()));
            datosCarga.setPrecioProducto(Float.parseFloat(txtPrecio.getText()));
            datosCarga.setFechaCompra(fecha);
            lista.add(datosCarga);
        } 
        
        Object[] filaObj = new Object[8];
        LimpiarTabla();
        for (DatosPlanilla datos : lista) {

            filaObj[0] = datos.getCodigo();
            filaObj[1] = datos.getNombreProducto();
            filaObj[2] = datos.getMarcaProducto();
            filaObj[3] = datos.getNombreProveedor();
            filaObj[4] = datos.getNombreEmpleado();
            filaObj[5] = datos.getCantidadCompra();
            filaObj[6] = datos.getPrecioProducto();
            filaObj[7] = datos.getFechaCompra();

            modelo.addRow(filaObj);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNombreProducto = new javax.swing.JTextPane();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtPrecio = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtNombreEmpleado = new javax.swing.JTextPane();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtCantidad = new javax.swing.JTextPane();
        txtCodigo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtNombreProveedor = new javax.swing.JTextPane();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtMarca = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCompras = new javax.swing.JTable();
        btnSelectProducto = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        btnGenerarPDF = new javax.swing.JButton();
        btnAbrirPDF = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nombre del Producto");

        txtNombreProducto.setEditable(false);
        txtNombreProducto.setBackground(new java.awt.Color(102, 102, 102));
        txtNombreProducto.setForeground(new java.awt.Color(102, 102, 102));
        txtNombreProducto.setCaretColor(new java.awt.Color(102, 102, 102));
        txtNombreProducto.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        txtNombreProducto.setFocusable(false);
        txtNombreProducto.setSelectedTextColor(new java.awt.Color(102, 102, 102));
        jScrollPane2.setViewportView(txtNombreProducto);

        jLabel8.setText("Precio Compra");

        txtPrecio.setEditable(false);
        txtPrecio.setFocusable(false);
        jScrollPane7.setViewportView(txtPrecio);

        txtNombreEmpleado.setEditable(false);
        txtNombreEmpleado.setBackground(new java.awt.Color(102, 102, 102));
        txtNombreEmpleado.setForeground(new java.awt.Color(102, 102, 102));
        txtNombreEmpleado.setFocusable(false);
        jScrollPane4.setViewportView(txtNombreEmpleado);

        jLabel5.setText("Nombre del Empleado");

        jScrollPane5.setViewportView(txtCantidad);

        txtCodigo.setEditable(false);
        txtCodigo.setText(" ");
        txtCodigo.setAutoscrolls(false);
        txtCodigo.setEnabled(false);
        txtCodigo.setFocusable(false);

        jLabel9.setText("Codigo");

        jLabel7.setText("Cantidad de Productos");

        txtNombreProveedor.setEditable(false);
        txtNombreProveedor.setBackground(new java.awt.Color(102, 102, 102));
        txtNombreProveedor.setForeground(new java.awt.Color(102, 102, 102));
        txtNombreProveedor.setFocusable(false);
        jScrollPane3.setViewportView(txtNombreProveedor);

        jLabel2.setText("Nombre del Proveedor");

        txtMarca.setEditable(false);
        txtMarca.setBackground(new java.awt.Color(102, 102, 102));
        txtMarca.setForeground(new java.awt.Color(102, 102, 102));
        txtMarca.setFocusable(false);
        txtMarca.setSelectedTextColor(new java.awt.Color(102, 102, 102));
        jScrollPane6.setViewportView(txtMarca);

        jLabel6.setText("Marca del Proveedor");

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
        jScrollPane1.setViewportView(tblCompras);

        btnSelectProducto.setText("Seleccionar otra Compra");
        btnSelectProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectProductoActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar Factura");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar a la tabla");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnGenerarPDF.setText("Generar Factura");
        btnGenerarPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarPDFActionPerformed(evt);
            }
        });

        btnAbrirPDF.setText("Abrir Factura");
        btnAbrirPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirPDFActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar)
                        .addGap(18, 18, 18)
                        .addComponent(btnSelectProducto))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel1)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))))
                            .addComponent(jLabel8)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane4)
                                .addComponent(jLabel5)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(48, 48, 48))
                            .addComponent(jLabel7)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(76, 76, 76))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAbrirPDF)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar)
                        .addGap(18, 18, 18)
                        .addComponent(btnGenerarPDF, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(btnCancelar))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSelectProducto)
                    .addComponent(btnAgregar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnEliminar)
                    .addComponent(btnGenerarPDF)
                    .addComponent(btnAbrirPDF))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblComprasMouseClicked

        if (evt.getClickCount() == 1) {
            fila = tblCompras.rowAtPoint(evt.getPoint());
            seleccionado = true;
        }
    }//GEN-LAST:event_tblComprasMouseClicked

    private void btnSelectProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectProductoActionPerformed
        FrmBuscarCompra frmBuscar;
        try {
            frmBuscar = new FrmBuscarCompra(null, true);

            frmBuscar.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    try {
                        String[] datos = frmBuscar.ObtenerDato();

                        if (datos.length != 0) {
                            CargarDatos(datos);
                        }

                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            });
            frmBuscar.setVisible(true);

        } catch (Exception ex) {
            Logger.getLogger(FrmCompraPDFCRUD.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnSelectProductoActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        CargarDatos();
        Limpiar();
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnGenerarPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarPDFActionPerformed
        //crea una fecha para evnairala crea el arreglo de datos planilla, los obtiene y los guarda y tambien crea el nombre del archivo
        try {
            DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String fechaPDF = dtf2.format(LocalDateTime.now());

            ArrayList<DatosPlanilla> datosTabla = lista;

            if (datosTabla.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Primero agregue datos a la tabla para poder crearlo");
            } else {
                //Creacion de nombre del archivo
                nombreArchivo = tblCompras.getValueAt(0, 0).toString() + tblCompras.getValueAt(0, 2).toString() + tblCompras.getValueAt(0, 3).toString();

                LNPlantilla plantilla = new LNPlantilla();
                plantilla.Plantilla(nombreArchivo, fechaPDF, datosTabla);
                plantilla.crearPlantilla(nombreArchivo, fechaPDF, datosTabla);
            }

        } catch (Exception e) {
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(FrmCompraPDFCRUD.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnGenerarPDFActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed

        eliminarSeleccionado();

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnAbrirPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirPDFActionPerformed

        if (nombreArchivo.equals("")) {
            JOptionPane.showMessageDialog(null, "No se a encontrado el archivo");
        } else {
            abrir(nombreArchivo);
        }


    }//GEN-LAST:event_btnAbrirPDFActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    //metodo para eliminar le dato seleccionado, enviandole el dato lista,
    // y si dato seleccionado es igual a true
    private void eliminarSeleccionado() {
        //metodo eliminar
        if (seleccionado) {
            if (!lista.isEmpty()) {
                lista.remove(fila);
                CargarDatos();
            }
            seleccionado = false;

        } else {
            JOptionPane.showMessageDialog(null, "Seleccione en la tabla el dato que desea eliminar");
        }
    }

   
    //Metodo para abrir el archivo, enviandole el nombre del archivo que se creo anteriormente
    //Se crea un lector y lo abre, enviandole la ubicacion del archivo, que fue creado en la misma carpeta
    //de la aplicacion
    public void abrir(String NombreArchivo) {
        try {
            File path = new File(NombreArchivo + ".pdf");
            Desktop.getDesktop().open(path);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Atención", 2);
        }
    }

    //Metodo para cargar datos enviandole la informaicon en un string
    //este metodo funciona para la tabla busqueda de compras, cuando se da un doble click se selecciona
    // el archivo y se trae sus datos
    public void CargarDatos(String[] datos) {
        txtCodigo.setText(datos[0]);
        txtNombreProducto.setText(datos[1]);
        txtMarca.setText(datos[2]);
        txtNombreProveedor.setText(datos[3]);
        txtNombreEmpleado.setText(datos[4]);
        txtCantidad.setText(datos[5]);
        txtPrecio.setText(datos[6]);
        fecha = datos[7];
    }

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
            java.util.logging.Logger.getLogger(FrmCompraPDFCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmCompraPDFCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmCompraPDFCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmCompraPDFCRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FrmCompraPDFCRUD dialog = new FrmCompraPDFCRUD(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnAbrirPDF;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGenerarPDF;
    private javax.swing.JButton btnSelectProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable tblCompras;
    private javax.swing.JTextPane txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextPane txtMarca;
    private javax.swing.JTextPane txtNombreEmpleado;
    private javax.swing.JTextPane txtNombreProducto;
    private javax.swing.JTextPane txtNombreProveedor;
    private javax.swing.JTextPane txtPrecio;
    // End of variables declaration//GEN-END:variables
}
