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

import l2bot.pj.cosas.Character;


/**
 *
 * sample
 *
 * 0000: 3e 2a 89 00 4c 01 00 00 00                         .|...
 *
 * format   dd
 *
 * @version $Revision: 1.3.2.1.2.4 $ $Date: 2005/03/27 15:29:57 $
 */
public class ChangeMoveType extends L2GameServerPacket
{
	//private static final String _S__3E_CHANGEMOVETYPE = "[S] 28 ChangeMoveType";
	//public static final int WALK = 0;
	//public static final int RUN = 1;

	//private int _charObjId;
	//private boolean _running;

	//public ChangeMoveType(L2Character character)
	//{
		//_charObjId = character.getObjectId();
		//_running = character.isRunning();
	//}

	@Override
	   public void readP()
	{
		//writeC(0x28);
		Character chr = getPj().chars.get(readD());//writeD(_charObjId);
		chr.isRunning = readD()==1;//writeD(_running ? RUN : WALK);
		//writeD(0); //c2
	}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return _S__3E_CHANGEMOVETYPE;
	//}
}
