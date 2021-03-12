package com.test.selvakumar;

import org.bukkit.entity.Player;

public class BoardPlayer {
	Player player;
	public int score;
	public BoardPlayer(Player player, int score) {
		this.player = player;
		this.score = score;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public int getScore() {
		return this.score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void incrementScore() {
		this.score = this.score + 1;
	}
}
