import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Bid} from '../model/bid';
import {Observable} from 'rxjs/Observable';

@Injectable()
export class BidService {

  private bidsUrl: string;

  constructor(private http: HttpClient) {
    this.bidsUrl = 'http://localhost:8080/bids';
  }

  public findAll(): Observable<Bid[]> {
    let username = "mata"
    let password = 'pass'
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username + ':' + password)});
    return this.http.get<Bid[]>(this.bidsUrl, {headers});
  }

  public findById(id: Number): Observable<Bid> {
    let username = "mata"
    let password = 'pass'
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username + ':' + password)});
    return this.http.get<Bid>(this.bidsUrl + "/" + id, {headers});
  }

  public save(bid: Bid) {
    let username = "mata"
    let password = 'pass'
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username + ':' + password)});
    return this.http.post<Bid>(this.bidsUrl + "/", bid, {headers});
  }
}
