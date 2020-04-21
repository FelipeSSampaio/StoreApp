package com.storeapp.StoreApp.enums;

public enum EnumTamanhoVestuario {

	//Alterar as strings somente altera o que sera apresentado no combo de tamanho
	P("P"),
	M("M"),
	G("G"),
	GG("GG"),
	XG("XG");
	
	private final String tamanhoCode;

    private EnumTamanhoVestuario(String tamanhoCode) {
        this.tamanhoCode = tamanhoCode;
    }

	public String getTamanhoCode() {
		return tamanhoCode;
	}	
}
