import { Injectable } from '@angular/core';
import { DataService } from '../dataService/data.service';

const SockJs = require('sockjs-client');
const Stomp = require('stompjs');

@Injectable()
export class WebSocketService {

    constructor(public dataService: DataService) { }
    connect() {
        const socket = new SockJs(this.dataService.getUrl('/socket'));
        const stompClient = Stomp.over(socket);
        return stompClient;
    }
}
