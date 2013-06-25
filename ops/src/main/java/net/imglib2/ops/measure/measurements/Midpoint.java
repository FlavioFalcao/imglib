package net.imglib2.ops.measure.measurements;

import net.imglib2.ops.measure.Measurement;


public class Midpoint implements Measurement {

	private Maximum max;
	private Minimum min;
	
	public Midpoint(Maximum max, Minimum min) {
		this.max = max;
		this.min = min;
	}
	
	@Override
	public double getValue() {
		return (max.getValue() + min.getValue()) / 2;
	}

}
