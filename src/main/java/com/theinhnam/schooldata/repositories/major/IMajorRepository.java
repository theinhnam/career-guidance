package com.theinhnam.schooldata.repositories.major;

import com.theinhnam.schooldata.entities.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMajorRepository extends JpaRepository<Major, Long> {
}
