    /**
     * https://www.hackerearth.com/practice/algorithms/searching/linear-search/practice-problems/algorithm/monk-takes-a-walk/
     */
    "use strict"
     
    function main(args) {
        var lines = args.split("\n");
        var str = "aeiouAEIOU";
        var hash = {};
        for (let i=0; i < str.length; i++) {
            hash[str.charAt(i)] = true;
        }
        var ans = [];
        for (let i=1; i < lines.length; i++) {
            let line = lines[i];
            let count = 0;
            for (let c=0; c < line.length; c++) {
                if (hash[line.charAt(c)]) {
                    ++count;
                }
            }
            ans.push("" + count);
        }
        process.stdout.write(ans.join('\n'));
    }
     
    process.stdin.resume();
    process.stdin.setEncoding('utf-8');
    var stdin_input = "";
     
    process.stdin.on("data", function(input) {
        stdin_input += input;
    });
     
    process.stdin.on("end", function() {
        main(stdin_input);
    });