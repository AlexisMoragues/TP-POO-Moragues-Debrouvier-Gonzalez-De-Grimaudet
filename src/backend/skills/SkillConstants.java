package backend.skills;


public interface SkillConstants{
	
	
	/*
	 * MageSkills
	 */
	
	/**
	 * FireMageSkills
	 */
	public static final int CLEANSE_DAMAGE  = 5;
	public static final int CLEANSE_RANGE = 6;
	public static final int CLEANSE_CHARGES = 2;
	public static final String CLEANSE_DESCRIPTION="Does " + CLEANSE_DAMAGE + " damage to an ally Unit and remove all his buffs \"Cleanse it! Cleanse it with fire!\" ";
	
	
	public static final int FIREBOMB_DAMAGE = 10;
	public static final double FIREBOMB_ATTACK_MODIFIER  = 0.9;
	public static final int FIREBOMB_RANGE = 6;
	public static final int FIREBOMB_CHARGES = 2;
	public static final String FIREBOMB_DESCRIPTION="Does "  + FIREBOMB_DAMAGE + " damage in a small area and decrease enemy damage by " + FIREBOMB_ATTACK_MODIFIER+ ".";
	
	public static final int WILDFIRE_DAMAGE  = 15;
	public static final int WILDFIRE_LENGTH = 8;
	public static final int WILDFIRE_RANGE = 1;
	public static final int WILDFIRE_CHARGES = 2;
	public static final String WILDFIRE_DESCRIPTION="Does "  + WILDFIRE_DAMAGE + " damage in a long straight line.";
	
	/**
	 * IceMageSkills
	 */
	public static final int BLIZZARD_DAMAGE  = 10;
	public static final int BLIZZARD_MOVEMENT_MODIFIER  = -1;
	public static final int BLIZZARD_RANGE = 6;
	public static final int BLIZZARD_CHARGES = 2;
	public static final int BLIZZARD_HEIGTH  = 1;
	public static final int BLIZZARD_WIDTH= 2;
	public static final String BLIZZARD_DESCRIPTION="Does " + BLIZZARD_DAMAGE + " damage in a big area and lowers movement.";
	
	public static final int EISKLINGE_DIMENSION = 3;
	public static final int EISKLINGE_DAMAGE  = 65;
	public static final int EISKLINGE_CHARGES = 1;
	public static final String EISKLINGE_DESCRIPTION="Does " + EISKLINGE_DAMAGE + " damage to close enemies.";
	
	public static final double ICEARMOR_ARMORMODIFIER  = 0.8;
	public static final int ICEARMOR_DIMENSION = 1;
	public static final int ICEARMOR_RANGE = 4;
	public static final int ICEARMOR_CHARGES = 2;
	public static final String ICEARMOR_DESCRIPTION = "Increases Damage Resistance by " + ICEARMOR_ARMORMODIFIER + " to all units in a small area.";
	
	/**
	 * ArcaneMageSkills
	 */
	
	public static final int ANCESTRAL_HEALING_CHARGES = 3;
	public static final int ANCESTRAL_HEALING_HEALING = 15;
	public static final double ANCESTRAL_HEALING_DMG_RECEIVED_MODIFIER = 0.9;
	public static final String ANCESTRAL_HEALING_DESCRIPTION ="Heal all team for " + ANCESTRAL_HEALING_HEALING + "hp and decrease slightly damage received.";
	
	public static final double SONG_OF_THE_ANCESTORS_ATTACKBUFF = 1.3;
	public static final int SONG_OF_THE_ANCESTORS_MOVEMENTBUFF = 1;
	public static final double SONG_OF_THE_ANCESTORS_ATTACKDEBUFF = 0.6;
	public static final int SONG_OF_THE_ANCESTORS_MOVEMENTDEBUFF = -2;
	public static final int SONG_OF_THE_ANCESTORS_RANGE = 5;
	public static final int SONG_OF_THE_ANCESTORS_CHARGES = 2;
	public static final String SONG_OF_THE_ANCESTORS_DESCRIPTION="Increase movement and damage to target Ally or decrease it to an enemy.";
	
	public static final int STRAFFE_GOTTES_DAMAGE = 50;
	public static final int STRAFFE_GOTTES_LENGHT = 4;
	public static final int STRAFFE_GOTTES_RANGE = 1;
	public static final int STRAFFE_GOTTES_CHARGES = 1;
	public static final String STRAFFE_GOTTES_DESCRIPTION="Deals " + STRAFFE_GOTTES_DAMAGE + " damage in a cone, hurting allys and enemys \" It Straffes and then it Gottes.\"";
	
