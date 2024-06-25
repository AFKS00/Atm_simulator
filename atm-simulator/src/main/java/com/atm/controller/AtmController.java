package com.atm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.atm.entities.Atm;
import com.atm.services.AtmService;


@RestController
public class AtmController {
	@Autowired
	private AtmService atmserviceref ;
	@PostMapping("/Atm")
	public void  insertsinleAtmDetail(@RequestBody Atm a1)
	{
		atmserviceref.insertAtmDetails(a1);
	}
	
	@GetMapping("/Atm")
	public List<Atm> getAllAtm(){
		return atmserviceref.showAllAtm();	
	}
	
//	@
//	public Atm getSingleAtm() {
//		return 
//	}
}
 