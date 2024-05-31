import { Component, OnInit } from '@angular/core';
import { Bronik } from '../interfaces/Bronik';
import { BronikService } from '../services/bronik.service';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.scss']
})
export class ListComponent implements OnInit {
  title: string = "List of Broniks";
  bronikList: Bronik[] = [];
  showAddForm: boolean = false;
  selectedBronik?: Bronik;

  constructor(private service: BronikService) {}

  ngOnInit(): void {
    this.updateBroniks();
    this.service.list.subscribe(
      (list: Bronik[]) => { this.bronikList = list; }
    );
  }

  updateBroniks() {
    this.service.getBroniks().subscribe(
      (broniks) => {
        this.bronikList = broniks;
      }
    );
  }

  addBronik(bronik: Bronik) {
    this.service.postBronik(bronik).subscribe(
      (bronik) => {
        this.updateBroniks();
      }
    );
  }

  onSelect(bronik: Bronik) {
    if (this.selectedBronik && bronik.id === this.selectedBronik.id) {
      this.selectedBronik = undefined;
    } else {
      this.selectedBronik = bronik;
    }
  }

  deleteBronik(bronik: Bronik) {
    this.service.deleteBronik(bronik).subscribe(
      () => {
        this.updateBroniks();
      }
    );
  }
}
