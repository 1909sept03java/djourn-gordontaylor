import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { IsPalindromeComponent } from './is-palindrome/is-palindrome.component';
import { SortNumsComponent } from './sort-nums/sort-nums.component';

@NgModule({
  declarations: [
    AppComponent,
    IsPalindromeComponent,
    SortNumsComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
