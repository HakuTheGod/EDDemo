import { Routes } from '@angular/router';
import { HomeComponent } from './app/pages/home/home.component';
import { RegisterComponent } from './app/pages/register/register.component';
import { DisplayUsersComponent } from './app/pages/display-users/display-users.component';

export const routes: Routes = [
    {path:'',
    children:[
        {path:'',component:HomeComponent},
        {path:'register',component:RegisterComponent},
        {path:'display-users',component:DisplayUsersComponent}
    ]
},
    
];