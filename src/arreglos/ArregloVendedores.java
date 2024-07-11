package arreglos;

import java.io.*;
import java.util.ArrayList;
import clases.Vendedor;

public class ArregloVendedores {
	private ArrayList<Vendedor> vendedor;

	public ArregloVendedores() {
		vendedor = new ArrayList<Vendedor>();

		cargarVendedores();
	}

	public void adicionar(Vendedor x) {
		vendedor.add(x);
		grabarVendedores();
	}

	public void eliminar(Vendedor x) {
		vendedor.remove(x);
		grabarVendedores();
	}

	public int tamanio() {
		return vendedor.size();
	}

	public Vendedor obtener(int i) {
		return vendedor.get(i);
	}

	public Vendedor buscar(int codigo) {
		for (int i = 0; i < vendedor.size(); i++) {
			if (vendedor.get(i).getCodigoVendedor() == codigo)
				return vendedor.get(i);
		}
		return null;
	}

	public int codigoCorrelativo() {
		if (vendedor.size() == 0)
			return 2001;
		return vendedor.get(vendedor.size() - 1).getCodigoVendedor() + 1;
	}

	public void ActualizarArchivo() {
		grabarVendedores();
	}

	private void grabarVendedores() {
		try {
			PrintWriter pw;
			String linea;
			Vendedor x;
			pw = new PrintWriter(new FileWriter("vendedores.txt"));
			for (int i = 0; i < vendedor.size(); i++) {
				x = vendedor.get(i);
				linea = x.getCodigoVendedor() + ";" + x.getCategoria() + ";" + x.getNombres() + ";" + x.getApellidos()
						+ ";" + x.getTelefono() + ";" + x.getDni();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}

	private void cargarVendedores() {
		try {
			BufferedReader br;
			String linea, nombres, apellidos, telefono, dni;
			String[] s;
			int codigoVendedor, categoria;
			br = new BufferedReader(new FileReader("vendedores.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigoVendedor = Integer.parseInt(s[0].trim());
				categoria = Integer.parseInt(s[1].trim());
				nombres = s[2].trim();
				apellidos = s[3].trim();
				telefono = s[4].trim();
				dni = s[5].trim();
				adicionar(new Vendedor(codigoVendedor, categoria, nombres, apellidos, telefono, dni));
			}
			br.close();
		} catch (Exception e) {
		}
	}
}
