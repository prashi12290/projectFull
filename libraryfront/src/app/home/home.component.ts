import { Component, OnInit } from '@angular/core';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { DataService } from '../data.service';
import { AuthService } from '../auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  blogs:any;

  constructor(private service:AuthService,private dataServie : DataService,private router:Router) {
    this.dataServie.getAllPosts().subscribe((res)=>{
      this.blogs=res;
    });
    this.getCategories();
   }
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

  categories:any;
  
  ngOnInit() {
    
  }

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

  getCategories(){
    this.dataServie.getAllCategories().subscribe((res)=>{
  
     this.categories=res;
     console.log(this.categories);
  
    })
  }
}
