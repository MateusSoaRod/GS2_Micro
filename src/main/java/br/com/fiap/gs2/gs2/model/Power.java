package br.com.fiap.gs2.gs2.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Power {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 60)
    private String nome;

    @Column(nullable = false, length = 40)
    private String material;

    @Column(nullable = false)
    private int validadeAnos;

    @Column(nullable = false)
    private int carga;

	public void setId(Long id2) {
		// TODO Auto-generated method stub
		
	}
}
