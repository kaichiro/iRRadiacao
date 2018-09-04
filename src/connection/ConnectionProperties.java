package connection;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Classe responsável por gerenciar o arquivo de configuraçãode conexão a base
 * de dados.
 */
public class ConnectionProperties {

    private String host;
    private String port;
    private String nameDB;
    private String user;
    private String password;

    public ConnectionProperties() {
//        this.SettersOLD();
        this.Setters();
    }

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getNameDB() {
        return nameDB;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "ConnectionProperties{" + "host=" + host + ", port=" + port + ", nameDB=" + nameDB + ", user=" + user + ", password=" + password + '}';
    }
//    private void SettersOLD() {
//        Properties prop = new Properties();
//        try {
//            FileInputStream file = new FileInputStream("cnx.config");
//            prop.load(file);
//            this.host = prop.getProperty("prop.server.host");
//            this.port = prop.getProperty("prop.server.port");
//            this.nameDB = prop.getProperty("prop.server.nameDB");
//            this.user = prop.getProperty("prop.server.user");
//            this.password = prop.getProperty("prop.server.password");
//        } catch (IOException ex) {
//            Logger.getLogger(ConnectionProperties.class.getName()).log(Level.SEVERE, null, ex);
//            JOptionPane.showMessageDialog(null, ex);
//        }
//    }

    /**
     * Método responsável por atribuir valores para atributos de conexão a base
     * de dados
     */
    private void Setters() {
        File fl = new File("cnx.config");
        if (!fl.exists()) {
            try {
                // Cria o arquivo de configuração caso não existir
                fl.createNewFile();
                System.out.println("criando arquivo de configuração");
            } catch (IOException ex) {
                Logger.getLogger(ConnectionProperties.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Erro ao tentar criar arquivo: " + ex);
            }
        }

//        FileInputStream fis = null;
        try {
            FileInputStream fis = new FileInputStream(fl);
            Properties prop = new Properties();
            prop.load(fis);

            String[] ParamsList = new String[]{
                "prop.server.host",
                "prop.server.port",
                "prop.server.nameDB",
                "prop.server.user",
                "prop.server.password"
            };

            for (String ParamsList1 : ParamsList) {
                if (!prop.toString().contains(ParamsList1)) {
                    ConnectionProperties.SetPropertieValue(prop, ParamsList1);
                } else if (prop.getProperty(ParamsList1).length() == 0) {
                    ConnectionProperties.SetPropertieValue(prop, ParamsList1);
                }
            }

            this.host = prop.getProperty("prop.server.host");
            this.port = prop.getProperty("prop.server.port");
            this.nameDB = prop.getProperty("prop.server.nameDB");
            this.user = prop.getProperty("prop.server.user");
            this.password = prop.getProperty("prop.server.password");

            prop.store(new FileOutputStream(fl), null);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(ConnectionProperties.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Erro ao tentar localizar arquivo de propriedades: " + ex);
        } catch (IOException ex) {
            Logger.getLogger(ConnectionProperties.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("error IO: " + ex);
        }
    }

    /**
     * ?Método que cria valores de parâmetros, caso eles não existam ou não
     * possuam valores.
     */
    private static void SetPropertieValue(Properties prop, String ParamsList1) {
        prop.setProperty(ParamsList1,
                JOptionPane.showInputDialog(
                        null,
                        "Informe um valor para (" + ParamsList1 + ")",
                        "Parâmetros do sistema",
                        JOptionPane.INFORMATION_MESSAGE
                )
        );
    }

}
