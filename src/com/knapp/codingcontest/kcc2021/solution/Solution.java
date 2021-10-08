/* -*- java -*- ************************************************************************** *
 *
 *                     Copyright (C) KNAPP AG
 *
 *   The copyright to the computer program(s) herein is the property
 *   of Knapp.  The program(s) may be used   and/or copied only with
 *   the  written permission of  Knapp  or in  accordance  with  the
 *   terms and conditions stipulated in the agreement/contract under
 *   which the program(s) have been supplied.
 *
 * *************************************************************************************** */

package com.knapp.codingcontest.kcc2021.solution;

import java.util.*;

import com.knapp.codingcontest.kcc2021.data.InputData;
import com.knapp.codingcontest.kcc2021.data.Institute;
import com.knapp.codingcontest.kcc2021.data.Packet;
import com.knapp.codingcontest.kcc2021.data.Pallet;
import com.knapp.codingcontest.kcc2021.data.Pallet.PacketPos;
import com.knapp.codingcontest.kcc2021.data.PalletType;
import com.knapp.codingcontest.kcc2021.warehouse.PalletExtendsViolatedException;
import com.knapp.codingcontest.kcc2021.warehouse.Warehouse;
import com.knapp.codingcontest.kcc2021.warehouse.WarehouseInfo;

/**
 * This is the code YOU have to provide
 *
 */
public class Solution {
  public String getParticipantName() {
    return "Anzola Fabio"; // TODO: return your name
  }

  public Institute getParticipantInstitution() {
    return Institute.HTL_Rennweg_Wien ; // TODO: return the Id of your institute - please refer to the hand-out
  }

  // ----------------------------------------------------------------------------

  protected final InputData input;
  protected final Warehouse warehouse;

  List<Packet> packets;
  List<PalletType> palletTypes;


  // ----------------------------------------------------------------------------

  public Solution(final Warehouse warehouse, final InputData input) {
    this.input = input;
    this.warehouse = warehouse;
    // TODO: prepare data structures

    this.packets = input.getPackets();

    this.packets.sort(Comparator.comparingInt(Packet::getTruckId).thenComparing(Packet::getLength).thenComparing(Packet::getWidth).thenComparing(Packet::getWeight));

    this.palletTypes = new ArrayList<>(input.getPalletTypes());
  }

  // ----------------------------------------------------------------------------

