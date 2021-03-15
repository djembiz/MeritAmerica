package week5;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import acm.graphics.GCompound;
import acm.graphics.GLabel;
import acm.graphics.GObject;
import acm.graphics.GPoint;
import acm.graphics.GRect;
import acm.program.GraphicsProgram;

public class BoxDiagram extends GraphicsProgram {
	JTextField textField;
	JLabel name = new JLabel("Name");
	JButton add = new JButton("Add");
	JButton clear = new JButton("Clear");
	JButton remove = new JButton("Remove");
	GObject movingBox;
	GPoint oldPosition;
	HashMap<String, Object> boxList = new HashMap<String, Object>();
	private static final double BOX_WIDTH = 120;
	private static final double BOX_HEIGHT = 50;
	
	public void init() {
		textField = new JTextField(30);
		add(textField, SOUTH);
		textField.addActionListener(this);
		add(name, SOUTH);
		add(add, SOUTH);
		add(remove, SOUTH);
		add(clear, SOUTH);
		
		addActionListeners();
		addMouseListeners();
		
	}
	
	private void createBox(String name) {
		GCompound box = new GCompound();
		GRect outline = new GRect(BOX_WIDTH, BOX_HEIGHT);
		GLabel label = new GLabel(name);
		box.add(outline, -BOX_WIDTH / 2, -BOX_HEIGHT / 2);
		box.add(label);
		add(box, getWidth()/2, getHeight()/2);
		boxList.put(name, box);
		addMouseListener(this);
	}
	
	private void removeBox(String title) {
		JComponent box = (JComponent) boxList.get(title);
		remove(box);
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add || e.getSource() == textField){
			createBox(textField.getText());
		} else if (e.getSource() == remove) {
			removeBox(textField.getText());
		} else if (e.getSource() == clear) {
			removeAll();
		}
	}
	
	public void mousePressed(MouseEvent e) {
		oldPosition = new GPoint(e.getPoint());
		movingBox = getElementAt(oldPosition);
	}
	
	public void mouseDragged(MouseEvent e) {
			movingBox.move(e.getX() - oldPosition.getX(), e.getY() - oldPosition.getY());
			oldPosition = new GPoint(e.getPoint());
	}
}