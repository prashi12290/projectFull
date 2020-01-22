import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
 


  message;
  user={
   name:"",
   email:"",
   password:"",
   confirmPassword:"",
   gender:"",
   phone:""
  }
constructor(private route:ActivatedRoute,
private router:Router,
private service:DataService) { }


ngOnInit() {
}


InsertUser(){
console.log(this.user);


 if(this.user.password != this.user.confirmPassword){
  //this.router.navigate(['login']);
  this.message="password and confirmPassword do not match";
}
else {
  let observableResult = this.service.InsertUser(this.user);
  observableResult.subscribe((result)=>{
   console.log(result);
   this.router.navigate(['home']);

  });

}
}
}
