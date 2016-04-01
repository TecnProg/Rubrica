package it.polito.tdp.rubrica;

import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.rubrica.model.RubricaModel;
import it.polito.tdp.rubrica.model.VoceRubrica;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class RubricaController {
	
	private RubricaModel model;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtTelefono;

    @FXML
    private Button bttCerca;

    @FXML
    private Button bttInserisci;
    
    @FXML
    private Label lblStato;

    @FXML
    private ComboBox <String> comboBox;

    @FXML
    void doCerca(ActionEvent event) {
    	txtNome.clear();
    	String nome = comboBox.getValue();
    	if(nome.length()==0)
    	{
    		lblStato.setText("Dati mancanti");
    	}
    	else
    	{
    		VoceRubrica v= model.findVoceByNome(nome);
    		if(v!= null)
    		{
    			txtEmail.setText(v.getEmail());
    			txtTelefono.setText(v.getTelefono());
    			lblStato.setText("TROVATO!");
    		}
    		else
    		{
    			txtNome.clear();
    			lblStato.setText("Voce non presente in elenco");
    			txtEmail.clear();
    			txtTelefono.clear();
    		}
    	}
    }

    @FXML
    void doInserisci(ActionEvent event) {
    	
    	//Estrai i dati dall'interfaccia
    	String nome = txtNome.getText();
    	String telefono = txtTelefono.getText();
    	String email = txtEmail.getText();
    	
    	//Validiamo i dati inseriti dall'utente
    	if(nome.length()==0 || (email.length()==0 && telefono.length()==0))
    	{
    		//errore
    		lblStato.setText("Dati mancanti");
    	}else{
    		//dati validi
    		boolean result= model.addVoce(new VoceRubrica(nome,email,telefono));
    		
    		if(!result)
    			lblStato.setText("Nome già presente");
    		else
    		{
    			lblStato.setText("Voce inserita");
    			comboBox.getItems().add(nome);
    		}
    	}
    	
    	
    	

    }
    
    public void setModel (RubricaModel model)
    {
    	this.model=model;
    }

    @FXML
    void initialize() {
        assert txtNome != null : "fx:id=\"txtNome\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert txtEmail != null : "fx:id=\"txtEmail\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert txtTelefono != null : "fx:id=\"txtTelefono\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert bttCerca != null : "fx:id=\"bttCerca\" was not injected: check your FXML file 'Rubrica.fxml'.";
        assert bttInserisci != null : "fx:id=\"bttInserisci\" was not injected: check your FXML file 'Rubrica.fxml'.";

    }
}
