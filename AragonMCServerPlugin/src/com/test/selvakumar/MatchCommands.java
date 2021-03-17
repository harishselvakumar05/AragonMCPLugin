package com.test.selvakumar;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.WorldBorder;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.GameMode;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.command.*;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.FireworkExplodeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;




public class MatchCommands implements CommandExecutor, Listener{

	private static Player player;
	private static World world;
	static boolean startGame = false;
	static boolean  start = true;
	private static main main;
	private static WorldBorder border;	
	private static BossBar bar;
	private int taskID = -1;
	private static int playersLeft = 0;
	private static int barTimeInterval = 20;


	private static SpawnPosition p1;
	private static SpawnPosition p2;
	private static SpawnPosition p3;
	private static SpawnPosition p4;
	private static SpawnPosition p5;
	private static SpawnPosition p6;
	private static SpawnPosition p7;
	private static SpawnPosition p8;
	private static SpawnPosition p9;
	private static SpawnPosition p10;

	private static BukkitTask round1;
	private static BukkitTask round2;
	private static BukkitTask round3;
	private static BukkitTask round4;
	private static BukkitTask round5;
	private static BukkitTask round6;

	final static int Time1 = 60;
	final static int Time2 = 50;
	final static int Time3 = 40;
	final static int Time4 = 30;
	final static int Time5 = 30;
	final static int Time6 = 30;

	final static int RingTime1 = 60;
	final static int RingTime2 = 50;
	final static int RingTime3 = 30;
	final static int RingTime4 = 10;
	final static int RingTime5 = 20;

	final static int border1 = 800;
	final static int border2 = 300;
	final static int border3 = 150;
	final static int border4 = 75;
	final static int border5 = 55;
	final static int border6 = 0;

	static Location chest1;
	static Location chest2;
	static Location chest3;
	static Location chest4;
	static Location chest5;
	static Location chest6;
	static Location chest7;
	static Location chest8;
	static Location chest9;
	static Location chest10;
	static Location chest11;
	static Location chest12;
	static Location chest13;
	static Location chest14;
	static Location chest15;
	static Location chest16;
	static Location chest17;
	static Location chest18;
	static Location chest19;
	static Location chest20;
	static Location chest21;
	static Location chest22;
	static Location chest23;
	static Location chest24;
	static Location chest25;
	static Location chest26;
	static Location chest27;
	static Location chest28;
	static Location chest29;
	static Location chest30;
	static ArrayList<Location> chests = new ArrayList<>();



	static Location cp1r1 = null;
	static Location cp2r1 = null;
	static Location cp3r1 = null;
	static Location cp4r1 = null;

	static Location cp1r2 = null;
	static Location cp2r2 = null;
	static Location cp3r2 = null;

	static Location cp1r3 = null;
	static Location cp2r3 = null;

	static Location cp1r4 = null;
	static Location cp2r4 = null;



	public static ItemStack defaultCrossbow = new ItemStack(Material.CROSSBOW);
	public static ItemMeta defaultCrossbowMeta = defaultCrossbow.getItemMeta();

	public static ItemStack defaultBread = new ItemStack(Material.BREAD, 64);
	public static ItemMeta defaultBreadMeta = defaultBread.getItemMeta();

	public static ItemStack defaultSword = new ItemStack(Material.WOODEN_SWORD);
	public static ItemMeta defaultSwordMeta = defaultSword.getItemMeta();

	public static ItemStack defaultFirework = new ItemStack(Material.FIREWORK_ROCKET, 25);
	public static FireworkMeta defaultFireworkMeta = (FireworkMeta) defaultFirework.getItemMeta();

	public static ItemStack defaultGoldenApple = new ItemStack(Material.GOLDEN_APPLE, 2);
	public static ItemMeta defaultGoldenAppleMeta = defaultGoldenApple.getItemMeta();

	public static ItemStack defaultGoldenCarrot = new ItemStack(Material.GOLDEN_CARROT, 1);
	public static ItemMeta defaultGoldenCarrotMeta = defaultGoldenCarrot.getItemMeta();

	public static ItemStack HealthBeacon = new ItemStack(Material.GOLD_BLOCK, 1);
	public static ItemMeta HealthBeaconMeta = HealthBeacon.getItemMeta();



	public static ItemStack rareShortRangeFirework = new ItemStack(Material.FIREWORK_ROCKET, 15);
	public static FireworkMeta rareShortRangeFireworkMeta = (FireworkMeta) rareShortRangeFirework.getItemMeta();

	public static ItemStack rareLongRangeFirework = new ItemStack(Material.FIREWORK_ROCKET, 10);
	public static FireworkMeta rareLongRangeFireworkMeta = (FireworkMeta) rareLongRangeFirework.getItemMeta();

	public static ItemStack EpicShortRangeFirework = new ItemStack(Material.FIREWORK_ROCKET, 5);
	public static FireworkMeta EpicShortRangeFireworkMeta = (FireworkMeta) rareShortRangeFirework.getItemMeta();

	public static ItemStack EpicLongRangeFirework = new ItemStack(Material.FIREWORK_ROCKET, 4);
	public static FireworkMeta EpicLongRangeFireworkMeta = (FireworkMeta) EpicLongRangeFirework.getItemMeta();

	public static ItemStack LegendaryShortRangeFirework = new ItemStack(Material.FIREWORK_ROCKET, 2);
	public static FireworkMeta LegendaryShortRangeFireworkMeta = (FireworkMeta) LegendaryShortRangeFirework.getItemMeta();

	public static ItemStack LegendaryLongRangeFirework = new ItemStack(Material.FIREWORK_ROCKET, 2);
	public static FireworkMeta LegendaryLongRangeFireworkMeta = (FireworkMeta) LegendaryLongRangeFirework.getItemMeta();
	
	public static ItemStack CarePackageLongRangeFirework = new ItemStack(Material.FIREWORK_ROCKET, 2);
	public static FireworkMeta CarePackageLongRangeFireworkMeta = (FireworkMeta) CarePackageLongRangeFirework.getItemMeta();
	
	public static ItemStack CarePackageShortRangeFirework = new ItemStack(Material.FIREWORK_ROCKET, 2);
	public static FireworkMeta CarePackageShortRangeFireworkMeta = (FireworkMeta) CarePackageShortRangeFirework.getItemMeta();
	
	
	
	
	public static ItemStack RareBlastPlate = new ItemStack(Material.IRON_CHESTPLATE, 1);
	public static ItemMeta RareBlastPlateMeta = RareBlastPlate.getItemMeta();
	
