package com.bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medicament {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	private String nom;
	private String nomCommercial;
	
	
	public Medicament() {
		
	}
	
	public Medicament( String nom, String nomCommercial) {
		this.nom = nom;
		this.nomCommercial = nomCommercial;
	}
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getNomCommercial() {
		return nomCommercial;
	}
	public void setNomCommercial(String nomCommercial) {
		this.nomCommercial = nomCommercial;
	}

	@Override
	public String toString() {
		return "Medicament [code=" + code + ", nom=" + nom + ", nomCommercial=" + nomCommercial + "]";
	}
	
	
	

}
