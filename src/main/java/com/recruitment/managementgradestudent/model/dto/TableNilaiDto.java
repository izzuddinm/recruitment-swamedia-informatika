package com.recruitment.managementgradestudent.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TableNilaiDto {
    @Id
    private String NIS;
    private String kodeMataPelajaran;
    private Integer semester;
    private float nilai;
    private String kodeNilai;
}
