package idat.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import idat.com.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	Usuario findByUsuario(String usuario);
}
