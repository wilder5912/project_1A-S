import { Bussine } from '../bussine/Bussine';
import { User } from '../usuario/User';
export class Box {
  boxId: number;
  bussineId: Bussine;
  userID: User;
  nameBox: string;
  codeBox: number;
  isSelectBox: boolean;
  isDelete: boolean;
}
