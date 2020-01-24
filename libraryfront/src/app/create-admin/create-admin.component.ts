import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-admin',
  templateUrl: './create-admin.component.html',
  styleUrls: ['./create-admin.component.css']
})
export class CreateAdminComponent implements OnInit {

  constructor(private service:DataService,private router:Router) { }
  message;
  uname:string;
  userlist:any;
  ngOnInit() {
  }

  searchUser(){
    this.service.SearchUser(this.uname).subscribe((res)=>{
      this.userlist=res;
    });
  }

  makeUserAdmin(userid){
    const result = confirm('Are you sure you want to user admin?');
      if (result) {
        console.log("uid"+userid)
        this.service.makeAdmin(userid).subscribe((res)=>{
          console.log(res);
          this.message="selected user role updated"
        },(error)=>{
          console.log(error)
          this.message="selected user role not updated";
        })
      }
  }
}
