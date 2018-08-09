/**
 * https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/monk-and-search-2/
 */
"use strict"

/**
 * First element not less than key is called lower bound
 */

function lower_bound(arr, key) {
    let s = 0;
    let e = arr.length - 1;
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

/**
 * First element greater than key is called upper bound
 */

function upper_bound(arr, key) {
    let s = 0;
    let e = arr.length - 1;
    while (s <= e) {
        let mid = s + Math.floor((e - s) / 2);
        if (arr[mid] <= key) {
            s = mid + 1;
        } else {
            e = mid - 1;
        }
    }
    return s;
}

function main(args) {
    var next = 0;
    var n = parseInt(args[next++]);
    var arr = args[next++].split(" ").map(x => parseInt(x));
    //sort the array
    arr.sort((x, y) => x - y);
    var q = parseInt(args[next++]);
    while (q--) {
        let input = args[next++].split(" ");
        let x = parseInt(input[1]);
        let b;
        if (input[0] === '0') { //lb
            b = lower_bound(arr, x);
        } else { //ub
            b = upper_bound(arr, x);
        }
        console.log(n - b);
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