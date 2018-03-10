import { Directive } from '@angular/core';
import { AbstractControl, NG_VALIDATORS } from '@angular/forms';
export class ValidateNumberPositive {
  static verificateNumberpositive(inputNumber: AbstractControl) {
     let isNumber = {isNumber: true };
    if (inputNumber.value >= 0) {
      isNumber = null;
    }
   return isNumber;
  }
}

