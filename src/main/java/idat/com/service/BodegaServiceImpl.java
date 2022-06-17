package idat.com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import idat.com.dto.request.BodegaActualizar;
import idat.com.dto.request.BodegaRegistrar;
import idat.com.model.Bodega;
import idat.com.model.Productos;
import idat.com.repository.BodegaRepository;
import idat.com.repository.ProductoRepository;

@Service
public class BodegaServiceImpl implements BodegaService {

	@Autowired
	BodegaRepository repo;
	@Autowired
	ProductoRepository repoP;
	
	@Override
	public void registo(BodegaRegistrar bodega) {
		// TODO Auto-generated method stub
		Bodega _bodega = new Bodega();
		_bodega.setDireccion(bodega.getDireccion());
		_bodega.setNombre(bodega.getNombre());
		Optional<Productos> productos = repoP.findById(bodega.getIdProducto());
		_bodega.setProducto(productos.get());
		
		repo.save(_bodega);
	}

	@Override
	public void actualizarBodega(BodegaActualizar bodega) {
		// TODO Auto-generated method stub
		Bodega _bodega = new Bodega();
		_bodega.setDireccion(bodega.getDireccion());
		_bodega.setNombre(bodega.getNombre());
		Optional<Productos> productos = repoP.findById(bodega.getIdProducto());
		_bodega.setProducto(productos.get());
		_bodega.setIdBodega(bodega.getIdBodega());
		repo.saveAndFlush(_bodega);
		
	}

	@Override
	public List<Bodega> listar() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Bodega buscarId(Integer id) {
		// TODO Auto-generated method stub
		return repo.findById(id).get();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
		
	}

}
