import { Component, OnInit } from '@angular/core';
import { Comment } from '@angular/compiler';
import { variable } from '@angular/compiler/src/output/output_ast';

@Component({
  selector: 'app-is-palindrome',
  templateUrl: './is-palindrome.component.html',
  styleUrls: ['./is-palindrome.component.scss']
})
export class IsPalindromeComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }

  show = false;

  toggleDiv(){

   this.show = !this.show;
  }

  comment = '';

   IsPalindrome(word) {   //remove special characters and check beginning and ending string chars
    var specials = /[^A-Za-z0-9]/g;   //to verify if the word is a palandrome
    word = word.toLowerCase().replace(specials, '');
    var wordlength = word.length;
    for (var i = 0; i < wordlength/2; i++) {
      if (word[i] !== word[wordlength - 1 - i]) { //if characters are not equal return false
          return false;
      }
    }
    return true;}
   addToComment(): void {


    const x = document.getElementById('myDiv');

    const p = document.createElement('p');

    if (this.IsPalindrome(`${this.comment}`)  == true){

      p.innerHTML =  `${this.comment} is a palindrome`;
      x.appendChild(p);
    }
    else{
      p.innerHTML =  `${this.comment} is not a palindrome`;
      x.appendChild(p);

    }
}
}
