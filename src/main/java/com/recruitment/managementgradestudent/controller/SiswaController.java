package com.recruitment.managementgradestudent.controller;

import com.recruitment.managementgradestudent.model.table.TableSiswa;
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
public class SiswaController {
    @Autowired
    private SiswaService siswaService;
    private static final String URL = "/service";
    @RequestMapping(value = SiswaController.URL
            + "/siswa/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createSiswa(@RequestBody @Validated TableSiswa payload) {
        return siswaService.createSiswa(payload);
    }

    @RequestMapping(value = SiswaController.URL
            + "/siswa/delete/{NIS}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteSiswa(@RequestBody @Validated TableSiswa payload, @PathVariable String NIS) {
        return siswaService.deleteSiswa(payload, NIS);
    }

    @RequestMapping(value = SiswaController.URL
            + "/siswa/update/{NIS}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateSiswa(@RequestBody @Validated TableSiswa payload, @PathVariable String NIS) {
        return siswaService.updateSiswa(payload, NIS);
    }

    @RequestMapping(value = SiswaController.URL
            + "/siswa/list-siswa", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAllSiswa() {
        return siswaService.getAllSiswa();
    }
}
