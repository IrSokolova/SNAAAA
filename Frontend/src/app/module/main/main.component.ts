import { Component} from '@angular/core';

@Component({
    selector: 'app-root',
    templateUrl: './main.component.html',
    styleUrls: ['./main.component.css']
})

export class MainComponent {

    constructor() {}

    submit(from: String, to: String, date: Date): void {
        console.log(from, to, date)

        // if (this.appointmentForm.invalid) {
        //     this.tryingToSubmit = true;
        //     return;
        // }
        // this.isProgressSpinnerOn = true;
        // this.specialistsService.postVisitOnServer(form.value).subscribe(
        //     (response: any) => {
        //         this.isProgressSpinnerOn = false;
        //         if (response.statusCode === 0) {
        //             this.showSuccessfulMessage(
        //                 'To edit or delete the appointment use the link from your Innopolis email.',
        //             );
        //         } else {
        //             this.showUnsuccessfulMessage();
        //         }
        //     },
        //     (error) => {
        //         this.isProgressSpinnerOn = false;
        //         this.showUnsuccessfulMessage();
        //     },
        // );
    }
}
