package br.edu.ufcg.srh.adicionais.client.view;

import br.edu.ufcg.srh.adicionais.client.Adicionais;
import br.edu.ufcg.srh.adicionais.client.activity.Presenter;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.event.dom.client.KeyPressHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.RadioButton;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;

public class FormViewImpl extends Composite implements FormView {

	private Presenter presenter;
	private TextBox matriculaTextBox;
	private TextBox nomeTextBox;
	private TextBox localizacaoTextBox;
	private TextBox setorTextBox;
	private TextBox horasTextBox;
	private ListBox tipoDeRiscoComboBox;
	private ListBox agenteDeRiscoComboBox;
	private TextArea descricaoTextArea;
	private Button submitButton;
	private Button cleanButton;
	private VerticalPanel carreiraRadioButtonsPanel;

	public FormViewImpl() {
		VerticalPanel vp = new VerticalPanel();
		this.initWidget(vp);
		vp.setSize("100%", "100%");

		FlexTable grid = new FlexTable();

		Label tituloLabel = new Label("Identificação de riscos");
		tituloLabel.setStyleName(Adicionais.RESOURCES.css().formTitle());

		Label matriculaLabel = new Label("Matrícula do servidor:");
		this.matriculaTextBox = new TextBox();

		Label nomeLabel = new Label("Nome do servidor:");
		this.nomeTextBox = new TextBox();

		Label carreiraLabel = new Label("Carreira:");
		this.carreiraRadioButtonsPanel = new VerticalPanel();
		RadioButton docenteRadioButton = new RadioButton("carreira", "Docente");
		RadioButton tecnicoRadioButton = new RadioButton("carreira", "Técnico");
		carreiraRadioButtonsPanel.add(docenteRadioButton);
		carreiraRadioButtonsPanel.add(tecnicoRadioButton);
		carreiraRadioButtonsPanel.setSpacing(4);

		Label localizacaoLabel = new Label("Unidade de localização");
		this.localizacaoTextBox = new TextBox();

		Label tipoDeRiscoLabel = new Label("Tipo de risco:");
		this.tipoDeRiscoComboBox = new ListBox();
		tipoDeRiscoComboBox.addItem("Insalubridade");
		tipoDeRiscoComboBox.addItem("Periculosidade");
		tipoDeRiscoComboBox.addItem("Radiação ionizante");

		Label agenteDeRiscoLabel = new Label("Agente de risco:");
		this.agenteDeRiscoComboBox = new ListBox();
		agenteDeRiscoComboBox.addItem("Físico");
		agenteDeRiscoComboBox.addItem("Químico");
		agenteDeRiscoComboBox.addItem("Biológico");

		Label setorLabel = new Label("Setor de risco:");
		this.setorTextBox = new TextBox();

		Label horasLabel = new Label("Horas trabalhadas no setor:");
		this.horasTextBox = new TextBox();
		this.horasTextBox.setMaxLength(2);
		this.horasTextBox.setVisibleLength(2);
		// Let's disallow non-numeric entry in the normal text box.
		this.horasTextBox.addKeyPressHandler(new KeyPressHandler() {
			public void onKeyPress(KeyPressEvent event) {
				if ((event.getUnicodeCharCode() != 0)
						&& (!Character.isDigit(event.getCharCode()))) {
					((TextBox) event.getSource()).cancelKey();
				}
			}
		});

		Label descricaoLabel = new Label("Descrição:");
		this.descricaoTextArea = new TextArea();

		this.submitButton = new Button("Submeter formulário");

		this.cleanButton = new Button("Limpar");

		grid.setCellSpacing(8);
		grid.setWidget(0, 0, matriculaLabel);
		grid.setWidget(0, 1, this.matriculaTextBox);
		grid.setWidget(1, 0, nomeLabel);
		grid.setWidget(1, 1, nomeTextBox);
		grid.setWidget(2, 0, carreiraLabel);
		grid.setWidget(2, 1, carreiraRadioButtonsPanel);
		grid.setWidget(3, 0, localizacaoLabel);
		grid.setWidget(3, 1, localizacaoTextBox);
		grid.setWidget(4, 0, tipoDeRiscoLabel);
		grid.setWidget(4, 1, tipoDeRiscoComboBox);
		grid.setWidget(5, 0, agenteDeRiscoLabel);
		grid.setWidget(5, 1, agenteDeRiscoComboBox);
		grid.setWidget(6, 0, setorLabel);
		grid.setWidget(6, 1, setorTextBox);
		grid.setWidget(7, 0, horasLabel);
		grid.setWidget(7, 1, horasTextBox);
		grid.setWidget(8, 0, descricaoLabel);
		grid.setWidget(8, 1, descricaoTextArea);
		grid.setWidget(9, 0, cleanButton);
		grid.setWidget(9, 1, submitButton);
		grid.getCellFormatter().setHorizontalAlignment(9, 1,
				HasHorizontalAlignment.ALIGN_RIGHT);

		vp.add(tituloLabel);
		vp.setCellVerticalAlignment(tipoDeRiscoLabel,
				HasVerticalAlignment.ALIGN_TOP);
		vp.setCellHorizontalAlignment(tituloLabel,
				HasHorizontalAlignment.ALIGN_CENTER);

		vp.add(grid);
		vp
				.setCellHorizontalAlignment(grid,
						HasHorizontalAlignment.ALIGN_CENTER);

	}

	@Override
	public Presenter getPresenter() {
		return this.presenter;
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;

	}

	@Override
	public TextBox getMatriculaTextBox() {
		return this.matriculaTextBox;
	}

	@Override
	public TextBox getNomeTextBox() {
		return this.nomeTextBox;
	}

	@Override
	public ListBox getAgenteDeRiscoComboBox() {
		return this.agenteDeRiscoComboBox;
	}

	@Override
	public Button getCleanButton() {
		// TODO Auto-generated method stub
		return this.cleanButton;
	}

	@Override
	public TextArea getDescricaoTextArea() {
		// TODO Auto-generated method stub
		return this.descricaoTextArea;
	}

	@Override
	public TextBox getHorasTextBox() {
		// TODO Auto-generated method stub
		return this.horasTextBox;
	}

	@Override
	public TextBox getLocalizacaoTextBox() {
		// TODO Auto-generated method stub
		return this.localizacaoTextBox;
	}

	@Override
	public TextBox getSetorTextBox() {
		// TODO Auto-generated method stub
		return this.setorTextBox;
	}

	@Override
	public Button getSubmitButton() {
		// TODO Auto-generated method stub
		return this.submitButton;
	}

	@Override
	public ListBox getTipoDeRiscoComboBox() {
		// TODO Auto-generated method stub
		return this.tipoDeRiscoComboBox;
	}

	@Override
	public VerticalPanel getCarreiraRadioButtonsPanel() {
		return this.carreiraRadioButtonsPanel;
	}

	@Override
	public RadioButton getCarreiraSelecionada() {
		for (int i = 0; i < this.getCarreiraRadioButtonsPanel()
				.getWidgetCount(); i++) {
			RadioButton r = (RadioButton) this.getCarreiraRadioButtonsPanel().getWidget(i);
			if (r.getValue()) {
				return r;
			}

		}
		return null;

	}
}