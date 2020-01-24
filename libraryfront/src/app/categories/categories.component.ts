import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent implements OnInit {
  
  categories:any;
  postlist;
  user:any;
 constructor(private service:DataService,private router:Router,private route:ActivatedRoute)
  {
    this.getData();
  }
  
  
  ngOnInit() {
  }

  getData(){
    this.route.paramMap.subscribe((result)=>{ 
      let id = result.get("ctId");
      console.log(id);
    this.service.getCategoryPosts(id).subscribe((res)=>{
      this.postlist=res; 
      console.log(this.postlist);
      this.categories=this.postlist[0].category;
      this.user=this.postlist[0].user;
      console.log(this.categories)
    },(error)=>{
      console.log(error)
    })
  })
  }
 
}
