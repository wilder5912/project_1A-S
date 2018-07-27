import * as _ from 'lodash';
import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'dataFilterProviderPhone'
})
export class ProviderPhonePipe implements PipeTransform {

  transform(array: any[], query: string): any {

    if (query) {
return _.filter(array, row => row.numberPhoneProvider.toString().toLocaleLowerCase().indexOf(query.toString().toLocaleLowerCase()) > -1);
    }
    return array;
  }
}
