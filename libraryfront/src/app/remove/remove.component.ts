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
    this.userlist=[
      {'id':1,'name':'Nilesh Ghule','email':'nilesh@sunbeaminfo.com','role':'User'},
      {'id':2,'name':'Vishal Salunkhe','email':'vishal@sunbeaminfo.com','role':'User'},
      {'id':3,'name':'Nitin Kudale','email':'nitin@sunbeaminfo.com','role':'User'},
      {'id':4,'name':'Yogesh Kolhe','email':'yogesh.kolhe@sunbeaminfo.com','role':'User'},
      {'id':5,'name':'Praniti','email':'praniti@sunbeaminfo.com','role':'Admin'},
      {'id':6,'name':'Sarang Patil','email':'sarang@sunbeaminfo.com','role':'Admin'}
    ];
   }
  
  uname:string;
  userlist:any;

  ngOnInit() {
  
  }

  searchUser(){
    this.userlist=this.service.SearchUser(this.uname);
  }

  removeUser(userid){
    const result = confirm('Are you sure you want to remove user?');
      if (result) {
        this.service.RemoveUser(userid);
      }
  }
}