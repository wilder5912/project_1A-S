import { Component, OnInit, Input } from '@angular/core';
import { NgxCarousel } from 'ngx-carousel';
import { DataService } from '../../../service/dataService/data.service';

@Component({
  selector: 'app-carousel-image-article',
  templateUrl: './carousel-image-article.component.html',
  styleUrls: ['./carousel-image-article.component.css']
})
export class CarouselImageArticleComponent implements OnInit {

  @Input() articleImagePage: string;
  public carouselImage: NgxCarousel;

  constructor(public dataService: DataService) { }

  ngOnInit() {
     this.carouselImage  = {
      grid: {xs: 1, sm: 2, md: 3, lg: 3, all: 0},
      slide: 2,
      speed: 400,
      animation: 'lazy',
      loop: true,
      point: {
        visible: true,
        pointStyles: `
          .ngxcarouselPoint {
            list-style-type: none;
            text-align: center;
            padding: 12px;
            margin: 0;
            white-space: nowrap;
            overflow: auto;
            box-sizing: border-box;
          }
          .ngxcarouselPoint li {
            display: inline-block;
            border-radius: 50%;
            border: 2px solid rgba(0, 0, 0, 0.55);
            padding: 4px;
            margin: 0 3px;
            transition-timing-function: cubic-bezier(.17, .67, .83, .67);
            transition: .4s;
          }
          .ngxcarouselPoint li.active {
              background: #6b6b6b;
              transform: scale(1.2);
          }
        `
      }
  };
  }


  public carouselTileLoad(evt: any) {

  }
  public imageClick(image) {
    this.dataService.imageActicle = this.getImage(image.name);
  }

  public getImage(imageActicle) {
    return  this.dataService.getApiUrl() + '/imageArticle/files/' + imageActicle;
  }
}
