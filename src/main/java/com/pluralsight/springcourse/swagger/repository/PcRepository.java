package com.pluralsight.springcourse.swagger.repository;

import com.pluralsight.springcourse.swagger.model.Pc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PcRepository extends JpaRepository<Pc, Long> {

}
