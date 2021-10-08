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

package com.knapp.codingcontest.kcc2021.warehouse;

import com.knapp.codingcontest.kcc2021.data.Packet;
import com.knapp.codingcontest.kcc2021.data.Pallet;

public class PacketAlreadyUsedException extends AbstractWarehouseException {
  private static final long serialVersionUID = 1L;

  // ----------------------------------------------------------------------------

  public final Pallet pallet;
  public final Packet packet;
  public final Pallet _pallet;

  // ----------------------------------------------------------------------------

  public PacketAlreadyUsedException(final Pallet pallet, final Packet packet, final Pallet _pallet) {
    super(packet + " => pallet.id=" + pallet.getId() + "\n=> already at: " + AbstractWarehouseException.shortString(_pallet) + "\n");
    this.pallet = new MyPallet(pallet);
    this.packet = packet;
    this._pallet = new MyPallet(_pallet);
  }

  // ----------------------------------------------------------------------------
}
