import { Component, OnInit } from '@angular/core';
import { EnrolmentService } from '../service/enrolment.service';
import { Subject } from '../model/subject';

@Component({
  selector: 'app-listing',
  templateUrl: './listing.component.html',
  styleUrls: ['./listing.component.css']
})
export class ListingComponent implements OnInit {

  constructor(private enrolmentService : EnrolmentService) { }

  subjects : Subject[] = null;
  dataLoaded : boolean = false;

  ngOnInit() {
    this.enrolmentService.getSubjects().subscribe(
      data => {
        this.subjects = data;
        for(var i=0;i<data.length;++i){
          data[i].collapse = true;
        }
        this.dataLoaded = true;
      },
      error => {
          console.log(error);
      });
  }

  openModal(subject : Subject){
    console.log(subject);
    this.enrolmentService.getStudents(subject.subject_code).subscribe(
      data => {
        var studentData = "student ids: ";
        console.log(data);
        for(var i=0;i<data.length;++i){
          studentData+=data[i].student_id+", "
        }
        alert(studentData);
      },
      error => {
          console.log(error);
      });
  }

}
