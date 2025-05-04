package com.theinhnam.schooldata.services;

import com.theinhnam.schooldata.dto.DocumentDTO;
import com.theinhnam.schooldata.repositories.document.IDocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DocumentService {
    private final IDocumentRepository documentRepository;

    public List<DocumentDTO> getDocumentsByMajor(String majorCode) {
        return documentRepository.findByMajorCode(majorCode)
                .stream()
                .map(doc -> new DocumentDTO(doc.getId(), doc.getTitle(), doc.getUrl()))
                .toList();
    }
}
