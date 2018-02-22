import * as _ from "lodash";
import {Pipe, PipeTransform} from "@angular/core";
import { Article } from '../../model/product/Article';


@Pipe({
  name: 'stringFilter'
})
export class StringFilterPipe implements PipeTransform {
 article :Article = new Article();
  transform(value: any[], q: string){

    if (!q || q === '') {
      return value;
    }

    return _.filter(value, row=>row.nameAr.toLocaleLowerCase().indexOf(q.toLowerCase())> -1)

  };

  }

