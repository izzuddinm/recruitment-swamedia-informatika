package com.recruitment.managementgradestudent.controller;

import com.recruitment.managementgradestudent.model.table.TableMataPelajaran;
import com.recruitment.managementgradestudent.service.MataPelajaranService;
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
public class MataPelajaranController {
    @Autowired
    private MataPelajaranService mataPelajaranService;
    private static final String URL = "/service";
    @RequestMapping(value = MataPelajaranController.URL
            + "/mapel/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> createSiswa(@RequestBody @Validated TableMataPelajaran payload) {
        return mataPelajaranService.createMataPelajaran(payload);
    }

    @RequestMapping(value = MataPelajaranController.URL
            + "/mapel/delete/{kodeMapel}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteSiswa(@PathVariable String kodeMapel) {
        return mataPelajaranService.deleteMataPelajaran(kodeMapel);
    }

    @RequestMapping(value = MataPelajaranController.URL
            + "/mapel/update/{kodeMapel}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> updateSiswa(@RequestBody @Validated TableMataPelajaran payload, @PathVariable String kodeMapel) {
        return mataPelajaranService.updateMataPelajaran(payload, kodeMapel);
    }

    @RequestMapping(value = MataPelajaranController.URL
            + "/mapel/list-mapel", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAllSiswa() {
        return mataPelajaranService.getAllMataPelajaran();
    }
}
