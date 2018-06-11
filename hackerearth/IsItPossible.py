from sys import stdin, stdout


def main():
    buff = stdin.read().splitlines()
    t = int(buff[0])
    out = []
    for i in range(1, t):
        out.append('YES' if int(buff[i][-1:]) % 2 == 0 else 'NO')
    stdout.write('\n'.join(out))


if __name__ == '__main__':
    main()
