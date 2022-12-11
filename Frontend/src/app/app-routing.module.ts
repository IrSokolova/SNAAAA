import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TrainListComponent } from './module/train-list/train-list.component';

const routes: Routes = [
    { path: 'trains/search', component: TrainListComponent }
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})
export class AppRoutingModule { }
