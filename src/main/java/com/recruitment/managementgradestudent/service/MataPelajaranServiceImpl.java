package com.recruitment.managementgradestudent.service;

import com.recruitment.managementgradestudent.base.dto.ResponseDto;
import com.recruitment.managementgradestudent.base.service.BaseService;
import com.recruitment.managementgradestudent.base.service.HttpService;
import com.recruitment.managementgradestudent.model.dto.TableMataPelajaranDto;
import com.recruitment.managementgradestudent.model.table.TableMataPelajaran;
import com.recruitment.managementgradestudent.repository.MataPelajaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MataPelajaranServiceImpl extends BaseService implements MataPelajaranService {
    @Autowired
    private HttpService httpService;
    @Autowired
    private MataPelajaranRepository mataPelajaranRepository;
    @Override
    public ResponseEntity<String> createMataPelajaran(TableMataPelajaran paylod) {
        ResponseDto<TableMataPelajaranDto> responseDto = new ResponseDto<>();
        TableMataPelajaranDto dto = new TableMataPelajaranDto();
        dto.setKodeMataPelajaran(paylod.getKodeMataPelajaran());
        dto.setNamaMataPelajaran(paylod.getNamaMataPelajaran());
        responseDto.addData(dto);
        mataPelajaranRepository.save(paylod);
        return httpService.getResponseEntity(responseDto, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<String> deleteMataPelajaran(String kodeMapel) {
        ResponseDto<TableMataPelajaranDto> responseDto = new ResponseDto<>();
        mataPelajaranRepository.deleteById(kodeMapel);
        return httpService.getSuccessResponse("Data mata pelajaran berhasil di hapus berdasarkan " + kodeMapel);
    }

    @Override
    public ResponseEntity<String> updateMataPelajaran(TableMataPelajaran payload, String kodeMapel) {
        Optional<TableMataPelajaran> existingMatapelajaranOptional = mataPelajaranRepository.findByKodeMataPelajaran(kodeMapel);
        if (existingMatapelajaranOptional.isPresent()) {
            TableMataPelajaran existingMatapelajaran = existingMatapelajaranOptional.get();
            if (!existingMatapelajaran.getKodeMataPelajaran().equals(payload.getKodeMataPelajaran())) {
                existingMatapelajaran.setKodeMataPelajaran(payload.getKodeMataPelajaran());
            }
            existingMatapelajaran.setNamaMataPelajaran(payload.getNamaMataPelajaran());

            mataPelajaranRepository.save(existingMatapelajaran);
            return httpService.getSuccessResponse("Data mata pelajaran berhasil diupdate dengan kode " + kodeMapel);
        } else {
            return httpService.getStatusResponse(HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public ResponseEntity<String> getAllMataPelajaran() {
        try {
            List<TableMataPelajaran> mapelList = mataPelajaranRepository.findAll();
            ResponseDto<TableMataPelajaranDto> responseDto = new ResponseDto<>();

            List<TableMataPelajaranDto> namaMataPelajaranList = mapelList.stream()
                    .map(mapel -> {
                        TableMataPelajaranDto dto = new TableMataPelajaranDto();
                        dto.setNamaMataPelajaran(mapel.getNamaMataPelajaran());
                        return dto;
                    })
                    .collect(Collectors.toList());

            responseDto.setData(namaMataPelajaranList);
            return httpService.getResponseEntity(responseDto);
        } catch (Exception e) {
            return httpService.getStatusResponse(HttpStatus.NOT_FOUND);
        }
    }

}
