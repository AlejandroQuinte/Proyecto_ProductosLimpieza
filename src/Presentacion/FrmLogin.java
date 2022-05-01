/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Presentacion;

import AccessoDatos.ADLogin;
import Entidades.Login;
import LogicaNegocio.LNLogin;
import java.awt.Image;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;

/**
 *
 * @author alequ
 */
public class FrmLogin extends javax.swing.JFrame {

    /**
     * Creates new form FrmLogin
     */
    public FrmLogin() {
        initComponents();
        setLocationRelativeTo(null);
        this.setTitle("Login");
 //colocar la imagen
        ImageIcon imageIcon = new ImageIcon(new ImageIcon("img\\imgLogin.png").getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH));
        
   
        imgLogo.setIcon(imageIcon);
    }

     

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtUser = new javax.swing.JTextField();
        txtLogin = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        imgLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel2.setLayout(null);

        jLabel1.setText("User:");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(100, 20, 40, 16);

        jLabel2.setText("Password:");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(70, 60, 71, 16);
        jPanel2.add(txtUser);
        txtUser.setBounds(140, 10, 170, 30);

        txtLogin.setText("Login");
        txtLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtLoginActionPerformed(evt);
            }
        });
        jPanel2.add(txtLogin);
        txtLogin.setBounds(240, 100, 72, 30);

        jButton2.setText("Create user");
        jButton2.setEnabled(false);
        jPanel2.add(jButton2);
        jButton2.setBounds(20, 100, 100, 30);
        jPanel2.add(txtPassword);
        txtPassword.setBounds(140, 50, 170, 30);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(imgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(36, Short.MAX_VALUE)
                .addComponent(imgLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtLoginActionPerformed

        //verifica que todo este lleno
        if (txtUser.getText().equals("") && txtPassword.getPassword().length == 0) {
            JOptionPane.showMessageDialog(this, "Debe llenar el usuario y la password");
        } else {
            if (txtPassword.getPassword().length == 0) {
                JOptionPane.showMessageDialog(this, "Debe llenar el password");
            } else {
                if (txtUser.getText().equals("")) {
                    JOptionPane.showMessageDialog(this, "Debe llenar el usuario");
                }
            }
        }

        //obtiene la contrase;a y verifica que tenga algun dato
        if (txtPassword.getPassword().length != 0 && !txtUser.getText().equals("")) {
            try {
                char[] arrayC = txtPassword.getPassword();
                String pass = new String(arrayC);
                ComprobarLogin(pass);
            } catch (Exception ex) {
                Logger.getLogger(FrmLogin.class.getName()).log(Level.SEVERE, null, ex);
            }

        }


    }//GEN-LAST:event_txtLoginActionPerformed

    //metodo para comprobar si existe el usuairo en la base de de datos que esta conectado con logica de negocio y acceso de datos
    private void ComprobarLogin(String passsword) throws Exception {
        try {
            LNLogin login = new LNLogin();
            int num = login.ComprobarLogin(txtUser.getText(), passsword);

            if (num == 0) {
                JOptionPane.showMessageDialog(this, "El usuario digitado no se encuentra en la base de datos, porfavor compruebe que los datos esten correctos");
            } else { 
                FrmMenuAdmin frmMenuPrincipal = new FrmMenuAdmin(); 
                this.dispose();
                frmMenuPrincipal.setVisible(true); 
            }

        } catch (Exception e) {
            throw e;
        }
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
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel imgLogo;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton txtLogin;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUser;
    // End of variables declaration//GEN-END:variables
}
