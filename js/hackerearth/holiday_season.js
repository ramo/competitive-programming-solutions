/**
 * https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/holiday-season-ab957deb/
 */
"use strict"

function main(args) {
    var n = parseInt(args[0]);
    var str = args[1];
    var hash = {};
    var next = [];
    for (let i = n-1; i >= 0; i--) {
        let c = str.charAt(i);
        if (hash[c]) {
            next[i] = hash[c];
        } else {
            next[i] = -1;
        }
        hash[c] = i;
    }

    var ans = 0;
    for (let i = 0; i < n; i++) {
        if (next[i] === -1) {
            continue;
        } 
        for (let j = i+1; j < next[i]; j++) {
            for (let x = next[j]; x != -1; x = next[x]) {
                if (x > next[i]) {
                    ++ans;
                }
            }
        }
    }
    console.log(ans);
}

var fs = require('fs');
var data = fs.readFileSync('/Users/ramachandranr/Desktop/input.txt', 'utf-8');
main(data.split("\n"));


// process.stdin.resume();
// process.stdin.setEncoding('utf-8');
// var stdin_input = "";

// process.stdin.on("data", function(input) {
//  stdin_input += input;
// });

// process.stdin.on("end", function() {
//  main(stdin_input.split("\n"));
// });