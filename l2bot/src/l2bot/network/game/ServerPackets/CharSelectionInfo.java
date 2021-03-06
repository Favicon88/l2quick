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

//import java.sql.PreparedStatement;

import l2bot.pj.ClassId;
import l2bot.pj.Race;
import l2bot.pj.handlers.CharSelectHandler.Char;

//import java.sql.ResultSet;
//import java.util.List;
//import java.util.logging.Logger;
//
//import javolution.util.FastList;
//import net.sf.l2j.L2DatabaseFactory;
//import net.sf.l2j.gameserver.datatables.ClanTable;
//import net.sf.l2j.gameserver.instancemanager.CursedWeaponsManager;
//import net.sf.l2j.gameserver.model.CharSelectInfoPackage;
//import net.sf.l2j.gameserver.model.Inventory;
//import net.sf.l2j.gameserver.model.L2Clan;
//import net.sf.l2j.gameserver.network.L2GameClient;

/**
 * This class ...
 *
 * @version $Revision: 1.8.2.4.2.6 $ $Date: 2005/04/06 16:13:46 $
 */
public class CharSelectionInfo extends L2GameServerPacket
{
    // d SdSddddddddddffddddddddddddddddddddddddddddddddddddddddddddddffd
    //private static final String _S__1F_CHARSELECTINFO = "[S] 09 CharSelectInfo";
    //private static Logger _log = Logger.getLogger(CharSelectionInfo.class.getName());
    //private String _loginName; 
    //private int _sessionId, _activeId;
    //private CharSelectInfoPackage[] _characterPackages;
    
    
    /**
     * @param _characters
     */
    //public CharSelectionInfo(String loginName, int sessionId)
    //{
        //_sessionId = sessionId;
        //_loginName = loginName;
        //_characterPackages = loadCharacterSelectInfo();
        //_activeId = -1;
    //}
    
    //public CharSelectionInfo(String loginName, int sessionId, int activeId)
    //{
        //_sessionId = sessionId;
        //_loginName = loginName;
        //_characterPackages = loadCharacterSelectInfo();
        //_activeId = activeId;
    //}
//    
    //public CharSelectInfoPackage[] getCharInfo()
    //{
        //return _characterPackages;
    //}
    
    @Override
    public void readP()
    {
        debugPacket();
        //writeC(0x09);
        //int size = (_characterPackages.length);
        int size = readD();//writeD(size);
        
        // Can prevent players from creating new characters (if 0); (if 1, the client will ask if chars may be created (0x13) Response: (0x0D) )
        readD();//writeD(0x07);
        readC();//writeC(0x00);
//        
        //long lastAccess = 0L;
//        
        //if (_activeId == -1)
        //{
            //for (int i = 0; i < size; i++)
            //{
                //if (lastAccess < _characterPackages[i].getLastAccess())
                //{
                    //lastAccess = _characterPackages[i].getLastAccess();
                    //_activeId = i;
                //}
            //}
        //}
       
        for (int i = 0; i < size; i++)
        {
            Char ch = getPj().charSelectHandler.addChar();
                    
            
            //CharSelectInfoPackage charInfoPackage = _characterPackages[i];
        
            ch.nombre = readS();//writeS(charInfoPackage.getName());
            ch.id = readD();//writeD(charInfoPackage.getCharId());
            ch.LoginName = readS();//writeS(_loginName);
            ch.sessionId = readD();//writeD(_sessionId);
            ch.clanId = readD();//writeD(charInfoPackage.getClanId());
            readD();//writeD(0x00); // ??
            
            ch.sexo = readD();//writeD(charInfoPackage.getSex());
            
            ch.raza = Race.values()[readD()];//writeD(charInfoPackage.getRace());
            
            //if (charInfoPackage.getClassId() == charInfoPackage.getBaseClassId())
            int cl = readD();
            ch.clase = ClassId.values()[cl];    //writeD(charInfoPackage.getClassId());
            //else
                //writeD(charInfoPackage.getBaseClassId());
            
            readD();//writeD(0x01); // active ??
            
            readD();//writeD(0x00); // x
            readD();//writeD(0x00); // y
            readD();//writeD(0x00); // z
            
            ch.hp = readF();//writeF(charInfoPackage.getCurrentHp()); // hp cur
            ch.mp = readF();//writeF(charInfoPackage.getCurrentMp()); // mp cur
            
            ch.sp = readD();//writeD(charInfoPackage.getSp());
            ch.exp = readQ();//writeQ(charInfoPackage.getExp());
            ch.lvl = readD();//writeD(charInfoPackage.getLevel());
            
            ch.karma = readD();//writeD(charInfoPackage.getKarma()); // karma
            ch.pkkils = readD();//writeD(charInfoPackage.getPkKills());
            
            readD();//writeD(0x00);
            readD();//writeD(0x00);
            readD();//writeD(0x00);
            readD();//writeD(0x00);
            readD();//writeD(0x00);
            readD();//writeD(0x00);
            readD();//writeD(0x00);
            readD();//writeD(0x00);
            
            ch.hairAll = readD();//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_HAIRALL));
            ch.rEar = readD();//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_REAR));
            ch.lEar = readD();//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_LEAR));
            ch.neck = readD();//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_NECK));
            ch.rFinger = readD();//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_RFINGER));
            ch.lFinger = readD();//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_LFINGER));
            ch.head = readD();//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_HEAD));
            ch.rHand = readD();//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_RHAND));
            ch.lHand = readD();//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_LHAND));
            ch.gloves = readD();//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_GLOVES));
            ch.chest = readD();//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_CHEST));
            ch.legs = readD();//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_LEGS));
            ch.feet = readD();//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_FEET));
            ch.back = readD();//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_BACK));
            ch.lrHand = readD();//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_LRHAND));
            ch.hair= readD();//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_HAIR));
            ch.hair2 = readD();//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_HAIR2));
            
            ch.rBraz = readD();//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_RBRACELET));
            ch.lBraz = readD();//writeD(charInfoPackage.getPaperdollItemId(Inventory.PAPERDOLL_LBRACELET));
            readD();//writeD(0x00);
            readD();//writeD(0x00);
            readD();//writeD(0x00);
            readD();//writeD(0x00);
            readD();//writeD(0x00);
            readD();//writeD(0x00);
            ch.hairColor = readD();//writeD(charInfoPackage.getHairStyle());
            ch.hairStyle = readD();//writeD(charInfoPackage.getHairColor());
            ch.face = readD();//writeD(charInfoPackage.getFace());
            
            ch.maxHp = readF();//writeF(charInfoPackage.getMaxHp()); // hp max
            ch.maxMp = readF();//writeF(charInfoPackage.getMaxMp()); // mp max
            
            //long deleteTime = charInfoPackage.getDeleteTimer();
            //int deletedays = 0;
            //if (deleteTime > 0)
                //deletedays = (int)((deleteTime-System.currentTimeMillis())/1000);
            ch.deleteDays = readD();//writeD(deletedays); // days left before
            //// delete .. if != 0
            //// then char is inactive
            readD();//writeD(charInfoPackage.getClassId());
            //if (i == _activeId)
            readD();    //writeD(0x01);
            //else
                //writeD(0x00); //c3 auto-select char
            
            ch.weaponEnchantment = readC();//writeC(charInfoPackage.getEnchantEffect() > 127 ? 127 : charInfoPackage.getEnchantEffect());
            
            ch.argumentationId = readH();//writeH(charInfoPackage.getAugmentationId());
            readH();//writeH(0x00); // this is for augmentation too
            
            ///readD();////writeD(charInfoPackage.getTransformId()); // Used to display Transformations  
            readD();//writeD(0x00); // Currently on retail when you are on character select you don't see your transformation.
            
        }
        getPj().charSelectHandler.showDialog();
    }
    
