from sys import stdin, stdout


def main():
    buff = stdin.read().splitlines()
    result = []
    idx = 0
    t = int(buff[idx])
    idx += 1
    while t > 0:
        n, k = map(int, buff[idx].split())
        idx += 1
        array = list(map(int, buff[idx].split()))
        idx += 1
        result.append(str(k - min(array)))
        t -= 1
    stdout.write('\n'.join(result))


if __name__ == '__main__':
    main()
