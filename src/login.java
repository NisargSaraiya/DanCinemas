/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author pankaj
 */
public class login extends javax.swing.JFrame {

    /**
     * Creates new form login
     */
    public login() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        cu = new javax.swing.JRadioButton();
        ad = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pa = new javax.swing.JPasswordField();
        l = new javax.swing.JLabel();
        re = new javax.swing.JButton();
        ui = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        buttonGroup1.add(cu);
        cu.setForeground(new java.awt.Color(255, 255, 255));
        cu.setSelected(true);
        cu.setText("Customer");
        cu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cuActionPerformed(evt);
            }
        });
        getContentPane().add(cu, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 60, 93, -1));

        buttonGroup1.add(ad);
        ad.setForeground(new java.awt.Color(255, 255, 255));
        ad.setText("Admin");
        ad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adActionPerformed(evt);
            }
        });
        getContentPane().add(ad, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 80, -1));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\manoj\\Desktop\\IP\\passwor.jpg")); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 40, 40));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\manoj\\Desktop\\IP\\user.jpg")); // NOI18N
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, 70));
        getContentPane().add(pa, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, 106, -1));

        l.setFont(new java.awt.Font("Bell MT", 0, 18)); // NOI18N
        l.setForeground(new java.awt.Color(255, 255, 255));
        l.setText("Don't have a account?");
        getContentPane().add(l, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 260, 180, -1));

        re.setText("REGISTER");
        re.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reActionPerformed(evt);
            }
        });
        getContentPane().add(re, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, -1, -1));
        getContentPane().add(ui, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 106, -1));

        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 210, -1, -1));

        jLabel1.setFont(new java.awt.Font("Bell MT", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PLEASE LOGIN");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 140, 20));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\manoj\\Desktop\\IP\\Theatre Image Background.jpg")); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reActionPerformed
        // TODO add your handling code here:
        register field = new register();
        field.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_reActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(ad.isSelected()){
            Connection con ;

            try{
                Class.forName("java.sql.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/IP_PROJECT","root","pass");
                String u = ui.getText();
                String p = pa.getText();
                String sql = "select * from admin  where UserID ='"+u+"' and password ='"+p+"';";
                Statement st = con.createStatement();

                ResultSet rs = st.executeQuery(sql);
                if(rs.next()){
                    JOptionPane.showMessageDialog(this,"USERID AND PASSWORD MATCHED");
                    admin field= new admin();
                    
                    field.setVisible(true);
                    setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(this,"USERID OR PASSWORD INCORRECT");
                    ui.setText("");
                    pa.setText("");
                }
                con.close();
            }
            catch(Exception e ){
                JOptionPane.showMessageDialog(this,e.getMessage());

            }

        }

        if(cu.isSelected()){
            Connection con ;

            try{
                Class.forName("java.sql.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/IP_PROJECT","root","pass");
                String u = ui.getText();
                String p = pa.getText();
                String sql = "select * from signin  where UserID ='"+u+"' and password ='"+p+"';";
                Statement st = con.createStatement();

                ResultSet rs = st.executeQuery(sql);
                if(rs.next()){
                    JOptionPane.showMessageDialog(this,"USERID AND PASSWORD MATCHED");
                    mainframe field= new mainframe();
                    field.setVisible(true);
                    setVisible(false);
               
                }
                else {
                    JOptionPane.showMessageDialog(this,"USERID OR PASSWORD INCORRECT");
                    ui.setText("");
                    pa.setText("");
                }
                con.close();
            }
            catch(Exception e ){
                JOptionPane.showMessageDialog(this,e.getMessage());

            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void adActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adActionPerformed
        // TODO add your handling code here:
          
        if(ad.isSelected()){
            re.setVisible(false);
           l.setVisible(false);
          }
         
    }//GEN-LAST:event_adActionPerformed

    private void cuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cuActionPerformed
        // TODO add your handling code here:
        if(cu.isSelected()){
            re.setVisible(true);
           l.setVisible(true);
          }
    }//GEN-LAST:event_cuActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new login().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ad;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JRadioButton cu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel l;
    private javax.swing.JPasswordField pa;
    private javax.swing.JButton re;
    private javax.swing.JTextField ui;
    // End of variables declaration//GEN-END:variables
}
