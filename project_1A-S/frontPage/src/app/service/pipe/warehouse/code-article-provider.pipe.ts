import * as _ from 'lodash';
import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'filtercodarprovipipe'
})
export class CodeArticleProviderPipe implements PipeTransform {

  transform(array: any, query: any): any {
    if (query) {
      return _.filter(array, row => row.articleProviderId.codeArticleProvider.toLocaleLowerCase().indexOf(query.toLocaleLowerCase()) > -1);
    }
    return array;
  }
}