	/*
	 * RangerSkills
	 */
	
	public static final double MORAL_CONQUEST_ALLY_ATTACKMODIFIER = 1.2;
	public static final double MORAL_CONQUEST_ENEMY_ATTACKMODIFIER = 0.7;
	public static final int MORAL_CONQUEST_DAMAGE = 15;
	public static final int MORAL_CONQUEST_DIMENSION = 2;
	public static final int MORAL_CONQUEST_RANGE = 7;
	public static final int MORAL_CONQUEST_CHARGES = 3;
	public static final String MORAL_CONQUEST_DESCRIPTION = "Reduces damage in a small area to enemys by " + MORAL_CONQUEST_ENEMY_ATTACKMODIFIER + " and increases damage in allys by " + MORAL_CONQUEST_ALLY_ATTACKMODIFIER + " while dealing " + MORAL_CONQUEST_DAMAGE + " damage in the center" ;
	
	public static final double 	PIERCING_JAVELIN_DEFENCEMODIFIER =  1.2;
	public static final double 	PIERCING_JAVELIN_ATTACKMODIFIER =  0.8;
	public static final int	PIERCING_JAVELIN_MOVEMENTMODIFIER =  -1;
	public static final int PIERCING_JAVELIN_LENGTH = 10;
	public static final int PIERCING_JAVELIN_DAMAGE = 15;
	public static final int PIERCING_JAVELIN_RANGE = 1;
	public static final int PIERCING_JAVELIN_CHARGES = 4;
	public static final String PIERCING_JAVELIN_DESCRIPTION = "Damages enemys by " + PIERCING_JAVELIN_DAMAGE + " in a straight line also reducing defence by " + PIERCING_JAVELIN_DEFENCEMODIFIER  ;
	
	public static final int SEEK_AND_DESTROY_CHARGES = 2;
	public static final double SEEK_AND_DESTROY_ATTACKMODIFIER = 1.4;
	public static final int SEEK_AND_DESTROY_MOVEMENTMODIFIER = 2;
	public static final String SEEK_AND_DESTROY_DESCRIPTION = "Drastically reduces your movement by " + SEEK_AND_DESTROY_MOVEMENTMODIFIER + " and increases your attack by " + SEEK_AND_DESTROY_ATTACKMODIFIER  ;  
	
	public static final int ARROW_TO_THE_KNEE_DAMAGE = 20;
	public static final int ARROW_TO_THE_KNEE_MOVEMENT_MODIFIER = -2;
	public static final int ARROW_TO_THE_KNEE_RANGE = 5;
	public static final int ARROW_TO_THE_KNEE_CHARGES = 3;
	public static final String ARROW_TO_THE_KNEE_DESCRIPTION = "Damages for " + ARROW_TO_THE_KNEE_DAMAGE + " and Slows former adventurers movement by " + ARROW_TO_THE_KNEE_MOVEMENT_MODIFIER;

	public static final int HEALING_ELF_ROOT_HEAL = 30;
	public static final int HEALING_ELF_ROOT_MAXHEALTH_INCREASE = 15;
	public static final int HEALING_ELF_ROOT_RANGE = 1;
	public static final int HEALING_ELF_ROOT_CHARGES = 3;
	public static final String HEALING_ELF_ROOT_DESCRIPTION ="Heals an ally for "+ HEALING_ELF_ROOT_HEAL +" Health, and increases maxHealth by " + HEALING_ELF_ROOT_MAXHEALTH_INCREASE + ".PRAISE ELF ROOT";
	
	public static final double SAND_ATTACK_ATTACK_MODIFIER = 0.35;
	public static final int SAND_ATTACK_RANGE = 1;
	public static final int SAND_ATTACK_CHARGES = 2;
	public static final String SAND_ATTACK_DESCRIPTION ="Drastically Lowers enemy's damage by " + SAND_ATTACK_ATTACK_MODIFIER + ". It's only dirty if you get caught";
	
	public static final double FOCUS_ATTACK_MODIFIER = 1.5;
	public static final double FOCUS_DEFENCE_REDUCTION = 2 ;
	public static final int FOCUS_CHARGES = 2;
	public static final String FOCUS_DESCRIPTION = "Focus: Multiply next hit by "+ FOCUS_ATTACK_MODIFIER +" but multiply next damage receive by " + FOCUS_DEFENCE_REDUCTION;
	
