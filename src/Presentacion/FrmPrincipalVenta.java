package Presentacion;

import Entidades.Cliente;
import Entidades.Empleado;
import Entidades.Login;
import Entidades.Producto;
import Entidades.Venta;
import LogicaNegocio.LNCliente;
import LogicaNegocio.LNEmpleado;
import LogicaNegocio.LNLogin;
import LogicaNegocio.LNProducto;
import LogicaNegocio.LNVenta;
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
 *
 * @author alequ
 */
public class FrmPrincipalVenta extends javax.swing.JFrame {

    //variables globales
    DefaultTableModel modelo;
    int idProducto = 0;
    int idCliente = 0;
    int idEmpleado = 0;

    public FrmPrincipalVenta() throws Exception {
        initComponents();

        this.setTitle("Agregar Venta");

        this.setLocationRelativeTo(null);

        try {
            CargarDatos("");
        } catch (Exception e) {
            throw e;
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

        tblCompras.setModel(modelo);
        modelo.addColumn("Codigo");
        modelo.addColumn("Nombre Producto");
        modelo.addColumn("Marca Producto");
        modelo.addColumn("Nombre Cliente");
        modelo.addColumn("Nombre Empleado");
        modelo.addColumn("Cantidad Venta");
        modelo.addColumn("Precio Producto");
        modelo.addColumn("Fecha");

    }

    //limpia los textbox
    private void Limpiar() {
        txtNombreProducto.setText("");
        txtNombreEmpleado.setText("");
        txtPrecio.setText("");
        txtNombreCliente.setText("");
        txtApellidoCliente.setText("");
        txtCantidad.setText("");
        txtCodigo.setText("");
        idProducto = 0;
        idCliente = 0;
        idEmpleado = 0;
    }

    //carga los datos hacia la tabla
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

    private Venta GenerarEntidad() {
 
        Venta venta = new Venta(); 

        try {

            //dando formato a la fecha y guardandola en las compras
            DateTimeFormatter dtf2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date fecha = formato.parse(dtf2.format(LocalDateTime.now()));

            //estos valores globales solo se obtienen cuando se hace una busqueda, asi que ahora hay que hacer una busqueda diferente para obtenerlos
            venta.setIdProducto(idProducto);
            venta.setIdCliente(idCliente);
            venta.setIdEmpleado(idEmpleado);

            venta.setCantidadVentidad(Integer.parseInt(txtCantidad.getText()));
            venta.setFechaVenta(fecha);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return venta;
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
        txtApellidoCliente = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtNombreEmpleado = new javax.swing.JTextPane();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtCantidad = new javax.swing.JTextPane();
        btnSelectCliente = new javax.swing.JButton();
        btnSelectProducto = new javax.swing.JButton();
        btnSelectEmpleado = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtNombreCliente = new javax.swing.JTextPane();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtPrecio = new javax.swing.JTextPane();
        txtCodigo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        btnVolverMenuPrincipal = new javax.swing.JButton();
        btnEmpleadoMes = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jLabel1.setText("Nombre del Producto");

        jLabel2.setText("Apellido del Cliente");

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

        jLabel3.setText("Ultimas facturaciones de Ventas");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Agregar nueva venta");

        jLabel5.setText("Nombre del Empleado");

        jLabel7.setText("Productos vendidos");

        txtNombreProducto.setEditable(false);
        txtNombreProducto.setBackground(new java.awt.Color(102, 102, 102));
        txtNombreProducto.setForeground(new java.awt.Color(102, 102, 102));
        txtNombreProducto.setCaretColor(new java.awt.Color(102, 102, 102));
        txtNombreProducto.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        txtNombreProducto.setFocusable(false);
        txtNombreProducto.setSelectedTextColor(new java.awt.Color(102, 102, 102));
        jScrollPane2.setViewportView(txtNombreProducto);

        txtApellidoCliente.setEditable(false);
        txtApellidoCliente.setBackground(new java.awt.Color(102, 102, 102));
        txtApellidoCliente.setForeground(new java.awt.Color(102, 102, 102));
        txtApellidoCliente.setFocusable(false);
        jScrollPane3.setViewportView(txtApellidoCliente);

        txtNombreEmpleado.setEditable(false);
        txtNombreEmpleado.setBackground(new java.awt.Color(102, 102, 102));
        txtNombreEmpleado.setForeground(new java.awt.Color(102, 102, 102));
        txtNombreEmpleado.setFocusable(false);
        jScrollPane4.setViewportView(txtNombreEmpleado);

        jScrollPane5.setViewportView(txtCantidad);

        btnSelectCliente.setText("Seleccionar");
        btnSelectCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectClienteActionPerformed(evt);
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

        txtNombreCliente.setEditable(false);
        txtNombreCliente.setBackground(new java.awt.Color(102, 102, 102));
        txtNombreCliente.setForeground(new java.awt.Color(102, 102, 102));
        txtNombreCliente.setFocusable(false);
        txtNombreCliente.setSelectedTextColor(new java.awt.Color(102, 102, 102));
        jScrollPane6.setViewportView(txtNombreCliente);

        jLabel6.setText("Nombre del Cliente");

        jLabel8.setText("Precio Venta");

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

        btnEmpleadoMes.setText("Ventas Mes");
        btnEmpleadoMes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEmpleadoMesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnVolverMenuPrincipal)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(btnSelectCliente)
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
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel7))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnEmpleadoMes)))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jLabel9)
                                                .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnLimpiar)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnGuardar))))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(264, 264, 264)
                                    .addComponent(jLabel10))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
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
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEmpleadoMes, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnSelectProducto)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(28, 28, 28)
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
                        .addComponent(btnSelectCliente)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVolverMenuPrincipal)
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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
                datos[i] = tblCompras.getValueAt(fila, i).toString();
            }
            //Despues hacemos que cuando cargue el nuevo formulario o jdialog envie los datos correspondientes a ese formulario

            try {
                //Crea e formulario y carga los datos envianle la informacion de la tabal que se selecciono
                FrmVentaPDFCRUD frmPDF = new FrmVentaPDFCRUD(null, true);
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
            } catch (Exception e) {
                try {
                    throw e;
                } catch (Exception ex) {
                    Logger.getLogger(FrmPrincipalVenta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }//GEN-LAST:event_tblComprasMouseClicked

    private void btnSelectClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectClienteActionPerformed
        try {
            //se crea el formualrio de cliente y se obtiene el doble click del dato que se selecciono para asi poder cargar la informacion ene ste formulario
            FrmBuscarCliente frmBuscar = new FrmBuscarCliente(null, true);
            frmBuscar.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {
                    try {
                        int id = frmBuscar.ObtenerId();
                        String condicion = "";
                        LNCliente logica = new LNCliente();
                        Cliente Cliente;
                        if (id > -1) {
                            condicion = String.format("ID_Cliente=%d", id);
                            Cliente = logica.ObtenerRegistro(condicion);
                            txtApellidoCliente.setText(String.valueOf(Cliente.getApellido()));
                            txtNombreCliente.setText(String.valueOf(Cliente.getNombre()));
                            idCliente = Cliente.getIdCliente();
                        } else {
                            //txtNombreProveedor.setText("");
                        }
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }
                }
            });
            frmBuscar.setVisible(true);
        } catch (Exception e) {
        }


    }//GEN-LAST:event_btnSelectClienteActionPerformed

    private void btnSelectProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectProductoActionPerformed
        
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
                        txtPrecio.setText(String.valueOf(producto.getPrecioVenta()));
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

    private void btnSelectEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectEmpleadoActionPerformed
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

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
//se revisa que todo este lleno
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
                    if (txtApellidoCliente.getText().equals("")) {
                        JOptionPane.showMessageDialog(null, "Ningun campo debe estar vacio");
                        vacio = true;
                    } else {
                        if (txtCantidad.getText().equals("")) {
                            JOptionPane.showMessageDialog(null, "Ningun campo debe estar vacio");
                            vacio = true;
                        } else {
                            if (txtNombreCliente.getText().equals("")) {
                                JOptionPane.showMessageDialog(null, "Ningun campo debe estar vacio");
                                vacio = true;
                            }
                        }
                    }
                }
            }
        }
