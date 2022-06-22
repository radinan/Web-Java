import { Component } from '@angular/core';
import { map } from 'rxjs/operators';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { AppService } from '../app.service';
import { Router } from '@angular/router';
import { ProductComponent } from '../product/product.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {

  //cards = [];
  /** Based on the screen size, switch from standard to one column per row */
  
  cards = this.breakpointObserver.observe(Breakpoints.Handset).pipe(
    map(({ matches }) => {
      if (matches) {
        return [
          { id:'1', title: 'Card 1', cols: 1, rows: 1 },
          { id:'2', title: 'Card 2', cols: 1, rows: 1 },
          { id:'3', title: 'Card 3', cols: 1, rows: 1 },
          { id:'4', title: 'Card 4', cols: 1, rows: 1 }
        ];
      }

      return [
        { id:'1', title: 'Card 1', cols: 2, rows: 1 },
        { id:'2', title: 'Card 2', cols: 1, rows: 1 },
        { id:'3', title: 'Card 3', cols: 1, rows: 2 },
        { id:'4', title: 'Card 4', cols: 1, rows: 1 }
      ];
    })
  );
  

  constructor(private breakpointObserver: BreakpointObserver, public appService:AppService, private router:Router, public product:ProductComponent) {}

  ngOnInit() {
    this.appService.getItems().subscribe(
      response => {

      },
      error => {

      }

    )
  }
  
  productGoTo(id: string){
    this.router.navigateByUrl('product');
    this.product.id=2;
  }

  getImage(id: string):string {
    return 'url(../assets/merch_pictures/' + id + '.jpg)';
  }
}
