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

//import java.util.Map;

//import net.sf.l2j.gameserver.Olympiad;
//import net.sf.l2j.gameserver.model.entity.Hero;
//import net.sf.l2j.gameserver.templates.StatsSet;

/**
 * Format: (ch) d [SdSdSdd]
 * d: size
 * [
 * S: hero name
 * d: hero class ID
 * S: hero clan name
 * d: hero clan crest id
 * S: hero ally name
 * d: hero Ally id
 * d: count
 * ]
 * @author -Wooden-
 * Format from KenM
 *
 * Re-written by godson
 *
 */
public class ExHeroList extends L2GameServerPacket
{
	//private static final String _S__FE_23_EXHEROLIST = "[S] FE:79 ExHeroList";
	//private Map<Integer, StatsSet> _heroList;

	//public ExHeroList()
	/////{
		//_heroList = Hero.getInstance().getHeroes();
	//}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.serverpackets.ServerBasePacket#writeImpl()
	 */
	@Override
	public void readP()
	{
		//writeC(0xfe);
		readH();//writeH(0x79);
		int s = readD();//writeD(_heroList.size());

		//for(Integer heroId : _heroList.keySet())
                for (int i = 0; i <s; i++) 
		{
                        //StatsSet hero = _heroList.get(heroId);
			String name = readS();//writeS(hero.getString(Olympiad.CHAR_NAME));
			int Class = readD();//writeD(hero.getInteger(Olympiad.CLASS_ID));
			String clan = readS();//writeS(hero.getString(Hero.CLAN_NAME, ""));
			int crest = readD();//writeD(hero.getInteger(Hero.CLAN_CREST, 0));
			String ally = readS();//writeS(hero.getString(Hero.ALLY_NAME, ""));
			int allyCrest = readD();//writeD(hero.getInteger(Hero.ALLY_CREST, 0));
			int count = readD();//writeD(hero.getInteger(Hero.COUNT));
		}

	}

	/* (non-Javadoc)
	 * @see net.sf.l2j.gameserver.BasePacket#getType()
	 */
	//@Override
	//public String getType()
	//{
		//return _S__FE_23_EXHEROLIST;
	//}

}