import { Component, Injectable, OnInit } from '@angular/core';
import { HomeComponent } from '../home/home.component';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})

@Injectable({
  providedIn: 'root'
})

export class ProductComponent implements OnInit {

  id: number = 1;
  name: string = '';
  description: string = '';
  category:string = '';
  price: number = 0;
  picture?: string = '';

  constructor() { }

  ngOnInit(): void {
  }

  setImage(pictureId: number){
    
    var imagePath = "../../merch_pictures/" + this.id + ".jpg";

    return imagePath;
  }
}
