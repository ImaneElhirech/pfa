package com.app.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.MedicamentDao;
import com.app.dao.exceptions.EntityNotFoundException;
import com.app.service.MedicamentService;
import com.bo.Medicament;

@Service
@Transactional
public class MedicamentServiceImpl implements MedicamentService{
	@Autowired
	private  MedicamentDao  medicamentDao;

	public void addNewMedicament(Medicament medic) {
		// TODO Auto-generated method stub
		medicamentDao.create(medic);
		
	}
	
	@Transactional(readOnly=true)
	public List<Medicament> getAllMedicaments() {
		// TODO Auto-generated method stub
		return medicamentDao.getAll();
	}

	public List<Medicament> finMedicamentByname(String name) {
		// TODO Auto-generated method stub
		return medicamentDao.getMedicamentByname(name);
	}

	public void updateMedicament(Medicament pMedicament) {
		// TODO Auto-generated method stub
		medicamentDao.update(pMedicament);

		
	}

	public void deleteMedicament(Long pId) throws EntityNotFoundException {
		// TODO Auto-generated method stub
		medicamentDao.delete(pId);
	}

}