	public static final int HEADSHOT_DAMAGE = 40;
	public static final int HEADSHOT_RANGE = 6;
	public static final int HEADSHOT_CHARGES = 1;
	public static final String HEADSHOT_DESCRIPTION = "Headshot: Does "+ HEADSHOT_DAMAGE +" damage ignoring damage resistance modifiers";
	
	
	public static final int RELOAD_CHARGES = 3;
	public static final String RELOAD_DESCRIPTION ="Reload and Reset your Headshot charge";

	/*
	 * WarriorSkills
	 */
	/**
	 * Halberd Warrior Skills
	 */
	public static final int JUMPATTACK_DAMAGE = 10;
	public static final int JUMP_ATTACK_RANGE = 3;
	public static final int JUMP_ATTACK_CHARGE = 2;
	public static final int JUMP_ATTACK_LENGTH = 1;
	public static final String JUMP_ATTACK_DESCRIPTION = "Warrior Jumps to the target area dealing " + JUMPATTACK_DAMAGE + " damage in a small area";

	public static final int BATTLECRY_LENGTH = 2;
	public static final double MYSELFBATTLECRY_ATTACKMODIFIER = 1.3;
	public static final double BATTLECRY_ATTACKMODIFIER = 1.15;
	public static final int BATTLECRY_CHARGES = 2;
	public static final String BATTLECRY_DESCRIPTION = "Increases attack to allys around the warrior by "+ BATTLECRY_ATTACKMODIFIER +" and to himself by " + MYSELFBATTLECRY_ATTACKMODIFIER ;
	public static final int BATTLECRY_RANGE = 2;
	
	
	public static final int SPIN_TO_WIN_MAX_DAMAGE = 50;
	public static final int SPIN_TO_WIN_MIN_DAMAGE = 25;
	public static final int SPIN_TO_WIN_MOVEMENT_MODIFIER = -1;
	public static final int SPIN_TO_WIN_CHARGES = 2;
	public static final String SPIN_TO_WIN_DESCRIPTION = "Spins dealing "+ SPIN_TO_WIN_MIN_DAMAGE  +" damage in a square area, but if the enemy is in the corner, it does " + SPIN_TO_WIN_MAX_DAMAGE +".It also reduces the users movement by " + SPIN_TO_WIN_MOVEMENT_MODIFIER ;
	public static final int SPIN_TO_WIN_LENGTH = 1;
	
	/**
	 * Zweihander Warrior Skills
	 */
	public static final int INVINCIBILITY = 0;
	
	public static final int UNDYINGMIGHT_HEALTH_INCREASE = 20;
	public static final int UNDYING_MIGHT_CHARGES = 2;
	public static final String UNDYING_MIGHT_DESCRPTION = "Makes the user impervious to the next attack and increases its health or max health by " + UNDYINGMIGHT_HEALTH_INCREASE;
	

	public static final int OSTOPPBAR_KRAFT_DAMAGE = 40;
	public static final int OSTOPPBAR_KRAFT_RANGE = 1;
	public static final int OSTOPPBAR_KRAFT_CHARGES = 1;
	public static final String OSTOPPBAR_KRAFT_DESCRIPTION =  "Deals increasing damage in an inverted cone in front of the user";
	public static final int OSTOPPBAR_KRAFT_LENGTH = 3;
	
	public static final double TAUNT_ARMOR_MODIFIER = 0.65;
	public static final int TAUNT_MOVEMENT_MODIFIER = -3;
	public static final String TAUNT_DESCRIPTION = "Decreases armor of enemys by " + TAUNT_ARMOR_MODIFIER + " and movement by "+ TAUNT_MOVEMENT_MODIFIER ;
	public static final int TAUNT_CHARGES = 2;
	public static final int TAUNT_LENGTH = 1; 
	
	/**
	 * ShorSword Warrior Skills
	 */
	public static final int BROADSLASH_RANGE = 1;
	public static final int BROADSLASH_CHARGES = 3;
	public static final int BROADSLASH_LENGTH = 1;
	public static final String BROADSLASH_DESCRIPTION = "Deals weapon damage in a small area";
	
	
	public static final int DOUBLESTRIKE_RANGE = 1;
	public static final int DOUBLESTRIKE_CHARGES = 3;
	public static final String DOUBLESTRIKE_DESCRIPTION = "Deals single target weapon damage twice";

	public static final int TACTICAL_WITHDRAWAL_RANGE = 4;
	public static final int TACTICAL_WITHDRAWAL_CHARGES = 2;
	public static final String TACTICAL_WITHDRAWAL_DESCRIPTION = "Allows the user to move once again with " +TACTICAL_WITHDRAWAL_RANGE+ " range";

}