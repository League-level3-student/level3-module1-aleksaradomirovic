package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class HangMan implements KeyListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	JLabel label2 = new JLabel();
	String displayString, actualWord, letterList;
	ArrayList<Character> guessedLetters = new ArrayList<Character>();

	void reloadDisplay() {
		displayString = "";
		for (int i = 0; i < actualWord.length(); i++) {
			displayString += "_";
		}
		char[] r = displayString.toCharArray();
		for (int i = 0; i < guessedLetters.size(); i++) {
			for (int j = 0; j < actualWord.length(); j++) {
				if (actualWord.charAt(j) == guessedLetters.get(i)) {
					r[j] = guessedLetters.get(i);
				}
			}
		}
		displayString = "";
		for (int i = 0; i < r.length; i++) {
			displayString += r[i];
		}
		letterList = "";
		for (Character i : guessedLetters) {
			boolean has = false;
			for (int j = 0; j < r.length; j++) {
				if (r[j] == i)
					has = true;
			}
			if (!has) {
				letterList += i;
			}
		}

		label.setText(displayString);
		label2.setText(letterList);
		frame.pack();
	}

	void newWord() {
		frame.setVisible(false);
		actualWord = Utilities.readRandomLineFromFile("src/_04_HangMan/fred.txt");
		reloadDisplay();
		frame.setVisible(true);
	}

	public HangMan() {
		frame.add(panel);
		panel.add(label);
		panel.add(label2);
		frame.addKeyListener(this);
		label.setText(displayString);
	}

	void start() {
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		newWord();
	}

	public static void main(String[] args) {
		new HangMan().start();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (!guessedLetters.contains(e.getKeyChar())) {
			guessedLetters.add(e.getKeyChar());
			System.out.println("typed");
		}

		reloadDisplay();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}
