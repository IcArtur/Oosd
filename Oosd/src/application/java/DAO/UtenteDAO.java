package application.java.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.java.models.Utente;
import java.sql.Connection;

public class UtenteDAO extends DAO {
	
	public Utente login(Utente utente) throws SQLException {
	    	
	    String sql = "select * from utenti where username=? and password=? ";
		
	    Connection jdbcConnection = connect();
	     
	    PreparedStatement statement = jdbcConnection.prepareStatement(sql);
	    statement.setString(1, utente.getUsername());
	    statement.setString(2, utente.getPassword());
	    ResultSet resultSet = statement.executeQuery();
	     
	    if (resultSet.next()) {
	    	int pk = resultSet.getInt("pk");
	    	String username = resultSet.getString("username");
	    	String password = resultSet.getString("password");
	    	String nome = resultSet.getString("nome");
	    	String cognome = resultSet.getString("cognome");
	        String email = resultSet.getString("email");
	        String codiceFiscale = resultSet.getString("codice_fiscale");
	        int isAdminInt = resultSet.getInt("is_admin");
	        boolean isAdmin;
	        if (isAdminInt == 1) {
	        	isAdmin = true;
	        }
	        else {
	        	isAdmin = false;
	        }
	        int isOperatorInt = resultSet.getInt("is_operator");
	        boolean isOperator;
	        if (isOperatorInt == 1) {
	        	isOperator = true;
	        }
	        else {
	        	isOperator = false;
	        }
	
	        utente = new  Utente(pk, username, password, nome, cognome, email, codiceFiscale, isAdmin, isOperator);
	
	    }
	    else {
	    	utente = null;
	    }
	    
	    disconnect(jdbcConnection);
	     
	    return utente;
	}
}