//se revisa que los datos sean numeros
        if (!StringUtils.isNumeric(txtCantidad.getText()) && !StringUtils.isNumeric(txtPrecio.getText()) && !txtCantidad.getText().equals("") && !txtPrecio.getText().equals("") && !vacio) {
            JOptionPane.showMessageDialog(null, "Cantidad y Precio debe llenarlo con numeros");
        } else if (!StringUtils.isNumeric(txtCantidad.getText()) && !txtCantidad.getText().equals("") && !vacio) {
            JOptionPane.showMessageDialog(null, "Cantidad debe llenarlo con numeros");
        } else if (!StringUtils.isNumeric(txtPrecio.getText()) && !txtPrecio.getText().equals("") && !vacio) {
            JOptionPane.showMessageDialog(null, "Precio debe llenarlo con numeros");
        } else {
            if (idProducto != 0 && idEmpleado != 0 && idCliente != 0 && !txtCantidad.getText().equals("") && !txtPrecio.getText().equals("")) {

                LNVenta logica = new LNVenta();
                Venta Venta = GenerarEntidad();
                try {
                    if (Venta.isExiste()) {
                        logica.Modificar(Venta);
                    } else {
                        logica.Insertar(Venta);
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

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnVolverMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverMenuPrincipalActionPerformed
        
        //se crea un formulario par apoder volver al inicio
        FrmMenuAdmin frm;
        try {  
            frm = new FrmMenuAdmin();
            frm.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(FrmMenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVolverMenuPrincipalActionPerformed

    private void btnEmpleadoMesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEmpleadoMesActionPerformed
       FrmVentasMes ventas=new FrmVentasMes(null,true);
       
       ventas.setVisible(true);
        
    }//GEN-LAST:event_btnEmpleadoMesActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPrincipalVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipalVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipalVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipalVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new FrmPrincipalVenta( ).setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(FrmPrincipalVenta.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEmpleadoMes;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSelectCliente;
    private javax.swing.JButton btnSelectEmpleado;
    private javax.swing.JButton btnSelectProducto;
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
    private javax.swing.JTextPane txtApellidoCliente;
    private javax.swing.JTextPane txtCantidad;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextPane txtNombreCliente;
    private javax.swing.JTextPane txtNombreEmpleado;
    private javax.swing.JTextPane txtNombreProducto;
    private javax.swing.JTextPane txtPrecio;
    // End of variables declaration//GEN-END:variables
}
