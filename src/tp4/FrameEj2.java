package tp4;

import javax.swing.JFrame;
import java.awt.Component;
import javax.swing.Box;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.GridLayout;

public class FrameEj2 extends JFrame {
	
	private static final long serialVersionUID = -8655331083261566238L;

	public FrameEj2() {
		super();
		setTitle("Promedio");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setBounds(100, 100, 583, 460);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		getContentPane().add(horizontalStrut, BorderLayout.WEST);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		getContentPane().add(verticalStrut, BorderLayout.NORTH);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		getContentPane().add(horizontalStrut_1, BorderLayout.EAST);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		getContentPane().add(verticalStrut_1, BorderLayout.SOUTH);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel pNotas = new JPanel();
		pNotas.setForeground(SystemColor.textHighlight);
		pNotas.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.activeCaption, null));
		pNotas.setBounds(28, 29, 332, 168);
		panel.add(pNotas);
		pNotas.setLayout(null);
		
		JLabel lblNota1 = new JLabel("Nota 1: ");
		lblNota1.setBounds(35, 23, 57, 21);
		pNotas.add(lblNota1);
		
		JLabel lblNota2 = new JLabel("Nota 2: ");
		lblNota2.setBounds(35, 55, 57, 21);
		pNotas.add(lblNota2);
		
		JLabel lblNota3 = new JLabel("Nota 3: ");
		lblNota3.setBounds(35, 87, 57, 21);
		pNotas.add(lblNota3);
		
		JLabel lblTPs = new JLabel("TPs: ");
		lblTPs.setBounds(35, 122, 57, 21);
		pNotas.add(lblTPs);
		
		JTextField txtNota1 = new JTextField();
		txtNota1.setBounds(133, 23, 159, 20);
		pNotas.add(txtNota1);
		
		JTextField txtNota2 = new JTextField();
		txtNota2.setBounds(133, 55, 159, 20);
		pNotas.add(txtNota2);
		
		JTextField txtNota3 = new JTextField();
		txtNota3.setBounds(133, 87, 159, 20);
		pNotas.add(txtNota3);
		
		JComboBox<String> cmbAprobado = new JComboBox<String>();
		cmbAprobado.addItem("Seleccionar");
		cmbAprobado.addItem("Aprobado");
		cmbAprobado.addItem("Desaprobado");
		cmbAprobado.setBounds(133, 122, 159, 20);
		pNotas.add(cmbAprobado);
		
		JPanel pButtons = new JPanel();
		pButtons.setForeground(SystemColor.control);
		pButtons.setBounds(370, 60, 144, 123);
		panel.add(pButtons);
		pButtons.setLayout(new GridLayout(0, 1, 0, 0));

		JButton btnSalir = new JButton("SALIR");
		btnSalir.addActionListener(new EventoCerrar(this));
		pButtons.add(btnSalir);
		
		JLabel lblNotas = new JLabel("Notas del estudiante");
		lblNotas.setBounds(39, 11, 203, 14);
		panel.add(lblNotas);
		
		JLabel lblNotas_1 = new JLabel("Notas del estudiante");
		lblNotas_1.setBounds(39, 224, 177, 14);
		panel.add(lblNotas_1);
		
		JPanel pNotas_1 = new JPanel();
		pNotas_1.setToolTipText("");
		pNotas_1.setForeground(SystemColor.textHighlight);
		pNotas_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, SystemColor.activeCaption, null));
		pNotas_1.setBounds(28, 240, 332, 105);
		panel.add(pNotas_1);
		pNotas_1.setLayout(null);
		
		JLabel lblPromedio = new JLabel("Promedio: ");
		lblPromedio.setBounds(34, 11, 93, 21);
		pNotas_1.add(lblPromedio);
		
		JTextField txtPromedio = new JTextField();
		txtPromedio.setBounds(137, 11, 159, 20);
		pNotas_1.add(txtPromedio);
		
		JTextField txtCondicion = new JTextField();
		txtCondicion.setBounds(137, 57, 159, 20);
		pNotas_1.add(txtCondicion);
		
		JLabel lblCondicion = new JLabel("Condicion: ");
		lblCondicion.setBounds(34, 57, 93, 21);
		pNotas_1.add(lblCondicion);
		
		JButton btnCalcular = new JButton("CALCULAR");
		btnCalcular.addActionListener(new EventoCalcular(txtNota1,txtNota2, txtNota3, cmbAprobado, txtPromedio,txtCondicion));
		pButtons.add(btnCalcular);
		
		JButton btnNuevo = new JButton("NUEVO");
		btnNuevo.addActionListener(new EventoNuevo(txtNota1,txtNota2, txtNota3, cmbAprobado, txtPromedio,txtCondicion));
		pButtons.add(btnNuevo);
	}
}

class EventoCerrar implements ActionListener
{
	JFrame frame;
	public EventoCerrar(JFrame frame) {
		this.frame = frame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}
}

class EventoNuevo implements ActionListener
{
	JTextField txtNota1; 
	JTextField txtNota2;
	JTextField txtNota3;
	JComboBox<String> cmbAprobado;
	JTextField txtPromedio;
	JTextField txtCondicion;
	ArrayList<Component> components;
	
