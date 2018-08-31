import * as _ from 'lodash';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterNameTypeMoney'
})
export class NameTypeMoneyPipe implements PipeTransform {

  transform(value: any, query: any): any {
    if (query) {
      return _.filter(value, row => row.nameTypeMoney.toLocaleLowerCase().indexOf(query.toLocaleLowerCase()) > -1);
    }
    return value;
  }

}
