import { BusinessCurrentUser } from '../usuario/BusinessCurrentUser';
import { PaymentType } from '../typeMoney/PaymentType';

export class DetailSell {
  detailSellId: number;
  businessCurouserId: BusinessCurrentUser;
  codeControlDetailSell: string;
  dateDetailSell: string;
  dateRegisterDetailSell: string;
  amountDetailSell: number;
  typeChangeDetailSell: string;
  changeAmountDetailsell: number;
  salesCheckDetailsell: number;
  roleCashierId: number;
  roleSellerId: number;
  paymentTypeId: PaymentType;
  isDelete: boolean;
}
