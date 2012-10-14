package net.mod_MinecraftPlus;

import java.awt.Color;
import java.io.File;
import java.util.Locale.Category;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.src.Achievement;
import net.minecraft.src.BiomeGenBase;
import net.minecraft.src.Block;
import net.minecraft.src.CallableMinecraftVersion;
import net.minecraft.src.CraftingManager;
import net.minecraft.src.CreativeTabs;
import net.minecraft.src.EnumArmorMaterial;
import net.minecraft.src.EnumCreatureType;
import net.minecraft.src.EnumToolMaterial;
import net.minecraft.src.IStatStringFormat;
import net.minecraft.src.Item;
import net.minecraft.src.ItemReed;
import net.minecraft.src.ItemStack;
import net.minecraft.src.Material;
import net.minecraft.src.ModLoader;
import net.minecraft.src.StatCollector;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.common.AchievementPage;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.EnumHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.Mod.ServerStarted;
import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartedEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.common.registry.TickRegistry;

//This is an Annotation interface that establishes what sides of the mod are required to run it. clientSideRequired should always be true, and serverSideRequired should USUALLY be false
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
//This is an Annotation interface that establishes the ModID, the name of the Mod, and the Version of the mod. 
@Mod(modid = "mod_Minecraft+", name = "Minecraft+", version = "r2b2")
public class MinecraftPlusBase 
{
	
	/** The instance for Addon Registry. */
	public static PlusAddonRegister addonRegistry;
	
	/** The instance for the Addon Base. Implement your addon with this & be sure to register it by using addonRegistry! */
	public static PlusAddonBase addonBase;
	
	public Minecraft minecraft;
	
	/** Mod release version. +1 every public release. */
	public static int modverrelease = 2;
	
	/** Mod build version. +1 every compile. */
    public static int modverbuild = 2;
    
    /** Full mod version string. */
    public static String modver = "r" + modverrelease + "b" + modverbuild;
    
    /** Current Minecraft Version. */
    public static String mcver = "1.3.2";
    
    /** Check to see if the mod is loaded or not. */
    public static boolean isMCPlusLoaded = false;
	
	//This is an Annotation interface which establishes the location of the Client and Server Proxy's. These are needed for such things as preloading texture files, etc
	@SidedProxy(clientSide = "net.mod_MinecraftPlus.ClientProxy", serverSide = "net.mod_MinecraftPlus.CommonProxy")
	public static CommonProxy proxy;
	public static ClientProxy clientproxy;
	
	//Establishes an Instance of your mod, simple enough
	@Instance("MinecraftPlus")
	public MinecraftPlusBase getPlusInstance;
	
	//ID's for Configuration File
	public static int embroniumIngotID;
	public static int embroniumDustID;
	public static int embroniumBlockID;
	public static int mummyEggID;
	public static int humanEggID;
	
	//Blocks
	public static Block embroniumBlock;
	public static Block embroniumOre;
	public static Block bouncyBlock;
	public static Block boosterBlock;
	public static Block healBlock;
	public static Block damageBlock;
	public static Block embroniumTorch;
	public static Block forceFieldBlock;
	public static Block shieldBlock;
	public static Block nullBlock;
	public static Block camperBlock;
	public static Block iBlock;
	public static Block cobbleGenBlock;
	public static Block craterBlock;
	public static Block minerBlock;
	public static Block hiddenBookshelf;
	
	/** Deprecated. Instead, now called trapBlockFire. */
	@Deprecated
	public static Block trapBlock;
	
	public static Block pizzaBlock;
    public static Block redstoneLampThinIdle;
    public static Block redstoneLampThinActive;
    public static Block trapBlockFire;
    public static Block trapBlockFireSpread;
	
	//Items
	public static Item embroniumIngot;
	public static Item embroniumDust;
	
	/** Deprecated. Instead, uses Forge's method of creating eggs with entities. */
	@Deprecated
	public static Item mummyEgg;
	
	/** Deprecated. Instead, uses Forge's method of creating eggs with entities. */
	@Deprecated
	public static Item humanEgg;	 
    public static Item vortexCrystal;

    //Food
    public static Item itemBandage; 
    public static Item Cheese;
    public static Item Sausage;
    public static Item hotDog;
    public static Item chickenSoup;
    public static Item Tomato;
    public static Item pizzaSlice;
    public static Item Sandwich;
    public static Item cheeseCake;
    public static Item pizzaPlacer;
    public static Item iceCube;
    public static Item iceCreamCone;

    //Armor
    public static Item embroniumHelmet;
    public static Item embroniumChest;
    public static Item embroniumPants;
    public static Item embroniumBoots;

    public static Item ironManHelmet;
    public static Item ironManChest;
    public static Item ironManPants;
    public static Item ironManBoots;  

    //Toolset
    public static Item embroniumPickaxe;
    public static Item embroniumSpade;
    public static Item embroniumSword;
    public static Item embroniumAxe;
    public static Item embroniumHoe;
    
    public static Item daggerWood;
    public static Item daggerStone;
    public static Item daggerIron;
    public static Item daggerGold;
    public static Item daggerDiamond;
    public static Item daggerEmbronium;
	
