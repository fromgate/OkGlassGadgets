package me.fromgate.okgadgets;

import me.fromgate.okglass.Gadget;


public class GadgetMemory extends Gadget{
	boolean gb = false;

	@Override
	public void onEnable() {
		gb = this.loadBoolean("gigabytes", false);
	}

	@Override
	public String getName() {
		return "Memory";
	}

	public String getMemoryStr() {
		int max = (int) (Math.max(Runtime.getRuntime().totalMemory(), Runtime.getRuntime().maxMemory())/1024/1024);
		int used = (int) (max-(Runtime.getRuntime().freeMemory()/1024/1024));
		return "Mem "+(gb ? (used/1024) : used)+(gb ? "Gb" : "Mb")+" / %";
	}

	public int getUsedMemoryPercent() {
		double max = Math.max(Runtime.getRuntime().totalMemory(), Runtime.getRuntime().maxMemory())/1024/1024;
		double free = Runtime.getRuntime().freeMemory()/1024/1024;
		double prc = ((max-free)/max)*100;
		return (int) Math.round(prc);
	}

	@Override
	public void onDisable() {
	}

	@Override
	public void process() {
		addResult(getMemoryStr(),getUsedMemoryPercent());
	}
}
