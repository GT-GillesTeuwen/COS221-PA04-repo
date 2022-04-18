/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.up.cs.cos221.prac04;

import za.ac.up.cs.cos221.prac04.GUI.DatabaseSelect;

/**
 *
 * @author User
 */
public class main {
	public static void main(String[] args) {
		DatabaseSelect pane= new DatabaseSelect();
		pane.setLocationRelativeTo(null);
		pane.setVisible(true);
                System.out.println("done");
        }
}
