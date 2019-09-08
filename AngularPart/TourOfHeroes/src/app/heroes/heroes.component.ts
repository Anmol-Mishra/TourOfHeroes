import { Component, OnInit } from '@angular/core';
import { Hero } from '../hero';
import { HeroService } from '../hero.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-heroes',
  templateUrl: './heroes.component.html',
  styleUrls: ['./heroes.component.css']
})
export class HeroesComponent implements OnInit {


heroes : Hero[];
  
selectedHero : Hero;
  constructor(private location : Location,
            private heroService : HeroService) { }

  

  ngOnInit() {
    this.getHeroes();
  }

  getHeroes() : void{
    this.heroService.getHeroes()
    .subscribe(
      heroes => this.heroes = heroes
    );
  }


  

  add(name:string):void{
    name = name.trim();
    let hero = new Hero();


    if(!name){return;}
    
    hero.name=name;
    this.heroService.addHero(hero)
    .subscribe(
      (data)=>{this.goBack(),this.getHeroes()},
      (error)=>{this.goBack(),this.getHeroes()}
    );

    
  }
  goBack():void{
    this.location.back();
  }

}
