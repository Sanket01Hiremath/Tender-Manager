package com.app.Tenders.Repository;

import com.app.Tenders.Entity.tender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface tenderRepo extends JpaRepository<tender,Integer> {
}
