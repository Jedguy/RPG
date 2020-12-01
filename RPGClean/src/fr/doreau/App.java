  
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doreau;

/**
 *
 * @author sogeking
 */
public class App {  
    protected static Fight fight;

    public static void main(String args[]) {
        fight = new Fight();
        fight.start();
    }
}