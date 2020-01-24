import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {

  posts={
    heading:"",
    description:"",
    body:"",
    category:"",
    filename:""
  }
  filename: any;
  imageUrl: any;
  userId:any;
  user:any
  returnResult:any
  categories:any;
constructor(private route:ActivatedRoute,
private router:Router,
private service:DataService) {

  this.getCategories();
 }

image:any;

ngOnInit() {
}

onSelectThumbnail(event) {
  this.image = event.target.files[0];
  
}

InsertBlog(formdata){

 this.user=JSON.parse(sessionStorage.getItem("user"));
 console.log("user"+this.user);
 this.userId=this.user.userId;
 console.log(this.userId);
 this.posts=formdata.form.value;

 console.log(this.posts);
let observableResult = this.service.InsertBlog(this.posts,this.image,this.userId);
observableResult.subscribe((result)=>{
 console.log(result);
 
 this.router.navigate(['home']);
})

}

getCategories(){
  this.service.getAllCategories().subscribe((res)=>{

   this.categories=res;
   console.log(this.categories);

  })
}

}
