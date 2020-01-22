import { Component } from '@angular/core';
import { AuthService } from './auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'mainProject';

  constructor(private service:AuthService,private router:Router)
  { }
  
  user={ 
    userId:null,
    name:"",
    email:"",
    password:"",
    gender:"",
    role:"",
    created_at:null,
    image:null,
    contact:null,
    deleted:"",
    posts:[],
    comments:[]}
    
  CheckUserNotLogin(){
    this.user = JSON.parse(sessionStorage.getItem("user"));
    return this.user==(null || undefined)
  }

  CheckUser(){

    this.user = JSON.parse(sessionStorage.getItem("user"));
    if(this.user!=(null || undefined)){
      return this.user.role == "USER";
    }
  }

  CheckAdmin(){

    this.user = JSON.parse(sessionStorage.getItem("user"));
    if(this.user!=(null || undefined)){
      return this.user.role == "ADMIN";
    }
  }

  Logout(){
    this.service.Logout();
    this.router.navigate(['home']);
  }

}
