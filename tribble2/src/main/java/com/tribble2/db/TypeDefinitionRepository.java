package com.tribble2.db;

import com.tribble2.model.TypeDefinition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TypeDefinitionRepository extends JpaRepository<TypeDefinition, Long> {

    @Query("SELECT p FROM TypeDefinition p WHERE p.parentId= null")
    public List<TypeDefinition> getRootTypes();

    @Query("SELECT p FROM TypeDefinition p WHERE p.parentId= :parentId")
    public List<TypeDefinition> getChildrenTypes(@Param("parentId") Long parentId);

}
