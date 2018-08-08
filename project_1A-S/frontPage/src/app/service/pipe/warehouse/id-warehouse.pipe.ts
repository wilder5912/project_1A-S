import * as _ from 'lodash';
import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'filteridwahopipe'
})
export class IdWarehousePipe implements PipeTransform {

  transform(array: any, query: any): any {
    if (query) {
      return _.filter(array, row => row.warehouseId.toString().indexOf(query.toString()) > -1);
    }
    return array;
  }
}
