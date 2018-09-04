/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.InversorCTRL;
import controller.StatusCTRL;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import model.bean.Inversor;
import model.bean.Status;
import utils.Enumeradors;
import utils.Utilitarios;

/**
 *
 * @author KAI
 */
public class DlgInversor extends javax.swing.JDialog {

    private Inversor inversor = new Inversor();
    private List<Inversor> inversores = new ArrayList<>();
    private boolean firstRun = true;

    public Inversor getInversor() {
        return inversor;
    }

    public void setInversor(Inversor inversor) {
        this.inversor = inversor;
        this.PopulaComponentesComObjInversor();
    }

    public List<Inversor> getInversores() {
        return inversores;
    }

    public void setInversores(List<Inversor> inversores) {
        this.inversores = inversores;
    }

    /**
     * Creates new form DlgInversor
     *
     * @param parent
     * @param modal
     */
    public DlgInversor(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.IniciaComponentes();
        this.firstRun = false;
        setIcon();
    }
    
    private void setIcon (){
        this.setIconImage(new ImageIcon(getClass().getResource("/image/solar-energy.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtId = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        txtPotenciaWCA = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        txtRendimentoNacional = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txtUccMaxEntradaAC = new javax.swing.JFormattedTextField();
        txtIccMaxEntradaA = new javax.swing.JFormattedTextField();
        txtPotenciaMaxWCC = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtValorVenda = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtRendimentoMaximo = new javax.swing.JFormattedTextField();
        cmbxStatus = new javax.swing.JComboBox<>();
        cmbxTipoSaidaAC = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        spnrLimit1 = new javax.swing.JSpinner();
        jLabel16 = new javax.swing.JLabel();
        txtLocalizar1 = new javax.swing.JFormattedTextField();
        btnLocalizar1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblInversores = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inversor");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("jButton1");

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnGravar.setText("Gravar");
        btnGravar.setEnabled(false);
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNovo)
                .addGap(18, 18, 18)
                .addComponent(btnGravar)
                .addGap(18, 18, 18)
                .addComponent(btnFechar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnNovo)
                    .addComponent(btnGravar)
                    .addComponent(btnFechar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Id:");

        txtId.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtId.setEnabled(false);

        jLabel2.setText("Status:");

        jLabel3.setText("Potência WCA:");

        jLabel4.setText("Modelo:");

        jLabel5.setText("Rendimento Nacional:");

        jLabel6.setText("Ucc Max Entrada A:");

        jLabel7.setText("Icc Max Entrada A:");

        jLabel8.setText("Potência Max WCC:");

        jLabel9.setText("Rendimento Máximo:");

        jLabel10.setText("Valor Venda:");

        jLabel12.setText("Tipo Saída AC:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtModelo))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtUccMaxEntradaAC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRendimentoNacional, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRendimentoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbxTipoSaidaAC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPotenciaWCA, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPotenciaMaxWCC, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtIccMaxEntradaA, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel1, jLabel12, jLabel3, jLabel4, jLabel6});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel10, jLabel2, jLabel5, jLabel8});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel7, jLabel9});

        jPanel3Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cmbxStatus, txtPotenciaMaxWCC});

        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cmbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPotenciaWCA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtPotenciaMaxWCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(txtIccMaxEntradaA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtUccMaxEntradaAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtRendimentoNacional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtRendimentoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10)
                    .addComponent(txtValorVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbxTipoSaidaAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setText("Limite:");

        spnrLimit1.setModel(new javax.swing.SpinnerNumberModel(10, 1, 1000, 1));

        jLabel16.setText("Localizar:");

        txtLocalizar1.setText("%");

        btnLocalizar1.setText("Localizar");
        btnLocalizar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spnrLimit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtLocalizar1)
                .addGap(18, 18, 18)
                .addComponent(btnLocalizar1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(spnrLimit1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(txtLocalizar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLocalizar1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel19.setText("Para alterar o registro tecle ENTER dou dê um duplo clique com o botão normal do mouse sobre a linha desejada.");

        tblInversores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblInversores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblInversoresMouseClicked(evt);
            }
        });
        tblInversores.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblInversoresKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblInversores);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLocalizar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizar1ActionPerformed
        this.PopulaJTableInversores();    }//GEN-LAST:event_btnLocalizar1ActionPerformed

    private void tblInversoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblInversoresMouseClicked
        if (evt.getClickCount() == 2) {
            this.PegarObj();
        }
    }//GEN-LAST:event_tblInversoresMouseClicked