	//The pre initialization step is not required for a mod to run, but it is excellent for establishing Configuration files before the Mod is loaded (Great for Item/Block ID's)
	@PreInit
	public void preInit(FMLPreInitializationEvent event)
	{
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		//Example Configuration File
		try
		{
			config.load();
			embroniumIngotID = Integer.parseInt(config.getOrCreateIntProperty("Embronium Ingot ID", config.CATEGORY_ITEM, 31702).value);
			embroniumDustID = Integer.parseInt(config.getOrCreateIntProperty("Embronium Dust ID", config.CATEGORY_ITEM, 31703).value);
			mummyEggID = Integer.parseInt((config.getOrCreateIntProperty("Mummy Egg ID", config.CATEGORY_ITEM, 31701)).value);
			humanEggID = Integer.parseInt((config.getOrCreateIntProperty("Human Egg ID", config.CATEGORY_ITEM, 31719)).value);
			embroniumBlockID = Integer.parseInt(config.getOrCreateBlockIdProperty("Embronium Block ID", 181).value);
		}catch(Exception e)
		{
			e.printStackTrace();
		} finally
		{
			config.save();
		}
	}
	
	@Init
	public void init(FMLInitializationEvent event)
	{
		proxy.registerRenderInformation();
		clientproxy.registerRenderInformation();
		
		//You don't have to have all of the calls separated into different methods obviously, I just find it easier to be organized this way
		initializeBlocksAndItems();
		registerBlocks();
		addNames();
		registerEntities();
		setBlockHarvestLevels();
		addRecipes();
		addSmeltingRecipes();
		addOreDictionaryRecipes();
		addOreDictionaryEntries();
		initAchievements();
		
		registerHandlers();
		
		isMCPlusLoaded = true;
	}
	
	private void registerEntities() {
		// Register your entities here
		// Parameters are: entClass, entName, ID, mod, trackingRange, updateFrequency, sendVelocityUpdates // Just like before, just called
		// Differently
		
        //Registers the entities.
        EntityRegistry.registerGlobalEntityID(EntityHuman.class, "Human", ModLoader.getUniqueEntityId(), 0x479C9C, 0x665DAC);
        EntityRegistry.registerGlobalEntityID(EntityMummy.class, "Mummy", ModLoader.getUniqueEntityId(), 0x909144, 0xFAF8CE);
        EntityRegistry.registerGlobalEntityID(EntityHerobrine.class, "Herobrine", ModLoader.getUniqueEntityId());
        
      EntityRegistry.registerModEntity(EntityHuman.class, "Mummy", 2, this, 250, 5, false);
      EntityRegistry.registerModEntity(EntityHerobrine.class, "Herobrine", 3, this, 250, 5, false);
      EntityRegistry.registerModEntity(EntityHuman.class, "Human", 1, this, 250, 5, false);
        
        //Adding Spawns
        EntityRegistry.addSpawn(EntityHuman.class, 5, 0, 10, EnumCreatureType.creature);
        EntityRegistry.addSpawn(EntityMummy.class, 5, 0, 20, EnumCreatureType.monster, BiomeGenBase.desert, BiomeGenBase.desertHills);
        EntityRegistry.addSpawn(EntityHerobrine.class, 1, 0, 2, EnumCreatureType.monster);
	}

	private void addSmeltingRecipes() 
	{
		//
	}

	private void setBlockHarvestLevels() 
	{
		//Used to establish what level of pickaxe is required to destroy a block
		//Params = (Block to add harvest level to, tool type used to harvest, New block harvest level)
		//Tool Types used to harvest = "pickaxe", "axe", "shovel", 
		//Level 0 = Wood, Level 1 = Stone and Gold, Level 2 = Iron, Level 3 = Diamond
		MinecraftForge.setBlockHarvestLevel(embroniumBlock, "pickaxe", 2);
	}

	private void initAchievements() 
	{
		//Achievement Params (Achievement ID, Achievement Name, X Coordinate, Y Coordinate, Block or Item that is rendered on the Achievement, Parent Achievement(Achievement that is required to get this achievement)
		//getExampleBlock = new Achievement(40, "getExampleBlock", 0, 0, exampleBlock, (Achievement)null).setIndependent().registerAchievement();
		//getExampleItem = new Achievement(41, "getExampleItem", -1, -2, exampleItem, getExampleBlock).setIndependent().registerAchievement();
		//getExampleSmeltingAchievementBlock = new Achievement(42, "getExampleSmeltingAchievementBlock", 3, 2, exampleSmeltingAchievementBlock, getExampleBlock).registerAchievement();
		
		
		//AchievementPage Params (Acievement Page Name, Achievements...) the Achievements... allows you to include as many achievements on the page as you like (minimum of two achievements)
		//Separate each Achievement with a comma
		//AchievementPage ExamplePage = new AchievementPage("Example Page", getExampleBlock, getExampleItem, getExampleSmeltingAchievementBlock);
		
		//Register Achievement page params (AchievementPage)
		//AchievementPage.registerAchievementPage(ExamplePage);
		/*Not Working properly, still working on getting this to work. Recommend you do not use this for now
		*/
	}

	private void registerHandlers() 
	{
		//Register World Generator params (new instance of a class that implements IWorldGenerator)
		//This registers a file to generate blocks in the world
		GameRegistry.registerWorldGenerator(new PlusWorldGenerator());
		
		//Register Fuel Handler params (new instance of a class that implements IFuelHandler)
		//This allows you to add fuels to the Furnace, and set the length of time the fuel lasts
		//GameRegistry.registerFuelHandler(new ExampleModFuelHandler());
		
		//Register Crafting Handler params (new instance of a class that implements ICraftingHandler)
		//This allows you to handle certain scenarios such as a player smelting an object or crafting a certain item. Great for triggering achievements
		GameRegistry.registerCraftingHandler(new MinecraftPlusCraftingHandler());
		
		//Register Pickup Handler params (new instance of a class that implements IPickupHandler)
		//This allows you to handle certain item pickup for uses such as triggering achievements
		//GameRegistry.registerPickupHandler(new ExampleModPickupHandler());
		
		//Register Tick Handler params (new instance of a class that implements ITickHandler, Side of Minecraft which uses this tick handler (Client, Server, or Bukkit))
		TickRegistry.registerTickHandler(new ClientTickHandler(), Side.CLIENT);
		TickRegistry.registerTickHandler(new ServerTickHandler(), Side.SERVER);
		
		//Register Gui Handler params (instance of your Mod class, new instance of a class that implements IGuiHandler)
		//NetworkRegistry.instance().registerGuiHandler(this, new ExampleModGUIHandler());
	}
	
