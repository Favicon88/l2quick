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

//import javolution.util.FastList;
//import net.sf.l2j.gameserver.instancemanager.CastleManager;
//import net.sf.l2j.gameserver.instancemanager.CastleManorManager;
//import net.sf.l2j.gameserver.instancemanager.CastleManorManager.SeedProduction;
//import net.sf.l2j.gameserver.model.L2Manor;
//import net.sf.l2j.gameserver.model.entity.Castle;

/**
 * format(packet 0xFE) ch dd [ddcdcdddddddd] c - id h - sub id
 * 
 * d - manor id d - size
 *  [ d - seed id d - level c d - reward 1 id c d - reward 2 id d - next sale
 * limit d - price for castle to produce 1 d - min seed price d - max seed price
 * d - today sales d - today price d - next sales d - next price ]
 * 
 * @author l3x
 */
public class ExShowSeedSetting extends L2GameServerPacket
{
    //private static final String _S__FE_1F_EXSHOWSEEDSETTING = "[S] FE:26 ExShowSeedSetting";
    
    //private int _manorId;
    
    //private int _count;
    
    //private int[] _seedData; // data to send, size:_count*12
    
    //@Override
    //public void runImpl()
    //{
    //}
    
    //public ExShowSeedSetting(int manorId)
    //{
        //_manorId = manorId;
        //Castle c = CastleManager.getInstance().getCastleById(_manorId);
        //FastList<Integer> seeds = L2Manor.getInstance().getSeedsForCastle(
                //_manorId);
        //_count = seeds.size();
        //_seedData = new int[_count * 12];
        //int i = 0;
        //for (int s : seeds)
        //{
            //_seedData[i * 12 + 0] = s;
            //_seedData[i * 12 + 1] = L2Manor.getInstance().getSeedLevel(s);
            //_seedData[i * 12 + 2] = L2Manor.getInstance().getRewardItemBySeed(
                    //s, 1);
            //_seedData[i * 12 + 3] = L2Manor.getInstance().getRewardItemBySeed(
                    //s, 2);
            //_seedData[i * 12 + 4] = L2Manor.getInstance().getSeedSaleLimit(s);
            //_seedData[i * 12 + 5] = L2Manor.getInstance().getSeedBuyPrice(s);
            //_seedData[i * 12 + 6] = L2Manor.getInstance().getSeedBasicPrice(s) * 60 / 100;
            //_seedData[i * 12 + 7] = L2Manor.getInstance().getSeedBasicPrice(s) * 10;
            //SeedProduction seedPr = c.getSeed(s,
                    //CastleManorManager.PERIOD_CURRENT);
            //if (seedPr != null)
            //{
                //_seedData[i * 12 + 8] = seedPr.getStartProduce();
                //_seedData[i * 12 + 9] = seedPr.getPrice();
            //}
            //else
            //{
                //_seedData[i * 12 + 8] = 0;
                //_seedData[i * 12 + 9] = 0;
            //}
            //seedPr = c.getSeed(s, CastleManorManager.PERIOD_NEXT);
            //if (seedPr != null)
            //{
                //_seedData[i * 12 + 10] = seedPr.getStartProduce();
                //_seedData[i * 12 + 11] = seedPr.getPrice();
            //}
            //else
            //{
                //_seedData[i * 12 + 10] = 0;
                //_seedData[i * 12 + 11] = 0;
            //}
            //i++;
        //}
    //}
    
    @Override
    public void readP()
    {
        //writeC(0xFE); // Id
        readH();//writeH(0x26); // SubId
        
        int mid = readD();//writeD(_manorId); // manor id
        int s =readD();//writeD(_count); // size
        
        for (int i = 0; i < s; i++)
        {
            int id = readD();//writeD(_seedData[i * 12 + 0]); // seed id
            int lvl = readD();//writeD(_seedData[i * 12 + 1]); // level
            readC();//writeC(1);
            int reward1 = readD();//writeD(_seedData[i * 12 + 2]); // reward 1 id
            readC();//writeC(1);
            int reward2 = readD();//writeD(_seedData[i * 12 + 3]); // reward 2 id
            
            int nextLimit = readD();//writeD(_seedData[i * 12 + 4]); // next sale limit
            int price4one = readD();//writeD(_seedData[i * 12 + 5]); // price for castle to produce 1
            int minprice = readD();//writeD(_seedData[i * 12 + 6]); // min seed price
            int maxprice = readD();//writeD(_seedData[i * 12 + 7]); // max seed price
      
            int todaysales = readD();//writeD(_seedData[i * 12 + 8]); // today sales
            int todayprice = readD();//writeD(_seedData[i * 12 + 9]); // today price
            int nextsales = readD();//writeD(_seedData[i * 12 + 10]); // next sales
            int nextprice = readD();//writeD(_seedData[i * 12 + 11]); // next price
        }
    }
    
    //@Override
    //public String getType()
    //{
        //return _S__FE_1F_EXSHOWSEEDSETTING;
    //}
}
