import { Injectable } from '@angular/core';
import { Hero } from './hero';
import { HEROES } from './mock-heroes';
import {Observable, of} from 'rxjs';
import { MessageService } from './message.service';
import { HttpClient, HttpHeaders } from  '@angular/common/http';
import {catchError, map, tap} from 'rxjs/operators'

@Injectable({
  providedIn: 'root'
})
export class HeroService {

  
heroesUrl : string = `http://localhost:8080`;



private handleError<T>(operation = 'operation', result?: T){
  return (error:any): Observable<T> => {

     console.error(error);
     this.log(`${operation} failed: ${error.message}`);


     return of(result as T);
  }
}

  constructor(private http : HttpClient,
              private messageService : MessageService) { }

getHeroes(): Observable<Hero[]>{
  // this.messageService.add("HeroService : fetched heroes");
  // return of(HEROES);

  return this.http.get<Hero[]>(this.heroesUrl + `/heroes`)
  .pipe(
    tap(_ => this.log('fetched heroes')),
    catchError(this.handleError<Hero[]>('getHeroes',[]))
  );
}

getHero(id:number):Observable<Hero>{
  // this.messageService.add(`Hero Service : fetched hero id:${id}`);
  // return of( HEROES.find(hero => hero.id === id) );

  const url = this.heroesUrl + `/heroes/${id}`;

  return this.http.get<Hero>(url)
  .pipe(
    tap(_=> this.log(`fetched hero id =${id}`)),
    catchError(this.handleError<Hero>(`getHero id=${id}`))
  );
  
}

httpOptions = {
  headers: new HttpHeaders({ 'Content-Type': 'application/json' })
};


updateHero(hero:Hero):Observable<any>{
   return this.http.put(this.heroesUrl + `/updateHero/${hero.id}`, hero);
  //  .pipe(
  //   tap(_ => this.log(`updated hero id=${hero.id}`)),
  //   catchError(this.handleError<any>('updateHero'))
  // );
}

//   addHero(hero:Hero):Observable<any>{

//   return this.http.post(`${this.heroesUrl}/addHero`, hero);
// }
/** POST: add a new hero to the server */
addHero (hero: Hero): Observable<Hero> {
  return this.http.post<Hero>(`${this.heroesUrl}/addHero`, hero);
  // .pipe(
  //   tap((newHero: Hero) => this.log(`added hero w/ id=${newHero.id}`)),
  //   catchError(this.handleError<Hero>('addHero'))
  // );
}

private log(message : string){
  this.messageService.add(`HeroService : ${message}`);
}

}
