package utils;

import connection.DataConnection;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import model.bean.Usuario;

public class Utilitarios {

    public static void MsgExcecao(String pExcecao) {
        JOptionPane.showMessageDialog(null, pExcecao, "<<< ATENÇÃO! >>>", 0);
    }

    public static void MsgSucesso() {
        JOptionPane.showMessageDialog(null, "Gravado com sucesso!", "<<< Execução concluída >>>", 1);
    }

    public static void MsgExclusao() {
        JOptionPane.showMessageDialog(null, "Excluído com sucesso!", "<<< Execução concluída >>>", 1);
    }

    public static void MsgExclamacao() {
        JOptionPane.showMessageDialog(null, "Objeto não existente!", "<<<Null>>>", 2);
    }

    public static void HabilitaCampos(Object[] pObj, boolean b) {
        for (Object o : pObj) {
            if (o.getClass() == JTextField.class) {
                ((Component) o).setEnabled(b);
            } else if (o.getClass() == JPanel.class) {
                ((Component) o).setEnabled(b);
            } else if (o.getClass() == JFormattedTextField.class) {
                ((Component) o).setEnabled(b);
            } else if (o.getClass() == JComboBox.class) {
                ((Component) o).setEnabled(b);
            } else if (o.getClass() == JLabel.class) {
                ((Component) o).setEnabled(b);
            }
        }
    }

    public static double ConverteTextoEmDouble(String txt) {
        return txt.trim().length() > 0
                ? Double.parseDouble(txt.replace(".", "").replace(",", "."))
                : 0;
    }

    /**
     * Converte parâmetro txt, retirando ponto(.) e vírgula(,)
     *
     * @param txt texto a ser convertido
     * @return retorna inteiro.
     */
    public static int ConverteTextoEmInteiro(String txt) {
        try {
            return txt.trim().length() > 0
                    ? Integer.parseInt(txt.replace(".", "").replace(",", "."))
                    : 0;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Erro ao tentar converter (" + txt + ") em número!\r\n\r\n" + e, "Converion ERROR", 2);
            return 0;
        }
    }

    public static java.sql.Date ConverteStringParaData(String pData, String pFormatoOpcional) throws Exception {
        java.sql.Date date = null;
        if (pData == null || pData.equals("")) {
            return null;
        } else {
            try {
                DateFormat formatter = new SimpleDateFormat(pFormatoOpcional != null ? pFormatoOpcional : "dd/MM/yyyy");
                date = (java.sql.Date) formatter.parse(pData);
            } catch (ParseException e) {
                JOptionPane.showMessageDialog(null, "erro:\n " + e);
                throw e;
            }
        }
        return date;
    }

    public static String ConverteDataParaString(Date pDate, String pFormatoOpcional) {
        String Retorno = "";
        if (pDate != null) {
            /*SimpleDateFormat*/ DateFormat formato = new SimpleDateFormat(pFormatoOpcional != null ? pFormatoOpcional : "dd/MM/yyyy");
            Retorno = formato.format(pDate);
        }
        return Retorno;
    }

    public static void FormataComponenteData(String dth, JFormattedTextField ftf, JTextField tf) {
        if ((dth.length() == 2) || (dth.length() == 5)) {
            if (ftf != null) {
                ftf.setText(dth + "/");
            }
            if (tf != null) {
                tf.setText(dth + "/");
            }
        }
    }

    public static void RePosicionaBotoes(JButton[] botoes_, JPanel pnlOwnerOfBotoes, int comprimentoBotao) {

        /* << BEGIN >>*/
 /* Testa se parent container do botao é o mesmo owner passado nos argumentos */
        int x_ = 0;
        for (JButton botoes_1 : botoes_) {
            if (botoes_1.getParent().equals(pnlOwnerOfBotoes)) {
                x_++;
            }
        }

        JButton[] botoes = new JButton[x_];
        int z_ = 0;
        for (int i = 0; i < x_; i++) {
            if (botoes_[i].getParent().equals(pnlOwnerOfBotoes)) {
                botoes[z_++] = botoes_[i];
            }
        }
        /* << END >> */

        int altura = (int) (pnlOwnerOfBotoes.getBounds().getHeight() * 0.35);
        int YPoint = (int) ((pnlOwnerOfBotoes.getBounds().getHeight() - altura) / 2);

        int espaco = (int) ((pnlOwnerOfBotoes.getBounds().getWidth() - (botoes.length * comprimentoBotao)) / (botoes.length + 1));
        pnlOwnerOfBotoes.setSize((int) pnlOwnerOfBotoes.getSize().getHeight(), (int) pnlOwnerOfBotoes.getSize().getWidth());
        for (int oL = 0; oL < botoes.length; oL++) {
            pnlOwnerOfBotoes.remove(botoes[oL]);
            int x = (espaco * (oL + 1)) + (comprimentoBotao * oL);
            int y = YPoint;
            int w = comprimentoBotao;
            int h = altura;
            botoes[oL].setBounds(x, y, w, h);
            pnlOwnerOfBotoes.add(botoes[oL]);
        }

        new IconManager().SetIcon(botoes_);
    }

