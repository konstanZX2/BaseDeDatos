package ejemplos;

import java.sql.*;

public class A {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        String url = "jdbc:postgresql://89.36.214.106:5432/geo";
        String usuari = "geo";
        String password = "geo";

        Connection con = DriverManager.getConnection(url, usuari, password);

        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select comarques.nom_c, provincia,count(cod_m)"+
                " from comarques inner join poblacions p using (nom_c)"+
                "group by 1,2 "+
                "order by 1");
        while (rs.next()) {
            System.out.print(rs.getString(1) + " (");
            System.out.println(rs.getString(2)+ "):\t");
            System.out.println(rs.getString(3) );
        }
        st.close();

        con.close();
    }
}
