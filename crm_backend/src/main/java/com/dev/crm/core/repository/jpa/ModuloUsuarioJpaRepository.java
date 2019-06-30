package com.dev.crm.core.repository.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.crm.core.model.entity.ModuloUsuario;

@Repository("moduloUsuarioJpaRepository")
public interface ModuloUsuarioJpaRepository extends JpaRepository<ModuloUsuario, Integer> {

	List<ModuloUsuario> findByDocumentoUsuario(String documentoUsuario);
}
