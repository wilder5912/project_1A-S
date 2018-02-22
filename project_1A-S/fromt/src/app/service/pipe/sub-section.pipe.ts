import * as _ from "lodash";
import {Pipe, PipeTransform} from "@angular/core";

@Pipe({
  name: "dataFilterSubSection"
})
export class SubSectionPipe implements PipeTransform {

  transform(array: any, query: any): any {
     let listResult;
    if (query) {
      let idP =_.filter(array, row=>row.subSectionId==query);
      var sectionInfo = [
        {"SectionInformation":_.filter(array, row=>row.subSectionId==query)},
        {"SectionInformation":_.filter(array, row=>row.nameSubSection.indexOf(query) > -1)},
        {"SectionInformation":_.filter(array, row=>row.secctionId.groupId.bussineId.nombreBu.indexOf(query) > -1)}, //groupId.bussineId.nombreBu
        {"SectionInformation":_.filter(array, row=>row.secctionId.groupId.nameGroup.indexOf(query) > -1)}, //groupId.bussineId.nombreBu
        {"SectionInformation":_.filter(array, row=>row.sectionId.nameSection.indexOf(query) > -1)}, //groupId.bussineId.nombreBu
        {"SectionInformation":_.filter(array, row=>row.nameSubSection.indexOf(query) > -1)}, //groupId.bussineId.nombreBu
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
