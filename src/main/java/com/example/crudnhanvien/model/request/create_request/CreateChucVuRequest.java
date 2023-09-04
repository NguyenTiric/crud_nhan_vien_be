package com.example.crudnhanvien.model.request.create_request;

import com.example.crudnhanvien.trang_thai_enum.TrangThai;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CreateChucVuRequest {
    private Integer id;
    private String ma;
    private String ten;
    @Enumerated(EnumType.STRING)
    private TrangThai.TrangThaiChucVu trangThai;
}
