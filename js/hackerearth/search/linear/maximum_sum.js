/**
 * https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/maximum-sum-4-f8d12458/
 */
"use strict"

function main(args) {
    args.shift();
    var arr = args.map(Number);

    var s = 0;
    var c = 0;
    var max_neg = Number.NEGATIVE_INFINITY;
    var flag = true;
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] >= 0) {
            c++;
            s += arr[i];
            if (flag)
                flag = false;    
        } else if (flag) {
            if (max_neg < arr[i]) {
                max_neg = arr[i];
            }
        }
    }

    if (c === 0) {
        c = 1;
        s = max_neg;
    }
    process.stdout.write('' + s + ' ' + c);
}

process.stdin.resume();
process.stdin.setEncoding('utf-8');
var stdin_input = "";

process.stdin.on("data", function(input) {
    stdin_input += input;
});

process.stdin.on("end", function() {
    main(stdin_input.split(/\s+/));
});