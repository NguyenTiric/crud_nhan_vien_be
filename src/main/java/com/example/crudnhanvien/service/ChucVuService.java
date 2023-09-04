package com.example.crudnhanvien.service;

import com.example.crudnhanvien.model.response.ChucVuResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ChucVuService {
    List<ChucVuResponse> listChucVuResponse();
}
