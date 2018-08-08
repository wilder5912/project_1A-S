import * as _ from 'lodash';
import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'filterquantyticurrect'
})
export class QuantytiCurrectPipe implements PipeTransform {

  transform(array: any, query: any): any {

    if (query) {
      return _.filter(array, row => row.quantytiCurrectWarehouse.toString().indexOf(query.toString()) > -1);
    }
    return array;
  }
}
