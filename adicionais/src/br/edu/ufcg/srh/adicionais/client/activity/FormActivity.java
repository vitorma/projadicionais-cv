package br.edu.ufcg.srh.adicionais.client.activity;

import br.edu.ufcg.srh.adicionais.client.ClientFactory;
import br.edu.ufcg.srh.adicionais.client.place.FormPlace;
import br.edu.ufcg.srh.adicionais.client.view.CentroView;
import br.edu.ufcg.srh.adicionais.client.view.FormView;
import br.edu.ufcg.srh.adicionais.client.view.LoginView;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.RadioButton;


public class FormActivity extends AbstractActivity implements Presenter {

	private ClientFactory clientFactory;
	private FormView formView;

	public FormActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}
	
	private void addClickHandlersToViewButtons(FormView formView) {
		final FormView fv = formView;
		fv.getCleanButton().addClickHandler(new ClickHandler() {
			@Override
			public void onClick(ClickEvent event) {
					fv.getMatriculaTextBox().setText("");
					fv.getNomeTextBox().setText("");
					for (int i = 0; i < fv.getCarreiraRadioButtonsPanel().getWidgetCount(); i++) {
						((RadioButton) fv.getCarreiraRadioButtonsPanel().getWidget(i)).setValue(false);
					}				
					fv.getLocalizacaoTextBox().setText("");
					fv.getTipoDeRiscoComboBox().setSelectedIndex(0);
					fv.getAgenteDeRiscoComboBox().setSelectedIndex(0);
					fv.getSetorTextBox().setText("");
					fv.getHorasTextBox().setText("");
					fv.getDescricaoTextArea().setText("");
					
					fv.getMatriculaTextBox().setFocus(true);
					
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
}
