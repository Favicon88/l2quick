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
package l2bot.network.game.ServerPackets;

//import net.sf.l2j.gameserver.model.L2Character;

/**
 * 0000: 01  7a 73 10 4c  b2 0b 00 00  a3 fc 00 00  e8 f1 ff    .zs.L...........
 * 0010: ff  bd 0b 00 00  b3 fc 00 00  e8 f1 ff ff             .............

 *
 * ddddddd
 *
 * @version $Revision: 1.3.4.3 $ $Date: 2005/03/27 15:29:57 $
 */
public final class MoveToLocation extends L2GameServerPacket
{
	//private static final String _S__01_CHARMOVETOLOCATION = "[S] 2f MoveToLocation";
	//private int _charObjId, _x, _y, _z, _xDst, _yDst, _zDst;

	//public MoveToLocation(L2Character cha)
	//{
		//_charObjId = cha.getObjectId();
		//_x = cha.getX();
		//_y = cha.getY();
		//_z = cha.getZ();
		//_xDst = cha.getXdestination();
		//_yDst = cha.getYdestination();
		//_zDst = cha.getZdestination();
	//}

	@Override
	public void readP()
	{
		//writeC(0x2f);

		int objId = readD();//writeD(_charObjId);

		int x1 = readD();//writeD(_xDst);
		int y1 = readD();//writeD(_yDst);
		int z1 = readD();//writeD(_zDst);

		int x0 = readD();//writeD(_x);
		int y0 = readD();//writeD(_y);
		int z0 = readD();//writeD(_z);
	}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return _S__01_CHARMOVETOLOCATION;
	//}

}
