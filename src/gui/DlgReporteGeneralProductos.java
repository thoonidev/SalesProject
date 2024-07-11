package gui;

import arreglos.*;
import clases.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DlgReporteGeneralProductos extends JDialog implements ActionListener {
	private JButton btnListar;
	private JTextArea txtAreaResultado;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgReporteGeneralProductos dialog = new DlgReporteGeneralProductos();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgReporteGeneralProductos() {
		setTitle("Reporte General por Productos");
		setBounds(100, 100, 642, 431);
		getContentPane().setLayout(null);

		btnListar = new JButton("LISTAR");
		btnListar.addActionListener(this);
		btnListar.setBounds(267, 11, 89, 23);
		getContentPane().add(btnListar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 606, 336);
		getContentPane().add(scrollPane);

		txtAreaResultado = new JTextArea();
		txtAreaResultado.setFont(new Font("Monospaced", Font.BOLD, 13));
		scrollPane.setViewportView(txtAreaResultado);
	}

	// DECLARACION GLOBAL
	ArregloFacturas af = new ArregloFacturas();

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnListar) {
			actionPerformedBtnListar(e);
		}
	}

	protected void actionPerformedBtnListar(ActionEvent e) {
		// Inicializa un HashMap para rastrear la informaci�n del reporte.
	    HashMap<Integer, ReporteProducto> reporte = new HashMap<>();

	    // Itera a traves de las facturas para calcular la informaci�n del reporte.
	    for (int i = 0; i < af.tamanio(); i++) {
	        Factura factura = af.obtener(i);
	        int codigoProducto = factura.getCodigoProducto();
	        int unidadesVendidas = factura.getUnidades();
	        double importeTotal = factura.getPrecio();

	        if (reporte.containsKey(codigoProducto)) {
	            // Si el producto ya esta en el informe, actualiza la informaci�n acumulada.
	            ReporteProducto reporteProducto = reporte.get(codigoProducto);
	            reporteProducto.incrementarVentas();
	            reporteProducto.incrementarUnidades(unidadesVendidas);
	            reporteProducto.incrementarImporteTotal(importeTotal);
	        } else {
	            // Si el producto no esta en el informe, crea una nueva entrada.
	            ReporteProducto reporteProducto = new ReporteProducto();
	            reporteProducto.setCodigoProducto(codigoProducto);
	            reporteProducto.incrementarVentas();
	            reporteProducto.incrementarUnidades(unidadesVendidas);
	            reporteProducto.incrementarImporteTotal(importeTotal);
	            reporte.put(codigoProducto, reporteProducto);
	        }
	    }

	    // Genera el informe y muestra la informacion en txtAreaResultado.
	    txtAreaResultado.setText("Reporte General por Productos:\n");
	    for (ReporteProducto reporteProducto : reporte.values()) {
	        String infoProducto = "Codigo de Producto: " + reporteProducto.getCodigoProducto() + "\n" +
	                             "Numero de Ventas: " + reporteProducto.getVentas() + "\n" +
	                             "Unidades Vendidas Acumuladas: " + reporteProducto.getUnidades() + "\n" +
	                             "Importe Total Acumulado: " + reporteProducto.getImporteTotal() + "\n\n";
	        imprimir(infoProducto);
	    }
	}

	void imprimir(String s) {
		txtAreaResultado.append(s + "\n");
	}
}
