import { Business } from '../business/Business';
import { User } from '../usuario/User';
export class Box {
  boxId: number;
  businessId: Business;
  userID: User;
  nameBox: string;
  codeBox: number;
  isSelectBox: boolean;
  isDelete: boolean;
}
