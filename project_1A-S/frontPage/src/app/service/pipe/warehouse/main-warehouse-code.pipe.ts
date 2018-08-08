import * as _ from 'lodash';
import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'filterwarehousecodepipe'
})
export class MainWarehouseCodePipe implements PipeTransform {

  transform(array: any, query: any): any {
    if (query) {
      return _.filter(array, row => row.wnameId.codeWarehouse.toLocaleLowerCase().indexOf(query.toLocaleLowerCase()) > -1);
    }
    return array;
  }
}
