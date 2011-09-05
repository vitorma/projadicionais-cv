package br.edu.ufcg.srh.adicionais.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class FormPlace extends Place {
	
	private String token;

	public FormPlace(String token) {
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public static class Tokenizer implements PlaceTokenizer<FormPlace> {

		@Override
		public FormPlace getPlace(String token) {
			return new FormPlace(token);
		}

		@Override
		public String getToken(FormPlace place) {
			return place.getToken();
		}
	}

}
