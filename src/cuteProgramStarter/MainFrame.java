package cuteProgramStarter;
/*
 * Written By Fatih AKTAŞ
 * 
The MIT License (MIT)

Copyright (c) 2016 Fatih Aktas

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
*/

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
		//asde
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
		sitBar.setBorder(null);
		sitBar.setEditable(false);
		
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
					
					//****************************************************************
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
				
				public void textUpdate(String str){
					sitBar.setText(str);
				}
		});
		
		//Starts the thread of the bar
		barLoader.start();
	}
	
	public static void main(String[] args){
		MainFrame loader = new MainFrame();
	}
}
