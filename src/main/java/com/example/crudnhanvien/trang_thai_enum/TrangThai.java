package com.example.crudnhanvien.trang_thai_enum;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;

public class TrangThai {
    public enum TrangThaiNhanVien{
        ACTIVE,
        INACTIVE
    }

    public enum TrangThaiChucVu{
        ACTIVE,
        INACTIVE
    }
}
