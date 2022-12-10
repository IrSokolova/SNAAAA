import { Component} from '@angular/core';
import {document} from "ngx-bootstrap/utils";
import { TrainService } from "../../service/TrainService";
import { FindTrainRequest } from "../../model/find-train-request";

@Component({
    selector: 'app-root',
    templateUrl: './main.component.html',
    styleUrls: ['./main.component.css']
})

export class MainComponent {

    constructor(private trainService: TrainService) {}

    submitForm(): void {
        let from = document.getElementById("startPoint").value;
        let to = document.getElementById("destPoint").value;
        let date = document.getElementById("startDate").value;
        // console.log(from, to, date)

        const request = {
            departure: from,
            arrival: to,
            depDate: date,
        } as FindTrainRequest;

        this.trainService.findAll(request).subscribe();
    }
}
