package com.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.app.dao.MedicamentDao;
import com.bo.Medicament;
import com.genericdao.impl.HibernateSpringGenericDaoImpl;

@Repository
public class MedicamentDaoImpl extends HibernateSpringGenericDaoImpl<Medicament, Long>implements MedicamentDao{
	public MedicamentDaoImpl() {

		// car on travail sur des objets de la classe Medicament, il y a des méthodes
		// hibernate qui auront besoin de cette information cf. le code de
		// generic dao
		super(Medicament.class);
	}
	
	public List<Medicament> getMedicamentByname(String nom) {

		// Une requete HQL simple pour chercher les livres par titre
		return (List<Medicament> ) getHibernateTemplate().find("from Medicament where nom=?", nom);
		

	}


}
