import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { ServicesService } from '../../../services.service';

@Component({
  selector: 'app-display-users',
  standalone: true,
  imports: [CommonModule, RouterModule, HttpClientModule],
  templateUrl: './display-users.component.html',
  styleUrls: ['./display-users.component.css'],
  providers: [ServicesService]
})
export class DisplayUsersComponent implements OnInit {
  users: any;

  constructor(private services: ServicesService) { }

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers(): void {
    this.services.getUsers().subscribe((res: any) => {
      this.users = res;
    });
  }
}
