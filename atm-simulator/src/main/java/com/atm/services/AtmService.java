package com.atm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atm.entities.Atm;
import com.atm.repositorie.AtmRepository;
import com.atm.serviceinterface.AtmServiceInterface;

@Service
public class AtmService implements AtmServiceInterface
{
	@Autowired
	private AtmRepository atmRepoRef;
	
	//insert one Atm details
	public void insertAtmDetails(Atm atmDetail)
	{
		atmRepoRef.save(atmDetail);
	}
	
	//insert Array of Atm details
	public void insertArrayOfAtmDetails(List<Atm> atmDetail)
	{
		atmRepoRef.saveAll(atmDetail);
	}
	
	//Show All atm
	public List<Atm> atmDetails()
	{
		return atmRepoRef.findAll();
	}
		
	//show atm by id
	public Atm findAtmById(int id)
	{
		List<Atm> ls = atmRepoRef.findAll();
		Atm foundAtm = null;
		for(Atm a : ls)
		{
			if(id==a.getId())
			{
				foundAtm = a;
				break;
			}
		}
		return foundAtm;
	}
	
	//show atm by name
	public Atm findAtmByName(String name)
	{
		List<Atm> ls = atmRepoRef.findAll();
		Atm foundAtm = null;
		for(Atm a : ls)
		{
			if(name==a.getName())
			{
				foundAtm = a;
				break;
			}
		}
		return foundAtm;
	}
	
	public void deleteAtmById(int id)
	{
		List<Atm> ls = atmRepoRef.findAll();
		for(Atm a : ls)
		{
			if(a.getId() == id)
			{
				atmRepoRef.delete(a);
			}
		}
	}
	
	public void updateAtm(Atm updateAtm)
	{
		List<Atm> ls = atmRepoRef.findAll();
		for(Atm a : ls)
		{
			if(updateAtm.getId() == a.getId())
			{
				atmRepoRef.save(updateAtm);
				
			}
		}
	}
	
	public void updateArrayAtm(List<Atm> listAtmDetails)
	{
		List<Atm> ls = atmRepoRef.findAll();
		for(Atm a : ls)
		{
		for(Atm b : listAtmDetails)
		{
			if(a.getId() == b.getId())
			{
				atmRepoRef.save(b);
			}
		}
	}
	}
}
