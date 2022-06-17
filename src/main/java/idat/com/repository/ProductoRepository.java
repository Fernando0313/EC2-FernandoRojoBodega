package idat.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import idat.com.model.Productos;

@Repository
public interface ProductoRepository extends JpaRepository<Productos, Integer>{

}
