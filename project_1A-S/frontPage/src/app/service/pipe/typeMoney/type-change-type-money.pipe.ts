import * as _ from 'lodash';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filtertypeChaeTypeM'
})
export class TypeChangeTypeMoneyPipe implements PipeTransform {

  transform(value: any, query: any): any {
    if (query) {
      return _.filter(value, row => row.typeChangeTypemoney.toString().indexOf(query.toString()) > -1);
    }
    return value;
  }

}
