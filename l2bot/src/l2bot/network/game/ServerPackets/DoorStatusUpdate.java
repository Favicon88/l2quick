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

//import net.sf.l2j.gameserver.model.actor.instance.L2DoorInstance;

/**
 * 61
 * d6 6d c0 4b		door id
 * 8f 14 00 00 		x
 * b7 f1 00 00 		y
 * 60 f2 ff ff 		z
 * 00 00 00 00 		??
 *
 * format  dddd    rev 377  ID:%d X:%d Y:%d Z:%d
 *         ddddd   rev 419
 *
 * @version $Revision: 1.3.2.2.2.3 $ $Date: 2005/03/27 15:29:57 $
 */
public final class DoorStatusUpdate extends L2GameServerPacket
{
	//private static final String _S__61_DOORSTATUSUPDATE = "[S] 4d DoorStatusUpdate";
	//private L2DoorInstance _door;

	//public DoorStatusUpdate(L2DoorInstance door)
	//{
		//_door=door;
	//}

	@Override
        public void readP()
	{
		//writeC(0x4d);
		int objId = readD();//writeD(_door.getObjectId());
		int open = readD();//writeD(_door.getOpen());
		int damage = readD();//writeD(_door.getDamage());
		boolean enemy = readD() != 0x00; //writeD(_door.isEnemy() ? 1 : 0);
		int id = readD();//writeD(_door.getDoorId());
		int hp = readD();//writeD((int)_door.getCurrentHp());
		int maxHp = readD();//writeD(_door.getMaxHp());
	}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		////return _S__61_DOORSTATUSUPDATE;
	//}
}