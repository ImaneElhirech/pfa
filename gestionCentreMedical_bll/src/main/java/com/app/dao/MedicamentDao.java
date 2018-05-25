package com.app.dao;

import java.util.List;


import com.bo.Medicament;

import com.genericdao.api.GenericDao;

public interface MedicamentDao extends GenericDao<Medicament,Long> {
	public List<Medicament> getMedicamentByname(String nom);


}
