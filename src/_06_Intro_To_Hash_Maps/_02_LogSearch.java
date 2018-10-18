package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch {
	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons. Button 1: Add Entry When this button is clicked, use
	 * an input dialog to ask the user to enter an ID number. After an ID is
	 * entered, use another input dialog to ask the user to enter a name. Add this
	 * information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 *
	 */
	HashMap<Integer, String> ids = new HashMap<Integer, String>();

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();

	JButton b1 = new JButton("ADD ID");
	JButton b2 = new JButton("SEARCH");
	JButton b3 = new JButton("DISPLAY ALL");
	JButton b4 = new JButton("REMOVE");

	static int maxValue = 0;

	void setup() {
		frame.add(panel);

		b1.addActionListener(new Add());
		b3.addActionListener(new ShowAll());
		b2.addActionListener(new Search());
		b4.addActionListener(new Delete());

		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);

		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new _02_LogSearch().setup();
	}

	class Add implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int key = Integer.parseInt(JOptionPane.showInputDialog("ID NUMBER"));
			ids.put(key, JOptionPane.showInputDialog("Name"));
			if (key > maxValue)
				maxValue = key + 1;
		}
	}

	class Search implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int i = Integer.parseInt(JOptionPane.showInputDialog("Search ID Number: "));

			if (ids.get(i) != null) {
				JOptionPane.showMessageDialog(null, "ID: " + i + " | Name: " + ids.get(i) + "\n");
			} else {
				JOptionPane.showMessageDialog(null, "No such id");
			}
		}
	}

	class ShowAll implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String r = "";
			String add;
			for (int i = 0; i < maxValue; i++) {
				if ((add = ids.get(i)) != null) {
					r += "ID: " + i + " | Name: " + add + "\n";
				}
				System.out.println(i);
			}

			JOptionPane.showMessageDialog(null, r);
		}
	}

	class Delete implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			int i = Integer.parseInt(JOptionPane.showInputDialog("ID to Delete: "));

			if (ids.get(i) != null) {
				ids.remove(i);
				JOptionPane.showMessageDialog(null, "Deleted ID at " + i);
			} else {
				JOptionPane.showMessageDialog(null, "No such id");
			}
		}

	}
}
