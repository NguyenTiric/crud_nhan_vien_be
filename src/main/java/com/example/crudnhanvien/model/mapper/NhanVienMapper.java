package com.example.crudnhanvien.model.mapper;

import com.example.crudnhanvien.entity.NhanVien;
import com.example.crudnhanvien.model.request.create_request.CreateNhanVienRequest;
import com.example.crudnhanvien.model.request.update_request.UpdateNhanVienRequest;
import com.example.crudnhanvien.model.response.NhanVienResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NhanVienMapper {
    NhanVien nhanVienResponseToNhanVienEntity(NhanVienResponse nhanVienResponse);
    NhanVienResponse nhanVienEntityToNhanVienResponse(NhanVien nhanVien);
    NhanVien createNhanVienRequestToNhanVienEntity(CreateNhanVienRequest createNhanVienRequest);
    NhanVien updateNhanVienRequestToNhanVienEntity(UpdateNhanVienRequest updateNhanVienRequest);
    List<NhanVienResponse> listNhanVienEntityToNhanVienResponse(List<NhanVien> nhanVienList);
}
