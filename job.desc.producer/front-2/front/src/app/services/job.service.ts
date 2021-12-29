import { Injectable } from '@angular/core';
import { HttpWrapService } from './http-wrap.service';

@Injectable({
  providedIn: 'root'
})
export class JobService {

  constructor(private http: HttpWrapService) { }


  /**
   * 
   */
  getAllJobDescs(): Promise<any> {

    return new Promise(

      (resolve, reject) => {

        this.http.get("/app/get-jobs")
  
          .then(data => {
            console.log("resolve()");
            resolve(data["jobDescs"])
          })
  
          .catch(error => {
            console.log("reject()");
            reject(error.error.error)
          });
      }

    )

  }


  addDescription(jobDes: any) {
    return new Promise(

      (resolve, reject) => {
        
        this.http.post("/app/add-desc", {
          id: jobDes.id,
          description: jobDes.desc
        })

        .then(data => {
          resolve(data)
        })

        .catch(error => {
          reject(error.error.error)
        })

      }

    )
  }

}
