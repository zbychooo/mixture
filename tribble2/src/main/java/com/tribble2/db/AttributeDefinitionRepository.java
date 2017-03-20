package com.tribble2.db;

import com.tribble2.model.AttributeDefinition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttributeDefinitionRepository extends JpaRepository<AttributeDefinition, Long> {
}