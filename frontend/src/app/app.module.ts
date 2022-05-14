import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import {RouterModule} from '@angular/router';
import { AppComponent } from './app.component';
import { LogInComponent } from './log-in/log-in.component'
import { DialogoRegistroComponent } from './dialogoRegistro/dialogoRegistro.component';
import {HomeComponent} from "./home/home.component";

import {HTTP_INTERCEPTORS, HttpClientModule} from '@angular/common/http';
import {MatGridListModule} from "@angular/material/grid-list";
import {MatCardModule,} from '@angular/material/card';
import {MatChipsModule} from '@angular/material/chips';
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

import {AppRoutingModule} from "./app-routing.module";
import { TalleresComponent } from './components/talleres/talleres.component';
import { EquiposComponent } from './components/equipos/equipos.component';
import { NavbarComponent } from './components/navbar/navbar.component';
import {ROUTES} from "./app.routes";

import {MatTabsModule} from '@angular/material/tabs';
import { MatToolbarModule } from '@angular/material/toolbar';
import {MatSidenavModule} from '@angular/material/sidenav';
import {MatListModule} from '@angular/material/list';
import {MatDividerModule} from '@angular/material/divider';
import {UserService} from "./user.service";
import { FooterComponent } from './components/footer/footer.component';
import {MatTooltipModule} from '@angular/material/tooltip';
import { EditUserComponent } from './edit-user/edit-user.component';
import {EquipoService} from "./servicios/equipo.service";
import {TallerService} from "./servicios/taller.service";
import { CategoryComponent } from './components/category/category.component';
import { UnTallerComponent } from './components/unTaller/unTaller.component';
import { UnEquipoComponent } from './components/unEquipo/unEquipo.component';

/*const appRoutes =[
  {path: '', component: LogInComponent, useAsDefault: true},
  {path: 'home', component: HomeComponent}
 // {path: '**', redirectTo: ''}
];*/
@NgModule({
  declarations: [
    AppComponent,
    LogInComponent,
    DialogoRegistroComponent,
    HomeComponent,
    TalleresComponent,
    EquiposComponent,
    NavbarComponent,
    FooterComponent,
    EditUserComponent,
    CategoryComponent,
    UnTallerComponent,
    UnEquipoComponent,
  ],
  imports: [
    RouterModule.forRoot(ROUTES),
    BrowserModule,
    AppRoutingModule,
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
    MatTabsModule,
    MatToolbarModule,
    MatSidenavModule,
    MatListModule,
    MatDividerModule,
    MatTooltipModule,
    MatChipsModule

  ],
  providers: [ LoginService,UserService,EquipoService,TallerService,
    {provide: HTTP_INTERCEPTORS, useClass: BasicAuthInterceptor, multi:true},
    {provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi:true},
    {provide: ErrorStateMatcher, useClass: ShowOnDirtyErrorStateMatcher},
    //{provide: MAT_RADIO_DEFAULT_OPTIONS, useValue: { color: '#003D33'}},
    {provide: MAT_DIALOG_DEFAULT_OPTIONS, useValue: {panelClass: 'mat-dialog-override'}},
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
