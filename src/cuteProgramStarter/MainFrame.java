package cuteProgramStarter;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class MainFrame extends JFrame {
	public JProgressBar bar = new JProgressBar(0,100);
	public JTextField sitBar = new JTextField();
	
	public MainFrame(){
		setUndecorated(true);
		setSize(new Dimension(250,100));
		setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2-125, Toolkit.getDefaultToolkit().getScreenSize().height/2-50);
		setVisible(true);
		
		Container pane = getContentPane();
		pane.setLayout(null);
		
		bar.setSize(new Dimension(250,20));
		bar.setLocation(0, 80);
		bar.setStringPainted(true);
		bar.setValue(0);
		pane.add(bar);
		
		sitBar.setText("Loading assets...");
		sitBar.setLocation(10, 60);
		sitBar.setSize(100,20);
		sitBar.setBackground(null);
		
		pane.add(sitBar);
		
		Thread barLoader = new Thread(new Runnable(){
				@Override
				public void run() {
					//Calls the loader
					loaderProcess();
				}
				
				public void loaderProcess(){
					//The process of the loader (loading variables, creating them etc)
					
					while(true){	
						try {
							Thread.sleep(100);
						} catch (InterruptedException e) {}
						
						bar.setValue(bar.getValue()+5);
						
						//If that statement below satisfies, finish It.
						if(bar.getValue() == 100){
							loadFinished();
							break;
						}
					}	
					
					//*********************************
				}
				
				public void loadFinished(){
					System.out.println("Loaded");
					System.exit(0);
				}
				
				public void barUpdate(int i){
					bar.setValue(i);
				}
				
				public void barMax(int i ){
					bar.setMaximum(i);
				}
				
				public void barMin(int i ){
					bar.setMinimum(i);
				}
		});
		
		//Starts the thread of the bar
		barLoader.start();
	}
}
