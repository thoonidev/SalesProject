package clases;

public class Factura {

	private int codigoFactura, codigoProducto, codigoVendedor, unidades;
	private double precio;

	public Factura(int codigoFactura, int codigoProducto, int codigoVendedor, int unidades, double precio) {
		this.codigoFactura = codigoFactura;
		this.codigoProducto = codigoProducto;
		this.codigoVendedor = codigoVendedor;
		this.unidades = unidades;
		this.precio = precio;
	}

	public void setCodigoFactura(int codigoFactura) {
		this.codigoFactura = codigoFactura;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public void setCodigoVendedor(int codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCodigoFactura() {
		return codigoFactura;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public int getCodigoVendedor() {
		return codigoVendedor;
	}

	public int getUnidades() {
		return unidades;
	}

	public double getPrecio() {
		return precio;
	}

}
