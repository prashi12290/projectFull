import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { DataService } from '../data.service';

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {

  constructor(private route:ActivatedRoute,
    private router:Router,
    private service:DataService) { 
      this.getCategories();
    }
  posts:any;
  categories:any;
  image:any;
  id;
  ngOnInit() {

    this.route.paramMap.subscribe((result)=>{ 
      this.id = result.get("pId");
      console.log(this.id);

      let observableResult = this.service.getPosts(this.id);
      observableResult.subscribe((records)=>{ 
        console.log(records);
        this.posts=records;
        
      } );

    });
  }

  onSelectThumbnail(event) {
    this.image = event.target.files[0];
    
  }

  

  Update(formdata){

    
  
    this.posts=formdata.form.value;
   
    console.log(this.posts);
   let observableResult = this.service.updatePost(this.posts,this.image,this.id);
   observableResult.subscribe((result)=>{
    console.log(result);
    
    this.router.navigate(['home']);
   })
   
   }
   

  getCategories(){
    this.service.getAllCategories().subscribe((res)=>{
  
     this.categories=res;
     console.log("categories "+this.categories);
  
    })
  }

}
