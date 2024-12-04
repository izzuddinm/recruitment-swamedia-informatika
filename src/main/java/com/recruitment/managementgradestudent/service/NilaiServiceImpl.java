package com.recruitment.managementgradestudent.service;

import com.recruitment.managementgradestudent.base.dto.ResponseDto;
import com.recruitment.managementgradestudent.base.service.BaseService;
import com.recruitment.managementgradestudent.base.service.HttpService;
import com.recruitment.managementgradestudent.model.dto.TableNilaiDto;
import com.recruitment.managementgradestudent.model.table.TableNilai;
import com.recruitment.managementgradestudent.model.table.TableSiswa;
import com.recruitment.managementgradestudent.repository.NilaiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class NilaiServiceImpl extends BaseService implements NilaiService {
    @Autowired
    private HttpService httpService;
    @Autowired
    private NilaiRepository nilaiRepository;

    @Override
    public ResponseEntity<String> createNilai(TableNilai payload) {
        ResponseDto<TableNilaiDto> responseDto = new ResponseDto<>();
        TableNilaiDto dto = new TableNilaiDto();
        Float nilaiMahasiswa = payload.getNilai();
        if (nilaiMahasiswa >= 0 && nilaiMahasiswa <= 59) {
            payload.setKodeNilai("E");
        } else if (nilaiMahasiswa >= 60 && nilaiMahasiswa <= 69) {
            payload.setKodeNilai("D");
        } else if (nilaiMahasiswa >= 70 && nilaiMahasiswa <= 79) {
            payload.setKodeNilai("C");
        } else if (nilaiMahasiswa >= 80 && nilaiMahasiswa <= 89) {
            payload.setKodeNilai("B");
        } else if (nilaiMahasiswa >= 90 && nilaiMahasiswa <= 100) {
            payload.setKodeNilai("A");
        } else {
            throw new IllegalArgumentException("Nilai tidak valid");

        }
        String nisFromPayload = payload.getNIS();
        TableNilai dtos = new TableNilai();
        dtos.setNIS(nisFromPayload);
        dtos.setNilai(payload.getNilai());
        dtos.setKodeNilai(payload.getKodeNilai());
        dtos.setSemester(payload.getSemester());
        dtos.setKodeMataPelajaran(payload.getKodeMataPelajaran());

        dto.setKodeNilai(payload.getKodeNilai());
        dto.setKodeMataPelajaran(payload.getKodeMataPelajaran());
        dto.setNilai(payload.getNilai());
        dto.setNIS(payload.getNIS());
        dto.setSemester(payload.getSemester());
        nilaiRepository.save(dtos);
        responseDto.addData(dto);
        return httpService.getResponseEntity(responseDto);
    }

    @Override
    public ResponseEntity<String> deleteNilai(String NIS) {
        ResponseDto<TableNilaiDto> responseDto = new ResponseDto<>();
        nilaiRepository.deleteById(NIS);
        return httpService.getSuccessResponse("Data nilai berhasil di hapus berdasarkan NIS " + NIS);
    }

    @Override
    public ResponseEntity<String> updateNilai(TableNilai payload, String NIS) {
        Optional<TableNilai> existingSiswaOptional = nilaiRepository.findByNIS(NIS);
        if (existingSiswaOptional.isPresent()) {
            TableNilai existingSiswa = existingSiswaOptional.get();
            Float nilaiMahasiswa = payload.getNilai();
            if (nilaiMahasiswa >= 0 && nilaiMahasiswa <= 59) {
                payload.setKodeNilai("E");
            } else if (nilaiMahasiswa >= 60 && nilaiMahasiswa <= 69) {
                payload.setKodeNilai("D");
            } else if (nilaiMahasiswa >= 70 && nilaiMahasiswa <= 79) {
                payload.setKodeNilai("C");
            } else if (nilaiMahasiswa >= 80 && nilaiMahasiswa <= 89) {
                payload.setKodeNilai("B");
            } else if (nilaiMahasiswa >= 90 && nilaiMahasiswa <= 100) {
                payload.setKodeNilai("A");
            } else {
                throw new IllegalArgumentException("Nilai tidak valid");

            }
            existingSiswa.setNilai(payload.getNilai());
            existingSiswa.setKodeNilai(payload.getKodeNilai());
            existingSiswa.setSemester(payload.getSemester());
            existingSiswa.setKodeMataPelajaran(payload.getKodeMataPelajaran());
            nilaiRepository.save(existingSiswa);
            return httpService.getSuccessResponse("Data nilai berhasil diupdate");
        } else {
            return httpService.getStatusResponse(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<String> getDataDesc() {
        try {
            List<TableNilai> nilaiList = nilaiRepository.findAll();
            nilaiList.sort(Comparator.comparing(TableNilai::getNilai, Collections.reverseOrder()));
            ResponseDto<TableNilai> responseDto = new ResponseDto<>();
            responseDto.setData(nilaiList);
            return httpService.getResponseEntity(responseDto);
        } catch (Exception e){
            return httpService.getStatusResponse(HttpStatus.NOT_FOUND);
        }
    }
}
