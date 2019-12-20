import {User} from './User';
import {Item} from './Item';
import {Observable} from "rxjs";


export class Bid {
  id: number;
  createdAt: string;
  user: Observable<User>;
  item: Item
  amount: number;
  isBuyout: boolean;

  constructor(user: Observable<User>, item: Item, amount: number) {

  }
}
