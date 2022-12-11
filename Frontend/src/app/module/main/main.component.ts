import { Component} from '@angular/core';
import {document} from "ngx-bootstrap/utils";
import { TrainService } from "../../service/TrainService";
import { FindTrainRequest } from "../../model/find-train-request";
import { Router } from "@angular/router";
import {Train} from "../../model/train";

@Component({
    selector: 'app-root',
    templateUrl: './main.component.html',
    styleUrls: ['./main.component.css']
})

export class MainComponent {

    constructor(private trainService: TrainService,
                private router: Router) {}

    display = false;
    trains: Train[];
    trainsDataToOutput: Array<Train> = [];

    cols = [
        { field: 'departureStationName', header: 'From'},
        { field: 'departureAt', header: 'Departure' },
        { field: 'destinationStationName', header: 'To'},
        { field: 'arrivalAt', header: 'Arrival' },
        { field: 'distance', header: 'Distance' },
        { field: 'trainNumber', header: 'Train' },
    ];

    // [{"trainNumber":13,"departureStationName":"KAZAN","destinationStationName":"MOSCOW","departureAt":"2022-12-14T20:59:38.198Z","arrivalAt":"2022-12-14T20:56:35.441Z","distance":23.00}]

    submitForm(): void {
        let from = document.getElementById("startPoint").value;
        let to = document.getElementById("destPoint").value;
        let date = document.getElementById("startDate").value;
        // console.log(from, to, date)

        let options = { hour: '2-digit', minute: '2-digit' };
        // let options = { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric', hour: '2-digit', minute: '2-digit' };
        // date = Intl.DateTimeFormat("en", options).format(date)


        const request = {
            fromStationName: from,
            toStationName: to,
            departureAt: date,
        } as FindTrainRequest;

        // this.trainService.findTrains(request).subscribe();

        // this.router.navigate(['/trains/search'],
        //     {state:{data:this.trainService.findTrains(request).subscribe()}})
        this.display = true

        this.trainService.findTrains(request).subscribe((response: Train[]) => {
            this.trains = response;

            this.trains.forEach((value) => {
                console.log(typeof(value.departureAt))
                let time1 = Date.parse(value.departureAt)
                let time2 = Date.parse(value.arrivalAt)
                value.departureAt = Intl.DateTimeFormat("en", options).format(time1)
                value.arrivalAt = Intl.DateTimeFormat("en", options).format(time2)
                // value.departureAt = new Date(Intl.DateTimeFormat("en", options).format(value.departureAt))
                this.trainsDataToOutput.push({...value});
            });
        });
    }


}
