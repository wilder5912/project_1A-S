import { Component, OnInit } from '@angular/core';
import { DataService } from '../../../service/dataService/data.service';
@Component({
  selector: 'app-home-cashier',
  templateUrl: './home-cashier.component.html',
  styleUrls: ['./home-cashier.component.css']
})
export class HomeCashierComponent implements OnInit {

  constructor(public dataService: DataService) { }

  ngOnInit() {
  }

}
