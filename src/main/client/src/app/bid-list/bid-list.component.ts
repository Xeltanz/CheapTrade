import {Component, OnInit} from '@angular/core';
import {Bid} from '../model/bid';
import {BidService} from '../service/bid.service';

@Component({
  selector: 'app-bid-list',
  templateUrl: './bid-list.component.html',
  styleUrls: ['./bid-list.component.css']
})
export class BidListComponent implements OnInit {

  bids: Bid[];

  constructor(private bidService: BidService) {
  }

  ngOnInit() {
    this.bidService.findAll().subscribe(data => {
      this.bids = data;
    });
  }
}
