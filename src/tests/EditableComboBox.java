package tests;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.ComboBoxEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class EditableComboBox extends JPanel {

    private BookEntry books[] = {
        new BookEntry("Ant: The Definitive Guide", "covers/ant.gif"),
        new BookEntry("Database Programming with JDBC and Java",
        "covers/jdbc.gif"),
        new BookEntry("Developing Java Beans", "covers/beans.gif"),
        new BookEntry("Developing JSP Custom Tag Libraries",
        "covers/jsptl.gif"),
        new BookEntry("Java 2D Graphics", "covers/java2d.gif"),
        new BookEntry("Java and XML", "covers/jxml.gif"),
        new BookEntry("Java and XSLT", "covers/jxslt.gif"),
        new BookEntry("Java and SOAP", "covers/jsoap.gif"),
        new BookEntry("Java and XML Data Binding", "covers/jxmldb.gif"),
        new BookEntry("Java Cookbook", "covers/jcook.gif"),
        new BookEntry("Java Cryptography", "covers/jcrypto.gif"),
        new BookEntry("Java Distributed Computing", "covers/jdist.gif"),
        new BookEntry("Java I/O", "covers/javaio.gif"),
        new BookEntry("Java in a Nutshell", "covers/javanut.gif"),
        new BookEntry("Java Management Extensions", "covers/jmx.gif"),
        new BookEntry("Java Message Service", "covers/jms.gif"),
        new BookEntry("Java Network Programming", "covers/jnetp.gif"),
        new BookEntry("Java Performance Tuning", "covers/jperf.gif"),
        new BookEntry("Java RMI", "covers/jrmi.gif"),
        new BookEntry("Java Security", "covers/jsec.gif"),
        new BookEntry("JavaServer Pages", "covers/jsp.gif"),
        new BookEntry("Java Servlet Programming", "covers/servlet.gif"),
        new BookEntry("Java Swing", "covers/swing.gif"),
        new BookEntry("Java Threads", "covers/jthread.gif"),
        new BookEntry("Java Web Services", "covers/jws.gif"),
        new BookEntry("Learning Java", "covers/learnj.gif")};

    Map bookMap = new HashMap();

    public EditableComboBox() {
        // Build a mapping from book titles to their entries
        for (int i = 0; i < books.length; i++) {
            bookMap.put(books[i].getTitle(), books[i]);
        }

        setLayout(new BorderLayout());

        JComboBox bookCombo = new JComboBox(books);
        bookCombo.setEditable(true);
        bookCombo.setEditor(new ComboBoxEditorExample(bookMap, books[0]));
        bookCombo.setMaximumRowCount(4);
        bookCombo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("You chose "
                        + ((JComboBox) e.getSource()).getSelectedItem() + "!");
            }
        });
        bookCombo.setActionCommand("Hello");
        add(bookCombo, BorderLayout.CENTER);
    }

    public static void main(String s[]) {
        JFrame frame = new JFrame("Combo Box Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new EditableComboBox());
        frame.pack();
        frame.setVisible(true);
    }
}

class BookEntry {

    private final String title;

    private final String imagePath;

    private ImageIcon image;

    public BookEntry(String title, String imagePath) {
        this.title = title;
        this.imagePath = imagePath;
    }

    public String getTitle() {
        return title;
    }

    public ImageIcon getImage() {
        if (image == null) {
            image = new ImageIcon(imagePath);
        }
        return image;
    }

    // Override standard toString method to give a useful result
    public String toString() {
        return title;
    }
}

class ComboBoxEditorExample implements ComboBoxEditor {

    Map map;

    ImagePanel panel;

    ImageIcon questionIcon;

    public ComboBoxEditorExample(Map m, BookEntry defaultChoice) {
        map = m;
        panel = new ImagePanel(defaultChoice);
        questionIcon = new ImageIcon("question.gif");
    }

    public void setItem(Object anObject) {
        if (anObject != null) {
            panel.setText(anObject.toString());
            BookEntry entry = (BookEntry) map.get(anObject.toString());
            if (entry != null) {
                panel.setIcon(entry.getImage());
            } else {
                panel.setIcon(questionIcon);
            }
        }
    }

    public Component getEditorComponent() {
        return panel;
    }

    public Object getItem() {
        return panel.getText();
    }

    public void selectAll() {
        panel.selectAll();
    }

    public void addActionListener(ActionListener l) {
        panel.addActionListener(l);
    }

    public void removeActionListener(ActionListener l) {
        panel.removeActionListener(l);
    }

    //  We create our own inner class to handle setting and
    //  repainting the image and the text.
    class ImagePanel extends JPanel {

        JLabel imageIconLabel;

        JTextField textField;

        public ImagePanel(BookEntry initialEntry) {
            setLayout(new BorderLayout());

            imageIconLabel = new JLabel(initialEntry.getImage());
            imageIconLabel.setBorder(new BevelBorder(BevelBorder.RAISED));

            textField = new JTextField(initialEntry.getTitle());
            textField.setColumns(45);
            textField.setBorder(new BevelBorder(BevelBorder.LOWERED));

            add(imageIconLabel, BorderLayout.WEST);
            add(textField, BorderLayout.EAST);
        }

        public void setText(String s) {
            textField.setText(s);
        }

        public String getText() {
            return (textField.getText());
        }

        public void setIcon(Icon i) {
            imageIconLabel.setIcon(i);
            repaint();
        }

        public void selectAll() {
            textField.selectAll();
        }

        public void addActionListener(ActionListener l) {
            textField.addActionListener(l);
        }

        public void removeActionListener(ActionListener l) {
            textField.removeActionListener(l);
        }
    }
}
