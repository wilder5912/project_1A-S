import {Article} from '../product/Article';
import { Business } from '../business/Business';

export class ArticleRelational {
  articleRelationalId: number;
  businessId: Business;
  articleId: Article;
  artArticleId: Article;

}
