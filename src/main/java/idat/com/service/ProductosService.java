package idat.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.com.dto.request.ProductoActualizar;
import idat.com.dto.request.ProductoRegistrar;
import idat.com.dto.request.UsuarioRegistro;
import idat.com.model.Productos;
import idat.com.model.Usuario;
import idat.com.repository.ProductoRepository;



public interface ProductosService {
	public void registrar(ProductoRegistrar producto);
	public void actualizar(ProductoActualizar producto);
	public void eliminar(Integer id);
	public  Productos buscarId(Integer id);
	public List<Productos> listar();
	

}
