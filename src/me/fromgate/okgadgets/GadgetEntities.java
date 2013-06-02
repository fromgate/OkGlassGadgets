package me.fromgate.okgadgets;

import me.fromgate.okglass.Gadget;

import org.bukkit.Bukkit;
import org.bukkit.World;

public class GadgetEntities extends Gadget{

	@Override
	public void init() {
		// TODO Auto-generated method stub
	}

	@Override
	public String getName() {
		return "Entities";
	}

	@Override
	public String getResultName() {
		return "&eEntities";
	}

	@Override
	public int getResultValue() {
		int e = 0;
		for (World w : Bukkit.getWorlds()) 
			e += w.getEntities().size();		
		return e;
	}

}
