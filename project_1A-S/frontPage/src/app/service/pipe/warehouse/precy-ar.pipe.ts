import * as _ from 'lodash';
import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'filterpresyarpipe'
})
export class PrecyArPipe implements PipeTransform {

  transform(array: any, query: any): any {
    if ( query ) {
      return _.filter(array, row => row.articleDetailId.articleId.precyAr.toString().toLocaleLowerCase().indexOf(query.toString().toLocaleLowerCase()) > -1);
    }
    return array;
  }
}