	public EventoNuevo(JTextField txtNota1, JTextField txtNota2, JTextField txtNota3, JComboBox<String> cmbAprobado , JTextField txtPromedio, JTextField txtCondicion) {
		this.components = new ArrayList<Component>();
		
		components.add(txtNota1);
		components.add(txtNota2);
		components.add(txtNota3);
		components.add(cmbAprobado);
		components.add(txtPromedio);
		components.add(txtCondicion);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for(Component c : components )
		{
			if(c instanceof JTextField)
			{
				((JTextField)c).setText("");
			}
			if(c instanceof JComboBox)
			{
				@SuppressWarnings("unchecked")
				JComboBox<String> combo = ((JComboBox<String>)c);
				combo.setSelectedItem("Seleccionar");
			}
		}
	}
}

class EventoCalcular implements ActionListener
{
	JTextField txtNota1; 
	JTextField txtNota2;
	JTextField txtNota3;
	JComboBox<String> cmbAprobado;
	JTextField txtPromedio;
	JTextField txtCondicion;
	
	public EventoCalcular(JTextField txtNota1, JTextField txtNota2, JTextField txtNota3, JComboBox<String> cmbAprobado , JTextField txtPromedio, JTextField txtCondicion) 
	{
		this.txtNota1 = txtNota1;
		this.txtNota2 = txtNota2;
		this.txtNota3 = txtNota3;
		this.cmbAprobado = cmbAprobado;
		this.txtPromedio = txtPromedio;
		this.txtCondicion = txtCondicion;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		boolean esCalculable = true;
		// Validar si son numeros
		if(!esNumeroValido(this.txtNota1.getText()))
		{
			esCalculable = false;
			txtNota1.setBackground(Color.red);
		}
		else
		{
			txtNota1.setBackground(Color.white);
		}
		
		if(!esNumeroValido(this.txtNota2.getText()))
		{
			esCalculable = false;
			txtNota2.setBackground(Color.red);
		}
		else
		{
			txtNota2.setBackground(Color.white);
		}
		
		if(!esNumeroValido(this.txtNota3.getText()))
		{
			esCalculable = false;
			txtNota3.setBackground(Color.red);
		}
		else
		{
			txtNota3.setBackground(Color.white);
		}
		if(esCalculable)
			Calcular();
	}
	
	private void Calcular() {

		double nota1 = Double.parseDouble(this.txtNota1.getText());
		double nota2 = Double.parseDouble(this.txtNota2.getText());
		double nota3 = Double.parseDouble(this.txtNota3.getText());

		double promedio = (nota1 + nota2 + nota3) / 3.0;
		promedio = Math.round(promedio * 10) / 10.0;
		this.txtPromedio.setText(String.valueOf(promedio));

		if((nota1 >= 8 && nota2 >= 8 && nota3 >= 8) && (String)this.cmbAprobado.getSelectedItem() == "Aprobado")
			this.txtCondicion.setText("Promocionado");	

		else if((String) this.cmbAprobado.getSelectedItem() != "Aprobado" || (nota1 < 6 || nota2 < 6 || nota3 < 6))
			this.txtCondicion.setText("Libre");
		else if(promedio >= 6 && (String)this.cmbAprobado.getSelectedItem() == "Aprobado")
			this.txtCondicion.setText("Regular");

	}

	private static boolean esNumeroValido(String s) {
		s = s.replace(",",".");
		
		final String Digits     = "(\\p{Digit}+)";
		final String HexDigits  = "(\\p{XDigit}+)";
		// an exponent is 'e' or 'E' followed by an optionally 
		// signed decimal integer.
		final String Exp        = "[eE][+-]?"+Digits;
		final String fpRegex    =
		    ("[\\x00-\\x20]*"+ // Optional leading "whitespace"
		    "[+-]?(" +         // Optional sign character
		    "NaN|" +           // "NaN" string
		    "Infinity|" +      // "Infinity" string
		    

		    // Digits ._opt Digits_opt ExponentPart_opt FloatTypeSuffix_opt
		    "((("+Digits+"(\\.)?("+Digits+"?)("+Exp+")?)|"+

		    // . Digits ExponentPart_opt FloatTypeSuffix_opt
		    "(\\.("+Digits+")("+Exp+")?)|"+

		    // Hexadecimal strings
		    "((" +
		    // 0[xX] HexDigits ._opt BinaryExponent FloatTypeSuffix_opt
		    "(0[xX]" + HexDigits + "(\\.)?)|" +

		    // 0[xX] HexDigits_opt . HexDigits BinaryExponent FloatTypeSuffix_opt
		    "(0[xX]" + HexDigits + "?(\\.)" + HexDigits + ")" +

		    ")[pP][+-]?" + Digits + "))" +
		    "[fFdD]?))" +
		    "[\\x00-\\x20]*");// Optional trailing "whitespace"
		if (Pattern.matches(fpRegex, s)){
		   double number = Double.valueOf(s);
		   return number >= 1 && number <=10;
		} else {
		   return false;
		}
	}	
}
