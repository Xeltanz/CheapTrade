import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Item} from '../model/item';
import {Observable} from 'rxjs/Observable';


@Injectable()
export class ItemService {

  private itemsUrl: string;

  constructor(private http: HttpClient) {
    this.itemsUrl = 'http://localhost:8080/items';
  }

  public findAll(): Observable<Item[]> {
    let username = "mata"
    let password = 'pass'
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username + ':' + password)});
    return this.http.get<Item[]>(this.itemsUrl, {headers});
  }

  public findById(id: Number): Observable<Item> {
    let username = "mata"
    let password = 'pass'
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username + ':' + password)});
    return this.http.get<Item>(this.itemsUrl + "/" + id, {headers});
  }

  public save(item: Item) {
    let username = "mata"
    let password = 'pass'
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username + ':' + password)});
    return this.http.post<Item>(this.itemsUrl + "/", item, {headers});
  }
}
