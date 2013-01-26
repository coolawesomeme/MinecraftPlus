package net.minecraftplus_mod;

import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.player.BonemealEvent;

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
                }else if (event.ID == MinecraftPlusBase.tomatoCrop.blockID)
                {
                    if (!event.world.isRemote)
                    {
                            ((BlockTomatoCrop)MinecraftPlusBase.tomatoCrop).growCrop(event.world, event.X, event.Y, event.Z);
                    }
                }

        }


}