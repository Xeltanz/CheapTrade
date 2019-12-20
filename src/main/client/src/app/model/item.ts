import {User} from './User';

export class Item {
  id: number;
  createdAt: String;

  user: User;
  name: string;
  startingPrice: number;
  buyOutPrice: number;

}
