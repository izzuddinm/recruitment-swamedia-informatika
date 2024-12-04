package com.recruitment.managementgradestudent.repository;

import com.recruitment.managementgradestudent.model.table.TableSiswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SiswaRepository extends JpaRepository<TableSiswa, String> {
    Optional<TableSiswa> findByNIS(String NIS);
}
