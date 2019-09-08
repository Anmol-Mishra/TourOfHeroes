import { Component, OnInit, Input } from '@angular/core';
import { Hero } from '../hero';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { HeroService } from '../hero.service'
@Component({
  selector: 'app-hero-detail',
  templateUrl: './hero-detail.component.html',
  styleUrls: ['./hero-detail.component.css']
})
export class HeroDetailComponent implements OnInit {

  // @Input() selectedHeroRewired:Hero;

  selectedHeroRewired : Hero;
  
  constructor(private route : ActivatedRoute,
              private  heroService : HeroService,
              private location : Location) { }

  ngOnInit() {
    this.getHero();
  }

  getHero():void{
      const id = +this.route.snapshot.paramMap.get('id');

      this.heroService.getHero(id).subscribe(
        data=>this.selectedHeroRewired = data,
        error=>console.log("Error @ Hero Details func getHero.")
      );
      
  }

  save():void{
    this.heroService.updateHero(this.selectedHeroRewired).subscribe(
      
      data=>this.goBack(),
      error=>console.log("error @ update hero SAVE METHOD OF HERODETAIL ")
    );
  }

  goBack():void{
    this.location.back();
  }

} 
