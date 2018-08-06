/**
 * https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/joker-and-thieves-53e59f4a/
 */
"use strict"

function main(args) {
    var t = parseInt(args.shift());
    while (t--) {
        let line = args.shift();
        let ans = 0;
        if (line) {
            let tmp = line.split(" ");
            let n = parseInt(tmp[0]);
            let k = parseInt(tmp[1]);
            
            while (n--) {
                let arr = args.shift().split(" ");
                let pptr = 0;
                let tptr = 0;
                do {
                    while (pptr < arr.length && arr[pptr] !== 'P') {
                        pptr++;
                    }                   
                    while (tptr < arr.length && arr[tptr] !== 'T') {
                        tptr++;
                    }
    
                    if (arr[pptr] === 'P' && arr[tptr] === 'T') {
                        if (Math.abs(pptr - tptr) <= k) {
                            ++ans;
                            ++pptr;
                            ++tptr;    
                        } else {
                            if (pptr < tptr) {
                                ++pptr;
                            } else {
                                ++tptr;
                            }
                        }
                    } 
                } while (pptr < arr.length && tptr < arr.length);
            }    
        }
        console.log(ans);
    }
}

process.stdin.resume();
process.stdin.setEncoding('utf-8');
var stdin_input = "";

process.stdin.on("data", function(input) {
 stdin_input += input;
});

process.stdin.on("end", function() {
 main(stdin_input.split("\n"));
});