package com.example.crudnhanvien.repository;

import com.example.crudnhanvien.entity.ChucVu;
import com.example.crudnhanvien.trang_thai_enum.TrangThai;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChucVuRepository extends JpaRepository<ChucVu,Integer> {
    List<ChucVu> getAllByTrangThai(TrangThai.TrangThaiChucVu trangThaiChucVu);
}
