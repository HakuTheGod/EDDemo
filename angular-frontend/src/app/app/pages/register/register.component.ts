import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ServicesService } from '../../../services.service';
import { Router } from '@angular/router';
import { BsDatepickerConfig, BsDatepickerModule } from 'ngx-bootstrap/datepicker';
import { BsDatepickerDirective } from 'ngx-bootstrap/datepicker';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { format } from 'date-fns'; 

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [
    CommonModule,
    HttpClientModule,
    ReactiveFormsModule,
    BsDatepickerModule
  ],
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  registerForm: FormGroup;
  bsConfig: Partial<BsDatepickerConfig> = {
    containerClass: 'theme-default',
    dateInputFormat: 'DD/MM/YYYY',
    showWeekNumbers: false,
  };
  formSubmitted = false;

  constructor(
    private fb: FormBuilder,
    private services: ServicesService,
    private router: Router
  ) {
    this.registerForm = this.fb.group({
      name: ['', Validators.required],
      surname: ['', Validators.required],
      gender: ['', Validators.required],
      birthDate: [null, Validators.required],
      workAddress: ['', Validators.required],
      homeAddress: ['', Validators.required]
    });
  }

  onSubmit(): void {
    this.formSubmitted = true;

    if (this.registerForm.valid) {
      const birthDate = this.registerForm.get('birthDate')?.value;
      const formattedDate = birthDate ? format(new Date(birthDate), 'dd/MM/yy') : ''; 

      const user = {
        name: this.registerForm.get('name')?.value,
        surname: this.registerForm.get('surname')?.value,
        gender: this.registerForm.get('gender')?.value,
        birthDate: formattedDate,
        addresses: [
          { address: this.registerForm.get('workAddress')?.value, type: 'work' },
          { address: this.registerForm.get('homeAddress')?.value, type: 'home' }
        ]
      };

      this.services.addUser(user).subscribe(
        (response: any) => {
          console.log('User added:', response);
          this.router.navigate(['/user-details', response.id], { state: { user } });
          this.registerForm.reset();
          this.formSubmitted = false;
        },
        (error: any) => {
          console.error('Error adding user:', error);
        }
      );
    }
  }

  showDatepicker(datepicker: BsDatepickerDirective): void {
    datepicker.show();
  }

  isFieldInvalid(fieldName: string): boolean {
    const control = this.registerForm.get(fieldName);
    return control ? (control.invalid && (control.touched || this.formSubmitted)) : false;
  }

  goHome(): void {
    this.router.navigate(['/']); 
  }
}
