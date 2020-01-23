import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  constructor() { this.user=JSON.parse(sessionStorage.getItem("user"));
console.log("usr"+this.user.name)}
  user:any;
  ngOnInit() {
  
  }

}
