import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Train } from '../model/train';
import type { Observable } from 'rxjs';

@Injectable()
export class TrainService {

    private trainUrl: string;

    constructor(private http: HttpClient) {
        this.trainUrl = 'http://localhost:8080/train';
    }

    public findAll(): Observable<Train[]> {
        return this.http.get<Train[]>(this.trainUrl);
    }
}
