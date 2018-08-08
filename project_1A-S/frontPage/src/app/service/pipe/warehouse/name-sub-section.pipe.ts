import * as _ from 'lodash';
import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'filternamesubseccpipe'
})
export class NameSubSeccionPipe implements PipeTransform {

  transform(array: any, query: any): any {

    if (query) {
      return _.filter(array, row => row.articleDetailId.subSectionId.nameSubSection.toLocaleLowerCase().indexOf(query.toLocaleLowerCase()) > -1);
    }
    return array;
  }
}
