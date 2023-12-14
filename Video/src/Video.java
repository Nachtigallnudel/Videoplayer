import java.awt.BorderLayout;
//import java.awt.Canvas;
import java.awt.FlowLayout;
//import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
//import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.SwingWorker;
import javax.swing.Timer;


import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
//import java.nio.file.Files;
//import java.nio.file.Path;




//import Streifen.Start;

public class Video extends JPanel implements ActionListener, KeyListener   {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String SHome=System.getProperty("user.home");
		
	private JFrame FrameVideo1;	
	private JFrame FrameVideo2;
	private JFrame FrameVideo3;
	
	private JButton startButton;
	private JButton startButton2;
	//private JButton manualButton; ok ok
	
	
	private JLabel LVido1PositionX;
	private JLabel LVido1PositionY;
	private JLabel LVido1SizeX;
	private JLabel LVido1SizeY;
	private JLabel LVido2PositionX;
	private JLabel LVido2PositionY;
	private JLabel LVido2SizeX;
	private JLabel LVido2SizeY;	
	private JLabel LVido3PositionX;
	private JLabel LVido3PositionY;
	private JLabel LVido3SizeX;
	private JLabel LVido3SizeY;
	
	private JLabel LVideo1;
	private JLabel LVideo2;
	private JLabel LPlatzhalter;
	private JLabel LPlatzhalter2;
	//private JLabel LPlatzhalter3;
	
	private Integer Vido1PositionX=0;
	private Integer Vido1PositionY=0;
	private Integer Vido1SizeX=1920;
	private Integer Vido1SizeY=1080;
	
	private Integer Vido2PositionX=100;
	private Integer Vido2PositionY=100;
	private Integer Vido2SizeX=400	;
	private Integer Vido2SizeY=300;	
	private Integer Vido3PositionX=100;
	private Integer Vido3PositionY=100;
	private Integer Vido3SizeX=400	;
	private Integer Vido3SizeY=300;	
	
		
	private Boolean BVideoEnd1=false;
	private Boolean BVideoEnd2=false;
	private Boolean BVideoEnd3=false;
	//@SuppressWarnings("unused")
	private Boolean Play=true;
	
	
	private Timer TT;
	private Timer TT2;
	private Timer TT3;
	private Timer TT4; // TTimer für Play länge Video
	public final static int ONE_SECOND = 50;   // Bestimmt nach dem Video wie Lange gewartet wird
	
	private JTextField TFVido1PositionX;
	private JTextField TFVido1PositionY;
	private JTextField TFVido1SizeX;
	private JTextField TFVido1SizeY;
	
	private JTextField TFVido3PositionX;
	private JTextField TFVido3PositionY;
	
	private JTextField TFVido2PositionX;
	private JTextField TFVido2PositionY;
	private JTextField TFVido2SizeX;
	private JTextField TFVido2SizeY;
	
	private JTextField TFVido3SizeX;
	private JTextField TFVido3SizeY;
	
	private JCheckBox CBTasten; 	//Umschalten Video zu Bild
	private JCheckBox CBTasten2;	//Manual
	private JCheckBox CBTasten3;	//Umschalten Control View sichtbar oder nicht
	private JCheckBox CBTasten4;	// Timer aktiv
	private Integer VideoLength=5000;	// Video Länge
	private JTextField TFVideoLaenge;
	private JLabel LTFVideoLaenge;
	
	
	
	
	private int	BildZaehler=1;
	
	
	
	
	private EmbeddedMediaPlayerComponent mediaPlayerComponent2;
	private EmbeddedMediaPlayerComponent mediaPlayerComponent1;
	private EmbeddedMediaPlayerComponent mediaPlayerComponent3;
	
	class Task extends SwingWorker<Void, Void> {
		/*
		 * Main task. Executed in background thread.
		 */
		@Override
		public Void doInBackground() {
			
			
		  return null;
		}
	
	
	
	
	/*
	 * Executed in event dispatching thread
	 */
	public void done() {
	  //Toolkit.getDefaultToolkit().beep();
	 
	  setCursor(null); // turn off the wait cursor
	  
	}
	}

