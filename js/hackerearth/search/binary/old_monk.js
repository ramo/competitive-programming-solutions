/**
 * https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/the-old-monk/
 */
"use strict"

function binary_search_max(arr, key) {
    let s = 0;
    let e = arr.length - 1;
    let ans = -1;
    while (s <= e) {
        let mid = s + Math.floor((e - s) / 2);
        if (arr[mid] < key) {
            e = mid-1;
        } else {
            ans = mid;
            s = mid+1;
        }
    }
    return ans;
}


function main(args) {
    var next = 0;
    var t = parseInt(args[next++]);
    while (t--) {
        let n = parseInt(args[next++]);
        let a = args[next++].split(" ").map(Number);
        let b = args[next++].split(" ").map(Number);
        
        let ans = 0;
        let pi = -1;
        for (let i = 0; i < n; i++) {
            if (a[i] == pi) { // we just care left most i
                continue;
            }
            let j = binary_search_max(b, a[i]);
            if (j > i) {
                ans = Math.max(ans, j-i);
            }
            pi = a[i];
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