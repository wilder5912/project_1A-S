import { Directive } from '@angular/core';
import { AbstractControl } from '@angular/forms';

export class ValidateText {
  static isValidateTextComma(inputText: AbstractControl) {
    let isText = {isTextS: true };
    const expresion = /'([^']*)/;
    const dataText = inputText.value.match( expresion);
    if ( null === dataText ) {
      isText = null;
    }
    return isText;
  }

}

