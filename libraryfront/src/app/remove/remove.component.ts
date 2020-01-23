import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-remove',
  templateUrl: './remove.component.html',
  styleUrls: ['./remove.component.css']
})
export class RemoveComponent implements OnInit {

  constructor(private service:DataService,private router:Router) {
    
   }
  
  uname:string;
  userlist:any;
  message;
  ngOnInit() {
    
  }

  searchUser(){
    this.service.SearchUser(this.uname).subscribe((res)=>{
      this.userlist=res;
    });
  }

  removeUser(userid){
    const result = confirm('Are you sure you want to remove user?');
      if (result) {
        console.log("uid"+userid)
        let observable=this.service.RemoveUser(userid);
        observable.subscribe((result)=>{
          //console.log(result);
          this.message="user removed"
        },(error)=>{
          console.log(error)
          this.message="user not removed";
        })
      }
  }
}