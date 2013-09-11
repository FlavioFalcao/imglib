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

import net.imglib2.RealInterval;
import net.imglib2.RealPositionable;

/**
 * @author Barry DeZonia
 */
public abstract class AbstractCalibratedRealInterval<A extends CalibratedAxis>
	extends AbstractCalibratedSpace<A> implements CalibratedRealInterval<A>
{

	private final double[] min;
	private final double[] max;

	public AbstractCalibratedRealInterval(RealInterval interval) {
		super(interval.numDimensions());
		this.min = new double[interval.numDimensions()];
		this.max = min.clone();
		interval.realMin(min);
		interval.realMax(max);
	}

	public AbstractCalibratedRealInterval(RealInterval interval, A... axes) {
		super(axes);
		if (interval.numDimensions() != axes.length) {
			throw new IllegalArgumentException("dimensions do not match");
		}
		this.min = new double[interval.numDimensions()];
		this.max = min.clone();
		interval.realMin(min);
		interval.realMax(max);
	}

	public AbstractCalibratedRealInterval(RealInterval interval, List<A> axes) {
		super(axes);
		if (interval.numDimensions() != axes.size()) {
			throw new IllegalArgumentException("dimensions do not match");
		}
		this.min = new double[interval.numDimensions()];
		this.max = min.clone();
		interval.realMin(min);
		interval.realMax(max);
	}

	public AbstractCalibratedRealInterval(double[] extents) {
		super(extents.length);
		this.min = new double[extents.length];
		this.max = extents.clone();
	}

	public AbstractCalibratedRealInterval(double[] extents, A... axes) {
		super(axes);
		if (extents.length != axes.length) {
			throw new IllegalArgumentException("dimensions do not match");
		}
		this.min = new double[extents.length];
		this.max = extents.clone();
	}

	public AbstractCalibratedRealInterval(double[] extents, List<A> axes) {
		super(axes);
		if (extents.length != axes.size()) {
			throw new IllegalArgumentException("dimensions do not match");
		}
		this.min = new double[extents.length];
		this.max = extents.clone();
	}

	public AbstractCalibratedRealInterval(double[] min, double[] max) {
		super(min.length);
		if (min.length != max.length) {
			throw new IllegalArgumentException("dimensions do not match");
		}
		this.min = min.clone();
		this.max = max.clone();
	}

	public AbstractCalibratedRealInterval(double[] min, double[] max, A... axes) {
		super(axes);
		if ((min.length != max.length) || (min.length != axes.length)) {
			throw new IllegalArgumentException("dimensions do not match");
		}
		this.min = min.clone();
		this.max = max.clone();
	}

	public AbstractCalibratedRealInterval(double[] min, double[] max, List<A> axes)
	{
		super(axes);
		if ((min.length != max.length) || (min.length != axes.size())) {
			throw new IllegalArgumentException("dimensions do not match");
		}
		this.min = min.clone();
		this.max = max.clone();
	}

	@Override
	public double realMax(int d) {
		return max[d];
	}

	@Override
	public void realMax(double[] dest) {
		for (int i = 0; i < dest.length; i++) {
			dest[i] = realMax(i);
		}
	}

	@Override
	public void realMax(RealPositionable dest) {
		for (int i = 0; i < dest.numDimensions(); i++) {
			dest.setPosition(realMax(i), i);
		}
	}

	@Override
	public double realMin(int d) {
		return min[d];
	}

	@Override
	public void realMin(double[] dest) {
		for (int i = 0; i < dest.length; i++) {
			dest[i] = realMin(i);
		}
	}

	@Override
	public void realMin(RealPositionable dest) {
		for (int i = 0; i < dest.numDimensions(); i++) {
			dest.setPosition(realMin(i), i);
		}
	}

}
