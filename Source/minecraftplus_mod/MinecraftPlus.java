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
	public static MinecraftPlus getPlusInstance;
	
	/** Truth. 
	 * @return true*/
	public boolean isCoolawesomemeAwesome(){
    	return true;
    }
	
	
	/** Inverts the boolean you supply.
	 * @param 
	 * @return Inverted Boolean */
	public boolean invertBoolean(boolean par1Boolean){
		boolean par2Boolean = (Boolean)null;
		if(par1Boolean == false){
			return par2Boolean = true;
		}
		else if(par1Boolean == true){
			return par2Boolean = false;
		}
		return par2Boolean;
	}
	
	/** Returns a random boolean.
	 * @return Inverted Boolean */
	public boolean getRandomBoolean(){
		Random random = new Random();
		int i = random.nextInt(2);
		boolean randomBoolean;
		if(i == 0){
			randomBoolean = false;
		}else{
			randomBoolean = true;
		}
		return randomBoolean;
	}
	
	/**Returns a random letter.
	 * @return Random Letter */
	public String getRandomLetter(){
		String letter = "";
		Random random = new Random();
		int i = random.nextInt(26);
		if(i == 0){
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
		}else if(i == 25){
			letter = "z";
		}
		return letter;
	}
	
	/**Returns a random number (1 - 9)
	 * @return Random Number */
	public String getRandomNumber(){
		Random random = new Random();
		int randomInt = random.nextInt(9);
		randomInt++;
		String number = "" + randomInt;
		return number;
	}
	
	/** Returns a random string under the parameter & above 4.
	 * @param
	 * @return Random String */
	public String getRandomString(int par1CharactersNumber){
		int length = 0;
		String finalString = "";
		for(int i = 0; i < par1CharactersNumber; i++){
			boolean keepOnGoing = getRandomBoolean();
			boolean number = getRandomBoolean();
			if(par1CharactersNumber < 4 || par1CharactersNumber == 4){
				par1CharactersNumber = 5;
			}else if(par1CharactersNumber > 21 || par1CharactersNumber == 21){
				par1CharactersNumber = 20;
			}
			
			if(length > ((int) 0.75 * par1CharactersNumber) || length == ((int) 0.75 * par1CharactersNumber)){
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
}
