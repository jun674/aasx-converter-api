package com.aas.converter.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.digitaltwin.aas4j.v3.dataformat.aasx.AASXDeserializer;
import org.eclipse.digitaltwin.aas4j.v3.dataformat.json.JsonSerializer;
import org.eclipse.digitaltwin.aas4j.v3.model.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.util.Map;

@Slf4j
@Service
public class AasxConverterService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public Map<String, Object> convertAasxToJson(MultipartFile file) throws Exception {
        log.info("Starting AASX to JSON conversion for file: {}", file.getOriginalFilename());
        
        // AASX 파일을 Environment 객체로 역직렬화
        AASXDeserializer deserializer = new AASXDeserializer(file.getInputStream());
        Environment environment = deserializer.read();
        // AASXDeserializer는 AutoCloseable이 아니므로 close() 메서드가 없음
        
        log.info("Successfully deserialized AASX file");
        log.info("Found {} AAS, {} Submodels, {} ConceptDescriptions", 
            environment.getAssetAdministrationShells() != null ? environment.getAssetAdministrationShells().size() : 0,
            environment.getSubmodels() != null ? environment.getSubmodels().size() : 0,
            environment.getConceptDescriptions() != null ? environment.getConceptDescriptions().size() : 0
        );
        
        // Environment 객체를 JSON으로 직렬화
        JsonSerializer jsonSerializer = new JsonSerializer();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        jsonSerializer.write(outputStream, environment);
        
        String jsonString = outputStream.toString("UTF-8");
        outputStream.close();
        
        // JSON 문자열을 Map으로 변환하여 반환
        Map<String, Object> result = objectMapper.readValue(jsonString, Map.class);
        
        log.info("Successfully converted to JSON");
        return result;
    }
}