package arreglos;

import java.io.*;
import java.util.ArrayList;
import clases.Producto;

public class ArregloProductos {
	private ArrayList<Producto> producto;

	public ArregloProductos() {
		producto = new ArrayList<Producto>();
		cargarProductos();
	}

	public void adicionar(Producto x) {
		producto.add(x);
		grabarProductos();
	}

	public void eliminar(Producto x) {
		producto.remove(x);
		grabarProductos();
	}

	public int tamanio() {
		return producto.size();
	}

	public Producto obtener(int i) {
		return producto.get(i);
	}

	public Producto buscar(int codigo) {
		for (int i = 0; i < producto.size(); i++) {
			if (producto.get(i).getCodigoProducto() == codigo)
				return producto.get(i);
		}
		return null;
	}

	public int codigoCorrelativo() {
		if (producto.size() == 0)
			return 3001;
		return producto.get(producto.size() - 1).getCodigoProducto() + 1;
	}

	public void ActualizarArchivo() {
		grabarProductos();
	}

	private void grabarProductos() {
		try {
			PrintWriter pw;
			String linea;
			Producto x;
			pw = new PrintWriter(new FileWriter("productos.txt"));
			for (int i = 0; i < producto.size(); i++) {
				x = producto.get(i);
				linea = x.getCodigoProducto() + ";" + x.getDescripcion() + ";" + x.getPrecio();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}

	private void cargarProductos() {
		try {
			BufferedReader br;
			int codigoProducto;
			String linea, descripcion;
			double precio;
			String[] s;
			br = new BufferedReader(new FileReader("productos.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigoProducto = Integer.parseInt(s[0].trim());
				descripcion = s[1].trim();
				precio = Double.parseDouble(s[2].trim());
				adicionar(new Producto(codigoProducto, descripcion, precio));
			}
			br.close();
		} catch (Exception e) {
		}
	}
}
