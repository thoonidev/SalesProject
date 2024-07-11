package clases;

public class Producto {

	private int codigoProducto;
	private String descripcion;
	private double precio;

	public Producto(int codigoProducto, String descripcion, double precio) {
		this.codigoProducto = codigoProducto;
		this.descripcion = descripcion;
		this.precio = precio;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getPrecio() {
		return precio;
	}

}
