import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-publish',
  templateUrl: './publish.component.html',
  styleUrls: ['./publish.component.css']
})
export class PublishComponent implements OnInit {

  postlist;
  message;
  constructor(private dataService : DataService,private router:Router) 
  { 
    this.getPosts()
  }

  ngOnInit() {
  }

  getPosts(){
    this.dataService.getUnpublishedPosts().subscribe((res)=>{
      this.postlist=res;
    });
  }

  publishPost(pId){
    const result = confirm('Are you sure you want to Publish Post?');
      if (result) {
        console.log("pid"+pId)
        let observable=this.dataService.publishPost(pId);
        observable.subscribe((result)=>{
          window.location.reload();
        },(error)=>{
          console.log(error)
          this.message="error publishing post";
        })
      }
  }

  removePost(pId){
    const result = confirm('Are you sure you want to Remove Post?');
      if (result) {
        console.log("pid"+pId)
        let observable=this.dataService.removePost(pId);
        observable.subscribe((result)=>{
        this.router.navigate(['publish']);
        },(error)=>{
          console.log(error)
          this.message="error publishing post";
        })
      }
  }
}
