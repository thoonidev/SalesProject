package gui;

import arreglos.*;
import clases.*;

import java.awt.BorderLayout;
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

public class DlgProducto extends JDialog implements ItemListener, ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtPrecioProducto;
	private JTextField txtDescripcionProducto;
	private JTable tblProducto;
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
			DlgProducto dialog = new DlgProducto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgProducto() {
		setTitle("Productos");
		setBounds(100, 100, 734, 690);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("CODIGO:");
		lblNewLabel.setBounds(10, 11, 90, 14);
		contentPanel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("DESCRIPCION:");
		lblNewLabel_1.setBounds(10, 46, 90, 14);
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("PRECIO(S/.):");
		lblNewLabel_2.setBounds(10, 80, 90, 14);
		contentPanel.add(lblNewLabel_2);

		txtDescripcionProducto = new JTextField();
		txtDescripcionProducto.setBounds(110, 43, 245, 20);
		contentPanel.add(txtDescripcionProducto);
		txtDescripcionProducto.setColumns(10);

		txtPrecioProducto = new JTextField();
		txtPrecioProducto.setBounds(110, 77, 162, 20);
		contentPanel.add(txtPrecioProducto);
		txtPrecioProducto.setColumns(10);

		btnIngresar = new JButton("INGRESO");
		btnIngresar.addActionListener(this);
		btnIngresar.setBounds(579, 11, 129, 23);
		contentPanel.add(btnIngresar);

		btnModificar = new JButton("MODIFICACION");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(579, 45, 129, 23);
		contentPanel.add(btnModificar);

		btnEliminar = new JButton("ELIMINACION");
		btnEliminar.addActionListener(this);
		btnEliminar.setBounds(579, 80, 129, 23);
		contentPanel.add(btnEliminar);

		btnListar = new JButton("LISTADO");
		btnListar.addActionListener(this);
		btnListar.setBounds(579, 114, 129, 23);
		contentPanel.add(btnListar);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 178, 698, 327);
		contentPanel.add(scrollPane);

		btnAceptar = new JButton("ACEPTAR");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(10, 132, 89, 23);
		contentPanel.add(btnAceptar);

		btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(110, 132, 104, 23);
		contentPanel.add(btnCancelar);

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 516, 698, 124);
		contentPanel.add(scrollPane_1);

		txtAreaResultado = new JTextArea();
		txtAreaResultado.setFont(new Font("Monospaced", Font.BOLD, 13));
		scrollPane_1.setViewportView(txtAreaResultado);

		cboCodigo = new JComboBox();
		cboCodigo.addItemListener(this);
		cboCodigo.setBounds(110, 7, 162, 22);
		contentPanel.add(cboCodigo);

		tblProducto = new JTable();
		tblProducto.addMouseListener(this);
		tblProducto.setFillsViewportHeight(true);
		scrollPane.setViewportView(tblProducto);
		modelo = new DefaultTableModel();
		modelo.addColumn("CODIGO");
		modelo.addColumn("DESCRIPCION");
		modelo.addColumn("PRECIO");
		tblProducto.setModel(modelo);

		ajustarColumnas();
		listar();
		deshabilitarTodo();
		actualizarListaProductos();
	}

	// DECLARACI�N GLOBAL
	ArregloProductos ap = new ArregloProductos();

	public void itemStateChanged(ItemEvent e) {
		if (e.getSource() == cboCodigo) {
			itemStateChangedCboCodigo(e);
		}
	}

	protected void itemStateChangedCboCodigo(ItemEvent e) {
		try {
			int codigoProducto = leerCodigo();
			Producto buscado = ap.buscar(codigoProducto);
			txtDescripcionProducto.setText(buscado.getDescripcion());
			txtPrecioProducto.setText(Double.toString(buscado.getPrecio()));
			tblProducto.setRowSelectionInterval(cboCodigo.getSelectedIndex(), cboCodigo.getSelectedIndex());
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
			actualizarListaProductos();
		}
	}

	protected void actionPerformedBtnAceptar(ActionEvent e) {
		try {
			int codigoProducto = leerCodigo();
			String descripcion = leerDescripcion();
			double precio = leerPrecio();

			if (descripcion.length() != 0) {
				if (!btnIngresar.isEnabled()) {
					if (precio >= 0) {
						Producto nuevoProducto = new Producto(codigoProducto, descripcion, precio);
						ap.adicionar(nuevoProducto);
						listar();
						mensaje("Producto ingresado exitosamente");
						deshabilitarTodo();
					} else {
						error("El precio debe ser un valor valido", txtPrecioProducto);
					}
				} else if (!btnModificar.isEnabled()) {
					Producto buscado = ap.buscar(codigoProducto);
					buscado.setDescripcion(descripcion);
					buscado.setPrecio(precio);
					ap.ActualizarArchivo();
					listar();
					mensaje("Producto modificado exitosamente");
					deshabilitarTodo();
				}
			} else {
				error("Ingrese la descripcion del producto", txtDescripcionProducto);
			}
		} catch (Exception error) {
			error("Seleccione un codigo de producto", cboCodigo);
		}
	}

	protected void actionPerformedBtnCancelar(ActionEvent e) {
		deshabilitarTodo();
	}

	protected void actionPerformedBtnIngresar(ActionEvent e) {
		limpiar();
		habilitar(false, true, true, true, true, false, true, false);
		cboCodigo.addItem(ap.codigoCorrelativo());
		cboCodigo.setSelectedIndex(ap.tamanio());
		txtDescripcionProducto.requestFocus();
	}

	protected void actionPerformedBtnModificar(ActionEvent e) {
		if (!btnIngresar.isEnabled())
			deshabilitarTodo();
		habilitar(true, true, true, true, true, true, false, false);
		cboCodigo.requestFocus();
	}

	protected void actionPerformedBtnEliminar(ActionEvent e) {
		try {
			int codigoProducto = leerCodigo();
			Producto buscado = ap.buscar(codigoProducto);

			if (confirmar() == 0) {
				ap.eliminar(buscado);
				listar();
				mensaje("Producto eliminado exitosamente");
				deshabilitarTodo();
			}

		} catch (Exception error) {
			error("Seleccione un codigo de vendedor", cboCodigo);
		}
	}

	private void actualizarListaProductos() {
		txtAreaResultado.setText(""); 
	    for (int i = 0; i < ap.tamanio(); i++) {
	        Producto producto = ap.obtener(i);
	        String productoInfo = 	"Codigo:" + producto.getCodigoProducto() + "\n" +
	                             	"Descripcion:" + producto.getDescripcion() + "\n" +
	                             	"Precio: S/." + producto.getPrecio() + "\n" +
	                                "--------------------------------------------------------------";
	        txtAreaResultado.append(productoInfo + "\n");
	    }
	}

	void habilitar(boolean codigo, boolean descripcion, boolean precio, boolean aceptar, boolean cancelar,
			boolean ingresar, boolean modificar, boolean eliminar) {
		cboCodigo.setEnabled(codigo);
		txtDescripcionProducto.setEditable(descripcion);
		txtPrecioProducto.setEditable(precio);
		btnAceptar.setEnabled(aceptar);
		btnCancelar.setEnabled(cancelar);
		btnIngresar.setEnabled(ingresar);
		btnModificar.setEnabled(modificar);
		btnEliminar.setEnabled(eliminar);
	}

	void deshabilitarTodo() {
		listarCboCodigo();
		habilitar(false, false, false, false, false, true, true, true);
		limpiar();
	}

	void limpiar() {
		cboCodigo.setSelectedIndex(-1);
		txtDescripcionProducto.setText("");
		txtPrecioProducto.setText("");
	}

	void listarCboCodigo() {
		cboCodigo.removeAllItems();
		for (int i = 0; i < ap.tamanio(); i++) {
			cboCodigo.addItem(ap.obtener(i).getCodigoProducto());
		}
	}

	void ajustarColumnas() {
		TableColumnModel modeloColuma = tblProducto.getColumnModel();
		modeloColuma.getColumn(0).setPreferredWidth(scrollPane.getWidth() * 2);
		modeloColuma.getColumn(1).setPreferredWidth(scrollPane.getWidth() * 2);
		modeloColuma.getColumn(2).setPreferredWidth(scrollPane.getWidth() * 2);
	}

	void listar() {
		modelo.setRowCount(0);
		for (int i = 0; i < ap.tamanio(); i++) {
			Object[] fila = {
					ap.obtener(i).getCodigoProducto(),
					ap.obtener(i).getDescripcion(),
					"S/."+ ap.obtener(i).getPrecio(),
			};
			modelo.addRow(fila);
		}
		
	}

	int leerCodigo() {
		return Integer.parseInt(cboCodigo.getSelectedItem().toString());
	}

	String leerDescripcion() {
		return txtDescripcionProducto.getText().trim().toUpperCase();
	}

	double leerPrecio() {
		String precioTexto = txtPrecioProducto.getText().trim().toUpperCase();
		try {
			double precio = Double.parseDouble(precioTexto);
			return precio;
		} catch (NumberFormatException e) {
			return 0.0;
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
		String descripcion = ap.buscar(leerCodigo()).getDescripcion();
		int valor = JOptionPane.showOptionDialog(null,
				"Estas seguro que deseas eliminar este producto?\n" + descripcion, "Confirmar",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "S�", "No" }, null);
		return valor;
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getSource() == tblProducto) {
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
				Producto buscado = ap.obtener(tblProducto.getSelectedRow());
				cboCodigo.setSelectedIndex(tblProducto.getSelectedRow());
				txtDescripcionProducto.setText(buscado.getDescripcion());
				txtPrecioProducto.setText(Double.toString(buscado.getPrecio()));
			} catch (Exception error) {

			}
		}
	}
}
