import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-blogpost',
  templateUrl: './blogpost.component.html',
  styleUrls: ['./blogpost.component.css']
})
export class BlogpostComponent implements OnInit {
  post:any;
  user:any;

  constructor(private service:DataService,private route:ActivatedRoute,
    private router:Router) {
    this.getData();
   }

  ngOnInit() {

  }

getData(){
  this.route.paramMap.subscribe((result)=>{ 
    let id = result.get("pId");
   // let id=3;
    console.log(id);

  this.service.getPosts(id).subscribe((res)=>{
    console.log(res);
    this.post=res;
  },(error)=>{
    console.log(error)
  })
})
}
}