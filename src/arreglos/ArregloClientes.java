package arreglos;

import java.io.*;
import java.util.ArrayList;
import clases.Cliente;

public class ArregloClientes {
	private ArrayList<Cliente> cliente;

	public ArregloClientes() {
		cliente = new ArrayList<Cliente>();

		cargarClientes();
	}

	public void adicionar(Cliente x) {
		cliente.add(x);
		grabarClientes();
	}

	public void eliminar(Cliente x) {
		cliente.remove(x);
		grabarClientes();
	}

	public int tamanio() {
		return cliente.size();
	}

	public Cliente obtener(int i) {
		return cliente.get(i);
	}

	public Cliente buscar(int codigo) {
		for (int i = 0; i < cliente.size(); i++) {
			if (cliente.get(i).getCodigoCliente() == codigo)
				return cliente.get(i);
		}
		return null;
	}

	public int codigoCorrelativo() {
		if (cliente.size() == 0)
			return 1001;
		return cliente.get(cliente.size() - 1).getCodigoCliente() + 1;
	}

	public void ActualizarArchivo() {
		grabarClientes();
	}

	private void grabarClientes() {
		try {
			PrintWriter pw;
			String linea;
			Cliente x;
			pw = new PrintWriter(new FileWriter("clientes.txt"));
			for (int i = 0; i < cliente.size(); i++) {
				x = cliente.get(i);
				linea = x.getCodigoCliente() + ";" + x.getNombres() + ";" + x.getApellidos() + ";" + x.getTelefono()
						+ ";" + x.getDni();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}

	private void cargarClientes() {
		try {
			BufferedReader br;
			String linea, nombres, apellidos, telefono, dni;
			String[] s;
			int codigoCliente;
			br = new BufferedReader(new FileReader("clientes.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigoCliente = Integer.parseInt(s[0].trim());
				nombres = s[1].trim();
				apellidos = s[2].trim();
				telefono = s[3].trim();
				dni = s[4].trim();
				adicionar(new Cliente(codigoCliente, nombres, apellidos, telefono, dni));
			}
			br.close();
		} catch (Exception e) {
		}
	}
}
