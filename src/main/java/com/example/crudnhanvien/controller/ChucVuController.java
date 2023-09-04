package com.example.crudnhanvien.controller;

import com.example.crudnhanvien.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chuc-vu")
@CrossOrigin("*")
public class ChucVuController {
    @Autowired
    ChucVuService chucVuService;
    @GetMapping("")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(chucVuService.listChucVuResponse());
    }
}
