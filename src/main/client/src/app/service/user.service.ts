import {Injectable} from '@angular/core';
import {User} from '../model/user';
import {Observable} from 'rxjs/Observable';
import {HttpClient, HttpHeaders} from '@angular/common/http';

@Injectable()
export class UserService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/users';
  }

  public findAll(): Observable<User[]> {
    let username = "mata"
    let password = 'pass'
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username + ':' + password)});
    return this.http.get<User[]>(this.usersUrl, {headers});
  }

  public findById(id: Number): Observable<User> {
    let username = "mata"
    let password = 'pass'
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username + ':' + password)});
    return this.http.get<User>(this.usersUrl + "/" + id, {headers});
  }

  public save(user: User) {
    let username = "mata"
    let password = 'pass'
    const headers = new HttpHeaders({Authorization: 'Basic ' + btoa(username + ':' + password)});
    return this.http.post<User>(this.usersUrl + "/", user, {headers});
  }
}
