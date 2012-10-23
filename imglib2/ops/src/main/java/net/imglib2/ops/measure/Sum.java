package net.imglib2.ops.measure;



public class Sum implements SamplingMeasurement {
	private boolean calculated = false;
	private double sum;
	
	public Sum() {}
	
	@Override
	public void preprocess(long[] origin) {
		sum = 0;
	}

	@Override
	public void dataValue(long[] pos, double value) {
		sum += value;
	}

	@Override
	public void postprocess() {
		calculated = true;
	}

	@Override
	public double getValue() {
		if (!calculated) return Double.NaN;
		return sum;
	}
}