	//Example of adding something to the ore Dictionary
	private void addOreDictionaryEntries() 
	{
		//Register Ore params (Ore Dictionary Type, Item to register this Type for)
		//OreDictionary.registerOre("Embronium Ingot", embroniumIngot);
		//OreDictionary.registerOre("Embronium Block", embroniumBlock);
	}
	
	//I have created this method to initialize the blocks to prevent errors when using a Configuration file for the ID's
	//This makes it positive that the block ID's are only initialized AFTER the Configuration file creates the property and the ID is received from the config file
	private static void initializeBlocksAndItems()
	{
		//Blocks
		embroniumBlock = new BlockStorageOre(181, 1, Material.rock).setHardness(2.0F).setCreativeTab(CreativeTabs.tabBlock).setBlockName("embroniumBlock");
		embroniumOre = new BlockNormal(180,3, Material.rock).setCreativeTab(CreativeTabs.tabBlock).setHardness(2.0F).setResistance(5.0F).setBlockName("embroniumOre");
		bouncyBlock = new BlockBouncyBlock(182,0).setHardness(2.0F).setResistance(5.0F).setCreativeTab(CreativeTabs.tabBlock).setBlockName("bouncyBlock");
		boosterBlock = new BlockBoosterBlock(183,0).setHardness(2.0F).setResistance(5.0F).setCreativeTab(CreativeTabs.tabBlock).setBlockName("boosterBlock");
		healBlock = new BlockHealBlock(184,4).setHardness(2.0F).setResistance(5.0F).setCreativeTab(CreativeTabs.tabBlock).setBlockName("healBlock");
		damageBlock = new BlockDamageBlock(185,6).setHardness(2.0F).setResistance(5.0F).setCreativeTab(CreativeTabs.tabBlock).setBlockName("damageBlock");
		embroniumTorch = new EmbroniumTorch(186, 15).setLightValue(1.0F).setHardness(1.0F).setBlockName("embroniumTorch");
		forceFieldBlock = new BlockForceField(187,9).setHardness(2.0F).setResistance(5.0F).setBlockName("forceField");
		shieldBlock = new BlockShield(188, 16 , 37, Material.glass, false).setHardness(3.0F).setResistance(10.0F).setBlockName("shieldBlock");
		nullBlock = new BlockNull(195,0).setHardness(0.0F).setResistance(1.0F).setBlockName("nullBlock");
		camperBlock = new BlockCamper(196,10).setHardness(2.0F).setResistance(5.0F).setCreativeTab(CreativeTabs.tabRedstone).setBlockName("camperBlock");
		iBlock = new BlockiBlock(197,14).setHardness(2.0F).setResistance(5.0F).setCreativeTab(CreativeTabs.tabBlock).setBlockName("iBlock");
		cobbleGenBlock = new BlockCobbleGen(198,11).setHardness(2.0F).setResistance(5.0F).setCreativeTab(CreativeTabs.tabRedstone).setBlockName("cobbleGenBlock");
		craterBlock = new BlockCrater(199,12).setHardness(2.0F).setResistance(5.0F).setCreativeTab(CreativeTabs.tabRedstone).setBlockName("craterBlock");
		minerBlock = new BlockMiner(200,13).setHardness(2.0F).setResistance(5.0F).setCreativeTab(CreativeTabs.tabRedstone).setBlockName("minerBlock");
		hiddenBookshelf = new BlockHiddenBookshelf(201,35).setHardness(1.5F).setCreativeTab(CreativeTabs.tabBlock).setResistance(5.0F).setBlockName("hiddenBookshelf");
		pizzaBlock = new BlockPizza(202,0).setHardness(2.0F).setResistance(1.0F).setBlockName("pizzaBlock");
		redstoneLampThinIdle = (new BlockRedstoneLampThin(203, false)).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setBlockName("redstoneLightThin").setCreativeTab(CreativeTabs.tabRedstone);
		redstoneLampThinActive = (new BlockRedstoneLampThin(204, true)).setHardness(0.3F).setStepSound(Block.soundGlassFootstep).setBlockName("redstoneLightThinActive");
		trapBlockFire = new BlockTrapFire(205,0).setHardness(2.0F).setResistance(5.0F).setCreativeTab(CreativeTabs.tabRedstone).setBlockName("trapBlockFire");
		trapBlockFireSpread = new BlockTrapFireSpread(206,0).setHardness(2.0F).setResistance(5.0F).setCreativeTab(CreativeTabs.tabRedstone).setBlockName("trapBlockFireSpread");
		
		//Items
		embroniumIngot = new ItemOre(31002).setIconCoord(1, 0).setCreativeTab(CreativeTabs.tabMaterials).setItemName("embroniumIngot");
		embroniumDust = new ItemOre(31005).setIconCoord(2, 0).setCreativeTab(CreativeTabs.tabMaterials).setItemName("embroniumDust");
		//mummyEgg = new ItemMummyEgg(31001).setIconCoord(14, 15).setCreativeTab(CreativeTabs.tabMisc).setItemName("mummyEgg");
		//humanEgg = new ItemHumanEgg(31019).setIconCoord(15, 15).setCreativeTab(CreativeTabs.tabMisc).setItemName("humanEgg");
		vortexCrystal = new ItemSpecialEffect(31024).setIconCoord(5, 0).setCreativeTab(CreativeTabs.tabMaterials).setItemName("vortexCrystal");

		//Food
		itemBandage = new ItemPlusFood(31000, 8, 1F, false).setIconCoord(3, 0).setCreativeTab(CreativeTabs.tabMaterials).setItemName("bandage"); 
		Cheese = new ItemPlusFood(31003, 4, 1F, false).setIconCoord(4, 0).setCreativeTab(CreativeTabs.tabFood).setItemName("Cheese");
		Sausage = new ItemPlusFood(31025, 4, 1F, true).setIconCoord(8, 0).setCreativeTab(CreativeTabs.tabFood).setItemName("Sausage");
		hotDog = new ItemPlusFood(31026, 4, 1F, false).setIconCoord(9, 0).setCreativeTab(CreativeTabs.tabFood).setItemName("hotDog");
		chickenSoup = new ItemPlusFood(31027, 4, 1F, false).setIconCoord(10, 0).setCreativeTab(CreativeTabs.tabFood).setItemName("chickenSoup");
		Tomato = new ItemNormal(31028).setIconCoord(11, 0).setCreativeTab(CreativeTabs.tabFood).setItemName("Tomato");
		pizzaSlice = new ItemPlusFood(31029, 2, 1F, false).setIconCoord(6, 0).setCreativeTab(CreativeTabs.tabFood).setItemName("pizzaSlice");
		Sandwich = new ItemPlusFood(31030, 3, 1F, false).setIconCoord(7, 0).setCreativeTab(CreativeTabs.tabFood).setItemName("Sandwich");
		cheeseCake = new ItemPlusFood(31031, 4, 1F, false).setIconCoord(2, 1).setCreativeTab(CreativeTabs.tabFood).setItemName("cheeseCake");
		pizzaPlacer = new ItemReed(31032, MinecraftPlusBase.pizzaBlock).setIconCoord(3, 1).setMaxStackSize(16).setCreativeTab(CreativeTabs.tabFood).setItemName("pizzaPlacer");
		iceCube = new ItemNormal(31033).setIconCoord(0, 1).setCreativeTab(CreativeTabs.tabFood).setItemName("iceCube").setContainerItem(Item.bucketEmpty);
		iceCreamCone = new ItemPlusFood(31034, 2, 1F, false).setIconCoord(1, 1).setCreativeTab(CreativeTabs.tabFood).setItemName("iceCreamCone").setContainerItem(Item.bucketEmpty);

		//Armor
		EnumArmorMaterial EMBRONIUM = EnumHelper.addArmorMaterial("EMBRONIUM", 25, new int[]{2, 7, 5, 2}, 25);
		EnumArmorMaterial IRONMAN = EnumHelper.addArmorMaterial("IRONMAN", 25, new int[]{3, 8, 6, 3}, 25);
		
		embroniumHelmet = new PlusItemArmor(31010,EMBRONIUM, 5, 0).setIconCoord(14, 0).setItemName("embroniumHelmet");
		embroniumChest = new PlusItemArmor(31011,EMBRONIUM, 5, 1).setIconCoord(14, 1).setItemName("embroniumChest");
		embroniumPants = new PlusItemArmor (31012, EMBRONIUM, 5 ,2).setIconCoord(14, 2).setItemName("embroniumPants");
		embroniumBoots = new PlusItemArmor (31013, EMBRONIUM, 5 ,3).setIconCoord(14, 3).setItemName("embroniumBoots");  

		ironManHelmet = new PlusItemArmor(31020,IRONMAN, 6, 0).setIconCoord(15, 0).setItemName("ironManHelmet");
		ironManChest = new PlusItemArmor(31021,IRONMAN, 6, 1).setIconCoord(15, 1).setItemName("ironManChest");
		ironManPants = new PlusItemArmor (31022, IRONMAN, 6 ,2).setIconCoord(15, 2).setItemName("ironManPants");
		ironManBoots = new PlusItemArmor (31023, IRONMAN, 6 ,3).setIconCoord(15, 3).setItemName("ironManBoots");  
		
		//Toolset
		embroniumPickaxe = (new PlusItemPickaxe (31014, PlusToolMaterial.EMBRONIUM)).setCreativeTab(CreativeTabs.tabTools).setIconCoord(14, 6).setItemName("embroniumPickaxe");
		embroniumSpade = (new PlusItemSpade (31015, PlusToolMaterial.EMBRONIUM)).setCreativeTab(CreativeTabs.tabTools).setIconCoord(14, 8).setItemName("embroniumSpade");
		embroniumSword = (new PlusItemSword (31016, PlusToolMaterial.EMBRONIUM, 4)).setCreativeTab(CreativeTabs.tabCombat).setIconCoord(14, 5).setItemName("embroniumSword");
		embroniumAxe = (new PlusItemAxe (31707, PlusToolMaterial.EMBRONIUM)).setCreativeTab(CreativeTabs.tabTools).setIconCoord(14, 6).setItemName("embroniumAxe");
		embroniumHoe = (new PlusItemHoe (31708, PlusToolMaterial.EMBRONIUM)).setCreativeTab(CreativeTabs.tabTools).setIconCoord(14, 8).setItemName("embroniumHoe");
		
		daggerWood = (new PlusItemSword (31050, PlusToolMaterial.WOOD, 1)).setCreativeTab(CreativeTabs.tabCombat).setIconCoord(15, 4).setItemName("daggerWood");
		daggerStone = (new PlusItemSword (31051, PlusToolMaterial.STONE, 1)).setCreativeTab(CreativeTabs.tabCombat).setIconCoord(15, 5).setItemName("daggerStone");
		daggerIron = (new PlusItemSword (31052, PlusToolMaterial.IRON, 1)).setCreativeTab(CreativeTabs.tabCombat).setIconCoord(15, 6).setItemName("daggerIron");
		daggerGold = (new PlusItemSword (31053, PlusToolMaterial.GOLD, 1)).setCreativeTab(CreativeTabs.tabCombat).setIconCoord(15, 7).setItemName("daggerGold");
		daggerDiamond = (new PlusItemSword (31054, PlusToolMaterial.EMERALD, 1)).setCreativeTab(CreativeTabs.tabCombat).setIconCoord(15, 8).setItemName("daggerDiamond");
		daggerEmbronium = (new PlusItemSword (31055, PlusToolMaterial.EMBRONIUM, 1)).setCreativeTab(CreativeTabs.tabCombat).setIconCoord(15, 9).setItemName("daggerEmbronium");
		//exampleSmeltingAchievementBlock = new BlockExampleBlock(exampleSmeltingAchievementBlockID, 1).setHardness(2.0F).setBlockName("Example Smelting Achievement Block");
	}

