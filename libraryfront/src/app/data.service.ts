import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class DataService {
 
  
  constructor(private helper:HttpClient) { }

  InsertBlog(postObj,image,userId){
    console.log(postObj);

    const formData = new FormData();
     formData.append('blogTitle',postObj.blogTitle);
     formData.append("description",postObj.description);
     formData.append("body",postObj.body);
     formData.append("category",postObj.category);
     formData.append("image",image);
     formData.append("userId",userId);
 
     return this.helper.post("http://localhost:7070/post/create/"+userId,formData);
   }

  InsertUser(userObj){
    console.log("user"+JSON.stringify(userObj));
    return this.helper.post("http://localhost:7070/signup",userObj);
  }

  RemoveUser(userid){
    return this.helper.delete("http://localhost:7070/user/"+userid);
  }

  getPosts(id) {
    return this.helper.get("http://localhost:7070/post/"+id)
  }

  getAllPosts() {
    return this.helper.get("http://localhost:7070/post")
  }


  SearchUser(uname){
    return this.helper.get("http://localhost:7070/user/name/"+uname);
  }

  makeAdmin(userid) {
    console.log("here"+userid)
    return this.helper.get("http://localhost:7070/user/"+userid);
                            
  }
}