	public Video() {
	super(new BorderLayout());

	addKeyListener(this);
    setFocusable(true);
    setFocusTraversalKeysEnabled(false);
	
	startButton = new JButton("++++++++++++     Play Videos     +++++++++++ ");
	startButton.setActionCommand("start");
	startButton.addActionListener(this);
	startButton.setSize(100, 30);
	
	
	startButton2 = new JButton("++++++++++++     Save Settings    +++++++++++ ");
	startButton2.setActionCommand("start2");
	startButton2.addActionListener(this);
	startButton2.setSize(100, 30);
	//startButton2.setSize(300, 5);;
	
	
	
	
	
	
	
	
	
	LVido1PositionX = new JLabel("Position - X");
	LVido1PositionY = new JLabel("Position - Y");
	LVido1SizeX = new JLabel("Video Width");
	LVido1SizeY = new JLabel("Video High");
	LVido2PositionX = new JLabel("Position - X");
	LVido2PositionY = new JLabel("Position - Y");
	LVido3PositionX = new JLabel("ControlVideo Position - X");
	LVido3PositionY = new JLabel("ControlVideo Position - Y");
	LVido2SizeX = new JLabel("Video Width");
	LVido2SizeY = new JLabel("Video High");
	LPlatzhalter = new JLabel("-");
	LPlatzhalter2 = new JLabel("-");
	LVido3SizeX = new JLabel("ControlVideo Width");
	LVido3SizeY = new JLabel("ControlVideo High");
	//LPlatzhalter3 = new JLabel("Switch to Key - Video Mode");
	
	LVideo1 = new JLabel("Video1: //videos/siOvideo1.mp4");
	LVideo2 = new JLabel("Video2: //videos/siOvideo2.mp4");
	
	TFVido1PositionX=new JTextField(String.valueOf(Vido1PositionX));
	TFVido1PositionX.setHorizontalAlignment(JTextField.CENTER);
	TFVido1PositionX.setColumns(20);
	
	
	TFVido1PositionY=new JTextField(String.valueOf(Vido1PositionY));
	TFVido1PositionY.setHorizontalAlignment(JTextField.CENTER);
	TFVido1SizeX=new JTextField(String.valueOf(Vido1SizeX));
	TFVido1SizeX.setHorizontalAlignment(JTextField.CENTER);
	TFVido1SizeY=new JTextField(String.valueOf(Vido1SizeY));
	TFVido1SizeY.setHorizontalAlignment(JTextField.CENTER);
	
	TFVido2PositionX=new JTextField(String.valueOf(Vido2PositionX));
	TFVido2PositionX.setHorizontalAlignment(JTextField.CENTER);
	TFVido2PositionX.setColumns(20);;
	TFVido2PositionY=new JTextField(String.valueOf(Vido2PositionY));
	TFVido2PositionY.setHorizontalAlignment(JTextField.CENTER);
	TFVido2SizeX=new JTextField(String.valueOf(Vido2SizeX));
	TFVido2SizeX.setHorizontalAlignment(JTextField.CENTER);
	TFVido2SizeY=new JTextField(String.valueOf(Vido2SizeY));
	TFVido2SizeY.setHorizontalAlignment(JTextField.CENTER);
	
	TFVido3PositionX=new JTextField(String.valueOf(Vido3PositionX));
	TFVido3PositionX.setHorizontalAlignment(JTextField.CENTER);
	TFVido3PositionX.setColumns(20);;
	TFVido3PositionY=new JTextField(String.valueOf(Vido3PositionY));
	TFVido3PositionY.setHorizontalAlignment(JTextField.CENTER);
	TFVido3SizeX=new JTextField(String.valueOf(Vido3SizeX));
	TFVido3SizeX.setHorizontalAlignment(JTextField.CENTER);
	TFVido3SizeY=new JTextField(String.valueOf(Vido3SizeY));
	TFVido3SizeY.setHorizontalAlignment(JTextField.CENTER);
	
	
	TFVideoLaenge=new JTextField(String.valueOf(VideoLength));
	TFVideoLaenge.setHorizontalAlignment(JTextField.CENTER);
	TFVideoLaenge.setColumns(20);;	
	LTFVideoLaenge = new JLabel("Video Länge in ms:");
	
	
	CBTasten = new JCheckBox("Key - Mode");
	CBTasten.setSelected(true);
	
	CBTasten2 = new JCheckBox("Manual");
	CBTasten2.setSelected(true);
	CBTasten2.setActionCommand("start3");
	CBTasten2.addActionListener(this);
	
	CBTasten3 = new JCheckBox("Control View");
	CBTasten3.setSelected(true);
	CBTasten3.setActionCommand("start4");
	CBTasten3.addActionListener(this);
	
	CBTasten4 = new JCheckBox("Activate Time Length");
	CBTasten4.setSelected(false);
	
	
	
	
	
	
	
		
	JPanel Links = new JPanel();
	JPanel Rechts = new JPanel();
	JPanel unten = new JPanel();
	
	Links.setLayout(new BoxLayout(Links, BoxLayout.Y_AXIS));
	//Links.
	Rechts.setLayout(new BoxLayout(Rechts, BoxLayout.Y_AXIS));
	unten.setLayout(new BoxLayout(unten, BoxLayout.X_AXIS));
	unten.setAlignmentX(CENTER_ALIGNMENT);
	//LL.getcsetSize(200, 50);
	//LCompany.setHorizontalAlignment(ABORT);
	
	
	
	unten.add(startButton);
	unten.add(startButton2);
	unten.add(CBTasten);
	
	
	Links.add(CBTasten);
	Links.add(CBTasten4);
	Links.add(LTFVideoLaenge);
	Links.add(LVideo1);
	Links.add(LVideo1);
	Links.add(LVido1PositionX);
	Links.add(TFVido1PositionX);	
	Links.add(LVido1PositionY);
	Links.add(TFVido1PositionY);	
	Links.add(LVido1SizeX);
	Links.add(TFVido1SizeX);
	Links.add(LVido1SizeY);
	Links.add(TFVido1SizeY);	
	Links.add(LVido3PositionX);
	Links.add(TFVido3PositionX);
	Links.add(LVido3SizeX);
	Links.add(TFVido3SizeX);
	Links.add(LPlatzhalter);
	//Links.add(manualButton);
	//Links.add(CBTasten);
	
	
	Rechts.add(CBTasten3);
	Rechts.add(CBTasten2);
	Rechts.add(TFVideoLaenge);
	Rechts.add(LVideo2);	
	Rechts.add(LVido2PositionX);
	Rechts.add(TFVido2PositionX);	
	Rechts.add(LVido2PositionY);
	Rechts.add(TFVido2PositionY);
	Rechts.add(LVido2SizeX);
	Rechts.add(TFVido2SizeX);
	Rechts.add(LVido2SizeY);
	Rechts.add(TFVido2SizeY);
	Rechts.add(LVido3PositionY);
	Rechts.add(TFVido3PositionY);
	Rechts.add(LVido3SizeY);
	Rechts.add(TFVido3SizeY);
	Rechts.add(LPlatzhalter2);
	
	

	
	
	
	
	//add(oben,BorderLayout.NORTH);
	add(Links, BorderLayout.WEST);
	add(Rechts, BorderLayout.EAST);
	add(unten,BorderLayout.SOUTH);
	
	//Play=false;
	
	
	System.out.println("++++++++++++++++++++++++++++++++++   Start App  ++++++++++++++++++++++++++++"); 
	
	TT = new Timer(ONE_SECOND, new ActionListener() {
	    public void actionPerformed(ActionEvent evt) {
	    	System.out.println("TT   Timer fertig nach 50 ms");
	    	//java.awt.Toolkit.getDefaultToolkit().beep();
	    	mediaPlayerComponent1.mediaPlayer().controls().start();		
			//mediaPlayerComponent2.mediaPlayer().controls().start();
			//mediaPlayerComponent3.mediaPlayer().controls().start();
			if(CBTasten.isSelected())
			{
				TT3.start();		  
			}
			else
			{
				mediaPlayerComponent2.mediaPlayer().controls().start();
				mediaPlayerComponent3.mediaPlayer().controls().start();
				//System.out.println("Start Video 2 und 3 +++++++++++++++++++++++++++++");
			}
	            TT.stop();
	            //...GUI aktualisieren...
	        
	    }    
	});
	
	TT2 = new Timer(ONE_SECOND, new ActionListener() {
	    public void actionPerformed(ActionEvent evt) {
	    	System.out.println("Timer fertig nach 50 ms");
	    	
	    	StartVideo1();
	    	StartVideo2();
	    	StartVideo3();
	    	//TT3.start();
	            TT2.stop();
	            //...GUI aktualisieren...
	        
	    }    
	});
	
	// Timer zum stoppen des Video bei Bilder Anzeige
	TT3 = new Timer(ONE_SECOND, new ActionListener() {
	    public void actionPerformed(ActionEvent evt) {
	    	System.out.println("Timer fertig nach 50 ms");
	    	//mediaPlayerComponent3.mediaPlayer().controls().pause();	
	    	mediaPlayerComponent2.mediaPlayer().controls().setPause(true);
			mediaPlayerComponent3.mediaPlayer().controls().setPause(true);
	    	//mediaPlayerComponent2.mediaPlayer().controls().pause();	
			//mediaPlayerComponent3.mediaPlayer().controls().pause();
			
			System.out.println("Pause Video 2 und 3 +++++++++++++++++++++++++++++");
	        TT3.stop();
	            //...GUI aktualisieren...
	        
	    }    
	});
	
	 lesenINI();
	
	TT4 = new Timer(VideoLength, new ActionListener() {
	    public void actionPerformed(ActionEvent evt) {
	    	System.out.println("Timer fertig nach Video Länge ms = " + VideoLength);
	    	
			System.out.println("Static Video Länge restart Videos");
			mediaPlayerComponent1.mediaPlayer().controls().stop();
			mediaPlayerComponent2.mediaPlayer().controls().stop();
			mediaPlayerComponent3.mediaPlayer().controls().stop();
			
			
			TT.start();
	       // TT4.stop();
	            //...GUI aktualisieren...
	        
	    }    
	});
	
	//schreibenINI();
	 //lesenINI();
	 checkScreen();
	
	
	
	
	
	TT2.start();
	if(CBTasten4.isSelected())
	{
	
		TT4.start();
		
	}
	
	

	}
	
	
	
	
	
	
public void actionPerformed(ActionEvent arg0) {
		
		// TODO Automatisch generierter Methodenstub	
		if (arg0.getSource() == startButton) {
			System.out.println("Play all Videos"); 
			
			schreibenINI();
			
			if(CBTasten4.isSelected())
			{
				TT4.start();
			}
			
				
				
			
				StartVideo1();
				StartVideo2();
				StartVideo3();
			
		}
		
		if (arg0.getSource() == startButton2) {
			System.out.println("Stop all Videos"); 
						
			schreibenINI();
		    }
		
		
		if (arg0.getSource() == CBTasten2) {
			System.out.println("Push Manual"); 
			
			JOptionPane.showMessageDialog(null, 
					
					"All content is to be saved in Videos folder C:\\Users\\xxx\\Videos"+
					" \n"+					
					"Video 1      = Color Video \n"+					
					" \n"+
					"Key Mode  = inactive \n"+
					"Video 2      = black and withe > Filter Video \n"+
					" \n"+
					"Key Mode  = active \n"+
					"Video 2      = black and withe > Filter Images \n"+
					" \n"+
					"Keys :\n"+
					"Space      = Pause / Play Video \n"+
					"<                = image back \n"+
					">                = image forward \n"+
					"ESC           = Stop Video \n"+
					"Mouse click      = Stop Video \n"
							
					,  "siOPTICA Videoplayer Manual", 
                    JOptionPane.INFORMATION_MESSAGE);
			
			
		    }
			
			
			
		
	
}
	




	
	
