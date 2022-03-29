package ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class consultaPostgreSQL {

    public static void main(String[] args) throws ClassNotFoundException, SQLException  {
        String url = "jdbc:postgresql://89.36.214.106:5432/geo";
        String usuari = "geo";
        String password = "geo";

        Connection con = DriverManager.getConnection(url, usuari, password);
        
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM instituts where provincia = 'Castello' order by 1");
        while (rs.next()){
            System.out.print(rs.getInt(1) + "\t");
            System.out.println(rs.getString(2));
        }
        st.close();
   
        con.close();
    }
}