package idat.com.service;

import java.util.List;

import idat.com.dto.request.ClienteActualizar;
import idat.com.dto.request.ClienteRegistro;
import idat.com.dto.response.ClienteDTO;

public interface ClienteService {

	public void registoCliente(ClienteRegistro cliente);
	public void actualizarCliente(ClienteActualizar cliente);
	public List<ClienteDTO> listarClientes();
	public ClienteDTO  buscarCliente(Integer id);
	
}
