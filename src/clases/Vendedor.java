package clases;

public class Vendedor {

	private int codigoVendedor, categoria;
	private String nombres, apellidos, telefono, dni;

	public Vendedor(int codigoVendedor, int categoria, String nombres, String apellidos, String telefono, String dni) {
		this.codigoVendedor = codigoVendedor;
		this.categoria = categoria;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.telefono = telefono;
		this.dni = dni;
	}

	public void setCodigoVendedor(int codigoVendedor) {
		this.codigoVendedor = codigoVendedor;
	}

	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getCodigoVendedor() {
		return codigoVendedor;
	}

	public int getCategoria() {
		return categoria;
	}

	public String getNombres() {
		return nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getDni() {
		return dni;
	}

}
