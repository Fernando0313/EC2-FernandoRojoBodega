package idat.com.dto.request;

public class ProductoRegistrar {
	
	private String producto;
	private String descripcion;
	private Double precio;
	private Integer stock;
	
	public ProductoRegistrar() {
		// TODO Auto-generated constructor stub
	}



	public String getProducto() {
		return producto;
	}

	public void setProducto(String producto) {
		this.producto = producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	
	
}
