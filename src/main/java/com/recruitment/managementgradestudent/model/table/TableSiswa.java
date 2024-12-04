package com.recruitment.managementgradestudent.model.table;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "tb_siswa")
public class TableSiswa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String NIS;
    @Column(name = "nama_siswa")
    private String  namaSiswa;
    @Column(name = "kelas")
    private String kelas;
    @Column(name = "jenis_kelamin")
    private String jenisKelamin;
}
