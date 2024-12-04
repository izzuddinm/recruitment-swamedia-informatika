package com.recruitment.managementgradestudent.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TableRankingDto {
    private String NIS;
    private Integer ranking;
    private Integer semester;

}
