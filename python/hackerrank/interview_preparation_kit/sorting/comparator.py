"""
https://www.hackerrank.com/challenges/ctci-comparator-sorting/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=sorting
"""

from functools import cmp_to_key


class Player:
    def __init__(self, name, score):
        self.name = name
        self.score = score

    def comparator(a, b):
        d = b.score - a.score
        if d == 0:
            if a.name < b.name:
                d = -1
            elif a.name > b.name:
                d = 1
        return d


def main():
    n = int(input())
    data = []
    for i in range(n):
        name, score = input().split()
        score = int(score)
        player = Player(name, score)
        data.append(player)

    data = sorted(data, key=cmp_to_key(Player.comparator))
    for i in data:
        print(i.name, i.score)


if __name__ == '__main__':
    main()
