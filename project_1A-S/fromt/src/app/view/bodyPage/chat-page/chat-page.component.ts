import { Component, OnInit } from '@angular/core';
import { WebSocketService } from "../../../service/webSocketServicePage/websocket.service";
import { DataService} from "../../../service/dataService/data.service";
import { ArticleService } from "../../../service/product/ArticleService";

@Component({
  selector: 'app-chat-page',
  templateUrl: './chat-page.component.html',
  styleUrls: ['./chat-page.component.css'],
  providers:[ArticleService]
})
export class ChatPageComponent implements OnInit {

  public notifications = 0;

  constructor(private webSocketService: WebSocketService,public dataService:DataService, public articleService:ArticleService ) {

  }

  ngOnInit() {

    let stompClient = this.webSocketService.connect();
    stompClient.connect({}, frame => {
      stompClient.subscribe('/topic/notification2', notifications => {
        this.notifications = JSON.parse(notifications.body).count;

      });

    });
  }


  public evento(){
    this.articleService.eveentoPru().subscribe(
      result=>{
        console.log(result,"se envio el mensage");
      }
    );
  }



}
