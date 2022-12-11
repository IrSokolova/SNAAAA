import { Component, OnInit } from '@angular/core';
import { Train } from '../../model/train';
import { TrainService } from '../../service/TrainService';

@Component({
    selector: 'app-train-list',
    templateUrl: './train-list.component.html',
    styleUrls: ['./train-list.component.css']
})
export class TrainListComponent implements OnInit {

    trains: Train[];
    trainsDataToOutput: Array<Train> = [];

    cols = [
        { field: 'departureTime', header: 'Departure' },
        { field: 'arrivalTime', header: 'Arrival' },
        { field: 'travelTime', header: 'Travel Time' },
        { field: 'trainNumber', header: 'Train' },
    ];

    constructor(private trainService: TrainService) {
    }

    ngOnInit() {

        // this.trainService.findTrains().subscribe((response: Train[]) => {
        //     this.trains = response;
        //
        //     this.trains.forEach((value) => {
        //         this.trainsDataToOutput.push({...value});
        //     });
        // });
    }
}
