/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View.Login;


import Connection.MySQL;
import View.CustomMenu.MainMenu;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author vinic
 */
public class StudentLoginPanel extends javax.swing.JFrame {
    MySQL conectar = new MySQL();
    public static int studentId;    
    
    public StudentLoginPanel() {
        initComponents();
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelUsuario = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonEntrar = new javax.swing.JButton();
        jButtonCadastrar = new javax.swing.JButton();
        txtPassword = new javax.swing.JPasswordField();
        jButtonLimpar = new javax.swing.JButton();
        jButtonLimpar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Consul TI - Login");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(69, 183, 233));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Login", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 12), new java.awt.Color(0, 0, 0))); // NOI18N

        jLabelUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelUsuario.setForeground(new java.awt.Color(0, 0, 0));
        jLabelUsuario.setText("Usuario:");

        txtLogin.setToolTipText("Informe o usuário");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Senha: ");

        jButtonEntrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonEntrar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonEntrar.setText("Entrar");
        jButtonEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEntrarActionPerformed(evt);
            }
        });

        jButtonCadastrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonCadastrar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonCadastrar.setText("Cadastrar");
        jButtonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCadastrarActionPerformed(evt);
            }
        });

        txtPassword.setToolTipText("Informe a senha");

        jButtonLimpar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonLimpar.setForeground(new java.awt.Color(0, 0, 0));
        jButtonLimpar.setText("Limpar");
        jButtonLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimparActionPerformed(evt);
            }
        });

        jButtonLimpar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonLimpar1.setForeground(new java.awt.Color(0, 0, 0));
        jButtonLimpar1.setText("Sair");
        jButtonLimpar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelUsuario)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonLimpar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonLimpar1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                                .addComponent(txtPassword))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButtonEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(53, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUsuario)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonEntrar)
                    .addComponent(jButtonCadastrar))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLimpar1)
                    .addComponent(jButtonLimpar))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

     private boolean LoginEmployee() throws SQLException {
        this.conectar.conectaBanco();
        
        String login = this.txtLogin.getText();
        String password = this.txtPassword.getText();
        
            this.conectar.executarSQL(
            "SELECT * "
            + " FROM"
            + " student"
          + " WHERE"
            + " login = '" + login + "'" + " and password = '" + password + "';"
            );
            return this.conectar.getResultSet().next(); 
     }
     
     private void MakeStudentId() throws SQLException {
        this.conectar.conectaBanco();
        
        String login = this.txtLogin.getText();
        String password = this.txtPassword.getText();
        
            this.conectar.executarSQL(
            "SELECT * "
            + " FROM"
            + " student"
          + " WHERE"
            + " login = '" + login + "'" + " and password = '" + password + "';"
            );
            while(this.conectar.getResultSet().next()) {
            studentId = Integer.parseInt(this.conectar.getResultSet().getString(1));
        } 
             this.conectar.fechaBanco();
     }
     
     private void apagarDados(){
         this.txtLogin.setText("");
         this.txtPassword.setText("");
     }

    
    private void ClearData() {
        txtLogin.setText("");
        txtPassword.setText("");
    }
    
    
    private void jButtonEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEntrarActionPerformed
        try {
            boolean exists = LoginEmployee();
            if (exists) {
                MainMenu obj = new MainMenu();
                MakeStudentId();
                JOptionPane.showMessageDialog(null, "Login efetuado com sucesso!");
                obj.setVisible(true);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Usuário e/ou senha inválidos. Digite novamente");
                this.txtLogin.setText("");
                this.txtPassword.setText("");
            }
        } catch (SQLException ex) {
            Logger.getLogger(StudentLoginPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButtonEntrarActionPerformed

    private void jButtonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCadastrarActionPerformed
        StudentRegisterPanel obj = new StudentRegisterPanel();
        obj.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonCadastrarActionPerformed

    private void jButtonLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimparActionPerformed
        ClearData();        
    }//GEN-LAST:event_jButtonLimparActionPerformed

    private void jButtonLimpar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpar1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButtonLimpar1ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(StudentLoginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentLoginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentLoginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentLoginPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentLoginPanel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCadastrar;
    private javax.swing.JButton jButtonEntrar;
    private javax.swing.JButton jButtonLimpar;
    private javax.swing.JButton jButtonLimpar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables

}
