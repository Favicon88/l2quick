/*
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later
 * version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 * 
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package l2bot.network.game.ClientPackets;

////import *net.sf.l2j.gameserver.serverpackets.StopRotation;

/**
 * This class ...
 *
 * @version $Revision: 1.1.4.3 $ $Date: 2005/03/27 15:29:30 $
 */
public final class FinishRotating extends L2GameClientPacket
{
	private static final String _C__4B_FINISHROTATING = "[C] 4B FinishRotating";

	//private int _degree;
	//@SuppressWarnings("unused")
   // private int _unknown;

	////@Override
	protected void readImpl(int degree)
	{
                
		writeD(degree);//_degree = readD();
		writeD(0);//_unknown = readD();
	}
/*
	//@Override
	protected void runImpl()
	{
		if (getClient().getActiveChar() == null)
		    return;
		StopRotation sr = new StopRotation(getClient().getActiveChar(), _degree);
		getClient().getActiveChar().broadcastPacket(sr);
	}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.clientpackets.ClientBasePacket#getType()
	 */
	////@Override
	public String getType()
	{
		return _C__4B_FINISHROTATING;
	}
}
