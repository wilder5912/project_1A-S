import { DetailSell } from './DetailSell';
import { Client } from '../clientModel/Client';
import { Warehouse } from '../warehouse/Warehouse';

export class SellProduct {
  sellproductId: number;
  detailSellId: DetailSell;
  clientId: Client;
  warehouseId: Warehouse;
  costProductCountrySpt: number;
  discountSp: number;
  numberPrudctSp: number;
  nameMoneySp: string;
  costTypeMoneySp: number;
  businessArSp: number;
  isDelete: boolean;
}
