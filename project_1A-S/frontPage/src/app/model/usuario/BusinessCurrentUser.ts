import { User} from './User';
import { Business } from '../business/Business';
export class BusinessCurrentUser {
  businesscurouserId: number;
  userID: User;
  businessId: Business;
  isDetele: boolean;
}
