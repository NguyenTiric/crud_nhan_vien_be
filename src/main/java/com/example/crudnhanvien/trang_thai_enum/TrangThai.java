package com.example.crudnhanvien.trang_thai_enum;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TrangThai {
    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public enum TrangThaiNhanVien{
        ACTIVE("ACTIVE","Hoạt Động","success"),INACTIVE("INACTIVE","Không Hoạt Động","danger");
        private final String ten;
        private final String moTa;
        private final String mauSac;

        private TrangThaiNhanVien(String ten, String moTa, String mauSac) {
            this.ten = ten;
            this.moTa = moTa;
            this.mauSac = mauSac;
        }

        public String getTen() {
            return ten;
        }

        public String getMoTa() {
            return moTa;
        }

        public String getMauSac() {
            return mauSac;
        }
    }

    @JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public enum TrangThaiChucVu{
        ACTIVE("ACTIVE","Hoạt Động","success"),INACTIVE("INACTIVE","Không Hoạt Động","danger");
        private final String ten;
        private final String moTa;
        private final String mauSac;

        private TrangThaiChucVu(String ten, String moTa, String mauSac) {
            this.ten = ten;
            this.moTa = moTa;
            this.mauSac = mauSac;
        }

        public String getTen() {
            return ten;
        }

        public String getMoTa() {
            return moTa;
        }

        public String getMauSac() {
            return mauSac;
        }
    }
}
