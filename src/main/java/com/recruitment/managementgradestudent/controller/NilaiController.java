package com.recruitment.managementgradestudent.controller;

import com.recruitment.managementgradestudent.model.table.TableNilai;
import com.recruitment.managementgradestudent.service.NilaiService;
import com.recruitment.managementgradestudent.service.SiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class NilaiController {
    @Autowired
    private NilaiService nilaiService;
    private static final String URL = "/service";
    @RequestMapping(value = NilaiController.URL
            + "/nilai/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createSiswa(@RequestBody @Validated TableNilai payload) {
        return nilaiService.createNilai(payload);
    }

    @RequestMapping(value = NilaiController.URL
            + "/nilai/delete/{NIS}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteSiswa(@PathVariable String NIS) {
        return nilaiService.deleteNilai(NIS);
    }

    @RequestMapping(value = NilaiController.URL
            + "/nilai/update/{NIS}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateSiswa(@RequestBody @Validated TableNilai payload, @PathVariable String NIS) {
        return nilaiService.updateNilai(payload, NIS);
    }

    @RequestMapping(value = NilaiController.URL
            + "/nilai/list-nilai-desc", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getDataDesc() {
        return nilaiService.getDataDesc();
    }
}
