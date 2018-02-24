import * as _ from "lodash";
import {Pipe, PipeTransform} from "@angular/core";

@Pipe({
  name: "dataFilterSection"
})
export class SectionPipe implements PipeTransform {

  transform(array: any, query: any): any {
     let listResult;
    if (query) {
      let idP =_.filter(array, row=>row.sectionId==query);
      var sectionInfo = [
        {"SectionInformation":_.filter(array, row=>row.sectionId==query)},
        {"SectionInformation":_.filter(array, row=>row.nameSection.indexOf(query) > -1)},
        {"SectionInformation":_.filter(array, row=>row.groupId.bussineId.nombreBu.indexOf(query) > -1)}, //groupId.bussineId.nombreBu
        {"SectionInformation":_.filter(array, row=>row.groupId.nameGroup.indexOf(query) > -1)},
      ]
      let nfo=idP;
      sectionInfo.forEach(function(sectioninforData, index) {
        if(sectioninforData.SectionInformation.length >= nfo.length){
          nfo=sectioninforData.SectionInformation;
        }
        });
      return nfo;
    }
    return array;
  }
}
