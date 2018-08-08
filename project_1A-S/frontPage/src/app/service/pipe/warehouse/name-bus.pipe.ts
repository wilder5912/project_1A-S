import * as _ from 'lodash';
import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'filterbusiness'
})
export class NameBusPipe implements PipeTransform {

  transform(array: any, query: any): any {
    if (query) {
      return _.filter(array, row => row.businessId.nameBu.toLocaleLowerCase().indexOf(query.toLocaleLowerCase()) > -1);
    }
    return array;
  }
}
