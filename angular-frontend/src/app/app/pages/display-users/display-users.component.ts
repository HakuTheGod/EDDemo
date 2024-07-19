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
  selectedUser: any;
  showModal: boolean = false;

  constructor(private services: ServicesService) { }

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers(): void {
    this.services.getUsers().subscribe((res: any) => {
      this.users = res;
    });
  }

  openModal(user: any): void {
    this.selectedUser = user;
    this.showModal = true;
  }

  closeModal(): void {
    this.showModal = false;
    this.selectedUser = null;
  }

  deleteUser(userId: string, event?: Event): void {
    if (event) {
      event.stopPropagation(); // Prevent the row click event from firing
    }

    this.services.deleteUser(userId).subscribe(
      () => {
        // Refresh the user list after successful deletion
        this.getUsers();

        // Optionally, you can use window.location.reload() to reload the entire page
        // window.location.reload();
      },
      error => {
        console.error('Error deleting user:', error);
      }
    );
  }

  getWorkAddress(user: any): string {
    return user?.addresses.find((address: any) => address.type === 'work')?.address || 'N/A';
  }

  getHomeAddress(user: any): string {
    return user?.addresses.find((address: any) => address.type === 'home')?.address || 'N/A';
  }
}
