import { Injectable } from '@angular/core';

@Injectable()
export class SharedService {
  testService() {
    console.log('share!');
  }
  public count = 0;

  get() {
    return this.count;
  }

  increment() {
    this.count++;
  }

  decrement() {
    this.count--;
  }

}
