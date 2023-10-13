package com.example.crudnhanvien.model.request.create_request;

import com.example.crudnhanvien.entity.ChucVu;
import com.example.crudnhanvien.trang_thai_enum.TrangThai;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CreateNhanVienRequest {
    private Integer id;
    @NotBlank(message = "ma khong duoc trong")
    private String ma;
    private String ten;
    private String anh;
    private Boolean gioiTinh;
    private LocalDate ngaySinh;
    private String email;
    private String sdt;
    private ChucVu chucVu;
    @Enumerated(EnumType.STRING)
    private TrangThai.TrangThaiNhanVien trangThai;
}
