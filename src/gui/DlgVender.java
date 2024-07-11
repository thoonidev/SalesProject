package gui;

import arreglos.*;
import clases.*;
import lib.NumeroLetra;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class DlgVender extends JDialog implements ItemListener, ActionListener {
	private JTextField txtCantidad;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JComboBox<Integer> cboCodigoCliente;
	private JComboBox<Integer> cboCodigoVendedor;
	private JComboBox<Integer> cboCodigoProducto;
	private JButton btnAceptar;
	private JButton btnIngresar;
	private JButton btnLimpiar;
	private JScrollPane scrollPane;
	private JTextArea txtAreaResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgVender dialog = new DlgVender();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgVender() {
		setTitle("Vender");
		setBounds(100, 100, 741, 562);
		getContentPane().setLayout(null);

		lblNewLabel = new JLabel("CODIGO DEL CLIENTE:");
		lblNewLabel.setBounds(10, 11, 151, 14);
		getContentPane().add(lblNewLabel);

		lblNewLabel_1 = new JLabel("CODIGO DEL VENDEDOR:");
		lblNewLabel_1.setBounds(10, 44, 151, 14);
		getContentPane().add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("CODIGO DEL PRODUCTO:");
		lblNewLabel_2.setBounds(10, 77, 151, 14);
		getContentPane().add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("CANTIDAD:");
		lblNewLabel_3.setBounds(10, 109, 151, 14);
		getContentPane().add(lblNewLabel_3);

		cboCodigoCliente = new JComboBox();
		cboCodigoCliente.setBounds(171, 7, 131, 22);
		getContentPane().add(cboCodigoCliente);

		cboCodigoVendedor = new JComboBox();
		cboCodigoVendedor.setBounds(171, 40, 131, 22);
		getContentPane().add(cboCodigoVendedor);

		cboCodigoProducto = new JComboBox();
		cboCodigoProducto.setBounds(171, 73, 131, 22);
		getContentPane().add(cboCodigoProducto);

		txtCantidad = new JTextField();
		txtCantidad.setBounds(171, 106, 131, 20);
		getContentPane().add(txtCantidad);
		txtCantidad.setColumns(10);

		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(329, 7, 89, 23);
		getContentPane().add(btnAceptar);

		btnIngresar = new JButton("INGRESO");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(626, 7, 89, 23);
		getContentPane().add(btnIngresar);

		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addActionListener(this);
		btnLimpiar.setBounds(626, 36, 89, 23);
		getContentPane().add(btnLimpiar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 134, 705, 378);
		getContentPane().add(scrollPane);

		txtAreaResultado = new JTextArea();
		txtAreaResultado.setFont(new Font("Monospaced", Font.BOLD, 13));
		scrollPane.setViewportView(txtAreaResultado);

		deshabilitarTodo();
	}

	// DECLARACI�N GLOBAL
	ArregloClientes ac = new ArregloClientes();
	ArregloVendedores av = new ArregloVendedores();
	ArregloProductos ap = new ArregloProductos();
	ArregloFacturas af = new ArregloFacturas();

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboCodigoCliente) {
			itemStateChangedCboCodigoCliente(e);
		}
		if (e.getSource() == cboCodigoVendedor) {
			itemStateChangedCboCodigoVendedor(e);
		}
		if (e.getSource() == cboCodigoProducto) {
			itemStateChangedCboCodigoProducto(e);
		}
	}

	protected void itemStateChangedCboCodigoCliente(ItemEvent e) {
		try {
			int codigoCliente = leerCodigoCliente();
			Cliente buscado = ac.buscar(codigoCliente);
			cboCodigoCliente.setSelectedItem(buscado.getCodigoCliente());

		} catch (Exception error) {

		}
	}

	protected void itemStateChangedCboCodigoVendedor(ItemEvent e) {
		try {
			int codigoVendedor = leerCodigoVendedor();
			Vendedor buscado = av.buscar(codigoVendedor);
			cboCodigoVendedor.setSelectedItem(buscado.getCodigoVendedor());
		} catch (Exception error) {

		}
	}

	protected void itemStateChangedCboCodigoProducto(ItemEvent e) {
		try {
			int codigoProducto = leerCodigoProducto();
			Producto buscado = ap.buscar(codigoProducto);
			cboCodigoProducto.setSelectedItem(buscado.getCodigoProducto());
		} catch (Exception error) {

		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
		if (e.getSource() == btnLimpiar) {
			actionPerformedBtnLimpiar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
	}

	protected void actionPerformedBtnAceptar(ActionEvent e) {
		try {
			int codigoCliente = leerCodigoCliente();
			int codigoVendedor = leerCodigoVendedor();
			int codigoProducto = leerCodigoProducto();
			int cantidad = leerCantidad();

			if (cantidad >= 0) {
				// Detalles del producto (ap) seg�n el c�digo.
				Producto producto = ap.buscar(codigoProducto);

				if (producto != null) {
					// Calcular los detalles de ventas.
					String descripcion = producto.getDescripcion();
					double precioUnitario = producto.getPrecio();
					double importeSubtotal = precioUnitario * cantidad;
					double importeIGV = 0.18 * importeSubtotal;
					double importeTotal = importeSubtotal + importeIGV;
					mensaje("Venta realizada exitosamente");

					// Create a new Factura and add it to the ArregloFacturas.
					Factura factura = new Factura(af.codigoCorrelativo(), codigoProducto, codigoVendedor, cantidad,
							importeTotal);
					af.adicionar(factura);
					deshabilitarTodo();

					// Mostrar el recibo de compra en txtAreaResultado
					String boletaVenta = "******************** BOLETA DE VENTA ********************" + "\n"
							+ "Codigo del cliente: " + codigoCliente + "\n" + "Codigo del vendedor: " + codigoVendedor
							+ "\n" + "Codigo del producto: " + codigoProducto + "\n" + "Descripcion del producto: "
							+ descripcion + "\n" + "Precio unitario: " + precioUnitario + "\n" + "Importe subtotal: "
							+ importeSubtotal + "\n" + "Importe del IGV: " + importeIGV + "\n"
							+ "Importe total a pagar: " + importeTotal + "\n"
							+ "=========================================================";

					txtAreaResultado.setText(boletaVenta);

				} else {
					error("Producto no encontrado", cboCodigoProducto);
				}
			} else {
				error("La cantidad debe ser un valor v�lido", txtCantidad);
			}
		} catch (Exception error) {
			error("Error al realizar la venta");
		}
	}

	protected void actionPerformedBtnIngresar(ActionEvent e) {
		limpiar();
		habilitar(true, true, true, true, true, true, false);

	}

	protected void actionPerformedBtnLimpiar(ActionEvent e) {
		// Solicita confirmaci�n antes de borrar el �rea de texto
		int borrarResultado = confirmarLimpieza();
		if (borrarResultado == JOptionPane.YES_OPTION) {
			txtAreaResultado.setText("");
		}
	}

	void habilitar(boolean codigoCliente, boolean codigoVendedor, boolean codigoProducto, boolean cantidad,
			boolean aceptar, boolean ingresar, boolean limpiar) {
		cboCodigoCliente.setEnabled(codigoCliente);
		cboCodigoVendedor.setEnabled(codigoVendedor);
		cboCodigoProducto.setEnabled(codigoProducto);
		txtCantidad.setEditable(cantidad);
		btnAceptar.setEnabled(aceptar);
		btnIngresar.setEnabled(ingresar);
		btnLimpiar.setEnabled(limpiar);
	}

	void deshabilitarTodo() {
		listarCboCodigoCliente();
		listarCboCodigoVendedor();
		listarCboCodigoProducto();
		habilitar(false, false, false, false, false, true, true);
		limpiar();
	}

	void limpiar() {
		cboCodigoCliente.setSelectedIndex(-1);
		cboCodigoVendedor.setSelectedIndex(-1);
		cboCodigoProducto.setSelectedIndex(-1);
		txtCantidad.setText("");
	}

	void listarCboCodigoCliente() {
		cboCodigoCliente.removeAllItems();
		for (int i = 0; i < ac.tamanio(); i++) {
			cboCodigoCliente.addItem(ac.obtener(i).getCodigoCliente());
		}
	}

	void listarCboCodigoVendedor() {
		cboCodigoVendedor.removeAllItems();
		for (int i = 0; i < av.tamanio(); i++) {
			cboCodigoVendedor.addItem(av.obtener(i).getCodigoVendedor());
		}
	}

	void listarCboCodigoProducto() {
		cboCodigoProducto.removeAllItems();
		for (int i = 0; i < ap.tamanio(); i++) {
			cboCodigoProducto.addItem(ap.obtener(i).getCodigoProducto());
		}
	}

	int leerCodigoCliente() {
		return Integer.parseInt(cboCodigoCliente.getSelectedItem().toString());
	}

	int leerCodigoVendedor() {
		return Integer.parseInt(cboCodigoVendedor.getSelectedItem().toString());
	}

	int leerCodigoProducto() {
		return Integer.parseInt(cboCodigoProducto.getSelectedItem().toString());
	}

	int leerCantidad() {
		return Integer.parseInt(txtCantidad.getText().toString());
	}

	void mensaje(String s) {
		JOptionPane.showMessageDialog(this, s);
	}

	void error(String s, JComboBox cbo) {
		JOptionPane.showMessageDialog(this, s, "", JOptionPane.ERROR_MESSAGE);
		cbo.requestFocus();
	}

	void error(String s, JTextField txt) {
		JOptionPane.showMessageDialog(this, s, "", JOptionPane.ERROR_MESSAGE);
		txt.selectAll();
		txt.requestFocus();
	}

	void error(String s) {
		JOptionPane.showMessageDialog(this, s, "", JOptionPane.ERROR_MESSAGE);
	}

	int confirmarLimpieza() {
		int valor = JOptionPane.showOptionDialog(null, "Estas seguro que deseas borrar el contenido del resultado?",
				"Confirmar Limpieza", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
				new Object[] { "Si", "No" }, null);
		return valor;
	}
}
