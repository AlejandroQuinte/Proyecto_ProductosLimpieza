 
package Presentacion;
 
import java.util.logging.Level;
import java.util.logging.Logger; 

/**
 *
 * @author alequ
 */
public class FrmMenuAdmin extends javax.swing.JFrame {

    String[] usuario;

    public FrmMenuAdmin() {

        initComponents();
        setLocationRelativeTo(null);
        this.setTitle("MenuAdmin");
    }

     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuFacturacionCompra = new javax.swing.JMenuItem();
        menuFacturacionVenta = new javax.swing.JMenuItem();
        menuCerrarSesion = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("Administrar");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        menuFacturacionCompra.setText("Facturacion Compra");
        menuFacturacionCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFacturacionCompraActionPerformed(evt);
            }
        });
        jMenu1.add(menuFacturacionCompra);

        menuFacturacionVenta.setText("Facturacion Venta");
        menuFacturacionVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuFacturacionVentaActionPerformed(evt);
            }
        });
        jMenu1.add(menuFacturacionVenta);

        jMenuBar1.add(jMenu1);

        menuCerrarSesion.setText("Cerrar Sesion");
        menuCerrarSesion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCerrarSesionMouseClicked(evt);
            }
        });
        menuCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCerrarSesionActionPerformed(evt);
            }
        });
        jMenuBar1.add(menuCerrarSesion);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 599, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 569, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        FrmPrincipalVenta frm;
        try {
            frm = new FrmPrincipalVenta();
            frm.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(FrmMenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void menuFacturacionVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFacturacionVentaActionPerformed

        FrmPrincipalVenta frm;
        try {
            frm = new FrmPrincipalVenta();
            frm.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(FrmMenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuFacturacionVentaActionPerformed

    private void menuCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCerrarSesionActionPerformed

        //no sirve
    }//GEN-LAST:event_menuCerrarSesionActionPerformed

    private void menuFacturacionCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuFacturacionCompraActionPerformed
        FrmPrincipalCompra frm;
        try {
            frm = new FrmPrincipalCompra();
            frm.setVisible(true);
            this.dispose();
        } catch (Exception ex) {
            Logger.getLogger(FrmMenuAdmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_menuFacturacionCompraActionPerformed

    private void menuCerrarSesionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCerrarSesionMouseClicked
        FrmLogin login = new FrmLogin();
        this.dispose();
        login.setVisible(true);
    }//GEN-LAST:event_menuCerrarSesionMouseClicked

     

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
            java.util.logging.Logger.getLogger(FrmMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmMenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmMenuAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menuCerrarSesion;
    private javax.swing.JMenuItem menuFacturacionCompra;
    private javax.swing.JMenuItem menuFacturacionVenta;
    // End of variables declaration//GEN-END:variables
}