    //private CharSelectInfoPackage[] loadCharacterSelectInfo()
    //{
        //CharSelectInfoPackage charInfopackage;
        //List<CharSelectInfoPackage> characterList = new FastList<CharSelectInfoPackage>();
        
        //java.sql.Connection con = null;
        
        //try
        //{
            //con = L2DatabaseFactory.getInstance().getConnection();
            //PreparedStatement statement = con.prepareStatement("SELECT account_name, charId, char_name, level, maxHp, curHp, maxMp, curMp, face, hairStyle, hairColor, sex, heading, x, y, z, exp, sp, karma, pvpkills, pkkills, clanid, race, classid, deletetime, cancraft, title, rec_have, rec_left, accesslevel, online, char_slot, lastAccess, base_class, transform_id FROM characters WHERE account_name=?");
            //statement.setString(1, _loginName);
            //ResultSet charList = statement.executeQuery();
//            
            //while (charList.next())// fills the package
            //{
                //charInfopackage = restoreChar(charList);
                //if ( charInfopackage != null )
                    //characterList.add(charInfopackage);
            //}
//            
            //charList.close();
            //statement.close();
//            
            //return characterList.toArray(new CharSelectInfoPackage[characterList.size()]);
        //}
        //catch (Exception e)
        //{
            //_log.warning("Could not restore char info: " + e);
        //}
        //finally
        //{
            //try { con.close(); } catch (Exception e) {}
        //}
//        
        //return new CharSelectInfoPackage[0];
    //}
//    
    //private void loadCharacterSubclassInfo(CharSelectInfoPackage charInfopackage, int ObjectId, int activeClassId)
    //{
        //java.sql.Connection con = null;
//        
        //try
        //{
            //con = L2DatabaseFactory.getInstance().getConnection();
            //PreparedStatement statement = con.prepareStatement("SELECT exp, sp, level FROM character_subclasses WHERE charId=? && class_id=? ORDER BY charId");
            //statement.setInt(1, ObjectId);
            //statement.setInt(2, activeClassId);
            //ResultSet charList = statement.executeQuery();
//            
            //if (charList.next())
            //{
                //charInfopackage.setExp(charList.getLong("exp"));
                //charInfopackage.setSp(charList.getInt("sp"));
                //charInfopackage.setLevel(charList.getInt("level"));
            //}
//            
            //charList.close();
            //statement.close();
//            
        //}
        //catch (Exception e)
        //{
            //_log.warning("Could not restore char subclass info: " + e);
        //}
        //finally
        //{
            //try { con.close(); } catch (Exception e) {}
        //}
//        
    //}
//    
//    
    //private CharSelectInfoPackage restoreChar(ResultSet chardata) throws Exception
    //{
        //int objectId = chardata.getInt("charId");
        //String name = chardata.getString("char_name");
//
        //// See if the char must be deleted
        //long deletetime = chardata.getLong("deletetime");
        //if (deletetime > 0)
        //{
            //if (System.currentTimeMillis() > deletetime)
            //{
                //L2Clan clan = ClanTable.getInstance().getClan(chardata.getInt("clanid"));
                //if(clan != null)
                    //clan.removeClanMember(objectId, 0);
//                
                //L2GameClient.deleteCharByObjId(objectId);
                //return null;
            //}
        //}
//        
        //CharSelectInfoPackage charInfopackage = new CharSelectInfoPackage(objectId, name);
        //charInfopackage.setLevel(chardata.getInt("level"));
        //charInfopackage.setMaxHp(chardata.getInt("maxhp"));
        //charInfopackage.setCurrentHp(chardata.getDouble("curhp"));
        //charInfopackage.setMaxMp(chardata.getInt("maxmp"));
        //charInfopackage.setCurrentMp(chardata.getDouble("curmp"));
        //charInfopackage.setKarma(chardata.getInt("karma"));
        //charInfopackage.setPkKills(chardata.getInt("pkkills"));
        //charInfopackage.setFace(chardata.getInt("face"));
        //charInfopackage.setHairStyle(chardata.getInt("hairstyle"));
        //charInfopackage.setHairColor(chardata.getInt("haircolor"));
        //charInfopackage.setSex(chardata.getInt("sex"));
//        
        //charInfopackage.setExp(chardata.getLong("exp"));
        //charInfopackage.setSp(chardata.getInt("sp"));
        //charInfopackage.setClanId(chardata.getInt("clanid"));
//        
        //charInfopackage.setRace(chardata.getInt("race"));
//        
        //final int baseClassId = chardata.getInt("base_class");
        //final int activeClassId = chardata.getInt("classid");
//        
        //// if is in subclass, load subclass exp, sp, lvl info
        //if(baseClassId != activeClassId)
            //loadCharacterSubclassInfo(charInfopackage, objectId, activeClassId);
//        
        //charInfopackage.setClassId(activeClassId);
//        
        //// Get the augmentation id for equipped weapon
        //int weaponObjId = charInfopackage.getPaperdollObjectId(Inventory.PAPERDOLL_LRHAND);
        //if (weaponObjId < 1)
            //weaponObjId = charInfopackage.getPaperdollObjectId(Inventory.PAPERDOLL_RHAND);
//        
        //// Check Transformation
        //int cursedWeaponId = CursedWeaponsManager.getInstance().checkOwnsWeaponId(objectId);
        //if (cursedWeaponId > 0)
        //{
            //// cursed weapon transformations
            //if(cursedWeaponId == 8190)
                //charInfopackage.setTransformId(301);
            //else if(cursedWeaponId == 8689)
                //charInfopackage.setTransformId(302);
            //else
                //charInfopackage.setTransformId(0);
        //}
        //else if (chardata.getInt("transform_id") > 0)
        //{
            //charInfopackage.setTransformId(chardata.getInt("transform_id"));
        //}
        //else
            //charInfopackage.setTransformId(0);
//        
        //if (weaponObjId > 0)
        //{
            //java.sql.Connection con = null;
            //try
            //{
                //con = L2DatabaseFactory.getInstance().getConnection();
                //PreparedStatement statement = con.prepareStatement("SELECT attributes FROM augmentations WHERE item_id=?");
                //statement.setInt(1, weaponObjId);
                //ResultSet result = statement.executeQuery();
//                
                //if (result.next())
                //{
                    //charInfopackage.setAugmentationId(result.getInt("attributes"));
                //}
//                
                //result.close();
                //statement.close();
            //}
            //catch (Exception e)
            //{
                //_log.warning("Could not restore augmentation info: " + e);
            //}
            //finally { try { con.close(); } catch (Exception e) {} }
        //}
//        
        ///*
         //* Check if the base class is set to zero and alse doesn't match
         //* with the current active class, otherwise send the base class ID.
         //*
         //* This prevents chars created before base class was introduced
         //* from being displayed incorrectly.
         //*/
        //if (baseClassId == 0 && activeClassId > 0)
            //charInfopackage.setBaseClassId(activeClassId);
        //else
            //charInfopackage.setBaseClassId(baseClassId);
//        
        //charInfopackage.setDeleteTimer(deletetime);
        //charInfopackage.setLastAccess(chardata.getLong("lastAccess"));
        //return charInfopackage;
    //}
//    
    //@Override
    //public String getType()
    //{
        //return _S__1F_CHARSELECTINFO;
    //}

}
