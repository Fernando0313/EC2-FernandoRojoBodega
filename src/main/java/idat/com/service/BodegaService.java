package idat.com.service;

import java.util.List;

import idat.com.dto.request.BodegaActualizar;
import idat.com.dto.request.BodegaRegistrar;
import idat.com.dto.request.ClienteActualizar;
import idat.com.dto.request.ClienteRegistro;
import idat.com.dto.response.ClienteDTO;
import idat.com.model.Bodega;

public interface BodegaService {
	public void registo(BodegaRegistrar bodega);
	public void actualizarBodega(BodegaActualizar bodega);
	public List<Bodega> listar();
	public Bodega  buscarId(Integer id);
	public void eliminar(Integer id);
}
