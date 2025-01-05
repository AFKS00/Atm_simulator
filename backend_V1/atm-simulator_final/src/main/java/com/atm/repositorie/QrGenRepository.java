package com.atm.repositorie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.atm.entities.QrGenApi;

public interface QrGenRepository extends JpaRepository<QrGenApi, Integer>{
	 QrGenApi findTopByOrderByIdDesc();
}
