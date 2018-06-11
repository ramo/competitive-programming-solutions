from sys import stdin, stdout


def main():
    buff = stdin.read().splitlines()
    n, q = [int(x) for x in buff[0].split()]
    arr = [int(x) for x in buff[1].split()]
    result = []
    for loop in range(q):
        qs, qe = [int(x) for x in buff[2+loop].split()]
        result.append(str(max(arr[qs:qe+1]) - min(arr[qs:qe+1])))
    stdout.write("\n".join(result))


if __name__ == '__main__':
    main()
