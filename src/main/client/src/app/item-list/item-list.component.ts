import {Component, OnInit} from '@angular/core';
import {Item} from '../model/item';
import {BidService} from '../service/bid.service';
import {ItemService} from "../service/item.service";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../service/user.service";
import {Bid} from "../model/bid";

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {


  items: Item[];

  constructor(private itemService: ItemService,
              private bidService: BidService,
              private userService: UserService,
              private route: ActivatedRoute,
              private router: Router) {
  }


  ngOnInit() {
    this.itemService.findAll().subscribe(data => {
      this.items = data;
    });
  }

  buyItem(id: number, price: number) {
    this.bidService.save(new Bid(this.userService.findById(1), this.items[id], price + 500)).subscribe(result => this.gotoBidsList());
  }

  gotoBidsList() {
    this.router.navigate(['/bids']);
  }
}
