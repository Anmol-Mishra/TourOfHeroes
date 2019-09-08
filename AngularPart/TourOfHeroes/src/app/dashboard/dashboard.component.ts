import { Component, OnInit } from '@angular/core';
import { HeroService } from '../hero.service';
import { Hero } from '../hero';


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  
  selectedHero:Hero;

  heroes : Hero[];
  constructor(private heroService : HeroService) { }

  ngOnInit() {
    this.getFourHeroes();
  }

  getFourHeroes():void{
    this.heroService.getHeroes().subscribe(
      data=> this.heroes = data.slice(0,4),
      error=>console.log("Error in dashboard component")
    );
  }

  onClickHero(hero:Hero):void{
      this.selectedHero = hero;
  }

}