	private void addOreDictionaryRecipes() 
	{
		//Example of making recipes that can use Items of the same registered Ore Dictionary type.
		//In this example you can use one of the example item and one of the example block and the recipe 
		//will still be complete giving you the Empty Bucket
		/*CraftingManager.getInstance().getRecipeList().add(new ShapedOreRecipe((Item.bucketEmpty), new Object[] {
		"FF", Character.valueOf('F'), "Example"
		}));*/
	}

	private void addRecipes() 
	{
		//This is an example of adding a Non-Ore Dictionary recipe where only a specific Item will do. Remind you of something? If you've used ModLoader
		/*GameRegistry.addRecipe(new ItemStack(Item.bucketEmpty), new Object [] {
		"FF", Character.valueOf('F'), exampleItem	
		});
		
		GameRegistry.addRecipe(new ItemStack(exampleItem), new Object [] {
			"F", Character.valueOf('F'), exampleBlock	
			});*/
		GameRegistry.addRecipe(new ItemStack(embroniumBlock), new Object [] {
			"$$$", "$$$", "$$$", Character.valueOf('$'), embroniumIngot	
			});
		GameRegistry.addShapelessRecipe(new ItemStack(embroniumDust), new Object[] { /*ingredients*/ embroniumIngot});
		GameRegistry.addRecipe(new ItemStack (embroniumHelmet, 1), (new Object[] {"XXX", "X X","   ", Character.valueOf('X'), MinecraftPlusBase.embroniumIngot}));
		GameRegistry.addRecipe(new ItemStack (embroniumChest, 1), (new Object[] {"X X", "XXX", "XXX", Character.valueOf('X'), MinecraftPlusBase.embroniumIngot}));
		GameRegistry.addRecipe(new ItemStack (embroniumPants, 1), (new Object[] {"XXX", "X X", "X X", Character.valueOf('X'), MinecraftPlusBase.embroniumIngot}));
		GameRegistry.addRecipe(new ItemStack (embroniumBoots, 1), (new Object[] {"X X", "X X", Character.valueOf('X'), MinecraftPlusBase.embroniumIngot}));
		GameRegistry.addRecipe(new ItemStack (ironManHelmet, 1), (new Object[] {"XXX", "X X","   ", Character.valueOf('X'), MinecraftPlusBase.vortexCrystal}));
		GameRegistry.addRecipe(new ItemStack (ironManChest, 1), (new Object[] {"X X", "XXX", "XXX", Character.valueOf('X'), MinecraftPlusBase.vortexCrystal}));
		GameRegistry.addRecipe(new ItemStack (ironManPants, 1), (new Object[] {"XXX", "X X", "X X", Character.valueOf('X'), MinecraftPlusBase.vortexCrystal}));
		GameRegistry.addRecipe(new ItemStack (ironManBoots, 1), (new Object[] {"X X", "X X", Character.valueOf('X'), MinecraftPlusBase.vortexCrystal}));

		//Toolset
		GameRegistry.addRecipe(new ItemStack (embroniumAxe, 1), (new Object[] {"XX ", "X@ "," @ ", Character.valueOf('X'), MinecraftPlusBase.embroniumIngot, Character.valueOf('@'), Item.stick}));
		GameRegistry.addRecipe(new ItemStack (embroniumPickaxe, 1), (new Object[] {"XXX", " @ "," @ ", Character.valueOf('X'), MinecraftPlusBase.embroniumIngot, Character.valueOf('@'), Item.stick}));
		GameRegistry.addRecipe(new ItemStack (embroniumHoe, 1), (new Object[] {"XX ", " @ "," @ ", Character.valueOf('X'), MinecraftPlusBase.embroniumIngot, Character.valueOf('@'), Item.stick}));
		GameRegistry.addRecipe(new ItemStack (embroniumSword, 1), (new Object[] {" X ", " X "," @ ", Character.valueOf('X'), MinecraftPlusBase.embroniumIngot, Character.valueOf('@'), Item.stick}));
		GameRegistry.addRecipe(new ItemStack (embroniumSpade, 1), (new Object[] {" X ", " @ "," @ ", Character.valueOf('X'), MinecraftPlusBase.embroniumIngot, Character.valueOf('@'), Item.stick}));
		//GameRegistry.addShapelessRecipe(new ItemStack(embroniumPickaxe), new Object[] { /*ingredients*/ Block.dirt});
		//^^ For testing purposes

		//Blocks
		GameRegistry.addRecipe(new ItemStack(redstoneLampThinIdle, 16), new Object [] {"   ", "###", "###", Character.valueOf('#'), Block.redstoneLampIdle});
		GameRegistry.addRecipe(new ItemStack(trapBlockFire, 1), new Object [] {"$@$", "$#$", "$$$", Character.valueOf('#'), Item.redstone, Character.valueOf('@'), Item.flintAndSteel, Character.valueOf('$'), Block.stone});
		GameRegistry.addRecipe(new ItemStack(hiddenBookshelf, 1), new Object [] {"$$$", "#@#", "$$$", Character.valueOf('#'), Item.book, Character.valueOf('@'), Item.redstone, Character.valueOf('$'), Block.planks});
		GameRegistry.addRecipe(new ItemStack(iBlock, 1), new Object [] {"###", "#@#", "###", Character.valueOf('#'), MinecraftPlusBase.embroniumIngot, Character.valueOf('@'), Item.redstone});
		GameRegistry.addRecipe(new ItemStack(forceFieldBlock, 1), new Object [] {"###", "#@#", "###", Character.valueOf('#'), Block.thinGlass, Character.valueOf('@'), Item.redstone});
		GameRegistry.addRecipe(new ItemStack(camperBlock, 1), new Object [] {"#$#", "#@#", "!%&", Character.valueOf('#'), Block.planks, Character.valueOf('@'), Item.bed, Character.valueOf('$'), Block.glass, Character.valueOf('!'), Block.stoneOvenIdle, Character.valueOf('&'), Block.workbench, Character.valueOf('%'), Block.chest});
		GameRegistry.addRecipe(new ItemStack(cobbleGenBlock, 1), new Object [] {"#@#", "###", "#$#", Character.valueOf('#'), Block.stone, Character.valueOf('@'), Item.bucketLava, Character.valueOf('$'), Item.bucketWater});
		GameRegistry.addRecipe(new ItemStack(craterBlock, 2), new Object [] {"$#$", "#@#", "$#$", Character.valueOf('#'), Block.sand, Character.valueOf('@'), Item.redstone, Character.valueOf('$'), Item.gunpowder});
		GameRegistry.addRecipe(new ItemStack(minerBlock, 1), new Object [] {"###", "#@#", "###", Character.valueOf('#'), MinecraftPlusBase.embroniumIngot, Character.valueOf('@'), Item.pickaxeSteel});
		GameRegistry.addRecipe(new ItemStack(minerBlock, 1), new Object [] {"###", "#@#", "###", Character.valueOf('#'), MinecraftPlusBase.embroniumIngot, Character.valueOf('@'), Item.pickaxeDiamond});
		GameRegistry.addRecipe(new ItemStack(minerBlock, 1), new Object [] {"###", "#@#", "###", Character.valueOf('#'), MinecraftPlusBase.embroniumIngot, Character.valueOf('@'), Item.pickaxeGold});
		GameRegistry.addRecipe(new ItemStack(minerBlock, 1), new Object [] {"###", "#@#", "###", Character.valueOf('#'), MinecraftPlusBase.embroniumIngot, Character.valueOf('@'), MinecraftPlusBase.embroniumPickaxe});
		GameRegistry.addRecipe(new ItemStack(boosterBlock, 1), new Object [] {"###", "###", "###", Character.valueOf('#'), Block.ice});
		GameRegistry.addRecipe(new ItemStack(damageBlock, 1), new Object [] {"###", "###", "###", Character.valueOf('#'), Block.cactus});
		GameRegistry.addRecipe(new ItemStack(healBlock, 1), new Object [] {"###", "###", "###", Character.valueOf('#'), Item.cake});
		GameRegistry.addRecipe(new ItemStack(bouncyBlock, 1), new Object [] {"   ", "###", "@ @", Character.valueOf('#'), Block.cloth, Character.valueOf('@'), Item.stick});
		GameRegistry.addRecipe(new ItemStack(iceCube, 4), new Object [] {"   ", " # ", " @ ", Character.valueOf('#'), Item.snowball, Character.valueOf('@'), Item.bucketWater});
		GameRegistry.addShapelessRecipe(new ItemStack(Block.ice, 1), new Object[] { /*ingredients*/ iceCube});
		GameRegistry.addShapelessRecipe(new ItemStack(embroniumIngot, 9), new Object[] { /*ingredients*/ MinecraftPlusBase.embroniumBlock});

		//Items
		GameRegistry.addRecipe(new ItemStack(embroniumTorch, 4), new Object [] {"   ", " # ", " @ ", Character.valueOf('#'), MinecraftPlusBase.embroniumDust, Character.valueOf('@'), Item.stick});
		GameRegistry.addRecipe(new ItemStack(vortexCrystal, 2), new Object [] {"$#$", "#@#", "$#$", Character.valueOf('#'), MinecraftPlusBase.embroniumIngot, Character.valueOf('@'), Item.redstone, Character.valueOf('$'), Item.diamond});  //This is the recipe for vortex crystals
		//GameRegistry.addShapelessRecipe(new ItemStack(ItemVortexCrystal), new Object[] { /*ingredients*/ Block.dirt});
		//^^ For testing purposes

		//Food
		GameRegistry.addShapelessRecipe(new ItemStack(Cheese), new Object[] { /*ingredients*/ Item.bucketMilk});
		GameRegistry.addRecipe(new ItemStack(itemBandage, 2), new Object [] {"   ", "#  ", "#  ", Character.valueOf('#'), Item.silk});  //This is the recipe for bandages (Note: They can also be collected from Mummies.)
		GameRegistry.addRecipe(new ItemStack(pizzaPlacer, 1), new Object [] {" # ", " @ ", " $ ", Character.valueOf('#'), MinecraftPlusBase.Cheese, Character.valueOf('@'), MinecraftPlusBase.Tomato, Character.valueOf('$'), Item.bread});  //This is the recipe for vortex crystals
		GameRegistry.addShapelessRecipe(new ItemStack(Sausage), new Object[] { /*ingredients*/ Item.chickenCooked, Item.porkCooked, Item.beefCooked});
		GameRegistry.addRecipe(new ItemStack(hotDog, 1), new Object [] {" # ", " @ ", " # ", Character.valueOf('#'), Item.bread, Character.valueOf('@'), MinecraftPlusBase.Sausage});  //This is the recipe for vortex crystals
		GameRegistry.addShapelessRecipe(new ItemStack(chickenSoup), new Object[] { /*ingredients*/ Item.bowlEmpty, Item.chickenCooked});
		GameRegistry.addShapelessRecipe(new ItemStack(Sandwich), new Object[] { /*ingredients*/ Item.bread, MinecraftPlusBase.Cheese, Item.bread, Item.chickenCooked});
		GameRegistry.addShapelessRecipe(new ItemStack(cheeseCake), new Object[] { /*ingredients*/ Item.cake, MinecraftPlusBase.Cheese});
		GameRegistry.addShapelessRecipe(new ItemStack(pizzaSlice, 8), new Object[] { /*ingredients*/ MinecraftPlusBase.pizzaPlacer});
		GameRegistry.addShapelessRecipe(new ItemStack(iceCreamCone, 1), new Object[] { /*ingredients*/ iceCube, Item.bucketMilk, (new ItemStack(Item.dyePowder, 1, 3))});
	}

