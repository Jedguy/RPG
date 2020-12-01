package fr.doreau;

import java.util.Random;

public class Characters {
	protected static final int LVL1_MAX_HP = 80;
	protected static final int LVL1_MAX_MANA = 35;

	protected static final int LVL1_ATK_STAT = 7;
	protected static final int LVL1_DEF_STAT = 4;
	protected static final int LVL1_MAG_STAT = 4;
	protected static final int LVL1_MDF_STAT = 4;

	protected static final int BASE_LVL_UP_EXP = 80;
	protected static final int[] statsLevelUpMin = { 8, 1, 2, 2, 0, 0 };
	protected static final int[] statsLevelUpMax = { 12, 2, 4, 4, 1, 1 };

	protected String name;

	protected int exp;
	protected int level;

	protected int maxHPStat;
	protected int maxManaStat;

	protected int attackStat;
	protected int defenseStat;

	protected int magicStat;
	protected int magicDefStat;

	protected int currentHP;
	protected int currentMana;

	protected boolean isAlive;

	protected boolean isGuarding;

	protected boolean dagged;

	public Characters(String p_name) {
		this.name = p_name;

		this.maxHPStat = LVL1_MAX_HP;
		this.currentHP = this.maxHPStat;

		this.maxManaStat = LVL1_MAX_MANA;
		this.currentMana = this.maxManaStat;

		this.attackStat = LVL1_ATK_STAT;
		this.defenseStat = LVL1_DEF_STAT;
		this.magicStat = LVL1_MAG_STAT;
		this.magicDefStat = LVL1_MDF_STAT;

		this.isAlive = true;

		this.level = 1;
		this.exp = 0;

		this.gainExp(2000000);
	}

	public int nombreAleatoire(int min, int max) {
		Random r = new Random();
		return r.nextInt((max + 1) - min) + min;
	}

	public int getExpToNextLevel() {
		return (int) (BASE_LVL_UP_EXP * Math.pow(1.1, level));
	}

	public void gainExp(int amount) {
		exp += amount;
		while (exp > getExpToNextLevel()) {
			exp -= getExpToNextLevel();
			levelUp();
			System.out.println(getExpToNextLevel());
		}
	}

	public void levelUp() {
		level++;
		int hpGain = nombreAleatoire(statsLevelUpMin[0], statsLevelUpMax[0]);
		int mpGain = nombreAleatoire(statsLevelUpMin[1], statsLevelUpMax[1]);
		maxHPStat += hpGain;
		maxManaStat += mpGain;
		attackStat += nombreAleatoire(statsLevelUpMin[2], statsLevelUpMax[2]);
		defenseStat += nombreAleatoire(statsLevelUpMin[3], statsLevelUpMax[3]);
		magicStat += nombreAleatoire(statsLevelUpMin[4], statsLevelUpMax[4]);
		magicDefStat += nombreAleatoire(statsLevelUpMin[5], statsLevelUpMax[5]);

		currentHP += hpGain;
		currentMana += mpGain;
	}

	public int getLevel() {
		return level;
	}

	public String getName() {
		return name;
	}

	public int getMaxHPStat() {
		return maxHPStat;
	}

	public int getMaxManaStat() {
		return maxManaStat;
	}

	public int getAttackStat() {
		return attackStat;
	}

	public int getDefenseStat() {
		return defenseStat;
	}

	public int getMagicStat() {
		return magicStat;
	}

	public int getMagicDefenseStat() {
		return magicDefStat;
	}

	public int getCurrentHP() {
		return currentHP;
	}

	public int getCurrentMana() {
		return currentMana;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public boolean isGuarding() {
			return isGuarding;
	}
	
	public void guard() {
        isGuarding = true;
    }

	public void attack(Characters enemy) {
        int actualDefense = enemy.isGuarding() ? enemy.getDefenseStat() * 2 : enemy.getDefenseStat();
        int damage = (int) (100 * ((double) attackStat / (double) (actualDefense + 100)));
        enemy.takeDamage(damage);
    }


    public void takeDamage(int amount) {

        currentHP -= amount;
        if (currentHP <= 0) {
            currentHP = 0;
            isAlive = false;
        }
        System.out.println("ouch ! " + getName() + " : " + currentHP + "/" + maxHPStat);
    }

	public String toString() {
		String result = getClassName() + " " + name + " => ";
		result += "HP : " + currentHP + "/" + maxHPStat + " | ";
		result += "MP : " + currentMana + "/" + maxManaStat + " | ";
		result += "ATK : " + attackStat + " | ";
		result += "DEF : " + defenseStat + " | ";
		result += "MAG : " + magicStat + " | ";
		result += "MDF : " + magicDefStat + " | ";

		return result;
	}

	public String getClassName() {
		return "Characters";
	}
}
