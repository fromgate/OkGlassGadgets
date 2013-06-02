package me.fromgate.okgadgets;

import me.fromgate.okglass.Gadget;

import org.bukkit.Bukkit;
import org.bukkit.World;

public class GadgetChunks extends Gadget{

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getName() {
		return "Chunks";
	}

	@Override
	public String getResultName() {
		return "&eChunks";
	}

	@Override
	public int getResultValue() {
		int chunks = 0;
		for (World w : Bukkit.getWorlds()) 
			chunks += w.getLoadedChunks().length;
		return chunks;
	}

}
