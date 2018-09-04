package tests;

import java.awt.BorderLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TestandoJComboBox extends JFrame {

    private JComboBox nomes;
    private DefaultComboBoxModel nomesModel;

    public TestandoJComboBox() {
        super("JListExample");
        nomesModel = new DefaultComboBoxModel();
        nomes = new JComboBox(nomesModel);
    }

    public void init() {
        setSize(300, 200);
        setLocation(300, 200);

        nomesModel.addElement("elemnto 1 a");
        nomesModel.addElement("elemento 2 b");
        nomesModel.addElement("kaichiro");

        nomes.setEditable(true);

        JPanel auxNomes = new JPanel();
        auxNomes.add(nomes);

        getContentPane().add(auxNomes, BorderLayout.CENTER);
        getContentPane().add(new JLabel("escolha um elemento"), BorderLayout.NORTH);

        setVisible(true);
    }

    public static void main(String[] abc123) {
        new TestandoJComboBox().init();
    }
}
