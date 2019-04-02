algorithm-practice

위에서 아래 순서대로 진행할 것을 권장

## 백준 대표 문제 풀이
* 1시간 넘어가면 풀던 짓을 그만두고 반드시 AC받은 코드 찾아보기 (설명이 꼭 달려있는 코드를 읽자)
* 이 문제의 답을 빨리 확인하고 이와 유사한 문제들을 여러개 풀어제끼는 것이 아주아주 현명한 방법임을 명심하자.
* 푼 다음에는 반드시 다른 사람의 코드를 봐야 한다. (로직 비슷한 풀이 말고, 완전 다르지만 참신한 방법이면 훑어보기)

총 4주 (그리디 전까지 2주, 그리디/완전탐색 2주)안에 완료하는 것을 목표로 잡는 것이 좋다.

> 취소선은 작성자가 완료한 문제를 표기한 것일 뿐, 아무 의미 없습니다.


### 입출력
[~~2557~~](https://www.acmicpc.net/problem/2557), [~~1000~~](https://www.acmicpc.net/problem/1000), [~~2558~~](https://www.acmicpc.net/problem/2558), [~~10950~~](https://www.acmicpc.net/problem/10950), [~~10951~~](https://www.acmicpc.net/problem/10951), [~~10952~~](https://www.acmicpc.net/problem/10952), [~~10953~~](https://www.acmicpc.net/problem/10953), [~~11021~~](https://www.acmicpc.net/problem/11021), [~~11022~~](https://www.acmicpc.net/problem/11022), [~~11718~~](https://www.acmicpc.net/problem/11718), [~~11719~~](https://www.acmicpc.net/problem/11719), [~~11720~~](https://www.acmicpc.net/problem/11720), [~~11721~~](https://www.acmicpc.net/problem/11721), [~~2741~~](https://www.acmicpc.net/problem/2741), [~~2742~~](https://www.acmicpc.net/problem/2742), [~~2739~~](https://www.acmicpc.net/problem/2739), [~~1924~~](https://www.acmicpc.net/problem/1924), [~~8393~~](https://www.acmicpc.net/problem/8393), [~~10818~~](https://www.acmicpc.net/problem/10818), [~~2438~~](https://www.acmicpc.net/problem/2438), [~~2439~~](https://www.acmicpc.net/problem/2439), [~~2440~~](https://www.acmicpc.net/problem/2440), [~~2441~~](https://www.acmicpc.net/problem/2441), [~~2442~~](https://www.acmicpc.net/problem/2442), [~~2445~~](https://www.acmicpc.net/problem/2445), [~~2522~~](https://www.acmicpc.net/problem/2522), [~~2446~~](https://www.acmicpc.net/problem/2446), [~~10991~~](https://www.acmicpc.net/problem/10991), [~~10992~~](https://www.acmicpc.net/problem/10992)

### DP
[~~1463~~](https://www.acmicpc.net/problem/1463), [~~11726~~](https://www.acmicpc.net/problem/11726), [~~11727~~](https://www.acmicpc.net/problem/11727), [~~9095~~](https://www.acmicpc.net/problem/9095), [~~10844~~](https://www.acmicpc.net/problem/10844), [~~11057~~](https://www.acmicpc.net/problem/11057), [~~2193~~](https://www.acmicpc.net/problem/2193), [~~9465~~](https://www.acmicpc.net/problem/9465), [~~2156~~](https://www.acmicpc.net/problem/2156), [~~11053~~](https://www.acmicpc.net/problem/11053), [11055](https://www.acmicpc.net/problem/11055), [11722](https://www.acmicpc.net/problem/11722), [11054](https://www.acmicpc.net/problem/11054), [1912](https://www.acmicpc.net/problem/1912), [2579](https://www.acmicpc.net/problem/2579), [1699](https://www.acmicpc.net/problem/1699), [2133](https://www.acmicpc.net/problem/2133), [9461](https://www.acmicpc.net/problem/9461), [2225](https://www.acmicpc.net/problem/2225), [2011](https://www.acmicpc.net/problem/2011), [11052](https://www.acmicpc.net/problem/11052)

### 기타
[2751](https://www.acmicpc.net/problem/2751), [11650](https://www.acmicpc.net/problem/11650), [11651](https://www.acmicpc.net/problem/11651), [10814](https://www.acmicpc.net/problem/10814), [10825](https://www.acmicpc.net/problem/10825), [10989](https://www.acmicpc.net/problem/10989), [11652](https://www.acmicpc.net/problem/11652), [11004](https://www.acmicpc.net/problem/11004), [10828](https://www.acmicpc.net/problem/10828), [9012](https://www.acmicpc.net/problem/9012), [10799](https://www.acmicpc.net/problem/10799), [10845](https://www.acmicpc.net/problem/10845), [10866](https://www.acmicpc.net/problem/10866), [10808](https://www.acmicpc.net/problem/10808), [10809](https://www.acmicpc.net/problem/10809), [10820](https://www.acmicpc.net/problem/10820), [2743](https://www.acmicpc.net/problem/2743), [11655](https://www.acmicpc.net/problem/11655), [10824](https://www.acmicpc.net/problem/10824), [11656](https://www.acmicpc.net/problem/11656), [1406](https://www.acmicpc.net/problem/1406), [1158](https://www.acmicpc.net/problem/1158), [1168](https://www.acmicpc.net/problem/1168), [10430](https://www.acmicpc.net/problem/10430), [2609](https://www.acmicpc.net/problem/2609), [1934](https://www.acmicpc.net/problem/1934), [1850](https://www.acmicpc.net/problem/1850), [9613](https://www.acmicpc.net/problem/9613), [11005](https://www.acmicpc.net/problem/11005), [2745](https://www.acmicpc.net/problem/2745), [1373](https://www.acmicpc.net/problem/1373), [1212](https://www.acmicpc.net/problem/1212), [2089](https://www.acmicpc.net/problem/2089), [11576](https://www.acmicpc.net/problem/11576), [1978](https://www.acmicpc.net/problem/1978), [1929](https://www.acmicpc.net/problem/1929), [6588](https://www.acmicpc.net/problem/6588), [11653](https://www.acmicpc.net/problem/11653), [10872](https://www.acmicpc.net/problem/10872), [1676](https://www.acmicpc.net/problem/1676), [2004](https://www.acmicpc.net/problem/2004)

### 그래프
[1260](https://www.acmicpc.net/problem/1260), [11724](https://www.acmicpc.net/problem/11724), [1707](https://www.acmicpc.net/problem/1707), [10451](https://www.acmicpc.net/problem/10451), [2331](https://www.acmicpc.net/problem/2331), [9466](https://www.acmicpc.net/problem/9466), [2667](https://www.acmicpc.net/problem/2667), [4963](https://www.acmicpc.net/problem/4963), [7576](https://www.acmicpc.net/problem/7576), [2178](https://www.acmicpc.net/problem/2178), [2146](https://www.acmicpc.net/problem/2146), [1991](https://www.acmicpc.net/problem/1991), [11725](https://www.acmicpc.net/problem/11725), [1167](https://www.acmicpc.net/problem/1167), [1967](https://www.acmicpc.net/problem/1967)

### binary search (이분탐색/삼분탐색)
[1654](https://www.acmicpc.net/problem/1654), [2805](https://www.acmicpc.net/problem/2805), [2110](https://www.acmicpc.net/problem/2110), [10815](https://www.acmicpc.net/problem/10815), [10816](https://www.acmicpc.net/problem/10816), [11662](https://www.acmicpc.net/problem/11662)

### 분할정복
[11728](https://www.acmicpc.net/problem/11728), [1780](https://www.acmicpc.net/problem/1780), [11729](https://www.acmicpc.net/problem/11729), [1992](https://www.acmicpc.net/problem/1992), [2447](https://www.acmicpc.net/problem/2447), [2448](https://www.acmicpc.net/problem/2448), [1517](https://www.acmicpc.net/problem/1517), [2261](https://www.acmicpc.net/problem/2261)

### 그리디
[11047](https://www.acmicpc.net/problem/11047), [2875](https://www.acmicpc.net/problem/2875), [10610](https://www.acmicpc.net/problem/10610), [1783](https://www.acmicpc.net/problem/1783), [1931](https://www.acmicpc.net/problem/1931), [11399](https://www.acmicpc.net/problem/11399), [2873](https://www.acmicpc.net/problem/2873), [1744](https://www.acmicpc.net/problem/1744)

### 완전탐색
[1476](https://www.acmicpc.net/problem/1476), [1107](https://www.acmicpc.net/problem/1107), [1451](https://www.acmicpc.net/problem/1451), [9095](https://www.acmicpc.net/problem/9095), [10819](https://www.acmicpc.net/problem/10819), [10971](https://www.acmicpc.net/problem/10971), [1697](https://www.acmicpc.net/problem/1697), [1963](https://www.acmicpc.net/problem/1963), [9019](https://www.acmicpc.net/problem/9019), [1525](https://www.acmicpc.net/problem/1525), [2251](https://www.acmicpc.net/problem/2251), [2186](https://www.acmicpc.net/problem/2186), [3108](https://www.acmicpc.net/problem/3108), [5014](https://www.acmicpc.net/problem/5014), [1759](https://www.acmicpc.net/problem/1759), [2580](https://www.acmicpc.net/problem/2580), [1987](https://www.acmicpc.net/problem/1987), [6603](https://www.acmicpc.net/problem/6603), [1182](https://www.acmicpc.net/problem/1182), [2003](https://www.acmicpc.net/problem/2003), [1806](https://www.acmicpc.net/problem/1806), [1644](https://www.acmicpc.net/problem/1644), [1261](https://www.acmicpc.net/problem/1261), [1208](https://www.acmicpc.net/problem/1208), [7453](https://www.acmicpc.net/problem/7453), [2632](https://www.acmicpc.net/problem/2632), [2143](https://www.acmicpc.net/problem/2143)


## 종만북
앞서 등장한 백준 문제들을 모두 풀어보면 종만북을 어렵지 않게 읽을 수 있음
> 종만북은 1권 1권 마지막 수치해석부터 읽는걸 추천. 2권 다 봤으면 1권 처음부터 보면 된다.

* 기하는 웬만하면 skip. 어렵기도하고 출제 빈도도 매우 적음
* 종만북 보면서 [알고스팟 문제들](http://book.algospot.com/problems.html) 다 풀어봐야 함

## 코딩인터뷰 완전 분석
종만북까지 무난하게 공부했는데, 면접에서 자꾸 떨어진다면 인터뷰 준비

## 참고
* [ps 시작하기](https://plzrun.tistory.com/entry/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%AC%B8%EC%A0%9C%ED%92%80%EC%9D%B4PS-%EC%8B%9C%EC%9E%91%ED%95%98%EA%B8%B0)
* [TIL 190320](https://cheolhojung.github.io/posts/til/TIL-190320.html)
