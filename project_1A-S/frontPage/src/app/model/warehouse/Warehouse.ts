import { ArticleProvider } from '../provider/ArticleProvider';
import { ArticleDetail } from '../product/ArticleDetail';
import {Provider} from '../provider/Provider';
export class Warehouse {
  warehouseId: number;
  articleDetailId: ArticleDetail;
  quantytiProviderWarehouse: number;
  articleProviderId: ArticleProvider;
  providerId: Provider;
  fatureWarehouse: string;
  dateStartWarehouse: string;
  dateEndWarehouse: string;
  codeWarehouse: string;
  quantytiCurrectWarehouse: number;
  isDelete: boolean;
}
