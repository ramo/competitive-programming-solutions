/**
 * https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/breakup-app/
 */
"use strict"

function main(args) {
    var n = Number(args.shift());
    let hash = [];
    let keys = [];
    for (let i = 0; i < n; i++) {
        let f = args[i].startsWith('G:') ? 2 : 1;
        let nos = args[i].match(/\d+/g) || [];
        for (let j = 0; j < nos.length; j++) {
            if (!keys.includes(nos[j])) {
                keys.push(nos[j]);
            }
            hash[nos[j]] = (hash[nos[j]] || 0) + f;
        }
    }

    var mx_value = -1;
    var mx_key = -1;

    for (let i = 0; i < keys.length; i++) {
        if (hash[keys[i]] > mx_value) {
            mx_value = hash[keys[i]];
            mx_key = keys[i];
        } else if (hash[keys[i]] == mx_value) {
            mx_value = -1;
            mx_key = -1;
        }
    }

    if (mx_key == 19 || mx_key == 20) {
        console.log('Date');
    } else {
        console.log('No Date');
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