package net.minecraftplus_mod;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraft.src.*;

public class PlusBonemealHandler
{

        @ForgeSubscribe
        public void onUseBonemeal(BonemealEvent event)
        {
                if (event.ID == MinecraftPlusBase.palmSapling.blockID)
                {
                        if (!event.world.isRemote)
                        {
                                ((BlockPalmSapling)MinecraftPlusBase.palmSapling).growTree(event.world, event.X, event.Y, event.Z, event.world.rand);
                        }
                }

        }


}