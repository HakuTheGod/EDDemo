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
  editableData: any = {};
  originalData: any = {};
  isEditing: any = {};
  isEditingAny = false;
  genderError = false;

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
        this.editableData = { ...this.user };
        this.originalData = { ...this.user };
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
    this.editableData[field] = this.user[field] || '';
    this.genderError = false; // Reset gender error when editing starts
  }

  validateGender(): void {
    const validGenders = ['male', 'female', 'other'];
    this.genderError = !validGenders.includes(this.editableData.gender.toLowerCase());
  }

  saveChanges(): void {
    const changes: any = {};
    Object.keys(this.isEditing).forEach((key) => {
      if (this.editableData[key] !== this.originalData[key]) {
        changes[key] = this.editableData[key];
      }
    });

    if (Object.keys(changes).length > 0) {
      const userId = this.user?.id;
      if (userId) {
        this.services.updateUser(userId, changes).subscribe(
          () => {
            this.originalData = { ...this.user, ...changes };
            this.user = { ...this.user, ...changes };
            this.editableData = { ...this.user };
            this.isEditing = {};
            this.isEditingAny = false;
          },
          (error) => {
            console.error('Error updating user:', error);
          }
        );
      }
    } else {
      this.cancelEdit();
    }
  }

  cancelEdit(): void {
    this.user = { ...this.originalData };
    this.editableData = { ...this.originalData };
    this.isEditing = {};
    this.isEditingAny = false;
  }
}
