    /**
     * https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/easy-sum-set-problem-7e6841ca/
     */
    "use strict"
     
    function intersect(st1, st2) {
        let tset = new Set();
        st1.forEach(el => {
            if (st2.has(el)) {
                tset.add(el);
            }
        });
        return tset;               
    }
     
    function main(args) {
        var a = args[1].split(" ").map(x => parseInt(x));
        var c = args[3].split(" ").map(x => parseInt(x));
        var cset = NaN;
        for (let i in a) {
            let st = new Set();
            for (let j in c) {
                st.add(c[j] - a[i]);
            }
            if (!cset) {
                cset = st;
            } else {
                cset = intersect(st, cset);
            }
        }
        let array = Array.from(cset);
        array.sort(((x, y) => {return x - y}));
        console.log(array.join(" "));
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