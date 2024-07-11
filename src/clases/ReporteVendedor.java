package clases;

public class ReporteVendedor {
	private int codigoVendedor;
	private int ventas;
	private int unidades;
	private double importeTotal;

	public ReporteVendedor() {
		ventas = 0;
		unidades = 0;
		importeTotal = 0.0;
	}

	// M�todos para actualizar la informaci�n del reporte de vendedor.
	public void incrementarVentas() {
		ventas++;
	}

	public void incrementarUnidades(int cantidad) {
		unidades += cantidad;
	}

	public void incrementarImporteTotal(double importe) {
		importeTotal += importe;
	}

	// Getters y setters.
	public int getCodigoVendedor() {
		return codigoVendedor;
	}

	public void setCodigoVendedor(int codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
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
}
