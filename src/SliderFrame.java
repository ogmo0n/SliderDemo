// Fig. 22.3: SliderFrame.java
// Using JSliders to size an oval.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class SliderFrame extends JFrame
{
   private final JSlider diameterJSlider; // slider to select diameter
   private OvalPanel myPanel; // panel to draw circle
   private RectPanel myPanel2;
   
   // new idea with loops/array
   private static final String[] colors = 
 	  {"Red", "Blue", "Green"};
   private final JRadioButton[] lButtons;
   private final JRadioButton[] rButtons;
   private final JRadioButton square;
   private final JRadioButton circle;

   // no-argument constructor
   public SliderFrame() 
   {
      super("Slider Demo");

      myPanel = new OvalPanel(); // create panel to draw circle
      myPanel.setBackground(Color.YELLOW); 

      // set up JSlider to control diameter value
      diameterJSlider = 
         new JSlider(SwingConstants.HORIZONTAL, 0, 200, 10);
      diameterJSlider.setMajorTickSpacing(10); // create tick every 10
      diameterJSlider.setPaintTicks(true); // paint ticks on slider

      // register JSlider event listener
      diameterJSlider.addChangeListener(
         new ChangeListener() // anonymous inner class
         {  
            // handle change in slider value
            @Override
            public void stateChanged(ChangeEvent e)
            {
               myPanel.setDiameter(diameterJSlider.getValue());
            } 
         } 
      ); 
      // add shape radio buttons
      square = new JRadioButton("  Square  ");
      circle = new JRadioButton("  Circle  ");
      JRadioButton empty1 = new JRadioButton("Empty");
      empty1.setVisible(false);
      JRadioButton empty2 = new JRadioButton("Empty");
      empty2.setVisible(false);
      ButtonGroup shapeGroup = new ButtonGroup();
      JPanel shapePanel = new JPanel(new GridLayout(1, 4));
      shapeGroup.add(empty1);
      shapeGroup.add(square);
      shapeGroup.add(circle);
      shapeGroup.add(empty2);
      shapePanel.add(empty1);
      shapePanel.add(square);
      shapePanel.add(circle);
      shapePanel.add(empty2);
      ItemListener shaper = new ItemListener() {
    	  @Override
    	  public void itemStateChanged(ItemEvent e) {
    	// if square
    		  if (square.isSelected()) {
    			  myPanel2 = new RectPanel();
    			  // get then set background color
    			  if (myPanel.getBackground() == Color.YELLOW) {
    				  myPanel2.setBackground(Color.YELLOW);
    			  } else if (myPanel.getBackground() == Color.RED) {
    				  myPanel2.setBackground(Color.RED);
    			  } else if (myPanel.getBackground() == Color.BLUE) {
    				  myPanel2.setBackground(Color.BLUE);
    			  } else if (myPanel.getBackground() == Color.GREEN) {
    				  myPanel2.setBackground(Color.GREEN);
    			  }
    			  // get then set foreground color
    			  if (myPanel.getForeground() == Color.RED) {
    				  myPanel2.setForeground(Color.RED);
    			  } else if (myPanel.getForeground() == Color.BLUE) {
    				  myPanel2.setForeground(Color.BLUE);
    			  } else if (myPanel.getForeground() == Color.GREEN) {
    				  myPanel2.setForeground(Color.GREEN);
    			  } else {
    				  myPanel2.setForeground(Color.BLACK);
    			  }
    			  myPanel.setVisible(false);
    			  add(myPanel2, BorderLayout.CENTER);
    	// if circle
    		  } else if (circle.isSelected()) {
    			  myPanel = new OvalPanel();
    			  // get then set background color
    			  if (myPanel2.getBackground() == Color.YELLOW) {
    				  myPanel.setBackground(Color.YELLOW);
    			  } else if (myPanel2.getBackground() == Color.RED) {
    				  myPanel.setBackground(Color.RED);
    			  } else if (myPanel2.getBackground() == Color.BLUE) {
    				  myPanel.setBackground(Color.BLUE);
    			  } else if (myPanel2.getBackground() == Color.GREEN) {
    				  myPanel.setBackground(Color.GREEN);
    			  }
    			  // get then set foreground color
    			  if (myPanel2.getForeground() == Color.RED) {
    				  myPanel.setForeground(Color.RED);
    			  } else if (myPanel2.getForeground() == Color.BLUE) {
    				  myPanel.setForeground(Color.BLUE);
    			  } else if (myPanel2.getForeground() == Color.GREEN) {
    				  myPanel.setForeground(Color.GREEN);
    			  } else {
    				  myPanel.setForeground(Color.BLACK);
    			  }
    			  myPanel2.setVisible(false);
    			  add(myPanel, BorderLayout.CENTER);
    		  }
    	  }
      };
      // add listeners
      square.addItemListener(shaper);
      circle.addItemListener(shaper);
      
      // background color buttons
      lButtons = new JRadioButton[colors.length];
      ButtonGroup bgGroup = new ButtonGroup();
      JPanel bgPanel = new JPanel(new GridLayout(4, 1));
      JLabel bgLabel = new JLabel(" Background ");
      bgPanel.add(bgLabel);
      // foreground color buttons
      rButtons = new JRadioButton[colors.length];
      ButtonGroup fgGroup = new ButtonGroup();
      JPanel fgPanel = new JPanel(new GridLayout(4, 1));
      JLabel fgLabel = new JLabel(" Foreground ");
      fgPanel.add(fgLabel);
      // loop to add buttons to groups and panels
      for (int i = 0; i < colors.length; i++) {
    	  lButtons[i] = new JRadioButton(colors[i]);
    	  bgGroup.add(lButtons[i]);
    	  bgPanel.add(lButtons[i]);
    	  rButtons[i] = new JRadioButton(colors[i]);
    	  fgGroup.add(rButtons[i]);
    	  fgPanel.add(rButtons[i]);
      } 
      ItemListener listener = new ItemListener() {
    	  @Override
    	  public void itemStateChanged(ItemEvent e) {
    		  // background
    		  if (e.getSource() == lButtons[0]) {
    			  if (square.isSelected()) {
    				  myPanel2.setBackground(Color.RED); 
    			  } else {
    				  myPanel.setBackground(Color.RED);
    			  }
    		  }
    		  if (e.getSource() == lButtons[1]) {
    			  if (square.isSelected()) {
    				  myPanel2.setBackground(Color.BLUE); 
    			  } else {
    				  myPanel.setBackground(Color.BLUE);
    			  }
    		  }
    		  if (e.getSource() == lButtons[2]) {
    			  if (square.isSelected()) {
    				  myPanel2.setBackground(Color.GREEN); 
    			  } else {
    				  myPanel.setBackground(Color.GREEN);
    			  }
    		  }
    		  // foreground
    		  if (e.getSource() == rButtons[0]) {
    			  if (square.isSelected()) {
    				  myPanel2.setForeground(Color.RED); 
    			  } else {
    				  myPanel.setForeground(Color.RED);
    			  }
    		  }
    		  if (e.getSource() == rButtons[1]) {
    			  if (square.isSelected()) {
    				  myPanel2.setForeground(Color.BLUE); 
    			  } else {
    				  myPanel.setForeground(Color.BLUE);
    			  }
    		  }
    		  if (e.getSource() == rButtons[2]) {
    			  if (square.isSelected()) {
    				  myPanel2.setForeground(Color.GREEN); 
    			  } else {
    				  myPanel.setForeground(Color.GREEN);
    			  }
    		  }
    	  }
      };
      // loop to add listeners
      for (int i = 0; i < colors.length; i++) {
    	  lButtons[i].addItemListener(listener);
    	  rButtons[i].addItemListener(listener);
      }
      
      // add panels and slider
      add(shapePanel, BorderLayout.NORTH);
      add(bgPanel, BorderLayout.WEST);
      add(fgPanel, BorderLayout.EAST);
      add(diameterJSlider, BorderLayout.SOUTH); 
      add(myPanel, BorderLayout.CENTER); // default panel
      
   } // end SliderFrame constructor
   
} // end class SliderFrame