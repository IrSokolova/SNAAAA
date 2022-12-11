import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MainComponent } from './module/main/main.component';
import { TrainListComponent } from './module/train-list/train-list.component';
import { TrainService } from './service/TrainService';
import {TableModule, ToastModule} from "primeng";

@NgModule({
    declarations: [
        MainComponent,
        TrainListComponent,
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule,
        TableModule,
        ToastModule
    ],
    providers: [TrainService],
    bootstrap: [MainComponent]
})
export class AppModule { }
