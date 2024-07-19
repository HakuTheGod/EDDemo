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
  selectedUser: any; // To hold the user whose details are currently being viewed

  constructor(private services: ServicesService) { }

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers(): void {
    this.services.getUsers().subscribe((res: any) => {
      this.users = res;
    });
  }

  openDetails(user: any): void {
    this.selectedUser = user;
    document.body.style.overflow = 'hidden'; // Prevent scrolling behind the modal
  }

  closeDetails(): void {
    this.selectedUser = null;
    document.body.style.overflow = 'auto'; // Allow scrolling again
  }

  deleteUser(userId: number): void {
    if (confirm('Are you sure you want to delete this user?')) {
      this.services.deleteUser(userId).subscribe(() => {
        this.getUsers(); // Reload the user list after deletion
        this.closeDetails(); // Close the modal if it's open
      });
    }
  }

  getAddress(user: any, type: string): string {
    const address = user.addresses.find((a: any) => a.type === type);
    return address ? address.address : 'N/A';
  }
}
