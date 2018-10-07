"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
Object.defineProperty(exports, "__esModule", { value: true });
var core_1 = require("@angular/core");
var SockJs = require('sockjs-client');
var Stomp = require('stompjs/lib/stomp.js');
var WebSocketService = (function () {
    function WebSocketService(dataService) {
        this.dataService = dataService;
    }
    WebSocketService.prototype.connect = function () {
        var socket = new SockJs(this.dataService.getUrl('/socket'));
        var stompClient = Stomp.over(socket);
        return stompClient;
    };
    WebSocketService = __decorate([
        core_1.Injectable()
    ], WebSocketService);
    return WebSocketService;
}());
exports.WebSocketService = WebSocketService;
