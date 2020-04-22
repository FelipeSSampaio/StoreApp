package com.storeapp.StoreApp.enums;

public enum EnumCorVestuario {

	//Alterar as strings somente altera o que sera apresentado no combo de tamanho
	AZUL("Azul"),
	AMARELO("Amarelo"),
	VERMELHO("Vermelho"),
	VERDE("Verde"),
	PRETO("Preto");
	
	private final String corCode;

    private EnumCorVestuario(String corCode) {
        this.corCode = corCode;
    }

	public String getCorCode() {
		return corCode;
	}	
}
