package gui;

import arreglos.*;
import clases.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DlgReportePrecios extends JDialog implements ActionListener {
	private JButton btnListar;
	private JTextArea txtAreaResultado;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgReportePrecios dialog = new DlgReportePrecios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgReportePrecios() {
		setTitle("Reporte por Precios");
		setBounds(100, 100, 656, 432);
		getContentPane().setLayout(null);

		btnListar = new JButton("LISTAR");
		btnListar.addActionListener(this);
		btnListar.setBounds(276, 11, 89, 23);
		getContentPane().add(btnListar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 620, 337);
		getContentPane().add(scrollPane);

		txtAreaResultado = new JTextArea();
		txtAreaResultado.setFont(new Font("Monospaced", Font.BOLD, 13));
		scrollPane.setViewportView(txtAreaResultado);

	}

	// DECLARACION GLOBAL
	ArregloProductos ap = new ArregloProductos();

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
	}

	protected void actionPerformedBtnListar(ActionEvent e) {
	        txtAreaResultado.setText(""); // Limpiar el area de resultados

	        // Recopilar todos los precios de los productos disponibles.
	        List<Double> precios = new ArrayList<>();
	        for (int i = 0; i < ap.tamanio(); i++) {
	            Producto producto = ap.obtener(i);
	            double precio = producto.getPrecio();
	            precios.add(precio);
	        }

	        if (!precios.isEmpty()) {
	            // Calcular el precio promedio.
	            double precioPromedio = calcularPrecioPromedio(precios);

	            // Calcular el precio maximo.
	            double precioMaximo = calcularPrecioMaximo(precios);

	            // Calcular el precio minimo.
	            double precioMinimo = calcularPrecioMinimo(precios);

	            // Mostrar el informe de precios.
	            imprimir("Precio Promedio: " + precioPromedio);
	            imprimir("Precio Maximo: " + precioMaximo);
	            imprimir("Precio Minimo: " + precioMinimo);
	        } else {
	            imprimir("No hay productos disponibles para calcular los precios.");
	        }
	    }

	private double calcularPrecioPromedio(List<Double> precios) {
		double suma = 0.0;
		for (double precio : precios) {
			suma += precio;
		}
		return suma / precios.size();
	}

	private double calcularPrecioMaximo(List<Double> precios) {
		return Collections.max(precios);
	}

	private double calcularPrecioMinimo(List<Double> precios) {
		return Collections.min(precios);
	}

	void imprimir(String s) {
		txtAreaResultado.append(s + "\n");
	}

}
