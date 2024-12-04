package com.recruitment.managementgradestudent.service;

import com.recruitment.managementgradestudent.base.dto.ResponseDto;
import com.recruitment.managementgradestudent.base.service.BaseService;
import com.recruitment.managementgradestudent.base.service.HttpService;
import com.recruitment.managementgradestudent.model.dto.TableSiswaDto;
import com.recruitment.managementgradestudent.model.table.TableSiswa;
import com.recruitment.managementgradestudent.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class SiswaServiceImpl extends BaseService implements SiswaService {
    @Autowired
    private HttpService httpService;

    @Autowired
    private SiswaRepository siswaRepository;
    @Override
    public ResponseEntity<String> createSiswa(TableSiswa payload) {
        ResponseDto<TableSiswaDto> responseDto = new ResponseDto<>();
        TableSiswaDto dto = new TableSiswaDto();
        dto.setNamaSiswa(payload.getNamaSiswa());
        dto.setKelas(payload.getKelas());
        dto.setJenisKelamin(payload.getJenisKelamin());
        siswaRepository.save(payload);
        responseDto.addData(dto);
        return httpService.getResponseEntity(responseDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> deleteSiswa(TableSiswa payload, String NIS) {
        ResponseDto<TableSiswaDto> responseDto = new ResponseDto<>();
        TableSiswaDto dto = new TableSiswaDto();
        dto.setNamaSiswa(payload.getNamaSiswa());
        dto.setKelas(payload.getKelas());
        dto.setJenisKelamin(payload.getJenisKelamin());
        siswaRepository.deleteById(NIS);
        responseDto.addData(dto);
        return httpService.getSuccessResponse("Data siswa berhasil di hapus dengan NIS " + NIS);
    }

    @Override
    public ResponseEntity<String> updateSiswa(TableSiswa payload, String NIS) {
        Optional<TableSiswa> existingSiswaOptional = siswaRepository.findByNIS(NIS);
        if (existingSiswaOptional.isPresent()) {
            TableSiswa existingSiswa = existingSiswaOptional.get();
            existingSiswa.setNamaSiswa(payload.getNamaSiswa());
            existingSiswa.setKelas(payload.getKelas());
            existingSiswa.setJenisKelamin(payload.getJenisKelamin());
            siswaRepository.save(existingSiswa);
            return httpService.getSuccessResponse("Data siswa berhasil diupdate dengan nama " + payload.getNamaSiswa());
        } else {
            return httpService.getStatusResponse(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> getAllSiswa() {
        try {
            List<TableSiswa> siswaList = siswaRepository.findAll();
            ResponseDto<TableSiswa> responseDto = new ResponseDto<>();
            responseDto.setData(siswaList);
            return httpService.getResponseEntity(responseDto);
        } catch (Exception e){
            return httpService.getStatusResponse(HttpStatus.NOT_FOUND);
        }
    }

}
