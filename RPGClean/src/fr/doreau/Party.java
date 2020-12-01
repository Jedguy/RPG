/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doreau;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author sogeking
 */
public class Party {
    protected List<Assassin> characters;
    
    public Party(int formation) {
        characters = new ArrayList<Assassin>();
        
        switch (formation) {
            case 0:
                characters.add(new Assassin("Wigfried"));
                characters.add(new Assassin("Gonzague"));
                characters.add(new Assassin("Enguerrand"));
                characters.add(new Assassin("Norbert"));
                break;
            case 1:
                characters.add(new Assassin("Jean-Bâtard"));
                characters.add(new Assassin("Jean-Craqué"));
                break;
        }
    }
    
    public List<Assassin> getCharacters() {
        return characters;
    }
    
    public Assassin getCharacter(int index) {
        return characters.get(index);
    }
    
    public Assassin getAliveCharacter(int index) {
        return getAliveCharacters().get(index);        
    }
    
    public List<Assassin> getAliveCharacters() {
        List<Assassin> aliveCharacters = new ArrayList<Assassin>();
        for (Assassin character : characters) {
            if (character.isAlive()) {
                aliveCharacters.add(character);
            }
        }
        return aliveCharacters;
    }
    
    public int getAliveCharactersSize() {
        return getAliveCharacters().size();
    }

    public boolean areAllDead() {
        return getAliveCharactersSize() == 0;
    }
}