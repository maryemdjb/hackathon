import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AddBikeComponent} from './add-bike.component';


const routes: Routes = [
  {path: '' , component : AddBikeComponent},

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class AddBikeRoutingModule { }
