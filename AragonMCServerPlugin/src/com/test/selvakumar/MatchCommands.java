package com.test.selvakumar;

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
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.entity.FireworkExplodeEvent;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.util.Vector;




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

	final static int border1 = 400;
	final static int border2 = 200;
	final static int border3 = 100;
	final static int border4 = 50;
	final static int border5 = 25;
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

	private static Location center;
	ArrayList<SpawnPosition> positions = new ArrayList<>();
	public static ArrayList<Player> playersAlive = new ArrayList<>();
	static ArrayList<Item> playerInventory = new ArrayList<>();
	public static ArrayList<BoardPlayer> LeaderBoardPlayers = new ArrayList<>();
	
	static ArrayList<ItemStack> LootPool = new ArrayList<>();


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
		LeaderBoardPlayers.trimToSize();

		for (Iterator<BoardPlayer> itr = LeaderBoardPlayers.iterator(); itr.hasNext();) {
			BoardPlayer next = itr.next();			
			if (next.getPlayer().getDisplayName().equals(event.getPlayer().getDisplayName())){
				itr.remove();
			}					
		}
		
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
			if ( ((player.getDisplayName().equals("DaddyThanosTHICC"))) || ((player.getDisplayName().equals("NinoTheBaker"))) || ((player.getDisplayName().equals("KazooKidFTW")))) {
				initializeMatch();
				new BukkitRunnable() {				
					@Override 
					public void run() {						
						setStart(false);
						chooseSpawnPosition();
						createChests();
						fillChests();	
						chooseCenter();
						cycle_one();
						startBossBar();
						refreshBoard();
						stunPlayers();			
						addPlayer();
						initializeCarePackages();
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
			player.setGameMode(GameMode.ADVENTURE);
			player.getInventory().clear();
			player.setHealth(20);
			player.getInventory().addItem(defaultCrossbow);
			player.getInventory().addItem(defaultBread);
			player.getInventory().addItem(defaultSword);
			player.getInventory().setItemInOffHand(defaultFirework);
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
		defaultFireworkLore.add(ChatColor.BLUE + "Default Fireworks");
		defaultFireworkLore.add("Range: 1");
		defaultFireworkLore.add("Damage: 1");
		FireworkEffect defaultFireworkEffect = FireworkEffect.builder().flicker(false).withColor(Color.WHITE).withFade(Color.WHITE).with(Type.BALL_LARGE).trail(true).build();
		defaultFireworkMeta.setDisplayName("Default Fireworks");
		defaultFireworkMeta.addEffect(defaultFireworkEffect);
		defaultFireworkMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		defaultFireworkMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		defaultFirework.setItemMeta(defaultFireworkMeta);	 
		
		List<String> defaultGoldenAppleLore = new ArrayList<String>();
		defaultGoldenAppleLore.add(" ");
		defaultGoldenAppleLore.add(ChatColor.GREEN + "Instant heal by 2 hearts");
		defaultGoldenAppleLore.add(ChatColor.GREEN + "No effects or saturation");
		defaultGoldenAppleMeta.setLore(defaultGoldenAppleLore);
		defaultGoldenAppleMeta.setDisplayName("Common Syringe");
		defaultGoldenApple.setItemMeta(defaultGoldenAppleMeta);
		
		List<String> defaultGoldenCarrotLore = new ArrayList<String>();
		defaultGoldenCarrotLore.add(" ");
		defaultGoldenCarrotLore.add(ChatColor.GREEN + "Heals Health Fully");
		defaultGoldenCarrotLore.add(ChatColor.GREEN + "No effects or saturation");
		defaultGoldenCarrotMeta.setLore(defaultGoldenAppleLore);
		defaultGoldenCarrotMeta.setDisplayName(ChatColor.ITALIC + " "  + ChatColor.BLUE + "Common Health Kit");
		defaultGoldenCarrot.setItemMeta(defaultGoldenCarrotMeta);
		
		LootPool.add(defaultFirework);
		LootPool.add(defaultGoldenApple);
		LootPool.add(defaultGoldenCarrot);
		
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
		Objective objective = board.registerNewObjective("MatchCommands-1","dummy", ChatColor.translateAlternateColorCodes('&', "&a&l<< &2&lKill Leaders &a&l>>") );
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

		Location c1 = new Location(world, 0,0,0);
		Location c2 = new Location(world, 0,0,0);
		Location c3 = new Location(world, 0,0,0);
		Location c4 = new Location(world, 0,0,0);
		Location c5 = new Location(world, 0,0,0);
		Location c6 = new Location(world, 0,0,0);
		Location c7 = new Location(world, 0,0,0);
		Location c8 = new Location(world, 0,0,0);
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
	public void onPlayerInteract(PlayerInteractEvent event) {



		final Player player =  event.getPlayer();


		if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.GOLDEN_CARROT) {
				if(player.getFoodLevel() == 20) {
					player.setFoodLevel(19);
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(main, new Runnable() {
						public void run() {
							player.setFoodLevel(20);
						}
					}, 1L);
				}
			}


			if (event.getPlayer().getInventory().getItemInMainHand().getType() == Material.SNOWBALL) {
				Vector velocity = event.getPlayer().getLocation().getDirection();
				event.setCancelled(true);
				Snowball snowball = player.launchProjectile(Snowball.class);
				velocity.normalize();
				snowball.setVelocity(velocity.multiply(5));
				snowball.setFallDistance(0);		
				snowball.setShooter(player);
			}
		}

	}









	@EventHandler
	public void onDamage(EntityDamageEvent event) {	
		if(getStartGame()){				
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
					
					if ((player.getHealth() - event.getFinalDamage()) <= 0) {
						
						setPlayersLeft(getPlayersLeft() - 1);
						killPlayer(player);
						event.setCancelled(true);											
						sendServermessage(ChatColor.BLUE + player.getDisplayName() + ChatColor.WHITE + " forgot they couldn't fly ");										
						
						
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
				} else if(event.getCause() == DamageCause.SUFFOCATION) {
					
			
					if ((player.getHealth() - event.getFinalDamage()) <= 0) {
						
						setPlayersLeft(getPlayersLeft() - 1);
						killPlayer(player);
						event.setCancelled(true);											
						sendServermessage(ChatColor.BLUE + player.getDisplayName() + ChatColor.WHITE + " died to the " + ChatColor.DARK_RED + "The Storm");																						
					}					
				}			
		}		
	}

	@EventHandler
	public void onFireworkExplode(FireworkExplodeEvent event) {
		Location location = event.getEntity().getLocation();
		Player p = (Player) event.getEntity().getShooter();		
		for(Player player : playersAlive) {
			double location2 = location.distance(player.getLocation());
			if(location2 <= 5) {
				Random randomGenerator = new Random();
				double rd = 2 * (2.5 + randomGenerator.nextDouble());			
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




	public void killPlayer(Player player) {
		player.setGameMode(GameMode.SPECTATOR);
		createDeathBox(player, player.getLocation());
		playersAlive.remove(player);
								


		if(getPlayersLeft() == 1) {
			sendServermessage("Looks like " + playersAlive.get(0).getDisplayName() + " won this time!");
			playersAlive.get(0).sendTitle(ChatColor.translateAlternateColorCodes('&', "&6You Are The Champion"), "good work I guess", 0, 300, 0);					
			initiateExit();
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
		block.setType(Material.CHEST);	

		PlayerInventory inventory = player.getInventory();
		ItemStack[] itemstack = inventory.getContents();

		Chest chest = (Chest) location.getBlock().getState();
		sendServermessage("Chest Created");
		if(location.getBlock().getState() instanceof Chest) {
			for(int x = 0; x < 26 ; x++) {
				sendServermessage("Inventory scanned");
				if(itemstack[x] != null) {
					sendServermessage("Inventory transferred");
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
	    Player player = event.getPlayer();

   
        
		if(event.getItem().getType() == Material.GOLDEN_APPLE) {
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
		} else if(event.getItem().getType() == Material.GOLDEN_CARROT) {
			double x = 20.0 -  player.getHealth();
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
		border.setSize(1000);
		clearChests();
		setStartGame(false);
		for(Player player : Bukkit.getOnlinePlayers()) {
			bar.removePlayer(player);
		}
		main.onDisable();		
	}







	public static void clearChests() {
		for (Chunk c : world.getLoadedChunks()) {
			for (BlockState b : c.getTileEntities()) {				
				if( b instanceof Chest) {
					b.getBlock().setType(Material.AIR);					
				}				
			}
		}
	}





	public void initializeCarePackages() {

		if(center.getBlockX() == 0) {

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
		}

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

		world.strikeLightningEffect(cp1r1);
		world.strikeLightningEffect(cp2r1);
		world.strikeLightningEffect(cp3r1);
		world.strikeLightningEffect(cp4r1);

		sendServermessage(ChatColor.GOLD, "Round 1 Care Packages have spawned");

	}







	public static void spawnCarePackageR2() {

		cp1r2.getBlock().setType(Material.CHEST);
		cp2r2.getBlock().setType(Material.CHEST);
		cp3r2.getBlock().setType(Material.CHEST);
		world.strikeLightningEffect(cp1r1);
		world.strikeLightningEffect(cp2r1);
		world.strikeLightningEffect(cp3r1);


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

		world.strikeLightningEffect(cp1r2);
		world.strikeLightningEffect(cp2r2);
		world.strikeLightningEffect(cp3r2);

		sendServermessage(ChatColor.GOLD, "Round 3 Care Packages have spawned");

	}







	public static void spawnCarePackageR3() {

		cp1r3.getBlock().setType(Material.CHEST);
		cp2r3.getBlock().setType(Material.CHEST);
		world.strikeLightningEffect(cp1r3);
		world.strikeLightningEffect(cp2r3);

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




	
	@EventHandler 
	public void onInventoryClick(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();
		Inventory inventory1 = event.getClickedInventory();
		int totalamount = 0;
		
		
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
		}
		
	//	event.setCancelled(true);
	}









	@EventHandler
	public void onItemSpawn(ItemSpawnEvent event) {
		if(getStartGame())
			event.setCancelled(true);          
	}








	public static void fillChests() {
		for (Chunk c : world.getLoadedChunks()) {
			for (BlockState b : c.getTileEntities()) {
				if (b instanceof Chest) {
					Chest chest = (Chest) b;				
					for(int x = 0; x < LootPool.size(); x++)				
							chest.getBlockInventory().addItem(LootPool.get(x));					
				}
			}
		}
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
				Location location = border.getCenter();
				spawnCarePackageR1();
				world.strikeLightningEffect(location);
				sendServerTitle("", "Ring Movement Has Started", 3, 1, 'c' );
			}
		}.runTaskLater(main, 20 * Time1));

		
		setRound2(new BukkitRunnable() {
			@Override
			public void run() {
				setBorder(border3, RingTime2, 0.5f);
				Location location = border.getCenter();
				spawnCarePackageR2();
				world.strikeLightningEffect(location);
				sendServerTitle("", "Ring Movement Has Started", 3, 1, 'c' );
			}
		}.runTaskLater(main, 20 * (Time1 + RingTime1 + Time2)));

		
		setRound3(new BukkitRunnable() {
			@Override
			public void run() {
				setBorder(border4, RingTime3, 1);
				Location location = border.getCenter();
				spawnCarePackageR3();
				world.strikeLightningEffect(location);
				sendServerTitle("", "Ring Movement Has Started", 3, 1, 'c' );
			}
		}.runTaskLater(main, 20 * (Time1 + RingTime1 + Time2 + RingTime2 + Time3)));

		
		setRound4(new BukkitRunnable() {
			@Override
			public void run() {
				setBorder(border5, RingTime4, 0.5f);
				Location location = border.getCenter();				
				world.strikeLightningEffect(location);
				sendServerTitle("", "Ring Movement Has Started", 3, 1, 'c' );
			}
		}.runTaskLater(main, 20 * (Time1 + RingTime1 + Time2 + RingTime2 + Time3 + RingTime3 + Time4)));

		
		setRound5(new BukkitRunnable() {
			@Override
			public void run() {
				setBorder(border6, RingTime5, 1);
				Location location = border.getCenter();
				world.strikeLightningEffect(location);
				sendServerTitle("", "Final Circle Has Started", 3, 1, 'c' );
			}
		}.runTaskLater(main, 20 * (Time1 + RingTime1 + Time2 + RingTime2 + Time3 + RingTime3 + Time4 + RingTime4 + Time5)));

		setRound6(new BukkitRunnable() {
			@Override
			public void run() {				
				border.setSize(1000);
				clearChests();
				setStartGame(false);
				for(Player player : Bukkit.getOnlinePlayers()) {
					bar.removePlayer(player);
				}
				main.onDisable();
			}
		}.runTaskLater(main, 20 * (Time1 + RingTime1 + Time2 + RingTime2 + Time3 + RingTime3 + Time4 + RingTime4 + Time5 + Time6 + 10)));
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
