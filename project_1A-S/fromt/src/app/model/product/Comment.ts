import {Article} from '../product/Article';
import {User} from '../usuario/User';
export class Comment{
      commentId: number;
      articleId: Article;
      userId: User;
      rating: number;
      nameComment: string;
      dateComment: string;
      isDelete: boolean;
}


