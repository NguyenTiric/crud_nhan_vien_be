package com.example.crudnhanvien.model.mapper;

import com.example.crudnhanvien.entity.ChucVu;
import com.example.crudnhanvien.model.request.create_request.CreateChucVuRequest;
import com.example.crudnhanvien.model.request.update_request.UpdateChucVuRequest;
import com.example.crudnhanvien.model.response.ChucVuResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ChucVuMapper {
    ChucVu chucVuResponseToChucVuEntity(ChucVuResponse chucVuResponse);
    ChucVuResponse chucVuEntityToChucVuResponse(ChucVu chucVu);
    ChucVu createChucVuRequestToChucVuEntity(CreateChucVuRequest createChucVuRequest);
    ChucVu updateChucVuRequestToChucVuEntity(UpdateChucVuRequest updateChucVuRequest);
    List<ChucVuResponse> listChucVuEntityToChucVuResponse(List<ChucVu> chucVuList);
}
