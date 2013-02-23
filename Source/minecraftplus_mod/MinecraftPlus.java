package net.minecraftplus_mod;

import java.util.Random;

public class MinecraftPlus {
	
	/** The instance for Addon Registry. */
	public static PlusAddonRegister addonRegistry;
	
	/** The instance for MinecraftPlusBase. */
	public static MinecraftPlusBase getPlusBaseInstance;
	
	/** The instance for the Addon Base. Implement your addon with this & be sure to register it by using addonRegistry! */
	public static PlusAddonBase addonBase;
	
	/** The instance for this class. Use to access methods without making an instance in your own class. */
	public static MinecraftPlus getPlusInstance = new MinecraftPlus();
	
	/** Truth. 
	 * @return true*/
	public static boolean isCoolawesomemeAwesome(){
    	return true;
    }
	
	
	/** Inverts the boolean you supply.
	 * @param 
	 * @return Inverted Boolean */
	public static boolean invertBoolean(boolean par1Boolean){
		return !par1Boolean;
	}
	
	/** Returns a random boolean.
	 * @return Inverted Boolean */
	public static boolean getRandomBoolean(){
		Random random = new Random();
		int i = random.nextInt(3);
		return !(i <= 1);
	}
	
	/**Returns a random letter.
	 * @return Random Letter */
	public static String getRandomLetter(){
		String letter = "";
		Random random = new Random();
		int i = random.nextInt(26);
		if(i <= 0){
			letter = "a";
		}else if(i == 1){
			letter = "b";
		}else if(i == 2){
			letter = "c";
		}else if(i == 3){
			letter = "d";
		}else if(i == 4){
			letter = "e";
		}else if(i == 5){
			letter = "f";
		}else if(i == 6){
			letter = "g";
		}else if(i == 7){
			letter = "h";
		}else if(i == 8){
			letter = "i";
		}else if(i == 9){
			letter = "j";
		}else if(i == 10){
			letter = "k";
		}else if(i == 11){
			letter = "l";
		}else if(i == 12){
			letter = "m";
		}else if(i == 13){
			letter = "n";
		}else if(i == 14){
			letter = "o";
		}else if(i == 15){
			letter = "p";
		}else if(i == 16){
			letter = "q";
		}else if(i == 17){
			letter = "r";
		}else if(i == 18){
			letter = "s";
		}else if(i == 19){
			letter = "t";
		}else if(i == 20){
			letter = "u";
		}else if(i == 21){
			letter = "v";
		}else if(i == 22){
			letter = "w";
		}else if(i == 23){
			letter = "x";
		}else if(i == 24){
			letter = "y";
		}else if(i >= 25){
			letter = "z";
		}
		return letter;
	}
	
	/**Returns a random number (1 - 9)
	 * @return Random Number */
	public static String getRandomNumber(){
		Random random = new Random();
		int randomInt = random.nextInt(9);
		randomInt++;
		return "" + randomInt;
	}
	
	/**Returns a random number (1 - 9)
	 * @return Random Int */
	public static int getRandomInt(){
		Random random = new Random();
		int randomInt = random.nextInt(9);
		return randomInt++;
	}
	
	/** Returns a random string under the parameter.
	 * @param
	 * @return Random String */
	public static String getRandomString(int par1CharactersNumber){
		int length = 0;
		String finalString = "";
		for(int i = 0; i < par1CharactersNumber; i++){
			boolean keepOnGoing = getRandomBoolean();
			boolean number = getRandomBoolean();
			
			if(length >= ((int) 0.75 * par1CharactersNumber)){
				if(keepOnGoing){
					if(number){
						String k = getRandomNumber();
						finalString.concat(k);
						length++;
					}else{
						String k = getRandomLetter();
						finalString.concat(k);
						length++;
					}
				}else{
					return finalString;
				}
			}else{
				if(number){
					String k = getRandomNumber();
					finalString.concat(k);
					length++;
				}else{
					String k = getRandomLetter();
					finalString.concat(k);
					length++;
				}
			}
		}
		return finalString;
	}
	
	public static void sendOutMessage(String message){
		System.out.println("[MC+] " + message);
	}
	
	public static void sendOutMessage(String message, String signature){
		System.out.println("[" + signature + "] " + message);
	}
}
