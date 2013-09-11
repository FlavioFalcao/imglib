/*
 * #%L
 * ImgLib2: a general-purpose, multidimensional image processing library.
 * %%
 * Copyright (C) 2009 - 2013 Stephan Preibisch, Tobias Pietzsch, Barry DeZonia,
 * Stephan Saalfeld, Albert Cardona, Curtis Rueden, Christian Dietz, Jean-Yves
 * Tinevez, Johannes Schindelin, Lee Kamentsky, Larry Lindsey, Grant Harris,
 * Mark Hiner, Aivar Grislis, Martin Horn, Nick Perry, Michael Zinsmaier,
 * Steffen Jaensch, Jan Funke, Mark Longair, and Dimiter Prodanov.
 * %%
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * 
 * 1. Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright notice,
 *    this list of conditions and the following disclaimer in the documentation
 *    and/or other materials provided with the distribution.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 * 
 * The views and conclusions contained in the software and documentation are
 * those of the authors and should not be interpreted as representing official
 * policies, either expressed or implied, of any organization.
 * #L%
 */

package net.imglib2.meta;

/**
 * @author Barry DeZonia
 */
public class CombinedCalibratedRealInterval<A extends CalibratedAxis, S extends CalibratedRealInterval<A>>
	extends CombinedRealInterval<A, S> implements CalibratedRealInterval<A>
{

	// TODO - these methods will need some TLC. Maybe this class will store its
	// own copy of calibration values and units. And then setUnit() and
	// setCalibration() on an axis does a unit converted scaling of existing axes
	// cal values. Pulling values out of this interval will use views and sampling
	// as needed to get values along unit/calibration converted points of the
	// underlying axes.

	@Override
	public void setUnit(String unit, int d) {
		axis(d).setUnit(unit);
	}

	@Override
	public String unit(int d) {
		return axis(d).unit();
	}

	@Override
	public double calibration(int d) {
		return axis(d).calibration();
	}

	@Override
	public void calibration(double[] cal) {
		for (int i = 0; i < cal.length; i++)
			cal[i] = calibration(i);
	}

	@Override
	public void calibration(float[] cal) {
		for (int i = 0; i < cal.length; i++)
			cal[i] = (float) calibration(i);
	}

	@Override
	public void setCalibration(double cal, int d) {
		// TODO: we could throw an UnsupportedOperationException. But this class
		// is already broken. Update this method later.
		axis(d).setCalibration(cal);
	}

	@Override
	public void setCalibration(double[] cal) {
		for (int i = 0; i < cal.length; i++)
			setCalibration(cal[i], i);
	}

	@Override
	public void setCalibration(float[] cal) {
		for (int i = 0; i < cal.length; i++)
			setCalibration(cal[i], i);
	}
}
