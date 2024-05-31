import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Bronik } from '../interfaces/Bronik';
import { BronikService } from '../services/bronik.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.scss']
})
export class UpdateComponent implements OnInit {
  @Input() bronik?: Bronik;
  @Output() updated: EventEmitter<null> = new EventEmitter();

  constructor(private service: BronikService) {}

  ngOnInit(): void {}

  updateBronik() {
    if (this.bronik) {
      this.service.putBronik(this.bronik).subscribe(
        () => {
          this.updated.emit();
        }
      );
    }
  }
}
