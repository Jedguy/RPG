package fr.doreau;


/**
 *
 * @author sogeking
 */
public class Warrior extends Characters {

    protected static final int LVL1_MAX_HP = 100;
    protected static final int LVL1_MAX_MANA = 20;

    protected static final int LVL1_ATK_STAT = 5;
    protected static final int LVL1_DEF_STAT = 5;
    protected static final int LVL1_MAG_STAT = 2;
    protected static final int LVL1_MDF_STAT = 2;

    protected static final int BASE_LVL_UP_EXP = 80;
    protected static final int[] statsLevelUpMin = {8, 1, 2, 2, 0, 0};
    protected static final int[] statsLevelUpMax = {12, 2, 4, 4, 1, 1};


    public Warrior(String p_name) {
        super(p_name);
    }

    public String getClassName() {
        return "Warrior";
    }
}
