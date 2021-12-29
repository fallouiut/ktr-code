import { Component, OnInit } from '@angular/core';
import { StatService } from './services/stat.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent implements OnInit {

  loading = true;
  jobStats: any = [];

  constructor(
    private statService: StatService
  ) {}

  ngOnInit(): void {

    setInterval(() => {
      this.loadJobDescs();
    }, 5000);
    
  }
  

  loadJobDescs() {
    this.loading = true;
    this.statService.getAllJobDescs()
    .then(data => {
      this.jobStats = data
      this.loading = false;
    })
    .catch(error => {
      alert(error);
      this.loading = false;
    })
  }

  getDescription(jobStat: any) {
    if(jobStat.description == "")
      return "...";
    else 
      return jobStat.description;
  }

}