	private void addNames() 
	{
		//DEFAULTS
		//Blocks
		LanguageRegistry.addName(embroniumBlock, "Embronium Block");
		LanguageRegistry.addName(embroniumOre, "Embronium Ore");
		LanguageRegistry.addName(bouncyBlock, "Bouncy Block");
		LanguageRegistry.addName(boosterBlock, "Booster Block");
		LanguageRegistry.addName(healBlock, "Heal Block");
		LanguageRegistry.addName(damageBlock, "Damage Block");
		LanguageRegistry.addName(embroniumTorch, "Embronium Torch");
		LanguageRegistry.addName(forceFieldBlock, "Force Field");
		LanguageRegistry.addName(shieldBlock, "Shield Block");
		LanguageRegistry.addName(nullBlock, "Null Block");
		LanguageRegistry.addName(camperBlock, "Tent Block");
		LanguageRegistry.addName(iBlock, "iBlock");
		LanguageRegistry.addName(cobbleGenBlock, "Cobblestone Generator");
		LanguageRegistry.addName(craterBlock, "Crater Block");
		LanguageRegistry.addName(minerBlock, "Miner Block");
		LanguageRegistry.addName(hiddenBookshelf, "Secret Bookshelf");
		LanguageRegistry.addName(trapBlockFire, "Fire Trap Block");
		LanguageRegistry.addName(trapBlockFireSpread, "Fire Spread Trap Block");
		LanguageRegistry.addName(pizzaBlock, "Pizza");
		LanguageRegistry.addName(redstoneLampThinIdle, "Thin Redstone Lamp");
		LanguageRegistry.addName(redstoneLampThinActive, "[ACTIVE] Thin Redstone Lamp");
		//Items
		LanguageRegistry.addName(embroniumIngot, "Embronium Ingot");
		LanguageRegistry.addName(embroniumDust, "Embronium Dust");
		//LanguageRegistry.addName(mummyEgg, "Mummy Egg");
		//LanguageRegistry.addName(humanEgg, "Human Egg");
		LanguageRegistry.addName(vortexCrystal, "Vortex Crystal");
		//Food
		LanguageRegistry.addName(itemBandage, "Bandage");
		LanguageRegistry.addName(Cheese, "Cheese");
		LanguageRegistry.addName(pizzaSlice, "Pizza Slice");
		LanguageRegistry.addName(Sandwich, "Sandwich");
		LanguageRegistry.addName(Sausage, "Sausage");
		LanguageRegistry.addName(hotDog, "Hot Dog");
		LanguageRegistry.addName(chickenSoup, "Chicken Soup");
		LanguageRegistry.addName(Tomato, "Tomato");
		LanguageRegistry.addName(iceCube, "Ice Cube");
		LanguageRegistry.addName(iceCreamCone, "Ice Cream Cone");
		LanguageRegistry.addName(cheeseCake, "Cheesecake");
		LanguageRegistry.addName(pizzaPlacer, "Pizza");
		//Armor
		LanguageRegistry.addName(embroniumHelmet, "Embronium Helmet");
		LanguageRegistry.addName(embroniumChest, "Embronium Chestplate");
		LanguageRegistry.addName(embroniumPants, "Embronium Pants");
		LanguageRegistry.addName(embroniumBoots, "Embronium Boots");
		
		LanguageRegistry.addName(ironManHelmet, "Iron Man Helmet");
		LanguageRegistry.addName(ironManChest, "Iron Man Chestplate");
		LanguageRegistry.addName(ironManPants, "Iron Man Pants");
		LanguageRegistry.addName(ironManBoots, "Iron Man Boots");
		//Tools
		LanguageRegistry.addName(embroniumSword, "Embronium Sword");
		LanguageRegistry.addName(embroniumPickaxe, "Embronium Pickaxe");
		LanguageRegistry.addName(embroniumAxe, "Embronium Axe");
		LanguageRegistry.addName(embroniumSpade, "Embronium Shovel");
		LanguageRegistry.addName(embroniumHoe, "Embronium Hoe");
		
		LanguageRegistry.addName(daggerWood, "Wooden Dagger");
		LanguageRegistry.addName(daggerStone, "Stone Dagger");
		LanguageRegistry.addName(daggerIron, "Iron Dagger");
		LanguageRegistry.addName(daggerGold, "Golden Dagger");
		LanguageRegistry.addName(daggerDiamond, "Diamond Dagger");
		LanguageRegistry.addName(daggerEmbronium, "Embronium Dagger");
		//Entities
        LanguageRegistry.instance().addStringLocalization("entity.Human.name", "en_US", "Human");
        LanguageRegistry.instance().addStringLocalization("entity.Mummy.name", "en_US", "Mummy");
        LanguageRegistry.instance().addStringLocalization("entity.Herobrine.name", "en_US", "Herobrine");
		
		//Other Languages
		//Blocks
		LanguageRegistry.instance().addNameForObject(embroniumBlock, "en_PT", "Block 'o' Embronium");
		LanguageRegistry.instance().addNameForObject(redstoneLampThinActive, "en_PT", "Cheater's Light");
		LanguageRegistry.instance().addNameForObject(redstoneLampThinIdle, "en_PT", "Magical Light");
		//Items
		LanguageRegistry.instance().addNameForObject(embroniumIngot, "en_PT", "Embronium Bullion");
		//Food
		LanguageRegistry.instance().addNameForObject(Cheese, "fr_FR", "Fromage");
		LanguageRegistry.instance().addNameForObject(Cheese, "en_PT", "Frozen Butter");
		LanguageRegistry.instance().addNameForObject(itemBandage, "en_PT", "Wrapped Parchment");
		//Armor
		//
		//Tools
		//
	}

