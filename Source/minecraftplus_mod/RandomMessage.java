package net.minecraftplus_mod;

import java.util.Random;

import net.minecraft.client.Minecraft;

public class RandomMessage {
	
	public static String getRandomMessage(){
		Random random = new Random();
		int randInt1 = random.nextInt(22);
		if(randInt1 <= 1)
			return "Come with me if you want to live.";
		else if(randInt1 == 2)
			return "Help me Obi-Wan, you're my only hope!";
		else if(randInt1 == 3)
			return "Hasta la Vista, baby.";
		else if(randInt1 == 4)
			return "The name's Bond. James Bond.";
		else if(randInt1 == 5)
			return "I'm the king of the world!";
		else if(randInt1 == 6)
			return "IT'S ALIVE!";
		else if(randInt1 == 7)
			return "I've a feeling we're not in Kansas anymore.";
		else if(randInt1 == 8)
			return "May the force be with you...";
		else if(randInt1 == 9)
			return "...Ah, Houston, we've had a problem.";
		else if(randInt1 == 10)
			return "JE PARLE UN PEU FRANCAIS!";
		else if(randInt1 == 11)
			return "SHUT UP AND TAKE MY MONEY!";
		else if(randInt1 == 12)
			return "Your mod is bad, and you should feel bad!";
		else if(randInt1 == 13)
			return "Your splashscreen is bad, and you should feel bad!";
		else if(randInt1 == 14)
			return "Build long and prosper.";
		else if(randInt1 == 15)
			return MinecraftColors.randomLetters + MinecraftColors.randomLetters + MinecraftColors.randomLetters + MinecraftColors.randomLetters;
		else if(randInt1 == 16)
			return "I'm gonna pop some tags, only got 20 dollars in my pocket!";
		else if(randInt1 == 17)
			return "AIN'T NOBODY GOT TIME FO DAT!";
		else if(randInt1 == 18)
			return "We're no strangers to love, you know the rules and so do I.";
		else if(randInt1 == 19)
			return "A full commitment's what I'm thinking of, you wouldn't get this from any other guy.";
		else if(randInt1 == 20)
			return "I just wanna tell you how I'm feeling, gotta make you understand";
		else if(randInt1 >= 21)
			return "And that, kids, is how I met your mother.";
		return "coolawesomeme is awesome!";
	}
	
	public static String getRandomTooltip(){
		String protip = "[" + MinecraftColors.lightRed + "PROTIP" + MinecraftColors.reset + "]: ";
		Random random = new Random();
		int randInt2 = random.nextInt(9);
		if(randInt2 <= 1)
			return protip + "Don't ever dig straight down.";
		else if(randInt2 == 2)
			return protip + "The chicken is a spy! (Or not.)";
		else if(randInt2 == 3)
			return protip + "Always bring a bucket o' water. ALWAYS.";
		else if(randInt2 == 4)
			return protip + "TNT cannons can blow themselves up.";
		else if(randInt2 == 5)
			return protip + "Lava can burn you.";
		else if(randInt2 == 6)
			return protip + "Half-slabs are sprayed with mob-protection spray! (Mobs won't spawn there.)";
		else if(randInt2 == 7)
			return protip + "Bedrock is unminable.";
		else if(randInt2 >= 8)
			return protip + "Creepers go boom-boom.";
		return protip + "Diamonds are often near lava!";
	}
}
