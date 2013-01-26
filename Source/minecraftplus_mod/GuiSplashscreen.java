package net.minecraftplus_mod;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import cpw.mods.fml.client.TextureFXManager;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.src.ModLoader;
import net.minecraft.util.StringTranslate;
import org.lwjgl.opengl.GL11;
import org.lwjgl.*;

@SideOnly(Side.CLIENT)
public class GuiSplashscreen extends GuiScreen{

	public String message = "";
	public boolean hasParent = false;
	public Gui parentGui;
	
    public GuiSplashscreen(String randMessage)
    {
        super();
        message = randMessage;
    }
    
    public GuiSplashscreen(Gui parentScreen, String randMessage)
    {
        super();
        message = randMessage;
        parentScreen = parentGui;
        hasParent = true;
    }
    
    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
    	//Background
    	this.drawDefaultBackground();
    	//drawBackgroundPicture(par1, par2, par3);
    	
    	//Logo
    	int imgWidth = 244;
    	int imgHeight = 45;
    	int x = (width - imgWidth) / 2;
    	int y = ((height - imgHeight) / 2) - 20;
    	int q = mc.renderEngine.getTexture("/minecraftplus/splashscreen/guilogo.png");
    	GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    	mc.renderEngine.bindTexture(q);
    	this.drawTexturedModalRect(x, y, 0, 0, imgWidth, imgHeight);
    	
    	//Text
    	int textBase = 15;
    	int finalLine = 0;
    	int substring1 = 0;
    	int substring2 = 0;
    	int substring3 = 0;
    	this.drawCenteredString(this.fontRenderer, "Minecraft+ \u00A72Enabled", this.width / 2, (this.height / 2) + textBase, 16777215);
    	try{
    	int length = message.length();
    	if(length < 82){
    		this.drawCenteredString(this.fontRenderer, message, this.width / 2, (this.height / 2) + textBase + 10, 16777215);
    		finalLine = textBase + 20;
    	}else if(length > 81 && length < 241){
    		substring1 = 81;
    		substring2 = length - 81;
    		this.drawCenteredString(this.fontRenderer, message.substring(0, substring1), this.width / 2, (this.height / 2) + textBase + 10, 16777215);
    		this.drawCenteredString(this.fontRenderer, message.substring(substring1), this.width / 2, (this.height / 2) + textBase + 20, 16777215);
    		finalLine = textBase + 30;
    	}else{
    		substring1 = 241;
    		substring2 = substring1 + 40;
    		substring3 = length - substring2;
    		this.drawCenteredString(this.fontRenderer, message.substring(0, substring1), this.width / 2, (this.height / 2) + textBase + 10, 16777215);
    		this.drawCenteredString(this.fontRenderer, message.substring(substring1, substring2), this.width / 2, (this.height / 2) + textBase + 20, 16777215);
    		this.drawCenteredString(this.fontRenderer, message.substring(substring2), this.width / 2, (this.height / 2) + textBase + 30, 16777215);
    		finalLine = textBase + 40;
    	}}catch(Exception e){
    		e.printStackTrace();
    		this.drawCenteredString(this.fontRenderer, message, this.width / 2, (this.height / 2) + textBase + 10, 16777215);
    		finalLine = textBase + 20;
    	}
        this.drawCenteredString(this.fontRenderer, getDate() + ", " + getYear() + " - " + getTime(), this.width / 2, (this.height / 2) + finalLine, 16777215);
        this.drawCenteredString(this.fontRenderer, "Press esc, or wait a few seconds for the game to start.", this.width / 2, (this.height / 2) + finalLine + 20, 16777215);
        this.drawCenteredString(this.fontRenderer, "This screen can be disabled in the config file. You may also change the length.", this.width / 2, (this.height / 2) + finalLine + 30, 16777215);
        
    	super.drawScreen(par1, par2, par3);
    }

	private void drawBackgroundPicture(int par1, int par2, float par3) {
		this.drawDefaultBackground();
		int i = mc.renderEngine.getTexture("/minecraftplus/splashscreen/bg.png");
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.renderEngine.bindTexture(i);
		drawTexturedModalRect(0, 0, 0, 0, width, height);
	}

	private String getYear(){
    	Calendar calendar = Calendar.getInstance();
		String year = "" + calendar.get(Calendar.YEAR);
		return year;
	}

	private boolean isMessageOK(String message) {
		if(message.length() > 40){
			return false;
		}else{
			return true;
		}
	}

	private String getDate() {
    	Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int month2 = calendar.get(2) + 1;
        int date = calendar.get(5);
        String month = "missingno";
        String suffix = "missingno";
        
        if(date == 1 || date == 21 || date == 31){
            suffix = "st";
        }
        if(date == 2 || date == 22){
            suffix = "nd";
        }
        if(date == 3 || date == 23){
            suffix = "rd";
        }
        if(date >= 4 && date <= 20 || date >= 24 && date <= 30){
            suffix = "th";
        }
        
        if(month2 == 1){
            month = "Jan.";
        }
        if(month2 == 2){
            month = "Feb.";
        }
        if(month2 == 3){
            month = "Mar.";
        }
        if(month2 == 4){
            month = "Apr.";
        }
        if(month2 == 5){
            month = "May.";
        }
        if(month2 == 6){
            month = "Jun.";
        }
        if(month2 == 7){
            month = "Jul.";
        }
        if(month2 == 8){
            month = "Aug.";
        }
        if(month2 == 9){
            month = "Sep.";
        }
        if(month2 == 10){
            month = "Oct.";
        }
        if(month2 == 11){
            month = "Nov.";
        }
        if(month2 == 12){
            month = "Dec.";
        }
    	
		return month + " " + date + suffix;
	}

	private String getTime() {
    	Calendar calendar = Calendar.getInstance();
    	String time = "~~null~~";
    	int hour = calendar.get(Calendar.HOUR_OF_DAY);
    	int minute = calendar.get(Calendar.MINUTE);
    	String ending = "null";
    	if(hour >= 12){
    		ending = "PM";
    		if(hour != 12){
    		hour = hour - 12;
    		}
    	}else{
    		ending = "AM";
    		if(hour == 0){
    			hour = 12;
    		}
    	}
    	String minutes = "" + minute;
    	if(minutes.length() == 1){
    		minutes = "0" + minutes;
    	}
    	time = hour + ":" + minutes + " " + ending;
    	return time;
	}

	/**
     * Returns true if this GUI should pause the game when it is displayed in single-player
     */
    public boolean doesGuiPauseGame()
    {
        return true;
    }
}
