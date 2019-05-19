package com.dev.crm.core.repository.jpa;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dev.crm.core.model.entity.Cargo;

@Repository("cargoJpaRepository")
public interface CargoJpaRepository extends JpaRepository<Cargo, String> {

	@Query("SELECT c FROM Cargo c " +
			"WHERE LOWER(c.descripcionCargo) LIKE LOWER(CONCAT('%',:termino, '%'))")
	List<Cargo> findByDescripcionCargo(@Param("termino") String termino);
}
