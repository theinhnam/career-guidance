package com.theinhnam.schooldata.repositories.document;

import com.theinhnam.schooldata.entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDocumentRepository extends JpaRepository<Document, Long> {
    List<Document> findByMajorCode(String majorCode);
}
