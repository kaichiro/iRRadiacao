/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.StatusCTRL;
import controller.UsuarioCTRL;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import model.bean.Status;
import model.bean.Usuario;
import utils.Utilitarios;

/**
 *
 * @author KAI
 */
public class DlgUsuarioOLD extends javax.swing.JDialog {

    private Usuario usuario = new Usuario();
    private List<Usuario> usuarios = new ArrayList<>();
    private String fSenhaAtual = "";

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
//        this.fSenhaAtual = this.usuario.getSenha();
        this.PopulaComponentesComDadosDoUsuario();
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(/*List<Usuario> usuarios*/) {
        this.usuarios.removeAll(this.usuarios);

        this.usuarios = UsuarioCTRL.BuscarTodos();

        cmbxUsuarios.removeAllItems();
        this.usuarios.forEach((Usuario u) -> {
            cmbxUsuarios.addItem(u);
        });
    }

    /**
     * Creates new form DlgUsuario
     *
     * @param parent
     * @param modal
     */
    public DlgUsuarioOLD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();

        this.IniciaComponentes();
        
        setIcon();
    }
    
    private void setIcon (){
        this.setIconImage(new ImageIcon(getClass().getResource("/image/user.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMain = new javax.swing.JPanel();
        pnlPesquisa = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbxUsuarios = new javax.swing.JComboBox<>();
        pnlCampos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cmbxStatus = new javax.swing.JComboBox<>();
        txtSenhaAtual = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        txtRepetirNovaSenha = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        txtNovaSenha = new javax.swing.JPasswordField();
        pnlBotoes = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnGrava = new javax.swing.JButton();
        btnFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Usuário");
        setResizable(false);

        pnlMain.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pnlPesquisa.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Escolher para Editar:");

        cmbxUsuarios.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbxUsuariosItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout pnlPesquisaLayout = new javax.swing.GroupLayout(pnlPesquisa);
        pnlPesquisa.setLayout(pnlPesquisaLayout);
        pnlPesquisaLayout.setHorizontalGroup(
            pnlPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbxUsuarios, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlPesquisaLayout.setVerticalGroup(
            pnlPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPesquisaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlPesquisaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbxUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCampos.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setText("Id:");

        txtId.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtId.setEnabled(false);

        jLabel3.setText("Nome:");

        jLabel4.setText("Senha Atual:");

        jLabel5.setText("Login:");

        jLabel7.setText("Status:");

        jLabel6.setText("Repetir Nova Senha:");

        jLabel8.setText("Novo Senha:");

        javax.swing.GroupLayout pnlCamposLayout = new javax.swing.GroupLayout(pnlCampos);
        pnlCampos.setLayout(pnlCamposLayout);
        pnlCamposLayout.setHorizontalGroup(
            pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCamposLayout.createSequentialGroup()
                        .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                            .addComponent(txtId)
                            .addComponent(txtSenhaAtual))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNovaSenha)
                            .addGroup(pnlCamposLayout.createSequentialGroup()
                                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRepetirNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addComponent(txtNome))
                .addContainerGap())
        );

        pnlCamposLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel5});

        pnlCamposLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel4, jLabel7});

        pnlCamposLayout.setVerticalGroup(
            pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cmbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel8)
                        .addComponent(txtNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSenhaAtual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtRepetirNovaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlCamposLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cmbxStatus, jLabel2, jLabel3, jLabel4, jLabel5, jLabel6, jLabel7, jLabel8, txtId, txtLogin, txtNome, txtNovaSenha, txtRepetirNovaSenha, txtSenhaAtual});

        pnlBotoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setText("jButton1");

        btnNovo.setText("Novo");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnGrava.setText("Gravar");
        btnGrava.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravaActionPerformed(evt);
            }
        });

        btnFechar.setText("Fechar");
        btnFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFecharActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlBotoesLayout = new javax.swing.GroupLayout(pnlBotoes);
        pnlBotoes.setLayout(pnlBotoesLayout);
        pnlBotoesLayout.setHorizontalGroup(
            pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGrava)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnFechar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlBotoesLayout.setVerticalGroup(
            pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBotoesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlBotoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnNovo)
                    .addComponent(btnGrava)
                    .addComponent(btnFechar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlMainLayout = new javax.swing.GroupLayout(pnlMain);
        pnlMain.setLayout(pnlMainLayout);
        pnlMainLayout.setHorizontalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlMainLayout.createSequentialGroup()
                        .addGroup(pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pnlBotoes, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlCampos, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlMainLayout.setVerticalGroup(
            pnlMainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCampos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBotoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlMain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnGravaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravaActionPerformed
        this.fSenhaAtual = this.usuario.getSenha();
        
        this.PopulaObjUsuarioComDadosDosComponentes();

        boolean CanPersist = false, NovaSenhaOK = false;

        if (this.VerificarSeNovaSenhaForamPreenchidas()) {
            if (this.VerificaIgualdadeEmNovaSenhaERepetirNovaSenha()) {
                CanPersist = true;
                NovaSenhaOK = true;
            } else {
                CanPersist = false;
                NovaSenhaOK = false;
                Utilitarios.MsgExcecao("Campos (Nova Senha e Repetir Senha) foram preenchidos e estão com valores diferentes.\r\nPreencha-os com o mesmo valor ou Apague seus conteúdos");
            }
        } else {
            NovaSenhaOK = true;
        }

        if (this.fSenhaAtual.equals(this.usuario.getSenha())) {
            CanPersist = true;
        } else {
            CanPersist = false;
            Utilitarios.MsgExcecao("Senha Atual incorreta!");
        }

        if (CanPersist && NovaSenhaOK) {
            this.setUsuario(
                    this.usuario.getId() > 0
                    ? UsuarioCTRL.Atualiza(this.usuario)
                    : UsuarioCTRL.Novo(this.usuario)
            );
            this.setUsuarios();
        }

    }//GEN-LAST:event_btnGravaActionPerformed

    private void btnFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFecharActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnFecharActionPerformed

    private void cmbxUsuariosItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbxUsuariosItemStateChanged
        if (cmbxUsuarios.getItemCount() > 0) {
            this.setUsuario((Usuario) cmbxUsuarios.getSelectedItem());
        }
    }//GEN-LAST:event_cmbxUsuariosItemStateChanged

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        this.setUsuario(new Usuario());
    }//GEN-LAST:event_btnNovoActionPerformed

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
            java.util.logging.Logger.getLogger(DlgUsuarioOLD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            DlgUsuarioOLD dialog = new DlgUsuarioOLD(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnGrava;
    private javax.swing.JButton btnNovo;
    private javax.swing.JComboBox<Status> cmbxStatus;
    private javax.swing.JComboBox<model.bean.Usuario> cmbxUsuarios;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel pnlBotoes;
    private javax.swing.JPanel pnlCampos;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlPesquisa;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JPasswordField txtNovaSenha;
    private javax.swing.JPasswordField txtRepetirNovaSenha;
    private javax.swing.JPasswordField txtSenhaAtual;
    // End of variables declaration//GEN-END:variables

    private void IniciaComponentes() {
        Utilitarios.RePosicionaBotoes(new JButton[]{btnNovo, btnGrava, btnFechar}, pnlBotoes, 140);

        StatusCTRL.BuscaTodos().forEach((Status s) -> {
            cmbxStatus.addItem(s);
        });

//        this.PopulaCmbxUsuario();
        this.setUsuarios();

    }

    private void PopulaObjUsuarioComDadosDosComponentes() {
        if (txtId.getText().trim().length() > 0) {
            this.usuario.setId(Integer.parseInt(txtId.getText()));
        }
        this.usuario.setLogin(txtLogin.getText());
        this.usuario.setNome(txtNome.getText());
        // Sefoi preenchido campos NovaSenha e RepetirNovaSenha, a senha salva será a nova senha, se não, será salvo a senha atual
        this.usuario.setSenha(
                String.valueOf(txtNovaSenha.getPassword()).trim().length() > 0 && String.valueOf(txtRepetirNovaSenha.getPassword()).trim().length() > 0
                ? String.valueOf(txtNovaSenha.getPassword())
                : String.valueOf(txtSenhaAtual.getPassword())
        );
        this.usuario.setStatus((Status) cmbxStatus.getSelectedItem());
    }

    private void PopulaComponentesComDadosDoUsuario() {
        txtId.setText(String.valueOf(this.usuario.getId()));
        txtLogin.setText(this.usuario.getLogin());
        txtNome.setText(this.usuario.getNome());
        txtSenhaAtual.setText(this.usuario.getSenha());
        if (this.usuario.getId() == 0) {
            cmbxStatus.setSelectedIndex(0);
        } else {
            Utilitarios.SetItemSelectedComboBox(new JComboBox[]{cmbxStatus}, new String[]{this.usuario.getStatus().getDescricao()});
        }
    }

    private boolean VerificaIgualdadeEmNovaSenhaERepetirNovaSenha() {
        String pNovaSenha = String.valueOf(txtNovaSenha.getPassword());
        String pRepetirNovaSenha = String.valueOf(txtRepetirNovaSenha.getPassword());
        return pNovaSenha.equals(pRepetirNovaSenha);
    }

    private boolean VerificarSeNovaSenhaForamPreenchidas() {
        String pNovaSenha = String.valueOf(txtNovaSenha.getPassword());
        String pRepetirNovaSenha = String.valueOf(txtRepetirNovaSenha.getPassword());
        return (pNovaSenha.trim().length() + pRepetirNovaSenha.trim().length()) > 0;
    }
}