	private void registerBlocks() 
	{
		//This is an example of registering a Block, again, this should also look familiar if you've used ModLoader
		//Register Block params (Object of Block) 
		GameRegistry.registerBlock(embroniumBlock);
		GameRegistry.registerBlock(embroniumOre);
		GameRegistry.registerBlock(bouncyBlock);
		GameRegistry.registerBlock(boosterBlock);
		GameRegistry.registerBlock(healBlock);
		GameRegistry.registerBlock(damageBlock);
		GameRegistry.registerBlock(embroniumTorch);
		GameRegistry.registerBlock(forceFieldBlock);
		GameRegistry.registerBlock(shieldBlock);
		GameRegistry.registerBlock(nullBlock);
		GameRegistry.registerBlock(camperBlock);
		GameRegistry.registerBlock(iBlock);
		GameRegistry.registerBlock(cobbleGenBlock);
		GameRegistry.registerBlock(craterBlock);
		GameRegistry.registerBlock(minerBlock);
		GameRegistry.registerBlock(hiddenBookshelf);
		GameRegistry.registerBlock(trapBlockFire);
		GameRegistry.registerBlock(trapBlockFireSpread);
		GameRegistry.registerBlock(pizzaBlock);
		GameRegistry.registerBlock(redstoneLampThinIdle);
		GameRegistry.registerBlock(redstoneLampThinActive);
		//GameRegistry.registerBlock(exampleSmeltingAchievementBlock);
	}

