package com.atm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atm.entities.Atm;
import com.atm.repositorie.AtmRepository;

@Service
public class AtmService {
	@Autowired
	private AtmRepository Atmrepo ;
	
	public void insertAtmDetails(Atm a1) {
		Atmrepo.save(a1);
	}
	 public List<Atm> showAllAtm(){
		 List<Atm>Atmlist = Atmrepo.findAll();
		 return Atmlist;
	 }
//	 public Atm getSingleAtm(int id) {
//		 Atm a1 = null;
//		List<Atm> Atmlist =Atmrepo.findAll();
//		for(Atm a :Atmlist) {
//			if(a.get == id) {
//		}
//	 }
	 
}
