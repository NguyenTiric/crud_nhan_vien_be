package com.example.crudnhanvien.controller;

import com.example.crudnhanvien.model.request.create_request.CreateNhanVienRequest;
import com.example.crudnhanvien.model.request.update_request.UpdateNhanVienRequest;
import com.example.crudnhanvien.service.NhanVienService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import static com.example.crudnhanvien.trang_thai_enum.TrangThai.TrangThaiNhanVien.ACTIVE;
import static com.example.crudnhanvien.trang_thai_enum.TrangThai.TrangThaiNhanVien.INACTIVE;

//http://localhost:8080/api/nhan-vien
@RestController
@RequestMapping("/api/nhan-vien")
@CrossOrigin("*")
public class NhanVienController {

    @Autowired
    NhanVienService nhanVienService;

    @GetMapping("")
    public ResponseEntity<?> getAll(@RequestParam(defaultValue = "0", name = "pageNo", required = false) Integer pageNo,
                                    @RequestParam(defaultValue = "10", name = "pageSize", required = false) Integer pageSize) {
        return ResponseEntity.ok(nhanVienService.pageNhanVien(pageNo, pageSize));
    }

    @GetMapping("/search")
    public ResponseEntity<?> search(@RequestParam(name = "search",required = false) String search,
                                    @RequestParam(defaultValue = "0", name = "pageNo", required = false) Integer pageNo,
                                    @RequestParam(defaultValue = "5", name = "pageSize", required = false) Integer pageSize) {
        return ResponseEntity.ok(nhanVienService.pageSearchNhanVien(pageNo, pageSize, search));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getNhanVienId(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(nhanVienService.getOne(id));
    }

    @PostMapping("/create")
    public ResponseEntity<?> createNhanVien(@Valid @RequestBody CreateNhanVienRequest createNhanVienRequest, BindingResult result) {
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.ok(list);
        }
        return ResponseEntity.ok(nhanVienService.create(createNhanVienRequest));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateNhanVien(@Valid @RequestBody UpdateNhanVienRequest updateNhanVienRequest, BindingResult result, @PathVariable("id") Integer id) {
        if (result.hasErrors()) {
            List<ObjectError> list = result.getAllErrors();
            return ResponseEntity.ok(list);
        }
        return ResponseEntity.ok(nhanVienService.update(updateNhanVienRequest, id));
    }

    @PutMapping("/revert/{id}")
    public ResponseEntity<?> revertNhanVien(@PathVariable("id") Integer id) {
        nhanVienService.removeOrRevert(String.valueOf(ACTIVE), id);
        return ResponseEntity.ok("Revert Success");
    }

    @PutMapping("/remove/{id}")
    public ResponseEntity<?> removeNhanVien(@PathVariable("id") Integer id) {
        nhanVienService.removeOrRevert(String.valueOf(INACTIVE), id);
        return ResponseEntity.ok("Remove Success");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id) {
        nhanVienService.delete(id);
        return ResponseEntity.ok("Delete Success");
    }
}
