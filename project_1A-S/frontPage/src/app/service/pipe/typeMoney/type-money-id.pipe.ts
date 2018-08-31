import * as _ from 'lodash';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filtertypem'
})
export class TypeMoneyIdPipe implements PipeTransform {

  transform(value: any, query: any): any {
    if (query) {
      return _.filter(value, row => row.typeMoneyId.toString().indexOf(query.toString()) > -1);
    }
    return value;
  }

}
