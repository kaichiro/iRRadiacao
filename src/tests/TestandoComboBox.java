/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import controller.ClienteCTRL;
import controller.StatusCTRL;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import model.bean.Cliente;
import model.bean.Status;

/**
 *
 * @author KAI
 */
public class TestandoComboBox extends javax.swing.JFrame {

    /**
     * Creates new form TestandoComboBox
     */
    public TestandoComboBox() {
        initComponents();
        cbStatus.setEditable(true);
        cbCliente.setEditable(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbStatus = new javax.swing.JComboBox<>();
        btnPesquisar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        cbCliente = new javax.swing.JComboBox<>();
        btnLocalizaCliente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtIdCliente = new javax.swing.JTextField();
        txtNomeCliente = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbStatus.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbStatusItemStateChanged(evt);
            }
        });
        cbStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbStatusActionPerformed(evt);
            }
        });
        cbStatus.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbStatusKeyPressed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        jLabel1.setText("Id:");

        jLabel2.setText("Descrição:");

        cbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbClienteActionPerformed(evt);
            }
        });

        btnLocalizaCliente.setText("Localiza Cliente");
        btnLocalizaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizaClienteActionPerformed(evt);
            }
        });

        jLabel3.setText("Id:");

        jLabel4.setText("Nome:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPesquisar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdCliente))
                            .addComponent(cbCliente, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtDescricao))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNomeCliente)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnLocalizaCliente)))
                .addContainerGap(90, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel2});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jLabel4});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLocalizaCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtIdCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(121, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbStatusActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        List<Status> statusList = new ArrayList<>();
        if (cbStatus.getSelectedItem() != null) {
            if (cbStatus.getSelectedItem().toString().trim().length() > 0) {
                statusList = StatusCTRL.BuscaPorDescricao(cbStatus.getSelectedItem().toString());
            }
        }

        cbStatus.removeAllItems();
        statusList.forEach((Status sts) -> {
            cbStatus.addItem(sts);
        });

//        cbStatus.removeAllItems();
//        StatusCTRL.BuscaPorDescricao(cbStatus.getSelectedItem().toString()).forEach((Status sts) -> {
//            cbStatus.addItem(sts);
//            System.out.println(sts.toString());
//        });
//;
//        cbStatus.setEditable(true);
//        final JTextField tf = (JTextField) cbStatus.getEditor().getEditorComponent();
//        tf.addCaretListener(new CaretListener() {
//            private String lastText;
//
//            @Override
//            public void caretUpdate(CaretEvent e) {
//                String txt = tf.getText();
//                if (!txt.equals(lastText)) {
//                    lastText = txt;
//
//                }
//            }
//        });
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void cbStatusItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbStatusItemStateChanged
        if (cbStatus.getSelectedItem() instanceof Status) {
            txtId.setText(String.valueOf(((Status) cbStatus.getSelectedItem()).getId()));
            txtDescricao.setText(((Status) cbStatus.getSelectedItem()).getDescricao());
        }
    }//GEN-LAST:event_cbStatusItemStateChanged

    private void cbStatusKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbStatusKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            System.out.println("teclei enter no combobox");
            this.PopulaComboBox();
        }
    }//GEN-LAST:event_cbStatusKeyPressed

    private void btnLocalizaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizaClienteActionPerformed
        this.LocalizaCliente();
    }//GEN-LAST:event_btnLocalizaClienteActionPerformed

    private void cbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbClienteActionPerformed

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
            java.util.logging.Logger.getLogger(TestandoComboBox.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TestandoComboBox().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLocalizaCliente;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<model.bean.Cliente> cbCliente;
    private javax.swing.JComboBox<model.bean.Status> cbStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtIdCliente;
    private javax.swing.JTextField txtNomeCliente;
    // End of variables declaration//GEN-END:variables

    private void PopulaComboBox() {
        List<Status> statusList = new ArrayList<>();
        if (cbStatus.getSelectedItem() != null) {
            if (cbStatus.getSelectedItem().toString().trim().length() > 0) {
                statusList = StatusCTRL.BuscaPorDescricao(cbStatus.getSelectedItem().toString());
            }
        }

        cbStatus.removeAllItems();
        statusList.forEach((Status sts) -> {
            cbStatus.addItem(sts);
        });
    }

    private void LocalizaCliente() {
        List<Cliente> clientes = new ArrayList<>();
        if (cbCliente.getSelectedItem() != null) {
            if (((Cliente) cbCliente.getSelectedItem()).getRazaoSocial_Nome().trim().length() > 0) {
                clientes = ClienteCTRL.BuscarPorNome(0, ((Cliente) cbCliente.getSelectedItem()).getRazaoSocial_Nome(), null);
            }
        }
        cbCliente.removeAllItems();
        clientes.forEach((Cliente clnt) -> {
            cbCliente.addItem(clnt);
        });
    }
}