  /**
   * The main entry-point
   */
  public void run() throws Exception {

    // TODO: make calls to API (see below)
    List<Packet> packetList = this.packets;
    for (int i = 0; i < packetList.size(); i++) {
      Packet packet = packetList.get(i);
      while (packet == null) {
        i++;
        packet = packetList.get(i);
      }
      Pallet pallet = null;
      for (PalletType palletType : this.palletTypes) {
        if (packet.getWidth() <= palletType.getWidth() && packet.getLength() <= palletType.getLength() && packet.getWeight() <= palletType.getMaxWeight()) {
          if (pallet == null) {
            pallet = warehouse.preparePallet(packet.getTruckId(), palletType);
          }
          if (palletType.getWidth() < pallet.getType().getWidth() || palletType.getLength() < pallet.getType().getLength()) {
            pallet = warehouse.preparePallet(packet.getTruckId(), palletType);
          }
          break;
        }
      }
      final int x = 0;
      final int y = 0;
      final boolean rotated = false;
      warehouse.putPacket(pallet, packet, x, y, rotated);

      try {
        if (packetList.get(i + 1).getTruckId() == packet.getTruckId() && packetList.get(i + 1).getWeight() <= pallet.getType().getMaxWeight() - pallet.getCurrentWeight() ) {
          if (packetList.get(i + 1).getWidth() < pallet.getType().getWidth()) {
            if (pallet.getType().getLength() - packet.getLength() >= packetList.get(i + 1).getLength()) {
              warehouse.putPacket(pallet, packetList.get(i + 1), pallet.getType().getLength() - (pallet.getType().getLength() - packet.getLength()), 0, rotated);
              packetList.set(i+1, null);
            }
          }
        }
      } catch (IndexOutOfBoundsException|NullPointerException ignored) {

      }

      try {
        if (packetList.get(i + 2).getTruckId() == packet.getTruckId() && packetList.get(i + 2).getWeight() <= pallet.getType().getMaxWeight() - pallet.getCurrentWeight() ) {
          if (packetList.get(i + 2).getWidth() < pallet.getType().getWidth()) {
            if (pallet.getType().getLength() - packet.getLength() >= packetList.get(i + 2).getLength()) {
              warehouse.putPacket(pallet, packetList.get(i + 2), pallet.getType().getLength() - (pallet.getType().getLength() - packet.getLength()), 0, rotated);
              packetList.set(i+2, null);
            }
          }
        }
      } catch (IndexOutOfBoundsException|NullPointerException ignored) {

      }

      try {
        if (packetList.get(i + 3).getTruckId() == packet.getTruckId() && packetList.get(i + 3).getWeight() <= pallet.getType().getMaxWeight() - pallet.getCurrentWeight() ) {
          if (packetList.get(i + 3).getWidth() < pallet.getType().getWidth()) {
            if (pallet.getType().getLength() - packet.getLength() >= packetList.get(i + 3).getLength()) {
              warehouse.putPacket(pallet, packetList.get(i + 3), pallet.getType().getLength() - (pallet.getType().getLength() - packet.getLength()), 0, rotated);
              packetList.set(i+3, null);
            }
          }
        }
      } catch (IndexOutOfBoundsException|NullPointerException ignored) {

      }

      try {
        if (packetList.get(i + 4).getTruckId() == packet.getTruckId() && packetList.get(i + 4).getWeight() <= pallet.getType().getMaxWeight() - pallet.getCurrentWeight() ) {
          if (packetList.get(i + 4).getWidth() < pallet.getType().getWidth()) {
            if (pallet.getType().getLength() - packet.getLength() >= packetList.get(i + 4).getLength()) {
              warehouse.putPacket(pallet, packetList.get(i + 4), pallet.getType().getLength() - (pallet.getType().getLength() - packet.getLength()), 0, rotated);
              packetList.set(i+4, null);
            }
          }
        }
      } catch (IndexOutOfBoundsException|NullPointerException ignored) {

      }

      try {
        if (packetList.get(i + 5).getTruckId() == packet.getTruckId() && packetList.get(i + 5).getWeight() <= pallet.getType().getMaxWeight() - pallet.getCurrentWeight() ) {
          if (packetList.get(i + 5).getWidth() < pallet.getType().getWidth()) {
            if (pallet.getType().getLength() - packet.getLength() >= packetList.get(i + 5).getLength()) {
              warehouse.putPacket(pallet, packetList.get(i + 5), pallet.getType().getLength() - (pallet.getType().getLength() - packet.getLength()), 0, rotated);
              packetList.set(i+5, null);
            }
          }
        }
      } catch (IndexOutOfBoundsException|NullPointerException ignored) {

      }


    }


  }

  // ----------------------------------------------------------------------------
  // ----------------------------------------------------------------------------

  /**
   * Just for documentation purposes.
   *
   * Method may be removed without any side-effects
   *
   *   divided into 4 sections
   *
   *     <li><em>input methods</em>
   *
   *     <li><em>main interaction methods</em>
   *         - these methods are the ones that make (explicit) changes to the warehouse
   *
   *     <li><em>information</em>
   *         - information you might need for your solution
   *
   *     <li><em>additional information</em>
   *         - various other infos: statistics, information about (current) costs, ...
   *
   */
  @SuppressWarnings("unused")
  private void apis() throws Exception {
    // ----- input -----

    final PalletType palletType = input.getPalletTypes().iterator().next();
    final Packet packet = input.getPackets().iterator().next();

    // ----- main interaction methods -----

    final Pallet pallet = warehouse.preparePallet(packet.getTruckId(), palletType);

    final int x = 0;
    final int y = 0;
    final boolean rotated = false;
    warehouse.putPacket(pallet, packet, x, y, rotated);

    // ----- information -----
    final int csh = pallet.getCurrentStackedHeight();
    final int cw = pallet.getCurrentWeight();
    final Pallet.Layer layer = pallet.getLayer(0);
    final Map<PacketPos, Packet> lpackets = layer.getPackets();

    // ----- additional information -----
    final WarehouseInfo info = warehouse.getInfo();

    final long tc = info.getTotalCost();
    final long upc = info.getUnfinishedPacketsCost();
    final long pac = info.getPalletsAreaCost();
    final long pvuc = info.getPalletsVolumeUsedCost();

    final int up = info.getUnfinishedPacketCount();
    final long pc = info.getPalletCount();
    final long pa = info.getPalletsArea();
    final long pvu = info.getPalletsVolumeUsed();
  }

  // ----------------------------------------------------------------------------
}
