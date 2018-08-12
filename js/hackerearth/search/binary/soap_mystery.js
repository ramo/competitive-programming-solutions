/**
 * https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/the-soap-mystery/
 */
"use strict"

/**
 * First element not less than key is called lower bound
 */
function lower_bound(arr, key) {
    var s = 0;
    var e = arr.length - 1;
    while (s <= e) {
        let mid = s + Math.floor((e - s) / 2);
        if (arr[mid] >= key) {
            e = mid - 1;
        } else {
            s = mid + 1;
        }
    }
    return s;
}

function main(args) {
    var next = 0;
    var n = parseInt(args[next++]);
    var soaps = args[next++].split(" ").map(x => parseInt(x));
    soaps.sort((x, y) => x - y);
    var q = parseInt(args[next++]);
    while (q--) {
        let m = parseInt(args[next++]);
        console.log(lower_bound(soaps, m));
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