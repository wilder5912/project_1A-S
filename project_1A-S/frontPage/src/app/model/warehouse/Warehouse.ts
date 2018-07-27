import { ArticleProvider } from '../provider/ArticleProvider';
import { ArticleDetail } from '../product/ArticleDetail';
import { Provider } from '../provider/Provider';
import { Business } from '../business/Business';
import { WareHouseMain } from './WareHouseMain';
export class Warehouse {
  warehouseId: number;
  articleDetailId: ArticleDetail;
  businessId: Business;
  quantytiProviderWarehouse: number;
  articleProviderId: ArticleProvider;
  providerId: Provider;
  fatureWarehouse: string;
  dateStartWarehouse: string;
  dateEndWarehouse: string;
  codeWarehouse: string;
  quantytiCurrectWarehouse: number;
  wnameId: WareHouseMain;
  isDelete: boolean;
}
