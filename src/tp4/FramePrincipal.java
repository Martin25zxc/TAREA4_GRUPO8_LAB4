package tp4;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.Font;

public class FramePrincipal extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7771510967014416258L;

	/**
	 * Create the application.
	 */
	public FramePrincipal() {
		super();
		initialize();
	}

	/**
	 * Initialize the contents of the 
	 */
	private void initialize() {

	    setSize(392, 279);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    getContentPane().setLayout(new FormLayout(new ColumnSpec[] {
	    		ColumnSpec.decode("29px"),
	    		ColumnSpec.decode("200px"),},
	    	new RowSpec[] {
	    		FormSpecs.RELATED_GAP_ROWSPEC,
	    		FormSpecs.DEFAULT_ROWSPEC,
	    		FormSpecs.UNRELATED_GAP_ROWSPEC,
	    		RowSpec.decode("61px"),
	    		RowSpec.decode("25px"),
	    		FormSpecs.RELATED_GAP_ROWSPEC,
	    		FormSpecs.DEFAULT_ROWSPEC,
	    		FormSpecs.RELATED_GAP_ROWSPEC,
	    		FormSpecs.DEFAULT_ROWSPEC,
	    		FormSpecs.RELATED_GAP_ROWSPEC,
	    		FormSpecs.DEFAULT_ROWSPEC,
	    		FormSpecs.RELATED_GAP_ROWSPEC,
	    		FormSpecs.DEFAULT_ROWSPEC,
	    		RowSpec.decode("2px"),
	    		FormSpecs.RELATED_GAP_ROWSPEC,
	    		FormSpecs.DEFAULT_ROWSPEC,
	    		FormSpecs.RELATED_GAP_ROWSPEC,
	    		FormSpecs.DEFAULT_ROWSPEC,
	    		FormSpecs.UNRELATED_GAP_ROWSPEC,
	    		RowSpec.decode("23px"),
	    		FormSpecs.UNRELATED_GAP_ROWSPEC,
	    		RowSpec.decode("23px"),}));
	    
	    JLabel lblTittle = new JLabel("GRUPO NRO: 8");
	    lblTittle.setFont(new Font("Sylfaen", Font.BOLD, 16));
	    getContentPane().add(lblTittle, "2, 4, fill, fill");
	    
	    JButton btnEj1 = new JButton("Ejercicio 1");
	    btnEj1.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		FrameEj1 window = new FrameEj1();
				window.setVisible(true);
	    	}
	    });
	    getContentPane().add(btnEj1, "2, 5, right, bottom");
	    
	    JButton btnEj2 = new JButton("Ejercicio 2");
	    getContentPane().add(btnEj2, "2, 7, right, top");
	    
	    JButton btnEj3 = new JButton("Ejercicio 3");
	    getContentPane().add(btnEj3, "2, 9, right, top");
	    
	    setVisible(true);
		
	}
}
