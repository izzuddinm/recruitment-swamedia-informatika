package com.recruitment.managementgradestudent.service;

import com.recruitment.managementgradestudent.model.table.TableNilai;
import org.springframework.http.ResponseEntity;

public interface NilaiService {
    public ResponseEntity<String> createNilai(TableNilai payload);
    public ResponseEntity<String> deleteNilai(String NIS);
    public ResponseEntity<String> updateNilai(TableNilai payload, String NIS);
    public ResponseEntity<String> getDataDesc();
}
