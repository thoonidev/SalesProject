package gui;

import arreglos.*;
import clases.*;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class DlgCliente extends JDialog implements ItemListener, ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombreCliente;
	private JTextField txtApellidoCliente;
	private JTextField txtTelefonoCliente;
	private JTextField txtDNICliente;
	private JTable tblCliente;
	private JComboBox<Integer> cboCodigo;
	private JButton btnModificar;
	private JButton btnIngresar;
	private JButton btnListar;
	private JButton btnEliminar;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JScrollPane scrollPane;
	private DefaultTableModel modelo;
	private JScrollPane scrollPane_1;
	private JTextArea txtAreaResultado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgCliente dialog = new DlgCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgCliente() {
		setTitle("Clientes");
		setBounds(100, 100, 736, 690);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("CODIGO:");
		lblNewLabel.setBounds(10, 11, 65, 14);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("NOMBRES:");
		lblNewLabel_1.setBounds(10, 46, 65, 14);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("APELLIDOS:");
		lblNewLabel_2.setBounds(10, 77, 75, 14);
		contentPanel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("TELEFONO:");
		lblNewLabel_3.setBounds(10, 112, 65, 14);
		contentPanel.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("DNI:");
		lblNewLabel_4.setBounds(10, 146, 65, 14);
		contentPanel.add(lblNewLabel_4);

		txtNombreCliente = new JTextField();
		txtNombreCliente.setBounds(95, 43, 226, 20);
		contentPanel.add(txtNombreCliente);
		txtNombreCliente.setColumns(10);

		txtApellidoCliente = new JTextField();
		txtApellidoCliente.setBounds(95, 74, 226, 20);
		contentPanel.add(txtApellidoCliente);
		txtApellidoCliente.setColumns(10);

		txtTelefonoCliente = new JTextField();
		txtTelefonoCliente.setBounds(95, 109, 146, 20);
		contentPanel.add(txtTelefonoCliente);
		txtTelefonoCliente.setColumns(10);

		txtDNICliente = new JTextField();
		txtDNICliente.setBounds(95, 143, 146, 20);
		contentPanel.add(txtDNICliente);
		txtDNICliente.setColumns(10);

		btnIngresar = new JButton("INGRESO");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(585, 8, 125, 23);
		contentPanel.add(btnIngresar);

		btnModificar = new JButton("MODIFICACION");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(585, 42, 125, 23);
		contentPanel.add(btnModificar);

		btnEliminar = new JButton("ELIMINACION");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(585, 77, 125, 23);
		contentPanel.add(btnEliminar);

		btnListar = new JButton("LISTADO");
		btnListar.addActionListener(this);
		btnListar.setBounds(585, 111, 125, 23);
		contentPanel.add(btnListar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 217, 700, 292);
		contentPanel.add(scrollPane);

		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(10, 183, 89, 23);
		contentPanel.add(btnAceptar);

		btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(109, 183, 104, 23);
		contentPanel.add(btnCancelar);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 520, 700, 120);
		contentPanel.add(scrollPane_1);

		txtAreaResultado = new JTextArea();
		txtAreaResultado.setFont(new Font("Monospaced", Font.BOLD, 13));
		scrollPane_1.setViewportView(txtAreaResultado);

		cboCodigo = new JComboBox();
		cboCodigo.addItemListener(this);
		cboCodigo.setBounds(95, 7, 146, 22);
		contentPanel.add(cboCodigo);

		tblCliente = new JTable();
		tblCliente.addMouseListener(this);
		tblCliente.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblCliente);
		modelo = new DefaultTableModel();
		modelo.addColumn("CODIGO");
		modelo.addColumn("NOMBRES");
		modelo.addColumn("APELLIDOS");
		modelo.addColumn("TELEFONO");
		modelo.addColumn("DNI");
		tblCliente.setModel(modelo);

		ajustarColumnas();
		listar();
		deshabilitarTodo();
		actualizarListaClientes();
	}

	// DECLARACI�N GLOBAL
	ArregloClientes ac = new ArregloClientes();

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboCodigo) {
			itemStateChangedCboCodigo(e);
		}
	}

	protected void itemStateChangedCboCodigo(ItemEvent e) {
		try {
			int codigoCliente = leerCodigo();
			Cliente buscado = ac.buscar(codigoCliente);
			txtNombreCliente.setText(buscado.getNombres());
			txtApellidoCliente.setText(buscado.getApellidos());
			txtTelefonoCliente.setText("" + buscado.getTelefono());
			txtDNICliente.setText(buscado.getDni());
			tblCliente.setRowSelectionInterval(cboCodigo.getSelectedIndex(), cboCodigo.getSelectedIndex());
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
			actualizarListaClientes();
		}
	}

	protected void actionPerformedBtnAceptar(ActionEvent e) {
		try {
			int codigoCliente = leerCodigo();
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
										Cliente nuevo = new Cliente(codigoCliente, nombre, apellidos, telefono, dni);
										ac.adicionar(nuevo);
										listar();
										mensaje("Nuevo cliente añadido exitosamente");
										deshabilitarTodo();
									} else {
										error("No puede ingresar un DNI ya existente", txtDNICliente);
									}
								} else if (!btnModificar.isEnabled()) {
									Cliente buscado = ac.buscar(codigoCliente);
									buscado.setNombres(nombre);
									buscado.setApellidos(apellidos);
									buscado.setTelefono(telefono);
									ac.ActualizarArchivo();
									listar();
									mensaje("Cliente modificado exitosamente");
									deshabilitarTodo();
								}

							} else {
								error("Ingrese un DNI valido", txtDNICliente);
							}

						} catch (Exception error) {
							error("Ingrese un n�mero de telefono v�lido", txtTelefonoCliente);
						}

					} else {
						error("Ingrese el apellido del cliente", txtApellidoCliente);
					}

				} catch (Exception error) {
					error("Ingrese los apellidos del cliente", txtApellidoCliente);
				}
			} else {
				error("Ingrese el nombre del cliente", txtNombreCliente);
			}
		} catch (Exception error) {
			error("Seleccione un c�digo de cliente", cboCodigo);
		}
	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		deshabilitarTodo();
	}

	protected void actionPerformedBtnIngresar(ActionEvent e) {
		limpiar();
		habilitar(false, true, true, true, true, true, true, false, true, false);
		cboCodigo.addItem(ac.codigoCorrelativo());
		cboCodigo.setSelectedIndex(ac.tamanio());
		txtNombreCliente.requestFocus();
	}

	protected void actionPerformedBtnModificar(ActionEvent e) {
		if (!btnIngresar.isEnabled())
			deshabilitarTodo();
		habilitar(true, true, true, false, true, true, true, true, false, false);
		cboCodigo.requestFocus();
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		try {
			int codigoCliente = leerCodigo();
			Cliente buscado = ac.buscar(codigoCliente);

			if (confirmar() == 0) {
				ac.eliminar(buscado);
				listar();
				mensaje("Cliente eliminado exitosamente");
				deshabilitarTodo();
			}

		} catch (Exception error) {
			error("Seleccione un c�digo de cliente", cboCodigo);
		}
	}

	private void actualizarListaClientes() {
		txtAreaResultado.setText(""); 
	    for (int i = 0; i < ac.tamanio(); i++) {
	        Cliente cliente = ac.obtener(i);
	        String clienteInfo = 	"Codigo:" + cliente.getCodigoCliente() + "\n" +
	                             	"Nombres:" + cliente.getNombres() + "\n" +
	                             	"Apellidos:" + cliente.getApellidos() + "\n" +
	                             	"Telefono:" + cliente.getTelefono() + "\n" +
	                             	"DNI:" + cliente.getDni() + "\n" +
	                                "--------------------------------------------------------------";
	        txtAreaResultado.append(clienteInfo + "\n");
	    }
	}

	void habilitar(boolean codigo, boolean nombre, boolean apellidos, boolean dni, boolean telefono, boolean aceptar,
			boolean cancelar, boolean ingresar, boolean modificar, boolean eliminar) {
		cboCodigo.setEnabled(codigo);
		txtNombreCliente.setEditable(nombre);
		txtApellidoCliente.setEditable(apellidos);
		txtDNICliente.setEditable(dni);
		txtTelefonoCliente.setEditable(telefono);
		btnAceptar.setEnabled(aceptar);
		btnCancelar.setEnabled(cancelar);
		btnIngresar.setEnabled(ingresar);
		btnModificar.setEnabled(modificar);
		btnEliminar.setEnabled(eliminar);
	}

	void deshabilitarTodo() {
		listarCboCodigo();
		habilitar(false, false, false, false, false, false, false, true, true, true);
		limpiar();
	}

	void limpiar() {
		cboCodigo.setSelectedIndex(-1);
		txtNombreCliente.setText("");
		txtApellidoCliente.setText("");
		txtTelefonoCliente.setText("");
		txtDNICliente.setText("");
	}

	void listarCboCodigo() {
		cboCodigo.removeAllItems();
		for (int i = 0; i < ac.tamanio(); i++) {
			cboCodigo.addItem(ac.obtener(i).getCodigoCliente());
		}
	}

	void ajustarColumnas() {
		TableColumnModel modeloColuma = tblCliente.getColumnModel();
		modeloColuma.getColumn(0).setPreferredWidth(scrollPane.getWidth() * 2);
		modeloColuma.getColumn(1).setPreferredWidth(scrollPane.getWidth() * 2);
		modeloColuma.getColumn(2).setPreferredWidth(scrollPane.getWidth() * 3);
		modeloColuma.getColumn(3).setPreferredWidth(scrollPane.getWidth() * 3);
		modeloColuma.getColumn(4).setPreferredWidth(scrollPane.getWidth() * 2);
	}

	void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < ac.tamanio(); i++) {
			Object[] fila = {
					ac.obtener(i).getCodigoCliente(),
					ac.obtener(i).getNombres(),
					ac.obtener(i).getApellidos(),
					ac.obtener(i).getTelefono(),
					ac.obtener(i).getDni(),
			};
			modelo.addRow(fila);
		}
		
	}

	boolean existeDNI(String dni) {
		for (int i = 0; i < ac.tamanio(); i++) {
			if(ac.obtener(i).getDni().equals(dni))
				return true;
		}
		return false;
	}

	int leerCodigo() {
		return Integer.parseInt(cboCodigo.getSelectedItem().toString());
	}

	String leerNombres() {
		return txtNombreCliente.getText().trim().toUpperCase();
	}

	String leerApellidos() {
		return txtApellidoCliente.getText().trim().toUpperCase();
	}

	String leerTelefono() {
		return txtTelefonoCliente.getText().trim().toUpperCase();
	}

	String leerDNI() {
		return txtDNICliente.getText().trim().toUpperCase();
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
				"Estas seguro que deseas eliminar a este cliente?\n" + ac.buscar(leerCodigo()).getNombres() + " "
						+ ac.buscar(leerCodigo()).getApellidos(),
				"Confirmar", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "S�", "No" },
				null);
		return valor;
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblCliente) {
			mouseClickedTblCliente(e);
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

	protected void mouseClickedTblCliente(MouseEvent e) {
		if (btnIngresar.isEnabled()) {
			try {
				Cliente buscado = ac.obtener(tblCliente.getSelectedRow());
				cboCodigo.setSelectedIndex(tblCliente.getSelectedRow());
				txtNombreCliente.setText(buscado.getNombres());
				txtApellidoCliente.setText(buscado.getApellidos());
				txtTelefonoCliente.setText("" + buscado.getTelefono());
				txtDNICliente.setText(buscado.getDni());
			} catch (Exception error) {

			}
		}
	}
}
