package fr.doreau;

public class Assassin extends Characters{
	protected static final int LVL1_MAX_HP = 80;
	protected static final int LVL1_MAX_MANA = 35;

	protected static final int LVL1_ATK_STAT = 7;
	protected static final int LVL1_DEF_STAT = 4;
	protected static final int LVL1_MAG_STAT = 4;
	protected static final int LVL1_MDF_STAT = 4;

	protected static final int BASE_LVL_UP_EXP = 80;
	protected static final int[] statsLevelUpMin = { 8, 1, 2, 2, 0, 0 };
	protected static final int[] statsLevelUpMax = { 12, 2, 4, 4, 1, 1 };
	
	protected static boolean isdagger;

	
	public Assassin(String p_name) {
		super(p_name);
	}

	public void guard() {
		isGuarding = true;
	}
	
	public boolean isdagger() {
		return isdagger;
	}
	
	public static void dagged() {
		isdagger = true;
	}
	
	public void Damage(int amount) {
		
	}


	public String getClassName() {
		return "Assassin";
	}
}