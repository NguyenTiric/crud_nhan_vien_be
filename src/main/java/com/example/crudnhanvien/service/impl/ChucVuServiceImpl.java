package com.example.crudnhanvien.service.impl;

import com.example.crudnhanvien.model.mapper.ChucVuMapper;
import com.example.crudnhanvien.model.response.ChucVuResponse;
import com.example.crudnhanvien.repository.ChucVuRepository;
import com.example.crudnhanvien.service.ChucVuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.example.crudnhanvien.trang_thai_enum.TrangThai.TrangThaiChucVu.ACTIVE;

@Component
public class ChucVuServiceImpl implements ChucVuService {

    @Autowired
    ChucVuRepository chucVuRepository;

    @Autowired
    ChucVuMapper chucVuMapper;

    @Override
    public List<ChucVuResponse> listChucVuResponse() {
        return chucVuMapper.listChucVuEntityToChucVuResponse(chucVuRepository.getAllByTrangThai(ACTIVE));
    }
}
