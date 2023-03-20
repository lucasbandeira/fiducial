package com.names.fiducial.name;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NameRepository extends JpaRepository<Name, Long> {
    @Query(value = "SELECT n FROM Name n ")
    Page<Name> getNames(final Pageable pageable);
    @Query("SELECT CASE WHEN COUNT(n) > 0 THEN true ELSE false END FROM Name n WHERE n.name = :name")
    boolean existsByName(@Param("name") String name);
}
