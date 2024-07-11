package gui;

import arreglos.*;
import clases.*;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DlgVendedor extends JDialog implements ItemListener, ActionListener, MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtNombreVendedor;
	private JTextField txtApellidoVendedor;
	private JTextField txtTelefonoVendedor;
	private JTextField txtDNIVendedor;
	private JTable tblVendedor;
	private JComboBox<Integer> cboCodigo;
	private JComboBox<String> cboCategoria;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnIngresar;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	private JButton btnListar;
	private JScrollPane scrollPane_1;
	private JTextArea txtAreaResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DlgVendedor dialog = new DlgVendedor();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public DlgVendedor() {
		setTitle("Vendedores");
		setBounds(100, 100, 722, 688);
		getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("CODIGO:");
		lblNewLabel.setBounds(10, 14, 76, 14);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("CATEGORIA:");
		lblNewLabel_1.setBounds(10, 46, 76, 14);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("NOMBRES:");
		lblNewLabel_2.setBounds(10, 80, 76, 14);
		getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("APELLIDOS:");
		lblNewLabel_3.setBounds(10, 114, 76, 14);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("TELEFONO:");
		lblNewLabel_4.setBounds(10, 148, 76, 14);
		getContentPane().add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("DNI:");
		lblNewLabel_5.setBounds(10, 179, 76, 14);
		getContentPane().add(lblNewLabel_5);

		txtNombreVendedor = new JTextField();
		txtNombreVendedor.setColumns(10);
		txtNombreVendedor.setBounds(96, 77, 243, 20);
		getContentPane().add(txtNombreVendedor);

		txtApellidoVendedor = new JTextField();
		txtApellidoVendedor.setColumns(10);
		txtApellidoVendedor.setBounds(96, 111, 243, 20);
		getContentPane().add(txtApellidoVendedor);

		txtTelefonoVendedor = new JTextField();
		txtTelefonoVendedor.setColumns(10);
		txtTelefonoVendedor.setBounds(96, 145, 157, 20);
		getContentPane().add(txtTelefonoVendedor);

		txtDNIVendedor = new JTextField();
		txtDNIVendedor.setColumns(10);
		txtDNIVendedor.setBounds(96, 176, 157, 20);
		getContentPane().add(txtDNIVendedor);

		btnIngresar = new JButton("INGRESO");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(569, 11, 127, 23);
		getContentPane().add(btnIngresar);

		btnModificar = new JButton("MODIFICACION");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(569, 45, 127, 23);
		getContentPane().add(btnModificar);

		btnEliminar = new JButton("ELIMINACION");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(569, 80, 127, 23);
		getContentPane().add(btnEliminar);

		btnListar = new JButton("LISTADO");
		btnListar.addActionListener(this);
		btnListar.setBounds(569, 114, 127, 23);
		getContentPane().add(btnListar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 253, 686, 265);
		getContentPane().add(scrollPane);

		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(10, 219, 89, 23);
		getContentPane().add(btnAceptar);

		btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(116, 219, 101, 23);
		getContentPane().add(btnCancelar);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 529, 686, 109);
		getContentPane().add(scrollPane_1);

		txtAreaResultado = new JTextArea();
		txtAreaResultado.setFont(new Font("Monospaced", Font.BOLD, 13));
		scrollPane_1.setViewportView(txtAreaResultado);

		cboCodigo = new JComboBox();
		cboCodigo.addItemListener(this);
		cboCodigo.setBounds(96, 10, 157, 22);
		getContentPane().add(cboCodigo);

		cboCategoria = new JComboBox();
		cboCategoria.setModel(new DefaultComboBoxModel(new String[] { "PRIMERO", "SEGUNDO", "TERCERO" }));
		cboCategoria.setBounds(96, 42, 157, 22);
		getContentPane().add(cboCategoria);

		tblVendedor = new JTable();
		tblVendedor.addMouseListener(this);
		tblVendedor.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblVendedor);
		modelo = new DefaultTableModel();
		modelo.addColumn("CODIGO");
		modelo.addColumn("CATEGORIA");
		modelo.addColumn("NOMBRES");
		modelo.addColumn("APELLIDOS");
		modelo.addColumn("TELEFONO");
		modelo.addColumn("DNI");
		tblVendedor.setModel(modelo);

		ajustarColumnas();
		listar();
		deshabilitarTodo();
		actualizarListaVendedores();

	}

	// DECLARACI�N GLOBAL
	ArregloVendedores av = new ArregloVendedores();

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboCodigo) {
			itemStateChangedCboCodigo(e);
		}
	}

	protected void itemStateChangedCboCodigo(ItemEvent e) {
		try {
			int codigoVendedor = leerCodigo();
			Vendedor buscado = av.buscar(codigoVendedor);
			cboCategoria.setSelectedIndex(buscado.getCategoria());
			txtNombreVendedor.setText(buscado.getNombres());
			txtApellidoVendedor.setText(buscado.getApellidos());
			txtTelefonoVendedor.setText("" + buscado.getTelefono());
			txtDNIVendedor.setText(buscado.getDni());
			tblVendedor.setRowSelectionInterval(cboCodigo.getSelectedIndex(), cboCodigo.getSelectedIndex());
		} catch (Exception error) {

		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnEliminar) {
			actionPerformedBtnEliminar(e);
		}
		if (e.getSource() == btnModificar) {
			actionPerformedBtnModificar(e);
		}
		if (e.getSource() == btnIngresar) {
			actionPerformedBtnIngresar(e);
		}
		if (e.getSource() == btnCancelar) {
			actionPerformedBtnCancelar(e);
		}
		if (e.getSource() == btnAceptar) {
			actionPerformedBtnAceptar(e);
		}
		if (e.getSource() == btnListar) {
			actualizarListaVendedores();
		}
	}

	protected void actionPerformedBtnAceptar(ActionEvent e) {
		try {
			int codigoVendedor = leerCodigo();
			int categoria = leerCategoria();

			if (categoria != -1) {
				String nombre = leerNombres();
				if (nombre.length() != 0) {
					String apellidos = leerApellidos();
					try {
						if (apellidos.length() != 0) {
							try {
								String telefono = leerTelefono();
								String dni = leerDNI();
								if (Integer.parseInt(dni) > 0 && Integer.parseInt(dni) < 100000000) {
									if (!btnIngresar.isEnabled()) {
										if (!existeDNI(dni)) {
											Vendedor nuevo = new Vendedor(codigoVendedor, categoria, nombre, apellidos,
													telefono, dni);
											av.adicionar(nuevo);
											listar();
											mensaje("Nuevo vendedor añadido exitosamente");
											deshabilitarTodo();
										} else {
											error("No puede ingresar un DNI ya existente", txtDNIVendedor);
										}
									} else if (!btnModificar.isEnabled()) {
										Vendedor buscado = av.buscar(codigoVendedor);
										buscado.setNombres(nombre);
										buscado.setApellidos(apellidos);
										buscado.setTelefono(telefono);
										buscado.setCategoria(categoria);
										av.ActualizarArchivo();
										listar();
										mensaje("Vendedor modificado exitosamente");
										deshabilitarTodo();
									}
								} else {
									error("Ingrese un DNI valido", txtDNIVendedor);
								}
							} catch (Exception error) {
								error("Ingrese un numero de telefono valido", txtTelefonoVendedor);
							}
						} else {
							error("Ingrese el apellido del vendedor", txtApellidoVendedor);
						}
					} catch (Exception error) {
						error("Ingrese los apellidos del vendedor", txtApellidoVendedor);
					}
				} else {
					error("Ingrese el nombre del vendedor", txtNombreVendedor);
				}
			} else {
				error("Especifique la categoria del vendedor", cboCategoria);
			}
		} catch (Exception error) {
			error("Seleccione un codigo de vendedor", cboCodigo);
		}
	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		deshabilitarTodo();
	}

	protected void actionPerformedBtnIngresar(ActionEvent e) {
		limpiar();
		habilitar(false, true, true, true, true, true, true, true, false, true, false);
		cboCategoria.setSelectedIndex(0);
		cboCodigo.addItem(av.codigoCorrelativo());
		cboCodigo.setSelectedIndex(av.tamanio());
		txtNombreVendedor.requestFocus();
	}

	protected void actionPerformedBtnModificar(ActionEvent e) {
		if (!btnIngresar.isEnabled())
			deshabilitarTodo();
		habilitar(true, true, true, false, true, true, true, true, true, false, false);
		cboCodigo.requestFocus();
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		try {
			int codigoVendedor = leerCodigo();
			Vendedor buscado = av.buscar(codigoVendedor);

			if (confirmar() == 0) {
				av.eliminar(buscado);
				listar();
				mensaje("Vendedor eliminado exitosamente");
				deshabilitarTodo();
			}

		} catch (Exception error) {
			error("Seleccione un codigo de vendedor", cboCodigo);
		}

	}

	private void actualizarListaVendedores() {
	    txtAreaResultado.setText(""); 
	    for (int i = 0; i < av.tamanio(); i++) {
	        Vendedor vendedor = av.obtener(i);
	        String vendedorInfo = 	"Codigo:" + vendedor.getCodigoVendedor() + "\n" +
	                             	"Categoria:" + nombreCategoria(vendedor.getCategoria()) + "\n" +
	                             	"Nombres:" + vendedor.getNombres() + "\n" +
	                             	"Apellidos:" + vendedor.getApellidos() + "\n" +
	                             	"Telefono:" + vendedor.getTelefono() + "\n" +
	                             	"DNI:" + vendedor.getDni() + "\n" +
	                                "--------------------------------------------------------------";
	        txtAreaResultado.append(vendedorInfo + "\n");
	    }
	}

	void habilitar(boolean codigo, boolean nombre, boolean apellidos, boolean dni, boolean telefono, boolean categoria,
			boolean aceptar, boolean cancelar, boolean ingresar, boolean modificar, boolean eliminar) {
		cboCodigo.setEnabled(codigo);
		txtNombreVendedor.setEditable(nombre);
		txtApellidoVendedor.setEditable(apellidos);
		txtDNIVendedor.setEditable(dni);
		txtTelefonoVendedor.setEditable(telefono);
		cboCategoria.setEnabled(categoria);
		btnAceptar.setEnabled(aceptar);
		btnCancelar.setEnabled(cancelar);
		btnIngresar.setEnabled(ingresar);
		btnModificar.setEnabled(modificar);
		btnEliminar.setEnabled(eliminar);
	}

	void deshabilitarTodo() {
		listarCboCodigo();
		habilitar(false, false, false, false, false, false, false, false, true, true, true);
		limpiar();
	}

	void limpiar() {
		cboCodigo.setSelectedIndex(-1);
		cboCategoria.setSelectedIndex(-1);
		txtNombreVendedor.setText("");
		txtApellidoVendedor.setText("");
		txtTelefonoVendedor.setText("");
		txtDNIVendedor.setText("");
	}

	void listarCboCodigo() {
		cboCodigo.removeAllItems();
		for (int i = 0; i < av.tamanio(); i++) {
			cboCodigo.addItem(av.obtener(i).getCodigoVendedor());
		}
	}

	void ajustarColumnas() {
		TableColumnModel modeloColuma = tblVendedor.getColumnModel();
		modeloColuma.getColumn(0).setPreferredWidth(scrollPane.getWidth() * 2);
		modeloColuma.getColumn(1).setPreferredWidth(scrollPane.getWidth() * 2);
		modeloColuma.getColumn(2).setPreferredWidth(scrollPane.getWidth() * 3);
		modeloColuma.getColumn(3).setPreferredWidth(scrollPane.getWidth() * 3);
		modeloColuma.getColumn(4).setPreferredWidth(scrollPane.getWidth() * 2);
		modeloColuma.getColumn(5).setPreferredWidth(scrollPane.getWidth() * 2);
	}

	void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < av.tamanio(); i++) {
			Object[] fila = {
					av.obtener(i).getCodigoVendedor(),
					nombreCategoria(av.obtener(i).getCategoria()),
					av.obtener(i).getNombres(),
					av.obtener(i).getApellidos(),
					av.obtener(i).getTelefono(),
					av.obtener(i).getDni(),
			};
			modelo.addRow(fila);
		}
	}

	boolean existeDNI(String dni) {
		for (int i = 0; i < av.tamanio(); i++) {
			if(av.obtener(i).getDni().equals(dni))
				return true;
		}
		return false;
	}

	int leerCodigo() {
		return Integer.parseInt(cboCodigo.getSelectedItem().toString());
	}

	String leerNombres() {
		return txtNombreVendedor.getText().trim().toUpperCase();
	}

	String leerApellidos() {
		return txtApellidoVendedor.getText().trim().toUpperCase();
	}

	String leerTelefono() {
		return txtTelefonoVendedor.getText().trim().toUpperCase();
	}

	String leerDNI() {
		return txtDNIVendedor.getText().trim().toUpperCase();
	}

	int leerCategoria() {
		return cboCategoria.getSelectedIndex();
	}

	String nombreCategoria(int i) {
		switch (i) {
		case 0:
			return "PRIMERO";
		case 1:
			return "SEGUNDO";
		case 2:
			return "TERCERO";
		default:
			return null;
		}
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

	int confirmar() {
		int valor = JOptionPane.showOptionDialog(null,
				"Estas seguro que deseas eliminar a este alumno?\n" + av.buscar(leerCodigo()).getNombres() + " "
						+ av.buscar(leerCodigo()).getApellidos(),
				"Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "S�", "No" },
				null);
		return valor;
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblVendedor) {
			mouseClickedTblVendedor(e);
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	protected void mouseClickedTblVendedor(MouseEvent e) {
		if (btnIngresar.isEnabled()) {
			try {
				Vendedor buscado = av.obtener(tblVendedor.getSelectedRow());
				cboCodigo.setSelectedIndex(tblVendedor.getSelectedRow());
				cboCategoria.setSelectedIndex(buscado.getCategoria());
				txtNombreVendedor.setText(buscado.getNombres());
				txtApellidoVendedor.setText(buscado.getApellidos());
				txtTelefonoVendedor.setText("" + buscado.getTelefono());
				txtDNIVendedor.setText(buscado.getDni());
			} catch (Exception error) {

			}
		}
	}
}
