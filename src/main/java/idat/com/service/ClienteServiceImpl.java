package idat.com.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.com.dto.request.ClienteActualizar;
import idat.com.dto.request.ClienteRegistro;
import idat.com.dto.response.ClienteDTO;
import idat.com.model.Cliente;
import idat.com.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	ClienteRepository repo;

	@Override
	public void registoCliente(ClienteRegistro cliente) {
		// TODO Auto-generated method stub
		
		Cliente _cliente = new Cliente();
		_cliente.setDireccion(cliente.getDireccionDTO());
		_cliente.setDni(cliente.getDniDTO());
		_cliente.setNombre(cliente.getNombreDTO());
		repo.save(_cliente);
		
	}

	@Override
	public void actualizarCliente(ClienteActualizar cliente) {
		// TODO Auto-generated method stub
		Cliente _cliente = new Cliente();
		_cliente.setDireccion(cliente.getDireccionDTO());
		_cliente.setDni(cliente.getDniDTO());
		_cliente.setNombre(cliente.getNombreDTO());
		_cliente.setIdCliente(cliente.getIdClienteDTO());
		repo.saveAndFlush(_cliente);
		
		
	}

	@Override
	public List<ClienteDTO> listarClientes() {
		// TODO Auto-generated method stub
		List<ClienteDTO> clienteDTOlist = new ArrayList<>();
		ClienteDTO _cliente = null;
		
		if(repo.findAll().size()==0) {
			return clienteDTOlist;
		}
		for(Cliente cliente : repo.findAll()) {
			_cliente = new ClienteDTO();
			_cliente.setDireccionDTO(cliente.getDireccion());
			_cliente.setDniDTO(cliente.getDni());
			_cliente.setNombreDTO(cliente.getNombre());
			_cliente.setIdClienteDTO(cliente.getIdCliente());
			clienteDTOlist.add(_cliente);
		}
		
		return clienteDTOlist;
	}

	@Override
	public ClienteDTO buscarCliente(Integer id) {
		// TODO Auto-generated method stub
		Optional<Cliente> cliente = repo.findById(id);
		ClienteDTO _cliente = new ClienteDTO();
		_cliente = new ClienteDTO();
		_cliente.setDireccionDTO(cliente.get().getDireccion());
		_cliente.setDniDTO(cliente.get().getDni());
		_cliente.setNombreDTO(cliente.get().getNombre());
		_cliente.setIdClienteDTO(cliente.get().getIdCliente());
		return _cliente;
	}
	
	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
	repo.deleteById(id);	
	}
}
