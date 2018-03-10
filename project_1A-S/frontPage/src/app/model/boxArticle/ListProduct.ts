import { Box } from './Box';
import { Article } from '../product/Article';

export class ListProduct {
  listProductId: number;
  boxId: Box;
  articleId: Article;
  numProduct: number;
  isDelete: number;
  isSelectBox: boolean;
}
