package com.recruitment.managementgradestudent.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TableSiswaDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String NIS;
    private String  namaSiswa;
    private String kelas;
    private String jenisKelamin;
}