	/**
	* Create the GUI and show it. As with all GUI code, this must run on the
	* event-dispatching thread.
	*/
	private static   void createAndShowGUI() {
	// Create and set up the window.
	JFrame frame = new JFrame("siOPTICA 2.1 -Video Player");
	frame.setLayout(new FlowLayout());
	frame.setSize(600, 450);
	//frame.addKeyListener(this);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocation(100, 100);
	
	JComponent newContentPane = new Video();
	newContentPane.setOpaque(true); // content panes must be opaque
	frame.setContentPane(newContentPane);
	frame.setResizable(false);
	

	// Display the window.
	
	frame.setVisible(true);
	//frame.toBack();
	}
	

	public static void main(String[] args) {
	// Schedule a job for the event-dispatching thread:
	// creating and showing this application's GUI.
	javax.swing.SwingUtilities.invokeLater(new Runnable() {
	  @Override
	public void run() {
	    createAndShowGUI();
	    
	  }
	});
	}

	
	
	
	public void StartVideo1() {
		
		System.out.println("Play Video 1"); 
		
		FrameVideo1 = new JFrame("Video 1");
		FrameVideo1.setSize(Integer.parseInt(TFVido1SizeX.getText()), Integer.parseInt(TFVido1SizeY.getText()));
		FrameVideo1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		FrameVideo1.setUndecorated(true);
		FrameVideo1.setLocation(Integer.parseInt(TFVido1PositionX.getText()), Integer.parseInt(TFVido1PositionY.getText()));
		//FrameVideo1.add(new JLabel("Hello World"), BorderLayout.CENTER);
		
		
		
		JPanel Anzeige2 = new JPanel();	
		Anzeige2.setLayout(new BoxLayout(Anzeige2, BoxLayout.X_AXIS));	
		
		
		
		// Video Play
		
		mediaPlayerComponent1 =  new EmbeddedMediaPlayerComponent()
		{
			 /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			@Override
			public void mouseClicked(MouseEvent e) {
	            super.mouseClicked(e);
	            System.out.println("Mouse Clicked. (" + e.getX() + "," + e.getY() + ")");
	            StopVideo();
	         }
			
			

			@Override
			   public void finished(MediaPlayer mediaPlayer) {
				 System.out.println("Ende Video 1"); 
				 BVideoEnd1=true;
				
					//mediaPlayerComponent1.mediaPlayer().controls().stop();
				
				 checkPlay();
			   }
			
		};		
				
				
		String video1;
		video1 =SHome + "\\videos\\siOvideo1.mp4";
		Anzeige2.add(mediaPlayerComponent1);		
		add(Anzeige2, BorderLayout.NORTH);		
		FrameVideo1.add(Anzeige2);
		
		FrameVideo1.setVisible(true);
		//mediaPlayerComponent1.mediaPlayer().controls().setRepeat(true);
		mediaPlayerComponent1.mediaPlayer().media().play(video1); 
		BVideoEnd1=false;
		FrameVideo1.addKeyListener(this);
	}
	
public void StartVideo2() {
	
		System.out.println("Play Video 2"); 
		
		FrameVideo2 = new JFrame("Video 2");
		FrameVideo2.setSize(Integer.parseInt(TFVido2SizeX.getText()), Integer.parseInt(TFVido2SizeY.getText()));
		FrameVideo2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		FrameVideo2.setUndecorated(true);
		FrameVideo2.setLocation(Integer.parseInt(TFVido2PositionX.getText()), Integer.parseInt(TFVido2PositionY.getText()));
		
		JPanel Anzeige3 = new JPanel();	
		Anzeige3.setLayout(new BoxLayout(Anzeige3, BoxLayout.X_AXIS));		
		// Video Play		
		mediaPlayerComponent2 =  new EmbeddedMediaPlayerComponent()
		{
			 /**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			
			@Override
			public void mouseClicked(MouseEvent e) {
	            super.mouseClicked(e);
	            System.out.println("Mouse Clicked. (" + e.getX() + "," + e.getY() + ")");
	            StopVideo();
	         }

			@Override
			   public void finished(MediaPlayer mediaPlayer2) {
				 System.out.println("Ende Video 2"); 
				 if(CBTasten.isSelected())
					{
					 	//mediaPlayerComponent2.mediaPlayer().controls().start();
						//mediaPlayerComponent3.mediaPlayer().controls().start();
					    BVideoEnd2=true;
					 	checkPlay();
					 
					}
					 else
					 {
						 BVideoEnd2=true;
						  checkPlay();
					 }
				 
				
					
				
				
			   }
			
		};
		
		
		
		String video2;
		//video2 =SHome + "\\videos\\siOvideo2.mp4";
		//video2 =SHome + "\\videos\\siOB1.jpg";
		if(CBTasten.isSelected())
		{
			video2 =SHome + "\\videos\\siOB1.jpg";
			LVideo2.setText("Video2: //videos/siOB1...4.jpg");
			switch(BildZaehler){
	        case 1:
	        	video2 =SHome + "\\videos\\siOB1.jpg";
	            System.out.println("i ist null");
	            break;
	        case 2:
	        	video2 =SHome + "\\videos\\siOB2.jpg";
	            System.out.println("i ist eins");
	            break;
	        case 3:
	        	video2 =SHome + "\\videos\\siOB3.jpg";
	            System.out.println("i ist zwei");
	            break;
	        case 4:
	        	video2 =SHome + "\\videos\\siOB4.jpg";
	            System.out.println("i ist drei");
	            break;
	        default:
	        	video2 =SHome + "\\videos\\siOB1.jpg";
	            System.out.println("i liegt nicht zwischen 1 und 4");
	            break;
	        }
		}
		else
		{
			video2 =SHome + "\\videos\\siOvideo2.mp4";
			LVideo2.setText("Video2: //videos/siOvideo2.mp4");
		}
		
		
		Anzeige3.add(mediaPlayerComponent2);		
		add(Anzeige3, BorderLayout.NORTH);		
		FrameVideo2.add(Anzeige3);
		
			
		
		
		FrameVideo2.setVisible(true);
		//mediaPlayerComponent2.mediaPlayer().controls().setRepeat(true);
		//mediaPlayerComponent2.mediaPlayer().audio().mute();
		mediaPlayerComponent2.mediaPlayer().media().play(video2); 
		BVideoEnd2=false;
		FrameVideo2.addKeyListener(this);
		
		
		
	}
public void StartVideo3() {
	
	System.out.println("Play Video 3"); 
	
	FrameVideo3 = new JFrame("Video 3");
	FrameVideo3.setSize(Integer.parseInt(TFVido3SizeX.getText()), Integer.parseInt(TFVido3SizeY.getText()));
	FrameVideo3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	FrameVideo3.setUndecorated(true);
	FrameVideo3.setLocation(Integer.parseInt(TFVido3PositionX.getText()),Integer.parseInt(TFVido3PositionY.getText()));
	
	JPanel Anzeige4 = new JPanel();	
	Anzeige4.setLayout(new BoxLayout(Anzeige4, BoxLayout.X_AXIS));		
	// Video Play		
	mediaPlayerComponent3 =  new EmbeddedMediaPlayerComponent()
	{
		 /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		@Override
		public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            System.out.println("Mouse Clicked. (" + e.getX() + "," + e.getY() + ")");
            StopVideo();
         }

		@Override
		   public void finished(MediaPlayer mediaPlayer3) {
			 System.out.println("Ende Video 3"); 
			 
				 if(CBTasten.isSelected())
					{
					 	//mediaPlayerComponent2.mediaPlayer().controls().start();
						//mediaPlayerComponent3.mediaPlayer().controls().start();
					    BVideoEnd3=true;
					 	checkPlay();
					 
					}
					 else
					 {
						 BVideoEnd3=true;
						  checkPlay();
					 }
		   }
		
	};
	
	
	
	@SuppressWarnings("unused")
	String video3;
	//video2 =SHome + "\\videos\\siOvideo2.mp4";
	//video2 =SHome + "\\videos\\siOB1.jpg";
	if(CBTasten.isSelected())
	{
		video3 =SHome + "\\videos\\siOB1.jpg";
		LVideo2.setText("Video2: //videos/siOB1...4.jpg");
		switch(BildZaehler){
        case 1:
        	video3 =SHome + "\\videos\\siOB1.jpg";
            System.out.println("i ist null");
            break;
        case 2:
        	video3 =SHome + "\\videos\\siOB2.jpg";
            System.out.println("i ist eins");
            break;
        case 3:
        	video3 =SHome + "\\videos\\siOB3.jpg";
            System.out.println("i ist zwei");
            break;
        case 4:
        	video3 =SHome + "\\videos\\siOB4.jpg";
            System.out.println("i ist drei");
            break;
        default:
        	video3 =SHome + "\\videos\\siOB1.jpg";
            System.out.println("i liegt nicht zwischen 1 und 4");
            break;
        }
	}
	else
	{
		video3 =SHome + "\\videos\\siOvideo2.mp4";
		LVideo2.setText("Video2: //videos/siOvideo2.mp4");
	}
	
	
	Anzeige4.add(mediaPlayerComponent3);		
	add(Anzeige4, BorderLayout.NORTH);		
	FrameVideo3.add(Anzeige4);
	//mediaPlayerComponent3.mediaPlayer().media().play(video3);
	
		
	
	if(CBTasten3.isSelected())
	{
		FrameVideo3.setVisible(true);
		mediaPlayerComponent3.mediaPlayer().media().play(video3); 
	}
	else
	{
		FrameVideo3.setVisible(false);
		//mediaPlayerComponent3.mediaPlayer().media().play(video3);
	}
	
	//mediaPlayerComponent2.mediaPlayer().controls().setRepeat(true);
	//mediaPlayerComponent2.mediaPlayer().audio().mute();
	
	BVideoEnd2=false;
	FrameVideo3.addKeyListener(this);
	
	
	
}
public void StopVideo() {
	
	System.out.println("Stop Video 1 & 2"); 
	
	mediaPlayerComponent2.mediaPlayer().controls().stop();
	mediaPlayerComponent1.mediaPlayer().controls().stop();
	mediaPlayerComponent3.mediaPlayer().controls().stop();
	FrameVideo2.dispose();
	FrameVideo1.dispose();
	FrameVideo3.dispose();
	TT4.stop();
	
	
}

public void checkPlay() {
	
	
		System.out.println("check play");
		System.out.println("BVideoEnd1 = " +BVideoEnd1.booleanValue());
		System.out.println("BVideoEnd2 = " +BVideoEnd2.booleanValue());
		System.out.println("BVideoEnd3 = " +BVideoEnd2.booleanValue());
		
		if(CBTasten4.isSelected())
		{
		
			
			
		}
		else
		{
				if(CBTasten.isSelected())
			{
				
				//BVideoEnd1=false;
				//BVideoEnd2=false;
				TT.start();		  
			}
			else
			{
				if(BVideoEnd1.equals(true) && BVideoEnd2.equals(true)&& BVideoEnd3.equals(true))
				{
					System.out.println("Restart Video 1&2");
					BVideoEnd1=false;
					BVideoEnd2=false;
					BVideoEnd3=false;
					
					TT.start();	
				}
			}
		}
		
		
	
		
		
	
	
	
}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("Taste gedrückt"); 
}

@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	System.out.println("ESC Stop Videos"); 
	if(e.getKeyCode() == KeyEvent.VK_ESCAPE) {
		StopVideo();
	}
	
	if(e.getKeyCode() == KeyEvent.VK_P) {
		System.out.println("P Play Videos"); 
		//mediaPlayerComponent1.mediaPlayer().controls().nextFrame();	
		//mediaPlayerComponent2.mediaPlayer().controls().nextFrame();
		mediaPlayerComponent1.mediaPlayer().controls().start();	
		mediaPlayerComponent2.mediaPlayer().controls().start();
		mediaPlayerComponent3.mediaPlayer().controls().start();

	}
	
	if(e.getKeyCode() == KeyEvent.VK_O) {
		System.out.println("O Pause  Videos 2 und 3 "); 
		//mediaPlayerComponent1.mediaPlayer().controls().nextFrame();	
		//mediaPlayerComponent2.mediaPlayer().controls().nextFrame();
		//mediaPlayerComponent1.mediaPlayer().controls().start();	
		mediaPlayerComponent2.mediaPlayer().controls().setPause(true);
		mediaPlayerComponent3.mediaPlayer().controls().setPause(true);
		//mediaPlayerComponent2.mediaPlayer().controls().pause();
		//mediaPlayerComponent3.mediaPlayer().controls().pause();
		//mediaPlayerComponent2.mediaPlayer().controls().

	}
	
	
	
	if(e.getKeyCode() == KeyEvent.VK_LEFT) {
		System.out.println("Key Left"); 
		if(CBTasten.isSelected())
		{
					//mediaPlayerComponent1.mediaPlayer().controls().pause();		
			//StopVideo();
			mediaPlayerComponent2.mediaPlayer().controls().stop();		
			FrameVideo2.dispose();
			mediaPlayerComponent3.mediaPlayer().controls().stop();		
			FrameVideo3.dispose();
			
			
			
			if(BildZaehler < 2)
			{
				
				BildZaehler=4;
			}
			else
			{
				BildZaehler=BildZaehler-1;
			}
			System.out.println("Bild = " + BildZaehler); 
			//StartVideo1();
			//mediaPlayerComponent1.mediaPlayer().controls().play();	
			StartVideo2();
			StartVideo3();
			if(CBTasten.isSelected())
			{
				TT3.start();		  
			}
		}
	
		
		
		

	}
	if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
		System.out.println("Key right"); 
		
		if(CBTasten.isSelected())
		{
				//mediaPlayerComponent1.mediaPlayer().controls().pause();		
			mediaPlayerComponent2.mediaPlayer().controls().stop();		
			FrameVideo2.dispose();
			mediaPlayerComponent3.mediaPlayer().controls().stop();		
			FrameVideo3.dispose();
			if(BildZaehler <4)
			{
				BildZaehler=BildZaehler+1;
			}
			else
			{
				BildZaehler=1;
			}
			System.out.println("Bild = " + BildZaehler); 
			
			//mediaPlayerComponent1.mediaPlayer().controls().play();	
			StartVideo2();
			StartVideo3();
			if(CBTasten.isSelected())
			{
				TT3.start();		  
			}
			
		}
		
		

	}
	if(e.getKeyCode() == KeyEvent.VK_SPACE) {
		System.out.println("Key space"); 
		
		if(Play )
		{
			mediaPlayerComponent1.mediaPlayer().controls().setPause(true);
			mediaPlayerComponent2.mediaPlayer().controls().setPause(true);
			if(CBTasten3.isSelected())
			{
				mediaPlayerComponent3.mediaPlayer().controls().setPause(true);
			}
			
			Play =false;
			System.out.println("Key space = true"); 
		}
		else
		{
			
			mediaPlayerComponent1.mediaPlayer().controls().play();
			mediaPlayerComponent2.mediaPlayer().controls().play();
			if(CBTasten3.isSelected())
			{
				mediaPlayerComponent3.mediaPlayer().controls().play();
			}
			
			Play =true;
			System.out.println("Key space = false"); 
			if(CBTasten.isSelected())
			{
				TT3.start();		  
			}
		}
		

	}
	
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}




public void lesenINI()
{
	
	ladeDatei(SHome + "\\videos\\siOINI.txt");
}

public void checkScreen()
{
	GraphicsEnvironment ge = GraphicsEnvironment.
			   getLocalGraphicsEnvironment();
			   GraphicsDevice[] gs = ge.getScreenDevices();				   
			  
				     
	
	
	if(gs.length == 1) {
		JOptionPane.showMessageDialog(null, 
			"Please check your second Screen  !!!!!!!!!!!!!!!!!!!",
         SHome, JOptionPane.INFORMATION_MESSAGE);
	}
	
	
}

public void schreibenINI()
{
	PrintWriter pWriter = null;
	 System.out.println("Schreiben Ini 1" );
	Vido1PositionX=Integer.parseInt(TFVido1PositionX.getText());
	Vido1PositionY=Integer.parseInt(TFVido1PositionY.getText());
	Vido1SizeX=Integer.parseInt(TFVido1SizeX.getText());
	Vido1SizeY=Integer.parseInt(TFVido1SizeY.getText());
	
	Vido2PositionX=Integer.parseInt(TFVido2PositionX.getText());
	Vido2PositionY=Integer.parseInt(TFVido2PositionY.getText());
	Vido2SizeX=Integer.parseInt(TFVido2SizeX.getText());
	Vido2SizeY=Integer.parseInt(TFVido2SizeY.getText());
	
	Vido3PositionX=Integer.parseInt(TFVido3PositionX.getText());
	Vido3PositionY=Integer.parseInt(TFVido3PositionY.getText());
	Vido3SizeX=Integer.parseInt(TFVido3SizeX.getText());
	Vido3SizeY=Integer.parseInt(TFVido3SizeY.getText());
	VideoLength=Integer.parseInt(TFVideoLaenge.getText());
	 System.out.println("Schreiben Ini 2 " );
	
    String s = SHome + "\\videos\\siOINI.txt";
    try {
        pWriter = new PrintWriter(new FileWriter(s));
        pWriter.println("siOPTICA GMBH Videoplayer INI");
        pWriter.println("Video1PX=" +Vido1PositionX);
        pWriter.println("Video1PY=" +Vido1PositionY);
        pWriter.println("Video1SX=" +Vido1SizeX);
        pWriter.println("Video1SY=" +Vido1SizeY);
        pWriter.println("Video2PX=" +Vido2PositionX);
        pWriter.println("Video2PY=" +Vido2PositionY);
        pWriter.println("Video2SX=" +Vido2SizeX);
        pWriter.println("Video2SY=" +Vido2SizeY);
        pWriter.println("KeyMode=" +CBTasten.isSelected()); 
        pWriter.println("CView=" +CBTasten3.isSelected()); 
        pWriter.println("Video3PX=" +Vido3PositionX);
        pWriter.println("Video3PY=" +Vido3PositionY);
        pWriter.println("Video3SX=" +Vido3SizeX);
        pWriter.println("Video3SY=" +Vido3SizeY);
        pWriter.println("TimerActive=" +CBTasten4.isSelected()); 
        pWriter.println("VideoLength=" +VideoLength); 
        
        
        
    } catch (IOException ioe) {
        ioe.printStackTrace();
    } finally {
        if (pWriter != null) {
            pWriter.flush();
            pWriter.close();
        }
    }
}



private void ladeDatei(String datName) {

    File file = new File(datName);
    String[] parts2 = null;
    String[] parts3 = null;
    String[] parts4 = null;
    String[] parts5 = null;
    String[] parts6 = null;
    String[] parts7 = null;
    String[] parts8 = null;
    String[] parts9 = null;
    String[] parts10 = null;
    String[] parts11 = null;
    String[] parts12 = null;
    String[] parts13 = null;
    String[] parts14 = null;
    String[] parts15 = null;
    String[] parts16 = null;
    String[] parts17 = null;

    if (!file.canRead() || !file.isFile())
    {
    	System.out.println("keine Ini" ); 
    	JOptionPane.showMessageDialog(null, "First time to start write ini File", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
    	schreibenINI();
    	System.exit(0);
    }
       

        BufferedReader in = null;
    try {
        in = new BufferedReader(new FileReader(datName));
        String zeile = null;
        
        Integer Z=1;
        while ((zeile = in.readLine()) != null) {
            System.out.println("Zeile NR = "+ Z + " Gelesene Zeile: " + zeile );
            if(Z==2) parts2 = zeile.split("=");
            if(Z==3) parts3 = zeile.split("=");
            if(Z==4) parts4 = zeile.split("=");
            if(Z==5) parts5 = zeile.split("=");
            if(Z==6) parts6 = zeile.split("=");
            if(Z==7) parts7 = zeile.split("=");
            if(Z==8) parts8 = zeile.split("=");
            if(Z==9) parts9 = zeile.split("=");
            if(Z==10) parts10 = zeile.split("=");
            if(Z==11) parts11 = zeile.split("=");
            if(Z==12) parts12 = zeile.split("=");
            if(Z==13) parts13 = zeile.split("=");
            if(Z==14) parts14 = zeile.split("=");
            if(Z==15) parts15 = zeile.split("=");
            if(Z==16) parts16 = zeile.split("=");
            if(Z==17) parts17 = zeile.split("=");
           // System.out.println("Gelesen =  " + parts[1] );
            
            Z=Z+1;
        }
    } catch (IOException e) {
    	        e.printStackTrace();
    } finally {
        if (in != null)
            try {
                in.close();
            } catch (IOException e) {
            	
            }
    }
   
    Vido1PositionX= Integer.parseInt(parts2[1]);
    Vido1PositionY= Integer.parseInt(parts3[1]);
    Vido1SizeX= Integer.parseInt(parts4[1]);
    Vido1SizeY= Integer.parseInt(parts5[1]);
    Vido2PositionX= Integer.parseInt(parts6[1]);
    Vido2PositionY= Integer.parseInt(parts7[1]);
    Vido2SizeX= Integer.parseInt(parts8[1]);
    Vido2SizeY= Integer.parseInt(parts9[1]);
    CBTasten.setSelected(Boolean.valueOf(parts10[1]));
    CBTasten3.setSelected(Boolean.valueOf(parts11[1]));
    Vido3PositionX= Integer.parseInt(parts12[1]);
    Vido3PositionY= Integer.parseInt(parts13[1]);
    Vido3SizeX= Integer.parseInt(parts14[1]);
    Vido3SizeY= Integer.parseInt(parts15[1]);
    CBTasten4.setSelected(Boolean.valueOf(parts16[1]));
    VideoLength= Integer.parseInt(parts17[1]);
    
    
    
    TFVido1PositionX.setText(String.valueOf(Vido1PositionX));
    TFVido1PositionY.setText(String.valueOf(Vido1PositionY));
    TFVido1SizeX.setText(String.valueOf(Vido1SizeX));
    TFVido1SizeY.setText(String.valueOf(Vido1SizeY));
    
    
    TFVido2PositionX.setText(String.valueOf(Vido2PositionX));
    TFVido2PositionY.setText(String.valueOf(Vido2PositionY));
    TFVido2SizeX.setText(String.valueOf(Vido2SizeX));
    TFVido2SizeY.setText(String.valueOf(Vido2SizeY));
    
    TFVido3PositionX.setText(String.valueOf(Vido3PositionX));
    TFVido3PositionY.setText(String.valueOf(Vido3PositionY));
    TFVido3SizeX.setText(String.valueOf(Vido3SizeX));
    TFVido3SizeY.setText(String.valueOf(Vido3SizeY));
    TFVideoLaenge.setText(String.valueOf(VideoLength));
    
    //System.out.println("Zeile NR = "+ Z + " Gelesene Zeile: " + zeile );
    
    
}





	
	
}






