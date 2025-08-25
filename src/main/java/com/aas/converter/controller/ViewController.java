package com.aas.converter.controller;

import com.aas.converter.service.AasxConverterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ViewController {

    @Autowired
    private AasxConverterService converterService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/upload")
    @ResponseBody
    public Map<String, Object> uploadFile(@RequestParam("file") MultipartFile file) {
        Map<String, Object> response = new HashMap<>();
        
        try {
            if (file.isEmpty()) {
                response.put("error", "파일이 비어있습니다.");
                return response;
            }

            if (!file.getOriginalFilename().toLowerCase().endsWith(".aasx")) {
                response.put("error", "AASX 파일만 업로드 가능합니다.");
                return response;
            }

            Map<String, Object> jsonData = converterService.convertAasxToJson(file);
            response.putAll(jsonData);
            
        } catch (Exception e) {
            response.put("error", "파일 변환 중 오류가 발생했습니다: " + e.getMessage());
        }
        
        return response;
    }
}