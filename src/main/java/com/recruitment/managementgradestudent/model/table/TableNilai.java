package com.recruitment.managementgradestudent.model.table;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_nilai")
public class TableNilai {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "NIS")
    private String NIS;
    @Column(name = "kode_mata_pelajaran")
    private String kodeMataPelajaran;
    @Column(name = "semester")
    private Integer semester;
    @Column(name = "nilai")
    private Float nilai;
    @Column(name = "kode_nilai")
    private String kodeNilai;

}
