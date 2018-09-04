package utils;

import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenuItem;

public class IconManager {

    private static final String ICON_NOVO = "/image/novo.png";
    private static final String ICON_PESQUISAR = "/image/procurar.1.png";

//    public static final String ICON_DATABASE_PLUS_SAVE = "/image/ícones/database_save.png";
//    public static final String ICON_DISKET = "/image/ícones/disk.png";
//    public static final String ICON_PAGE_PLUS_SAVE = "/image/ícones/page_save.png";
//    public static final String ICON_NEW_PAGE = "/image/ícones/page.png";
//    public static final String ICON_NEW_PAGE_PLUS_ADD = "/image/ícones/page_add.png";
//    public static final String ICON_NEW_EMPTY_PAGE = "/image/novo.png";
//    public static final String ICON_CANCEL = "/image/ícones/cancel.png";
//    private final URL ICON_DATABASE_PLUS_SAVE_ = getClass().getResource("/image/ícones/database_save.png");
    public final javax.swing.ImageIcon ICON_DATABASE_PLUS_SAVE = new javax.swing.ImageIcon(getClass().getResource("/image/ícones/database_save.png"));
    public final javax.swing.ImageIcon ICON_DISKET = new javax.swing.ImageIcon(getClass().getResource("/image/ícones/disk.png"));
    public final javax.swing.ImageIcon ICON_PAGE_PLUS_SAVE = new javax.swing.ImageIcon(getClass().getResource("/image/ícones/page_save.png"));
    public final javax.swing.ImageIcon ICON_NEW_PAGE = new javax.swing.ImageIcon(getClass().getResource("/image/ícones/page.png"));
    public final javax.swing.ImageIcon ICON_NEW_PAGE_PLUS_ADD = new javax.swing.ImageIcon(getClass().getResource("/image/ícones/page_add.png"));
    public final javax.swing.ImageIcon ICON_NEW_EMPTY_PAGE = new javax.swing.ImageIcon(getClass().getResource("/image/novo.png"));
    public final javax.swing.ImageIcon ICON_CANCEL = new javax.swing.ImageIcon(getClass().getResource("/image/ícones/cancel.png"));
    public final javax.swing.ImageIcon ICON_DELETE = new javax.swing.ImageIcon(getClass().getResource("/image/ícones/delete.png"));
    public final javax.swing.ImageIcon ICON_PESQUISAR_ = new javax.swing.ImageIcon(getClass().getResource("/image/ícones/Search.18px.png"));

    /**
     *
     * Método reponsável por setar ícones em botões. A quantidade de elementos
     * do array Icones deve ser a mesma quantidade de um dos arrays (Botoes,
     * ItensDeMenus).
     *
     * @param Icones array de ImageIcon (fields desta classe)
     * @param Botoes array de JButton
     * @param ItensDeMenus array de JMenuItem
     */
    public void SetaIcones(ImageIcon[] Icones, JButton[] Botoes, JMenuItem[] ItensDeMenus) {
        /* Cria um array {quantidade de ícones, quantidade de botões, quantidade de itens de menús} */
        int[] ComprimentosArrays = new int[]{Icones.length, Botoes.length, ItensDeMenus.length};

        /* Testa igualdades entre quantidades de ícones de botões, se sim, faz iteração atribuindo ícones */
        if (Botoes != null) {
            if (ComprimentosArrays[0] == ComprimentosArrays[1]) {
                for (int i = 0; i < ComprimentosArrays[0]; i++) {
                    Botoes[i].setIcon(Icones[i]);
                }
            }
        }

        /* Testa igualdades entre quantidades de ícones de itens de menús, se sim, faz iteração atribuindo ícones */
        if (ItensDeMenus != null) {
            if (ComprimentosArrays[0] == ComprimentosArrays[2]) {
                for (int i = 0; i < ComprimentosArrays[0]; i++) {
                    ItensDeMenus[i].setIcon(Icones[i]);
                }
            }
        }
    }

    /**
     *
     * Método reponsável por setar ícones em botões, de acordo com o Text do
     * Botão.
     *
     * @param Botoes array de JButton
     */
    public void SetaIcones(JButton[] Botoes) {
        for (JButton botao : Botoes) {
            switch (botao.getText()) {
                case "Gravar":
                    botao.setIcon(ICON_DISKET);
                    botao.setMnemonic(KeyEvent.VK_G);
                    break;
                case "Cancelar":
                case "Fechar":
                    botao.setIcon(ICON_CANCEL);
                    botao.setMnemonic(KeyEvent.VK_C);
                    break;
                default:
                    if (botao.getText().startsWith("Adicion") || botao.getText().startsWith("Inclui")) {
                        botao.setIcon(ICON_NEW_PAGE_PLUS_ADD);
                        botao.setMnemonic(KeyEvent.VK_A);
                    } else if (botao.getText().startsWith("Remove")) {
                        botao.setIcon(ICON_DELETE);
                        botao.setMnemonic(KeyEvent.VK_R);
                    } else if (botao.getText().startsWith("Grav")) {
                        botao.setIcon(ICON_DISKET);
                        botao.setMnemonic(KeyEvent.VK_G);
                    } else if (botao.getText().startsWith("Busca")) {
                        botao.setIcon(ICON_PESQUISAR_);
                        botao.setMnemonic(KeyEvent.VK_B);
                    }
            }

//            if (botao.getText().equals("Gravar")) {
//                botao.setIcon(ICON_DISKET);
//            } else if (botao.getText().equals("Cancelar") || botao.getText().equals("Fechar")) {
//                botao.setIcon(ICON_CANCEL);
//            } else if (botao.getText().startsWith("Adicion")) {
//                botao.setIcon(ICON_NEW_PAGE_PLUS_ADD);
//            } else if (botao.getText().startsWith("Remove")) {
//                botao.setIcon(ICON_DELETE);
//            }
        }
    }

    /**
     * @param MenuItem
     * @param ICON
     */
    public void SetIcon(JMenuItem[] MenuItem, String ICON) {
        for (JMenuItem mni1 : MenuItem) {
            mni1.setIcon(new javax.swing.ImageIcon(getClass().getResource(ICON)));
        }
    }

    /**
     * @param botoes
     * @param ICON
     */
    public void SetIcon(JButton[] botoes, String ICON) {
        for (JButton btn : botoes) {
            btn.setIcon(new javax.swing.ImageIcon(getClass().getResource(ICON)));
        }
    }

    public void SetIcon(JButton[] botoes) {
        for (JButton btn : botoes) {
            switch (btn.getText()) {
                case "Novo":
                    btn.setIcon(new ImageIcon(getClass().getResource(ICON_NOVO)));
                    break;
                case "Pesquisar":
                case "Localizar":
                    btn.setIcon(new ImageIcon(getClass().getResource(ICON_PESQUISAR)));
                    break;
                default:
                    break;
            }
        }
    }

}
