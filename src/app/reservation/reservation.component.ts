import {Component, OnInit} from '@angular/core';
import {FormBuilder} from '@angular/forms';
import {Router} from '@angular/router';
import {ReservationService} from './reservation.service';


@Component({
  selector: 'app-reservation',
  templateUrl: './reservation.component.html',
  styleUrls: ['./reservation.component.scss']
})
export class ReservationComponent implements OnInit {
  model: any = {};
  public selectedMoments = [
    new Date(2018, 1, 12, 10, 30),
    new Date(2018, 3, 21, 20, 30)
  ];
  isLinear = false;
  startDate: any;
  endDate: any;

  constructor(
              private formBuilder: FormBuilder,
              private reservationService: ReservationService,
              private router: Router) {
  }

  ngOnInit() {

  }


  reserve() {
    console.log("coucouuuuuuuuuuuuuuu");
    console.log(
    String(this.model.debut));
    this.reservationService.reserveForm(String(this.model.debut), String(this.model.fin), 1,1)
      .subscribe(response => {
        console.log("hhhhhhhhhh");

          alert("Votre inscription est effectuée avec succès")


           this.router.navigate(['/home']);
            // console.log(this.model.username, this.model.password);

      }, error => {
        console.error(error);
      });
     this.sendEmail()
  }

 sendEmail() {
    let receiver ='kiki';
    let nom ='kawther';
    let mail ='kawther.bjaoui@gmail.com'

    try {
      const data =  this.reservationService.notifEmail(receiver,nom,mail).subscribe(res=>{console.log("final");
      })
      // Since sendEmail again returns a Promise, I can await it.
      console.log(data);
    } catch (error) {
      console.log(error);
    }
  }
}
