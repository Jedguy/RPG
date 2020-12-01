/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.doreau;

import java.util.Scanner;



/**
 *
 * @author sogeking
 */
public class Fight {

    protected Party party;
    protected Party foes;

    protected boolean ended;
    protected boolean hasPartyWon;

    protected static String menuMsg = "Que doit faire # ?\n1-Attaque\n2-Comp�tence\n3-Objet\n4-Garde";
    protected static String skillMsg = "Qu'elle comp�tence utilis�e ?\n1-Dague maitris�\n2-Brouillard";
    protected static String targetMsg = "Sur quelle cible ?";
    protected static String victoryMsg = "Victoire ! GGs boyz";
    protected static String defeatMsg = "D�faite ! L'�quipe a �t� �radiqu�e, le monde est condamn� � la nuit !";

    public Fight() {
        party = new Party(0);
        foes = new Party(1);

        ended = false;
        hasPartyWon = false;
    }

    public void start() {
        while (!ended) {
            playerTurn();
            enemyTurn();
        }
        if (hasPartyWon) {
            System.out.println(victoryMsg);
        } else {
            System.out.println(defeatMsg);
        }
    }

    protected void playerTurn() {
        for (Assassin character : party.getAliveCharacters()) {
            displayFightState();
            playerAction(character);
            checkFightEnded();
            waitForText();

            if (ended) {
                return;
            }
        }
    }

    protected void enemyTurn() {
        for (Assassin enemy : foes.getAliveCharacters()) {
            displayFightState();
            enemyAction(enemy);
            checkFightEnded();
            waitForText();

            if (ended) {
                return;
            }
        }
    }

    protected void playerAction(Characters character) {
        displayMenuMsg(character.getName());
        //character.attackdagged(party.getAliveCharacter(0));
        int mainAction = pickMainMenuAction();

        Assassin target;
        switch (mainAction) {
            case 1:
                // Attack
                displayTargetMsg();
                target = pickTarget();
                character.attack(target);
                break;
            case 2:
                // TODO : Skill
            	Assassin.dagged();;
            	break;
            case 3:
                // TODO : Object
                break;
            case 4:
                // Guard
                character.guard();
                break;

        }
    }

    protected int pickMainMenuAction() {
        Scanner in = new Scanner(System.in);

        int result = -1;
        while (result == -1) {
            try {
                String action = in.nextLine();
                int tmp = Integer.parseInt(action);
                if (tmp < 1 || tmp > 4) {
                    throw new NumberFormatException();
                }
                result = tmp;
            } catch (NumberFormatException e) {
                System.out.println("Entr�e invalide");
            }
        }
        return result;
    }

    protected Assassin pickTarget() {
        Scanner in = new Scanner(System.in);

        int result = -1;
        while (result == -1) {
            try {
                String action = in.nextLine();
                int tmp = Integer.parseInt(action);
                if (tmp < 1 || tmp > party.getAliveCharactersSize() + foes.getAliveCharactersSize()) {
                    throw new NumberFormatException();
                }
                result = tmp;
            } catch (NumberFormatException e) {
                System.out.println("Entr�e invalide");
            }
        }

        if (result <= foes.getAliveCharactersSize()) {
            return foes.getAliveCharacter(result - 1);
        } else {
            return party.getAliveCharacter(result - 1 - foes.getAliveCharactersSize());
        }
    }

    private void enemyAction(Assassin enemy) {
        enemy.attack(party.getAliveCharacter(0));
    }
    
    

    protected void displayFightState() {
        System.out.println("Personnages : \n");
        for (Assassin character : party.getCharacters()) {
            System.out.println(character.toString());
        }
        System.out.println("\nEnnemis : \n");
        for (Assassin enemy : foes.getCharacters()) {
            System.out.println(enemy.toString());
        }
        System.out.println("");
    }

    protected void displayMenuMsg(String name) {
        System.out.println(menuMsg.replace("#", name));
    }
    
    protected void displaySkillMsg(String name) {
        System.out.println(skillMsg.replace("#", name));
    }

    protected void displayTargetMsg() {
        System.out.println(targetMsg);
        int index = 1;
        for (Assassin enemy : foes.getAliveCharacters()) {
            System.out.println(index + "- " + enemy.getName());
            index++;
        }
        for (Assassin character : party.getAliveCharacters()) {
            System.out.println(index + "- " + character.getName());
            index++;
        }
    }

    private void checkFightEnded() {
        if (party.areAllDead()) {
            ended = true;
        } else if (foes.areAllDead()) {
            ended = true;
            hasPartyWon = true;
        }
    }

    private void waitForText() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {

        }
    }
}