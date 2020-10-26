
import java.awt.event.ActionListener.*;
import acm.graphics.*;
import acm.program.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;

public class MakeBoxDiagram extends GraphicsProgram {
	private HashMap<String, GObject> stuff;
	private JTextField nameField;
	private JButton addButton;
	private JButton removeButton;
	private JButton clearButton;
	private String MAX_NAME;
	private double BOX_WIDTH;
	private double BOX_HEIGHT;
	private GPoint last;
	private GObject currentObject;

	/* Initializes the program */
	public void init() {
		stuff = new HashMap<String, GObject>();
		createController();
		addActionListeners();
		addMouseListeners();
	}

	/* Creates the control strip at the bottom of the window */
	private void createController() {
		nameField = new JTextField(MAX_NAME);
		nameField.addActionListener(this);
		addButton = new JButton("Add");
		removeButton = new JButton("Remove");
		clearButton = new JButton("Clear");
		add(new JLabel("Name"), SOUTH);
		add(nameField, SOUTH);
		add(addButton, SOUTH);
		add(removeButton, SOUTH);
		add(clearButton, SOUTH);
	}

	/* Adds a box with the given name at the center of the window */
	private void addBox(String name) {
		GCompound box = new GCompound();
		GRect outline = new GRect(BOX_WIDTH, BOX_HEIGHT);
		GLabel label = new GLabel(name);
		box.add(outline, -BOX_WIDTH / 2, -BOX_HEIGHT / 2);
		box.add(label, -label.getWidth() / 2, label.getAscent() / 2);
		add(box, getWidth() / 2, getHeight() / 2);
		stuff.put(name, box);
	}

	/* Removes the box with the given name */
	private void removeBox(String name) {
		GObject obj = stuff.get(name);
		if (obj != null) {
			remove(obj);
		}
	}



	private void removeContents() {
		Iterator<String> iterator = stuff.keySet().iterator();
		while (iterator.hasNext()) {
			removeBox(iterator.next());
		}
		stuff.clear(); // Clear all entries in the hashmap
	}

	/* Called in response to button actions */
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source == addButton || source == nameField) {
			addBox(nameField.getText());
		} else if (source == removeButton) {
			removeBox(nameField.getText());
		} else if (source == clearButton) {
			removeContents();
		}
	}

	/* Called on mouse press to record the coordinates of the click */
	public void mousePressed(MouseEvent e) {
		last = new GPoint(e.getPoint());
		currentObject = getElementAt(last);
	}

	/* Called on mouse drag to reposition the object */
	public void mouseDragged(MouseEvent e) {
		if (currentObject != null) {
			currentObject.move(e.getX() - last.getX(), e.getY() - last.getY());
			last = new GPoint(e.getPoint());
		}

	}

	/* Called on mouse click to move this object to the front */
	public void mouseClicked(MouseEvent e) {
		if (currentObject != null)
			currentObject.sendToFront();
}
}