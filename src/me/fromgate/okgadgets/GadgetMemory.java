package me.fromgate.okgadgets;

import me.fromgate.okglass.Gadget;


public class GadgetMemory extends Gadget{
	boolean gb = false;

	@Override
	public void init() {
		gb = this.loadBoolean("gigabytes", false);
	}

	@Override
	public String getName() {
		return "Memory";
	}

	@Override
	public String getResultName() {
		int max = (int) Math.max(Runtime.getRuntime().totalMemory(), Runtime.getRuntime().maxMemory())/1024/1024;
		int used = (int) (max-(Runtime.getRuntime().freeMemory()/1024/1024));
		return "&aMem "+(gb ? (used/1000) : used)+(gb ? "Gb" : "Mb")+" / %";
	}

	@Override
	public int getResultValue() {
		double max = Math.max(Runtime.getRuntime().totalMemory(), Runtime.getRuntime().maxMemory())/1024/1024;
		double free = Runtime.getRuntime().freeMemory()/1024/1024;
		double prc = ((max-free)/max)*100;
		return (int) Math.round(prc);
	}
}
