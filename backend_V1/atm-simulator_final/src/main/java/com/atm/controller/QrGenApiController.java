package com.atm.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.atm.entities.QrGenApi;
import com.atm.entities.QrGenApiDto;
import com.atm.entities.QrGenApiRequest;
import com.atm.services.QrGenApiService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
public class QrGenApiController {

    @Autowired
    private QrGenApiService qrGenApiService;

    @PostMapping("/save")
    public ResponseEntity<QrGenApiDto> saveTransaction(@RequestBody QrGenApiRequest request) {
        String tranId = UUID.randomUUID().toString().substring(0, 8);
        
        qrGenApiService.saveTransaction(tranId, request.getAtmId(), request.getAmount());
        QrGenApiDto qrGenApiQ = qrGenApiService.getLatestTransaction();
        return ResponseEntity.ok(qrGenApiQ);
    }

    @GetMapping("/latest")
    public ResponseEntity<QrGenApiDto> getLatestTransaction() {
        QrGenApiDto qrGenApiDto = qrGenApiService.getLatestTransaction();
        if (qrGenApiDto != null) {
            return ResponseEntity.ok(qrGenApiDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}