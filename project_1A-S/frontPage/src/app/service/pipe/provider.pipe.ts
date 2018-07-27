import * as _ from 'lodash';
import {Pipe, PipeTransform} from '@angular/core';

@Pipe({
  name: 'dataFilterProvider'
})
export class ProviderPipe implements PipeTransform {

  transform(array: any[], query: string): any {
    if (query) {
      const idP = _.filter(array, row => Number(row.providerId) === Number(query));
      const sectionInfo = [
        {'SectionInformation': _.filter(array, row => row.nameProvider.toLocaleLowerCase().indexOf(query.toLocaleLowerCase()) > -1)},
        {'SectionInformation': _.filter(array, row => row.codeProvider.toLocaleLowerCase().indexOf(query.toLocaleLowerCase()) > -1)}
      ];
      let nfo = idP;
      if (idP.length !== 1 ) {
        sectionInfo.forEach(function (sectioninforData, index) {
          if (sectioninforData.SectionInformation.length >= nfo.length) {
            nfo = sectioninforData.SectionInformation;
          }
        });
      }

      return nfo;
    }
    return array;
  }
}
