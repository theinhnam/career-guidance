package com.theinhnam.schooldata.controllers;

import com.theinhnam.schooldata.dto.DocumentDTO;
import com.theinhnam.schooldata.services.DocumentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/documents")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentService documentService;

    @GetMapping
    public ResponseEntity<List<DocumentDTO>> getDocuments(@RequestParam String majorCode) {
        List<DocumentDTO> result = documentService.getDocumentsByMajor(majorCode);
        return ResponseEntity.ok(result);
    }
}