	public static ItemStack EpicBlastPlate = new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1);
	public static ItemMeta EpicBlastPlateMeta = EpicBlastPlate.getItemMeta();
	
	public static ItemStack LegendaryBlastPlate = new ItemStack(Material.DIAMOND_CHESTPLATE, 1);
	public static ItemMeta LegendaryBlastPlateMeta = LegendaryBlastPlate.getItemMeta();
	
	public static ItemStack CarePackageBlastPlate = new ItemStack(Material.NETHERITE_CHESTPLATE, 1);
	public static ItemMeta CarePackageBlastPlateMeta = CarePackageBlastPlate.getItemMeta();
	
	
	
	
	
	
	public static ItemStack Emerald = new ItemStack(Material.EMERALD, 1);
	public static ItemMeta EmeraldMeta = Emerald.getItemMeta();
	
	public static ItemStack Gold = new ItemStack(Material.GOLD_INGOT, 1);
	public static ItemMeta GoldMeta = Gold.getItemMeta();
	
	public static ItemStack Diamond = new ItemStack(Material.DIAMOND, 1);
	public static ItemMeta DiamondMeta = Diamond.getItemMeta();
	
	public static ItemStack RedStone = new ItemStack(Material.REDSTONE, 1);
	public static ItemMeta RedstoneMeta = Diamond.getItemMeta();
	
	public static ItemStack Lapis = new ItemStack(Material.LAPIS_LAZULI, 1);
	public static ItemMeta LapisMeta = Lapis.getItemMeta();
	
	
	public static ItemStack EmeraldBlock = new ItemStack(Material.EMERALD_BLOCK, 1);
	public static ItemMeta EmeraldBlockMeta = EmeraldBlock.getItemMeta();
	
	public static ItemStack GoldBlock = new ItemStack(Material.GOLD_BLOCK, 1);
	public static ItemMeta GoldBlockMeta = GoldBlock.getItemMeta();
	
	public static ItemStack DiamondBlock = new ItemStack(Material.DIAMOND_BLOCK, 1);
	public static ItemMeta DiamondBlockMeta = DiamondBlock.getItemMeta();
	
	public static ItemStack RedstoneBlock = new ItemStack(Material.REDSTONE_BLOCK, 1);
	public static ItemMeta RedstoneBlockMeta = RedstoneBlock.getItemMeta();
	
	public static ItemStack LapisBlock = new ItemStack(Material.LAPIS_BLOCK, 1);
	public static ItemMeta LapisBlockMeta = LapisBlock.getItemMeta();
	
	

	
	
	public static ItemStack PopUpWall = new ItemStack(Material.WHITE_WOOL, 1);
	public static ItemMeta PopUpWallMeta = PopUpWall.getItemMeta();
	
	
	public static ItemStack placeholder = new ItemStack(Material.BARRIER, 1);
	public static ItemMeta placeholdermeta = placeholder.getItemMeta();

	private static Location center;
	ArrayList<SpawnPosition> positions = new ArrayList<>();
	public static ArrayList<Player> playersAlive = new ArrayList<>();
	static ArrayList<Item> playerInventory = new ArrayList<>();
	public static ArrayList<BoardPlayer> LeaderBoardPlayers = new ArrayList<>();

	static ArrayList<Loot> HealthLootPool = new ArrayList<>();
	static ArrayList<Loot> WeaponLootPool = new ArrayList<>();
	static ArrayList<Loot> ArmorLootPool = new ArrayList<>();
	static ArrayList<Loot> UtilLootPool = new ArrayList<>();
	static ArrayList<Loot> CraftLootPool = new ArrayList<>();
	static ArrayList<Loot> CarePackageLootPool = new ArrayList<>();
	static ArrayList<Location> garbageList = new ArrayList<>();
	
	static int[] LootPoolRate = {100, 100, 100 , 100, 100};


	public MatchCommands(main main) {
		MatchCommands.main = main;
	}





	@EventHandler
	public static void onPlayerJoin(PlayerJoinEvent event) {		
		Player player =  event.getPlayer();	
		player.sendTitle(ChatColor.translateAlternateColorCodes('&', "&4Welcome to Aragon!"), ChatColor.translateAlternateColorCodes('&', "&fThe happiest place on Earth") , 0, 60, 10);
		if(startGame) {
			player.setGameMode(GameMode.SPECTATOR);
		}		
		BoardPlayer boardplayer = new BoardPlayer(player, 0);
		MatchCommands.LeaderBoardPlayers.add(boardplayer);	
		createBoard(player);
		refreshBoard();
	}


	@EventHandler
	public static void onPlayerLeave(PlayerQuitEvent event) {
		

		for (Iterator<BoardPlayer> itr = LeaderBoardPlayers.iterator(); itr.hasNext();) {
			BoardPlayer next = itr.next();			
			if (next.getPlayer().getDisplayName().equals(event.getPlayer().getDisplayName())){
				itr.remove();
			}					
		}
		LeaderBoardPlayers.trimToSize();

		if(getStartGame()) {
			setPlayersLeft(getPlayersLeft()-1);
			playersAlive.remove(event.getPlayer());
		}
		refreshBoard();
	}






	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if (!(sender instanceof Player)) return true;		

		player = ( Player ) sender;
		world = player.getWorld();
		border =  player.getWorld().getWorldBorder();				
		if (cmd.getName().equalsIgnoreCase("startmatch")) {
			if ( ((player.getDisplayName().equals("DaddyThanosTHICC"))) || ((player.getDisplayName().equals("NinoTheBaker"))) || ((player.getDisplayName().equals("KazooKidFTW")) || (!( sender instanceof Player)))) {
				initializeMatch();
				new BukkitRunnable() {				
					@Override 
					public void run() {						
						setStart(false);
						chooseSpawnPosition();
						clearBlock();
						createChests();						
						fillChests();						
						chooseCenter();
						initializeCarePackages();
						cycle_one();
						startBossBar();
						refreshBoard();
						stunPlayers();			
						addPlayer();
						
					}
				}.runTaskLater(main, 20*5);		
				return true;
			} else {
				return true;
			}
		}
		return true;
	}







	public static void initializeMatch() {		
		initializeItems();
		Location loc = new Location (world, -33, 31, 0);
		for(Player player : Bukkit.getOnlinePlayers()) {
			player.teleport(loc);
			player.setGameMode(GameMode.SURVIVAL);
			player.getInventory().clear();
			player.setHealth(20);
			player.getInventory().addItem(defaultCrossbow);
			player.getInventory().addItem(defaultBread);
			player.getInventory().addItem(defaultSword);
			player.getInventory().setItemInOffHand(defaultFirework);
			ItemStack[] a = player.getInventory().getContents();
			for(int x = 27; x <= 35; x++) {
				a[x] = placeholder;
			}
		}
	}






	public static void initializeItems() {


		defaultCrossbowMeta.setDisplayName(ChatColor.WHITE + "Default Crossbow");
		defaultCrossbowMeta.setUnbreakable(true);
		defaultCrossbow.setItemMeta(defaultCrossbowMeta);		

		List<String> defaultSwordLore = new ArrayList<String>();
		defaultSwordLore.add(ChatColor.WHITE + "Just a normal sword");
		defaultSwordMeta.setLore(defaultSwordLore);
		defaultSwordMeta.setDisplayName(ChatColor.WHITE + "Default Sword");		
		defaultSwordMeta.setUnbreakable(true);
		defaultSword.setItemMeta(defaultSwordMeta);


		List<String> defaultBreadLore = new ArrayList<String>();
		defaultBreadLore.add(ChatColor.BLUE + "Just some normal bread ");
		defaultBreadMeta.setLore(defaultBreadLore);
		defaultBreadMeta.setDisplayName(ChatColor.BLUE + "Normal Bread");
		defaultBread.setItemMeta(defaultBreadMeta);

		List<String> defaultFireworkLore = new ArrayList<String>();
		defaultFireworkMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		defaultFireworkLore.add(ChatColor.BLUE + "Default Fireworks");	
		FireworkEffect defaultFireworkEffect = FireworkEffect.builder().withColor(Color.WHITE).with(Type.BALL).trail(true).build();
		defaultFireworkMeta.addEffect(defaultFireworkEffect);
		defaultFireworkMeta.setDisplayName("Default Fireworks");
		defaultFirework.setItemMeta(defaultFireworkMeta);	 

		List<String> defaultGoldenAppleLore = new ArrayList<String>();
		defaultGoldenAppleLore.add("");
		defaultGoldenAppleLore.add(ChatColor.GREEN + "Instant heal by 2 hearts");
		defaultGoldenAppleLore.add(ChatColor.GREEN + "No effects or saturation");
		defaultGoldenAppleMeta.setLore(defaultGoldenAppleLore);
		defaultGoldenAppleMeta.setDisplayName("Common Syringe");
		defaultGoldenApple.setItemMeta(defaultGoldenAppleMeta);
		setMaxStackSize(Material.GOLDEN_APPLE, 4);

		List<String> defaultGoldenCarrotLore = new ArrayList<String>();
		defaultGoldenCarrotLore.add(ChatColor.GOLD + "5 second usage time");
		defaultGoldenCarrotLore.add(ChatColor.GREEN + "Heals Health Fully");
		defaultGoldenCarrotLore.add(ChatColor.GREEN + "No effects or saturation");
		defaultGoldenCarrotMeta.setLore(defaultGoldenCarrotLore);
		defaultGoldenCarrotMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&b&oCommon Health Kit"));
		defaultGoldenCarrot.setItemMeta(defaultGoldenCarrotMeta);
		setMaxStackSize(Material.GOLDEN_CARROT, 2);

		List<String> HealthBeaconLore = new ArrayList<String>();		
		HealthBeaconLore.add(ChatColor.GOLD + "Heals all players ");
		HealthBeaconLore.add(ChatColor.GOLD + "within a 5 block sphere ");
		HealthBeaconLore.add(ChatColor.GOLD + "for 20 seconds ");
		HealthBeaconMeta.setLore(HealthBeaconLore);
		HealthBeaconMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',"&b&oHealth Beacon"));	
		HealthBeacon.setItemMeta(HealthBeaconMeta);
		setMaxStackSize(Material.GOLD_BLOCK, 1);

		List<String> rareShortRangeFireworkLore = new ArrayList<String>();
		rareShortRangeFireworkMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		rareShortRangeFireworkLore.add("Medium Damage");
		rareShortRangeFireworkLore.add("Short Range");
		FireworkEffect rareShortRangeFireworkEffect = FireworkEffect.builder().withColor(Color.BLUE).with(Type.BALL_LARGE).trail(true).build();		
		rareShortRangeFireworkMeta.addEffect(rareShortRangeFireworkEffect);
		rareShortRangeFireworkMeta.setPower(1);
		rareShortRangeFireworkMeta.setLore(rareShortRangeFireworkLore);
		rareShortRangeFireworkMeta.setDisplayName(ChatColor.BLUE + "Rare Short Range Firework" );			
		rareShortRangeFirework.setItemMeta(rareShortRangeFireworkMeta);


		List<String> rareLongRangeFireworkLore = new ArrayList<String>();
		rareLongRangeFireworkMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		rareLongRangeFireworkLore.add("Small Damage");
		rareLongRangeFireworkLore.add("Long Range");
		rareLongRangeFireworkLore.add("Medium Speed");
		FireworkEffect rareLongRangeFireworkEffect = FireworkEffect.builder().withColor(Color.BLUE).with(Type.STAR).trail(true).build();		
		rareLongRangeFireworkMeta.addEffect(rareLongRangeFireworkEffect);
		rareLongRangeFireworkMeta.setPower(3);		
		rareLongRangeFireworkMeta.setLore(rareLongRangeFireworkLore);
		rareLongRangeFireworkMeta.setDisplayName(ChatColor.BLUE + "Rare Long Range Firework" );			
		rareLongRangeFirework.setItemMeta(rareLongRangeFireworkMeta);


		List<String> EpicShortRangeFireworkLore = new ArrayList<String>();
		EpicShortRangeFireworkLore.add(ChatColor.DARK_PURPLE + "High Damage");
		EpicShortRangeFireworkLore.add(ChatColor.DARK_PURPLE + "Short Range");
		FireworkEffect EpicShortRangeFireworkEffect = FireworkEffect.builder().withColor(Color.PURPLE).with(Type.BALL_LARGE).trail(true).build();			
		EpicShortRangeFireworkMeta.addEffect(EpicShortRangeFireworkEffect);
		EpicShortRangeFireworkMeta.setPower(1);
		EpicShortRangeFireworkMeta.setLore(EpicShortRangeFireworkLore);
		EpicShortRangeFireworkMeta.setDisplayName(ChatColor.DARK_PURPLE + "Epic Short Range Firework" );			
		EpicShortRangeFirework.setItemMeta(EpicShortRangeFireworkMeta);


		List<String> EpicLongRangeFireworkLore = new ArrayList<String>();
		EpicLongRangeFireworkLore.add(ChatColor.DARK_PURPLE +"Medium Damage");
		EpicLongRangeFireworkLore.add(ChatColor.DARK_PURPLE +"Long Range");
		EpicLongRangeFireworkLore.add(ChatColor.DARK_PURPLE +"High Speed");
		FireworkEffect EpicLongRangeFireworkEffect = FireworkEffect.builder().withColor(Color.PURPLE).with(Type.STAR).trail(true).build();	
		EpicLongRangeFireworkMeta.addEffect(EpicLongRangeFireworkEffect);
		EpicLongRangeFireworkMeta.setPower(4);
		EpicLongRangeFireworkMeta.setLore(EpicLongRangeFireworkLore);
		EpicLongRangeFireworkMeta.setDisplayName(ChatColor.DARK_PURPLE + "Epic Long Range Firework" );			
		EpicLongRangeFirework.setItemMeta(EpicLongRangeFireworkMeta);


		List<String> LegendaryShortRangeFireworkLore = new ArrayList<String>();
		LegendaryShortRangeFireworkLore.add(ChatColor.GOLD +"Very High Damage");
		LegendaryShortRangeFireworkLore.add(ChatColor.GOLD+"Medium Range");
		FireworkEffect LegendaryShortRangeFireworkEffect = FireworkEffect.builder().withColor(Color.ORANGE).with(Type.BALL_LARGE).withColor(Color.RED).with(Type.BALL_LARGE).trail(true).build();		
		LegendaryShortRangeFireworkMeta.addEffect(LegendaryShortRangeFireworkEffect);
		LegendaryShortRangeFireworkMeta.setPower(2);
		LegendaryShortRangeFireworkMeta.setLore(LegendaryShortRangeFireworkLore);
		LegendaryShortRangeFireworkMeta.addEnchant(Enchantment.LUCK, 1, true);
		LegendaryShortRangeFireworkMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		LegendaryShortRangeFireworkMeta.setDisplayName(ChatColor.GOLD + "Legendary Short Range Firework" );			
		LegendaryShortRangeFirework.setItemMeta(LegendaryShortRangeFireworkMeta);


		List<String> LegendaryLongRangeFireworkLore = new ArrayList<String>();
		LegendaryLongRangeFireworkLore.add(ChatColor.GOLD +"High Damage");
		LegendaryLongRangeFireworkLore.add(ChatColor.GOLD +"Long Range");
		LegendaryLongRangeFireworkLore.add(ChatColor.GOLD +"Very High Speed");
		//FireworkEffect LegendaryLongRangeFireworkEffect = FireworkEffect.builder().withColor(Color.BLACK).with(Type.STAR).withColor(Color.RED).with(Type.STAR).withColor(Color.WHITE).with(Type.STAR).trail(true).build();	
		FireworkEffect LegendaryLongRangeFireworkEffect = FireworkEffect.builder().withColor(Color.ORANGE).with(Type.STAR).withColor(Color.RED).with(Type.STAR).trail(true).build();
		LegendaryLongRangeFireworkMeta.addEffect(LegendaryLongRangeFireworkEffect);
		LegendaryLongRangeFireworkMeta.setPower(4);
		LegendaryLongRangeFireworkMeta.setLore(LegendaryLongRangeFireworkLore);
		LegendaryLongRangeFireworkMeta.addEnchant(Enchantment.LUCK, 1, true);
		LegendaryLongRangeFireworkMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		LegendaryLongRangeFireworkMeta.setDisplayName(ChatColor.GOLD + "Legendary Long Range Firework" );			
		LegendaryLongRangeFirework.setItemMeta(LegendaryLongRangeFireworkMeta);
		
		
		
		
		List<String> CarePackageLongRangeFireworkLore = new ArrayList<String>();
		CarePackageLongRangeFireworkLore.add(ChatColor.GOLD +"Very High Damage");
		CarePackageLongRangeFireworkLore.add(ChatColor.GOLD +"Long Range");
		CarePackageLongRangeFireworkLore.add(ChatColor.GOLD +"Very High Speed");
		FireworkEffect CarePackageLongRangeFireworkEffect = FireworkEffect.builder().withColor(Color.BLACK).with(Type.STAR).withColor(Color.RED).with(Type.STAR).withColor(Color.WHITE).with(Type.STAR).trail(true).build();		
		CarePackageLongRangeFireworkMeta.addEffect(CarePackageLongRangeFireworkEffect);
		CarePackageLongRangeFireworkMeta.setPower(4);
		CarePackageLongRangeFireworkMeta.setLore(CarePackageLongRangeFireworkLore);
		CarePackageLongRangeFireworkMeta.addEnchant(Enchantment.LUCK, 1, true);
		CarePackageLongRangeFireworkMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		CarePackageLongRangeFireworkMeta.setDisplayName(ChatColor.GOLD + "Megumin's Long Range Bakuretsu" );			
		CarePackageLongRangeFirework.setItemMeta(CarePackageLongRangeFireworkMeta);
		
		
		
		
		List<String> CarePackageShortRangeFireworkLore = new ArrayList<String>();
		CarePackageShortRangeFireworkLore.add(ChatColor.GOLD +"High Damage");
		CarePackageShortRangeFireworkLore.add(ChatColor.GOLD +"Short Range");
		CarePackageShortRangeFireworkLore.add(ChatColor.GOLD +"Very High Speed");
		FireworkEffect CarePackageShortRangeFireworkEffect = FireworkEffect.builder().withColor(Color.BLACK).with(Type.STAR).withColor(Color.RED).with(Type.STAR).withColor(Color.WHITE).with(Type.BALL_LARGE).trail(true).build();	
		
		CarePackageShortRangeFireworkMeta.addEffect(CarePackageShortRangeFireworkEffect);
		CarePackageShortRangeFireworkMeta.setPower(2);
		CarePackageShortRangeFireworkMeta.setLore(CarePackageShortRangeFireworkLore);
		CarePackageShortRangeFireworkMeta.addEnchant(Enchantment.LUCK, 1, true);
		CarePackageShortRangeFireworkMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		CarePackageShortRangeFireworkMeta.setDisplayName(ChatColor.GOLD + "Megumin's Short Range Bakuretsu" );			
		CarePackageShortRangeFirework.setItemMeta(CarePackageShortRangeFireworkMeta);






		
		
		
		
		List<String> RareBlastPlateLore = new ArrayList<String>();
		RareBlastPlateLore.add(ChatColor.BLUE + "Minimal Explosive Protection");
		RareBlastPlateMeta.setDisplayName(ChatColor.BLUE + "Rare Blast Plate");
		RareBlastPlateMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		RareBlastPlateMeta.setLore(RareBlastPlateLore);
		RareBlastPlate.setItemMeta(RareBlastPlateMeta);
		
		
		
		List<String> EpicBlastPlateLore = new ArrayList<String>();
		EpicBlastPlateLore.add(ChatColor.DARK_PURPLE + "Moderate Explosive Protection");
		EpicBlastPlateMeta.setDisplayName(ChatColor.DARK_PURPLE + "Epic Blast Plate");
		EpicBlastPlateMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		EpicBlastPlateMeta.setLore(EpicBlastPlateLore);
		EpicBlastPlate.setItemMeta(EpicBlastPlateMeta);
		
		
		List<String> LegendaryBlastPlateLore = new ArrayList<String>();
		LegendaryBlastPlateLore.add(ChatColor.GOLD + "High Explosive Protection");
		LegendaryBlastPlateMeta.setDisplayName(ChatColor.GOLD + "Legendary Blast Plate");
		LegendaryBlastPlateMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		LegendaryBlastPlateMeta.setLore(LegendaryBlastPlateLore);
		LegendaryBlastPlate.setItemMeta(LegendaryBlastPlateMeta);
		

		List<String> CarePackageBlastPlateLore = new ArrayList<String>();
		CarePackageBlastPlateLore.add(ChatColor.DARK_RED + "Very High Explosive Protection");
		CarePackageBlastPlateMeta.setDisplayName(ChatColor.DARK_RED+ "Ara Ara Protection");
		CarePackageBlastPlateMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		CarePackageBlastPlateMeta.setLore(CarePackageBlastPlateLore);
		CarePackageBlastPlate.setItemMeta(CarePackageBlastPlateMeta);
		





		
		
		
		
		
		
		
		List<String> EmeraldLore = new ArrayList<String>();
		EmeraldLore.add(ChatColor.GOLD + "Add to unenchanted armor" );
		EmeraldLore.add(ChatColor.GOLD + "to add protection 1" );
		EmeraldMeta.setDisplayName("Protection Jewl");
		EmeraldMeta.setLore(EmeraldLore);
		Emerald.setItemMeta(EmeraldMeta);
		setMaxStackSize(Material.EMERALD, 1);
		
		List<String> GoldLore = new ArrayList<String>();
		GoldLore.add(ChatColor.GOLD + "Add to unenchanted armor" );
		GoldLore.add(ChatColor.GOLD + "to add thorns 1" );
		GoldMeta.setDisplayName("Thorns Jewl");
		GoldMeta.setLore(GoldLore);
		Gold.setItemMeta(GoldMeta);
		setMaxStackSize(Material.GOLD_INGOT, 1);
		
		
		List<String> DiamondLore = new ArrayList<String>();
		DiamondLore.add(ChatColor.GOLD + "Add to unenchanted armor" );
		DiamondLore.add(ChatColor.GOLD + "to add protection 1 and" );
		DiamondLore.add(ChatColor.GOLD + "10% Explosion Resistance" );
		DiamondMeta.setDisplayName(ChatColor.GOLD + "Combat Jewl");
		DiamondMeta.setLore(DiamondLore);
		Diamond.setItemMeta(DiamondMeta);
		setMaxStackSize(Material.DIAMOND, 1);



		List<String> RedstoneLore = new ArrayList<String>();
		RedstoneLore.add(ChatColor.GOLD + "Add to unenchanted crossbow" );
		RedstoneLore.add(ChatColor.GOLD + "for moderate reload time" );
		RedstoneLore.add(ChatColor.GOLD + "reduction" );
		RedstoneMeta.setDisplayName("Fast Hands Jewl");
		RedstoneMeta.setLore(RedstoneLore);
		RedStone.setItemMeta(RedstoneMeta);
		setMaxStackSize(Material.REDSTONE, 1);


		
		List<String> LapisLore = new ArrayList<String>();
		LapisLore.add(ChatColor.GOLD + "Add to unenchanted crossbow" );
		LapisLore.add(ChatColor.GOLD + "for multiple projectiles " );
		LapisLore.add(ChatColor.GOLD + "to be fired at a time" );
		LapisMeta.setDisplayName("Multiplier Jewl");
		LapisMeta.setLore(LapisLore);
		Lapis.setItemMeta(LapisMeta);
		setMaxStackSize(Material.LAPIS_LAZULI, 1);

		
		
		List<String> EmeraldBlockLore = new ArrayList<String>();
		EmeraldBlockLore.add(ChatColor.DARK_RED + "Add to unenchanted armor" );
		EmeraldBlockLore.add(ChatColor.DARK_RED+ "to add max protection" );
		EmeraldBlockMeta.setDisplayName("Protection Material");
		EmeraldBlockMeta.setLore(EmeraldBlockLore);
		EmeraldBlockMeta.addEnchant(Enchantment.LUCK, 1, true);
		EmeraldBlockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		EmeraldBlock.setItemMeta(EmeraldBlockMeta);
		setMaxStackSize(Material.EMERALD_BLOCK, 1);
		
		List<String> GoldBlockLore = new ArrayList<String>();
		GoldBlockLore.add(ChatColor.DARK_RED + "Add to unenchanted armor" );
		GoldBlockLore.add(ChatColor.DARK_RED + "to add max thorns" );
		GoldBlockMeta.setDisplayName("Thorns Material");
		GoldBlockMeta.setLore(GoldBlockLore);
		GoldBlockMeta.addEnchant(Enchantment.LUCK, 1, true);
		GoldBlockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		GoldBlock.setItemMeta(GoldBlockMeta);
		setMaxStackSize(Material.GOLD_BLOCK, 1);
		
		
		List<String> DiamondBlockLore = new ArrayList<String>();
		DiamondBlockLore.add(ChatColor.DARK_RED + "Add to unenchanted armor" );
		DiamondBlockLore.add(ChatColor.DARK_RED + "to add max protection and" );
		DiamondBlockLore.add(ChatColor.DARK_RED + "35% Explosion Resistance" );
		DiamondBlockMeta.setDisplayName("Combat Material");
		DiamondBlockMeta.setLore(DiamondBlockLore);
		DiamondBlockMeta.addEnchant(Enchantment.LUCK, 1, true);
		DiamondBlockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		DiamondBlock.setItemMeta(DiamondBlockMeta);
		setMaxStackSize(Material.DIAMOND_BLOCK, 1);



		List<String> RedstoneBlockLore = new ArrayList<String>();
		RedstoneBlockLore.add(ChatColor.DARK_RED + "Add to unenchanted crossbow" );
		RedstoneBlockLore.add(ChatColor.DARK_RED + "for high reload time" );
		RedstoneBlockLore.add(ChatColor.DARK_RED + "reduction" );
		RedstoneBlockMeta.setDisplayName("Fast Hands Material");
		RedstoneBlockMeta.addEnchant(Enchantment.LUCK, 1, true);
		RedstoneBlockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		RedstoneBlockMeta.setLore(RedstoneBlockLore);
		RedstoneBlock.setItemMeta(RedstoneBlockMeta);
		setMaxStackSize(Material.REDSTONE_BLOCK, 1);


		
		List<String> LapisBlockLore = new ArrayList<String>();
		LapisBlockLore.add(ChatColor.DARK_RED + "Add to unenchanted crossbow" );
		LapisBlockLore.add(ChatColor.DARK_RED + "for multiple projectiles " );
		LapisBlockLore.add(ChatColor.DARK_RED + "to be fired at a time" );
		LapisBlockMeta.setDisplayName("Multiplier Jewl");
		LapisBlockMeta.addEnchant(Enchantment.LUCK, 1, true);
		LapisBlockMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		LapisBlockMeta.setLore(LapisBlockLore);
		LapisBlock.setItemMeta(LapisBlockMeta);
		setMaxStackSize(Material.LAPIS_BLOCK, 1);





		
		
		List<String> PopUpWallLore = new ArrayList<String>();
		PopUpWallLore.add(ChatColor.GOLD + "Place to create a ");
		PopUpWallLore.add(ChatColor.GOLD + "barrier for 10 seconds ");
		PopUpWallMeta.setLore(PopUpWallLore);
		PopUpWallMeta.addEnchant(Enchantment.ARROW_DAMAGE, 1,true);
		PopUpWallMeta.setDisplayName("Popup Tower");
		PopUpWallMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		PopUpWall.setItemMeta(PopUpWallMeta);
		setMaxStackSize(Material.WHITE_WOOL, 1);
		
		
		
		
		
		placeholdermeta.setDisplayName(ChatColor.RED + "This Slot Cannot Be Used");
		placeholder.setItemMeta(placeholdermeta);
		



		HealthLootPool.add(new Loot(HealthBeacon, 10));
		HealthLootPool.add(new Loot(defaultGoldenApple, 40));
		HealthLootPool.add(new Loot(defaultGoldenCarrot, 20));
		
		
		
		CraftLootPool.add(new Loot(Emerald,100));
		CraftLootPool.add(new Loot(Gold,100));
		CraftLootPool.add(new Loot(Diamond,100));
		CraftLootPool.add(new Loot(RedStone,100));
		CraftLootPool.add(new Loot(Lapis,100));
		CraftLootPool.add(new Loot(EmeraldBlock,100));
		CraftLootPool.add(new Loot(GoldBlock,100));
		CraftLootPool.add(new Loot(DiamondBlock,100));
		CraftLootPool.add(new Loot(RedstoneBlock,100));
		CraftLootPool.add(new Loot(LapisBlock,100));
		
		
		WeaponLootPool.add(new Loot(defaultFirework, 50));
		WeaponLootPool.add(new Loot(rareShortRangeFirework, 30));
		WeaponLootPool.add(new Loot(rareLongRangeFirework, 28));
		WeaponLootPool.add(new Loot(EpicShortRangeFirework, 20));
		WeaponLootPool.add(new Loot(EpicLongRangeFirework, 18));
		WeaponLootPool.add(new Loot(LegendaryShortRangeFirework, 8));
		WeaponLootPool.add(new Loot(LegendaryLongRangeFirework, 7));
		WeaponLootPool.add(new Loot(CarePackageLongRangeFirework, 3));
		WeaponLootPool.add(new Loot(CarePackageShortRangeFirework, 3));
		

		ArmorLootPool.add(new Loot(RareBlastPlate,50));
		ArmorLootPool.add(new Loot(EpicBlastPlate,50));
		ArmorLootPool.add(new Loot(LegendaryBlastPlate,50));
		ArmorLootPool.add(new Loot(CarePackageBlastPlate,50));
		
		
		
		UtilLootPool.add(new Loot(PopUpWall, 100));

	}


	public static void setMaxStackSize(Material m, int amount) {
		try {
			String packageVersion = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
			Class<?> magicClass = Class.forName("org.bukkit.craftbukkit." + packageVersion + ".util.CraftMagicNumbers");
			Method method = magicClass.getDeclaredMethod("getItem", Material.class);
			Object item = method.invoke(null, m);
			Class<?> itemClass = Class.forName("net.minecraft.server." + packageVersion + ".Item");
			Field field = itemClass.getDeclaredField("maxStackSize");
			field.setAccessible(true);
			field.setInt(item, amount);
			Field mf = Material.class.getDeclaredField("maxStack");
			mf.setAccessible(true);
			mf.setInt(m, amount);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}





	public void startBossBar() {
		createBar("Round 1", BarColor.GREEN, BarStyle.SOLID);
		setTaskID(Bukkit.getScheduler().scheduleSyncRepeatingTask(main, new Runnable () {	
			int count = -1;
			int counter = Time2 - 1;			
			double progress = 1.0;
			double time = 1.0 / (Time1 - 1);

			@Override		
			public void run() {

				bar.setProgress(progress);	

				switch(count) {
				case -1:
					break;
				case 0:
					bar.setColor(BarColor.RED);
					bar.setTitle("Circle Closing");
					break;
				case 1:
					bar.setColor(BarColor.GREEN);
					bar.setTitle("Round 2 in " + counter);
					counter--;
					break;
				case 2:
					bar.setColor(BarColor.RED);
					bar.setTitle("Circle Closing");
					break;
				case 3:
					bar.setColor(BarColor.GREEN);
					bar.setTitle("Round 3 in " + counter);
					counter--;
					break;
				case 4:
					bar.setColor(BarColor.RED);
					bar.setTitle("Circle Closing");
					break;
				case 5:
					bar.setColor(BarColor.GREEN);
					bar.setTitle("Round 4 in " + counter);
					counter--;
					break;
				case 6:
					bar.setColor(BarColor.RED);
					bar.setTitle("Circle Closing");
					break;
				case 7:
					bar.setColor(BarColor.GREEN);
					bar.setTitle("Final Round in " + counter);
					counter--;
					break;
				case 8:
					bar.setColor(BarColor.RED);
					bar.setTitle("Final Round Closing");
					break;					
				}
				progress = progress - time;
				if ( progress <= 0) {
					count++;
					bar.setProgress(1.0);
					progress = 1.0;
					switch(count) {
					case 0: 
						time = 1.0 / (RingTime1 + 1);
						break;
					case 1:
						time = 1.0 / (Time2 - 1);
						break;
					case 2:
						time = 1.0 / (RingTime2 + 1);
						counter = Time3 - 1;                                
						break;
					case 3:
						time = 1.0 / (Time3 - 1);
						break;
					case 4:
						time = 1.0 / (RingTime3 + 1);
						counter = Time4 -1;
						break;
					case 5:
						time = 1.0 / (Time4 - 1);
						break;
					case 6:
						time = 1.0 / (RingTime4 + 1);
						counter = Time5 -1;
						break;						
					case 7:
						time = 1.0 / (Time5 - 1);
						break;
					case 8:
						time = 1.0 / (RingTime5 + 1);
						break;
					}
				}
			}			
		}, 0, barTimeInterval ));										
	}





	public void stunPlayers() {
		sendServermessage(ChatColor.RED, "Don't move until the match starts!");
		sendServerTitle("5", 1, 'c');
		new BukkitRunnable() {
			@Override
			public void run() {
				setStart(true);
				setStartGame(true);
				refreshBoard();
				sendServermessage(ChatColor.GREEN, "MATCH STARTED");
			}
		}.runTaskLater(main, 20 * 5);

		new BukkitRunnable() {
			@Override
			public void run() {
				sendServerTitle("4", 1, 'c');
			}
		}.runTaskLater(main, 20);

		new BukkitRunnable() {
			@Override
			public void run() {
				sendServerTitle("3", 1, 'c');
			}
		}.runTaskLater(main, 20 * 2);

		new BukkitRunnable() {
			@Override
			public void run() {
				sendServerTitle("2", 1, 'c');
			}
		}.runTaskLater(main, 20 * 3);

		new BukkitRunnable() {
			@Override
			public void run() {
				sendServerTitle("1", 1, 'c');
			}
		}.runTaskLater(main, 20 * 4);

		new BukkitRunnable() {
			@Override
			public void run() {
				sendServerTitle("GO!", 1, 'a' );
				playLightningEffect();
			}
		}.runTaskLater(main, 20 * 5);

	}




	public static void sendServerTitle(String string, int duration, char color) {
		for(Player player : Bukkit.getOnlinePlayers()) {

			string = "&" + String.valueOf(color) +  string;
			String fstring = ChatColor.translateAlternateColorCodes('&', string);
			player.sendTitle(fstring, "", 0, duration * 20 , 0 );
		}
	}






	public static void createBoard(Player player) {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		String title;
		if(getStartGame()) {
			title = "&4&l<< Score Board &4&l>>";

		} else {
			title =  "&a&l<< &2Players Online &a>>";
		}
		Objective objective = board.registerNewObjective("MatchCommands-1","dummy", ChatColor.translateAlternateColorCodes('&', title) );
		objective.setDisplaySlot(DisplaySlot.SIDEBAR);	
		for(BoardPlayer player1 : LeaderBoardPlayers) {			 			 
			Score score1 = objective.getScore(ChatColor.GOLD + player1.getPlayer().getDisplayName());
			score1.setScore(player1.getScore());		 
		}
		player.setScoreboard(board);
	}




	public static void sendServerTitle(String string, int duration, int color) {
		for(Player player : Bukkit.getOnlinePlayers()) {

			string = "&" + String.valueOf(color) +  string;
			String fstring = ChatColor.translateAlternateColorCodes('&', string);
			player.sendTitle(fstring, "", 0, duration * 20 , 0 );
		}
	}

	public static void sendServerTitle(String string, String sub, int duration, char color) {
		for(Player player : Bukkit.getOnlinePlayers()) {

			string = "&" + String.valueOf(color) +  string;
			sub = "&" + String.valueOf(color) +  sub;
			String fstring = ChatColor.translateAlternateColorCodes('&', string);
			String fsub = ChatColor.translateAlternateColorCodes('&', sub);
			player.sendTitle(fstring, fsub, 0, duration * 20 , 0 );
		}
	}

	public static void sendServerTitle(String string, String sub, int duration, int color) {
		for(Player player : Bukkit.getOnlinePlayers()) {

			string = "&" + String.valueOf(color) +  string;
			sub = "&" + String.valueOf(color) +  sub;
			String fstring = ChatColor.translateAlternateColorCodes('&', string);
			String fsub = ChatColor.translateAlternateColorCodes('&', sub);
			player.sendTitle(fstring, fsub, 0, duration * 20 , 0 );
		}
	}

	public static void sendServerTitle(String string, String sub, int duration, int fade, char color) {
		for(Player player : Bukkit.getOnlinePlayers()) {

			string = "&" + String.valueOf(color) +  string;
			sub = "&" + String.valueOf(color) +  sub;
			String fstring = ChatColor.translateAlternateColorCodes('&', string);
			String fsub = ChatColor.translateAlternateColorCodes('&', sub);
			player.sendTitle(fstring, fsub, 0, duration * 20 , fade * 20 );
		}
	}

	public static void sendServerTitle(String string, String sub, int duration, int fade, int color) {
		for(Player player : Bukkit.getOnlinePlayers()) {

			string = "&" + String.valueOf(color) +  string;
			sub = "&" + String.valueOf(color) +  sub;
			String fstring = ChatColor.translateAlternateColorCodes('&', string);
			String fsub = ChatColor.translateAlternateColorCodes('&', sub);
			player.sendTitle(fstring, fsub, 0, duration * 20 , fade * 20 );
		}
	}

	public void chooseCenter() {

		Location c1 = new Location(world, 105, 0, -140);
		Location c2 = new Location(world, -22, 0, 68);
		Location c3 = new Location(world, -125, 0, -9);
		Location c4 = new Location(world, -63, 0, -170);
		Location c5 = new Location(world, 119, 0, 64);
		Location c6 = new Location(world, 155, 0, -19);
		Location c7 = new Location(world, 147, 0, -58);
		Location c8 = new Location(world, -42, 0, -15);
		Location c9 = new Location(world, 0,0,0);

		ArrayList<Location> locations = new ArrayList<>();
		locations.add(c1);
		locations.add(c2);
		locations.add(c3);
		locations.add(c4);
		locations.add(c5);
		locations.add(c6);
		locations.add(c7);
		locations.add(c8);
		locations.add(c9);

		Collections.shuffle(locations);
		center = locations.get(5);

	}








	public void chooseSpawnPosition() {
		p1 = new SpawnPosition(world, -85, 25, 35, true);
		p2 = new SpawnPosition(world, 39, 16, -27, true);
		p3 = new SpawnPosition(world, -156, 18, -12, true);
		p4 = new SpawnPosition(world, 27, 25, 38, true);
		p5 = new SpawnPosition(world, 77, 25, 8, true);
		p6 = new SpawnPosition(world, 8, 25, 96, true);
		p7 = new SpawnPosition(world, -120, 25, 99, true);
		p8 = new SpawnPosition(world, 43, 10, -107, true);
		p9 = new SpawnPosition(world, 12, 11, -91, true);
		p10 = new SpawnPosition(world, -56, 14, -81, false);	

		positions.add(p1);
		positions.add(p2);
		positions.add(p3);
		positions.add(p4);
		positions.add(p5);
		positions.add(p6);
		positions.add(p7);
		positions.add(p8);
		positions.add(p9);
		positions.add(p10);
		Collections.shuffle(positions);

		int counter = 0;
		for (Player player : Bukkit.getOnlinePlayers()) {
			player.teleport(positions.get(counter).getLocation());
			player.setHealth(20);
			player.setSaturation(20);			
			MatchCommands.playersAlive.add(player);
			setPlayersLeft(getPlayersLeft() + 1);
			counter++;						
		}
	}







	public BossBar getBar() {
		return bar;
	}







	public void addPlayer() {  	
		for ( Player player : Bukkit.getOnlinePlayers()) {			
			bar.addPlayer(player);
		}    		
	}







	public void createBar(String string, BarColor color, BarStyle style) {
		player.sendMessage(string);
		bar = Bukkit.createBossBar(format(string), color, style);
		bar.setVisible(true);
	}







	private String format(String string) {
		string = "&c" + string;
		return ChatColor.translateAlternateColorCodes('&', string);
	}







	@EventHandler
	public void onPlayerInteract(final PlayerInteractEvent event) {
		if(event.getPlayer() != null && event != null && event.getAction() != null) {
		final Player player =  event.getPlayer();
		if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {

					
				if (event.getPlayer().getInventory().getItemInMainHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',"&b&oCommon Health Kit"))) {
					if(player.getFoodLevel() >= 20) {
						player.setFoodLevel(19);
						Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
							public void run() {
								player.setFoodLevel(20);
							}
						}, 1L);
					}
				}  
			}	
		}
		}
	






	@EventHandler 
	public void onDamage(EntityDamageEvent event) {	
		if(getStartGame()){	
			
			if(event.getCause() == DamageCause.SUFFOCATION) {

				if ((player.getHealth() - event.getFinalDamage()) <= 0) {

					setPlayersLeft(getPlayersLeft() - 1);
					killPlayer(player);
					event.setCancelled(true);											
					sendServermessage(ChatColor.BLUE + player.getDisplayName() + ChatColor.WHITE + " died to the " + ChatColor.DARK_RED + "The Storm");																						
				}					
			}
			
			if (event instanceof EntityDamageByEntityEvent) {							
				Player player = (Player) event.getEntity();
				event = (EntityDamageByEntityEvent) event;
				



				if(event.getCause() == DamageCause.ENTITY_ATTACK || event.getCause() == DamageCause.ENTITY_SWEEP_ATTACK) {

					Player p = (Player) ((EntityDamageByEntityEvent) event).getDamager();
					if ((player.getHealth() - event.getFinalDamage()) <= 0) {

						setPlayersLeft(getPlayersLeft() - 1);
						killPlayer(player);
						for(BoardPlayer player1 : LeaderBoardPlayers) {
							if(player1.getPlayer().getDisplayName().equals(p.getDisplayName())) {
								player1.incrementScore();	
								refreshBoard();
							}
						}
						event.setCancelled(true);					
						sendServermessage(ChatColor.BLUE + player.getDisplayName() + ChatColor.WHITE +  " was hacked to oblivion by " + ChatColor.DARK_RED + p.getDisplayName());					

					}




				} else if(event.getCause() == DamageCause.PROJECTILE) {	

					Arrow projectile = (Arrow)  ((EntityDamageByEntityEvent) event).getDamager();
					Player p = (Player) projectile.getShooter();

					if ((player.getHealth() - event.getFinalDamage()) <= 0) {

						setPlayersLeft(getPlayersLeft() - 1);
						killPlayer(player);
						for(BoardPlayer player1 : LeaderBoardPlayers) {
							if(player1.getPlayer().getDisplayName().equals(p.getDisplayName())) {
								player1.incrementScore();	
								refreshBoard();
							}
						}
						event.setCancelled(true);											
						sendServermessage(ChatColor.BLUE + player.getDisplayName() + ChatColor.WHITE + " witnessed the good aim of " + ChatColor.DARK_RED + p.getDisplayName());										

					}



				} else if(event.getCause() == DamageCause.ENTITY_EXPLOSION) {
					event.setCancelled(true);					

				}

			} else if(event.getCause() == DamageCause.FALL) {
				if(player.getGameMode() == GameMode.SURVIVAL) {

				if ((player.getHealth() - event.getFinalDamage()) <= 0) {

					setPlayersLeft(getPlayersLeft() - 1);
					killPlayer(player);
					event.setCancelled(true);											
					sendServermessage(ChatColor.BLUE + player.getDisplayName() + ChatColor.WHITE + " forgot they couldn't fly ");										


				}
				}

			} else if(event.getCause() == DamageCause.DROWNING) {

				if ((player.getHealth() - event.getFinalDamage()) <= 0) {

					setPlayersLeft(getPlayersLeft() - 1);
					killPlayer(player);
					event.setCancelled(true);											
					sendServermessage(ChatColor.BLUE + player.getDisplayName() + ChatColor.WHITE + " swam for too long ");										


				}

			} else if(event.getCause() == DamageCause.STARVATION) {


				if ((player.getHealth() - event.getFinalDamage()) <= 0) {

					setPlayersLeft(getPlayersLeft() - 1);
					killPlayer(player);
					event.setCancelled(true);											
					sendServermessage(ChatColor.BLUE + player.getDisplayName() + ChatColor.WHITE + " had a bad diet ");										


				}

			} else if(event.getCause() == DamageCause.FIRE) {


				if ((player.getHealth() - event.getFinalDamage()) <= 0) {

					setPlayersLeft(getPlayersLeft() - 1);
					killPlayer(player);
					event.setCancelled(true);											
					sendServermessage(ChatColor.BLUE + player.getDisplayName() + ChatColor.WHITE + " was grilled ");										


				}


			} else if(event.getCause() == DamageCause.LAVA) {


				if ((player.getHealth() - event.getFinalDamage()) <= 0) {

					setPlayersLeft(getPlayersLeft() - 1);
					killPlayer(player);
					event.setCancelled(true);											
					sendServermessage(ChatColor.BLUE + player.getDisplayName() + ChatColor.WHITE + " drank some spicy lava ");										


				}
			} 			
		}		
	}






	@EventHandler
	public void onFireworkExplode(FireworkExplodeEvent event) {

		Location location = event.getEntity().getLocation();
		Player p = (Player) event.getEntity().getShooter();	
		ItemMeta meta = event.getEntity().getFireworkMeta();
		
		if(meta.getDisplayName().equalsIgnoreCase("default fireworks")){
			inflictFireworkDamage(location, 1.5, 5, p);

		} else if(meta.getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',"&9Rare Short Range Firework"))) {
			inflictFireworkDamage(location, 2.5, 5, p);

		} else if(meta.getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',"&9Rare Long Range Firework"))) {
			inflictFireworkDamage(location, 1.5, 5, p);

		} else if(meta.getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',"&5Epic Short Range Firework"))) {
			inflictFireworkDamage(location, 3.5, 6, p);

		} else if(meta.getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',"&5Epic Long Range Firework"))) {			
			inflictFireworkDamage(location, 2.5, 7, p);	

		}else if(meta.getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',"&6Legendary Short Range Firework"))) {
			inflictFireworkDamage(location, 4.5, 7, p);	

		}else if(meta.getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',"&6Legendary long Range Firework"))) {
			inflictFireworkDamage(location, 3.5, 9, p);	

		}

	}

	
	
	
	

	public void inflictFireworkDamage(Location location, double damage, int range, Player p) {
		for(Player player : playersAlive) {
			double location2 = location.distance(player.getLocation());
			if(location2 <= range && (!(player.getDisplayName().equals(p.getDisplayName())))) {
				if (select(location, player.getLocation(), world)) {
					Random randomGenerator = new Random();
					double rd = 2 * (damage + randomGenerator.nextDouble());
					rd = handleArmorDamage(rd);
					if ((player.getHealth() - rd) <= 0) {

						for(BoardPlayer player1 : LeaderBoardPlayers) {
							if(player1.getPlayer().getDisplayName().equals(p.getDisplayName())) {
								player1.incrementScore();	
								sendServermessage(ChatColor.BLUE + player.getDisplayName() + ChatColor.WHITE + " was blasted by " + ChatColor.DARK_RED + p.getDisplayName());
								refreshBoard();
							}
						}					
						setPlayersLeft(getPlayersLeft() - 1);					
						killPlayer(player);					
					} else { 
						player.setHealth(player.getHealth() - rd);					
					}	
				}
			}
		}
	}
	
	
	
	
	public double handleArmorDamage(double init) {
		double rd = init;
		
		if(player.getInventory().getChestplate().getItemMeta().hasEnchant(Enchantment.PROTECTION_EXPLOSIONS)) {
			rd = rd * 0.2;
		}
		
		if(player.getInventory().getChestplate() == null) {
			return init;
		} else if(player.getInventory().getChestplate().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&9Rare Blast Plate"))) {
			rd = rd * 0.8;
			return rd;
		} else if(player.getInventory().getChestplate().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&5Epic Blast Plate"))) {
			rd = rd * 0.7;
			return rd;
		} else if(player.getInventory().getChestplate().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "6Legendary Blast Plate"))) {
			rd = rd * 0.6;
			return rd;
		} else if(player.getInventory().getChestplate().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&', "&4Ara Ara Protection"))) {
			rd = rd * 0.5;
			return rd;
		} 
		
 
		return rd;
	}



	@EventHandler
	public void onProjectileFireEvent(ProjectileLaunchEvent event) {
		
		if(event.getEntity() instanceof Firework) {
			Firework fw = (Firework) event.getEntity();
			ItemMeta meta = fw.getFireworkMeta();
			Player player = (Player) fw.getShooter();
			int x = player.getInventory().getItemInOffHand().getAmount();
			int y = player.getInventory().getItemInMainHand().getAmount();
			if(player.getInventory().getItemInMainHand().getType() == Material.CROSSBOW) {
			if(meta.getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',"&1Rare Long Range Firework"))) {
				fw.setVelocity(player.getLocation().getDirection().multiply(2.5));

			} else if(meta.getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',"&5Epic Long Range Firework"))) {
				fw.setVelocity(player.getLocation().getDirection().multiply(4));

			} else if(meta.getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',"&6Legendary Long Range Firework"))) {
				fw.setVelocity(player.getLocation().getDirection().multiply(6));

			} 
			} else {
				event.setCancelled(true);
				player.getInventory().getItemInOffHand().setAmount(x);
				player.getInventory().getItemInMainHand().setAmount(y);
			}
		}
	}

	
	
	
	@EventHandler
	public void onBlockPlace(final BlockPlaceEvent event) {
		if(event.getPlayer().getGameMode() == GameMode.SURVIVAL) {
			if(event.getBlock().getType() == Material.GOLD_BLOCK) {

				boolean areaState = false;
				int r = 10;
				Location pos = event.getBlock().getLocation();
				for(int x = (r * -1); x <= r; x++) {
					for(int y = (r * -1); y <= r; y++) {
						for(int z = (r * -1); z <= r; z++) {		            	
							Block b = pos.getWorld().getBlockAt(pos.getBlockX() + x, pos.getBlockY() + y, pos.getBlockZ() + z);

							if(!(b.getLocation().toString().equals(pos.toString()))){			
								if(b.getType() == Material.GOLD_BLOCK) {
									areaState = true;
									event.getPlayer().sendMessage(ChatColor.RED + " Another Health Beacon is present in the area ");
									event.setCancelled(true);
								}
							}
						}		            
					}	        
				}


				if(!areaState) {							
					garbageList.add(event.getBlock().getLocation());
					final Player p = event.getPlayer();
					final Location location = event.getBlock().getLocation();	
					new BukkitRunnable() {
						int counter = 0;
						@Override
						public void run() {
							if( counter < 20) {
								for( Player player : Bukkit.getOnlinePlayers() ) {							
									if(location.distance(player.getLocation()) < 10) {
										if(player.getHealth() + 2 < 20) {
											player.setHealth(player.getHealth() + 2);
										}
										else{
											player.setHealth(20);
										}
										player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_IRON_XYLOPHONE, 10, 10);
									}
								}
								counter++;
							} else {						
								location.getBlock().setType(Material.AIR);
								p.playSound(p.getLocation(), Sound.BLOCK_BEACON_DEACTIVATE, 10, 10);
								cancel();
							}
						}
					}.runTaskTimer(main, 20, 20);
				}
			} else if(event.getBlock().getType() == Material.WHITE_WOOL) {
				final ArrayList<Block> tempGL = new ArrayList<>();
				tempGL.add(event.getBlock());
				Location pos = event.getBlock().getLocation();
				Player player = event.getPlayer();
				String direction = player.getFacing().toString();
	
				if(direction.equalsIgnoreCase("NORTH") ) {
					for(int x = pos.getBlockX() - 2; x <= pos.getBlockX() + 2; x++) {
						for(int y = pos.getBlockY(); y <= pos.getBlockY() + 1; y++) {
							if(world.getBlockAt(x, y, pos.getBlockZ()).getType() == Material.AIR ) {
								
								world.getBlockAt(x, y, pos.getBlockZ()).setType(Material.WHITE_WOOL);
								tempGL.add(world.getBlockAt(x, y, pos.getBlockZ()));
								garbageList.add(world.getBlockAt(x, y, pos.getBlockZ()).getLocation());
								
							}
						}
					}					
				} else if ( direction.equalsIgnoreCase("SOUTH")){
					for(int x = pos.getBlockX() - 2; x <= pos.getBlockX() + 2; x++) {
						for(int y = pos.getBlockY(); y <= pos.getBlockY() + 1; y++) {
							if(world.getBlockAt(x, y, pos.getBlockZ()).getType() == Material.AIR ) {
								
								world.getBlockAt(x, y, pos.getBlockZ()).setType(Material.WHITE_WOOL);
								tempGL.add(world.getBlockAt(x, y, pos.getBlockZ()));
								garbageList.add(world.getBlockAt(x, y, pos.getBlockZ()).getLocation());
								
							}
						}
					}
				}
				
				else if(direction.equalsIgnoreCase("EAST")) {

					for(int z = pos.getBlockZ() - 2; z <= pos.getBlockZ() + 2; z++) {
						for(int y = pos.getBlockY(); y <= pos.getBlockY() + 1; y++) {
							if(world.getBlockAt(pos.getBlockX(), y, z).getType() == Material.AIR ) {
								
								world.getBlockAt(pos.getBlockX(), y, z).setType(Material.WHITE_WOOL);
								tempGL.add(world.getBlockAt(pos.getBlockX(), y, z));
								garbageList.add(world.getBlockAt(pos.getBlockX(), y, z).getLocation());
								
								
							}
						}
					}
				} else {
					for(int z = pos.getBlockZ() - 2; z <= pos.getBlockZ() + 2; z++) {
						for(int y = pos.getBlockY(); y <= pos.getBlockY() + 1; y++) {
							if(world.getBlockAt(pos.getBlockX(), y, z).getType() == Material.AIR ) {
								
								world.getBlockAt(pos.getBlockX(), y, z).setType(Material.WHITE_WOOL);
								tempGL.add(world.getBlockAt(pos.getBlockX(), y, z));
								garbageList.add(world.getBlockAt(pos.getBlockX(), y, z).getLocation());
								
								
							}
						}
					}
				}

				new BukkitRunnable() {

					@Override
					public void run() {
						for(Block b : tempGL) {
							if(b.getType() != Material.AIR) {
								b.setType(Material.AIR);
							}
						}
						
					}
					
				}.runTaskLater(main, 20 * 10);
				
				
				
			} else {
				event.setCancelled(true);
				event.getPlayer().sendMessage(ChatColor.RED + "This block cannot be placed!");
			}
			
			
		}
	}


	@EventHandler (priority = EventPriority.HIGH)
	public void onBlockBreak(BlockBreakEvent event){
		if(event.getPlayer().getGameMode() != GameMode.CREATIVE) {
			event.setCancelled(true);
			event.getPlayer().sendMessage(ChatColor.RED + "This block cannot be broken!");
		}
	}


	public void killPlayer(Player player) {
		player.setGameMode(GameMode.SPECTATOR);
		createDeathBox(player, player.getLocation());
		playersAlive.remove(player);

		if(getPlayersLeft() == 1) {
			sendServermessage("Looks like " + playersAlive.get(0).getDisplayName() + " won this time!");
			playersAlive.get(0).sendTitle(ChatColor.translateAlternateColorCodes('&', "&6You Are The Champion"), "good work I guess", 0, 300, 0);					
			initiateExit();
		}
		
		player.setWalkSpeed(0.2f);
	}
	

	@EventHandler
	public static void onPlayerDeath(PlayerDeathEvent e) {

		if(getStartGame()) {

			Player p = e.getEntity();
			setPlayersLeft(getPlayersLeft() - 1);
			createDeathBox(p, p.getLocation());
			playersAlive.remove(p);

			if(getPlayersLeft() == 1) {
				sendServermessage("Looks like " + playersAlive.get(0).getDisplayName() + " won this time!");
				playersAlive.get(0).sendTitle(ChatColor.translateAlternateColorCodes('&', "&6You Are The Champion"), "good work I guess", 0, 300, 0);					
				initiateExit();
			}	
		}
	}



	public static void refreshBoard(){
		for(BoardPlayer p : LeaderBoardPlayers) {
			createBoard(p.getPlayer());
		}
	}

	
	@EventHandler
	public void onProjectileHit(ProjectileHitEvent event) {

		if(event.getHitEntity() instanceof Player) {
			if(event.getEntity() instanceof Arrow) {

			}
		}		
	}






	public static boolean createDeathBox(Player player, Location location) {

		if(!playersAlive.contains(player)) return true;
		Block block = location.getBlock();
		if(player.getLocation().getBlock().getType() == Material.AIR) {
			
			block.setType(Material.CHEST);	
		} else {
			int y = player.getLocation().getBlockY();
			while((world.getBlockAt(player.getLocation().getBlockX(), y, player.getLocation().getBlockY()).getType()) != Material.AIR) {
				y++;
			}
			location.setY(y); 
			block = location.getBlock();
			block.setType(Material.CHEST);
		}
		
		
		
		PlayerInventory inventory = player.getInventory();
		ItemStack[] itemstack = inventory.getContents();

		Chest chest = (Chest) location.getBlock().getState();
		if(location.getBlock().getState() instanceof Chest) {
			for(int x = 0; x < 26 ; x++) {				
				if(itemstack[x] != null) {					
					chest.getInventory().addItem(itemstack[x]);			
				}
			}			                                
		}
		return true;
	}








	public static void sendServermessage(String string) {
		for(Player player : Bukkit.getOnlinePlayers()) {
			player.sendMessage(string);
		}
	}







	public static void sendServermessage(ChatColor color, String string) {
		for(Player player : Bukkit.getOnlinePlayers()) {
			player.sendMessage(color + string);
		}
	}


	public void setHealthPlayer(Player player, int health) {

	}

	@EventHandler
	public void onItemConsume(PlayerItemConsumeEvent event) {
		final Player player = event.getPlayer();		

		if(event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase("common syringe")) {
			if(player.getHealth() + 4 <= 20.0) {
				player.setHealth(player.getHealth() + 4);


				PlayerInventory inventory = player.getInventory();
				int curr = inventory.getHeldItemSlot();
				ItemStack Item = player.getInventory().getItem(curr);			
				Item.setAmount(Item.getAmount()-1);					
				player.getInventory().setItem(curr, Item);

				event.setCancelled(true);

			} else {
				player.setHealth(20);

				PlayerInventory inventory = player.getInventory();
				int curr = inventory.getHeldItemSlot();
				ItemStack Item = player.getInventory().getItem(curr);			
				Item.setAmount(Item.getAmount()-1);					
				player.getInventory().setItem(curr, Item);

				event.setCancelled(true);
			}			
		} else if(event.getItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.translateAlternateColorCodes('&',"&b&oCommon Health Kit"))) {

			final double x = 20.0 -  player.getHealth();		
			event.setCancelled(true);		
			player.setHealth(player.getHealth() + x);		
			
			PlayerInventory inventory = player.getInventory();
			int curr = inventory.getHeldItemSlot();
			ItemStack Item = player.getInventory().getItem(curr);			
			Item.setAmount(Item.getAmount()-1);					
			player.getInventory().setItem(curr, Item);


			event.setCancelled(true);
		}
	}




	public static void createChests() {

		chest1 = new Location(world, 12, 25, -5);
		chest2 = new Location(world, -15, 18, -6);
		chest3 = new Location(world, -27, 24, -5);
		chest4 = new Location(world, -51, 18, -15);
		chest5 = new Location(world, 0, 18, -3);
		chest6 = new Location(world, 26, 18, -1);
		chest7 = new Location(world, 41, 16, -20);
		chest8 = new Location(world, 52, 17, -24);
		chest9 = new Location(world, 65, 16, -33);
		chest10 = new Location(world, 76, 18, -54);
		chest11 = new Location(world, 169, 18, -4);
		chest12 = new Location(world, 76, 25, 7);
		chest13 = new Location(world, 97, 25, 92);
		chest14 = new Location(world, 23, 25, 85);
		chest15 = new Location(world, -22, 25, 69);
		chest16 = new Location(world, -74, 25, 73);
		chest17 = new Location(world, 11, 18, 22);
		chest18 = new Location(world, 3, 18, 9);
		chest19 = new Location(world, -7, 25, 13);
		chest20 = new Location(world, 35, 25, 0);
		chest21 = new Location(world, 54, 25, -9);
		chest22 = new Location(world, 20, 25, 95);
		chest23 = new Location(world, 107, 25, 43);
		chest24 = new Location(world, 54, 11, -97);
		chest25 = new Location(world, 191, 10, -106);
		chest26 = new Location(world, 7, 13, -40);
		chest27 = new Location(world, 58, 14, -43);
		chest28 = new Location(world, -89, 18, -3);
		chest29 = new Location(world, -13, 18,37);
		chest30 = new Location(world, -76, 25, -4);




		chests.add(chest1);
		chests.add(chest2);
		chests.add(chest3);
		chests.add(chest4);
		chests.add(chest5);
		chests.add(chest6);
		chests.add(chest7);
		chests.add(chest8);
		chests.add(chest9);
		chests.add(chest10);
		chests.add(chest11);
		chests.add(chest12);
		chests.add(chest13);
		chests.add(chest14);
		chests.add(chest15);
		chests.add(chest16);
		chests.add(chest17);
		chests.add(chest18);
		chests.add(chest19);
		chests.add(chest20);
		chests.add(chest21);
		chests.add(chest22);
		chests.add(chest23);
		chests.add(chest24);
		chests.add(chest25);
		chests.add(chest26);
		chests.add(chest27);
		chests.add(chest28);
		chests.add(chest29);
		chests.add(chest30);

		Collections.shuffle(chests);
		for(Location location : chests) {			
			location.getBlock().setType(Material.CHEST);
		}	
	}







	public static void initiateExit() {
		//Declare Game as False
		clearBlock();
		setStartGame(false);
		
		//Set Border back to original
		border.setSize(1000);
		
		//Set Board Back to Players Online
		refreshBoard();
		
		//Delete Unwanted Block
			
		
		//Remove Player from Boss Bar;
		for(Player player : Bukkit.getOnlinePlayers()) {
			bar.removePlayer(player);
		}
		
		main.onDisable();		
	}
	







	public static void clearBlock() {
		for (Chunk c : world.getLoadedChunks()) {
			for (BlockState b : c.getTileEntities()) {	
				
				if( b instanceof Chest) {
					b.getBlock().setType(Material.AIR);								 
				}
			}					
		}		
		
		for(Location l : garbageList) {
			if(l.getBlock().getType() != Material.AIR) {
				l.getBlock().setType(Material.AIR);
			}
		}
	}





	public void initializeCarePackages() {

	//	if(center.getBlockX() == 0) {

			cp1r1 = new Location(world, -18,25,62);
			cp2r1 = new Location(world, -30,18,32);
			cp3r1 = new Location(world, 43,12,-60);
			cp4r1 = new Location(world, 129,18,-41);

			cp1r2 = new Location(world, -60,25,31);
			cp2r2 = new Location(world, -135,18,0);
			cp3r2 = new Location(world, 3,25,61);

			cp1r3 = new Location(world, -28,25,16);
			cp2r3 = new Location(world, -19,24,53);

			cp1r3 = new Location(world, -28,26,16);
			cp2r3 = new Location(world, -19,25,53);
/*
		} else if(center.getBlockX() == 20) {

			cp1r1 = new Location(world, -18,25,62);
			cp2r1 = new Location(world, -30,18,32);
			cp3r1 = new Location(world, 43,12,-60);
			cp4r1 = new Location(world, 129,18,-41);

			cp1r2 = new Location(world, -60,25,31);
			cp2r2 = new Location(world, -135,18,0);
			cp3r2 = new Location(world, 3,25,61);

			cp1r3 = new Location(world, -28,25,16);
			cp2r3 = new Location(world, -19,24,53);

			cp1r3 = new Location(world, -28,26,16);
			cp2r3 = new Location(world, -19,25,53);

		} else if(center.getBlockX() == 30) {

			cp1r1 = new Location(world, -18,25,62);
			cp2r1 = new Location(world, -30,18,32);
			cp3r1 = new Location(world, 43,12,-60);
			cp4r1 = new Location(world, 129,18,-41);

			cp1r2 = new Location(world, -60,25,31);
			cp2r2 = new Location(world, -135,18,0);
			cp3r2 = new Location(world, 3,25,61);

			cp1r3 = new Location(world, -28,25,16);
			cp2r3 = new Location(world, -19,24,53);

			cp1r3 = new Location(world, -28,26,16);
			cp2r3 = new Location(world, -19,25,53);

		} else if(center.getBlockX() == 23) {

			cp1r1 = new Location(world, -18,25,62);
			cp2r1 = new Location(world, -30,18,32);
			cp3r1 = new Location(world, 43,12,-60);
			cp4r1 = new Location(world, 129,18,-41);

			cp1r2 = new Location(world, -60,25,31);
			cp2r2 = new Location(world, -135,18,0);
			cp3r2 = new Location(world, 3,25,61);

			cp1r3 = new Location(world, -28,25,16);
			cp2r3 = new Location(world, -19,24,53);

			cp1r3 = new Location(world, -28,26,16);
			cp2r3 = new Location(world, -19,25,53);

		} else if(center.getBlockX() == 1) {

			cp1r1 = new Location(world, -18,25,62);
			cp2r1 = new Location(world, -30,18,32);
			cp3r1 = new Location(world, 43,12,-60);
			cp4r1 = new Location(world, 129,18,-41);

			cp1r2 = new Location(world, -60,25,31);
			cp2r2 = new Location(world, -135,18,0);
			cp3r2 = new Location(world, 3,25,61);

			cp1r3 = new Location(world, -28,25,16);
			cp2r3 = new Location(world, -19,24,53);

			cp1r3 = new Location(world, -28,26,16);
			cp2r3 = new Location(world, -19,25,53);

		} else if(center.getBlockX() == 18) {

			cp1r1 = new Location(world, -18,25,62);
			cp2r1 = new Location(world, -30,18,32);
			cp3r1 = new Location(world, 43,12,-60);
			cp4r1 = new Location(world, 129,18,-41);

			cp1r2 = new Location(world, -60,25,31);
			cp2r2 = new Location(world, -135,18,0);
			cp3r2 = new Location(world, 3,25,61);

			cp1r3 = new Location(world, -28,25,16);
			cp2r3 = new Location(world, -19,24,53);

			cp1r3 = new Location(world, -28,26,16);
			cp2r3 = new Location(world, -19,25,53);

		} else if(center.getBlockX() == 13) {

			cp1r1 = new Location(world, -18,25,62);
			cp2r1 = new Location(world, -30,18,32);
			cp3r1 = new Location(world, 43,12,-60);
			cp4r1 = new Location(world, 129,18,-41);

			cp1r2 = new Location(world, -60,25,31);
			cp2r2 = new Location(world, -135,18,0);
			cp3r2 = new Location(world, 3,25,61);

			cp1r3 = new Location(world, -28,25,16);
			cp2r3 = new Location(world, -19,24,53);

			cp1r3 = new Location(world, -28,26,16);
			cp2r3 = new Location(world, -19,25,53);

		} else if(center.getBlockX() == 10) {

			cp1r1 = new Location(world, -18,25,62);
			cp2r1 = new Location(world, -30,18,32);
			cp3r1 = new Location(world, 43,12,-60);
			cp4r1 = new Location(world, 129,18,-41);

			cp1r2 = new Location(world, -60,25,31);
			cp2r2 = new Location(world, -135,18,0);
			cp3r2 = new Location(world, 3,25,61);

			cp1r3 = new Location(world, -28,25,16);
			cp2r3 = new Location(world, -19,24,53);

			cp1r3 = new Location(world, -28,26,16);
			cp2r3 = new Location(world, -19,25,53);

		} else if(center.getBlockX() == 90) {

			cp1r1 = new Location(world, -18,25,62);
			cp2r1 = new Location(world, -30,18,32);
			cp3r1 = new Location(world, 43,12,-60);
			cp4r1 = new Location(world, 129,18,-41);

			cp1r2 = new Location(world, -60,25,31);
			cp2r2 = new Location(world, -135,18,0);
			cp3r2 = new Location(world, 3,25,61);

			cp1r3 = new Location(world, -28,25,16);
			cp2r3 = new Location(world, -19,24,53);

			cp1r3 = new Location(world, -28,26,16);
			cp2r3 = new Location(world, -19,25,53);
		}*/

	}






	public static void spawnCarePackageR1() {

		cp1r1.getBlock().setType(Material.CHEST);
		cp2r1.getBlock().setType(Material.CHEST);
		cp3r1.getBlock().setType(Material.CHEST);
		cp4r1.getBlock().setType(Material.CHEST);
		world.strikeLightningEffect(cp1r1);
		world.strikeLightningEffect(cp2r1);
		world.strikeLightningEffect(cp3r1);
		world.strikeLightningEffect(cp4r1);	
		playLightningEffect();

		Chest chest = (Chest) cp1r1.getBlock().getState();
		Chest chest1 = (Chest) cp2r1.getBlock().getState();
		Chest chest2 = (Chest) cp3r1.getBlock().getState();
		Chest chest3 = (Chest) cp4r1.getBlock().getState();
		ItemStack item = new ItemStack(Material.APPLE, 3);

		if(cp1r1.getBlock().getState() instanceof Chest && cp2r1.getBlock().getState() instanceof Chest
				&&	cp3r1.getBlock().getState() instanceof Chest && cp4r1.getBlock().getState() instanceof Chest) {

			chest.getInventory().addItem(item);
			chest1.getInventory().addItem(item);
			chest2.getInventory().addItem(item);
			chest3.getInventory().addItem(item);

		}


		sendServermessage(ChatColor.GOLD, "Round 1 Care Packages have spawned");

	}







	public static void spawnCarePackageR2() {

		cp1r2.getBlock().setType(Material.CHEST);
		cp2r2.getBlock().setType(Material.CHEST);
		cp3r2.getBlock().setType(Material.CHEST);
		world.strikeLightningEffect(cp1r1);
		world.strikeLightningEffect(cp2r1);
		world.strikeLightningEffect(cp3r1);
		playLightningEffect();


		Chest chest = (Chest) cp1r2.getBlock().getState();
		Chest chest1 = (Chest) cp2r2.getBlock().getState();
		Chest chest2 = (Chest) cp3r2.getBlock().getState();
		ItemStack item = new ItemStack(Material.APPLE, 3);

		if(cp1r2.getBlock().getState() instanceof Chest && cp2r2.getBlock().getState() instanceof Chest
				&&	cp3r2.getBlock().getState() instanceof Chest) {

			chest.getInventory().addItem(item);
			chest1.getInventory().addItem(item);
			chest2.getInventory().addItem(item);


		}


		sendServermessage(ChatColor.GOLD, "Round 2 Care Packages have spawned");

	}







	public static void spawnCarePackageR3() {

		cp1r3.getBlock().setType(Material.CHEST);
		cp2r3.getBlock().setType(Material.CHEST);
		world.strikeLightningEffect(cp1r3);
		world.strikeLightningEffect(cp2r3);
		playLightningEffect();

		Chest chest = (Chest) cp1r3.getBlock().getState();
		Chest chest1 = (Chest) cp2r3.getBlock().getState();
		ItemStack item = new ItemStack(Material.APPLE, 3);

		if(cp1r3.getBlock().getState() instanceof Chest && cp2r3.getBlock().getState() instanceof Chest) {

			chest.getInventory().addItem(item);
			chest1.getInventory().addItem(item);

		}

		world.strikeLightningEffect(cp1r3);
		world.strikeLightningEffect(cp2r3);

		sendServermessage(ChatColor.GOLD, "Round 3 Care Packages have spawned");

	}

	
	public static void playLightningEffect() {
		for(final Player player : Bukkit.getOnlinePlayers()) {
				Location loc = player.getLocation();
				loc.setY(0);
		
			   world.strikeLightningEffect(loc);
		
		}
	}




	@EventHandler(priority = EventPriority.MONITOR)
	public void onInventoryClick(final InventoryClickEvent event) {

		Inventory inventory1 = event.getClickedInventory();

		if(inventory1.getType() != null) {

			int totalamount = 0;
			Player player = (Player) event.getWhoClicked();
			PlayerInventory inventory = player.getInventory();
			ItemStack[] itemstack = inventory.getContents();

			if(!(inventory1.getType() == InventoryType.PLAYER)) {


				for(int x = 0; x < 9; x++) {
					if(itemstack[x] != null) {
						if(itemstack[x].getType() == Material.CROSSBOW) {
							totalamount++;
						}	
					}
				}

				if(event.getCurrentItem().getType() == Material.CROSSBOW) {
					if(totalamount == 2) {
						player.sendMessage(ChatColor.RED + "Cannot hold more than 2 crossbows");
						event.setCancelled(true);
					}

				}
			} else if(inventory1.getType() == InventoryType.PLAYER) {
				if(event.getCurrentItem().getType() == Material.BARRIER) {
					event.setCancelled(true);
					player.sendMessage(ChatColor.RED + "That inventory slot cannot be used");
				}
			}
		}

		if (event.isCancelled()) {
			return;
		} else if (event.getWhoClicked() instanceof Player){
			Bukkit.getScheduler().runTask(main, new Runnable(){
				@Override
				public void run() {
					Player p = (Player) event.getWhoClicked();
					p.updateInventory();

				}
			});

		}

		//	event.setCancelled(true);
	}








	@EventHandler
	public void onItemSpawn(ItemSpawnEvent event) {
		if(getStartGame())
			event.setCancelled(true);          
	}




	@EventHandler
	public static void onPlayerRespawn(PlayerRespawnEvent event) {
		
		if(getStartGame()) {
			player.setGameMode(GameMode.SPECTATOR);
		}
	}



	public static void fillChests() {
		for (Chunk c : world.getLoadedChunks()) {
			for (BlockState b : c.getTileEntities()) {
				if (b instanceof Chest) {

					Chest chest = (Chest) b;
					
					int r = 1 + (int) ((7) * Math.random());
						
				      for(int x = 0; x <= r; x++) {
						
						int pool = weightedProbability(LootPoolRate);
						
				
						switch (pool) {
						case 0:
							chest.getInventory().addItem(weightedProbability(HealthLootPool)); 
							break;
						case 1:
							chest.getInventory().addItem(weightedProbability(WeaponLootPool)); 
							break;
						case 2:
							chest.getInventory().addItem(weightedProbability(ArmorLootPool)); 							
							break;
						case 3:
							chest.getInventory().addItem(weightedProbability(CraftLootPool)); 							
							break;
						case 4:
							chest.getInventory().addItem(weightedProbability(UtilLootPool)); 							
							break;

						}						
				      }
				}
			}
		}
	}



	
	
	
	public static int weightedProbability(int[] probabilities) {

		int max = 0;
		int rng = 0;
		int curr = 0;
		
		for( int c = 0; c < probabilities.length; c++) {
			max += probabilities[c];
		}
		int r = 1 + (int) ((max) * Math.random());

		for( int x = 0; x < probabilities.length; x++) {
			if(r <= curr + probabilities[x]) {
				rng = x;				
				break;		
			} else {
				curr += probabilities[x];
			}
		}
		return rng;
	}

	
	
	
	
	
	
	public static boolean select(Location loc1, Location loc2, World w){
		 
        //First of all, we create the list:
        List<Block> blocks = new ArrayList<Block>();
      
        //Next we will name each coordinate
        int x1 = loc1.getBlockX();
        int y1 = loc1.getBlockY();
        int z1 = loc1.getBlockZ();
 
        int x2 = loc2.getBlockX();
        int y2 = loc2.getBlockY();
        int z2 = loc2.getBlockZ();
 
        //Then we create the following integers
        int xMin, yMin, zMin;
        int xMax, yMax, zMax;
        int x, y, z;
 
        //Now we need to make sure xMin is always lower then xMax
        if(x1 > x2){ //If x1 is a higher number then x2
            xMin = x2;
            xMax = x1;
        }else{
            xMin = x1;
            xMax = x2;
        }
 
        //Same with Y
        if(y1 > y2){
            yMin = y2;
            yMax = y1;
        }else{
            yMin = y1;
            yMax = y2;
        }
 
        //And Z
        if(z1 > z2){
            zMin = z2;
            zMax = z1;
        }else{
            zMin = z1;
            zMax = z2;
        }
 
        //Now it's time for the loop
        for(x = xMin; x <= xMax; x ++){
            for(y = yMin; y <= yMax; y ++){
                for(z = zMin; z <= zMax; z ++){
                    Block b = new Location(w, x, y, z).getBlock();
                    blocks.add(b);
                }
            }
        }
        
        for(Block b : blocks) {
        	if(b.getType() != Material.AIR) {        	
        	    return false;
        	} else {
        		return true;
        	}
        }        
        //And last but not least, we return with the list
        return true;
    }

	
	
	
	
	
	
	public static ItemStack weightedProbability( ArrayList<Loot> probabilities) {

		int max = 0;
		int rng = 0;
		int curr = 0;
		
		for( int c = 0; c < probabilities.size(); c++) {
			max += (probabilities.get(c).getProbability());
		}
		int r = 1 + (int) ((max) * Math.random());

		for( int x = 0; x < probabilities.size(); x++) {
			if(r <= curr + probabilities.get(x).getProbability()) {
				rng = x;				
				break;		
			} else {
				curr += probabilities.get(x).getProbability();
			}
		}
		return probabilities.get(rng).getItem();
	}









	public static void setStart(boolean bool) {
		start = bool;
	}








	public static void setStartGame(boolean bool) {
		startGame = bool;
	}







	public static boolean getStartGame() {
		return startGame;
	}







	@EventHandler
	public  void movement(PlayerMoveEvent event) {
		if ( start == false) {
			event.setCancelled(true);
		}		
	}








	public static void setBorder( int x, int time, float damage) {
		border.setCenter(center);
		if (time == 0) border.setSize(x);
		else border.setSize(x,time);		
		border.setDamageAmount(damage);	
	}







	public static void cycle_one() {
		border.setDamageBuffer(0);
		border.setWarningDistance(10);
		border.setDamageAmount(0.01);
		setBorder(border1, 0, 1);	
		border.setCenter(center);

		setRound1(new BukkitRunnable() {
			@Override
			public void run() {
				setBorder(border2, RingTime1, 0.25f);
				playLightningEffect();
				sendServerTitle("", "Ring Movement Has Started", 3, 1, 'c' );
				spawnCarePackageR1();
				
				
				
			}
		}.runTaskLater(main, 20 * Time1));


		setRound2(new BukkitRunnable() {
			@Override
			public void run() {
				setBorder(border3, RingTime2, 0.5f);
				playLightningEffect();
				sendServerTitle("", "Ring Movement Has Started", 3, 1, 'c' );
				spawnCarePackageR2();
				
				
			}
		}.runTaskLater(main, 20 * (Time1 + RingTime1 + Time2)));


		setRound3(new BukkitRunnable() {
			@Override
			public void run() {
				setBorder(border4, RingTime3, 1);
				playLightningEffect();
				sendServerTitle("", "Ring Movement Has Started", 3, 1, 'c' );
				spawnCarePackageR3();
				
				
			}
		}.runTaskLater(main, 20 * (Time1 + RingTime1 + Time2 + RingTime2 + Time3)));


		setRound4(new BukkitRunnable() {
			@Override
			public void run() {
				setBorder(border5, RingTime4, 0.5f);			
				playLightningEffect();
				sendServerTitle("", "Ring Movement Has Started", 3, 1, 'c' );
			}
		}.runTaskLater(main, 20 * (Time1 + RingTime1 + Time2 + RingTime2 + Time3 + RingTime3 + Time4)));


		setRound5(new BukkitRunnable() {
			@Override
			public void run() {
				setBorder(border6, RingTime5, 1);
				playLightningEffect();
				sendServerTitle("", "Final Circle Has Started", 3, 1, 'c' );
			}
		}.runTaskLater(main, 20 * (Time1 + RingTime1 + Time2 + RingTime2 + Time3 + RingTime3 + Time4 + RingTime4 + Time5)));

		setRound6(new BukkitRunnable() {
			@Override
			public void run() {				
				border.setSize(1000);
				clearBlock();
				setStartGame(false);
				for(Player player : Bukkit.getOnlinePlayers()) {
					bar.removePlayer(player);
				}
				main.onDisable();
			}
		}.runTaskLater(main, 20 * (Time1 + RingTime1 + Time2 + RingTime2 + Time3 + RingTime3 + Time4 + RingTime4 + Time5 + Time6 + 10)));
	}


	
	
	
	
	
	//ALL CUSTOM ITEM RELATED METHODS AND CONSTRUCTORS
	
	public static ShapedRecipe getArmorRecipe() {
		
		ItemStack item = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(main, "iron_chestplate" );
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("MA ", "   ", "   ");
		recipe.setIngredient('M', Material.EMERALD);
		recipe.setIngredient('A', Material.IRON_CHESTPLATE);
		
		return recipe;
	}
	
	
	
	
	
	
	public static ShapedRecipe getArmorRecipe1() {
		
		ItemStack item = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.THORNS, 1, true);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(main, "iron_chestplate2" );
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("MA ", "   ", "   ");
		recipe.setIngredient('M', Material.GOLD_INGOT);
		recipe.setIngredient('A', Material.IRON_CHESTPLATE);
		
		return recipe;
	}
	
	
	
	
	
	
	public static ShapedRecipe getArmorRecipe2() {
		
		ItemStack item = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(main, "iron_chestplate3" );
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("MA ", "   ", "   ");
		recipe.setIngredient('M', Material.DIAMOND);
		recipe.setIngredient('A', Material.IRON_CHESTPLATE);
		
		return recipe;
	}
	
	
	
	
	
	
	
	public static ShapedRecipe getArmorRecipe3() {
		
		ItemStack item = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(main, "Chain_chestplate" );
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("MA ", "   ", "   ");
		recipe.setIngredient('M', Material.EMERALD);
		recipe.setIngredient('A', Material.CHAINMAIL_CHESTPLATE);
		
		return recipe;
	}
	
	
	
	
	
	
	public static ShapedRecipe getArmorRecipe4() {
		
		ItemStack item = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.THORNS, 1, true);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(main, "Chain_chestplate2" );
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("MA ", "   ", "   ");
		recipe.setIngredient('M', Material.GOLD_INGOT);
		recipe.setIngredient('A', Material.CHAINMAIL_CHESTPLATE);
		
		return recipe;
	}
	
	
	
	
	
	
	public static ShapedRecipe getArmorRecipe5() {
		
		ItemStack item = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(main, "Chain_chestplate3" );
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("MA ", "   ", "   ");
		recipe.setIngredient('M', Material.DIAMOND);
		recipe.setIngredient('A', Material.CHAINMAIL_CHESTPLATE);
		
		return recipe;
	}


	
	
	
	public static ShapedRecipe getArmorRecipe6() {
		
		ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(main, "DIAMOND_chestplate" );
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("MA ", "   ", "   ");
		recipe.setIngredient('M', Material.EMERALD);
		recipe.setIngredient('A', Material.DIAMOND_CHESTPLATE);
		
		return recipe;
	}
	
	
	
	
	
	
	public static ShapedRecipe getArmorRecipe7() {
		
		ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.THORNS, 1, true);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(main, "DIAMOND_chestplate2" );
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("MA ", "   ", "   ");
		recipe.setIngredient('M', Material.GOLD_INGOT);
		recipe.setIngredient('A', Material.DIAMOND_CHESTPLATE);
		
		return recipe;
	}
	
	
	
	
	
	
	public static ShapedRecipe getArmorRecipe8() {
		
		ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(main, "DIAMOND_chestplate3" );
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("MA ", "   ", "   ");
		recipe.setIngredient('M', Material.DIAMOND);
		recipe.setIngredient('A', Material.DIAMOND_CHESTPLATE);
		
		return recipe;
	}
	
	
	
	public static ShapedRecipe getArmorRecipe9() {
		
		ItemStack item = new ItemStack(Material.NETHERITE_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(main, "NETHERITE_chestplate" );
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("MA ", "   ", "   ");
		recipe.setIngredient('M', Material.EMERALD);
		recipe.setIngredient('A', Material.NETHERITE_CHESTPLATE);
		
		return recipe;
	}
	
	
	
	
	
	
	public static ShapedRecipe getArmorRecipe10() {
		
		ItemStack item = new ItemStack(Material.NETHERITE_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.THORNS, 1, true);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(main, "NETHERITE_chestplate2" );
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("MA ", "   ", "   ");
		recipe.setIngredient('M', Material.GOLD_INGOT);
		recipe.setIngredient('A', Material.NETHERITE_CHESTPLATE);
		
		return recipe;
	}
	
	
	
	
	
	
	public static ShapedRecipe getArmorRecipe11() {
		
		ItemStack item = new ItemStack(Material.NETHERITE_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
		meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 1, true);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(main, "NETHERITE_chestplate3" );
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("MA ", "   ", "   ");
		recipe.setIngredient('M', Material.DIAMOND);
		recipe.setIngredient('A', Material.NETHERITE_CHESTPLATE);
		
		return recipe;
	}




	
	
	public static ShapedRecipe getArmorRecipe12() {
		
		ItemStack item = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(main, "piron_chestplate" );
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("MA ", "   ", "   ");
		recipe.setIngredient('M', Material.EMERALD_BLOCK);
		recipe.setIngredient('A', Material.IRON_CHESTPLATE);
		
		return recipe;
	}
	
	
	
	
	
	
	public static ShapedRecipe getArmorRecipe13() {
		
		ItemStack item = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.THORNS, 3, false);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(main, "piron_chestplate2" );
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("MA ", "   ", "   ");
		recipe.setIngredient('M', Material.GOLD_BLOCK);
		recipe.setIngredient('A', Material.IRON_CHESTPLATE);
		
		return recipe;
	}
	
	
	
	
	
	
	public static ShapedRecipe getArmorRecipe14() {
		
		ItemStack item = new ItemStack(Material.IRON_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(main, "piron_chestplate3" );
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("MA ", "   ", "   ");
		recipe.setIngredient('M', Material.DIAMOND_BLOCK);
		recipe.setIngredient('A', Material.IRON_CHESTPLATE);
		
		return recipe;
	}
	
	
	
	
	
	
	
	public static ShapedRecipe getArmorRecipe15() {
		
		ItemStack item = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(main, "pChain_chestplate" );
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("MA ", "   ", "   ");
		recipe.setIngredient('M', Material.EMERALD_BLOCK);
		recipe.setIngredient('A', Material.CHAINMAIL_CHESTPLATE);
		
		return recipe;
	}
	
	
	
	
	
	
	public static ShapedRecipe getArmorRecipe16() {
		
		ItemStack item = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.THORNS, 3, false);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(main, "pChain_chestplate2" );
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("MA ", "   ", "   ");
		recipe.setIngredient('M', Material.GOLD_BLOCK);
		recipe.setIngredient('A', Material.CHAINMAIL_CHESTPLATE);
		
		return recipe;
	}
	
	
	
	
	
	
	public static ShapedRecipe getArmorRecipe17() {
		
		ItemStack item = new ItemStack(Material.CHAINMAIL_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, false);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(main, "pChain_chestplate3" );
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("MA ", "   ", "   ");
		recipe.setIngredient('M', Material.DIAMOND_BLOCK);
		recipe.setIngredient('A', Material.CHAINMAIL_CHESTPLATE);
		
		return recipe;
	}


	
	
	
	public static ShapedRecipe getArmorRecipe18() {
		
		ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(main, "DIAMOND_BLOCK_chestplate" );
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("MA ", "   ", "   ");
		recipe.setIngredient('M', Material.EMERALD_BLOCK);
		recipe.setIngredient('A', Material.DIAMOND_CHESTPLATE);
		
		return recipe;
	}
	
	
	
	
	
	
	public static ShapedRecipe getArmorRecipe19() {
		
		ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.THORNS, 3, false);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(main, "DIAMOND_BLOCK_chestplate2" );
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("MA ", "   ", "   ");
		recipe.setIngredient('M', Material.GOLD_BLOCK);
		recipe.setIngredient('A', Material.DIAMOND_CHESTPLATE);
		
		return recipe;
	}
	
	
	
	
	
	
	public static ShapedRecipe getArmorRecipe20() {
		
		ItemStack item = new ItemStack(Material.DIAMOND_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(main, "DIAMOND_BLOCK_chestplate3" );
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("MA ", "   ", "   ");
		recipe.setIngredient('M', Material.DIAMOND_BLOCK);
		recipe.setIngredient('A', Material.DIAMOND_CHESTPLATE);
		
		return recipe;
	}
	
	
	
	public static ShapedRecipe getArmorRecipe21() {
		
		ItemStack item = new ItemStack(Material.NETHERITE_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 3, true);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(main, "pNETHERITE_chestplate" );
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("MA ", "   ", "   ");
		recipe.setIngredient('M', Material.EMERALD_BLOCK);
		recipe.setIngredient('A', Material.NETHERITE_CHESTPLATE);
		
		return recipe;
	}
	
	
	
	
	
	
	public static ShapedRecipe getArmorRecipe22() {
		
		ItemStack item = new ItemStack(Material.NETHERITE_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.THORNS, 3, false);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(main, "pNETHERITE_chestplate2" );
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("MA ", "   ", "   ");
		recipe.setIngredient('M', Material.GOLD_BLOCK);
		recipe.setIngredient('A', Material.NETHERITE_CHESTPLATE);
		
		return recipe;
	}
	
	
	
	
	
	
	public static ShapedRecipe getArmorRecipe23() {
		
		ItemStack item = new ItemStack(Material.NETHERITE_CHESTPLATE);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 4, true);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(main, "pNETHERITE_chestplate3" );
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("MA ", "   ", "   ");
		recipe.setIngredient('M', Material.DIAMOND_BLOCK);
		recipe.setIngredient('A', Material.NETHERITE_CHESTPLATE);
		
		return recipe;
	}



	
	
	
	
	
	
	
	public static ShapedRecipe getCrossBowRecipe() {
		
		ItemStack item = new ItemStack(Material.CROSSBOW);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.QUICK_CHARGE, 1, true);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(main, "pcrossbow_recipe1" );
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("MA ", "   ", "   ");
		recipe.setIngredient('M', Material.REDSTONE);
		recipe.setIngredient('A', Material.CROSSBOW);
		
		return recipe;
	}
	
	
	
	
	
	
	public static ShapedRecipe getCrossBowRecipe1() {
		
		ItemStack item = new ItemStack(Material.CROSSBOW);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.MULTISHOT, 1, true);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(main, "pcrossbow_recipe2" );
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("MA ", "   ", "   ");
		recipe.setIngredient('M', Material.LAPIS_LAZULI);
		recipe.setIngredient('A', Material.CROSSBOW);
		
		return recipe;
	}
	
	
	public static ShapedRecipe getCrossBowRecipe2() {
		
		ItemStack item = new ItemStack(Material.CROSSBOW);
		ItemMeta meta = item.getItemMeta();
		meta.addEnchant(Enchantment.QUICK_CHARGE, 3, true);
		item.setItemMeta(meta);
		
		NamespacedKey key = new NamespacedKey(main, "pcrossbow_recipe3" );
		
		ShapedRecipe recipe = new ShapedRecipe(key, item);
		
		recipe.shape("MA ", "   ", "   ");
		recipe.setIngredient('M', Material.REDSTONE_BLOCK);
		recipe.setIngredient('A', Material.CROSSBOW);
		
		return recipe;
	}
	
	
	




	
	

	public int getTaskID() {
		return taskID;
	}
	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}


	public static int getPlayersLeft() {
		return playersLeft;
	}


	public static void setPlayersLeft(int playersLeft) {
		MatchCommands.playersLeft = playersLeft;
	}


	public static BukkitTask getRound1() {
		return round1;
	}


	public static void setRound1(BukkitTask round1) {
		MatchCommands.round1 = round1;
	}
	public static BukkitTask getRound2() {
		return round2;
	}
	public static void setRound2(BukkitTask round2) {
		MatchCommands.round2 = round2;
	}
	public static BukkitTask getRound3() {
		return round3;
	}
	public static void setRound3(BukkitTask round3) {
		MatchCommands.round3 = round3;
	}
	public static BukkitTask getRound4() {
		return round4;
	}
	public static void setRound4(BukkitTask round4) {
		MatchCommands.round4 = round4;
	}
	public static BukkitTask getRound5() {
		return round5;
	}
	public static void setRound5(BukkitTask round5) {
		MatchCommands.round5 = round5;
	}
	public static BukkitTask getRound6() {
		return round6;
	}
	public static void setRound6(BukkitTask round6) {
		MatchCommands.round6 = round6;
	}
	public static void setBarTimeInterval(int barTimeInterval) {
		MatchCommands.barTimeInterval = barTimeInterval;
	}
}
