import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ServicesService } from '../services.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css'],
  providers: [ServicesService],
  standalone: true,
  imports: [CommonModule, FormsModule]
})
export class UserDetailsComponent implements OnInit {
  user: any;
  editableData: any = {}; // For storing editable data
  originalData: any = {}; // For storing the original data
  isEditing: any = {}; // Track which field is being edited
  isEditingAny = false; // Track if any field is being edited

  constructor(
    private route: ActivatedRoute,
    private services: ServicesService,
    private router: Router
  ) { }

  ngOnInit(): void {
    const userId = this.route.snapshot.paramMap.get('id');
    this.getUserDetails(userId);
  }

  getUserDetails(id: string | null): void {
    if (id) {
      this.services.getUserById(id).subscribe((res: any) => {
        this.user = res;
        // Initialize editableData and originalData with user details
        this.editableData = { ...this.user };
        this.originalData = { ...this.user }; // Backup the original data
      });
    }
  }

  getAddress(user: any, type: string): string {
    return user?.addresses.find((a: { type: string; }) => a.type === type)?.address || 'N/A';
  }

  goHome(): void {
    this.router.navigate(['/']);
  }

  goDisplayUsers(): void {
    this.router.navigate(['/display-users']);
  }

  editUser(field: string): void {
    this.isEditing = { [field]: true };
    this.isEditingAny = true;
    // Set the editable data to the field value
    this.editableData[field] = this.user[field] || '';
  }

  saveChanges(): void {
    // Update the user object with the edited data
    Object.keys(this.isEditing).forEach((key) => {
      this.user[key] = this.editableData[key];
    });
    
    this.services.updateUser(this.user).subscribe(
      () => {
        console.log('User updated successfully');
        this.isEditing = {};
        this.isEditingAny = false;
      },
      (error) => {
        console.error('Error updating user:', error);
      }
    );
  }

  cancelEdit(): void {
    // Restore original data
    this.user = { ...this.originalData };
    this.editableData = { ...this.originalData }; // Reset editable data
    this.isEditing = {};
    this.isEditingAny = false;
  }
}
