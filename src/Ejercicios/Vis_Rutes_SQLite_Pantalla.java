package Ejercicios;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class Vis_Rutes_SQLite_Pantalla extends JFrame implements ActionListener{
    
    JComboBox combo;
    JButton eixir = new JButton("Eixir");
    JTextArea area = new JTextArea();
    Connection con;
    
    public void iniciar() throws SQLException {
        // sentències per a fer la connexió
        String url = "jdbc:sqlite:Rutes.sqlite";
        con = DriverManager.getConnection(url);
        
        
        this.setBounds(100, 100, 450, 300);
        this.setLayout(new BorderLayout());
        
        JPanel panell1 = new JPanel(new FlowLayout());
        JPanel panell2 = new JPanel(new BorderLayout());
        this.add(panell1,BorderLayout.NORTH);
        this.add(panell2,BorderLayout.CENTER);
        
        ArrayList<String> llista_rutes = new ArrayList<String>();
        // sentències per a omplir l'ArrayList amb el nom de les rutes

        Statement st1 = con.createStatement();
        ResultSet rs1 = st1.executeQuery("SELECT * FROM RUTES");
        while (rs1.next()) {
            llista_rutes.add(rs1.getString(2));
        }
        
        
        combo = new JComboBox(llista_rutes.toArray());
        
        panell1.add(combo);
        panell1.add(eixir);
        
        panell2.add(new JLabel("LLista de punts de la ruta:"),BorderLayout.NORTH);
        panell2.add(area,BorderLayout.CENTER);
        
        this.setVisible(true);
        combo.addActionListener(this);
        eixir.addActionListener(this);
       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == combo){
            //accions quan s'ha seleccionat un element del combobox, i que han de consistir en omplir el JTextArea
            Integer ind = combo.getSelectedIndex() +1;
            System.out.println(ind);
            try {
                Statement st2 = con.createStatement();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        if (e.getSource() == eixir){
            //accions quan s'ha apretat el botó d'eixir
            try {
                con.close();
                System.exit(0);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}