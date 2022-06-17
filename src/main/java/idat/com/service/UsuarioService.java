package idat.com.service;

import java.util.List;

import idat.com.dto.request.UsuarioRegistro;
import idat.com.model.Usuario;

public interface UsuarioService {

	public void registrar(UsuarioRegistro usuario);
	public void actualizar(Usuario usuario);
	public void eliminar(Integer id);
	public  Usuario buscarId(Integer id);
	public List<Usuario> listar();
	
}