    private void tblInversoresKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblInversoresKeyPressed
        if ((evt.getKeyChar() == KeyEvent.VK_ENTER)) {
            this.PegarObj();
            evt.consume();
        }
    }//GEN-LAST:event_tblInversoresKeyPressed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.HabilitaDesabilitaComponentes(true);
        btnNovo.setEnabled(false);
        btnGravar.setEnabled(true);
        this.setInversor(new Inversor());

    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        this.GravaModulo();
        btnNovo.setEnabled(true);
    }//GEN-LAST:event_btnGravarActionPerformed

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
            java.util.logging.Logger.getLogger(DlgInversor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            DlgInversor dialog = new DlgInversor(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFechar;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnLocalizar1;
    private javax.swing.JButton btnNovo;
    private javax.swing.JComboBox<Status> cmbxStatus;
    private javax.swing.JComboBox<utils.Enumeradors.TipoSaidaAC> cmbxTipoSaidaAC;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSpinner spnrLimit1;
    private javax.swing.JTable tblInversores;
    private javax.swing.JFormattedTextField txtIccMaxEntradaA;
    private javax.swing.JFormattedTextField txtId;
    private javax.swing.JFormattedTextField txtLocalizar1;
    private javax.swing.JFormattedTextField txtModelo;
    private javax.swing.JFormattedTextField txtPotenciaMaxWCC;
    private javax.swing.JFormattedTextField txtPotenciaWCA;
    private javax.swing.JFormattedTextField txtRendimentoMaximo;
    private javax.swing.JFormattedTextField txtRendimentoNacional;
    private javax.swing.JFormattedTextField txtUccMaxEntradaAC;
    private javax.swing.JFormattedTextField txtValorVenda;
    // End of variables declaration//GEN-END:variables

    private void PegarObj() {
        for (int i = 0; i < this.inversores.size(); i++) {
            if (this.inversores.get(i).getId() == ((int) tblInversores.getValueAt(tblInversores.getSelectedRow(), 0))) {
                this.setInversor(this.inversores.get(i));
                break;
            }
        }

        if (this.inversores.isEmpty()) {
            this.setInversor(new Inversor());
        }

        btnGravar.setEnabled(!this.inversores.isEmpty() ? this.inversor.getId() > 0 : false);
    }

    private void IniciaComponentes() {
        this.setResizable(false);

        for (Enumeradors.TipoSaidaAC tpSaidaAC : Enumeradors.TipoSaidaAC.values()) {
            cmbxTipoSaidaAC.addItem(tpSaidaAC);
        }

        for (Status item : StatusCTRL.BuscaTodos()) {
            cmbxStatus.addItem(item);
        }

        Utilitarios.RePosicionaBotoes(new JButton[]{btnNovo, btnGravar, btnFechar, btnLocalizar1}, jPanel2, 150);

        this.PopulaJTableInversores();

        this.HabilitaDesabilitaComponentes(false);
    }

    private void PopulaJTableInversores() {
        String[] colunas = new String[]{"Id", "Modelo", "Status", "Tipo Saída A.C."};
        int QtdeRegistros = 0;
        this.inversores.removeAll(this.inversores);
        if (!firstRun) {
            if (txtLocalizar1.getText().trim().length() > 0) {
                this.inversores = InversorCTRL.BuscaPorModelo(txtLocalizar1.getText(), (int) spnrLimit1.getValue());
                QtdeRegistros = this.inversores.size();
            } else {
                JOptionPane.showMessageDialog(null, "Digite alguma informação para a pesquisa!", "<<<ATENÇÃO>>>", 2);
            }
        }
        Object[][] dados = new Object[QtdeRegistros][colunas.length];

        for (int linha = 0; linha < QtdeRegistros; linha++) {
            int coluna = 0;
            dados[linha][coluna++] = this.inversores.get(linha).getId();
            dados[linha][coluna++] = this.inversores.get(linha).getModelo();
            dados[linha][coluna++] = this.inversores.get(linha).getStatus();
            dados[linha][coluna++] = this.inversores.get(linha).getTipoSaidaAC();
        }

        DefaultTableModel mdl = new DefaultTableModel(dados, colunas) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
        tblInversores.setModel(mdl);
        tblInversores.setAutoCreateRowSorter(true);
        tblInversores.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblInversores.setShowGrid(true);
        tblInversores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        tblInversores.getColumnModel().getColumn(0).setPreferredWidth(65);

        if (this.inversores.isEmpty()) {
            this.setInversor(new Inversor());
        }

        this.HabilitaDesabilitaComponentes(true);
    }

    private void PopulaComponentesComObjInversor() {
        txtIccMaxEntradaA.setText(String.valueOf(this.inversor.getIccMaxEntradaA()).replace(".", ","));
        txtId.setText(String.valueOf(this.inversor.getId()));
        txtModelo.setText(this.inversor.getModelo());
        txtPotenciaMaxWCC.setText(String.valueOf(this.inversor.getPotenciaWCA()));
        txtPotenciaWCA.setText(String.valueOf(this.inversor.getPotenciaWCA()));
        txtRendimentoMaximo.setText(String.valueOf(this.inversor.getRendimentoMaximo()).replace(".", ","));
        txtRendimentoNacional.setText(String.valueOf(this.inversor.getRendimentoNacional()).replace(".", ","));
        txtUccMaxEntradaAC.setText(String.valueOf(this.inversor.getUccMaxEntradaA()).replace(".", ","));
        txtValorVenda.setText(String.valueOf(this.inversor.getValorVenda()).replace(".", ","));

        cmbxTipoSaidaAC.setSelectedItem(this.inversor.getTipoSaidaAC());
        cmbxStatus.setSelectedItem(this.inversor.getStatus());
        if (inversor.getStatus() != null) {
            Utilitarios.SetItemSelectedComboBox(new JComboBox[]{cmbxStatus}, new String[]{inversor.getStatus().toString()});
        }
    }

    private void HabilitaDesabilitaComponentes(boolean b) {
        cmbxStatus.setEnabled(b);
        cmbxTipoSaidaAC.setEnabled(b);
        txtIccMaxEntradaA.setEnabled(b);
        txtModelo.setEnabled(b);
        txtPotenciaMaxWCC.setEnabled(b);
        txtPotenciaWCA.setEnabled(b);
        txtRendimentoMaximo.setEnabled(b);
        txtRendimentoNacional.setEnabled(b);
        txtUccMaxEntradaAC.setEnabled(b);
        txtValorVenda.setEnabled(b);
    }

    private void GravaModulo() {
        this.PopulaObjInversorComInfosDosComponentes();
        this.setInversor(InversorCTRL.Grava(this.inversor));
        if (txtLocalizar1.getText().trim().length() > 0) {
            this.PopulaJTableInversores();
        }
    }

    private void PopulaObjInversorComInfosDosComponentes() {
        if (txtId.getText().trim().length() > 0) {
            this.inversor.setId(Integer.parseInt(txtId.getText()));
        }
        this.inversor.setIccMaxEntradaA(Utilitarios.ConverteTextoEmDouble(txtIccMaxEntradaA.getText()));
        this.inversor.setModelo(txtModelo.getText());
        this.inversor.setPotenciaMaxWCC(Integer.parseInt(txtPotenciaMaxWCC.getText()));
        this.inversor.setPotenciaWCA(Integer.parseInt(txtPotenciaWCA.getText()));
        this.inversor.setRendimentoMaximo(Utilitarios.ConverteTextoEmDouble(txtRendimentoMaximo.getText()));
        this.inversor.setRendimentoNacional(Utilitarios.ConverteTextoEmDouble(txtRendimentoNacional.getText()));
        this.inversor.setUccMaxEntradaA(Utilitarios.ConverteTextoEmDouble(txtUccMaxEntradaAC.getText()));
        this.inversor.setValorVenda(Utilitarios.ConverteTextoEmDouble(txtValorVenda.getText()));
        this.inversor.setTipoSaidaAC((Enumeradors.TipoSaidaAC) cmbxTipoSaidaAC.getSelectedItem());
        this.inversor.setStatus((Status) cmbxStatus.getSelectedItem());
    }
}