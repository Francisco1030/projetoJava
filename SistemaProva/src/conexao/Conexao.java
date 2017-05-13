package conexao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Conexao {    
    String driver = "com.mysql.jdbc.Driver";
    String url;
    PreparedStatement stmt;
    Connection con;
  //  public ResultSet rs;
    String ip;
    String Banco;
    String porta;
    String usuario;
    String senha;
    public Connection getConnection(){
        try {
            url= "jdbc:mysql://";
            BufferedReader ler = new BufferedReader(new FileReader("Configurações/Config.cfg"));
            ip = ler.readLine();
            Banco = ler.readLine();
            porta = ler.readLine();
            usuario = ler.readLine();
            senha = ler.readLine();
            ler.close();
            url = url+ip+":"+porta+"/"+Banco;
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url, usuario, senha);
            
            //JOptionPane.showMessageDialog(null, "Banco conectado!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o Banco de dados");
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }




    }
        
    
    

