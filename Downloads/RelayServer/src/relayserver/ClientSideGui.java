/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package relayserver;
import com.sun.xml.internal.ws.api.message.Message;
import java.io.*;
import java.net.*;
import javax.swing.JOptionPane;


/**
 *
 * @author StephenJMScott
 */
public class ClientSideGui extends javax.swing.JFrame {
    private static String host;
    private static int port;
    /**
     * Creates new form ClientSideGui
     */
    public ClientSideGui() {
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

        lblClientSide = new javax.swing.JLabel();
        lblIPAddress = new javax.swing.JLabel();
        lblPort = new javax.swing.JLabel();
        txtIPField = new javax.swing.JTextField();
        txtPortField = new javax.swing.JTextField();
        btnSetIPandPort = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtMessageArea = new javax.swing.JTextArea();
        btnSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblClientSide.setFont(new java.awt.Font("Perpetua Titling MT", 1, 12)); // NOI18N
        lblClientSide.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClientSide.setText("Client Side");

        lblIPAddress.setText("IP Address:");
        lblIPAddress.setToolTipText("");

        lblPort.setText("Port:");
        lblPort.setToolTipText("");

        btnSetIPandPort.setText("Set");
        btnSetIPandPort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetIPandPortActionPerformed(evt);
            }
        });

        txtMessageArea.setColumns(20);
        txtMessageArea.setRows(5);
        jScrollPane1.setViewportView(txtMessageArea);

        btnSend.setText("Send Message");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSend)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblIPAddress)
                                    .addComponent(lblPort))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtIPField)
                                    .addComponent(txtPortField, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addComponent(btnSetIPandPort))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(lblClientSide, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblClientSide)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIPAddress)
                    .addComponent(txtIPField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPort)
                    .addComponent(txtPortField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSetIPandPort))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(btnSend)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSetIPandPortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetIPandPortActionPerformed
        
        Boolean booIP=true, booPort=true;
        
            if(txtIPField.getText().length() >0 && txtPortField.getText().length() >0){ //Making Sure that both fields are filled in.
                // if statement with Regex for valid IP addresses or Localhost as the only acccepted entry
                if(txtIPField.getText().matches("\\A(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\z" )|| txtIPField.getText().equalsIgnoreCase("localhost")){
                  host = txtIPField.getText();   
                }else{
                    booIP=false;
                }
                
                if(txtPortField.getText().length()<5)// Ensuring the port number is within range of 0 - 9999.
                try{ //making sure the port is numeric only. 
                    port = Integer.parseInt(txtPortField.getText());
                }catch(Exception e){
                    booPort = false;
                }
                
                if(!booIP && !booPort)
                    JOptionPane.showMessageDialog(null, "Incorrect IP and Port Details");
                else if(!booIP && booPort)
                    JOptionPane.showMessageDialog(null, "Incorrect IP Details");
                else if (booIP && !booPort)
                    JOptionPane.showMessageDialog(null, "Incorrect Port Details");
                else if (booIP && booPort)
                    JOptionPane.showMessageDialog(null, "Connection set!");
            
            
            }
            else
                JOptionPane.showMessageDialog(null, "Please input into both fields");
            
        
        
    }//GEN-LAST:event_btnSetIPandPortActionPerformed

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
            java.util.logging.Logger.getLogger(ClientSideGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientSideGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientSideGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientSideGui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientSideGui().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSend;
    private javax.swing.JButton btnSetIPandPort;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblClientSide;
    private javax.swing.JLabel lblIPAddress;
    private javax.swing.JLabel lblPort;
    private javax.swing.JTextField txtIPField;
    private javax.swing.JTextArea txtMessageArea;
    private javax.swing.JTextField txtPortField;
    // End of variables declaration//GEN-END:variables
}