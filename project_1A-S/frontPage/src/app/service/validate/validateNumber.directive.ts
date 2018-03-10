import { Directive } from '@angular/core';
import { AbstractControl } from '@angular/forms';

export class ValidateNumber {
  static verificateNumber(inputNumber: AbstractControl) {
     let isNumber = {isNumber: true };
    if (!isNaN(inputNumber.value) ) {
      isNumber = null;
    }
   return isNumber;
  }
}

