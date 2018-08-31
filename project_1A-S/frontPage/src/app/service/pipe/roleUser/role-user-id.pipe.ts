import * as _ from 'lodash';
import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'filterRoleUserId'
})
export class RoleUserIdPipe implements PipeTransform {

  transform(value: any, query: any): any {
    if (query) {
      return _.filter(value, row => row.roleUserId.toString().indexOf(query.toString()) > -1);
    }
    return value;
  }
}
