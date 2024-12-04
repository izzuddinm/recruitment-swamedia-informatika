package com.recruitment.managementgradestudent.repository;

import com.recruitment.managementgradestudent.model.table.TableNilai;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface NilaiRepository extends JpaRepository<TableNilai, String> {
    Optional<TableNilai> findByNIS(String NIS);
//    List<TableNilai> findAllDesc();
}
