package tp4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JTextField;

import java.awt.Color;

public class FrameEj1 extends JFrame {
	
	private static final long serialVersionUID = 7839909949549363338L;
	
	public FrameEj1() {
		super();
		initialize();
	}

	/**
	 * Initialize the contents of the 
	 */
	private void initialize() {

	    setSize(483, 438);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	    
	    setTitle("Contactos");
		getContentPane().setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(57, 54, 102, 22);
		getContentPane().add(lblNombre);
		JTextField txtNombre = new JTextField();
		txtNombre.setBounds(208, 54, 190, 20);
		getContentPane().add(txtNombre);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(57, 90, 102, 22);
		getContentPane().add(lblApellido);
		JTextField txtApellido = new JTextField();
		txtApellido.setBounds(208, 90, 190, 20);
		getContentPane().add(txtApellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(57, 126, 102, 22);
		getContentPane().add(lblTelefono);
		JTextField txtTelefono = new JTextField();
		txtTelefono.setBounds(208, 126, 190, 20);
		getContentPane().add(txtTelefono);
		
		JLabel lblFechaNacimiento = new JLabel("Fecha de Nacimiento");
		lblFechaNacimiento.setBounds(57, 159, 102, 22);
		getContentPane().add(lblFechaNacimiento);
		JTextField txtFechaNacimiento = new JTextField();
		txtFechaNacimiento.setBounds(208, 159, 190, 20);
		getContentPane().add(txtFechaNacimiento);
		
		JLabel lblMsg = new JLabel("Los datos ingresados fueron: ");
		lblMsg.setBounds(57, 283, 324, 14);
		getContentPane().add(lblMsg);
		
		JLabel lblInfo = new JLabel("New label");
		lblInfo.setBounds(10, 308, 447, 39);
		lblInfo.setVisible(false);
		getContentPane().add(lblInfo);
		
		JButton btnNewButton = new JButton("Mostrar");
		btnNewButton.setBounds(296, 224, 102, 22);
		btnNewButton.addActionListener(new EventoMostrar(txtNombre, txtApellido, txtTelefono, txtFechaNacimiento, lblInfo));
		getContentPane().add(btnNewButton);
	    setVisible(true);
		
	}
}
class EventoMostrar implements ActionListener
{
	JTextField txtNombre;
	JTextField txtApellido;
	JTextField txtTelefono;
	JTextField txtFechaNacimiento;
	
	JLabel lblInfoIngresada;
	EventoMostrar(JTextField txtNombre, JTextField txtApellido, JTextField txtTelefono, JTextField txtFechaNacimiento, JLabel lblInfo)
	{
		this.txtNombre = txtNombre;
		this.txtApellido = txtApellido;
		this.txtTelefono = txtTelefono;
		this.txtFechaNacimiento = txtFechaNacimiento;
		
		this.lblInfoIngresada = lblInfo;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean noHayError = true;
		String nombre = txtNombre.getText();
		if(Utils.isNullOrEmpty(nombre))
		{
			noHayError = false;
			txtNombre.setBackground(Color.red);
		}
		else
		{
			txtNombre.setBackground(Color.white);
		}
		
		String apellido = txtApellido.getText();
		if(Utils.isNullOrEmpty(apellido))
		{
			noHayError = false;
			txtApellido.setBackground(Color.red);
		}
		else
		{
			txtApellido.setBackground(Color.white);
		}
		
		String telefono = txtTelefono.getText();
		if(Utils.isNullOrEmpty(telefono))
		{
			noHayError = false;
			txtTelefono.setBackground(Color.red);
		}
		else
		{
			txtTelefono.setBackground(Color.white);
		}
		
		String fecha = txtFechaNacimiento.getText();
		if(Utils.isNullOrEmpty(fecha))
		{
			noHayError = false;
			txtFechaNacimiento.setBackground(Color.red);
		}
		else
		{
			txtFechaNacimiento.setBackground(Color.white);
		}
		
		if(noHayError)
		{
			lblInfoIngresada.setText("Nombre y Apellido: " +nombre + ", "+ apellido + ". Tel: " + telefono + " Fecha: " + fecha );
			lblInfoIngresada.setVisible(true);
		}
		else
		{
			lblInfoIngresada.setVisible(false);
		}
	}
		
}