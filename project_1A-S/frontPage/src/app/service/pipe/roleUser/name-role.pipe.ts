import * as _ from 'lodash';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterNameRole'
})
export class NameRolePipe implements PipeTransform {

  transform(value: any, query: any): any {
    if (query) {
      return _.filter(value, row => row.nameRole.toString().indexOf(query.toString()) > -1);
    }
    return value;
  }

}
