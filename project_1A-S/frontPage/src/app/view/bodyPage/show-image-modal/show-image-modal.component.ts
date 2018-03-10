import { Component, OnInit, Input, ViewChild  } from '@angular/core';
import { ModalDirective } from 'ngx-bootstrap/modal';

 @Component({
  selector: 'app-show-image-modal',
  templateUrl: './show-image-modal.component.html',
  styleUrls: ['./show-image-modal.component.css']
})
export class ShowImageModalComponent implements OnInit {
  @Input() srcImage: string;
  @ViewChild('parentModal') parentModal: ModalDirective;
  constructor() { }

  ngOnInit() {
  }
   showChildModal(): void {
     this.parentModal.show();
    }
}
