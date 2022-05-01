/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
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
import com.microsoft.sqlserver.jdbc.StringUtils;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList; 
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * DefaultTableModel modelo;
 *
 * @author alequ
 */
public class FrmPrincipalCompra extends javax.swing.JFrame {

    DefaultTableModel modelo;
    int idProducto = 0;
    int idEmpleado = 0;
    int idProveedor = 0;

    public FrmPrincipalCompra() throws Exception {
        initComponents(); 
        
        setLocationRelativeTo(null);
        this.setTitle("Agregar Compra");

        try {
            CargarDatos("");
        } catch (Exception e) {
            throw e;
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
//limpiar los textbox t algunos datos globales
    private void Limpiar() {
        txtNombreProducto.setText("");
        txtNombreEmpleado.setText("");
        txtPrecio.setText("");
        txtMarca.setText("");
        txtNombreProveedor.setText("");
        txtCantidad.setText("");
        txtCodigo.setText("");
        idProducto = 0;
        idEmpleado = 0;
        idProveedor = 0;
    }
//cargar los datos a la tabla
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

    private Compra GenerarEntidad() {

        boolean modificar = false;
        Compra compra = new Compra();
        LNCompra busqueda = new LNCompra();

        try {
             

            //dando formato a la fecha y guardandola en las compras
            DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = formato.parse(dtf2.format(LocalDateTime.now()));

            //estos valores globales solo se obtienen cuando se hace una busqueda, asi que ahora hay que hacer una busqueda diferente para obtenerlos
            compra.setIdProducto(idProducto);
            compra.setIdVendedor(idProveedor);
            compra.setIdEmpleado(idEmpleado);

            compra.setCantidadCompra(Integer.parseInt(txtCantidad.getText()));
            compra.setFechaCompra(fecha);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return compra;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCompras = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNombreProducto = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtNombreProveedor = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtNombreEmpleado = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtCantidad = new javax.swing.JTextPane();
        btnSelectProveedor = new javax.swing.JButton();
        btnSelectProducto = new javax.swing.JButton();
        btnSelectEmpleado = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtMarca = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtPrecio = new javax.swing.JTextPane();
        txtCodigo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnVolverMenuPrincipal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Nombre del Producto");

        jLabel2.setText("Nombre del Proveedor");

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

        jLabel3.setText("Ultimas facturaciones de compras");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Agregar nueva compra");

        jLabel5.setText("Nombre del Empleado");

        jLabel7.setText("Agregar Productos");

        txtNombreProducto.setEditable(false);
        txtNombreProducto.setBackground(new java.awt.Color(102, 102, 102));
        txtNombreProducto.setForeground(new java.awt.Color(102, 102, 102));
        txtNombreProducto.setCaretColor(new java.awt.Color(102, 102, 102));
        txtNombreProducto.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        txtNombreProducto.setFocusable(false);
        txtNombreProducto.setSelectedTextColor(new java.awt.Color(102, 102, 102));
        jScrollPane2.setViewportView(txtNombreProducto);

        txtNombreProveedor.setEditable(false);
        txtNombreProveedor.setBackground(new java.awt.Color(102, 102, 102));
        txtNombreProveedor.setForeground(new java.awt.Color(102, 102, 102));
        txtNombreProveedor.setFocusable(false);
        jScrollPane3.setViewportView(txtNombreProveedor);

        txtNombreEmpleado.setEditable(false);
        txtNombreEmpleado.setBackground(new java.awt.Color(102, 102, 102));
        txtNombreEmpleado.setForeground(new java.awt.Color(102, 102, 102));
        txtNombreEmpleado.setFocusable(false);
        jScrollPane4.setViewportView(txtNombreEmpleado);

        jScrollPane5.setViewportView(txtCantidad);

        btnSelectProveedor.setText("Seleccionar");
        btnSelectProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectProveedorActionPerformed(evt);
            }
        });

        btnSelectProducto.setText("Seleccionar");
        btnSelectProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectProductoActionPerformed(evt);
            }
        });

        btnSelectEmpleado.setText("Seleccionar");
        btnSelectEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectEmpleadoActionPerformed(evt);
            }
        });

        btnGuardar.setText("Agregar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        txtMarca.setEditable(false);
        txtMarca.setBackground(new java.awt.Color(102, 102, 102));
        txtMarca.setForeground(new java.awt.Color(102, 102, 102));
        txtMarca.setFocusable(false);
        txtMarca.setSelectedTextColor(new java.awt.Color(102, 102, 102));
        jScrollPane6.setViewportView(txtMarca);

        jLabel6.setText("Marca del Proveedor");

        jLabel8.setText("Precio Compra");

        txtPrecio.setEditable(false);
        txtPrecio.setFocusable(false);
        jScrollPane7.setViewportView(txtPrecio);

        txtCodigo.setEditable(false);
        txtCodigo.setText(" ");
        txtCodigo.setAutoscrolls(false);
        txtCodigo.setEnabled(false);
        txtCodigo.setFocusable(false);

        jLabel9.setText("Codigo");

        jLabel10.setText("Doble click para crear la facturacion");

        btnVolverMenuPrincipal.setText("Volver al Menu Principal");
        btnVolverMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverMenuPrincipalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLimpiar)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuardar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1)
                                        .addComponent(btnSelectProveedor)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel6))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel2)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnSelectProducto)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel8)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(btnSelectEmpleado))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addGap(183, 183, 183))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jLabel7))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel9)
                                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(264, 264, 264)
                                    .addComponent(jLabel10))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(btnVolverMenuPrincipal)))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel4)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSelectEmpleado))
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSelectProducto)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSelectProveedor)))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVolverMenuPrincipal)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblComprasMouseClicked

        if (evt.getClickCount() == 2) {
            int fila = tblCompras.rowAtPoint(evt.getPoint());
            
            //Creacion de una variable que enviaremos los datos de la tabla
            String[] datos = new String[8];
            //cargamos los datos de la tabla al String
            for (int i = 0; i < datos.length; i++) {
                datos[i]=tblCompras.getValueAt(fila, i).toString();
            }
            //Despues hacemos que cuando cargue el nuevo formulario o jdialog envie los datos correspondientes a ese formulario
            
            FrmCompraPDFCRUD frmPDF = new FrmCompraPDFCRUD(null, true);
            frmPDF.addWindowListener(new WindowAdapter() {
                @Override
                public void windowOpened(WindowEvent e) {
                    try {
                        frmPDF.CargarDatos(datos);
                        String condicion = "";
                        LNProducto logica = new LNProducto();
                        Producto producto;
                        
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            });

            frmPDF.setVisible(true);

        }
    }//GEN-LAST:event_tblComprasMouseClicked

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnSelectProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectProductoActionPerformed
        //crea un formulario de busqueda y obtenemos el id del producto mediante el metodo que se encuentra en ese fomrulario creado
        //y luego se hace la colocacion del dato en los textbox
        FrmBuscarProducto frmBuscar = new FrmBuscarProducto(null, true);
        frmBuscar.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                try {
                    int id = frmBuscar.ObtenerId();
                    String condicion = "";
                    LNProducto logica = new LNProducto();
                    Producto producto;
                    if (id > -1) {
                        condicion = String.format("id_producto=%d", id);
                        producto = logica.ObtenerRegistro(condicion);
                        txtNombreProducto.setText(String.valueOf(producto.getNombre()));
                        txtPrecio.setText(String.valueOf(producto.getPrecioCompra()));
                        idProducto = producto.getIdProducto();
                    } else {
                        //txtNombreProducto.setText("");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        frmBuscar.setVisible(true);
    }//GEN-LAST:event_btnSelectProductoActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
//se evalua que todo este lleno para poder guardar los datos en la BD
        boolean vacio = false;
        if (txtNombreProducto.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Ningun campo debe estar vacio");
            vacio = true;
        } else {
            if (txtPrecio.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Ningun campo debe estar vacio");
                vacio = true;
            } else {
                if (txtNombreEmpleado.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Ningun campo debe estar vacio");
                    vacio = true;
                } else {
                    if (txtNombreProveedor.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Ningun campo debe estar vacio");
                        vacio = true;
                    } else {
                        if (txtCantidad.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Ningun campo debe estar vacio");
                            vacio = true;
                        } else {
                            if (txtMarca.getText().equals("")) {
                                JOptionPane.showMessageDialog(null, "Ningun campo debe estar vacio");
                                vacio = true;
                            }
                        }
                    }
                }
            }
        }
//evalua que los datos sean numericos
        if (!StringUtils.isNumeric(txtCantidad.getText()) && !StringUtils.isNumeric(txtPrecio.getText()) && !txtCantidad.getText().equals("") && !txtPrecio.getText().equals("") && !vacio) {
            JOptionPane.showMessageDialog(null, "Cantidad y Precio debe llenarlo con numeros");
        } else if (!StringUtils.isNumeric(txtCantidad.getText()) && !txtCantidad.getText().equals("") && !vacio) {
            JOptionPane.showMessageDialog(null, "Cantidad debe llenarlo con numeros");
        } else if (!StringUtils.isNumeric(txtPrecio.getText()) && !txtPrecio.getText().equals("") && !vacio) {
            JOptionPane.showMessageDialog(null, "Precio debe llenarlo con numeros");
        } else {
            if (idProducto != 0 && idEmpleado != 0 && idProveedor != 0 && !txtCantidad.getText().equals("") && !txtPrecio.getText().equals("")) {

                LNCompra logica = new LNCompra();
                Compra compra = GenerarEntidad();
                try {
                    if (compra.isExiste()) {
                        logica.Modificar(compra);
                    } else {
                        logica.Insertar(compra);
                    }

                    JOptionPane.showMessageDialog(this, logica.getMensaje());
                    System.out.println(logica.getMensaje());
                    Limpiar();

                    CargarDatos("");
                } catch (Exception e) {
                    try {
                        throw e;
                    } catch (Exception ex) {
                        Logger.getLogger(FrmPrincipalCompra.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
        }


    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnSelectProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectProveedorActionPerformed
        //crea un formulario de busqueda y obtenemos el id del proveedor mediante el metodo que se encuentra en ese fomrulario creado
        //y luego se hace la colocacion del dato en los textbox
        FrmBuscarProveedor frmBuscar = new FrmBuscarProveedor(null, true);
        frmBuscar.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                try {
                    int id = frmBuscar.ObtenerId();
                    String condicion = "";
                    LNProveedor logica = new LNProveedor();
                    Proveedor proveedor;
                    if (id > -1) {
                        condicion = String.format("id_proveedor=%d", id);
                        proveedor = logica.ObtenerRegistro(condicion);
                        txtNombreProveedor.setText(String.valueOf(proveedor.getNombreProveedor()) + " " + String.valueOf(proveedor.getApellidoProveedor()));
                        txtMarca.setText(String.valueOf(proveedor.getMarca()));
                        idProveedor = proveedor.getIdProveedor();
                    } else {
                        //txtNombreProveedor.setText("");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        frmBuscar.setVisible(true);
    }//GEN-LAST:event_btnSelectProveedorActionPerformed

    private void btnSelectEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectEmpleadoActionPerformed
        //crea un formulario de busqueda y obtenemos el id del Empleado mediante el metodo que se encuentra en ese fomrulario creado
        //y luego se hace la colocacion del dato en los textbox
        FrmBuscarEmpleado frmBuscar = new FrmBuscarEmpleado(null, true);
        frmBuscar.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                try {
                    int id = frmBuscar.ObtenerId();
                    String condicion = "";
                    LNEmpleado logica = new LNEmpleado();
                    Empleado empleado;
                    if (id > -1) {
                        condicion = String.format("id_empleado=%d", id);
                        empleado = logica.ObtenerRegistro(condicion);
                        txtNombreEmpleado.setText(String.valueOf(empleado.getNombre()) + " " + String.valueOf(empleado.getApellido()));
                        idEmpleado = empleado.getIdEmpleado();
                    } else {
                        //txtNombreEmpleado.setText("");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        });

        frmBuscar.setVisible(true);
    }//GEN-LAST:event_btnSelectEmpleadoActionPerformed

    private void btnVolverMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverMenuPrincipalActionPerformed
        FrmMenuAdmin frm;
        try { 
            frm = new FrmMenuAdmin(); 
            
            frm.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(FrmMenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVolverMenuPrincipalActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPrincipalCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipalCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipalCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipalCompra.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmPrincipalCompra().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(FrmPrincipalCompra.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSelectEmpleado;
    private javax.swing.JButton btnSelectProducto;
    private javax.swing.JButton btnSelectProveedor;
    private javax.swing.JButton btnVolverMenuPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JSeparator jSeparator1;
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
