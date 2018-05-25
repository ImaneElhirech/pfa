package com.app.service;

import java.util.List;
import java.util.Map;

import com.app.dao.exceptions.EntityNotFoundException;
import com.bo.Medicament;

public interface MedicamentService {
	/** Enregistrer un Medicament */
	public void addNewMedicament(Medicament medic);

	/** récupére la liste des Medicaments */
	
	public List<Medicament> getAllMedicaments();

	

	/** recherche un Medicament par son nom */
	public List<Medicament> finMedicamentByname(String name);



	/** mise é jour des informations d'un Medicament*/
	public void updateMedicament(Medicament pMedicament) ;

	
	
	/** supprime un Medicament de la base de données 
	 * @throws EntityNotFoundException */
	public void deleteMedicament(Long pId) throws EntityNotFoundException;



}
