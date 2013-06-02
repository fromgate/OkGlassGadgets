package me.fromgate.okgadgets;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.fromgate.fakeplayersonline.FPOcbo;
import me.fromgate.okglass.Gadget;

public class GadgetPlayerPing extends Gadget {

	@Override
	public String getName() {
		return "PlayerPing";
	}

	@Override
	public String getResultName() {
		return "&aAverage Ping:";
	}

	@Override
	public int getResultValue() {
		int pingsum=0;
		for (Player p: Bukkit.getOnlinePlayers())
			pingsum += FPOcbo.getPlayerPing(p);
		return Math.max(pingsum/Bukkit.getOnlinePlayers().length, 1); // if result is 0 it could be hidden from the scoreboard :(
	}
	

	@Override
	public void init() {
		//Don't need to init...
	}

}
