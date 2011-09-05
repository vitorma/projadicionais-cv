package br.edu.ufcg.srh.adicionais.client.view;

import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public interface FormView extends View{
	
	public TextBox getMatriculaTextBox(); 
	public TextBox getNomeTextBox(); 
	public TextBox getLocalizacaoTextBox();
	public TextBox getSetorTextBox(); 
	public TextBox getHorasTextBox(); 
	public ListBox getTipoDeRiscoComboBox(); 
	public ListBox getAgenteDeRiscoComboBox();
	public TextArea getDescricaoTextArea();
	public Button getSubmitButton();
	public Button getCleanButton();
	public VerticalPanel getCarreiraRadioButtonsPanel();
	RadioButton getCarreiraSelecionada();
	
}
