package com.example.crudnhanvien.model.mapper.impl;

import com.example.crudnhanvien.entity.ChucVu;
import com.example.crudnhanvien.model.mapper.ChucVuMapper;
import com.example.crudnhanvien.model.request.create_request.CreateChucVuRequest;
import com.example.crudnhanvien.model.request.update_request.UpdateChucVuRequest;
import com.example.crudnhanvien.model.response.ChucVuResponse;
import jakarta.annotation.Generated;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Generated(value = "org.mapstruct.ap.MappingProcessor", date = "2023-03-29T01:09:18+0700", comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.6 (JetBrains s.r.o.)")
@Component
public class ChucVuMapperImpl implements ChucVuMapper {

    @Autowired
    ModelMapper modelMapper;

    @Override
    public ChucVu chucVuResponseToChucVuEntity(ChucVuResponse chucVuResponse) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        ChucVu chucVu = modelMapper.map(chucVuResponse, ChucVu.class);
        return chucVu;
    }

    @Override
    public ChucVuResponse chucVuEntityToChucVuResponse(ChucVu chucVu) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        ChucVuResponse chucVuResponse = modelMapper.map(chucVu, ChucVuResponse.class);
        return chucVuResponse;
    }

    @Override
    public ChucVu createChucVuRequestToChucVuEntity(CreateChucVuRequest createChucVuRequest) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        ChucVu chucVu = modelMapper.map(createChucVuRequest, ChucVu.class);
        return chucVu;
    }

    @Override
    public ChucVu updateChucVuRequestToChucVuEntity(UpdateChucVuRequest updateChucVuRequest) {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        ChucVu chucVu = modelMapper.map(updateChucVuRequest, ChucVu.class);
        return chucVu;
    }

    @Override
    public List<ChucVuResponse> listChucVuEntityToChucVuResponse(List<ChucVu> chucVuList) {
        List<ChucVuResponse> list = new ArrayList<>(chucVuList.size());
        for (ChucVu cv : chucVuList) {
            list.add(chucVuEntityToChucVuResponse(cv));
        }
        return list;
    }
}
