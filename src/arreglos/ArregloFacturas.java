package arreglos;

import java.io.*;
import java.util.ArrayList;
import clases.Factura;

public class ArregloFacturas {
	private ArrayList<Factura> factura;

	public ArregloFacturas() {
		factura = new ArrayList<Factura>();
		cargarFacturas();
	}

	public void adicionar(Factura x) {
		factura.add(x);
		grabarFacturas();
	}

	public void eliminar(Factura x) {
		factura.remove(x);
		grabarFacturas();
	}

	public int tamanio() {
		return factura.size();
	}

	public Factura obtener(int i) {
		return factura.get(i);
	}

	public Factura buscar(int codigo) {
		for (int i = 0; i < factura.size(); i++) {
			if (factura.get(i).getCodigoFactura() == codigo)
				return factura.get(i);
		}
		return null;
	}

	public Factura buscarCod(int codigo) {
		for (int i = 0; i < factura.size(); i++) {
			if (factura.get(i).getCodigoProducto() == codigo)
				return factura.get(i);
		}
		return null;
	}

	public int codigoCorrelativo() {
		if (factura.size() == 0)
			return 4001;
		return factura.get(factura.size() - 1).getCodigoFactura() + 1;
	}

	public void ActualizarArchivo() {
		grabarFacturas();
	}

	private void grabarFacturas() {
		try {
			PrintWriter pw;
			String linea;
			Factura x;
			pw = new PrintWriter(new FileWriter("facturas.txt"));
			for (int i = 0; i < factura.size(); i++) {
				x = factura.get(i);
				linea = x.getCodigoFactura() + ";" + x.getCodigoProducto() + ";" + x.getCodigoVendedor() + ";"
						+ x.getUnidades() + ";" + x.getPrecio();
				pw.println(linea);
			}
			pw.close();
		} catch (Exception e) {
		}
	}

	private void cargarFacturas() {
		try {
			BufferedReader br;
			int codigoFactura, codigoProducto, codigoVendedor, unidades;
			double precio;
			String linea;
			String[] s;
			br = new BufferedReader(new FileReader("facturas.txt"));
			while ((linea = br.readLine()) != null) {
				s = linea.split(";");
				codigoFactura = Integer.parseInt(s[0].trim());
				codigoProducto = Integer.parseInt(s[1].trim());
				codigoVendedor = Integer.parseInt(s[2].trim());
				unidades = Integer.parseInt(s[3].trim());
				precio = Double.parseDouble(s[4].trim());
				adicionar(new Factura(codigoFactura, codigoProducto, codigoVendedor, unidades, precio));
			}
			br.close();
		} catch (Exception e) {
		}
	}

}
