import {SubSection} from '../product/SubSection';
import {Article} from '../product/Article';
export class ArticleDetail {
  articleDetailId: number;
  articleId: Article;
  subSectionId: SubSection;
  isDelete: boolean;
}