    /**
     *
     * Usar este método
     *
     * @param Botoes
     * @param Painel
     * @param WidthBotoes
     * @param AtribuiIcones
     */
    public static void RePosicionaBotoes(JButton[] Botoes, JPanel Painel, int WidthBotoes, boolean AtribuiIcones) {
        int MedidaX = (int) ((Painel.getWidth() - (Botoes.length * WidthBotoes)) / (Botoes.length + 1));
        for (int i = 0; i < Botoes.length; i++) {
            Painel.remove(Botoes[i]);
            Botoes[i].setBounds(
                    ((MedidaX + WidthBotoes) * i) + MedidaX,
                    Botoes[i].getY(),
                    WidthBotoes,
                    Botoes[i].getHeight()
            );
            Painel.add(Botoes[i]);
        }

        if (AtribuiIcones) {
            new IconManager().SetaIcones(Botoes);
        }
    }

    public static void ConfiguraJTable(JTable tableComp, Object[][] tuplas, String[] colunas, Class[] tipos, boolean[] canEditColumns, boolean mostrarGrade_LinhasColunas) {
        tableComp.setModel(new javax.swing.table.DefaultTableModel(tuplas, colunas) {
            @Override
            public Class getColumnClass(int columnIndex) {
                return tipos[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEditColumns[columnIndex];
            }
        });
        tableComp.setAutoCreateRowSorter(true);
        tableComp.setShowGrid(mostrarGrade_LinhasColunas);

        tableComp.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        for (int i = 0; i < tableComp.getColumnCount(); i++) {
            if (tableComp.getColumnName(i).toUpperCase().equals("ID")) {
                tableComp.getColumnModel().getColumn(i).setPreferredWidth(45);
            } else if (tableComp.getColumnName(i).toUpperCase().equals(("Status").toUpperCase())) {
                tableComp.getColumnModel().getColumn(i).setPreferredWidth(55);
            } else if (tableComp.getColumnName(i).equals("DataCadastro") || tableComp.getColumnName(i).equals("DataUltimaAlteracao")) {
                tableComp.getColumnModel().getColumn(i).setPreferredWidth(125);
            } else if (tipos[i] == java.lang.String.class || tipos[i] == String.class) {
                tableComp.getColumnModel().getColumn(i).setPreferredWidth(155);
            }
            tableComp.getColumnModel().getColumn(i).setResizable(true);
        }
    }

    public static void ExcluirObjetos(int pId, Class ObjetoClasse) {
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = DataConnection.getConnection();
            stmt = con.prepareStatement("delete from " + ObjetoClasse.getSimpleName() + " where Id = ?");
            stmt.setInt(1, pId);
            stmt.executeUpdate();
            Utilitarios.MsgExclusao();
        } catch (SQLException e) {
            Utilitarios.MsgExcecao(e.getMessage());
        } finally {
            DataConnection.closeConnection(con, stmt);
        }
    }

    public static void SetItemSelectedComboBox(JComboBox[] cmbx, String[] strValue) {
        if (cmbx.length == strValue.length) {
            for (int z = 0; z < cmbx.length; z++) {
                for (int i = 0; i < cmbx[z].getItemCount(); i++) {
                    cmbx[z].setSelectedIndex(i);
                    if (cmbx[z].getSelectedItem().toString().equals(strValue[z])) {
                        cmbx[z].setSelectedIndex(i);
                        break;
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    "Número de parâmetro não pode ser diferente.\r\ncmbx(" + cmbx.length + ") != strValue(" + strValue.length + ")",
                    "Inconsistência",
                    2
            );
        }
    }

    public static int RetornaApenasNumeroInteiro(String str) {
        String[] RangeNumber = ("0,1,2,3,4,5,6,7,8,9").split(",");
        String Resultado = "";
        for (int i = 0; i < str.length(); i++) {
            for (String rn : RangeNumber) {
                if (String.valueOf(str.subSequence(i, i + 1)).equals(rn)) {
                    Resultado += String.valueOf(str.subSequence(i, i + 1));
                }
            }
        }
        Resultado = Resultado.trim().length() > 0 ? Resultado : "0";
        return Integer.parseInt(Resultado);
    }

    public java.util.Date ConverteTexto_UtilDate(String pData, Enumeradors.TiposMascarados pMascara) {
        System.out.println(pData.substring(1, 1));
        return new Date();
    }

    public static String RetornaApenasCaracteresNumericos(String str_) {
        String resultado = "";
        String[] sNumeros = "0,1,2,3,4,5,6,7,8,9".split(",");
        for (int a = 0; a < str_.length(); a++) {
            for (String sNumero : sNumeros) {
                resultado += str_.substring(a, a + 1).equals(sNumero) ? str_.substring(a, a + 1) : "";
            }
        }
        return resultado;
    }

    public boolean HabilitaJMenu(Usuario.PerfilGrupo[] pgCanView, Usuario.PerfilGrupo pgCurrent, JMenu mn) {
        boolean retorno = false;
        for (Usuario.PerfilGrupo pgCanView_Iteracao : pgCanView) {
//            System.out.println(pgCurrent.toString() + " == " + pgCanView_Iteracao.toString());
            if (pgCurrent == pgCanView_Iteracao) {
                retorno = true;
                break;
            }
        }
        return retorno;
    }
}
