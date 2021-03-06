package view;

import controller.InversorCTRL;
import controller.StatusCTRL;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import model.bean.Inversor;
import model.bean.Status;
import utils.IconManager;
import utils.Utilitarios;

/**
 *
 * @author KAI
 */
public class DlgInversorOLD extends javax.swing.JDialog {

    /**
     * Creates new form DlgInversorOld
     *
     * @param parent
     * @param modal
     */
    private Inversor inversor = new Inversor();
    private final List<Status> status = StatusCTRL.BuscaTodos();

    public DlgInversorOLD(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        initComponents();

        this.IniciaFuncionalidadesForm();
        setIcon();
    }
    
    private void setIcon (){
        this.setIconImage(new ImageIcon(getClass().getResource("/image/solar-energy.png")).getImage());
    }

    public Inversor getInversor() {
        return inversor;
    }

    public void setInversor(Inversor inversor) {
        this.inversor = inversor;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlMainInversor = new javax.swing.JPanel();
        pnlFuncoes = new javax.swing.JPanel();
        btnIncluir = new javax.swing.JButton();
        btnGravar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnPesquisar = new javax.swing.JButton();
        pnlId = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfId = new javax.swing.JTextField();
        pnlDataCadastro = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        dcDataCadastro = new com.toedter.calendar.JDateChooser();
        pnlDataUltimaAlteracao = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        dcDataUltimaAlteracao = new com.toedter.calendar.JDateChooser();
        pnlModelo = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tfModelo = new javax.swing.JTextField();
        pnlPotenciaWCA = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        ftfPotenciaWCA = new javax.swing.JFormattedTextField();
        pnlPotenciaMaxWCC = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        ftfPotenciaMaxWCC = new javax.swing.JFormattedTextField();
        pnlIccMaxEntradaA = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        ftfIccMaxEntradaA = new javax.swing.JFormattedTextField();
        pnlUccMaxEntradaA = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        ftfUccMaxEntradaA = new javax.swing.JFormattedTextField();
        pnlRendimentoNacional = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        ftfRendimentoNacional = new javax.swing.JFormattedTextField();
        pnlRendimentoMaximo = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        ftfRendimentoMaximo = new javax.swing.JFormattedTextField();
        pnlSaidaAC = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cmbxTipoSaidaAC = new javax.swing.JComboBox<>();
        pnlStatus = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        cmbxStatus = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Inversor");
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        pnlMainInversor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        pnlFuncoes.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlFuncoes.setPreferredSize(new java.awt.Dimension(414, 27));

        btnIncluir.setText("Incluir");
        btnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirActionPerformed(evt);
            }
        });

        btnGravar.setText("Gravar");
        btnGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGravarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnPesquisar.setText("Pesquisar");
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlFuncoesLayout = new javax.swing.GroupLayout(pnlFuncoes);
        pnlFuncoes.setLayout(pnlFuncoesLayout);
        pnlFuncoesLayout.setHorizontalGroup(
            pnlFuncoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFuncoesLayout.createSequentialGroup()
                .addComponent(btnIncluir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGravar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPesquisar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlFuncoesLayout.setVerticalGroup(
            pnlFuncoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlFuncoesLayout.createSequentialGroup()
                .addGroup(pnlFuncoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIncluir)
                    .addComponent(btnGravar)
                    .addComponent(btnCancelar)
                    .addComponent(btnPesquisar))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        pnlId.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Id:");

        tfId.setEnabled(false);

        javax.swing.GroupLayout pnlIdLayout = new javax.swing.GroupLayout(pnlId);
        pnlId.setLayout(pnlIdLayout);
        pnlIdLayout.setHorizontalGroup(
            pnlIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIdLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfId))
        );
        pnlIdLayout.setVerticalGroup(
            pnlIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIdLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(tfId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlDataCadastro.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel3.setText("Data Cadastro:");

        dcDataCadastro.setEnabled(false);

        javax.swing.GroupLayout pnlDataCadastroLayout = new javax.swing.GroupLayout(pnlDataCadastro);
        pnlDataCadastro.setLayout(pnlDataCadastroLayout);
        pnlDataCadastroLayout.setHorizontalGroup(
            pnlDataCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataCadastroLayout.createSequentialGroup()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlDataCadastroLayout.setVerticalGroup(
            pnlDataCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(pnlDataCadastroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(dcDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel3))
        );

        pnlDataUltimaAlteracao.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Data Última Alteração:");

        dcDataUltimaAlteracao.setEnabled(false);

        javax.swing.GroupLayout pnlDataUltimaAlteracaoLayout = new javax.swing.GroupLayout(pnlDataUltimaAlteracao);
        pnlDataUltimaAlteracao.setLayout(pnlDataUltimaAlteracaoLayout);
        pnlDataUltimaAlteracaoLayout.setHorizontalGroup(
            pnlDataUltimaAlteracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataUltimaAlteracaoLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dcDataUltimaAlteracao, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE))
        );
        pnlDataUltimaAlteracaoLayout.setVerticalGroup(
            pnlDataUltimaAlteracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDataUltimaAlteracaoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                .addComponent(jLabel4)
                .addComponent(dcDataUltimaAlteracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlModelo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel5.setText("Modelo:");

        javax.swing.GroupLayout pnlModeloLayout = new javax.swing.GroupLayout(pnlModelo);
        pnlModelo.setLayout(pnlModeloLayout);
        pnlModeloLayout.setHorizontalGroup(
            pnlModeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlModeloLayout.createSequentialGroup()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfModelo))
        );
        pnlModeloLayout.setVerticalGroup(
            pnlModeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlModeloLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5)
                .addComponent(tfModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlPotenciaWCA.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setText("Potência WCA:");

        ftfPotenciaWCA.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###"))));

        javax.swing.GroupLayout pnlPotenciaWCALayout = new javax.swing.GroupLayout(pnlPotenciaWCA);
        pnlPotenciaWCA.setLayout(pnlPotenciaWCALayout);
        pnlPotenciaWCALayout.setHorizontalGroup(
            pnlPotenciaWCALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPotenciaWCALayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ftfPotenciaWCA))
        );
        pnlPotenciaWCALayout.setVerticalGroup(
            pnlPotenciaWCALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPotenciaWCALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel6)
                .addComponent(ftfPotenciaWCA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlPotenciaMaxWCC.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel7.setText("Potência Máx. WCC:");

        ftfPotenciaMaxWCC.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###"))));

        javax.swing.GroupLayout pnlPotenciaMaxWCCLayout = new javax.swing.GroupLayout(pnlPotenciaMaxWCC);
        pnlPotenciaMaxWCC.setLayout(pnlPotenciaMaxWCCLayout);
        pnlPotenciaMaxWCCLayout.setHorizontalGroup(
            pnlPotenciaMaxWCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPotenciaMaxWCCLayout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ftfPotenciaMaxWCC))
        );
        pnlPotenciaMaxWCCLayout.setVerticalGroup(
            pnlPotenciaMaxWCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPotenciaMaxWCCLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel7)
                .addComponent(ftfPotenciaMaxWCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlIccMaxEntradaA.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel8.setText("ICC Máx. Entrada A:");

        ftfIccMaxEntradaA.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.000"))));

        javax.swing.GroupLayout pnlIccMaxEntradaALayout = new javax.swing.GroupLayout(pnlIccMaxEntradaA);
        pnlIccMaxEntradaA.setLayout(pnlIccMaxEntradaALayout);
        pnlIccMaxEntradaALayout.setHorizontalGroup(
            pnlIccMaxEntradaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIccMaxEntradaALayout.createSequentialGroup()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ftfIccMaxEntradaA))
        );
        pnlIccMaxEntradaALayout.setVerticalGroup(
            pnlIccMaxEntradaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIccMaxEntradaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel8)
                .addComponent(ftfIccMaxEntradaA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlUccMaxEntradaA.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel9.setText("UCC Máx. Entrada A:");

        ftfUccMaxEntradaA.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.000"))));

        javax.swing.GroupLayout pnlUccMaxEntradaALayout = new javax.swing.GroupLayout(pnlUccMaxEntradaA);
        pnlUccMaxEntradaA.setLayout(pnlUccMaxEntradaALayout);
        pnlUccMaxEntradaALayout.setHorizontalGroup(
            pnlUccMaxEntradaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUccMaxEntradaALayout.createSequentialGroup()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ftfUccMaxEntradaA, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlUccMaxEntradaALayout.setVerticalGroup(
            pnlUccMaxEntradaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlUccMaxEntradaALayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel9)
                .addComponent(ftfUccMaxEntradaA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlRendimentoNacional.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel10.setText("Rendimento Nacional:");

        ftfRendimentoNacional.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.000"))));

        javax.swing.GroupLayout pnlRendimentoNacionalLayout = new javax.swing.GroupLayout(pnlRendimentoNacional);
        pnlRendimentoNacional.setLayout(pnlRendimentoNacionalLayout);
        pnlRendimentoNacionalLayout.setHorizontalGroup(
            pnlRendimentoNacionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRendimentoNacionalLayout.createSequentialGroup()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ftfRendimentoNacional, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlRendimentoNacionalLayout.setVerticalGroup(
            pnlRendimentoNacionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRendimentoNacionalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel10)
                .addComponent(ftfRendimentoNacional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlRendimentoMaximo.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel11.setText("Rendimento Máximo:");

        ftfRendimentoMaximo.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#,###.000"))));

        javax.swing.GroupLayout pnlRendimentoMaximoLayout = new javax.swing.GroupLayout(pnlRendimentoMaximo);
        pnlRendimentoMaximo.setLayout(pnlRendimentoMaximoLayout);
        pnlRendimentoMaximoLayout.setHorizontalGroup(
            pnlRendimentoMaximoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRendimentoMaximoLayout.createSequentialGroup()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ftfRendimentoMaximo))
        );
        pnlRendimentoMaximoLayout.setVerticalGroup(
            pnlRendimentoMaximoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRendimentoMaximoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel11)
                .addComponent(ftfRendimentoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlSaidaAC.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel12.setText("Saída AC:");

        javax.swing.GroupLayout pnlSaidaACLayout = new javax.swing.GroupLayout(pnlSaidaAC);
        pnlSaidaAC.setLayout(pnlSaidaACLayout);
        pnlSaidaACLayout.setHorizontalGroup(
            pnlSaidaACLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSaidaACLayout.createSequentialGroup()
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbxTipoSaidaAC, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlSaidaACLayout.setVerticalGroup(
            pnlSaidaACLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlSaidaACLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel12)
                .addComponent(cmbxTipoSaidaAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlStatus.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel13.setText("Status:");

        cmbxStatus.setLightWeightPopupEnabled(false);

        javax.swing.GroupLayout pnlStatusLayout = new javax.swing.GroupLayout(pnlStatus);
        pnlStatus.setLayout(pnlStatusLayout);
        pnlStatusLayout.setHorizontalGroup(
            pnlStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatusLayout.createSequentialGroup()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlStatusLayout.setVerticalGroup(
            pnlStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlStatusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel13)
                .addComponent(cmbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout pnlMainInversorLayout = new javax.swing.GroupLayout(pnlMainInversor);
        pnlMainInversor.setLayout(pnlMainInversorLayout);
        pnlMainInversorLayout.setHorizontalGroup(
            pnlMainInversorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainInversorLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlMainInversorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlFuncoes, javax.swing.GroupLayout.DEFAULT_SIZE, 674, Short.MAX_VALUE)
                    .addGroup(pnlMainInversorLayout.createSequentialGroup()
                        .addGroup(pnlMainInversorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(pnlRendimentoNacional, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlIccMaxEntradaA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMainInversorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlRendimentoMaximo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlUccMaxEntradaA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlPotenciaWCA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMainInversorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pnlStatus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlSaidaAC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlPotenciaMaxWCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 1, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMainInversorLayout.createSequentialGroup()
                        .addComponent(pnlId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlDataUltimaAlteracao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlMainInversorLayout.setVerticalGroup(
            pnlMainInversorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMainInversorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFuncoes, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainInversorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlId, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDataUltimaAlteracao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDataCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainInversorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlPotenciaWCA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainInversorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlIccMaxEntradaA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlUccMaxEntradaA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlPotenciaMaxWCC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMainInversorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlRendimentoNacional, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlRendimentoMaximo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlSaidaAC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(pnlMainInversor);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirActionPerformed
    }//GEN-LAST:event_btnIncluirActionPerformed

    private void btnGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGravarActionPerformed
        this.PreencheAtributosDoInversorComInfosDosCampos();
        this.setInversor(
                this.inversor.IsNew()
                ? InversorCTRL.Novo(this.getInversor())
                : InversorCTRL.Atualiza(this.getInversor())
        );
        this.PreencheCamposComOjbInversor();
    }//GEN-LAST:event_btnGravarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed

    }//GEN-LAST:event_btnPesquisarActionPerformed

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
            java.util.logging.Logger.getLogger(DlgInversorOLD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            DlgInversorOLD dialog = new DlgInversorOLD(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGravar;
    private javax.swing.JButton btnIncluir;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JComboBox<model.bean.Status> cmbxStatus;
    private javax.swing.JComboBox<utils.Enumeradors.TipoSaidaAC> cmbxTipoSaidaAC;
    private com.toedter.calendar.JDateChooser dcDataCadastro;
    private com.toedter.calendar.JDateChooser dcDataUltimaAlteracao;
    private javax.swing.JFormattedTextField ftfIccMaxEntradaA;
    private javax.swing.JFormattedTextField ftfPotenciaMaxWCC;
    private javax.swing.JFormattedTextField ftfPotenciaWCA;
    private javax.swing.JFormattedTextField ftfRendimentoMaximo;
    private javax.swing.JFormattedTextField ftfRendimentoNacional;
    private javax.swing.JFormattedTextField ftfUccMaxEntradaA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel pnlDataCadastro;
    private javax.swing.JPanel pnlDataUltimaAlteracao;
    private javax.swing.JPanel pnlFuncoes;
    private javax.swing.JPanel pnlIccMaxEntradaA;
    private javax.swing.JPanel pnlId;
    private javax.swing.JPanel pnlMainInversor;
    private javax.swing.JPanel pnlModelo;
    private javax.swing.JPanel pnlPotenciaMaxWCC;
    private javax.swing.JPanel pnlPotenciaWCA;
    private javax.swing.JPanel pnlRendimentoMaximo;
    private javax.swing.JPanel pnlRendimentoNacional;
    private javax.swing.JPanel pnlSaidaAC;
    private javax.swing.JPanel pnlStatus;
    private javax.swing.JPanel pnlUccMaxEntradaA;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfModelo;
    // End of variables declaration//GEN-END:variables

    private void IniciaFuncionalidadesForm() {
        cmbxStatus.removeAllItems();
        this.status.forEach((Status s) -> {
            cmbxStatus.addItem(s);
        });

        cmbxTipoSaidaAC.removeAllItems();
//        for (Inversor.TipoSaidaAC tpSaidaAC : Inversor.TipoSaidaAC.values()) {
//            cmbxTipoSaidaAC.addItem(tpSaidaAC);
//        }

        utils.Utilitarios.RePosicionaBotoes(new JButton[]{btnIncluir, btnGravar, btnCancelar, btnPesquisar}, pnlFuncoes, 155);

        IconManager ic = new IconManager();
//        ic.SetIcon(new JButton[]{btnIncluir}, IconManager.ICON_NOVO());
//        ic.SetIcon(new JButton[]{btnPesquisar}, ic.getICON_PESQUISAR());

        dcDataCadastro.setDateFormatString("dd/MM/yyyy HH:mm:ss");
        dcDataUltimaAlteracao.setDateFormatString(dcDataCadastro.getDateFormatString());
    }

    private void PreencheAtributosDoInversorComInfosDosCampos() {
        System.out.println(ftfIccMaxEntradaA.getText());
        this.inversor.setIccMaxEntradaA(Utilitarios.ConverteTextoEmDouble(ftfIccMaxEntradaA.getText()));
        if (!this.inversor.IsNew()) {
            this.inversor.setId(Integer.parseInt(tfId.getText()));
        }
        this.inversor.setModelo(tfModelo.getText());
        this.inversor.setPotenciaMaxWCC(Integer.parseInt(ftfPotenciaMaxWCC.getText()));
        this.inversor.setPotenciaWCA(Integer.parseInt(ftfPotenciaWCA.getText()));
        this.inversor.setRendimentoMaximo(Utilitarios.ConverteTextoEmDouble(ftfRendimentoMaximo.getText()));
        this.inversor.setRendimentoNacional(Utilitarios.ConverteTextoEmDouble(ftfRendimentoNacional.getText()));
        this.inversor.setStatus((Status) cmbxStatus.getSelectedItem());
//        this.inversor.setTipoSaidaAC((Inversor.TipoSaidaAC) cmbxTipoSaidaAC.getSelectedItem());
        this.inversor.setUccMaxEntradaA(Utilitarios.ConverteTextoEmDouble(ftfUccMaxEntradaA.getText()));
    }

    private void PreencheCamposComOjbInversor() {
        ftfIccMaxEntradaA.setText(String.valueOf(this.inversor.getIccMaxEntradaA()));
        ftfPotenciaMaxWCC.setText(String.valueOf(this.inversor.getPotenciaMaxWCC()));
        ftfPotenciaWCA.setText(String.valueOf(this.inversor.getPotenciaWCA()));
        ftfRendimentoMaximo.setText(String.valueOf(this.inversor.getRendimentoMaximo()));
        ftfRendimentoNacional.setText(String.valueOf(this.inversor.getRendimentoNacional()));
        ftfUccMaxEntradaA.setText(String.valueOf(this.inversor.getUccMaxEntradaA()));

        tfId.setText(String.valueOf(this.inversor.getId()));
        tfModelo.setText(this.inversor.getModelo());

//        dcDataCadastro.setDate(this.inversor.getDataCadastro());
//        dcDataUltimaAlteracao.setDate(this.inversor.getDataUltimaAlteracao());
    }

}
