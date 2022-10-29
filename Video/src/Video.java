import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.SwingWorker;
import javax.swing.Timer;


import uk.co.caprica.vlcj.player.base.MediaPlayer;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;





//import Streifen.Start;

public class Video extends JPanel implements ActionListener, KeyListener   {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String SHome=System.getProperty("user.home");
		
	private JFrame FrameVideo1;	
	private JFrame FrameVideo2;
	
	private JButton startButton;
	private JButton startButton2;
	
	
	private JLabel LVido1PositionX;
	private JLabel LVido1PositionY;
	private JLabel LVido1SizeX;
	private JLabel LVido1SizeY;
	private JLabel LVido2PositionX;
	private JLabel LVido2PositionY;
	private JLabel LVido2SizeX;
	private JLabel LVido2SizeY;
	
	private JLabel LVideo1;
	private JLabel LVideo2;
	private JLabel LPlatzhalter;
	private JLabel LPlatzhalter2;
	
	private Integer Vido1PositionX=0;
	private Integer Vido1PositionY=0;
	private Integer Vido1SizeX=1920;
	private Integer Vido1SizeY=1080;
	
	private Integer Vido2PositionX=1920;
	private Integer Vido2PositionY=0;
	private Integer Vido2SizeX=3840;
	private Integer Vido2SizeY=2160;	
	
		
	private Boolean BVideoEnd1=false;
	private Boolean BVideoEnd2=false;
	
	private Timer TT;
	public final static int ONE_SECOND = 50;   // Bestimmt nach dem Video wie Lange gewartet wird
	
	private JTextField TFVido1PositionX;
	private JTextField TFVido1PositionY;
	private JTextField TFVido1SizeX;
	private JTextField TFVido1SizeY;
	
	private JTextField TFVido2PositionX;
	private JTextField TFVido2PositionY;
	private JTextField TFVido2SizeX;
	private JTextField TFVido2SizeY;
	
	private EmbeddedMediaPlayerComponent mediaPlayerComponent2;
	private EmbeddedMediaPlayerComponent mediaPlayerComponent1;
	
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
	startButton.setSize(200, 30);
	
	
	startButton2 = new JButton("++++++++++++     Stop Videos     +++++++++++ ");
	startButton2.setActionCommand("start2");
	startButton2.addActionListener(this);
	startButton2.setSize(300, 30);
	startButton2.setSize(300, 5);;
	
	
	
	
	
	LVido1PositionX = new JLabel("Position - X");
	LVido1PositionY = new JLabel("Position - Y");
	LVido1SizeX = new JLabel("Video Width");
	LVido1SizeY = new JLabel("Video High");
	LVido2PositionX = new JLabel("Position - X");
	LVido2PositionY = new JLabel("Position - Y");
	LVido2SizeX = new JLabel("Video Width");
	LVido2SizeY = new JLabel("Video High");
	LPlatzhalter = new JLabel("-");
	LPlatzhalter2 = new JLabel("-");
	
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
	
	
	Links.add(LVideo1);
	Links.add(LVido1PositionX);
	Links.add(TFVido1PositionX);	
	Links.add(LVido1PositionY);
	Links.add(TFVido1PositionY);	
	Links.add(LVido1SizeX);
	Links.add(TFVido1SizeX);
	Links.add(LVido1SizeY);
	Links.add(TFVido1SizeY);
	Links.add(LPlatzhalter);
	
	
	Rechts.add(LVideo2);	
	Rechts.add(LVido2PositionX);
	Rechts.add(TFVido2PositionX);	
	Rechts.add(LVido2PositionY);
	Rechts.add(TFVido2PositionY);
	Rechts.add(LVido2SizeX);
	Rechts.add(TFVido2SizeX);
	Rechts.add(LVido2SizeY);
	Rechts.add(TFVido2SizeY);
	Rechts.add(LPlatzhalter2);
	
	
	
	//add(Unten,BorderLayout.SOUTH);
	add(Links, BorderLayout.WEST);
	add(Rechts, BorderLayout.EAST);
	add(unten,BorderLayout.SOUTH);
	
	
	System.out.println("++++++++++++++++++++++++++++++++++   Start App  ++++++++++++++++++++++++++++"); 
	
	TT = new Timer(ONE_SECOND, new ActionListener() {
	    public void actionPerformed(ActionEvent evt) {
	    	System.out.println("Timer fertig nach 50 ms");
	    	
	    	mediaPlayerComponent1.mediaPlayer().controls().start();		
			mediaPlayerComponent2.mediaPlayer().controls().start();
	            TT.stop();
	            //...GUI aktualisieren...
	        
	    }    
	});
	
	
	
	
	
	StartVideo1();
	StartVideo2();
	
	

	}
	
	
	
	
	
	
public void actionPerformed(ActionEvent arg0) {
		
		// TODO Automatisch generierter Methodenstub	
		if (arg0.getSource() == startButton) {
			System.out.println("Play all Videos"); 
			
			
			StartVideo1();
			StartVideo2();
			
		}
		
		if (arg0.getSource() == startButton2) {
			System.out.println("Stop all Videos"); 
			
			
			StopVideo();
			
			
			
		}
	
}
	




	
	
	/**
	* Create the GUI and show it. As with all GUI code, this must run on the
	* event-dispatching thread.
	*/
	private static  void createAndShowGUI() {
	// Create and set up the window.
	JFrame frame = new JFrame("siOPTICA 2-Video Player");
	frame.setLayout(new FlowLayout());
	frame.setSize(600, 300);
	//frame.addKeyListener(this);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setLocation(100, 100);
	
	JComponent newContentPane = new Video();
	newContentPane.setOpaque(true); // content panes must be opaque
	frame.setContentPane(newContentPane);
	frame.setResizable(false);
	

	// Display the window.
	
	frame.setVisible(true);
	frame.toBack();
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
			   public void finished(MediaPlayer mediaPlayer2) {
				 System.out.println("Ende Video 2"); 
				 BVideoEnd2=true;
				
					//mediaPlayerComponent2.mediaPlayer().controls().stop();
				
				 checkPlay();
			   }
			
		};
		
		
		
		String video2;
		video2 =SHome + "\\videos\\siOvideo2.mp4";
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
public void StopVideo() {
	
	System.out.println("Stop Video 1 & 2"); 
	
	mediaPlayerComponent2.mediaPlayer().controls().stop();
	mediaPlayerComponent1.mediaPlayer().controls().stop();
	FrameVideo2.dispose();
	FrameVideo1.dispose();
	
	
}

public void checkPlay() {
	
	
		System.out.println("check play");
		System.out.println("BVideoEnd1 = " +BVideoEnd1.booleanValue());
		System.out.println("BVideoEnd2 = " +BVideoEnd2.booleanValue());
		
		if(BVideoEnd1.equals(true) && BVideoEnd2.equals(true))
		{
			System.out.println("Restart Video 1&2");
			//mediaPlayerComponent1.mediaPlayer().controls().start();		
			//mediaPlayerComponent2.mediaPlayer().controls().start();
			BVideoEnd1=false;
			BVideoEnd2=false;
			
			
			TT.start();
			 
			  
			
			
		}
		
		//BVideoEnd1=false;
		//BVideoEnd2=false;
	
	
	
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

	}
	
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

	
	
}




