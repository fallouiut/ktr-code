import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, ReactiveFormsModule } from '@angular/forms';
import { JobService } from './services/job.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})

export class AppComponent implements OnInit {

  jobs: any = [];
  jobForm!: FormGroup;

  constructor(
    private jobService: JobService,
    private formBuilder: FormBuilder
  ) {}

  ngOnInit(): void {
    // load jobs
    console.log("ngOnInit()");
    this.jobService.getAllJobDescs()
    .then(data => {
      this.jobs = data
      console.log("resolve()");
      console.log("data: " + data.length);
    })
    .catch(error => {
      alert(error);
      console.log("reject()");
      // console.log(error);
    })

    // add form group
    this.jobForm = this.formBuilder.group({
      id:   ["", Validators.required],
      desc: ["", Validators.required]
    });
  }
  
  addJobDesc() {

    if(this.jobForm.valid) {

      let job = {
        id: this.jobForm.value.id,
        desc: this.jobForm.value.desc
      }

      this.jobService.addDescription(job)
      .then(data => {
        alert("ok");
      })
      .catch(error => {
        alert(error);
      })

    } else {
      alert("Data is not valid");
    }
  }

}
