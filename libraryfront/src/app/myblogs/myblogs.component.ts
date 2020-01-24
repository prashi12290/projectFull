import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-myblogs',
  templateUrl: './myblogs.component.html',
  styleUrls: ['./myblogs.component.css']
})
export class MyblogsComponent implements OnInit {

  posts:any;
  user:any;

  constructor(private service:DataService,private route:ActivatedRoute,
    private router:Router) {
    this.getData();
    
   }

  ngOnInit() {

  }

getData(){
  this.route.paramMap.subscribe((result)=>{ 
    let id = result.get("userId");
   // let id=3;
    console.log(id);

  this.service.getMyPosts(id).subscribe((res)=>{
    console.log(res);
    this.posts=res;
  },(error)=>{
    console.log(error)
  })
})
}
}
