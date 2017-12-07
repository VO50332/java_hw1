package hw1_3;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;

/**
 * Main application class for exercise #1.
 * This application allows the user to add shapes to a graphical window and
 * to animate them.
 */
@SuppressWarnings("serial")
public class Animator extends JFrame implements ActionListener {

    // preferred frame width and height.
    private static final int WINDOW_WIDTH = 600;
    private static final int WINDOW_HEIGHT = 400;

    // graphical components
    private JMenuBar menuBar;
    private JMenu fileMenu, insertMenu, helpMenu;
    private JMenuItem newItem, exitItem,
                        triangleItem, ovalItem,
                        numberedOvalItem, sectorItem, aboutItem;
    private JCheckBoxMenuItem animationCheckItem;
    private JPanel mainPanel;
    private Point location;
    // shapes that have been added to this

    // TODO (BOM): Add and initialize a container of shapes called shapes.
    ArrayList<Shape> shapes = new ArrayList<>();
    
	private Shape newShape;
	Rectangle windowBound = new Rectangle(WINDOW_WIDTH,WINDOW_HEIGHT);
  
 

	public void stepAll() {
		Iterator<Shape> iter = shapes.iterator();
		while(iter.hasNext()) {
			newShape.step(windowBound);
		}
	}
	
	
	
    /**
     * @modifies this
     * @effects Initializes the GUI and enables a timer that steps animation
     *          of all shapes in this 25 times per second while animation
     *          checkbox is selected.
     */
    public Animator() {
        super("Animator");

        // create main panel and menubar
        mainPanel = (JPanel)createMainPanel();
        getContentPane().add(mainPanel);
        menuBar = (JMenuBar)createMenuBar();
        setJMenuBar(menuBar);
        location = mainPanel.getLocation();
        // enable animation timer (ticks 25 times per second)
        Timer timer = new Timer(40, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                if (animationCheckItem.isSelected()) {
                    // TODO (BOM): Add code for making one animation step for all
                    //       shapes in this
                	
                	
                	stepAll();

                		
                    repaint();  // make sure that the shapes are redrawn
                }
            }
        });
        timer.start();
    }


    /**
     * @return main GUI panel.
     */
    private JComponent createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(
                new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        mainPanel.setBorder(BorderFactory.createLoweredBevelBorder());
        mainPanel.setBackground(Color.WHITE);

        return mainPanel;
    }


    /**
     * @return main GUI menubar.
     */
    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        fileMenu = new JMenu("File");
        newItem = new JMenuItem("New");
        newItem.addActionListener(this);
        fileMenu.add(newItem);
        animationCheckItem = new JCheckBoxMenuItem("Animation");
        fileMenu.add(animationCheckItem);
        exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(this);
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        insertMenu = new JMenu("Insert");
        triangleItem = new JMenuItem("Triangle");
        triangleItem.addActionListener(this);
        insertMenu.add(triangleItem);
        ovalItem = new JMenuItem("Oval");
        ovalItem.addActionListener(this);
        insertMenu.add(ovalItem);
        numberedOvalItem = new JMenuItem("Numbered Oval");
        numberedOvalItem.addActionListener(this);
        insertMenu.add(numberedOvalItem);
        sectorItem = new JMenuItem("Sector");
        sectorItem.addActionListener(this);
        insertMenu.add(sectorItem);
        menuBar.add(insertMenu);

        helpMenu = new JMenu("Help");
        aboutItem = new JMenuItem("About");
        aboutItem.addActionListener(this);
        helpMenu.add(aboutItem);
        menuBar.add(helpMenu);

        return menuBar;
    }


    /**
     * @modifies g
     * @effects Paint this including all its shapes to g. This method is
     *          invoked by Swing to draw components. It should not be invoked
     *          directly, but the repaint method should be used instead in
     *          order to schedule the component for redrawing.
     */
    public void paint(Graphics g) {
    	Iterator<Shape> iter = shapes.iterator();
		while(iter.hasNext()) {		
			iter.next().draw(getContentPane().getGraphics());
			
		}
        //TODO (BOM): Add code for drawing all shapes in this
    }
    
    
    
    
    /**
     * @modifies this
     * @effects Invoked when the user selects an action from the menubar
     *          and performs the appropriate operation.
     */
    public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem)(e.getSource());

        // File->New : clear all shapes
        if (source.equals(newItem)) {
            shapes.clear();
            repaint();

            //TODO (BOM):  Add code for number of LocationChangingNumerOval = 0
        }

        // File->Exit: close application
        else if (source.equals(exitItem)) {
            dispose();
        }

        // Insert a shape
        else if ((source.equals(triangleItem)) ||
                 (source.equals(ovalItem)) ||
                 (source.equals(numberedOvalItem)) ||
                 (source.equals(sectorItem))) {
        	//Point location = new Point((int)Math.random()*WINDOW_WIDTH,(int)Math.random()*WINDOW_HEIGHT);
            int red = (int)Math.random()*256;
            int green = (int)Math.random()*256;
            int blue = (int)Math.random()*256;
            Color color = new Color(red,green,blue);
            int randomWidth = (int)Math.random(); 
            int width = randomWidth*WINDOW_WIDTH*2/10+WINDOW_WIDTH/10;
            int randomHeight = (int)Math.random(); 
            int height = randomHeight*WINDOW_HEIGHT*2/10+WINDOW_HEIGHT/10;
            int y = (int) ( -(WINDOW_HEIGHT - height)*Math.random() + location.getY());
            int x = (int) ( (WINDOW_WIDTH - width)*Math.random() + location.getX());
            int startAngle = (int) (Math.random()*2 -1 ) * 359;
            int arcAngle = (int) (Math.random() ) * 359;
            Point shapeLocation = new Point(x,y);
            
        	if (source.equals(triangleItem)) {
        		LocationAndColorChangingTriangle newShape = new LocationAndColorChangingTriangle(shapeLocation, color,width,height);
        	 	shapes.add(newShape);
        		
        	}
        	if(source.equals(sectorItem)) {
        		AngleChangingSector newShape = new AngleChangingSector(shapeLocation, color,width,height,startAngle,arcAngle);
        	 	shapes.add(newShape);
        	}
        	if(source.equals(numberedOvalItem)) {
        		LocationChangingNumberedOval newShape = new LocationChangingNumberedOval(shapeLocation, color,width,height); 
        	 	shapes.add(newShape);
        	}
        	if(source.equals(ovalItem)) {
        		Shape newShape = new LocationChangingOval( shapeLocation, color,width,height);
        	 	shapes.add(newShape);
        	}
       
            // TODO (BOM): Add code for creating the appropriate shape such that:
            //       it is completely inside the window's bounds &&
            //       its location, size and color are randomly selected &&
            //       1/10*WINDOW_WIDTH <= shape.width < 3/10*WINDOW_WIDTH &&
            //       1/10*WINDOW_HEIGHT <= shape.height < 3/10*WINDOW_HEIGHT
        	

            repaint();
        }

        // Help->About : show about message dialog
        else if (source.equals(aboutItem)){
            JOptionPane.showMessageDialog(
                    this,
                    "Animator - 1st" +
                    " homework assignment",
                    "About",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }


    /**
     * @effects Animator application.
     */
    public static void main(String[] args) {
        Animator application = new Animator();

        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setResizable(false);
        application.pack();
        application.setVisible(true);
    }
}