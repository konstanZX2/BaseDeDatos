package ejemplos;

public class cargaControladores {


    public static void main(String[] args) throws ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");
        Class.forName("org.sqlite.JDBC");
        System.out.println("Ja s'ha carregat el controlador");
    }

}
