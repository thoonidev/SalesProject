package clases;

public class ReporteProducto {
	private int codigoProducto;
	private int ventas;
	private int unidades;
	private double importeTotal;

	public ReporteProducto() {
		ventas = 0;
		unidades = 0;
		importeTotal = 0.0;
	}

	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}

	public void setVentas(int ventas) {
		this.ventas = ventas;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}

	public int getCodigoProducto() {
		return codigoProducto;
	}

	public int getVentas() {
		return ventas;
	}

	public int getUnidades() {
		return unidades;
	}

	public double getImporteTotal() {
		return importeTotal;
	}

	// M�todos para actualizar la informaci�n del reporte.
	public void incrementarVentas() {
		ventas++;
	}

	public void incrementarUnidades(int cantidad) {
		unidades += cantidad;
	}

	public void incrementarImporteTotal(double importe) {
		importeTotal += importe;
	}
}
