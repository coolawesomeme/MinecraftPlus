package net.mod_MinecraftPlus;

import net.minecraft.src.ICommandSender;
import net.minecraft.src.RConConsoleSource;
import net.minecraft.src.StringTranslate;

public class PlusConsoleSender extends RConConsoleSource
{
    /** only ever used by MinecraftServer.executeCommand */
    public static final PlusConsoleSender consoleBuffer = new PlusConsoleSender();
    private StringBuffer chatBuffer = new StringBuffer();

    public void clearChatBuffer()
    {
        this.chatBuffer.setLength(0);
    }

    public String getChatBuffer()
    {
        return this.chatBuffer.toString();
    }

    /**
     * Gets the name of this command sender (usually username, but possibly "Rcon")
     */
    public String getCommandSenderName()
    {
        return "Minecraft+";
    }
}
