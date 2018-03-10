import * as _ from 'lodash';
import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'dataFilterGroupProduct'
})
export class GroupProductPipe implements PipeTransform {

  transform(array: any[], query: string): any {
    if (query) {
      return _.filter(array, row => row.nameGroup.indexOf(query) > -1);
    }
    return array;
  }
}
