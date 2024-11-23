package br.com.fiap.gs2.gs2.dtos;

import java.math.BigDecimal;

public class PowerUpdate {
	private String nome;
	private BigDecimal valor;
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    
    public BigDecimal getValor() {
        return valor;
    }
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }
   
}
