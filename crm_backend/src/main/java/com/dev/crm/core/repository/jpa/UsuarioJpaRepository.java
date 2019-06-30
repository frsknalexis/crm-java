package com.dev.crm.core.repository.jpa;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.crm.core.model.entity.Usuario;

@Repository("usuarioJpaRepository")
public interface UsuarioJpaRepository extends JpaRepository<Usuario, BigDecimal> {

	Usuario findByNombreUsuario(String nombreUsuario);
}
