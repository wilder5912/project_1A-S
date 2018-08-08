import * as _ from 'lodash';
import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'filterfaturewarehopipe'
})
export class FatureWarehousePipe implements PipeTransform {

  transform(array: any, query: any): any {

    if (query) {
      return _.filter(array, row => row.fatureWarehouse.toString().indexOf(query.toString()) > -1);
    }
    return array;
  }
}
