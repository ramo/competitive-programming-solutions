/**
 * https://www.hackerearth.com/practice/algorithms/searching/binary-search/practice-problems/algorithm/stones-love/
 */
"use strict"

function lower_bound(arr, key) {
    let s = 0; 
    let e = arr.length - 1;
    let ans = -1;
    while (s <= e) {
        let mid = s + Math.floor((e - s) / 2);
        if (arr[mid] == key) {
            ans = mid + 1;
            break;
        } else if (arr[mid] > key) {
            e = mid - 1;
            ans = mid + 1;
        } else {
            s = mid + 1;
        }
    }
    return ans;
}

function main(args) {
    var tmp = args[0].trim().split(" ").map(x => parseInt(x));
    var n = tmp[0];
    var q = tmp[1];
    var stones = args[1].trim().split(" ").map(x => parseInt(x));
    var quries = args[2].trim().split(" ").map(x => parseInt(x));

    var stt = [stones[0]];
    for (let i = 1; i < n; i++) {
        stt[i] = stt[i-1] + stones[i];
    }
 
    var result = [];
    for (let i = 0; i < q; i++) {
        let m = quries[i];
        result.push(lower_bound(stt, m));
    }
    console.log(result.join("\n"));
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