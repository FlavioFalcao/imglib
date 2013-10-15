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

import java.util.List;

import net.imglib2.meta.axis.LinearAxis;

/**
 * Abstract base class for {@link CalibratedSpace}.
 * 
 * @author Curtis Rueden
 */
public abstract class AbstractCalibratedSpace<A extends CalibratedAxis> extends
	AbstractTypedSpace<A> implements CalibratedSpace<A>
{

	public AbstractCalibratedSpace(final int numDims) {
		super(numDims);
	}

	public AbstractCalibratedSpace(final A... axes) {
		super(axes);
	}

	public AbstractCalibratedSpace(final List<A> axes) {
		super(axes);
	}

	// -- CalibratedSpace methods --

	@Override
	public double averageScale(final int d) {
		return averageScale(d);
	}

	@Deprecated
	@Override
	public double calibration(final int d) {
		return linearAxis(d).scale();
	}

	@Deprecated
	@Override
	public void calibration(final double[] cal) {
		for (int d = 0; d < numDimensions(); d++) {
			cal[d] = calibration(d);
		}
	}

	@Deprecated
	@Override
	public void calibration(final float[] cal) {
		for (int d = 0; d < numDimensions(); d++) {
			cal[d] = (float) calibration(d);
		}
	}

	@Deprecated
	@Override
	public void setCalibration(final double cal, final int d) {
		linearAxis(d).setScale(cal);
	}

	@Deprecated
	@Override
	public void setCalibration(final double[] cal) {
		for (int d = 0; d < numDimensions(); d++) {
			setCalibration(cal[d], d);
		}
	}

	@Deprecated
	@Override
	public void setCalibration(final float[] cal) {
		for (int d = 0; d < numDimensions(); d++) {
			setCalibration(cal[d], d);
		}
	}

	@Deprecated
	@Override
	public String unit(final int d) {
		return axis(d).unit();
	}

	@Deprecated
	@Override
	public void setUnit(final String unit, final int d) {
		axis(d).setUnit(unit);
	}

	// -- Helper methods --

	// NB: Only exists to fulfill deprecated method implementations above.
	// Will go away in a subsequent release to eliminate LinearAxis dependency.
	private LinearAxis linearAxis(final int d) {
		final A axis = axis(d);
		if (axis instanceof LinearAxis) {
			return (LinearAxis) axis;
		}
		throw new IllegalArgumentException("Unsupported axis: " +
			axis.getClass().getName());
	}

}
