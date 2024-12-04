package com.recruitment.managementgradestudent.service;

import com.recruitment.managementgradestudent.model.table.TableMataPelajaran;
import org.springframework.http.ResponseEntity;
public interface MataPelajaranService {
    public ResponseEntity<String> createMataPelajaran(TableMataPelajaran paylod);
    public ResponseEntity<String> deleteMataPelajaran(String mapel);
    public ResponseEntity<String> updateMataPelajaran(TableMataPelajaran payload, String kodeMapel);
    public ResponseEntity<String> getAllMataPelajaran();
}
