import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';


@Injectable({
  providedIn: 'root'
})
export class HttpWrapService {

  constructor(
    private http: HttpClient
  ) { }

  url = "http://localhost:8060";

  getHeaders(): HttpHeaders {

    var token = sessionStorage.getItem("authToken");
    console.log("Http call -> Token: '" + token + "'");

    if(token == null || !token || token == 'undefined') {
      
      return new HttpHeaders()
      .set('Content-Type'                , 'application/json')
      .set('Accept'                      , 'application/json')
      .set('Access-Control-Allow-Origin' , '*')
      .set('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, PATCH, DELETE')
      .set('Access-Control-Allow-Headers', 'Access-Control-Allow-Origin, Content-Type, Accept, Accept-Language, Origin, User-Agent')
      
    } else {
      return new HttpHeaders()
      .set('Content-Type'                , 'application/json')
      .set('Accept'                      , 'application/json')
      .set('Access-Control-Allow-Origin' , '*')
      .set('Access-Control-Allow-Methods', 'GET, POST, OPTIONS, PUT, PATCH, DELETE')
      .set('Access-Control-Allow-Headers', '*')
      .set('Authorization', 'Bearer ' + token)
    }


  }

  get(uri: string) : Promise<any> {

    return new Promise(


      (resolve, reject) => {

        var url = this.url + uri;

        const headers = this.getHeaders();

        this.http.get(
          url,
          {
            headers: headers
          }
        ).toPromise()

        .then(data => {
          resolve(data);
        })
        .catch(error => {
          reject(error);
        })

      }

    );
  }

  post(uri: string, data: any): Promise<any> {

    return new Promise(

      (resolve, reject) => {
        
        var url = this.url + uri;

        const headers = this.getHeaders();

        this.http.post(
          url, 
          data,
          {
            headers: headers
          } 
        ).toPromise()

        .then((data) => {
          resolve(data);
        })

        .catch(error => {
          reject(error)
        });

      }

    );

  }
}