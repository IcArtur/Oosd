package application.java.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	private Connection connection;
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
	
//   Costruttore per istanze DAO, utile per non riscrivere le variabili
//   di collegamento al DB
	public DAO() {
        this.jdbcURL = "jdbc:mysql://localhost:3306/autonoleggio?useSSL=false";
        this.jdbcUsername = "root";
        this.jdbcPassword = "";
    }
//	Metodo per connettersi al database ereditato da tutte le sottoclassi
	public Connection connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            jdbcConnection = DriverManager.getConnection(
                                        jdbcURL, jdbcUsername, jdbcPassword);
        }
        return jdbcConnection;
    }
//	Metodo per disconnettersi al database ereditato da tutte le sottoclassi
	public void disconnect(Connection jdbcConnection) throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

}
