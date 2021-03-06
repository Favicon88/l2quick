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
/*
//import *java.util.logging.Logger;

//import *net.sf.l2j.Config;
//import *net.sf.l2j.gameserver.model.L2ItemInstance;
//import *net.sf.l2j.gameserver.model.actor.instance.L2PcInstance;
//import *net.sf.l2j.gameserver.model.actor.instance.L2PetInstance;
//import *net.sf.l2j.gameserver.network.SystemMessageId;
//import *net.sf.l2j.gameserver.serverpackets.SystemMessage;

/**
 * This class ...
 *
 * @version $Revision: 1.3.2.1.2.5 $ $Date: 2005/03/29 23:15:33 $
 */
public final class RequestGiveItemToPet extends L2GameClientPacket
{
	private static final String REQUESTCIVEITEMTOPET__C__8B = "[C] 8B RequestGiveItemToPet";
	
	//private static Logger _log = Logger.getLogger(RequestGetItemFromPet.class.getName());
	
	//private int _objectId;
	
	//private int _amount;
	
	////@Override
	protected void readImpl(int id, int can)
	{
		writeD(id);//_objectId = readD();
		writeD(can);//_amount = readD();
	}
	/*
	//@Override
	protected void runImpl()
	{
		L2PcInstance player = getClient().getActiveChar();
		if (player == null || !(player.getPet() instanceof L2PetInstance))
			return;
		
		// Alt game - Karma punishment
		if (!Config.ALT_GAME_KARMA_PLAYER_CAN_TRADE && player.getKarma() > 0)
			return;
		
		if (player.getPrivateStoreType() != 0)
		{
			player.sendMessage("Cannot exchange items while trading");
			return;
		}
		
		// Exploit Fix for Hero weapons Uses pet Inventory to buy New One.
		// [L2JOneo]
		L2ItemInstance item = player.getInventory().getItemByObjectId(_objectId);
		
		if (item == null)
			return;
		
		if (item.isHeroItem())
		{
			player.sendMessage("Duo To Hero Weapons Protection u Canot Use Pet's Inventory");
			return;
		}
		
		if (item.isAugmented())
			return;
		
		L2PetInstance pet = (L2PetInstance) player.getPet();
		if (pet.isDead())
		{
			sendPacket(new SystemMessage(SystemMessageId.CANNOT_GIVE_ITEMS_TO_DEAD_PET));
			return;
		}
		
		if (_amount < 0)
		{
			return;
		}
		
		if (player.transferItem("Transfer", _objectId, _amount, pet.getInventory(), pet) == null)
		{
			_log.warning("Invalid item transfer request: " + pet.getName() + "(pet) --> " + player.getName());
		}
	}
	
	//@Override*/
	public String getType()
	{
		return REQUESTCIVEITEMTOPET__C__8B;
	}
}
