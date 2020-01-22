import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class AuthService implements CanActivate
{
  canActivate(route:ActivatedRouteSnapshot, state:RouterStateSnapshot) 
  {
    if(this.IsloggedIn()){
      return true;
    }else{
      this.router.navigate(['login']);
      return false;  
    }
    
  }

  IsloggedIn(){
    if(window.sessionStorage.getItem('user') != null)
    //&&
    //window.sessionStorage.getItem('active') == "1")
    {
            return true;
    }
    else{
           return false;
    }
  }

  constructor(private router:Router,private helper:HttpClient) 
  {  }

Login(userdetails){
    const formData = new FormData();
    formData.append("email",userdetails.uname);
    formData.append("password",userdetails.password);
    return this.helper.post("http://localhost:7070/login",formData);
 
}

Logout(){
  window.sessionStorage.setItem('user',null);
}


}