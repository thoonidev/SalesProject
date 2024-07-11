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

public class DlgReporteGeneralVendedores extends JDialog implements ActionListener {
	private JButton btnListar;
	private JTextArea txtAreaResultado;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgReporteGeneralVendedores dialog = new DlgReporteGeneralVendedores();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgReporteGeneralVendedores() {
		setTitle("Reporte General por Vendedores");
		setBounds(100, 100, 652, 432);
		getContentPane().setLayout(null);

		btnListar = new JButton("LISTAR");
		btnListar.addActionListener(this);
		btnListar.setBounds(262, 11, 89, 23);
		getContentPane().add(btnListar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 45, 616, 337);
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
        // Inicializa un HashMap para rastrear la informacion del reporte por vendedores.
        HashMap<Integer, ReporteVendedor> reporte = new HashMap<>();

        // Itera a traves de las facturas para calcular la informacion del informe.
        for (int i = 0; i < af.tamanio(); i++) {
            Factura factura = af.obtener(i);
            int codigoVendedor = factura.getCodigoVendedor();
            int unidadesVendidas = factura.getUnidades();
            double importeTotal = factura.getPrecio();

            if (reporte.containsKey(codigoVendedor)) {
                // Si el vendedor ya esta en el informe, actualiza la informacion acumulada.
                ReporteVendedor reporteVendedor = reporte.get(codigoVendedor);
                reporteVendedor.incrementarVentas();
                reporteVendedor.incrementarUnidades(unidadesVendidas);
                reporteVendedor.incrementarImporteTotal(importeTotal);
            } else {
                // Si el vendedor no esta en el informe, crea una nueva entrada.
                ReporteVendedor reporteVendedor = new ReporteVendedor();
                reporteVendedor.setCodigoVendedor(codigoVendedor);
                reporteVendedor.incrementarVentas();
                reporteVendedor.incrementarUnidades(unidadesVendidas);
                reporteVendedor.incrementarImporteTotal(importeTotal);
                reporte.put(codigoVendedor, reporteVendedor);
            }
        }

        // Genera el informe y muestra la informaci�n en txtAreaResultado.
        txtAreaResultado.setText("Reporte General por Vendedores:\n");
        for (ReporteVendedor reporteVendedor : reporte.values()) {
            String infoVendedor = "Codigo de Vendedor: " + reporteVendedor.getCodigoVendedor() + "\n" +
                                "Numero de Ventas: " + reporteVendedor.getVentas() + "\n" +
                                "Unidades Vendidas Acumuladas: " + reporteVendedor.getUnidades() + "\n" +
                                "Importe Total Acumulado: " + reporteVendedor.getImporteTotal() + "\n\n";
            imprimir(infoVendedor);
        }
    }

	void imprimir(String s) {
		txtAreaResultado.append(s + "\n");
	}

}
