package com.recruitment.managementgradestudent.service;

import com.recruitment.managementgradestudent.model.table.TableSiswa;
import org.springframework.http.ResponseEntity;

public interface SiswaService {
    public ResponseEntity<String> createSiswa(TableSiswa payload);
    public ResponseEntity<String> deleteSiswa(TableSiswa payload, String NIS);
    public ResponseEntity<String> updateSiswa(TableSiswa payload, String NIS);
    public ResponseEntity<String> getAllSiswa();
}
