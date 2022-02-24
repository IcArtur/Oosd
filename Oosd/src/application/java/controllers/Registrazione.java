package application.java.controllers;

import java.io.IOException;
import java.sql.SQLException;

import application.java.Main;
import application.java.DAO.UtenteDAO;
import application.java.models.Utente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class Registrazione {
	Utente utente = new Utente();
	UtenteDAO utenteDAO = new UtenteDAO();
	Boolean registrazione = false;
	Main m = new Main();

    public Registrazione() {
    	
    }
//  Variabili JavaFX
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private TextField email;
    @FXML
    private TextField nome;
    @FXML
    private TextField cognome;
    @FXML
    private TextField codiceFiscale;
    @FXML
    private Button registerButton;
    @FXML
    private Label wrongRegistration;
    
//    Metodo che gestisce il click del Button per la registrazione
    public void userRegister(ActionEvent event) throws IOException, SQLException {
    	try {
//    		Generiamo un nuovo utente per poi passato al DAO che lo inserira' nel database
	    	utente = new  Utente(username.getText(), password.getText(), nome.getText(), cognome.getText(), email.getText(), codiceFiscale.getText());
	    	registrazione = utenteDAO.registerUtente(utente);
    	} catch(Exception e) {
//    		Possible SQL 
    		wrongRegistration.setText("Controlla i campi");
    		return;
    	}
    	if (registrazione) {
//    		Cambio scena se la registrazione e' andata a buon fine
    		m.changeScene("/application/resources/view/LoginFrame.fxml", "Login");
    	}
    	else {
//    		Messaggio di errore generico
    		wrongRegistration.setText("Registrazione non riuscita");
    	}
    }
}
