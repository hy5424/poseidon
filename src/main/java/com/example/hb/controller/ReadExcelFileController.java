package com.example.hb.controller;

import com.example.hb.service.ReadExcelFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/read")
public class ReadExcelFileController {

    @Autowired
    ReadExcelFileService readExcelFileService;

    @RequestMapping("/excel")
    public void readExcel(){
        readExcelFileService.readExcelFile("ss1");
    }

}
