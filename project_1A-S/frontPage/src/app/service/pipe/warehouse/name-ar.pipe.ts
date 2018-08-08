import * as _ from 'lodash';
import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'filterNaArPipe'
})
export class NameArPipe implements PipeTransform {

  transform(array: any, query: any): any {
    if (query) {
      return _.filter(array, row => row.articleDetailId.articleId.nameAr.toLocaleLowerCase().indexOf(query.toLocaleLowerCase()) > -1);
    }
    return array;
  }
}
