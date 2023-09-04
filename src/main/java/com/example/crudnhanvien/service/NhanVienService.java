package com.example.crudnhanvien.service;

import com.example.crudnhanvien.model.request.create_request.CreateNhanVienRequest;
import com.example.crudnhanvien.model.request.update_request.UpdateNhanVienRequest;
import com.example.crudnhanvien.model.response.NhanVienResponse;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface NhanVienService {

    Page<NhanVienResponse> pageNhanVien(Integer pageNo,Integer size);

    Page<NhanVienResponse> pageSearchNhanVien(Integer pageNo,Integer size,String search);

    NhanVienResponse create(CreateNhanVienRequest createNhanVienRequest);

    NhanVienResponse update(UpdateNhanVienRequest updateNhanVienRequest, Integer id);

    NhanVienResponse getOne(Integer id);

    void removeOrRevert(String trangThaiNhanVien,Integer id);

    void delete(Integer id);


}
