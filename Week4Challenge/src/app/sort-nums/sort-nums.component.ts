import { Component, OnInit } from '@angular/core';

import { Comment } from '@angular/compiler';
import { variable } from '@angular/compiler/src/output/output_ast';
@Component({
  selector: 'app-sort-nums',
  templateUrl: './sort-nums.component.html',
  styleUrls: ['./sort-nums.component.scss']
})
export class SortNumsComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }
  show = false;
  toggleDiv(){

    this.show = !this.show;
   }

   comment = '';

SortNums(nums){
  var specials = /[^A-Za-z0-9]/g;   //to verify if the word is a palandrome
  nums = nums.toLowerCase().replace(specials, ',');
  var newnums = nums.split(",");
  newnums.sort();
console.log(newnums);
  return newnums;



}

   addToComment(): void {


    const x = document.getElementById('myDiv');

    const p = document.createElement('p');

 const sorted =this.SortNums(this.comment);
//  sorted.toString();
console.log("sorted");
      p.innerHTML =  `${this.comment} was your original entry.${sorted} is your entry sorted`;
      x.appendChild(p);
    }













}

