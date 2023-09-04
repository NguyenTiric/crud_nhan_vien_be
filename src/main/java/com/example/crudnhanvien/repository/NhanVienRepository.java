package com.example.crudnhanvien.repository;


import com.example.crudnhanvien.entity.NhanVien;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NhanVienRepository extends JpaRepository<NhanVien,Integer> {
    @Query(value = "SELECT nv FROM NhanVien nv LEFT JOIN nv.chucVu cv WHERE nv.ten LIKE %:search% or nv.email like %:search% or nv.sdt like %:search%")
    Page<NhanVien> pageSearch(Pageable pageable, @Param("search") String search);

//    @Query(value = "select nv.* from nhan_vien nv left join chuc_vu cv on nv.chuc_vu_id = cv.id " +
//            "where nv.ten like %:search% or nv.ma like %:search% or nv.sdt like %:search%", nativeQuery = true)
//    Page<NhanVien> pageSearch(Pageable pageable, @Param("search") String search);

    @Transactional
    @Modifying
    @Query(value = "UPDATE nhan_vien nv SET nv.trang_thai = :trangThai WHERE nv.id = :id",nativeQuery = true)
    void removeOrRevert(@Param("trangThai") String trangThaiNhanVien, @Param("id") Integer id);

}
