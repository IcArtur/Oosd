package application.java.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.java.models.Utente;
import application.java.Main;
import application.java.DAO.UtenteDAO;

import java.io.IOException;


public class Login {
//	Dichiarazioni di variabili globali
	Utente utente = new Utente();
	Utente utenteLoggato = new Utente();
	UtenteDAO utenteDAO = new UtenteDAO();
	Main m = new Main();

    public Login() {
    }
//	Variabili JavaFX
    @FXML
    private Button button;
    @FXML
    private Button register;
    @FXML
    private Label wrongLogin;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;


//  Metodo che gestisce il click del Button per la login
    public void userLogin(ActionEvent event) throws IOException, SQLException {
    	utente = new Utente(username.getText().toString(), password.getText().toString());
    	utenteLoggato = utenteDAO.login(utente);
    	if (utenteLoggato != null) {
    		wrongLogin.setText("Login riuscito");
    		m.changeScene("/application/resources/view/Homepage.fxml", "Homepage");
    	}
    	else {
    		wrongLogin.setText("Login fallito");
    		username.setText("");
    		password.setText("");
    	}
    }
//  Metodo che gestisce il cambio di scena per la registrazione
    public void registerScene(MouseEvent event) throws IOException {
    	m.changeScene("/application/resources/view/Registrazione.fxml", "Registrazione");
    }


}
