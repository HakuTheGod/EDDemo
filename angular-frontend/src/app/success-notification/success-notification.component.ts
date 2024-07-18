import { Component, Input } from '@angular/core';
import { CommonModule } from '@angular/common'; // Import CommonModule

@Component({
  selector: 'app-success-notification',
  standalone: true,
  imports: [CommonModule], // Include CommonModule
  templateUrl: './success-notification.component.html',
  styleUrls: ['./success-notification.component.css']
})
export class SuccessNotificationComponent {
  @Input() message: string = '';
  @Input() isVisible: boolean = false;
}