import {Article} from '../product/Article';
import { Business } from '../business/Business';

export class ArticleRelational {
  articleRelationalId: number;
  articleId: Article;
  artArticleId: Article;
  businessId: Business;
}
