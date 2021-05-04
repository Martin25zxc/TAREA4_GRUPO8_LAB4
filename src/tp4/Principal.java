package tp4;

import java.awt.EventQueue;

public class Principal {
	public static void main(String [] args)
	{
		EventQueue.invokeLater(new Runnable(){
			public void run() {
				try {
					FramePrincipal window = new FramePrincipal();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
}

