import {Routes, RouterModule} from "@angular/router";
import {HomeComponent} from "./home/home.component";
import {LogInComponent} from "./log-in/log-in.component";
const appRoutes =[
  {path: '/login', component: LogInComponent, useAsDefault: true},
  {path: 'home', component:HomeComponent}
];

export const routing=RouterModule.forRoot(appRoutes);
