import * as _ from 'lodash';
import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'filterCodeArPipe'
})
export class CodeArPipe implements PipeTransform {

  transform(array: any, query: any): any {

    if (query) {
      return _.filter(array, row => row.articleDetailId.articleId.codigoAr.toLocaleLowerCase().indexOf(query.toLocaleLowerCase()) > -1);
    }
    return array;
  }
}
