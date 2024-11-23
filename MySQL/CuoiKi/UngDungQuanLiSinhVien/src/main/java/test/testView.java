package test;

import javax.swing.UIManager;

import View.TableView;

public class testView {
public static void main(String[] args) {
	try {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		new TableView();
	} catch (Exception e) {
		e.printStackTrace();
	}
}
}
