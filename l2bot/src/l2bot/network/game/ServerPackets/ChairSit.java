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

//import net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;

/**
 * sample

 * format
 * d
 *
 * @version $Revision: 1.1.2.1.2.3 $ $Date: 2005/03/27 15:29:39 $
 */
public class ChairSit extends L2GameServerPacket
{
    //private static final String _S__e1_CHAIRSIT = "[S] ed ChairSit";

    //private L2PcInstance _activeChar;
    //private int _staticObjectId;

    /**
     */
    //public ChairSit()
    //{
        //_activeChar = player;
        //_staticObjectId = staticObjectId;
    //}

    @Override
    public void readP()
    {
        //writeC(0xed);
        readD();//writeD(_activeChar.getObjectId());
        int chair = readD();//writeD(_staticObjectId);
    }

    /* (non-Javadoc)
     * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#getType()
     */
    //@Override
	//public String getType()
    //{
        //return _S__e1_CHAIRSIT;
    //}
}
