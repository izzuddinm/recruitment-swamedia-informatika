package com.recruitment.managementgradestudent.model.table;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_mata_pelajaran")
public class TableMataPelajaran {
    @Id
    @Column(name = "kode_mata_pelajaran")
    private String kodeMataPelajaran;
    @Column(name = "nama_mata_pelajaran")
    private String namaMataPelajaran;
}
