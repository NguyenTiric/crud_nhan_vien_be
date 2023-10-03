package com.example.crudnhanvien.service.impl;

import com.example.crudnhanvien.entity.ChucVu;
import com.example.crudnhanvien.entity.NhanVien;
import com.example.crudnhanvien.exception.DuplicateRecordException;
import com.example.crudnhanvien.exception.InternalServerException;
import com.example.crudnhanvien.exception.NotFoundException;
import com.example.crudnhanvien.model.mapper.NhanVienMapper;
import com.example.crudnhanvien.model.request.create_request.CreateNhanVienRequest;
import com.example.crudnhanvien.model.request.update_request.UpdateNhanVienRequest;
import com.example.crudnhanvien.model.response.NhanVienResponse;
import com.example.crudnhanvien.repository.ChucVuRepository;
import com.example.crudnhanvien.repository.NhanVienRepository;
import com.example.crudnhanvien.service.NhanVienService;
import com.example.crudnhanvien.trang_thai_enum.TrangThai;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

@Component
public class NhanVienServiceImpl implements NhanVienService {

    @Autowired
    NhanVienRepository nhanVienRepository;

    @Autowired
    ChucVuRepository chucVuRepository;

    @Autowired
    NhanVienMapper nhanVienMapper;

    @Override
    public Page<NhanVienResponse> pageNhanVien(Integer pageNo, Integer size) {
        Pageable pageable = PageRequest.of(pageNo, size, Sort.by(Sort.Direction.DESC, "id"));
        Page<NhanVien> nhanVienPage = nhanVienRepository.findAll(pageable);
        return nhanVienPage.map(nhanVienMapper::nhanVienEntityToNhanVienResponse);
    }

    @Override
    public Page<NhanVienResponse> pageSearchNhanVien(Integer pageNo, Integer size, String search, TrangThai.TrangThaiNhanVien trangThai) {
        Pageable pageable = PageRequest.of(pageNo, size,Sort.by(Sort.Direction.DESC, "id"));
        Page<NhanVien> nhanVienPage = nhanVienRepository.pageSearch(pageable, search,trangThai);
        return nhanVienPage.map(nhanVienMapper::nhanVienEntityToNhanVienResponse);
    }

    @Override
    public Page<NhanVienResponse> pageSearchNhanVienName(Integer pageNo, Integer size, String ten, String email, String sdt) {
        Pageable pageable = PageRequest.of(pageNo, size,Sort.by(Sort.Direction.DESC, "id"));
        Page<NhanVien> nhanVienPage = nhanVienRepository.pageSearchName(pageable, ten,email,sdt);
        return nhanVienPage.map(nhanVienMapper::nhanVienEntityToNhanVienResponse);
    }

    @Override
    public NhanVienResponse create(CreateNhanVienRequest createNhanVienRequest) {
        try {
            NhanVien nhanVien = nhanVienMapper.createNhanVienRequestToNhanVienEntity(createNhanVienRequest);
            nhanVien.setTrangThai(TrangThai.TrangThaiNhanVien.ACTIVE);
            return nhanVienMapper.nhanVienEntityToNhanVienResponse(nhanVienRepository.save(nhanVien));
        } catch (DataIntegrityViolationException ex) {
            throw new DuplicateRecordException("Failed to create product. Possibly duplicate record." + ex);
        } catch (Exception ex) {
            throw new InternalServerException("Failed to create product due to an unexpected error." + ex);
        }
    }

    @Override
    @Transactional
    public NhanVienResponse update(UpdateNhanVienRequest updateNhanVienRequest, Integer id) {
        NhanVien nhanVien = nhanVienRepository.findById(id).orElseThrow(() -> new NotFoundException("NhanVien not found with id " + id));

        ChucVu chucVu = nhanVien.getChucVu();

        if (chucVu == null || chucVu.getId() == null) {
            throw new NotFoundException("ChucVu not found with id " + id);
        }

        nhanVien = nhanVienMapper.updateNhanVienRequestToNhanVienEntity(updateNhanVienRequest);
        nhanVienRepository.save(nhanVien);

        return nhanVienMapper.nhanVienEntityToNhanVienResponse(nhanVien);
    }

    @Override
    public NhanVienResponse getOne(Integer id) {
        NhanVien nhanVien = nhanVienRepository.findById(id).orElseThrow(() -> new NotFoundException("NhanVien not found with id " + id));
        return nhanVienMapper.nhanVienEntityToNhanVienResponse(nhanVien);
    }

    @Override
    public void removeOrRevert(String trangThaiNhanVien ,Integer id) {
        nhanVienRepository.removeOrRevert(trangThaiNhanVien, id);
    }

    @Override
    public void delete(Integer id) {
        nhanVienRepository.deleteById(id);
    }


}
