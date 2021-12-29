import { Injectable } from '@angular/core';
import { HttpWrapService } from './http-wrap.service';

@Injectable({
  providedIn: 'root'
})

export class StatService {

  constructor(private http: HttpWrapService) { }

  getAllJobDescs(): Promise<any> {

    return new Promise(

      (resolve, reject) => {
        this.http.get("/app/get-stats")
          .then(data => {
            console.log("resolve()");
            resolve(data["jobStats"])
          })
  
          .catch(error => {
            console.log("reject()");
            reject(error.error.error);
          });
      }
    )
  }

}
