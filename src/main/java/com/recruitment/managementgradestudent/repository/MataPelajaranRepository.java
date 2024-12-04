package com.recruitment.managementgradestudent.repository;

import com.recruitment.managementgradestudent.model.table.TableMataPelajaran;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MataPelajaranRepository extends JpaRepository<TableMataPelajaran, String> {
    Optional<TableMataPelajaran> findByKodeMataPelajaran(String kodeMataPelajaran);
}
