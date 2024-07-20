// user-details.component.ts
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ServicesService } from '../services.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-user-details',
  templateUrl: './user-details.component.html',
  styleUrls: ['./user-details.component.css'],
  providers: [ServicesService],
  standalone: true,
  imports: [CommonModule]
})
export class UserDetailsComponent implements OnInit {
  user: any;

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
}
