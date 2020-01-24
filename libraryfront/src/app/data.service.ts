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

  InsertUser(userObj,image){
    console.log("user"+JSON.stringify(userObj));
    const formData = new FormData();
     formData.append('name',userObj.name);
     formData.append("email",userObj.email);
     formData.append("password",userObj.password);
     formData.append("confirmPassword",userObj.confirmPassword);
     formData.append("gender",userObj.gender);
     formData.append("phone",userObj.phone);
     formData.append("image",image);     
    return this.helper.post("http://localhost:7070/signup",formData);
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

  getMyPosts(userId) {
    return this.helper.get("http://localhost:7070/post/mypost/"+userId);
  }


  insertCategory(category) {
    const formData = new FormData();
     formData.append("name",category.name);
     formData.append("description",category.description);
    return this.helper.post("http://localhost:7070/addCategory",formData);
  }


  getAllCategories() {
    return this.helper.get("http://localhost:7070/categories")
  }

  getCategoryPosts(id) {
    return this.helper.get("http://localhost:7070/post/category/"+id)
  }
  
}
