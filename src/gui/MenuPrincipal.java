package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.UIManager;

public class MenuPrincipal extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnMantenimiento;
	private JMenu mnVentas;
	private JMenu mnReportes;
	private JMenuItem mntmVendedores;
	private JMenuItem mntmClientes;
	private JSeparator separator;
	private JMenuItem mntmProductos;
	private JSeparator separator_1;
	private JMenuItem mntmSalirDelSistema;
	private JMenuItem mntmVender;
	private JMenuItem mntmReporteGeneralProductos;
	private JMenuItem mntmReporteGeneralVendedores;
	private JMenuItem mntmReporteVendedor;
	private JMenuItem mntmReporteProducto;
	private JMenuItem mntmReportePrecios;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPrincipal frame = new MenuPrincipal();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MenuPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 870, 700);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnMantenimiento = new JMenu("Mantenimiento");
		menuBar.add(mnMantenimiento);

		mntmVendedores = new JMenuItem("Vendedores");
		mntmVendedores.addActionListener(this);
		mnMantenimiento.add(mntmVendedores);

		mntmClientes = new JMenuItem("Clientes");
		mntmClientes.addActionListener(this);
		mnMantenimiento.add(mntmClientes);

		separator = new JSeparator();
		mnMantenimiento.add(separator);

		mntmProductos = new JMenuItem("Productos");
		mntmProductos.addActionListener(this);
		mnMantenimiento.add(mntmProductos);

		separator_1 = new JSeparator();
		mnMantenimiento.add(separator_1);

		mntmSalirDelSistema = new JMenuItem("Salir del Sistema");
		mntmSalirDelSistema.addActionListener(this);
		mnMantenimiento.add(mntmSalirDelSistema);

		mnVentas = new JMenu("Ventas");
		menuBar.add(mnVentas);

		mntmVender = new JMenuItem("Vender");
		mntmVender.addActionListener(this);
		mnVentas.add(mntmVender);

		mnReportes = new JMenu("Reportes");
		menuBar.add(mnReportes);

		mntmReporteGeneralProductos = new JMenuItem("Reporte general por productos");
		mntmReporteGeneralProductos.addActionListener(this);
		mnReportes.add(mntmReporteGeneralProductos);

		mntmReporteGeneralVendedores = new JMenuItem("Reporte general por vendedores");
		mntmReporteGeneralVendedores.addActionListener(this);
		mnReportes.add(mntmReporteGeneralVendedores);

		mntmReporteVendedor = new JMenuItem("Reporte por vendedor");
		mntmReporteVendedor.addActionListener(this);
		mnReportes.add(mntmReporteVendedor);

		mntmReporteProducto = new JMenuItem("Reporte por producto");
		mntmReporteProducto.addActionListener(this);
		mnReportes.add(mntmReporteProducto);

		mntmReportePrecios = new JMenuItem("Reporte de precios");
		mntmReportePrecios.addActionListener(this);
		mnReportes.add(mntmReportePrecios);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == mntmVendedores) {
			actionPerformedMntmVendedores(e);
		}
		if (e.getSource() == mntmClientes) {
			actionPerformedMntmClientes(e);
		}
		if (e.getSource() == mntmProductos) {
			actionPerformedMntmProductos(e);
		}
		if (e.getSource() == mntmVender) {
			actionPerformedMntmVender(e);
		}
		if (e.getSource() == mntmReporteGeneralProductos) {
			actionPerformedMntmReporteGeneralProductos(e);
		}
		if (e.getSource() == mntmReporteGeneralVendedores) {
			actionPerformedMntmReporteGeneralVendedores(e);
		}
		if (e.getSource() == mntmReporteVendedor) {
			actionPerformedMntmReporteVendedor(e);
		}
		if (e.getSource() == mntmReporteProducto) {
			actionPerformedMntmReporteProducto(e);
		}
		if (e.getSource() == mntmReportePrecios) {
			actionPerformedMntmReportePrecios(e);
		}
		if (e.getSource() == mntmSalirDelSistema) {
			actionPerformedMntmSalirDelSistema(e);
		}
	}

	protected void actionPerformedMntmSalirDelSistema(ActionEvent e) {
		int valor = JOptionPane.showOptionDialog(null, "Estas seguro que deseas cerrar el programa?", "Confirmar",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, new Object[] { "Si", "No" }, null);
		if (valor == 0)
			System.exit(0);
	}

	protected void actionPerformedMntmVendedores(ActionEvent e) {
		DlgVendedor vendedor = new DlgVendedor();
		vendedor.setModal(true);
		vendedor.setLocationRelativeTo(this);
		vendedor.setVisible(true);
	}

	protected void actionPerformedMntmClientes(ActionEvent e) {
		DlgCliente cliente = new DlgCliente();
		cliente.setModal(true);
		cliente.setLocationRelativeTo(this);
		cliente.setVisible(true);
	}

	protected void actionPerformedMntmProductos(ActionEvent e) {
		DlgProducto producto = new DlgProducto();
		producto.setModal(true);
		producto.setLocationRelativeTo(this);
		producto.setVisible(true);
	}

	protected void actionPerformedMntmVender(ActionEvent e) {
		DlgVender vender = new DlgVender();
		vender.setModal(true);
		vender.setLocationRelativeTo(this);
		vender.setVisible(true);
	}

	protected void actionPerformedMntmReporteGeneralProductos(ActionEvent e) {
		DlgReporteGeneralProductos reportegeneralproductos = new DlgReporteGeneralProductos();
		reportegeneralproductos.setModal(true);
		reportegeneralproductos.setLocationRelativeTo(this);
		reportegeneralproductos.setVisible(true);
	}

	protected void actionPerformedMntmReporteGeneralVendedores(ActionEvent e) {
		DlgReporteGeneralVendedores reportegeneralvendedores = new DlgReporteGeneralVendedores();
		reportegeneralvendedores.setModal(true);
		reportegeneralvendedores.setLocationRelativeTo(this);
		reportegeneralvendedores.setVisible(true);
	}

	protected void actionPerformedMntmReporteVendedor(ActionEvent e) {
		DlgReporteVendedor reportevendedor = new DlgReporteVendedor();
		reportevendedor.setModal(true);
		reportevendedor.setLocationRelativeTo(this);
		reportevendedor.setVisible(true);
	}

	protected void actionPerformedMntmReporteProducto(ActionEvent e) {
		DlgReporteProducto reporteproducto = new DlgReporteProducto();
		reporteproducto.setModal(true);
		reporteproducto.setLocationRelativeTo(this);
		reporteproducto.setVisible(true);
	}

	protected void actionPerformedMntmReportePrecios(ActionEvent e) {
		DlgReportePrecios reporteprecios = new DlgReportePrecios();
		reporteprecios.setModal(true);
		reporteprecios.setLocationRelativeTo(this);
		reporteprecios.setVisible(true);
	}

}
