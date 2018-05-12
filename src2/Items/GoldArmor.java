package Items;


public class GoldArmor extends Armor {
	private static String name = "Gold Armor";;
	private static String desc = "Increases maximum HP by 15";;
	private static int increase = 15;
	private static int price = 15;

	public GoldArmor () {
		super(name, desc, increase, price);
	}


}
