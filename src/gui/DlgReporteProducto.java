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

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class DlgReporteProducto extends JDialog implements ActionListener {
	private JButton btnListar;
	private JTextArea txtAreaResultado;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgReporteProducto dialog = new DlgReporteProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgReporteProducto() {
		setTitle("Reporte por Producto ");
		setBounds(100, 100, 653, 434);
		getContentPane().setLayout(null);

		btnListar = new JButton("LISTAR");
		btnListar.addActionListener(this);
		btnListar.setBounds(273, 11, 89, 23);
		getContentPane().add(btnListar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 617, 339);
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
	        txtAreaResultado.setText(""); // Limpiar el �rea de resultados

	       

	        // Iterar a traves de las facturas para generar el informe por producto.
	        for (int i = 0; i < af.tamanio(); i++) {
	            Factura factura = af.obtener(i);
	         // Obtener el c�digo del producto de la factura.
	            int codigoProducto = factura.getCodigoProducto();
	            if (factura.getCodigoProducto() == codigoProducto) {
	                int codigoFactura = factura.getCodigoFactura();
	                int codigoVendedor = factura.getCodigoVendedor();
	                int unidadesVendidas = factura.getUnidades();
	                double precioUnitario = factura.getPrecio();

	                String infoVenta = "Codigo de Factura: " + codigoFactura + "\n" +
	                                  "Codigo de Vendedor: " + codigoVendedor + "\n" +
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
