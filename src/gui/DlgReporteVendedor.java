package gui;

import arreglos.*;
import clases.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import arreglos.ArregloFacturas;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DlgReporteVendedor extends JDialog implements ActionListener {
	private JButton btnListar;
	private JTextArea txtAreaResultado;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgReporteVendedor dialog = new DlgReporteVendedor();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgReporteVendedor() {
		setTitle("Reporte por Vendedor ");
		setBounds(100, 100, 654, 430);
		getContentPane().setLayout(null);

		btnListar = new JButton("LISTAR");
		btnListar.addActionListener(this);
		btnListar.setBounds(269, 11, 89, 23);
		getContentPane().add(btnListar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 618, 335);
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
			txtAreaResultado.setText(""); // Limpiar el area de resultados

			

	        // Iterar a traves de las facturas para generar el informe por vendedor.
	        for (int i = 0; i < af.tamanio(); i++) {
	            Factura factura = af.obtener(i);
	         // Obtener el c�digo del vendedor de la factura.
	            int codigoVendedor = factura.getCodigoVendedor();

	            if (factura.getCodigoVendedor() == codigoVendedor) {
	                int codigoFactura = factura.getCodigoFactura();
	                int codigoProducto = factura.getCodigoProducto();
	                int unidadesVendidas = factura.getUnidades();
	                double precioUnitario = factura.getPrecio();

	                String infoVenta = "Codigo de Factura: " + codigoFactura + "\n" +
	                                  "Codigo de Producto: " + codigoProducto + "\n" +
	                                  "Unidades Vendidas: " + unidadesVendidas + "\n" +
	                                  "Precio Unitario: " + precioUnitario + "\n\n";

	                imprimir(infoVenta);
	            }
	        }
		}

	void imprimir(String s) {
		txtAreaResultado.append(s + "\n");
	}
}