	//This is another method that does not have to be used, but can be used for manipulating things
	//once the Game has already been started
	@PostInit
	public void postInit(FMLPostInitializationEvent event)
	{
		
	}
	
	//This allows you to do Certain things once a server with the mod installed is started 
	//(Such as in the new combined Client/Server Minecraft)
	@ServerStarted
	public void serverStarted(FMLServerStartedEvent event)
	{
		
	}
	
	/** Truth. 
	 * @return true*/
	public static boolean isCoolawesomemeAwesome(){
    	return true;
    }
	
	/** Returns if the mod is loaded.
	 * @return Is MinecraftPlus Loaded */
	public boolean isMinecraftPlusLoaded(){
    	return isMCPlusLoaded;
    }
	
	/** Returns a random integer.
	 * @param par1Limit
	 * @return A random int from 0 - your input */
	public static int getRandomInt(int par1Limit){
	   	Random randomGenerator = new Random();
	    int randomInt = randomGenerator.nextInt(par1Limit + 1);
	   	return randomInt;
	}
	
	/** Returns the mod version.
	 * @return Mod Version */
	public static String getModVersion(){
		return modver;
	}
	
	/** Inverts the boolean you supply.
	 * @param par1Boolean
	 * @return Inverted Boolean */
	public static boolean invertBoolean(boolean par1Boolean){
		boolean par2Boolean = (Boolean)null;
		if(par1Boolean == false){
			return par2Boolean = true;
		}
		else if(par1Boolean == true){
			return par2Boolean = false;
		}
		return par2Boolean;
	}
}
