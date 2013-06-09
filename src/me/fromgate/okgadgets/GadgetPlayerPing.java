package me.fromgate.okgadgets;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import me.fromgate.fakeplayersonline.FPOcbo;
import me.fromgate.okglass.Gadget;

public class GadgetPlayerPing extends Gadget {

	boolean fpo_installed=false;
	boolean show_average = true;
	boolean show_yourping = true;
	
	@Override
	public String getName() {
		return "PlayerPing";
	}

	public int getAveragePing() {
		if (!fpo_installed) return -1;
		int pingsum=0;
		for (Player p: Bukkit.getOnlinePlayers())
			pingsum += getPlayerPing(p);
		return Math.max(pingsum/Bukkit.getOnlinePlayers().length, 1); // if result is 0 it could be hidden from the scoreboard :(
	}
	
	public int getPlayerPing(){
		return getPlayerPing(getPlayer());
	}
	
	public int getPlayerPing (Player p){
		if (!fpo_installed) return -1;
		return Math.max(1, FPOcbo.getPlayerPing(p));
	}
	

	@Override
	public void onEnable() {
	   Plugin fpo = Bukkit.getPluginManager().getPlugin("FakePlayersOnline");
	   fpo_installed = (fpo!=null);
	   show_average=loadBoolean("show-average-ping", true);
	   show_yourping=loadBoolean("show-player-ping", true);
	}

	@Override
	public void onDisable() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void process() {
		if (show_average) addResult("Average Ping",getAveragePing());
		if (show_yourping) addResult(getPlayer().getName()+" ☇",getPlayerPing());
		
	}

}
