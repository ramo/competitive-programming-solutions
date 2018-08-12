/**
 * https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/highest-average-25400da7/
 */
"use strict"

function binary_search(arr, key) {
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
    var nxt = 0;
    var n = parseInt(args[nxt++]);
    var arr = args[nxt++].split(" ").map(x => parseInt(x));
    arr.sort((x, y) => x - y);
    
    var sum_arr = [arr[0]];
    for (let i = 1; i < n; i++) {
        sum_arr[i] = sum_arr[i-1] + arr[i];
    }
    
    var avg_arr = [];
    for (let i = 0; i < n; i++) {
        avg_arr[i] = Math.floor(sum_arr[i] / (i+1));
    }

    var q = parseInt(args[nxt++]);
    while (q--) {
        let k = parseInt(args[nxt++]);
        console.log(binary_search(avg_arr, k));
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