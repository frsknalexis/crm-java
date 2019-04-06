package com.dev.crm.core.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dev.crm.core.model.entity.Ubigeo;

@Repository("ubigeoJpaRepository")
public interface UbigeoJpaRepository extends JpaRepository<Ubigeo, String> {

	@Query("SELECT u FROM Ubigeo u " + 
			"WHERE LOWER(u.nombreUbigeo) LIKE LOWER(CONCAT('%' ,:termino, '%'))")
	List<Ubigeo> findByNombreUbigeo(@Param("termino")String termino);
}
