package com.recruitment.managementgradestudent.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TableMataPelajaranDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String kodeMataPelajaran;
    private String namaMataPelajaran;
}
