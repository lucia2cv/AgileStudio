import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

//import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LogInComponent } from './log-in/log-in.component'
import { DialogoRegistroComponent } from './dialogoRegistro/dialogoRegistro.component';
import {HomeComponent} from "./home/home.component";

import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {MatGridListModule} from "@angular/material/grid-list";
import {MatCardModule,} from '@angular/material/card';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { FlexLayoutModule } from '@angular/flex-layout';
import {MatFormFieldModule} from '@angular/material/form-field';
import {MatInputModule} from "@angular/material/input";
import {ErrorStateMatcher, ShowOnDirtyErrorStateMatcher} from "@angular/material/core";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatIconModule} from "@angular/material/icon";
import {MAT_DIALOG_DEFAULT_OPTIONS, MatDialogModule} from "@angular/material/dialog";
import {MAT_RADIO_DEFAULT_OPTIONS, MatRadioModule} from '@angular/material/radio';
import {MatButtonModule} from '@angular/material/button';
import {LoginService} from "./log-in/login.service";
import {BasicAuthInterceptor} from "./auth/auth.interceptor";
import {ErrorInterceptor} from "./auth/error.interceptor";
import {RouterModule} from "@angular/router";



const appRoutes =[
  {path: 'login', component: LogInComponent, useAsDefault: true},
  {path: 'home', component: HomeComponent},
  {path: '**', redirectTo: ''}
];
@NgModule({
  declarations: [
    AppComponent,
    LogInComponent,
    DialogoRegistroComponent,
    HomeComponent,
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    BrowserModule,
   // AppRoutingModule,
    HttpClientModule,
    MatGridListModule,
    MatCardModule,
    ReactiveFormsModule,
    FlexLayoutModule,
    MatFormFieldModule,
    MatInputModule,
    BrowserAnimationsModule,
    MatIconModule,
    FormsModule,
    MatDialogModule,
    MatRadioModule,
    MatButtonModule,


  ],
  providers: [ LoginService,
    {provide: HTTP_INTERCEPTORS, useClass: BasicAuthInterceptor, multi:true},
    {provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi:true},
    {provide: ErrorStateMatcher, useClass: ShowOnDirtyErrorStateMatcher},
    {provide: MAT_RADIO_DEFAULT_OPTIONS, useValue: { color: 'accent'}},
    {provide: MAT_DIALOG_DEFAULT_OPTIONS, useValue: {panelClass: 'mat-dialog-override'}},
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
