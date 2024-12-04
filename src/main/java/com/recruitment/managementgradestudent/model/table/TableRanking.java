package com.recruitment.managementgradestudent.model.table;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
@Entity
@Table(name = "tb_ranking")
public class TableRanking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String NIS;
    private Integer ranking;
    private Integer semester;

}
