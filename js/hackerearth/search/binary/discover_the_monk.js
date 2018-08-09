/**
 * https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/discover-the-monk/
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
    var next = 0;
    var q = parseInt(args[next++].split(" ")[1]);
    var arr = args[next++].split(" ").map(x => parseInt(x));
    arr.sort((x, y) => x - y);
    
    while (q--) {
        let x = parseInt(args[next++]);
        console.log(binary_search(arr, x) != -1 ? 'YES' : 'NO');
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