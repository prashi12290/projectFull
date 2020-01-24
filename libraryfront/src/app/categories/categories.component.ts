import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {
  category={
    name:"",
    description:""
  };
  user:any;
 constructor(private service:DataService,private router:Router)
  { }
  message;
  SignIn(){
   console.log(this.category);
    //let isvalid = this.service.Login(this.userdetails);
     this.service.insertCategory(this.category).subscribe((result)=>{
       //this.user=result;
       console.log("user "+JSON.stringify(result));
     
     
      },(error)=>{
        console.log(error)
        this.message="unable to add new category";
        console.log("msg"+this.message)
      })
      
    }
  
  ngOnInit() {
  }
  
}
