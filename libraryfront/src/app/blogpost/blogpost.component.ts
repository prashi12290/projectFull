import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-blogpost',
  templateUrl: './blogpost.component.html',
  styleUrls: ['./blogpost.component.css']
})
export class BlogpostComponent implements OnInit {
  
  user:any;
  userComment="";
  post;
  id;
    

  constructor(private service:DataService,private route:ActivatedRoute,
    private router:Router) {
    this.getData();
   }

  ngOnInit() {

  }

getData(){
  this.user = JSON.parse(sessionStorage.getItem("user"));
  this.route.paramMap.subscribe((result)=>{ 
    this.id = result.get("pId");
    console.log(this.id);

  this.service.getPosts(this.id).subscribe((res)=>{
    console.log(res);
    this.post=res;
    console.log("pst"+this.post);
  },(error)=>{
    console.log(error)
  })
})
}

InsertComment(){

    console.log(this.userComment);
   let observableResult = this.service.InsertComment(this.post.pId,this.user.userId,this.userComment);
    observableResult.subscribe((result)=>{
     console.log(result);
  
    this.router.navigate(['home']);
 })
 
 }

}