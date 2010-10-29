/**
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License 2
 * as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 * 
 * @author Stephan Preibisch
 */
package mpicbg.imglib.algorithm.function;

import mpicbg.imglib.function.Converter;
import mpicbg.imglib.type.numeric.RealType;

public class RealTypeConverter< A extends RealType<A>, B extends RealType<B> > implements Converter<A, B>
{
	@Override
	public void convert( final A input, final B output )
	{
		output.setReal( input.getRealDouble() );
	}
}