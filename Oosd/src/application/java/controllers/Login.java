package application.java.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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

//import application.java.Main;
public class Login {
	Utente utente = new Utente();
	Utente utenteLoggato = new Utente();
	UtenteDAO utenteDAO = new UtenteDAO();

    public Login() {

    }

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



    public void userLogin(ActionEvent event) throws IOException, SQLException {
    	checkLogin();
    }

    private void checkLogin() throws IOException, SQLException  {
    	Main m = new Main();
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
//        Main m = new Main();
    }


}
