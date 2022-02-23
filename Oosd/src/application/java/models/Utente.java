package application.java.models;

import java.util.Random;

public class Utente {
    protected int pk;
    protected String username;
    protected String password;
    protected String nome;
    protected String cognome;
    protected String email;
    protected String codiceFiscale;
    protected boolean isAdmin;
    protected boolean isOperator;
    
    
 
    public Utente() {
    }
 
    public Utente(int pk) {
        this.pk = pk;
    }
    
    public Utente(String username, String password) {
    	this.username = username;
    	this.password = password;
    }
    
    public Utente(int pk, String username, String password, String email) {
    	this(username, password);
    	this.email = email;
    	this.pk = pk;
    }

	public Utente(int pk, String username, String password, String nome, String cognome, String email,
			String codiceFiscale, boolean isAdmin, boolean isOperator) {
		super();
		this.pk = pk;
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.email = email;
		this.codiceFiscale = codiceFiscale;
		this.isAdmin = isAdmin;
		this.isOperator = isOperator;
	}

	public int getPk() {
		return pk;
	}

	public void setPk(int pk) {
		this.pk = pk;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isOperator() {
		return isOperator;
	}

	public void setOperator(boolean isOperator) {
		this.isOperator = isOperator;
	}
}