package br.edu.ufcg.srh.adicionais.client.activity;

import br.edu.ufcg.srh.adicionais.client.ClientFactory;
import br.edu.ufcg.srh.adicionais.client.SubmitService;
import br.edu.ufcg.srh.adicionais.client.SubmitServiceAsync;
import br.edu.ufcg.srh.adicionais.client.view.FormView;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.RadioButton;

public class FormActivity extends AbstractActivity implements Presenter {

	private ClientFactory clientFactory;
	private FormView formView;
	private SubmitServiceAsync submitService = (SubmitServiceAsync) GWT
			.create(SubmitService.class);

	public FormActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	private void addClickHandlersToViewButtons(FormView formView) {
		final FormView fv = formView;
		fv.getCleanButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				resetarFormulario();
			}

		});

		fv.getSubmitButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
				submeterFormulario();
			}
		});

	}

	@Override
	public void goTo(Place place) {
		this.clientFactory.getPlaceController().goTo(place);
	}

	@Override
	public void start(AcceptsOneWidget panel, EventBus eventBus) {
		this.formView = this.clientFactory.getFormView();
		this.formView.setPresenter(this);
		panel.setWidget(this.formView.asWidget());
		this.addClickHandlersToViewButtons(this.formView);
	}

	private void resetarFormulario() {
		this.formView.getMatriculaTextBox().setText("");
		this.formView.getNomeTextBox().setText("");
		for (int i = 0; i < this.formView.getCarreiraRadioButtonsPanel()
				.getWidgetCount(); i++) {
			((RadioButton) this.formView.getCarreiraRadioButtonsPanel()
					.getWidget(i)).setValue(false);
		}
		this.formView.getLocalizacaoTextBox().setText("");
		this.formView.getTipoDeRiscoComboBox().setSelectedIndex(0);
		this.formView.getAgenteDeRiscoComboBox().setSelectedIndex(0);
		this.formView.getSetorTextBox().setText("");
		this.formView.getHorasTextBox().setText("");
		this.formView.getDescricaoTextArea().setText("");

		this.formView.getMatriculaTextBox().setFocus(true);
	}

	private void submeterFormulario() {
		try {
			submitService.submit(
					this.formView.getMatriculaTextBox().getText(),
					this.formView.getNomeTextBox().getText(),
					this.formView.getCarreiraSelecionada().getFormValue(),
					this.formView.getLocalizacaoTextBox().getText(),
					this.formView.getSetorTextBox().getText(),
					this.formView.getHorasTextBox().getText(),
					this.formView.getTipoDeRiscoComboBox().getValue(
							this.formView.getTipoDeRiscoComboBox()
									.getSelectedIndex()),
					this.formView.getAgenteDeRiscoComboBox().getValue(
							this.formView.getAgenteDeRiscoComboBox()
									.getSelectedIndex()), this.formView
							.getDescricaoTextArea().getText(),
					new AsyncCallback<String>() {

						@Override
						public void onFailure(Throwable caught) {
							Window.alert(caught.getMessage());

						}

						@Override
						public void onSuccess(String result) {
							Window.alert("Servidor de matrícula" + result
									+ "cadastrado com sucesso");

						}
					});
		} catch (Exception e) {
			Window.alert(e.getMessage());
		}
	}
}
