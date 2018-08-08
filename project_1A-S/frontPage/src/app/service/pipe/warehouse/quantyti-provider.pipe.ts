import * as _ from 'lodash';
import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'filterquantyprovpipe'
})
export class QuantytiProviderPipe implements PipeTransform {

  transform(array: any, query: any): any {

    if (query) {
      return _.filter(array, row => row.quantytiProviderWarehouse.toString().indexOf(query.toString()) > -1);
    }
    return array;
  }
}
