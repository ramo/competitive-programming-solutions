/**
 * https://www.hackerearth.com/practice/algorithms/searching/binary-search/tutorial/
 */
"use strict"


function binary_search(arr, k) {
    var s = 0;
    var e = arr.length - 1;
    var ans = -1;
    while (s <= e) {
        let mid = s + Math.floor((e - s) / 2);
        if (arr[mid] == k) {
            ans = mid+1;
            break;
        } else if (arr[mid] < k) {
            s = mid+1;
        } else {
            e = mid-1;
        }
    }

    return ans;
}

function main(args) {
    var idx = 0;
    var n = parseInt(args[idx++]);
    var arr = args[idx++].split(" ").map(x => parseInt(x));
    arr.sort((a, b) => a-b);
    var q = parseInt(args[idx++]);
    while (q--) {
        var x = parseInt(args[idx++]);
        console.log(binary_search(arr, x));
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