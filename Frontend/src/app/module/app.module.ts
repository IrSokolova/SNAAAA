import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MainComponent } from './main/main.component';
import { TrainListComponent } from './train-list/train-list.component';
import { TrainService } from '../service/TrainService';

@NgModule({
    declarations: [
        MainComponent,
        TrainListComponent,
    ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule
    ],
    providers: [TrainService],
    bootstrap: [MainComponent]
})
export class AppModule { }
